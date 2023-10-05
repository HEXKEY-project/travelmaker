window.onload = function () {
    ///////// 화살표 클릭 시 내용 숨김////////////////////
    function toggleContent($h2Element, $bodyElement, $spanElement) {

        let rotated = false;

        $h2Element.addEventListener("click", function () {

            if (rotated) {
                $spanElement.style.transform = 'rotate(315deg)'; // 원래 각도로 회전
                $bodyElement.style.display = "inline";

            } else {
                $spanElement.style.transform = 'rotate(135deg)'; // 새로운 각도로 회전
                $bodyElement.style.display = "none";
            }

            rotated = !rotated;
        });
    }

    toggleContent(
        document.getElementById("ship_h2"),
        document.getElementById("ship_body"),
        document.getElementById("ship_h2_span")
    );

    toggleContent(
        document.getElementById("product_h2"),
        document.getElementById("product_body"),
        document.getElementById("product_h2_span")
    );

    toggleContent(
        document.getElementById("discount_h2"),
        document.getElementById("discount_body"),
        document.getElementById("discount_h2_span")
    );

    toggleContent(
        document.getElementById("pay_h2"),
        document.getElementById("pay_body"),
        document.getElementById("pay_h2_span")
    );

    toggleContent(
        document.getElementById("pay_kind_h2"),
        document.getElementById("pay_kind_body"),
        document.getElementById("pay_kind_h2_span")
    );

    toggleContent(
        document.getElementById("point_h2"),
        document.getElementById("point_body"),
        document.getElementById("point_h2_span")
    );


}