
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Page</title>
   <style>

         .username {
      position: relative;
     font-size: 16px;
     height: auto;
     padding: 9px;
     background: #3d3a3a;
     border-color: #054B87;
      @include box-sizing(border-box);
                    }
    body {background-color:powderblue;}
    h1 {color:red;}
    .logint{
              opacity: 60;
              padding-left: 2px;
               height: 100%;
             width: 100%;
             position: absolute;
             top: 200px;
              font-weight: bold;
             color: white;
             font-size: 22px;
          }

          .login{
             top: -14px;
             font-weight: bold;
             border-radius: 4px;
             border: none;
            font-size: 20px;
             position: relative;
             color: black;
            display: inline-block;
            cursor: pointer;
             text-decoration: none;
              outline: none;
            background-color: #3d3a3a;
              box-shadow:  9px #999;
}

.login:hover {background-color: #054B87;}

.login:active {
  background-color: #054B87;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
::-webkit-input-placeholder {
  color: #054B87 ;
}
}

  </style>
</head>
<body>
<body background="food.jpg" >
  <center>
    <div align="center">

<form action="project2.php" class="logint" method="post" id="loginpage">
<p style="font-size: 180%;font-family:comic sans ms bold">Login</p>
UserName: <input type="text" name="uname"><br>
Password: <input type="text" name="paswd"><br><br>
<input type="submit" class="login">
</form></body>
</html>