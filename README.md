statsd-client
=============

Thin async java client for etsy/statsd
https://github.com/etsy/statsd
Provides limited queue size, after which old metrices are flushed.

Usage
=====

```
StatsDClient statsdClient = new AsyncStatsDClient("my.prefix", "localhost", 9483);
StatsDClient statsdClient = new AsyncStatsDClient("my.prefix", "localhost", 9483, 200); // 200 = queue size
```

Methods available
-----------------

All methods listed src/main/java/org/statsd/StatsDClient.java interface
