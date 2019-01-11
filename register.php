<?php
require "first.php";
$name = $_POST["name11"];
$email = $_POST["email11"];
$password = $_POST["pass11"];



 $CheckSQL = "SELECT * FROM user_info WHERE email= '$email'";
 
 $check = mysqli_fetch_array(mysqli_query($con1,$CheckSQL));
 
 if(isset($check)){

 echo "Email Already Exist!!";

 }

 else{

   $sql_query = "insert into user_info values('$name','$email','$password')";

 if(mysqli_query($con1,$sql_query))
 {
  echo "Data inserted successfully!!!";
 }
 else{
  echo "Data insertion failed...".mysqli_error($con1);
 }

}
?>