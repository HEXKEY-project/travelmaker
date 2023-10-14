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


// 아이디 찾기 버튼에 대한 클릭 이벤트
function findUserId() {

    var name = document.getElementById("inputName_id").value;
    var phone = document.getElementById("inputPhone_id").value;
    var findIdResult = document.getElementById("findIdResult").value;

}

// 휴대폰 or 이메일로 비밀번호 찾기 선택 시 보이는 화면
function find_Pwd(num) {
    if (num == '1') {
        document.getElementById("findPwdByPhone").style.display = "";
        document.getElementById("findPwdByEmail").style.display = "none";
    } else {
        document.getElementById("findPwdByPhone").style.display = "none";
        document.getElementById("findPwdByEmail").style.display = "";

    }
}
