// 회원가입 이동
document.addEventListener('DOMContentLoaded', function() {
    const joinBtn = document.getElementById('joinBtn');

    if (joinBtn) {
        joinBtn.addEventListener('click', function() {
            window.location.href = '/user/user/regist';
        });
    }
});


// 비밀번호 Caps Lock 활성화 확인
function checkCapsLock(event)  {
    if (event.getModifierState("CapsLock")) {
        document.getElementById("capsMessage").innerText
            = "Caps Lock 활성화되어 있습니다."
    }else {
        document.getElementById("capsMessage").innerText
            = ""
    }
}

// 아이디 저정
function rememberId() {
    console.log("아이디 체크 여부 확인 메시지 ")

    let isChecked = document.getElementById('saveId').checked;

    if (isChecked) {
        let username = document.getElementById('memberId').value;
        document.cookie = "memberName=" + username + "; expires=Thu, 18 Dec 2022 12:00:00 UTC; path=/;";
    } else {
        document.cookie = "memberName=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    }
}



document.addEventListener("DOMContentLoaded", function () {
    let memberName = getCookie("memberName");
    if (memberName !== "") {
        document.getElementById('memberId').value = memberName;
        document.getElementById('saveId').checked = true;
    }
});

function getCookie(saveId) {
    let name = saveId + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}
