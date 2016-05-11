//var m = $("#pic");
//
//function SKclass(obj, Rate, speed) {
//    var oL = obj.offsetLeft;
//    var oT = obj.offsetTop;
//    this.stop = null;
//    this.oTime = null;
//    this.state = 0;
//    var om = this;
//    this.start = function () {
//        console.log("dyd")
//        if (this.state == 0) {
//            ostart();
//            this.state = 1;
//        }
//        else {
//            console.log('Ì«À÷º¦ÁË')
//        }
//    }
//    var ostart = function () {
//        if (parseInt(obj.style.left) == oL - 2) {
//            obj.style.top = oT + 2 + "px";
//            setTimeout(function () {
//                obj.style.left = oL + 2 + "px"
//            },
//            Rate)
//        }
//        else {
//            obj.style.top = oT - 2 + "px";
//            setTimeout(function () {
//                obj.style.left = oL - 2 + "px"
//            },
//            Rate)
//        }
//        om.oTime = setTimeout(function () {
//            ostart()
//        },
//        speed);
//    }
//    this.stop = function () {
//        clearTimeout(om.oTime);
//        this.state = 0;
//
//    }
//}
//var pic = new SKclass(m, 20, 50);

function zd(u) {
    var a = ['top', 'left'], b = 0;
    u = setInterval(function () {
        document.getElementById('win').style[a[b % 2]] = (b++) % 4 < 2 ? 0 : 4;
        if (b > 15) {
            clearInterval(u);
            b = 0
        }
    },
    32)
}