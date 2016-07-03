<?php

//Importing Database Script 
require_once('dbConnect.php');
	
//Creating sql query
$sql = "SELECT * FROM Disciplina";
	
$r = mysqli_query($con,$sql);
	
$result = array();
	
//looping through all the records fetched
while($row = mysqli_fetch_array($r, MYSQL_ASSOC)){
		
	array_push($result,array(
		"id"=>$row['id'],
		"naziv"=>$row['naziv'],
		"opis"=>$row['opis']
		));
	}

echo json_encode($result);
	
mysqli_close($con);
