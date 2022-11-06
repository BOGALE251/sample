package com.example.demo1.model;

import com.example.demo1.Country;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotNull
    private String userName;

    @NotNull
    @Min(5)
    private int age;

    @NotNull
    @Pattern( regexp = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,4}\n", message = "invalid email")
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Country country;

    @Pattern( regexp = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,4}\n", message = "invalid password recovery email")
    private String passwordRecoveryEmail;

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Long getUserId() {
        return userId;
    }

    public int getAge() {
        return age;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordRecoveryEmail() {
        return passwordRecoveryEmail;
    }

    public void setPasswordRecoveryEmail(String passwordRecoveryEmail) {
        this.passwordRecoveryEmail = passwordRecoveryEmail;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
