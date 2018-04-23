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
	$sql = "SELECT * FROM  canteen_order;";
else if($msg=='juices')
	$sql = "SELECT * FROM  juices_order;";
else if($msg=='stores')
	$sql = "SELECT * FROM  stores_order;";
else if($msg=='fastfood')
	$sql = "SELECT * FROM  fastfood_order;";

$stmt = $conn->prepare($sql);
 

$stmt->execute();
 

$stmt->bind_result( $item_name,$item_cost,$msg);
 

while($stmt->fetch()){
 

 $temp = [
 'item_name'=>$item_name,
 'item_cost'=>$item_cost,
 'shop'=>$msg
 ];
 

 array_push($heroes, $temp);
}
 

echo json_encode(array("server_response"=>$heroes));
?>