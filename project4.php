<?php 

   session_start(); // this NEEDS TO BE AT THE TOP of the page before any output etc
  // echo $_SESSION['shop_name'];

?>

<html>
<head>
	<style>
	body
	{
		background-color:white;		
	}
	h3
	{
	color:green;
	}
	</style>
</head>
<body>
	<h3>
<?php

$lh="localhost";
$db="employee101";
$un="root";
$pswd="";
$shop=$_SESSION['shop_name'];
$conn=mysqli_connect($lh,$un,$pswd,$db);

//
$qry="select * from $shop;";



if(isset($_POST['itemnameadd']) && isset($_POST['itemcostadd']))
{
	$ita=$_POST['itemnameadd'];
	$ica=$_POST['itemcostadd'];
	$q1="insert into $shop values('$ita',$ica);";
	$result=mysqli_query($conn,$q1);	
}
if(isset($_POST['itemnamedel']) && isset($_POST['itemcostdel']))
{
	$itd=$_POST['itemnamedel'];
	$icd=$_POST['itemcostdel'];
	$q2="delete from $shop where item_name like '$itd' and item_cost = $icd;";
	$result=mysqli_query($conn,$q2);	
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
echo "<td>" . $row['item_name'] . "</td>";
echo "<td>" . $row['item_cost'] . "</td>";
echo "</tr>";
}
echo "</table>";
?>


</br>
	ADD menu items:
	<form action="project4.php" method="POST">
		<br/>ITEM_NAME<input type="text" name="itemnameadd">
		<br/>ITEM_COSt<input type="text" name="itemcostadd">
		<br/><input type="submit">
	</form>
</br>
	delete menu items:
	<form action="project4.php" method="POST">
		<br/>ITEM_NAME<input type="text" name="itemnamedel">
		<br/>ITEM_COSt<input type="text" name="itemcostdel">
		<br/><input type="submit">
	</form>
		<form action="project3.php" method="POS">
		<br/><input type="submit" value="back">
	</form>
</h3>
</body>