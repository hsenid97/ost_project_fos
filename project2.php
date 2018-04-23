<?php

 session_start();
 

?><?php
$db_name = "employee101";
$mysql_username = "root";
$mysql_password = "";
$server_name = "localhost";
$conn = mysqli_connect($server_name, $mysql_username, $mysql_password,$db_name);


$name=$_POST["uname"];


$pswd=$_POST["paswd"];

$_SESSION['shop_name'] = $name;
$qry="select * from user_account where usr_name like '$name' and usr_pswd like '$pswd';";
echo $qry;
$result = mysqli_query($conn ,$qry);
if(mysqli_num_rows($result) > 0) {
echo "success";
header("Location:project3.php");
}
else {
echo "failed";
header("Location:project1.php");
}

?>