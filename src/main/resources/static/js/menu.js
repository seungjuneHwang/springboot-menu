$(document).ready(function() {
    $("button").click(function() {
      $.post("/ajaxmenu",
      {
          menu: $("#menu").val(), 
          img_link: $("#img_link").val()
      },
      function(data, status) {
          console.log(data);
          alert(data);
          // 새로 고침
          location.reload();
      });
    });
});