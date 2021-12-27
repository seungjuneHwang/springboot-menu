$(document).ready(function() {
    $("button").click(function() {
        // 버튼 눌렀을때 restapi 로 데이터 전송(json)
        var data = {
            menu: $("#menu").val(), 
            imgLink: $("#img_link").val()
        };
 
        $.ajax({
            type : 'POST',
            url : '/api/v1/menusave',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('메뉴가 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    });
});

// $.post("/api/v1/menusave",
// {
//     menu: $("#menu").val(), 
//     img_link: $("#img_link").val()
// },
// function(data, status) {
//     console.log(data);
//     alert(data);
//     // 새로 고침
//     location.reload();
// });