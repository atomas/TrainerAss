<?php 
	
	$id_clan = $_POST['id_clan'];
	$id_disciplina = $_POST['id_disciplina'];
	$rezultat = $_POST['rezultat']; 
		
	//Creating an sql query
	$sql = "INSERT INTO StavkeTreninga (id_clan, id_disciplina, rezultat) VALUES ('$id_clan','$id_disciplina','$rezultat')";
		
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


