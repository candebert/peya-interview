package http

import io.vertx.core.Vertx
import io.vertx.ext.web.Router

object Routes {

    fun register() {
        val vertx = Vertx.vertx()
        val server = vertx.createHttpServer()
        val router = Router.router(vertx)
        router.route("/health").handler { routingContext -> routingContext.response().end("It's alive!") }
        server.requestHandler(router).listen(8080)
    }

}
