<?php
include "../mySQLConnection/conn.php";
$user_name = $_POST['username'];
$email = $_POST['email'];
$pass = $_POST['password'];
$mobile = $_POST['mobile'];
$gender = $_POST['gender'];  

/* $user_name = "prathik123";
$email = "pratshik@gmail.com";
$pass = "1234567";
$mobile = "9901348774";
$gender = "Male"; */

$isValidEmail = filter_var($email,FILTER_VALIDATE_EMAIL);
if($con){
	if(strlen($pass)>40 || strlen($pass)< 6 ){
		echo "Password Must be less than 40 and more than 6 charecters";
		
	}else if ($isValidEmail == false){
		echo "This email is not valid";
	}
	else {
		$sqlToCheckUserName = "select * from `user_table`  where `user_Name` LIKE '$user_name'";
		$userNameQuery = mysqli_query($con,$sqlToCheckUserName);
		
		$sqlToCheckEmail = "select * from `user_table`  where `email-id` LIKE '$email'";
		$userEmailQuery = mysqli_query($con,$sqlToCheckEmail);
		
		if(mysqli_num_rows($userNameQuery)>0){
			echo "UserName is alrady used choose another username";
		}else if(mysqli_num_rows($userEmailQuery)>0){
			echo "This E-mail ID is alrady Registered Select Other E-mail ID";
		}
		else{
			$sql_rigister = "INSERT INTO `user_table` (`id`, `user_Name`, `email-id`, `password`, `mobile`, `gender`) VALUES (NULL, '$user_name', '$email', '$pass', '$mobile', '$gender')";
			if(mysqli_query($con,$sql_rigister)){
				echo "Successfully Registered";
			}else{
				echo "Failed to Rigister";
			}
			
		}
		
	}
}else{
	echo "Connection Error";
}


mysqli_close($con);
?>