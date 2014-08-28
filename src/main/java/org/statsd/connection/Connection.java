/*
 * Connection interface
 * @author - legolas
 */

package org.statsd.connection;

public interface Connection {

  public void send();
  public Object recieve();

}
