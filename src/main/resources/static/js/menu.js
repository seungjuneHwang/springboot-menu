$(document).ready(function() {
    $("#saveBtn").click(function() {
        let menu = $("#menu").val();
        let imgLink = $("#img_link").val();
        if (menu.trim() == "") {
            alert("메뉴를 입력하세요");
            return;
        }
        if (imgLink.trim() == "") {
            alert("이미지 링크를 입력하세요");
            return;
        }
        // 버튼 눌렀을때 restapi 로 데이터 전송(json)
        var data = {
            menu: menu, 
            imgLink: imgLink
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
    });  // saveBtn

    $("#updateBtn").click(function() {
        let menu = $("#m_menu").val();
        let imgLink = $("#m_imglink").val();
        if (menu.trim() == "") {
            alert("메뉴를 입력하세요");
            return;
        }
        if (imgLink.trim() == "") {
            alert("이미지 링크를 입력하세요");
            return;
        }
        // 버튼 눌렀을때 restapi 로 데이터 전송(json)
        var data = {
            menu: menu, 
            imgLink: imgLink
        };

        // 업데이트를 하기위한 키값
        let id = $("#m_id").val();
        // alert(id + " " + menu + " " + imgLink + " 수정이 됩니다.");
 
        $.ajax({
            type : 'PUT',
            url : '/api/v1/menu/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('메뉴가 수정되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    });  // updateBtn
});

function modal_show(id, menu, imgLink) {
    console.log(id);
    console.log(menu);
    console.log(imgLink);
    // 클릭한 위치의 테이블의 데이터를 모달에 값을 셋팅
    $("#m_id").val(id);
    $("#m_menu").val(menu);
    $("#m_imglink").val(imgLink);

    $("#myModal").modal();
}