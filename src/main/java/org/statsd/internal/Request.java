/*
 * Request - request object
 * stores users request
 * @author - souravupadhyay
 */

package org.statsd.internal;

import java.io.Serializable;

public class Request implements Serializable {

  private MetricType metricType;
  private String key;
  private int value;
  private float sampling;

  public Request() {
  }

  public Request(MetricType metricType, String key, int value, float sampling) {
    this.setMetricType(metricType).setKey(key).setValue(value).setSampling(sampling);
  }

  public Request setMetricType(MetricType metricType) {
    this.metricType = metricType;
    return this;
  }

  public MetricType getMetricType() {
    return metricType;
  }

  public Request setKey(String key) {
    this.key = key;
    return this;
  }

  public String getKey() {
    return key;
  }

  public Request setValue(int value) {
    this.value = value;
    return this;
  }

  public int getValue() {
    return value;
  }

  public Request setSampling(float sampling) {
    this.sampling = sampling;
    return this;
  }

  public float getSampling() {
    return sampling;
  }

}
