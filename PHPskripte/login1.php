<?php 
	
	//if($_SERVER['REQUEST_METHOD']=='POST'){
		//Getting values 
		$username = $_POST['username'];
		$password = $_POST['password'];
		
		//Creating sql query
		$sql = "SELECT * FROM Trener where lozinka ='$password' and korIme='$username' or email = '$username' ";
		
		//importing dbConnect.php script 
		require_once('dbConnect.php');
		
		//executing query
		$result = mysqli_query($con,$sql);
		
		//fetching result
		$check = mysqli_fetch_array($result);
		
		//if we got some result 
		if(isset($check)){
			//displaying success
			echo 1;
		}else{
			//displaying failure
			echo "nesto je poslo po zlu";
		}
		mysqli_close($con);
	//}
