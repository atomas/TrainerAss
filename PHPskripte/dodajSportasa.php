<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Getting values
		$name = $_POST['name'];
		$dat = $_POST['dat'];
		$trener = $_POST['idTrener'];
		
		//Creating an sql query
		$sql = "INSERT INTO Sportas (name,datRodjenja, idTrener) VALUES ('$name','$dat','$trener')";
		
		//Importing our db connection script
		require_once('dbConnect.php');
		
		//Executing query to database
		if(mysqli_query($con,$sql)){
			echo 'Sportist Added Successfully';
		}else{
			echo 'Could Not Add Sportist';
		}
		
		//Closing the database 
		mysqli_close($con);
	}

