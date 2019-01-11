<?php

$server_name="localhost";
$db_name="androiddatabase";
$mysql_user1="root";
$mysql_pass="";
//$email11=$_POST["email"];
//$email12=$_POST["dell"];

$con1 = mysqli_connect($server_name,$mysql_user1,$mysql_pass,$db_name);
if(!$con1)
 {
   //echo "Connection failed!!!".mysqli_connect_error();
 }
else{

	//echo "Connection Successfull!!!";
//
	
$sql_queryy = "select * from trip_info where email1='123'";
$response = array();
$result = mysqli_query($con1,$sql_queryy);

      if(mysqli_num_rows($result)>0){
	
	while($row = mysqli_fetch_assoc($result)){
	 $response[] = $row;
	//array_push($response,$row);
      //print_r($response); 
     }
 }
    
}

header('Content-Type: application/json');
	echo json_encode(array("students"=>$response));
//echo json_encode($response,JSON_FORCE_OBJECT);
mysqli_close($con1);

?>
