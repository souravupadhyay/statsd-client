/*
 * AsyncStatsDClient - client singleton class for statsD
 * @author - souravupadhyay
 */

package org.statsd;

import java.util.Deque;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.statsd.connection.Connection;
import org.statsd.connection.UDPConnection;
import org.statsd.internal.MetricType;
import org.statsd.internal.Request;
import org.statsd.internal.RequestQueue;
import org.statsd.internal.RequestWorker;

public class AsyncStatsDClient implements StatsDClient {

  private String prefix;
  private Connection connection;
  private RequestQueue requestQueue;
  private RequestWorker requestWorker;

  public AsyncStatsDClient(String prefix, String host, int port) throws UnknownHostException, SocketException {
    this.prefix = prefix;
    this.connection = new UDPConnection(host, port);
    this.requestQueue = new RequestQueue();
    this.requestWorker = new RequestWorker(this.requestQueue, this.connection);
  }

  public AsyncStatsDClient(String prefix, String host, int port, long queueSize) throws UnknownHostException, SocketException {
    if(queueSize <= 0) {
      throw new IllegalArgumentException("'queueSize' cannot be non-positive");
    }
    this.prefix = prefix;
    this.connection = new UDPConnection(host, port);
    this.requestQueue = new RequestQueue(queueSize);
    this.requestWorker = new RequestWorker(this.requestQueue, this.connection);
  }

  @Override
  public void count(String key, long delta) {
    Request request = new Request(MetricType.COUNTING, prefix, key, Long.toString(delta));
    this.requestQueue.push(request);
  }

  @Override
  public void count(String key, long delta, double sampleRate) {
    Request request = new Request(MetricType.COUNTING, prefix, key, Long.toString(delta), sampleRate);
    this.requestQueue.push(request);
  }

  @Override
  public void increment(String key) {
    count(key, 1);
  }

  @Override
  public void decrement(String key) {
    count(key, -1);
  }

  @Override
  public void gauge(String key, long value) {
    Request request = new Request(MetricType.GAUGES, prefix, key, Long.toString(value));
    this.requestQueue.push(request);
  }

  @Override
  public void gauge(String key, double value) {
    Request request = new Request(MetricType.GAUGES, prefix, key, Double.toString(value));
    this.requestQueue.push(request);
  }

  @Override
  public void set(String key, String event) {
    Request request = new Request(MetricType.SETS, prefix, key, event);
    this.requestQueue.push(request);
  }

  @Override
  public void recordTime(String key, long timeInMs) {
    Request request = new Request(MetricType.TIMING, prefix, key, Long.toString(timeInMs));
    this.requestQueue.push(request);
  }

  @Override
  public void recordTime(String key, long timeInMs, double sampleRate) {
    Request request = new Request(MetricType.TIMING, prefix, key, Long.toString(timeInMs), sampleRate);
    this.requestQueue.push(request);
  }

}
