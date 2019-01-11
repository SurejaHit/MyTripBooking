<?php
require "first.php";

$email = $_POST["data1"];




 $sql_query = "DELETE FROM trip_info  WHERE email1 = '$email'";

 if(mysqli_query($con1,$sql_query))
 {
  echo "Data deleted successfully!!!";
 }
 else{
  echo "Data deletion failed...".mysqli_error($con1);
 }


?>