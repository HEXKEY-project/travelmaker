window.onload = function () {
    let big = ['', 'CR', 'BG', 'TI'];
    let middle = [['2차 분류'],
        ['2차 분류', 'HD', 'ST'],
        ['2차 분류', 'BK', 'SG'],
        ['2차 분류', 'AC', 'SS', 'AY', 'AS']];
    let little = [[['3차 분류']],
        [['3차 분류'],
            ['3차 분류', 'OD', 'ME', 'LE'],
            ['3차 분류', 'OD', 'ME', 'LE']],
        [['3차 분류'],
            ['3차 분류', 'TE', 'BS', 'BE'],
            ['3차 분류', 'FF', 'BD', 'CS', 'AB', 'EB']],
        [['3차 분류'],
            ['3차 분류', 'TP', 'EN', 'WU', 'CF', 'AY'],
            ['3차 분류', 'CB', 'SW', 'LW', 'SF', 'BC'],
            ['3차 분류', 'PN', 'EE', 'TI', 'TS', 'SR'],
            ['3차 분류', 'CH', 'GF', 'RD', 'AS', 'SM']]
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
            opt.value = mcs;
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
            opt.value = lcs;
            opt.appendChild(txt);
            little_category_serial.appendChild(opt);
        }
    }


    let first = ['', '캐리어', '가방', '여행용품'];
    let second = [['2차 분류' ],
        [{ categoryName : '2차 분류'}, { categoryCode : 4, categoryName : '하드' }, { categoryCode : 5, categoryName : '소프트' }],
        [{ categoryName : '2차 분류'}, { categoryCode : 6, categoryName : '배낭' }, { categoryCode : 7, categoryName : '보조가방' }],
        [{ categoryName : '2차 분류'}, { categoryCode : 8, categoryName : '수납|편의' }, { categoryCode : 9, categoryName : '안전|위생'},
                                      { categoryCode : 10, categoryName : '악세서리'}, { categoryCode : 11, categoryName : '액티비티|시즌' }]];
    let third = [[[ '3차 분류' ]],
        [['3차 분류' ],
            [{ categoryName : '3차 분류' }, { categoryCode : 12, categoryName : '기내(21형 이하)' }, { categoryCode : 13, categoryName : '중형(22~26형)' }, { categoryCode : 14, categoryName : '대형(27형 이상)' }],
            [{ categoryName : '3차 분류' }, { categoryCode : 15, categoryName : '기내(21형 이하)' }, { categoryCode : 16, categoryName : '중형(22~26형)' }, { categoryCode : 17, categoryName :'대형(27형 이상)' }]],
        [[ '3차 분류' ],
            [{ categoryName : '3차 분류' }, { categoryCode : 18, categoryName : '여행배낭' }, { categoryCode : 19, categoryName : '배낭용품' }, { categoryCode : 20, categoryName : '백팩' }],
            [{ categoryName : '3차 분류' }, { categoryCode : 21, categoryName : '접이식|폴딩백' }, { categoryCode : 22, categoryName : '보스턴|더플백' }, { categoryCode : 23, categoryName : '크로스|숄더백' }, { categoryCode : 24, categoryName : '도난방지 백' }, { categoryCode : 25, categoryName : '기타 백' }]],
        [[ '3차 분류' ],
            [{ categoryName : '3차 분류' }, { categoryCode : 26, categoryName : '트래블팩|파우치' }, { categoryCode : 27, categoryName : '안대|목베개' }, { categoryCode : 28, categoryName : '와이파이|유심' }, { categoryCode : 29, categoryName : '간편식품' }, { categoryCode : 30, categoryName : '편의용품' }],
            [{ categoryName : '3차 분류' }, { categoryCode : 31, categoryName : '캐리어커버|벨트' }, { categoryCode : 32, categoryName : '안전복대|지갑' }, { categoryCode : 33, categoryName : '자물쇠|와이어' }, { categoryCode : 34, categoryName : '보안|구급용품' }, { categoryCode : 35, categoryName : '뷰티케어' }],
            [{ categoryName : '3차 분류' }, { categoryCode : 36, categoryName : '여권커버|네임택' }, { categoryCode : 37, categoryName : '전자|전기용품' }, { categoryCode : 38, categoryName : '여행아이템' }, { categoryCode : 39, categoryName : '여행문구' }, { categoryCode : 40, categoryName : '기념품' }],
            [{ categoryName : '3차 분류' }, { categoryCode : 41, categoryName : '캠핑|등산' }, { categoryCode : 42, categoryName : '골프' }, { categoryCode : 43, categoryName : '래쉬가드' }, { categoryCode : 44, categoryName : '아쿠아슈즈' }, { categoryCode : 45, categoryName : '스웜' }]]
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
            let txt = document.createTextNode(mc.categoryName);
            opt.value = mc.categoryCode;
            opt.appendChild(txt);
            middle_category.appendChild(opt);
        }


    middle_category.addEventListener('change', thirdCategory)

    function thirdCategory() {
        let bcIndex = big_category.selectedIndex;
        let mcIndex = middle_category.selectedIndex;

        while (little_category.lastChild) {
            little_category.removeChild(little_category.lastChild)
        }

        for (let lc of third[bcIndex][mcIndex]) {
            console.log(lc);
            let opt = document.createElement('option')
            let txt = document.createTextNode(lc.categoryName);
            opt.value = lc.categoryCode;
            opt.appendChild(txt);
            little_category.appendChild(opt);
        }

    }

    }


}

