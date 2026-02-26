package it.matteoroxis.operations_mcp_server.model;

import java.time.Instant;

public record Incident(String id, String title, Instant timestamp, String status) {
}
