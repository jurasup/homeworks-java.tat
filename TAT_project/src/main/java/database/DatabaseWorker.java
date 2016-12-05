package database;

import util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Provides functionality for adding and deleting users in database.
 * @author Yury Suponev
 */
public class DatabaseWorker {
    private ConnectionManager connectionManager = new ConnectionManager();

    public void addUser(User user) {
        Connection connection = connectionManager.openConnection();
        StatementBuilder statementBuilder = new StatementBuilder(connection);
        try {
            connection.createStatement().executeUpdate(statementBuilder.getInsertUserQuery(user));
            for (Map.Entry<String, String> entry : user.getMeta().entrySet()) {
                connection.createStatement().
                            executeUpdate(statementBuilder.
                                    getInsertMetaQuery(user.getID(), entry.getKey(), entry.getValue()));
            }
        } catch (SQLException e) {
            System.out.println("Can't add user.");
        }
        connectionManager.closeConnection(connection);
    }

    public void deleteUser(long userID) {
        Connection connection = connectionManager.openConnection();
        StatementBuilder statementBuilder = new StatementBuilder(connection);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(statementBuilder.getDeleteUserQuery(userID));
            statement.executeUpdate(statementBuilder.getDeleteMetaQuery(userID));
        } catch (SQLException e) {
            System.out.println("Can't delete user.");
        }
        connectionManager.closeConnection(connection);
    }
}
