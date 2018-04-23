<!DOCTYPE html>
<html lang="en">
<style type="text/css">
*{
  margin: 0;
  padding: 0;
 }


body{
  font-family: calibri, sans-serif;
  }


.background-wrap{
position :fixed;
z-index: -1000;
width: 100%;
height: 100%;
overflow: hidden;
top= 0;
left =0;
}

#video-bg-elem{
position: absolute;
top: 0;
left: 0;
min-height: 100%;
min-width: 100%;
}


.content{
position: absolute;
width: 100%;
min-height: 100%
z-index: 1000;
background-color: rgba(0,0,0,0.7);
}


.btn a{
position: absolute;
top: 25%;
left: 20%;
} 
.btn b{
position: absolute;
top: 25%;
left: 40%;
} 


.btn c{
position: absolute;
top: 25%;
left: 60%;
} 

.btn a{
  border-radius: 4px;
  
  border: groove;
  border-color: white;
  color: white;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.btn as span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.btn a span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.btn a:hover span {
  padding-right: 25px;
}

.btn a:hover span:after {
  opacity: 1;
  right: 0;
}
.btn b{
  border-radius: 4px;
  background-color: #000706;
  border: groove;
  border-color: lime;
  color: lime;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.btn span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.btn b span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.btn b:hover span {
  padding-right: 25px;
}

.btn b:hover span:after {
  opacity: 1;
  right: 0;
}
.btn c{
  border-radius: 4px;
  background-color: #000706;
  border: groove;
  border-color: #d2891e;
  color: #d2891e;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.btn c span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.btn c span:after {
  content: '\00bb';
  
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.btn c:hover span {

  padding-right: 25px;
}

.btn c:hover span:after {
  opacity: 1;
  right: 0;
}

</style> 



<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body background= "food.jpg">
 
<div class="btn">
  <a style="margin-top:  0px; margin-left: 450px;"" href="project4.php"><span>add menu </span></a>
   
  <a style="margin-top:  100px; margin-left: 450px" href="project5.php"><span>view orders </span></a>
<a style="margin-top: 200px; margin-left: 450px" href="project6.php"><span>accept orders </span></a>
  
</div>





</body>
</html>