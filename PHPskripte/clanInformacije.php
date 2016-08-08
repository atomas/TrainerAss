<?php

//get the user id
$id = $_POST['id'];

//Importing Database Script 
require_once('dbConnect.php');
	
//Creating sql query
$sql = "SELECT ime, prezime, datum, visina, tezina FROM Clan WHERE id = '$id'";
	
$r = mysqli_query($con,$sql);
	
$result = array();
	
//looping through all the records fetched
while($row = mysqli_fetch_array($r, MYSQL_ASSOC)){
	array_push($result,array(
		"id"=>$row['id'],
		"ime"=>$row['ime'],
		"prezime"=>$row['prezime']
		"datum"=>$row['datum']
		"visina"=>$row['visina']
		"tezina"=>$row['tezina']
	));
}

echo json_encode($result);
	
mysqli_close($con);