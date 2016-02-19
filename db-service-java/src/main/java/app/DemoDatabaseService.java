package app;

import io.vertx.codegen.annotations.ProxyClose;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

@ProxyGen
public interface DemoDatabaseService {
    String ADDRESS = "demo-db-service";
    // A couple of factory methods to create an instance and a proxy
    static DemoDatabaseService create(Vertx vertx) {
        return new DemoDatabaseServiceImpl(vertx);
    }

    static DemoDatabaseService createProxy(Vertx vertx,
                                           String address) {
        return new DemoDatabaseServiceVertxEBProxy(vertx, address);
    }

    // Actual service operations here...
    void save(String collection, JsonObject document,
              Handler<AsyncResult<Void>> resultHandler);

    @ProxyClose
    void close();
}
