window.onload = function() {
    // 화살표 클릭 시 내용 숨김
    const $ship_h2 = document.getElementById("ship_h2");
    const $ship_body = document.getElementById("ship_body");
    const $ship_h2_span = document.getElementById("ship_h2_span")

    let rotated = false;

    $ship_h2.addEventListener("click", function() {

        if (rotated) {
            $ship_h2_span.style.transform = 'rotate(135deg)'; // 원래 각도로 회전
            $ship_body.style.display = "inline";

        } else {
            $ship_h2_span.style.transform = 'rotate(315deg)'; // 새로운 각도로 회전
            $ship_body.style.display = "none";
        }

        rotated = !rotated ;

    });

    const $product_h2 = document.getElementById("product_h2");
    const $product_body = document.getElementById("product_body");
    const $product_h2_span = document.getElementById("product_h2_span")

    let rotated2 = false;

    $product_h2.addEventListener("click", function() {

        if (rotated2) {
            $product_h2_span.style.transform = 'rotate(135deg)'; // 원래 각도로 회전
            $product_body.style.display = "inline";

        } else {
            $product_h2_span.style.transform = 'rotate(315deg)'; // 새로운 각도로 회전
            $product_body.style.display = "none";
        }

        rotated2 = !rotated2 ;

    });

    const $discount_h2 = document.getElementById("discount_h2");
    const $discount_body = document.getElementById("discount_body");
    const $discount_h2_span = document.getElementById("discount_h2_span")

    let rotated3 = false;

    $discount_h2.addEventListener("click", function() {

        if (rotated3) {
            $discount_h2_span.style.transform = 'rotate(135deg)'; // 원래 각도로 회전
            $discount_body.style.display = "inline";

        } else {
            $discount_h2_span.style.transform = 'rotate(315deg)'; // 새로운 각도로 회전
            $discount_body.style.display = "none";
        }

        rotated3 = !rotated3 ;

    });



}