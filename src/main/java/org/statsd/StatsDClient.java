/*
 * StatsDClient - client singleton class for statsD
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

public class StatsDClient {

  private Connection connection;
  private RequestQueue requestQueue;
  private RequestWorker requestWorker;

  public StatsDClient(String host, int port) throws UnknownHostException, SocketException {
    this.connection = new UDPConnection(host, port);
    this.requestQueue = new RequestQueue();
    this.requestWorker = new RequestWorker(this.requestQueue, this.connection);
  }

  public void count(String key, int value, float sampling) {
    Request request = new Request(MetricType.COUNTING, key, value, sampling);
    this.requestQueue.push(request);
  }

  public void timing(String key, int value, float sampling) {
    Request request = new Request(MetricType.TIMING, key, value, sampling);
    this.requestQueue.push(request);
  }

  public void gauge(String key, int value, float sampling) {
    Request request = new Request(MetricType.GAUGES, key, value, sampling);
    this.requestQueue.push(request);
  }

  public void set(String key, int value, float sampling) {
    Request request = new Request(MetricType.SETS, key, value, sampling);
    this.requestQueue.push(request);
  }

}
