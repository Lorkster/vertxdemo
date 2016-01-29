var Router = require('vertx-web-js/router');
var SockJSHandler = require('vertx-web-js/sock_js_handler');
var StaticHandler = require('vertx-web-js/static_handler');

// create a http router
var router = Router.router(vertx);

// Allow events for the designated addresses in/out of the event bus bridge
var opts = {
    inboundPermitteds:  [{address: 'news-feed'}],
    outboundPermitteds: [{address: 'news-feed'}]
};

// Create the event bus bridge and add it to the router.
router.route('/eventbus/*').handler(SockJSHandler.create(vertx).bridge(opts).handle);

// Serve the static resources
router.route().handler(StaticHandler.create().handle);

vertx.createHttpServer().requestHandler(router.accept).listen(8080);