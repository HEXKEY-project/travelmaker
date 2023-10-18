
/*회원 상세페이지 팝업창 */
function popup(event,memberCode){

    if (event.target.tagName !== 'INPUT') {
        const url = "/admin/adminMemberDetail?memberCode=" + memberCode;
        const name = "adminMemberDetail";
        const option = "width = 1000, height = 800, top = 100, left = 200, location = no"
        window.open(url, name, option);
    }
}

/*회원 비밀번호변경 팝업창 */
function pwUpdatepopup(memberCode){
    const url = "/admin/adminPwUpdate?memberCode="+memberCode;
    const name = "adminPwUpdate";
    const option = "width = 500, height = 500, top = 100, left = 100, location = no"
     window.open(url, name, option);
}

/*회원 적립금 팝업창 */

function memberPoints(memberCode){

    const url = "/admin/adminPointDetail?memberCode="+memberCode;
    const name = "adminPointDetail";
    const option = "width = 500, height = 500, top = 100, left = 100, location = no"
     window.open(url, name, option);

}



function closeTabClick() {
    // 변수를 close해 새창을 닫음
    window.close();
}

window.onload = function() {
    /* 회원 비밀번호수정버튼 클릭시 */
    $("#pwUpdate").click(function(){

        let memberPw1 = document.getElementById("memberPw1").value.trim();
        let memberPw2 = document.getElementById("memberPw2").value.trim();
        let memberCode = document.getElementById("memberCode").value;
        console.log(memberCode);

        if (memberPw1 != memberPw2) {
            alert("새 비밀번호가 일치하지 않습니다.");
            $("#memberPw2").focus();
            return false;
        }
            //요청주소 설정
            fetch("/admin/adminPwUpdate", {
                //POST형식으로
                method: "POST",
                //지금의 데이터를 json형태로 바꾼후
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                //memberPwd 값을 보낸다
                body: JSON.stringify({
                                            memberCode: memberCode,
                                            memberPwd: memberPw1
                })

            }).then(result => result.text())
                .then(result => alert(result))


    });


    /* 회원정보 수정버튼클릭시 */
    $('#modifyButton').click(function () {
        const memberCode = $('#memberCode').val();
        const memberGradeCode = $('#memberGradeList').val();
        const memberTell = $('#memberTell').val();
        const memberPhone = $('#memberPhone').val();
        const smsStatus = $('#smsStatus').prop("checked") ? 'Y' : 'N';
        const emailStatus = $('#emailStatus').prop("checked") ? 'Y' : 'N';

        console.log("memCode:", memberCode);
        console.log("memberTell:", memberTell);
        console.log("memberTell:", memberTell);
        console.log("memberPhone:", memberPhone);
        console.log("memberGradeCode:", memberGradeCode);
        console.log("smsStatus:", smsStatus);
        console.log("emailStatus:", emailStatus);

      const obj= {
            memberCode:memberCode,
            gradeCode:{gradeCode: memberGradeCode},
            tell:memberTell,
            phone:memberPhone,
            smsYn:smsStatus,
            emailYn:emailStatus
        };

        console.log(obj);

        //const obj = JSON.parse(json);
        fetch("/admin/adminMemberUpdate", {
            //POST형식으로
            method: "POST",
            //지금의 데이터를 json형태로 바꾼후
            headers: {
                'Content-Type': 'application/json;charset=UTF-8'
            },
            //memberPwd 값을 보낸다
            body: JSON.stringify(obj)
        })
            .then(result => result.text())
            .then(result => {
                alert(result);
                // 메인 창 리로드 및 팝업 창 닫기
                if (window.opener) {
                    window.opener.location.reload();
                }
                window.close();
            })
    });
    /* 적립금 적립/차감 이벤트*/
    if(document.getElementById('OK')){
        const $OK = document.getElementById('OK');
        $OK.onclick = function (){
            //alert("테스트")

            const memberCode = $('#memberCode').val();
            //"flexRadioDefault"라는 이름을 가진 라디오 버튼 중 선택된 것의 값을 selectedValue 변수에 할당합니다.
            // 사용자가 "지급"을 선택하면 
            // selectedValue에는 'Y'가, "차감"을 선택하면 'N'이 할당됨
            const mileageType = $("input[name='flexRadioDefault']:checked").val();
            const mileage = $('#point').val();
            const occuredType = $('#floatingTextarea').val().toString();
            console.log(memberCode);
            console.log(mileageType);
            console.log(mileage);
            console.log(occuredType);

            const  obj = {
                memberCode:memberCode,
                mileageType:mileageType,
                mileage:mileage,
                occuredType:occuredType
            }
            console.log(obj);
            fetch("/admin/adminPointDetail", {
                //POST형식으로
                method: "POST",
                //지금의 데이터를 json형태로 바꾼후
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                //memberPwd 값을 보낸다
                body: JSON.stringify(obj)
            })
                .then(result => result.text())
                .then(result => {
                    alert(result);
                    // 메인 창 리로드 및 팝업 창 닫기
                    if (window.opener) {
                        window.opener.location.reload();
                    }
                    window.close();
                })
        }

    }

    /* 전체 체크박스 선택시*/
    $('#allCheck').click(function (){

        const chk = $('#allCheck').prop("checked");
        if (chk){
            $(".rowCheck").prop("checked",true);
            console.log("체크")
        }else {
            $(".rowCheck").prop("checked",false);
            console.log("체크취소")
        }
    });
    /* 선택 체크박스 선택취소*/
    $(".rowCheck").click(function (){

        $('#allCheck').prop("checked",false);
        console.log("체크취소")

    });


    if (document.getElementById('memberPointManager')){
        const $memberPointManager = document.getElementById('memberPointManager');

        $memberPointManager.onclick = function () {
            // alert("xxx")

            const test = document.querySelectorAll("input[class='rowCheck']:checked").length;
            if (test != 0){
                const confim_val = confirm("회원에게 적립금을 지급하시겠습니까?");
                if (confim_val){
                    const checkArr = new Array();
                    $("input[class='rowCheck']:checked").each(function () {
                        checkArr.push($(this).attr("data-memberCode"));
                        console.log(checkArr)
                        memberPoints(checkArr);
                    });
                }

            }else{
                alert("회원을 선택하셔야합니다");
                return false;
            }
        }
    }



    if (document.getElementById('memberGradeRemove')){
        const $memberGradeRemove = document.getElementById('memberGradeRemove');

        $memberGradeRemove.onclick =function (){
            //alert("테스트")
            const test = document.querySelectorAll("input[class='rowCheck']:checked").length;
            if (test != 0){
                const confim_val = confirm( test+"명의  일반회원으로 바꾸겠습니까?");
                if (confim_val){
                    const checkArr = new Array();

                    $("input[class='rowCheck']:checked").each(function () {
                        checkArr.push($(this).attr("data-memberCode"));
                        console.log(checkArr)
                    });

                    $.ajax({
                        url: "/admin/memberGradeRemove",
                        type: "post",
                        data: {rowCheck: checkArr},
                        success: function (data) {
                            if (data.result === "success") {
                                alert("등급이 수정되었습니다.");
                                location.reload();
                            } else {
                                alert("등급 수정에 실패하였습니다.");
                            }
                        }
                    });
                }
            }else {
                alert("선택된 회원이 없습니다!");
                return false;
            }
        }

    }

    /* 회원정보 삭제 클릭시*/
    if(document.getElementById("memberInfoDeletion")) {
        const $memberInfoDeletion = document.getElementById("memberInfoDeletion");

        $memberInfoDeletion.onclick = function() {

                const test = document.querySelectorAll("input[class='rowCheck']:checked").length;
                if(test != 0) {

                    const confim_val = confirm(test+"명의 회원들을 정말로 삭제하시겠습니까?");
                    if (confim_val) {
                        const checkArr = new Array();

                        $("input[class='rowCheck']:checked").each(function () {
                            checkArr.push($(this).attr("data-memberCode"));
                            console.log(checkArr)
                        });

                        $.ajax({
                            url: "/admin/deleteMember",
                            type: "post",
                            data: {rowCheck: checkArr},
                            success: function (data) {
                                if (data.result === "success") {
                                    alert("삭제를 완료하였습니다");
                                    location.reload();
                                } else {
                                    alert("삭제실패");
                                }
                            }
                        });
                    }
                }else {
                    alert("선택된 회원이 없습니다!");
                    return false;
                }

        }
    }

}


