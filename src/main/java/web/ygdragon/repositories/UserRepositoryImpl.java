package web.ygdragon.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import web.ygdragon.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbc;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /* Добавление записи о пользователе в таблицу БД */
    @Override
    public void create(User user) {
        jdbc.update(
                "INSERT INTO userTable VALUES (NULL, ?, ?)",
                user.getFirstName(), user.getLastName());
    }

    /* Получение списка всех пользователей из таблицы БД */
    @Override
    public List<User> read() {
        return jdbc.query(
                "SELECT * FROM userTable",
                ROW_MAPPER
        );
    }

    /* Обновление записи о пользователе в таблице БД */
    @Override
    public void update(User user) {
        jdbc.update(
                "UPDATE userTable SET firstName=?, lastName=? WHERE id=?",
                user.getFirstName(), user.getLastName(), user.getId());
    }

    /* Удаление записи о пользователе из таблицы БД по ID */
    @Override
    public void delete(int id) {
        jdbc.update(
                "DELETE FROM userTable WHERE id=?",
                id);
    }

}
