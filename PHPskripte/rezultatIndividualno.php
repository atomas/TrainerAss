<?php

//get the user id
$id = $_POST['id'];

//Importing Database Script 
require_once('dbConnect.php');
	
//Creating sql query
$sql = "SELECT d.naziv, s.rezultat FROM Disciplina AS d INNER JOIN StavkeTreninga AS s ON d.id = s.id_disciplina WHERE s.id_clan = 11 ORDER BY d.id, s.rezultat";
	
$r = mysqli_query($con,$sql);
	
$result = array();
	
//looping through all the records fetched
while($row = mysqli_fetch_array($r, MYSQL_ASSOC)){
	array_push($result,array(
		"naziv"=>$row['naziv'],
		"rezultat"=>$row['rezultat']
	));
}

echo json_encode($result);
	
mysqli_close($con);
