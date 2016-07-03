<?php

$ime = $_POST['ime'];
$prezime = $_POST ['prezime'];
$username = $_POST ['username'];
$email = $_POST ['email'];
$password = $_POST ['password'];

require_once('dbConnect.php');

$sql = "SELECT * FROM Trener WHERE korIme='$username' OR email='$email'";
 
$check = mysqli_fetch_array(mysqli_query($con,$sql));
 
if(isset($check)){
	echo 3;
}else{ 
	$sql = "INSERT INTO Trener (ime, prezime,korIme, lozinka, email) VALUES('$ime', '$prezime','$username', '$password', '$email')";
 	if(mysqli_query($con,$sql)){
 		echo 1;
 	}else{
 		echo 'nesto je poslo po zlu';
 	}
}
mysqli_close($con);
