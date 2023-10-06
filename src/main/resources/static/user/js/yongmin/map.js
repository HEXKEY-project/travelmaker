window.onload = function () {

    const $map1 = document.getElementById('map1');
    const $map2 = document.getElementById('map2');
    const $map = document.getElementById('map');
    const $roadview = document.getElementById('roadview');

    $map1.addEventListener("click", function() {
        $roadview.style.display = 'none'
        $map.style.display = 'block'

        $map1.style.backgroundColor = '#0075BD'
        $map2.style.backgroundColor = ''

        $map1.style.color = 'white'
        $map2.style.color = '#3f3f3f'

    })

    $map2.addEventListener("click", function() {
        $map.style.display = 'none'
        $roadview.style.display = 'block'

        $map1.style.backgroundColor = ''
        $map2.style.backgroundColor = '#0075BD'

        $map1.style.color = '#3f3f3f'
        $map2.style.color = 'white'
    })


}