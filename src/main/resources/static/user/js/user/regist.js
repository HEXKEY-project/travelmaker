window.onload = function() {

    // 아이디 중복 확인
    if (document.getElementById("idCheck")) {

        const $duplication = document.getElementById("idCheck");
        const $memberId = document.getElementById("memberId");

        $duplication.onclick = function () {

            let memberId = $memberId.value.trim();

            if (memberId === "") {
                alert("아이디를 입력하세요.");
                return;
            }

            fetch("/user/idCheck", {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                body: JSON.stringify({memberId: memberId})
            })
                .then(result => result.text())
                .then(result => alert(result))
                .catch((error) => error.text().then((res) => alert(res)));

        }

    }

    if (document.getElementById("regist")) {
        const $regist = document.getElementById("regist");
        $regist.onclick = function () {
            location.href = "/user/regist";
        }
    }



}

// 이메일 자동 완성
function autoEmail(a, b) {
    const mailId = b.split('@');                                                                   // 메일계정의 ID만 받아와서 처리하기 위함
    const mailList = ['naver.com', 'gmail.com', 'daum.net', 'hanmail.net', 'nate.com'];    // 메일목록
    const availableCity = new Array;                                                        // 자동완성 키워드 리스트
    for (var i = 0; i < mailList.length; i++) {
        availableCity.push(mailId[0] + '@' + mailList[i]);                                         // 입력되는 텍스트와 메일목록을 조합
    }
    $("#" + a).autocomplete({
        source: availableCity,                                                                     // jQuery 자동완성에 목록을 넣어줌
        focus: function (event, ui) {
            return false;
        }
    });
}

// HTML 로드된 후에 스크립트 실행
document.addEventListener('DOMContentLoaded', function () {

    // 아이디 형식에 맞춰 작성
    $("#id").blur(function () {
        let idCheck = /^[a-z0-9]{4,16}$/;

        if (!idCheck.test($("#id").val())) {
            $("#idError").css("color", "red");
            $("#idError").text("아이디는 영문 소문자 또는 숫자 4~16자로 입력해 주세요.");
            id = false;
        } else {
            $("#idError").text("");
            id = true;
        }
    });

    // 비밀번호 형식에 맞춰 작성
    document.getElementById('pwd1').addEventListener('blur', function () {
        const password = this.value;
        const regex = /^(?!.*(.)\1\1)(?!((?:[A-Za-z]+)|(?:[~`!@#$^()*_\-={}[]|;:<>,.?\/]+)|(?:[0-9]+))$)[A-Za-z\d~`!@#$^()*_\-={}[]|;:<>,.?\/]{10,}$/;
        const isValid = regex.test(password);
        const messageElement = document.getElementById('pwdError');

        if (password.length >= 10 && isValid) {
            messageElement.textContent = "";
        } else if (password.length > 0) {
            messageElement.textContent = "비밀번호가 형식에 맞지 않습니다.";
        }
    });

    // 비밀번호 클릭 시 비밀번호 형식 안내 문구창
    const pwd1Element = document.getElementById("pwd1");
    const pwdMessageElement = document.getElementById("pwdMessage");

    pwd1Element.addEventListener("click", function (event) {
        // event.stopPropagation();
        pwdMessageElement.style.display = "block";
    });

    document.addEventListener("click", function (event) {
        if (event.target !== pwd1Element && event.target !== pwdMessageElement) {
            pwdMessageElement.style.display = "none";
        }
    });

    document.addEventListener("keydown", function (event) {
        if (event.key === "Tab") {
            pwdMessageElement.style.display = "none";
        }
    });

    // 비밀번호 일치 확인
    document.getElementById('pwd1').addEventListener('input', checkPasswords);
    document.getElementById('pwd2').addEventListener('input', checkPasswords);

    function checkPasswords() {
        let password1 = document.getElementById('pwd1').value;
        let password2 = document.getElementById('pwd2').value;
        let messageElement = document.getElementById('pwdError2')

        if (password1 === password2) {
            messageElement.textContent = "";
        } else {
            messageElement.textContent = "비밀번호가 일치하지 않습니다."
        }

    }

    // 체크 박스 상태 변화
    let checkAllCheckbox = document.getElementById('checkAll');
    let requiredCheck = document.getElementsByClassName('requiredCheck');
    let optionalCheck = document.getElementsByClassName('optionalCheck');

    function updateCheckAllCheckbox() {
        let allChecked = true;

        for (let i = 0; i < requiredCheck.length; i++) {
            if (!requiredCheck[i].checked) {
                allChecked = false;
                break;
            }
        }

        for (let i = 0; i < optionalCheck.length; i++) {
            if (!optionalCheck[i].checked) {
                allChecked = false;
                break;
            }
        }

        checkAllCheckbox.checked = allChecked;

    }

    checkAllCheckbox.addEventListener('change', function () {
        for (let i = 0; i < requiredCheck.length; i++) {
            requiredCheck[i].checked = this.checked;
        }

        for (let i = 0; i < optionalCheck.length; i++) {
            optionalCheck[i].checked = this.checked;
        }

        updateCheckAllCheckbox();

    });

    for (let i = 0; i < requiredCheck.length; i++) {
        requiredCheck[i].addEventListener('change', function () {
            updateCheckAllCheckbox();
        });
    }

    for (let i = 0; i < optionalCheck.length; i++) {
        optionalCheck[i].addEventListener('change', function () {
            updateCheckAllCheckbox();
        });
    }

});


document.addEventListener("DOMContentLoaded", function() {
    var smsCheckbox = document.getElementById("promotion1");
    var smsHiddenInput = document.getElementById("promo1");
    smsCheckbox.addEventListener("change", function() {
        smsHiddenInput.value = this.checked ? "Y" : "N";
    });

    var emailCheckbox = document.getElementById("promotion2");
    var emailHiddenInput = document.getElementById("promo2");
    emailCheckbox.addEventListener("change", function() {
        emailHiddenInput.value = this.checked ? "Y" : "N";
    });
});
