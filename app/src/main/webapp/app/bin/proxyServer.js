var http = require('http'),
    httpProxy = require('http-proxy')

//
// Create a proxy server with custom application logic
//
var proxy = httpProxy.createProxyServer({});

//
// Create your custom server and just call `proxy.web()` to proxy
// a web request to the target passed in the options
// also you can use `proxy.ws()` to proxy a websockets request
//
var server = http.createServer(function(req, res) {
    // You can define here your custom logic to handle the request
    // and then proxy the request.

    console.log(req.url);
    var re = /.*\/api.*/;
    if(req.url.match(re)) {
        console.log(req.url + " connect to 127.0.0.1:8102");
        proxy.web(req, res, { target: 'http://localhost:8102'});
    }else{
        console.log(req.url + " connect to 127.0.0.1:8102");
        proxy.web(req, res, { target: 'http://127.0.0.1:8101'});
    }
});

server.listen(8100);
