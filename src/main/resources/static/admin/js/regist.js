window.onload = function () {
    let big = ['', 'CR', 'BG', 'TI'];
    let middle = [['2차 분류'],
        ['2차 분류', 'HD', 'ST'],
        ['2차 분류', 'BK', 'SG'],
        ['2차 분류', 'AC', 'SS', 'AY', 'AS']];
    let little = [[['3차 분류']],
        [['3차 분류'],
            [['3차 분류'], ['OD'], ['ME'], ['LE']],
            [['3차 분류'], ['OD'], ['ME'], ['LE']]],
        [['3차 분류'],
            [['3차 분류'], ['TE'], ['BS'], ['BE']],
            [['3차 분류'], ['FF'], ['BD'], ['CS'], ['AB'], ['EB']]],
        [['3차 분류'],
            [['3차 분류'], ['TP'], ['EN'], ['WU'], ['CF'], ['AY']],
            [['3차 분류'], ['CB'], ['SW'], ['LW'], ['SF'], ['BC']],
            [['3차 분류'], ['PN'], ['EE'], ['TI'], ['TS'], ['SR']],
            [['3차 분류'], ['CH'], ['GF'], ['RD'], ['AS'], ['SM']]]
    ]

    let big_category_serial = document.getElementById('big_category_serial')
    let middle_category_serial = document.getElementById('middle_category_serial')
    let little_category_serial = document.getElementById('little_category_serial')

    big_category_serial.addEventListener('change', middleSerial)

    function middleSerial() {
        // 현재 선택한 big_category의 index값을 알아냄
        let bigIndex = big_category_serial.selectedIndex;
        // 이미 등록된 목록은 제거
        while (middle_category_serial.lastChild) {
            middle_category_serial.removeChild(middle_category_serial.lastChild);
        }
        // 선택한 시도에 대한 구군목록을 배열에서 가져와서
        // 구군select에 목록 option으로 추가함
        for (let mcs of middle[bigIndex]) {
            let opt = document.createElement('option');
            let txt = document.createTextNode(mcs);
            opt.appendChild(txt);
            middle_category_serial.appendChild(opt);
        }

    }

    middle_category_serial.addEventListener('change', littleSerial)

    function littleSerial() {
        let bigIndex = big_category_serial.selectedIndex;
        let middleIndex = middle_category_serial.selectedIndex;

        while (little_category_serial.lastChild) {
            little_category_serial.removeChild(little_category_serial.lastChild)
        }

        for (let lcs of little[bigIndex][middleIndex]) {
            let opt = document.createElement('option');
            let txt = document.createTextNode(lcs);
            opt.appendChild(txt);
            little_category_serial.appendChild(opt);
        }
    }


    let first = ['', '캐리어', '가방', '여행용품'];
    let second = [['2차 분류'],
        ['2차 분류', '하드', '소프트'],
        ['2차 분류', '배낭', '보조가방'],
        ['2차 분류', '수납|편의', '안전|위생', '악세서리', '액티비티|시즌']];
    let third = [[['3차 분류']],
        [['3차 분류'],
            [['3차 분류'], ['기내(21형 이하)'], ['중형(22~26형)'], ['대형(27형 이상)']],
            [['3차 분류'], ['기내(21형 이하)'], ['중형(22~26형)'], ['대형(27형 이상)']]],
        [['3차 분류'],
            [['3차 분류'], ['여행배낭'], ['배낭용품'], ['백팩']],
            [['3차 분류'], ['접이식|폴딩백'], ['보스턴|더플백'], ['크로스|숄더백'], ['도난방지 백'], ['기타 백']]],
        [['3차 분류'],
            [['3차 분류'], ['트래블팩|파우치'], ['안대|목베개'], ['와이파이|유심'], ['간편식품'], ['편의용품']],
            [['3차 분류'], ['캐리어커버|벨트'], ['안전복대|지갑'], ['자물쇠|와이어'], ['보안|구급용품'], ['뷰티케어']],
            [['3차 분류'], ['여권커버|네임택'], ['전자|전기용품'], ['여행아이템'], ['여행문구'], ['기념품']],
            [['3차 분류'], ['캠핑|등산'], ['골프'], ['래쉬가드'], ['아쿠아슈즈'], ['스웜']]]
    ]

    let big_category = document.getElementById('big_category')
    let middle_category = document.getElementById('middle_category')
    let little_category = document.getElementById('little_category')

    big_category.addEventListener('change', secondCategory)

    function secondCategory() {
        let bcIndex = big_category.selectedIndex;

        while (middle_category.lastChild) {
            middle_category.removeChild(middle_category.lastChild);
        }

        for (let mc of second[bcIndex]) {
            let opt = document.createElement('option');
            let txt = document.createTextNode(mc);
            opt.appendChild(txt)
            middle_category.appendChild(opt);
        }

    }

    middle_category.addEventListener('change', thirdCategory)

    function thirdCategory() {
        let bcIndex = big_category.selectedIndex;
        let mcIndex = middle_category.selectedIndex;

        while (little_category.lastChild) {
            little_category.removeChild(little_category.lastChild)
        }

        for (let lc of third[bcIndex][mcIndex]) {
            let opt = document.createElement('option')
            let txt = document.createTextNode(lc)
            opt.appendChild(txt)
            little_category.appendChild(opt);
        }

    }



}

