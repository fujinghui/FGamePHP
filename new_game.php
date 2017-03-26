<?php
	session_start();
	include("phptools/connection.php");
	if(isset($_SESSION['login_state']))
	{
		if(connectingDatabase())
		{
			$id = $_SESSION['id'];
			$current_scene = "home_scene_map()";
			$game_progress = 0;
			$x = 0;$y = 600;	
			$score1 = 0; $score2 = 0; $score3 = 0;
			
			$sql = "update user set game_progress=$game_progress,current_scene='$current_scene',x=$x,y=$y,score1=$score1,score2=$score2,score3=$score3 where id=$id";
			$result = mysql_query($sql);
			if($result)
			{
				echo "ok";
			}
			else
			{
				echo "faild";
			}
			closeDatabase();
		}
	}
?>