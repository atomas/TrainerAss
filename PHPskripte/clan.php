<?php

//Importing Database Script 
require_once('dbConnect.php');
	
//Creating sql query
$sql = "SELECT * FROM Clan";
	
$r = mysqli_query($con,$sql);

$result = array();
	
//looping through all the records fetched
while($row = mysqli_fetch_array($r, MYSQL_ASSOC)){
	array_push($result,array(
		"id"=>$row['id'],
		"ime"=>$row['ime'],
		"prezime"=>$row['prezime']
		));
}

//echo json_encode($result);
echo json_encode($result); 

	
mysqli_close($con);
