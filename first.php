<?php

$db_name="androiddatabase";
$mysql_user1="root";
$mysql_pass="";
$server_name="localhost";

$con1 = mysqli_connect($server_name,$mysql_user1,$mysql_pass,$db_name);
if(!$con1)
 {
   //echo "Connection failed!!!".mysqli_connect_error();
 }
else{
	//echo "Connection Successfull!!!";
}
?>
