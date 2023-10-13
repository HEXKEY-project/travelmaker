
/* 상품이미지들 마우스 휠 이벤트 */
document.addEventListener('DOMContentLoaded', function (){
    document.getElementById('smallImgArea').addEventListener('wheel', function (e) {
        e.preventDefault(); // 기본 스크롤 이벤트 비활성화

        const scrollAmount = e.deltaY; // 마우스 휠 동작에 따른 스크롤 양
        const smallImgArea = document.getElementById('smallImgArea');
        smallImgArea.scrollLeft += scrollAmount;
    });
});

/* 상품이미지들 마우스 오버시 thumbnail영역에 이미지 보여주기 */

document.addEventListener('DOMContentLoaded', function () {
    const thumbnailArea = document.getElementById('thumbnailArea');
    const thumbnailImages = document.querySelectorAll('.thumbnailImg');

    // 초기로딩 이미지를 설정합니다.
    if (thumbnailImages.length > 0) {
        const initialImage = new Image();
        initialImage.src = thumbnailImages[0].src;
        initialImage.alt = "상세 이미지";
        initialImage.style.width = "706px";
        initialImage.style.height = "695px";
        initialImage.style.flexShrink = "0";

        thumbnailArea.appendChild(initialImage);
    }

    // 각 썸네일 이미지에 마우스 오버 이벤트 리스너를 추가하여 이미지를 표시합니다.
    thumbnailImages.forEach((thumbnail, index) => {
        thumbnail.addEventListener('mouseover', () => {
            // 마우스 오버할 때 이미지를 변경합니다.
            thumbnailArea.innerHTML = `<img src="${thumbnail.src}" alt="상세 이미지" style="width: 706px; height: 695px; flex-shrink: 0;">`;
        });
    });
});

document.addEventListener('DOMContentLoaded', function (){
    function updateSelectedOption() {
        const selectElement = document.getElementById("productOpt");
        const selectedOption = selectElement.options[selectElement.selectedIndex].text;
        const addOptDiv = document.getElementById("addOpt");

        // 선택한 옵션 텍스트로 새로운 span 요소를 생성합니다.
        const newSpan = document.createElement("span");
        newSpan.innerText = selectedOption;

        // addOptDiv의 기존 내용을 지우고 새로운 span 요소를 추가합니다.
        addOptDiv.innerHTML = '';
        addOptDiv.appendChild(newSpan);
    }
});

