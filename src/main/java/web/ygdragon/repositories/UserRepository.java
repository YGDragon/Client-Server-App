package web.ygdragon.repositories;

import org.springframework.jdbc.core.RowMapper;
import web.ygdragon.model.User;

import java.util.List;

public interface UserRepository {
    // Mapper, превращающий строку из таблицы БД в объект класса User
    RowMapper<User> ROW_MAPPER = (resultSet, rowNum) -> {
        User user = new User();
        user.setId(
                resultSet.getInt("id")
        );
        user.setFirstName(
                resultSet.getString("firstName")
        );
        user.setLastName(
                resultSet.getString("lastName")
        );
        return user;
    };

    void create(User user);

    void update(User user);

    List<User> read();

    void delete(int id);
}
