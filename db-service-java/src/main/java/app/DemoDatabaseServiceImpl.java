package app;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class DemoDatabaseServiceImpl implements DemoDatabaseService {
    public DemoDatabaseServiceImpl(Vertx vertx) {
    }

    @Override
    public void save(String collection, JsonObject document, Handler<AsyncResult<Void>> resultHandler) {
        System.out.println("Service got: " + document.encodePrettily());
        if (resultHandler != null) {
            resultHandler.handle(Future.succeededFuture());
        }
    }
}
