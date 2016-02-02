package app

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.eventbus.EventBus
import util.Runner

/**
 * Created by jonathan on 2016-01-29.
 */

class NewsServer extends AbstractVerticle{

    public static void main (String... args){
        Runner.runClusteredExample(NewsServer.class)
    }

    @Override
    public void start(Future<Void> future){
        println "starting server"
        EventBus eb = vertx.eventBus()
        // Send a message every second
        vertx.setPeriodic(1000, {
            eb.publish("news-feed", "Some news from Groovy!")
        })
        println "Ready to send news from Groovy!"
    }
}