function logger(msg) {
    document.getElementById("logger").innerHTML = "ResponseData from Android --->" + msg;
}
 //显示抽奖信息
 function disPlayInfo(msg){
    //将抽奖信息解析成对象
     var info = JSON.parse(msg);
//     logger("android返回的数据,lotteryNum="+info.lotteryNum);
 }

function beginLottery() {

//      logger("开始抽奖..");
//      document.getElementById("lottery").setAttribute("src", "");
      window.WebViewJavascriptBridge.callHandler(
          "beginLottery",
          "nothing",
          function (receivedData) {
//              logger("android返回的数据"+receivedData);
              alert("android返回的数据"+receivedData);
              disPlayInfo(receivedData);
          });
  }

function closeLottery() {

  var poem = [{"spoilName": "卤蛋","spoilNo": "53"},
      {"spoilName": "榨菜","spoilNo": "55"},
      {"spoilName": "榨菜","spoilNo": "55"},
      {"spoilName": "卤蛋","spoilNo": "54"}];

    var data = JSON.stringify(poem);

//   logger("抽奖结束");
     window.WebViewJavascriptBridge.callHandler(
      "closeLottery",
      data,
      function (receivedData) {
//          logger(receivedData);
      });

}

function closeLotteryTwo() {

  var poem = [{"spoilName": "卤蛋","spoilNo": "53"},
      {"spoilName": "榨菜","spoilNo": "55"}];

    var data = JSON.stringify(poem);

//   logger("抽奖结束");
     window.WebViewJavascriptBridge.callHandler(
      "closeLottery",
      data,
      function (receivedData) {
//          logger(receivedData);
      });

}