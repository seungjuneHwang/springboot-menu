$(document).ready(function() {
    

    $("#rndBtn").click(function() {
        $.getJSON("/api/v1/playlist", function(result){
            console.log(result.title);
            console.log(result.artist);
            console.log(result.songLink);
            var videoId=result.songLink.split('v=');
            var html = "제목: " + result.title + " 가수: " +  result.artist;
            html += '<br><embed width="560" height="315" src= "https://www.youtube.com/embed/'+ videoId[1] +' " title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>';
            $("#div1").html(html);
        });
    });  // rndBtn
});
