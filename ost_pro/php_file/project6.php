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

$qry="select * from $shop"."_accept;";


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
