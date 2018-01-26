function printTicket(){
logger("信息正在打印..");
//var printText = [{"info":"奔想智能","alignType":1,"textSize":1,"boldType":0,"doubleWH":4,"line_spacing":2},
//                    {"info":"\n","alignType":1},
//                    {"info":"取餐号:"}
//                    ];
  var printText = [{"info":"奔想智能","alignType":1,"textSize":1,"boldType":0,"doubleWH":4,"line_spacing":2},
              {"info":"\n","alignType":1,"line_spacing":2},
              {"info":"取餐号:"},
              {"info":"16","doubleWH":4},
              {"info":"                订餐号：14975809452540","line_spacing":1},
              {"info":"\n","line_spacing":1},
              {"info":"时间:06-16 10:42:25        付款方式：微信支付宝"},
              {"info":"\n"},
              {"info":"温馨提醒：凭小票取票，请保管好小票","boldType":0},
              {"info":"\n"},
              {"info":"--------------------------------------------------------------"},
              {"info":"\n"},
              {"info":"名称: 数量    单价    小计"},
              {"info":"\n"},
              {"info":"--------------------------------------------------------------"},
              {"info":"\n"},
              {"info":"1.意大利牛排面意大利牛排面            1         6.00    6.00"},
              {"info":"\n"},
              {"info":"五香味","cutPaperType":0,"textSize":1,"boldType":0},
              {"info":"\n"},
              {"info":"--------------------------------------------------------------"},
              {"info":"\n"},
              {"info":"合计:6.66    ","boldType":0,"alignType":2},
              {"info":"\n","alignType":2},
              {"info":"--------------------------------------------------------------","alignType":1,"textSize":1,"boldType":0},
              {"info":"\n"},
              {"info":"电话：020-12345678"},
              {"info":"\n"},
              {"info":"地址：广州番禺大石镇河村工业路3号"},
              {"info":"\n"},
              {"info":"--------------谢谢惠顾！！欢迎下次光临--------------"},
              {"info":"\n"},
              {"info":"生成二维码的字符串","alignType":1,"qrCode":1},
              {"info":"\n"}];

   var data = JSON.stringify(printText);
   printInfo(data,"netPrinterPrintInfo");
 }

 //显示抽奖信息
 function disPlayInfo(msg){
    //将抽奖信息解析成对象
     var info = JSON.parse(msg);
//     logger("android返回的数据,lotteryNum="+info.lotteryNum);
 }

 function beginLottery() {

     logger("开始抽奖..");
//     document.getElementById("lottery").setAttribute("src", "");
//     window.WebViewJavascriptBridge.callHandler(
//         "beginLottery",
//         "nothing",
//         function (receivedData) {
////             logger("android返回的数据"+receivedData);
//             alert("android返回的数据"+receivedData);
//             disPlayInfo(receivedData);
//         });
 }

 function closeLottery() {

     var poem = [{"info": "spoilName": "卤蛋","spoilNo": 53},
 		{"info": "spoilName": "榨菜","spoilNo": 55},
         {"info": "spoilName": "榨菜","spoilNo": 55},
         {"info": "spoilName": "卤蛋","spoilNo": 54}];

    	var data = JSON.stringify(poem);

      logger("抽奖结束");
        window.WebViewJavascriptBridge.callHandler(
         "closeLottery",
         data,
         function (receivedData) {
             logger(receivedData);
         });

 }


function printInfo(data,type){
  window.WebViewJavascriptBridge.callHandler(
    type,
    data,
    function (receivedData) {
        var resultInfo = JSON.parse(receivedData);
        resultCode=resultInfo.resultCode;

          alert(resultCode)
          logger(resultCode);
    });
}
function logger(msg) {
    document.getElementById("logger").innerHTML = "ResponseData from Android --->" + msg;
}

