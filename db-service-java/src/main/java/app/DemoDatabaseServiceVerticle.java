package app;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ProxyHelper;
import util.Runner;

public class DemoDatabaseServiceVerticle extends AbstractVerticle {

    DemoDatabaseService service;
    MessageConsumer<JsonObject> consumer;

    public static void main(String... args) {
        Runner.runHaExample(DemoDatabaseServiceVerticle.class);
    }

    @Override
    public void start(Future<Void> fut) {
        service = DemoDatabaseService.create(vertx);
        consumer = ProxyHelper.registerService(DemoDatabaseService.class, vertx, service, DemoDatabaseService.ADDRESS);

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        ProxyHelper.unregisterService(consumer);
    }
}
