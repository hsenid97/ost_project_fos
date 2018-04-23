<?php
 session_start();

$db_name = "shop_keeper";
$mysql_username = "root";
$mysql_password = "";
$server_name = "localhost";
$conn = mysqli_connect($server_name, $mysql_username, $mysql_password,$db_name);

$un=$_POST['usr'];
$pd=$_POST['psw'];
echo $un;
echo $pd;
$_SESSION['shop']=$un;
echo $_SESSION['shop'];

$qry="select * from shops where username like '$un' and password like '$pd';";

$result=mysqli_query($conn,$qry);
if(mysqli_num_rows($result)>0)
{
	header("Location:display.php");
}
else
{
	header("Location:login_page1.html");
}
?>