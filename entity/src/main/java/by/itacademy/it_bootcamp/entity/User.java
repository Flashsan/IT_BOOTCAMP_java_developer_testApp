package by.itacademy.it_bootcamp.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * User entity
 *
 * @author Aliaksandr Hryharovich
 * @version 25.03.2023
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "user_full_name", length = 40)
    private String userFullName;

    @Column(name = "user_surname", length = 40)
    private String userSurname;

    @Column(name = "user_patronymic", length = 40)
    private String userPatronymic;

    @Column(name = "user_email", length = 50)
    private String userEmail;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Role userRole;

    public User() {
    }

    public User(Long userId, String userFullName, String userSurname, String userPatronymic, String userEmail, Role userRole) {
        this.userId = userId;
        this.userFullName = userFullName;
        this.userSurname = userSurname;
        this.userPatronymic = userPatronymic;
        this.userEmail = userEmail;
        this.userRole = userRole;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPatronymic() {
        return userPatronymic;
    }

    public void setUserPatronymic(String userPatronymic) {
        this.userPatronymic = userPatronymic;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final User user;

        public Builder() {
            user = new User();
        }

        public Builder userId(final Long userId){
            user.setUserId(userId);
            return this;
        }
        public Builder userFullName(final String userFullName){
            user.setUserFullName(userFullName);
            return this;
        }

        public Builder userSurname(final String userSurname){
            user.setUserSurname(userSurname);
            return this;
        }

        public Builder userPatronymic(final String userPatronymic){
            user.setUserPatronymic(userPatronymic);
            return this;
        }

        public Builder userEmail(final String userEmail){
            user.setUserEmail(userEmail);
            return this;
        }

        public Builder userRole(final Role userRole){
            user.setUserRole(userRole);
            return this;
        }

        public User build(){
            return user;
        }
    }

}
