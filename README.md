statsd-client
=============

Thin async java client for etsy/statsd
https://github.com/etsy/statsd

Provides limited queue size, after which old metrices are flushed.

Usage
=====

```
// constructors
AsyncStatsDClient(String prefix, String host, int port); // throws UnknownHostException, SocketException
AsyncStatsDClient(String prefix, String host, int port, long queueSize); // throws UnknownHostException, SocketException, IllegalArgumentException
// usage
StatsDClient statsdClient = new AsyncStatsDClient("my.prefix", "localhost", 9483);
StatsDClient statsdClient = new AsyncStatsDClient("my.prefix", "localhost", 9483, 200); // 200 = queue size
```

Methods available
-----------------

All methods listed src/main/java/org/statsd/StatsDClient.java interface

Documentation pending
