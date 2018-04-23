<?php

//session_start();


$lh="localhost";
$us="root";
$ps="";
$db="employee101";

$conn=mysqli_connect($lh,$us,$ps,$db);
$qry="select * from canteen_order";
$result=mysqli_query($conn,$qry);
if(mysqli_num_rows($result)>0)
{
	echo "suceess";
}
else
{
	echo"fauled;
}

?>