<?php

//Importing Database Script 
require_once('dbConnect.php');
	
//Creating sql query
$sql = "SELECT * FROM Sportas";
	
$r = mysqli_query($con,$sql);
	
$result = array();
	
//looping through all the records fetched
while($row = mysqli_fetch_array($r)){
		
	array_push($result,array(
		"id"=>$row['id'],
		"name"=>$row['name']
		));
	}

echo json_encode(array('result'=>$result));
	
mysqli_close($con);