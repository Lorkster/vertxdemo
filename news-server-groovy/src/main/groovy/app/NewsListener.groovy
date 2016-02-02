package main.groovy.app

import io.vertx.core.AbstractVerticle
import io.vertx.core.eventbus.EventBus
import main.groovy.util.Runner

/**
 * Created by jonathan on 2016-02-01.
 */

class NewsListener extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runClusteredExample(NewsListener.class)
    }

    @Override
    public void start() {
        println("Starting")
        EventBus eb = vertx.eventBus();
        eb.consumer("news-feed", { message ->
            println("I have received a message: ${message.body()}")
        })
    }

    @Override
    public void stop() {
        println("Stopping")
    }
}