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
	$sql = "delete from  canteen_order where (username like '$un') and item_name like '$item_cost' ";
else if($msg=='juices')
	$sql = "delete from  juices_order where username like '$un' and item_name like '$item_cost' ";
else if($msg=='stores')
	$sql = "delete from  stores_order where username like '$un' and item_name like '$item_cost' ";
else if($msg=='fastfood')
	$sql = "delete from  fastfood_order where username like '$un' and item_name like '$item_cost'";


$conn->query($sql) ;
$conn->close();
echo ("$sql"+"success");
?>