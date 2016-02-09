require 'vertx/vertx'
options = {
    'haEnabled' => true
}
Vertx::Vertx.clustered_vertx(options) { |res_err,res|
  if (res_err == nil)
    vertx = res
    eventBus = vertx.event_bus()
    puts "Ready to send news from Ruby!"

    # Send a message every second
    vertx.set_periodic(1000) { |v|
      eventBus.publish("news-feed", "Some news from Ruby!")
    }
  else
    puts "Failed: #{res_err}"
  end
}