/* 상품 옵션 +버튼 클릭시 옵션명 input 만들기 */

document.addEventListener("DOMContentLoaded", function (){
    // + 버튼 클릭 시 옵션명 입력 필드와 + 버튼을 추가
    let optionCount = 2; // 옵션의 숫자를 초기화

    document.getElementById('plusOptName').addEventListener('click', function() {
        let optionContainer = document.getElementById('optionContainer');

        // 새로운 옵션명 입력 필드를 생성
        let input = document.createElement('input');
        input.type = 'text';
        input.placeholder = '옵션명';
        input.id = 'optName' + optionCount; // ID 값에 숫자 추가

        // '-' 버튼 생성
        let removeButton = document.createElement('button');
        removeButton.type = 'button';
        removeButton.innerText = '-';

        // '-' 버튼 클릭 시 옵션 제거
        removeButton.addEventListener('click', function() {
            optionContainer.removeChild(input); // 옵션명 입력 필드 삭제
            optionContainer.removeChild(removeButton); // '-' 버튼 삭제
        });

        // 생성된 요소를 옵션 컨테이너에 추가
        optionContainer.appendChild(input);
        optionContainer.appendChild(removeButton);
        optionContainer.style.flex="none";

        optionCount++; // 옵션 숫자 증가
    });

});



/* 옵션관리 추가하기 삭제하기 */
document.addEventListener("DOMContentLoaded", function (){
    let nextValue = 4;

    document.getElementById("addOption").addEventListener("click", function (){
        const optionTextValue = document.getElementById("optionText").value;
        const selectElement = document.getElementById("product_option");
        const newOption = document.createElement("option");

        newOption.textContent = optionTextValue;
        newOption.value = nextValue.toString();

        selectElement.appendChild(newOption);

        document.getElementById("optionText").value="";

        nextValue++;
    });

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

/* 상품 설명이미지 파일 불러오기시 input값에 해당 파일명이 뜬다. */
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

/* 상품 대표 이미지 파일 불러오기시 input값에 해당 파일명이 뜬다. */
document.addEventListener("DOMContentLoaded", function() {
    // 모든 input 요소에 대한 이벤트 리스너 등록
    const fileInputs = document.querySelectorAll('input[type="file"]');
    fileInputs.forEach(function(fileInput) {
        fileInput.addEventListener('change', function() {
            // 해당하는 .img-area 요소를 찾아 파일 이름 업데이트
            const imgArea = this.parentElement.querySelector('.img-area2');
            if (this.files.length > 0) {
                imgArea.value = this.files[0].name;
            } else {
                imgArea.value = "예) 각도별 이미지.jpg";
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

/* 상세설명 이미지 추가하기 버튼 클릭시 이벤트 */
document.addEventListener("DOMContentLoaded", function () {

    const addButton = document.querySelector("#add_content");

    let counter = 6;

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


        const labelNumber = document.createElement("label");

        labelNumber.setAttribute("class", "number");
        labelNumber.className = "number";
        labelNumber.textContent = counter;
        labelNumber.style.marginLeft = "16px";

        counter++;

        contentInput.appendChild(labelNumber);
        contentInput.appendChild(imgArea);
        contentInput.appendChild(productContent);
        contentInput.appendChild(fileButton);


        const divAddContent = document.getElementById("div_add_content");

        divAddContent.parentNode.insertBefore(contentInput, divAddContent);

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

});


/* 상품 이미지 추가하기 버튼 클릭시 이벤트 */

document.addEventListener("DOMContentLoaded", function () {

    const addImgButton = document.querySelector("#add_img");


    addImgButton.addEventListener("click", function (){


        const imgInput = document.createElement("div");
        imgInput.classList.add("img-input");

        const imgArea2 = document.createElement("input");
        imgArea2.classList.add("img-area2");

        imgArea2.setAttribute("value", "예) 각도별 이미지.jpg");
        imgArea2.setAttribute("placeholder", "예) 각도별 이미지.jpg");

        const counterId2 = "productImg" + (document.querySelectorAll(".img-input").length + 1);

        const productImg = document.createElement("input");
        productImg.setAttribute("type", "file");
        productImg.setAttribute("name", "product_img");
        productImg.setAttribute("accept", "image/gif,image/jpeg,image/png");
        productImg.setAttribute("id", counterId2);

        const fileButton2 = document.createElement("label");

        fileButton2.setAttribute("for", counterId2);
        fileButton2.classList.add("file_button");
        fileButton2.textContent = "찾아보기";

        const labelName = document.createElement("label");

        labelName.setAttribute("class", "text");
        labelName.className = "text";
        labelName.textContent = "각도별 이미지";
        labelName.style.marginLeft = "16px";

        imgInput.appendChild(labelName);
        imgInput.appendChild(imgArea2);
        imgInput.appendChild(productImg);
        imgInput.appendChild(fileButton2);

        const divAddImg = document.getElementById("div_add_img");

        divAddImg.parentNode.insertBefore(imgInput, divAddImg);

        const imgFileInputs = document.querySelectorAll('input[type="file"]');
        imgFileInputs.forEach(function(imgFileInput) {
            imgFileInput.addEventListener('change', function() {
                // 해당하는 .img-area 요소를 찾아 파일 이름 업데이트
                const imgArea2 = this.parentElement.querySelector('.img-area2');
                if (this.files.length > 0) {
                    imgArea2.value = this.files[0].name;
                } else {
                    imgArea2.value = "예) 각도별 이미지.jpg";
                }
            });
        });


    });

});