package app;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import util.Runner;

public class NewsListener extends AbstractVerticle {
    // Convenience method so you can run it in your IDE
    public static void main(String[] args) {
        Runner.runClusteredExample(NewsListener.class);
    }


    @Override
    public void start() throws Exception {

        EventBus eb = vertx.eventBus();

        eb.consumer("news-feed", message -> System.out.println("Received news: " + message.body()));

        System.out.println("Ready!");
    }

}
