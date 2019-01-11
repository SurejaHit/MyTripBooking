<?php
require "first.php";
$email1 = $_POST["data1"];
$trip = $_POST["data2"];
$no_person =$_POST["data3"];
$p_name = $_POST["data4"];
$aadhar_no = $_POST["data5"];


$sql_query = "insert into trip_info values('$email1','$trip','$no_person','$p_name','$aadhar_no')";

if(mysqli_query($con1,$sql_query))
{
  echo "Data inserted successfully!!!";
  $JSON['success'];
}
else{
  echo "Data insertion failed...".mysqli_error($con1);
}

?>