var audioElement;
$(document).ready(function () {
    audioElement = $('#audio');
    //audioElement.setAttribute('src', 'http://att2.weiphone.net/temp16/Day_1301248/shake_sound_male.mp3');
    //audioElement.setAttribute('src', './resourcse/shake_sound_male.mp3');
    //audioElement.attr('autoplay', 'autoplay');//打开自动播放
    audioElement.load();
    $.get();

    //    audioElement.addEventListener("load", function () {
    //        audioElement.play();
    //    },
    //    true);
    //    $('#sss').click(function () {
    //        audioElement.play();
    //    });
    //
    //    $('.pause').click(function () {
    //        audioElement.pause();
    //    });
});

function soundclick() {
    //audioElement.play();
     $('#audio').play();
};