require "vertx/vertx"
include Vertx

puts("Ready to send news from Ruby!")
$vertx::set_periodic(1000) do
  eventBus = $vertx.event_bus()
  eventBus.publish("news-feed", "News from Ruby!")
end