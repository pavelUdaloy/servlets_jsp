package by.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private static int incId = 1;
    private int id = incId++;
    private String email;
    private String firstName;
    private String lastName;
    private String pass;
    private int age;
    private Role role=new Role("user");
    public void minusIncId(){
        incId--;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pass='" + pass + '\'' +
                ", age=" + age +
                ", role=" + role.getName() +
                '}';
    }
}
