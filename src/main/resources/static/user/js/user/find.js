function findMember(method) {
    document.getElementById("findIdByEmail").style.display = (method === 'email') ? 'block' : 'none';
    document.getElementById("findIdByPhone").style.display = (method === 'phone') ? 'block' : 'none';

    if (method === 'phone') {
        document.getElementById("findIdEmail").removeAttribute('required');
        document.getElementById("findIdPhone").setAttribute('required', 'required');
    } else if (method === 'email') {
        document.getElementById("findIdEmail").setAttribute('required', 'required');
        document.getElementById("findIdPhone").removeAttribute('required');
    }
중
}

// 아이디 찾기
function findMemberId() {

    let name = document.getElementById("findIdName").value;
    let email = document.getElementById("findIdEmail").value;
    let findIdResult = document.getElementById("findIdResult").value;

}

function findMemberPassword(method) {

    document.getElementById("findPwdByEmail").style.display = (method === 'email') ? 'block' : 'none';
    document.getElementById("findPwdByPhone").style.display = (method === 'phone') ? 'block' : 'none';

}

// 비밀번호 찾기
function findMemberPwd() {

    let name = document.getElementById("findPwdName").value;
    let email = document.getElementById("findPwdEmail").value;
    let findPwdResult = document.getElementById("findPwdResult").value;

}