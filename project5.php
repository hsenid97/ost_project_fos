<?php
session_start();
?>
<?php

$lh="localhost";
$db="employee101";
$un="root";
$pswd="";
$shop=$_SESSION['shop_name'];
$conn=mysqli_connect($lh,$un,$pswd,$db);

$qry="select * from $shop"."_order;";

$q1="";
if(isset($_POST['user']) && isset($_POST['item']) && isset($_POST['cost']))
{
	$usr=$_POST['user'];
	$itm=$_POST['item'];
	$cst=$_POST['cost'];	
	$q1="delete from $shop"."_order where username like '$usr' and  item_name like '$itm' and item_cost like '$cst';";
	
	$result=mysqli_query($conn,$q1);
	$q2="insert into $shop"."_accept  values('$usr','$itm','$cst');";
	
	$result=mysqli_query($conn,$q2);
}
$result=mysqli_query($conn,$qry);

echo "<table border='1'>
<tr>
<th>username</th>
<th>itemname</th>
<th>itemcost</th>
</tr>";

while($row = mysqli_fetch_array($result))
{
echo "<tr>";
echo "<td>" . $row['username'] . "</td>";
echo "<td>" . $row['item_name'] . "</td>";
echo "<td>" . $row['item_cost'] . "</td>";
echo "</tr>";
}
echo "</table>";
?>

<html>
<head>
	<style>
	body{background-color:"powderblue;"};
	</style>
	</head>
<body style="color:brown;">

ACCEPT ORDERS:
	</form>
		<form action="project5.php" method="POST">
		<br/>Username:<input type="text" name="user">
		<br/>item_name<input type="text" name="item">
		<br/>item_cost<input type="text" name="cost">
		<br/><input type="submit" >
	</form>
	</form>
		<form action="project3.php" method="POS">
		<br/><input type="submit" value="back">
	</form>

</body>