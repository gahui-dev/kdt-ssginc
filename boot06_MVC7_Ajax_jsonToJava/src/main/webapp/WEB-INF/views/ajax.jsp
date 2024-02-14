<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
       .important{
          font-size: xx-large;
          font-weight: bold;
       }
       .blue{
         color:blue;
       }

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        /*
            ajax 사용

          */

        $(document).ready(function(){
          $("#main").on("click", function(){
              // ajax 
              $.ajax({
                type:'post',
                url:"main",
                dataType:"text", // json, xml,
                headers:{
                   "Content-Type":"application/json"	 
                },
                data:JSON.stringify({userid:"홍길동",passwd:"1234"}),
                success:function(data, status, xhr){

                },
                error:function(xhr,status,error){
                  console.log("Error:", error);
                }
              });
          });//end id="main"

          $("#main2").on("click", function(){
              // ajax 
              $.ajax({
                type:'post',
                url:"main2",
                dataType:"text", // json, xml
                headers:{
                    "Content-Type":"application/json"	 
                 },
                 data:JSON.stringify([{userid:"홍길동1",passwd:"1234"},{userid:"홍길동2",passwd:"1234"} ]),
                success:function(data, status, xhr){
                   
                },
                error:function(xhr,status,error){
                  console.log("Error:", error);
                }
              });
          });//end id="main2"
          
          
          
        });//end reay()
    </script>
</head>
<body>
  <button id="main">main</button>
  <button id="main2">main2</button>
  <div id="result"></div>
</body>
</html>