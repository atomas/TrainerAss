<?php 
	
	$ime = $_POST['ime'];
	$prezime = $_POST['prezime'];
	$datum = $_POST['datum'];
	$visina = $_POST['visina'];
	$tezina = $_POST['tezina'];
		
	//Creating an sql query
	$sql = "INSERT INTO Clan (ime, prezime, datum, visina, tezina) VALUES ('$ime','$prezime','$datum', '$visina', '$tezina')";
		
	//Importing our db connection script
	require_once('dbConnect.php');
		
	//Executing query to database
	if(mysqli_query($con,$sql)){
		echo 1;
	}else{
		echo 'nesto je poslo po zlu';
	}
		
	//Closing the database 
	mysqli_close($con);

