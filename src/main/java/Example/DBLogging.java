package Example;

public interface DBLogging {
    String MONGO_DB_NAME = "ABC_Mongo_Datastore";
    String NEO4J_DB_NAME = "ABC_Neo4J_Datastore";
    String CASSANDRA_DB_NAME = "ABC_Cassandra_Datastore";

    default void logInfo(String message) {
        log(message, "INFO");
    }

    default void logWarn(String message) {
        log(message, "WARN");
    }

    default void logError(String message) {
        log(message, "ERROR");
    }

    default void logFatal(String message) {
        log(message, "FATAL");
    }

    default void log(String message, String msgPrefix) {
        // Step 1: Connect to DataStore
        // Step 2: Log Message with Prefix and styles etc.
        // Step 3: Close the DataStore connection
    }
    // Any other abstract, static, default methods
}