# Operations MCP Server

Un **Enterprise Operations Assistant** costruito con MCP (Model Context Protocol), Java e Spring Boot.

## 🚀 Caratteristiche

Questo server MCP espone tool per il monitoraggio delle operazioni enterprise:

- **getSystemMetrics** - Recupera metriche di sistema in tempo reale (latenza, tasso di errore, timestamp)
- **getRecentIncidents** - Recupera la lista degli incidenti recenti con dettagli completi

## 📋 Prerequisiti

- Java 25 o superiore
- Maven 3.6+ (incluso Maven Wrapper)

## 🔧 Setup Rapido

### Windows

```powershell
# Esegui lo script batch per compilare e avviare
.\run.bat
```

### Linux/macOS

```bash
# Compila
./mvnw clean package

# Esegui
./mvnw spring-boot:run
```

## 🛠️ Tool Disponibili

### 1. getSystemMetrics
Recupera le metriche di sistema correnti.

**Output esempio:**
```json
{
  "avgLatencyMs": 120,
  "errorRate": 0.02,
  "timestamp": "2026-02-11T10:30:00Z"
}
```

### 2. getRecentIncidents
Recupera gli incidenti recenti del sistema.

**Output esempio:**
```json
[
  {
    "id": "INC-42",
    "title": "Database latency spike",
    "timestamp": "2026-02-11T09:30:00Z",
    "status": "Resolved"
  },
  {
    "id": "INC-43",
    "title": "Cache eviction anomaly",
    "timestamp": "2026-02-11T08:30:00Z",
    "status": "Investigating"
  }
]
```

## 🔌 Integrazione con Claude Desktop

Aggiungi questa configurazione al file di configurazione di Claude:

**Windows:** `%APPDATA%\Claude\claude_desktop_config.json`

**macOS/Linux:** `~/Library/Application Support/Claude/claude_desktop_config.json`

```json
{
  "mcpServers": {
    "operations-mcp-server": {
      "command": "java",
      "args": [
        "-jar",
        "/percorso/completo/al/operations-mcp-server/target/operations-mcp-server-0.0.1-SNAPSHOT.jar"
      ]
    }
  }
}
```

Riavvia Claude Desktop per attivare i tool.

## 📚 Documentazione

Per maggiori dettagli, consulta [USAGE.md](USAGE.md).

## 🏗️ Struttura del Progetto

```
operations-mcp-server/
├── src/main/java/it/matteoroxis/operations_mcp_server/
│   ├── OperationsMcpServerApplication.java    # Main application
│   ├── component/
│   │   └── MonitoringTools.java               # Tool MCP implementati
│   ├── configuration/
│   │   └── McpServerConfiguration.java        # Configurazione MCP
│   └── model/
│       ├── Incident.java                      # Modello Incident
│       └── SystemMetrics.java                 # Modello SystemMetrics
└── src/main/resources/
    └── application.properties                 # Configurazione Spring
```

## 🔑 Tecnologie Utilizzate

- **Spring Boot 3.5.10** - Framework applicativo
- **Spring AI 1.1.2** - Integrazione MCP Server
- **Java 25** - Linguaggio di programmazione
- **Maven** - Build tool

## 📝 Licenza

Questo progetto è fornito "as-is" senza alcuna garanzia.
