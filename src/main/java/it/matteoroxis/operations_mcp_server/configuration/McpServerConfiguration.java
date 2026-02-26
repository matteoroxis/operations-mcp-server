package it.matteoroxis.operations_mcp_server.configuration;

import it.matteoroxis.operations_mcp_server.component.MonitoringTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpServerConfiguration {


    @Bean
    ToolCallbackProvider tools(MonitoringTools monitoringTools) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(monitoringTools)
                .build();
    }

}
