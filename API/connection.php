<?php
$hostName = 'localhost';
$useName = 'root';
$userPass = '';
$dbName = 'userdata';

$con = mysqli_connect($hostName, $useName, $userPass, $dbName);

if(!con){
    echo "connection Failed";
}else{
    echo "connection Success";
}
?>