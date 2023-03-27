package by.itacademy.it_bootcamp.dto;

import by.itacademy.it_bootcamp.entity.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * UserDto
 *
 * @author Aliaksandr Hryharovich
 * @version 25.03.2023
 */


public class UserDto implements Serializable {
    private Long id;

    @Size(min = 1, max = 20, message = "20 latin letters")
    @Pattern(regexp = "[a-zA-Z]*", message = "Only latin letters")
    private String fullName;

    @Size(min = 1, max = 40, message = "40 latin letters")
    @Pattern(regexp = "[a-zA-Z]*", message = "Only latin letters")
    private String surName;

    @Size(min = 1, max = 40, message = "40 latin letters")
    @Pattern(regexp = "[a-zA-Z]*", message = "Only latin letters")
    private String patronymic;
    @Email(message = "standard pattern")
    @Size(min = 1, max = 50, message = "50 latin letters")
    private String email;
    private Role role;

    public UserDto(final Long id, final String fullName, final String surName,
                   final String patronymic, final String email, final Role role) {
        this.id = id;
        this.fullName = fullName;
        this.surName = surName;
        this.patronymic = patronymic;
        this.email = email;
        this.role = role;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSurName() {
        return surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final UserDto userDto;

        public Builder() {
            userDto = new UserDto();
        }

        public Builder id(final Long id) {
            userDto.setId(id);
            return this;
        }

        public Builder fullName(final String fullName) {
            userDto.setFullName(fullName);
            return this;
        }

        public Builder surName(final String surName) {
            userDto.setSurName(surName);
            return this;
        }

        public Builder patronymic(final String patronymic) {
            userDto.setPatronymic(patronymic);
            return this;
        }

        public Builder email(final String email) {
            userDto.setEmail(email);
            return this;
        }

        public Builder role(final Role role) {
            userDto.setRole(role);
            return this;
        }

        public UserDto build() {
            return userDto;
        }
    }
}
