package GU.Java.chat.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {
    public Optional<User> getAuth(String login, String password) {
        Connection connection = DBConnection.getInstance();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id, login, name, password FROM users WHERE login = ? AND password = ?"
            );
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                return Optional.of(
                        new User(
                                result.getInt("id"),
                                result.getString("login"),
                                result.getString("name"),
                                result.getString("password")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
