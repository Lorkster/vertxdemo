package app;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ProxyHelper;
import util.Runner;

public class NewsServer extends AbstractVerticle {

    DemoDatabaseService service;

    public static void main(String... args) {
        Runner.runClusteredExample(NewsServer.class);
    }

    @Override
    public void start(Future<Void> fut) {
        service = ProxyHelper.createProxy(DemoDatabaseService.class, vertx, DemoDatabaseService.ADDRESS);
        EventBus eb = vertx.eventBus();
        // Send a message every second
        System.out.println("Ready to send news from JAVA!");
        vertx.setPeriodic(1000, v ->
        {
            eb.publish("news-feed", "Some news from JAVA!");

            //Demonstrating calling another service that's located either locally or remotely. Calls will be transferred
            //over the event bus as will the asynchronous reply
            service.save("blablah", new JsonObject().put("event", "Saving news from JAVA!"), r -> {
                if (r.succeeded()) {
                    System.out.printf("Success in calling DemoDatabaseService at time %d%n", System.currentTimeMillis());
                } else {
                    System.err.printf("Failed in calling DemoDatabaseService due to: %s%n", r.cause());

                }
            });
        });
    }
}
