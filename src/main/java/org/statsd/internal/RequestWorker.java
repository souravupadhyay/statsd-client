/*
 * RequestWorker - Worker thread that processes and sends requests to statsd server
 * @author - souravupadhyay
 */

package org.statsd.internal;

public class RequestWorker implements Runnable {

  private RequestQueue requestQueue;
  private Thread thread;

  public RequestWorker(RequestQueue requestQueue) {
    this.requestQueue = requestQueue;
    thread = new Thread(this);
    thread.start();
  }

  public void run() {
    Request request;
    while(true) {
      try {
        request = requestQueue.pop();
      } catch(Exception e) {
        // keep running
      }
    }
  }

}
