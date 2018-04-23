<?php

$db = "employee101";
$us = "root";
$ps = "";
$lh = "localhost";
$conn = mysqli_connect($lh, $us, $ps,$db);


//$qry="select * from user_account where usr_name like '$name' and usr_pswd like '$pswd';";
$qry="select * from canteen_order";
echo $qry;
$result=mysqli_query($conn,$qry);
if(mysqli_num_rows($result)>0)
{
echo "success";
}
else
{
echo "failed";
}

$qry="select * from canteen_order";
$result=mysqli_query($conn,$qry);
if(mysqli_num_rows($result)>0)
{
	echo "suceess";
}
else
{
	echo"fauled";
}


?>