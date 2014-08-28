statsd-client
=============

Thin async java client for etsy/statsd
https://github.com/etsy/statsd

Usage
=====

```
StatsDClient statsdClient = new StatsDClient("localhost", 9483);
statsdClient.count("xxx.product.sold", 1);
```

Methods available
-----------------
```
count(String key, int value, float sampling);
count(String key, int value);
timing(String key, int value, float sampling);
timing(String key, int value);
gauge(String key, int value, float sampling);
gauge(String key, int value);
set(String key, int value, float sampling);
set(String key, int value);
```
