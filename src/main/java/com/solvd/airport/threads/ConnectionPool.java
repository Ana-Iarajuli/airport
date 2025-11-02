package com.solvd.airport.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;
    private final BlockingQueue<Connection> connections;
    private final int poolSize;

    private ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        this.connections = new LinkedBlockingQueue<>(poolSize);
        initializePool();
    }

    public static ConnectionPool getInstance(int poolSize) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(poolSize);
                }
            }
        }
        return instance;
    }

    private void initializePool() {
        for (int i = 0; i < poolSize; i++) {
            connections.offer(new Connection("Connectionn: " + i));
        }
    }

    public Connection getConnection() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        logger.info("This thread is trying to get a connection: " + threadName);
        Connection connection = connections.take();
        logger.info(threadName + " got a connection: " + connection.getName());

        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            connections.offer(connection);
            String ThreadName = Thread.currentThread().getName();
            logger.info(ThreadName + " released " + connection.getName());
        }
    }

    public int availableConnections() {
        return connections.size();
    }
}
