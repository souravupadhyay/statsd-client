/*
 * StatsDClient - Interface that defines client functionality
 * @author - souravupadhay
 */

package org.statsd;

public interface StatsDClient {

  public void count(String key, long delta);

  public void count(String key, long delta, double sampleRate);

  public void increment(String key);

  public void decrement(String key);

  public void gauge(String key, long value);

  public void gauge(String key, double value);

  public void set(String key, String event);

  public void recordTime(String key, long timeInMs);

  public void recordTime(String key, long timeInMs, double sampleRate);

}
