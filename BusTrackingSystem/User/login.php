<?php
include "../mySQLConnection/conn.php";

$email = $_POST['email'];
$pass = $_POST['password']; 

/* $email = "prathik@gmail.com";
$pass = "123456";  */

$isValidEmail = filter_var($email,FILTER_VALIDATE_EMAIL);

if($con){
	if ($isValidEmail == false){
		echo "This email is not valid";
	}else{
		$sqlToCheckEmail = "select * from `user_table`  where `email-id` LIKE '$email'";
		$userEmailQuery = mysqli_query($con,$sqlToCheckEmail);
	
	if(mysqli_num_rows($userEmailQuery)>0){
		$sqlToLogin = "select * from `user_table`  where `email-id` LIKE '$email' and `password` LIKE '$pass'";
		$result = mysqli_query($con,$sqlToLogin);
		
		if(mysqli_num_rows($result)>0){
			echo "Login Success";
		}else{
			echo "Wrong Password";
		}
			
		}else{
			echo "The Email-id is not Registerd";
			
		}
	}
	
}else{
	echo "Connection Error";
}

mysqli_close($con);

?>