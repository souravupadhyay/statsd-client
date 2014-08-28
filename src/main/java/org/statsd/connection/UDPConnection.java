/*
 * UDPConnection - implements Connection
 * @author - souravupadhyay
 */

package org.statsd.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class UDPConnection implements Connection {

  private String host;
  private int port;
  private int packetSize;
  private InetAddress hostAddress;
  private DatagramSocket socket;

  public UDPConnection(String host, int port) throws UnknownHostException, SocketException {
    this.host = host;
    this.port = port;
    this.packetSize = 1024;
    this.hostAddress = InetAddress.getByName(host);
    this.socket = new DatagramSocket();
  }

  public void setPacketSize(int packetSize) {
    this.packetSize = packetSize;
  }

  public void send(byte[] data) throws IOException {
    DatagramPacket packet = new DatagramPacket(data, data.length, hostAddress, port);
    socket.send(packet);
  }

  public byte[] receive() throws IOException {
    byte[] data = new byte[packetSize];
    DatagramPacket packet = new DatagramPacket(data, data.length);
    socket.receive(packet);
    return data;
  }

  protected void finalize() throws Throwable {
    socket.close();
  }

}
