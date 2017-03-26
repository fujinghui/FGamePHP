<?php
	session_start();
	include("phptools/tools.php");
	$name = $_POST['name']; 
	$pwd = $_POST['pwd'];
	$state = TestLogin($name, $pwd);
	if($state)			//登录成功
	{
		$_SESSION['login_state'] = 1;
		
	}
	echo $state;
	header("location:index.php");
?>