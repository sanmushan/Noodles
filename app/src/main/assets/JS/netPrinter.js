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

      var poem = [{"info":"" ,"spoilName": "卤蛋","spoilNo": 53},
  		{"info":"" , "spoilName": "榨菜","spoilNo": 55},
          {"info":"" , "spoilName": "榨菜","spoilNo": 55},
          {"info":"" , "spoilName": "卤蛋","spoilNo": 54}];

     	var data = JSON.stringify(poem);

       logger("抽奖结束");
         window.WebViewJavascriptBridge.callHandler(
          "closeLottery",
          data,
          function (receivedData) {
              logger(receivedData);
          });

  }


function logger(msg) {
    document.getElementById("logger").innerHTML = "ResponseData from Android --->" + msg;
}

