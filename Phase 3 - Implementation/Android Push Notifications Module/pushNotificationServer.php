<?php

if (!empty($_REQUEST['deleteFile'])) 
{
    unlink($_REQUEST['filename']);
}
else
{

	$myfile = fopen($_REQUEST['filename'], "a") or die("Unable to open file!");
	$txt = "Error";

	if (!empty($_REQUEST['notification'])) 
	{
		$txt = $_REQUEST["notification"];
	}

	fwrite($myfile, $txt);
}
?>