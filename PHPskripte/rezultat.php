<?php

$id = $_POST['id'];

//Importing Database Script 
require_once('dbConnect.php');
	
//Creating sql query
$sql = "SELECT * FROM Clan AS c 
	INNER JOIN StavkeTreninga AS s ON c.id = s.id_clan 
	WHERE s.id_disciplina = '$id' ORDER BY rezultat";
	
$r = mysqli_query($con,$sql);
	
$result = array();
	
//looping through all the records fetched
while($row = mysqli_fetch_array($r, MYSQL_ASSOC)){
	array_push($result,array(
		"id"=>$row['id'],
		"ime"=>$row['ime'],
		"prezime"=>$row['prezime'],
		"rezultat"=>$row['rezultat']
	));
}

echo json_encode($result);
	
mysqli_close($con);
