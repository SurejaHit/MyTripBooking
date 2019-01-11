<?php
require "first.php";

$email1 = $_POST["emailL"];//emailL
$pass = $_POST["passL"];//passL

$sql_queryy = "select name from user_info where email like '$email1' and password like '$pass'";

$result = mysqli_query($con1,$sql_queryy);

//$response = array();
if(mysqli_num_rows($result)>0)
{
	$row = mysqli_fetch_assoc($result);
	$name1 = $row["name"];
	//array_push($response,$row);
	//echo "Login Successfull!!!...".$name1." ";
      echo "Data Matched";

}
else{
	echo "Login Failed...Try again";
}

//echo json_encode($response);
mysqli_close($con1);

?>