$(function (){
    $("#variableColor").hide();
    $("#careerSize").hide();
    $("#etcSize").hide();
    $("#etcOption").hide();

    $("#product_option").change(function (){

        switch ($("#product_option").val()){
            case "firstOption" :
                $("#variableColor").hide();
                $("#careerSize").hide();
                $("#etcSize").hide();
                $("#etcOption").hide();
                break
            case "color" :
                $("#variableColor").show();
                $("#careerSize").hide();
                $("#etcSize").hide();
                $("#etcOption").hide();
                break
            case "size" :
                $("#etcSize").show();
                $("#variableColor").hide();
                $("#careerSize").hide();
                $("#etcOption").hide();
                break
            case "inch" :
                $("#careerSize").show();
                $("#etcSize").hide();
                $("#etcOption").hide();
                $("#variableColor").hide();
                break
            case "etc" :
                $("#etcOption").show();
                $("#variableColor").hide();
                $("#careerSize").hide();
                $("#etcSize").hide();
                break
            default :
                break
        }
    })

});

/* label별 index 화면 표시 */
document.addEventListener("DOMContentLoaded", function () {
    const imgContentInputs = document.querySelectorAll(".content-input");

    imgContentInputs.forEach(function (imgContentInputs, index) {
        const labelNumber = document.createElement("label");
        labelNumber.className = "number";
        labelNumber.textContent = index + 1;
        labelNumber.style.marginLeft = "16px";
        imgContentInputs.insertBefore(labelNumber, imgContentInputs.firstChild);
    });
});


document.addEventListener("DOMContentLoaded", function() {
    // 모든 input 요소에 대한 이벤트 리스너 등록
    const fileInputs = document.querySelectorAll('input[type="file"]');
    fileInputs.forEach(function(fileInput) {
        fileInput.addEventListener('change', function() {
            // 해당하는 .img-area 요소를 찾아 파일 이름 업데이트
            const imgArea = this.parentElement.querySelector('.img-area');
            if (this.files.length > 0) {
                imgArea.value = this.files[0].name;
            } else {
                imgArea.value = "예)상세 페이지.jpg";
            }
        });
    });
});

/* 각 이미지 div별 label생성 */
document.addEventListener("DOMContentLoaded", function () {
    const imgContentInputs = document.querySelectorAll(".img-input");

    imgContentInputs.forEach(function (imgContentInputs, index) {
        const labelText = document.createElement("label");
        labelText.className = "text";
        labelText.textContent = index === 0 ? "대표 이미지" : "각도별 이미지";
        labelText.style.marginLeft = "16px";
        imgContentInputs.insertBefore(labelText, imgContentInputs.firstChild);

    });
});

/* 이미지 추가하기 버튼 클릭시 이벤트 */
document.addEventListener("DOMContentLoaded", function () {

    const addButton = document.querySelector("#add_content");

    addButton.addEventListener("click", function (){

        const contentInput = document.createElement("div");
        contentInput.classList.add("content-input");

        const imgArea = document.createElement("input");
        imgArea.classList.add("img-area");

        imgArea.setAttribute("value", "예)상세 페이지.jpg");
        imgArea.setAttribute("placeholder", "예)상세 페이지.jpg");

        const counterId = "productContent" + (document.querySelectorAll(".content-input").length + 1);

        const productContent = document.createElement("input");
        productContent.setAttribute("type", "file");
        productContent.setAttribute("name", "product_content");
        productContent.setAttribute("accept", "image/gif,image/jpeg,image/png");
        productContent.setAttribute("id", counterId);

        const fileButton = document.createElement("label");


        fileButton.setAttribute("for", counterId);
        fileButton.classList.add("file_button");
        fileButton.textContent = "찾아보기";

        contentInput.appendChild(imgArea);
        contentInput.appendChild(productContent);
        contentInput.appendChild(fileButton);

        const newContentInput = document.querySelector(".content-input");
        newContentInput.lastChild

    });

});
