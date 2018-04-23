<?php 

$servername = "localhost";
$username = "root";
$password = "";
$database = "employee101";
 
 

$conn = new mysqli($servername, $username, $password, $database);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$msg = $_POST["message"];
 
$heroes = array(); 
 
if($msg=="canteen")
	$sql = "SELECT * FROM  canteen;";
else if($msg=='juices')
	$sql = "SELECT * FROM  juices;";
else if($msg=='stores')
	$sql = "SELECT * FROM  stores;";
else if($msg=='fastfood')
	$sql = "SELECT * FROM  fastfood;";


// echo ($sql);

$stmt = $conn->prepare($sql);
 

$stmt->execute();
 

$stmt->bind_result( $item_name,$item_cost);
 

while($stmt->fetch()){
 

 $temp = [
 'item_name'=>$item_name,
 'item_cost'=>$item_cost
 ];
 

 array_push($heroes, $temp);
}
 

echo json_encode(array("server_response"=>$heroes));
?>