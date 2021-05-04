<?php
include "../mySQLConnection/conn.php";
$responce = array();

$sql = "SELECT * FROM `working_driver_info` WHERE `rout` LIKE 'Karkala to Nakre' ";
$result = mysqli_query($con,$sql);

$num=mysqli_num_rows($result);
if($num> 0){
	$responce['success'] = 1;
	$location = array();

	while($row=mysqli_fetch_assoc($result)){
		array_push($location,$row);
	}
	$responce['location'] = $location;
	
}
else{
	$responce['success'] = 0;
	$responce['message'] = "no Data";
}
echo json_encode($responce);
mysqli_close($con);
?>