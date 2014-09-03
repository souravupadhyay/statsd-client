/*
 * RequestQueue - queue to store all requests to be processed later
 * @author - souravupadhyay
 */

package org.statsd.internal;

import java.util.Deque;
import java.util.ArrayDeque;

public class RequestQueue {

  private long queueSize;
  private Deque<Request> queue;

  public RequestQueue() {
    queue = new ArrayDeque<Request>();
  }

  public RequestQueue(long queueSize) {
    this.queueSize = queueSize;
    queue = new ArrayDeque<Request>();
  }

  public synchronized void push(Request request) {
    if(queue.size() >= queueSize)
      pop();
    queue.push(request);
  }

  public synchronized Request pop() {
    return queue.pop();
  }

}
