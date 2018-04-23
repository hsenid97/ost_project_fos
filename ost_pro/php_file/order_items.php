<?php 

$servername = "localhost";
$username = "root";
$password = "";
$database = "employee101";
 
 

$conn = new mysqli($servername, $username, $password, $database);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
    echo("failed");
}


$un=$_POST["user_name"];
$item_name=$_POST["item_name"];
$item_cost=$_POST["item_cost"]; 
$msg=$_POST["shop"];

 
if($msg=="canteen")
	$sql = "insert into canteen_order values('$un','$item_name','$item_cost');";
else if($msg=='juices')
	$sql = "insert into juices_order values('$un','$item_name','$item_cost');";
else if($msg=='stores')
	$sql = "insert into stores_order values('$un','$item_name','$item_cost');";
else if($msg=='fastfood')
	$sql = "insert into fastfood_order values('$un','$item_name','$item_cost');";


$conn->query($sql) ;
$conn->close();
echo ("success");
?>