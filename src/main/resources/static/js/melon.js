$(document).ready(function() {
    $.getJSON("/api/v1/melon", function(result) {
        var html = "";
        $.each(result, function(i, field){
            // console.log(field.rank);
            // console.log(field.title);
            // console.log(field.artist);
            html += "<tr>";
            html += "<td>" + field.rank + "</td>";
            html += "<td>" + field.title + "</td>";
            html += "<td>" + field.artist + "</td>";
            html += "</tr>";
        });
        $("#musiclist").append(html);
      });
});
