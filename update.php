<?php
require "first.php";

$person = $_POST["data3"];
$names = $_POST["data4"];
$aadhar = $_POST["data5"];



 $sql_query = "UPDATE  trip_info set no_person = '$person',p_name = '$names',aadhar_no = '$aadhar' WHERE email1 = '123'";

 if(mysqli_query($con1,$sql_query))
 {
  echo "Data updated successfully!!!";
 }
 else{
  echo "Data updation failed...".mysqli_error($con1);
 }


?>