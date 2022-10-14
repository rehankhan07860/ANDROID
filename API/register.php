<?php
require 'connection.php';

$username = $_POST['username'];
$email = $_POST['email'];
$password = $_POST['password'];


$checkUser = "SELECT * FROM user where email = '$email'";
$checkQuery = mysqli_query($con, $checkUser);

if(mysqli_num_rows($checkQuery)>0){
    $response['error']="002";
    $response['message']= "User exits";
}else {

    $insertQuery = "INSERT INTO user(username, email, password) values('$username', '$email', '$password')";
    $result = mysqli_query($con, $insertQuery);
    
    if($result){
      $response['error']="000";
      $response['message']= "Register Success";
    }else{
        $response['error']="001";
        $response['message']= "Register Failed";
    }
    
}

echo json_encode($response);
?>