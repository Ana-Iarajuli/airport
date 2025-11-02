package com.solvd.airport.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionTaskThread implements Runnable {

    private static final Logger logger = LogManager.getLogger(ConnectionTaskThread.class);
    private final ConnectionPool pool;
    private final int taskId;

    public ConnectionTaskThread(ConnectionPool pool, int taskId) {
        this.pool = pool;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        Connection connection = null;
        try {
            connection = pool.getConnection();

            Account account = connection.create("Account " + taskId, 1000);
            Thread.sleep(500);

            connection.update(account.getId(), "Updated Account" + taskId + 1, 1300);
            Thread.sleep(500);

            logger.info("Task with " + taskId + " finished");
        } catch (InterruptedException e) {
            logger.error("Error (Interrupted): " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            if (connection != null) {
                pool.releaseConnection(connection);
            }
        }
    }

}
