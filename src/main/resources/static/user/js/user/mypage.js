window.onload = function() {
    // 마이페이지 -> 회원 정보 이동
    if (document.getElementById("myInfo")) {
        const $update = document.getElementById("myInfo");
        $update.onclick = function () {
            location.href = "/user/user/modify";
        }
    }
}