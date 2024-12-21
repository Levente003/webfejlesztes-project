package hu.unideb.inf.webproject_backend.service.dto;

import java.util.Objects;

public class UserDto {
    private String username;
    private String password;
    private String role;

    public UserDto() {
    }

    public UserDto(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(username, userDto.username) && Objects.equals(password, userDto.password) && Objects.equals(role, userDto.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, role);
    }
}
