function connectWebViewJavascriptBridge(callback) {
    if (window.WebViewJavascriptBridge) {
        callback(WebViewJavascriptBridge)
    } else {
        document.addEventListener(
            'WebViewJavascriptBridgeReady'
            , function () {
                callback(WebViewJavascriptBridge)
            },
            false
        );
    }
}

connectWebViewJavascriptBridge(function (bridge) {
    bridge.init(function (message, responseCallback) {
        responseCallback(data);
    });
    bridge.registerHandler("functionInJs", function (data, responseCallback) {
//        document.getElementById("logger").innerHTML = ("data from Java: = " + data);
        var responseData = "show success";
        responseCallback(data);
    });
//    readIdInfo();
})

