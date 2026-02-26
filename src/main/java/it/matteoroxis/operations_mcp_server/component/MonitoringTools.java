package it.matteoroxis.operations_mcp_server.component;

import it.matteoroxis.operations_mcp_server.model.Incident;
import it.matteoroxis.operations_mcp_server.model.SystemMetrics;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class MonitoringTools {


    @Tool(description = "Retrieve current system metrics including response time, error rate and timestamp")
    public SystemMetrics getSystemMetrics() {
        return new SystemMetrics(120,0.02, Instant.now());
    }

    @Tool(description = "Retrieve list of recent incidents with their ID, description, timestamp and status")
    public List<Incident> getRecentIncidents() {
        return List.of(
                new Incident("INC-42","Database latency spike", Instant.now().minusSeconds(3600), "Resolved"),
                new Incident("INC-43","Cache eviction anomaly", Instant.now().minusSeconds(7200), "Investigating")
        );
    }
}
