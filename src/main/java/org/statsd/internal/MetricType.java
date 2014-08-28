/*
 * MetricType - enumeration that defines various types of metrices supported by statsd
 * @author - souravupadhyay
 */

package org.statsd.internal;

public enum MetricType {

  COUNTING() {
  },
  TIMING() {
  },
  GAUGES() {
  },
  SETS() {
  };

  //public abstract String getProtocolString();

}
