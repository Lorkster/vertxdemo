package app;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.serviceproxy.ProxyHelper;
import util.Runner;

public class DemoDatabaseServiceVerticle extends AbstractVerticle {

    DemoDatabaseService service;

    public static void main(String... args) {
        Runner.runClusteredExample(DemoDatabaseServiceVerticle.class);
    }

    @Override
    public void start(Future<Void> fut) {
        service = new DemoDatabaseServiceImpl(vertx);
        ProxyHelper.registerService(DemoDatabaseService.class, vertx, service, DemoDatabaseService.ADDRESS);

    }
}
