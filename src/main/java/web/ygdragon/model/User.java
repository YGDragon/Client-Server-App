package web.ygdragon.model;

import java.util.Objects;

public class User {
    private int id;
    private String firstName;
    private String lastName;

    //region Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //endregion
    //region Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                && Objects.equals(firstName, user.getFirstName())
                && Objects.equals(lastName, user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
