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
//          console.log(JSON.stringify(result));
          console.log(result.items);
            // alert("통신 성공");
            // $("#getresult").text("결과 : " + JSON.stringify(result));
            // var tblresult = result;
            var html = "";
            $.each(result.items, function(i, field){
                console.log(field.title);
                html += "<tr>";
                html += "<td>" + (i+1) + "</td>";
                html += "<td><a href='" + field.link + "' target='_blank' >"
                html += field.title + "</a></td>";
                html += "<td>" + field.pubDate + "</td>";
                html += "</tr>";
            });
            $("#newslist").empty();  // 비우고 다시 출력 하기 위해
            $("#newslist").append(html);
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