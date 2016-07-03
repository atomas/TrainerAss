<?php 
	$username = $_POST['email'];
	$password = $_POST['password'];
		
	//Creating sql query
	$sql = "SELECT * FROM Trener where korIme='$username' or email = '$username' and lozinka ='$password' ";
		
	//importing dbConnect.php script 
	require_once('dbConnect.php');
	
	//executing query
	$result = mysqli_query($con,$sql);
		
	//fetching result
	$check = mysqli_fetch_array($result);
		
	//$results = array();

	//if we got some result 
	if(isset($check)){
		//displaying success 
		// echo "success";
		echo 1;
		//ovo si ti dodao
		//looping through all the records fetched
		/* while($row = mysqli_fetch_array($result)){
	 	array_push($results,array(
			"id"=>$row['id']//, "korIme"=>$row['korIme']
			));
		}
		echo json_encode(array('result'=>$results)); */

	}else{
		//displaying failure
		echo "failure";
	}
	mysqli_close($con);
	
