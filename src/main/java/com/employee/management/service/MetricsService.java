/*
 * package com.employee.management.service;
 * 
 * import io.micrometer.core.instrument.MeterRegistry; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * @Service public class MetricsService {
 * 
 * @Autowired private MeterRegistry meterRegistry;
 * 
 * public void recordHttpRequest(String endpoint) {
 * meterRegistry.counter("http_requests_total", "endpoint",
 * endpoint).increment(); }
 * 
 * public void recordError(String endpoint) {
 * meterRegistry.counter("http_errors_total", "endpoint", endpoint).increment();
 * }
 * 
 * public void recordEndpointHit(String endpoint) {
 * meterRegistry.counter("endpoint_hits_total", "endpoint",
 * endpoint).increment(); } }
 */