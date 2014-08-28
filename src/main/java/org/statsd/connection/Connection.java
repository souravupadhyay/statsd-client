/*
 * Connection interface
 * @author - souravupadhyay
 */

package org.statsd.connection;

import java.io.IOException;

public interface Connection {

  public void send(byte[] data) throws IOException;
  public byte[] receive() throws IOException;

}
