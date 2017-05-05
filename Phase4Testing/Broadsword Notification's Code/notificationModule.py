"""Handles incoming request and dispatches notifications"""

from email.MIMEMultipart import MIMEMultipart
from email.MIMEText import MIMEText
from apiclient import errors
import nsq
import json
import smtplib

global sendemail
global logNotification

messageLog = []

#This class will handles any incoming request from
#the browser 
class NotificationRequest():

        def sendEmail(self, request):
	    """
            Send email as specified in request and return boolean/error indicating success

            Keyword arguments:
            request -- JSON object with message, notification type and recepient's email address
            """
	
	    print(request.body)
            reqObj = json.loads(request.body)
            emailTo = reqObj['content']['email']

            subject = "NavUP Notification"
            
            fromaddr = "bswordnotification@gmail.com"
            toaddr = emailTo
            msg = MIMEMultipart()
            msg['From'] = fromaddr
            msg['To'] = toaddr
            msg['Subject'] = subject

            body = reqObj['content']['message']
            msg.attach(MIMEText(body, 'plain'))
            try:
                server = smtplib.SMTP('smtp.gmail.com', 587)
                server.ehlo()
                server.starttls()
                server.login(fromaddr, 'notification301')
                text = msg.as_string()
                server.sendmail(fromaddr, toaddr, text)
                writer.pub(reqObj['src'], '{"src"  : "Notification", "dest" : '"'+reqObj['src']+'"', "msgType" : "response", "queryType" : "", "content" : { "success" : "true", "error" : ""}}')
            except errors.HttpError as err:
                writer.pub(reqObj['src'], '{"src"  : "Notification", "dest" : '"'+reqObj['src']+'"', "msgType" : "response", "queryType" : "", "content" : { "success" : "false", "error" : "Error: '+err+'"}}')
            return True
        
        def logNotification(self, notificationRequest):
	    """
            append notification request received to array
            
            Keyword arguments:
            request -- JSON object with message, notification type and recepient's email address
            """
	
            messageLog.append(notificationRequest)
            print(messageLog[0].userId)
            return
        
writer = nsq.Writer('127.0.0.1:4150')
nr = NotificationRequest()
requestServer = nsq.Reader(message_handler=nr.sendEmail, lookupd_http_addresses=['http://127.0.0.1:4161'], topic='notification', channel='navup', lookupd_poll_interval=5)
nsq.run()
