<?php
	$connecting_link;
	function connectingDatabase(){
	$host_address = "localhost";
	$host_user = "root";
	$host_password = "wswz415114";
	$host_database = "fgame";
	global $connecting_link;
	
		$connecting_link = @mysql_connect($host_address, $host_user, $host_password);
		if($connecting_link)
		{
			mysql_query("set names 'utf-8'");
			$select_db = @mysql_select_db($host_database, $connecting_link);
			if(!$select_db)
			{
				@mysql_close($connecting_link);
				$connecting_link = null;
			}
		}
		else
			echo "数据库连接失败！";
		return $connecting_link;
	}
	function closeDatabase(){
		global $connecting_link;
		if($connecting_link)
		{
			mysql_close($connecting_link);
			$connecting_link = null;
		}
	}
?>