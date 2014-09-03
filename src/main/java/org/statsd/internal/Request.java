/*
 * Request - request object
 * stores users request
 * @author - souravupadhyay
 */

package org.statsd.internal;

import java.io.Serializable;

public class Request implements Serializable {

  private MetricType metricType;
  private String prefix;
  private String key;
  private String value;
  private double sampling;

  public Request(MetricType metricType, String prefix, String key, String value) {
    this.setMetricType(metricType).setPrefix(prefix).setKey(key).setValue(value);
  }

  public Request(MetricType metricType, String prefix, String key, String value, double sampling) {
    this.setMetricType(metricType).setPrefix(prefix).setKey(key).setValue(value).setSampling(sampling);
  }

  public Request setMetricType(MetricType metricType) {
    this.metricType = metricType;
    return this;
  }

  public MetricType getMetricType() {
    return metricType;
  }

  public Request setPrefix(String prefix) {
    this.prefix = prefix;
    return this;
  }

  public String getPrefix() {
    return prefix;
  }

  public Request setKey(String key) {
    this.key = key;
    return this;
  }

  public String getKey() {
    return key;
  }

  public Request setValue(String value) {
    this.value = value;
    return this;
  }

  public String getValue() {
    return value;
  }

  public Request setSampling(double sampling) {
    this.sampling = sampling;
    return this;
  }

  public double getSampling() {
    return sampling;
  }

}
