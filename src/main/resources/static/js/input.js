$(document).ready(function(){
    $("#inputbtn").click(function(){
      $.ajax({
        url : "/api/v1/news",
        type : "get",
        dataType : 'json',
        contentType : 'application/json; charset=utf-8',
        data : {
          data: $("#data").val()
        },
        success : function(result){
          console.log(JSON.stringify(result));
            // alert("통신 성공");
            // $("#getresult").text("결과 : " + JSON.stringify(result));
            // var tblresult = result;
            // var str = "";
            // $.each(tblresult, function(i){
            // });
            // $("#userList").append(str);
        },
        error : function(xhr, status, error){
            alert("통신 에러");
        }
    });
      // $.post("/api/v1/news",
      // {
      //     data: $("#data").val()
      // },
      // function(data,status){
      //   //alert("Data: " + data + "\nStatus: " + status);
      //       $("#div1").html(data);
      // });
    });
  });