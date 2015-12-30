<?php

$name = $_GET['name'];
$username = $_GET['username'];
$password = $_GET['password'];
$email = $_GET['email'];
 

if($name == '' || $username == '' || $password == '' || $email == ''){
echo 'please fill all values';
 }else{ require_once('dbConnect.php');

 $sql = "SELECT * FROM Trener WHERE korIme='$username' OR email='$email'";
 
 $check = mysqli_fetch_array(mysqli_query($con,$sql));
 
 if(isset($check)){
 echo 'username or email already exist';
 }else{ 
 $sql = "INSERT INTO Trener (imePrez,korIme,lozinka,email) VALUES('$name','$username','$password','$email')";
 if(mysqli_query($con,$sql)){
 echo 'successfully registered';
 }else{
 echo 'oops! Please try again!';
 }
 }
 mysqli_close($con);
 }