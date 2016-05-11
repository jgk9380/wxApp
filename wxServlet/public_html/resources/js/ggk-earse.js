$(function () {
    $('#redux').eraser( {
        size : 5
    });
});

$('#redux').eraser( {
    completeRatio : 0.1, completeFunction : console.log("30%")
});

$('#redux').eraser( {
    progressFunction : function (p) {
        console.log(p);
        console.log(Math.round(p * 100) + '%');
    }
});

function qry() {
    console.log("dd");
    var progress = $('#redux').eraser('progress');
    console.log("dd" + progress);
    return progress;
}
//              function remove(event) {
//                  $("#redux").eraser('clear');
//                  event.preventDefault();
//              }
//
//              function reset(event) {
//                  $("#redux").eraser('reset');
//                  event.preventDefault();
//              }


