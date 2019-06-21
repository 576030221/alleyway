var current = null;
document.querySelector('#email').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: 0,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '240 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});
document.querySelector('#password').addEventListener('focus', function(e) {
    if (current) current.pause();   //pause暂停的意思
    current = anime({
        targets: 'path',    // 获取元素
        strokeDashoffset: {//指定了dash模式到路径开始的距离
            value: -336,
            duration: 700,  // 动画持续时间
            easing: 'easeOutQuart'  // 运动曲线
        },
        strokeDasharray: {  //设置描边的点划线的图案范式。就是设置实线和虚线的宽度。即有或者没有线段的长度
            value: '240 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});

document.querySelector('#submit').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: -730,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '530 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});
