package app;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import util.Runner;

public class NewsServer extends AbstractVerticle {

    public static void main(String... args) {
        Runner.runClusteredExample(NewsServer.class);
    }

    @Override
    public void start(Future<Void> fut) {
        EventBus eb = vertx.eventBus();
        // Send a message every second
        System.out.println("Ready to send news from JAVA!");
        vertx.setPeriodic(1000, v -> eb.publish("news-feed", "Some news from JAVA!"));
    }
}
