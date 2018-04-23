<?php
 session_start();
 $sh=$_SESSION['shop'];
 //echo $sh;

$db_name = "shop_keeper";
$mysql_username = "root";
$mysql_password = "";
$server_name = "localhost";
$conn = mysqli_connect($server_name, $mysql_username, $mysql_password,$db_name);


$qry="select * from $sh;";




if(isset($_POST['it']) && isset($_POST['ic']))
{
	$item=$_POST['it'];
	$cost=$_POST['ic'];
	$q1="insert into $sh  values('$item','$cost');";
	$result=mysqli_query($conn,$q1);
}

$result=mysqli_query($conn,$qry);
echo "<table border='1'>
<tr>
<th>itemname</th>
<th>itemcost</th>
</tr>";

while($row = mysqli_fetch_array($result))
{
echo "<tr>";
echo "<td>" . $row['itemname'] . "</td>";
echo "<td>" . $row['itemcost'] . "</td>";
echo "</tr>";
}
echo "</table>";
?>
<!DOCTYPE html>
<html>
<head>
	<style>
		body {background-color:powderblue;}
		h1 {color:red;}
	</style>
</head>
<body>
		<form action="display.php" method="POST">
			<br/>ITEMNAME<input type="text" name="it">
			<br/>ITEMCOST<input type="text" name="ic">
			<br/><input type="submit">
		</form>
		<form action="login_page1.html" method="POST" >
			<input type="submit" value="back">
		</form>
</body>
</html>

