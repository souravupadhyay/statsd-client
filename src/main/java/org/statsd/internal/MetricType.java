/*
 * MetricType - enumeration that defines various types of metrices supported by statsd
 * @author - souravupadhyay
 */

package org.statsd.internal;

public enum MetricType {

  COUNTING("c"),
  TIMING("ms"),
  GAUGES("g"),
  SETS("s");

  private String type;

  private MetricType(String type) {
    this.type = type;
  }

  public String getProtocolString(String key, int value, float sampling) {
    StringBuilder stringBuilder = new StringBuilder(key);
    stringBuilder.append(":");
    stringBuilder.append(value);
    stringBuilder.append("|");
    stringBuilder.append(this.type);
    if(sampling != 0.0f) {
      stringBuilder.append("|@");
      stringBuilder.append(sampling);
    }
    return stringBuilder.toString();
  }

}
