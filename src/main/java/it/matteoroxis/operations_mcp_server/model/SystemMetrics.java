package it.matteoroxis.operations_mcp_server.model;

import java.time.Instant;

public record SystemMetrics(int avgLatencyMs, double errorRate, Instant timestamp){}
