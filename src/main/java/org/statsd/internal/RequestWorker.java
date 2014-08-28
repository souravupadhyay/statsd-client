/*
 * RequestWorker - Worker thread that processes and sends requests to statsd server
 * @author - souravupadhyay
 */

package org.statsd.internal;

import org.statsd.connection.Connection;

public class RequestWorker implements Runnable {

  private RequestQueue requestQueue;
  private Connection connection;
  private Thread thread;

  public RequestWorker(RequestQueue requestQueue, Connection connection) {
    this.requestQueue = requestQueue;
    this.connection = connection;
    thread = new Thread(this);
    thread.start();
  }

  public void run() {
    Request request;
    while(true) {
      try {
        request = requestQueue.pop();
        String protocolString = request.getMetricType().getProtocolString(request.getKey(), request.getValue(), request.getSampling());
        connection.send(protocolString.getBytes());
      } catch(Exception e) {
        // keep running
      }
    }
  }

}
