$(document).ready(function(){
    $("#inputbtn").click(function(){
      $.post("/api/v1/senddata",
      {
          data: $("#data").val()
      },
      function(data,status){
        //alert("Data: " + data + "\nStatus: " + status);
            $("#div1").html(data);
      });
    });
  });