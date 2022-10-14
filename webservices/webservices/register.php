<?php
include 'connection.php';

        $first_name= null;

        $last_name= null;
        $email = null; 
        $password = null; 




if($_SERVER['REQUEST_METHOD']=='POST'){

	$first_name = $_POST['first_name'];
	$last_name= $_POST['last_name'];

    $email= $_POST['email'];
    $password= $_POST['password'];

	

}

if($_SERVER['REQUEST_METHOD']=='GET'){


   $first_name = $_GET['first_name'];
    $last_name= $_GET['last_name'];

    $email= $_GET['email'];
    $password= $_GET['password'];
       
}



$sql= "INSERT INTO `dr_users`( `first_name`, `last_name`, `email`, `password`) VALUES (
		'$first_name', 
        '$last_name', 
        '$email', 
        '$password'
        
)";


      $result=mysqli_query($conn,$sql);

if($result)
    {
    
    $response = array("response"=>"success");
    	echo json_encode($response);
    }
else
    {
    	$response = array("response"=>"failure");
    	echo json_encode($response);
    }

?>
