package com.dentist.patient.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Primary key")
    private Long id;

    @Column(name = "first_name", nullable = false)
    @ApiModelProperty(notes = "User first name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @ApiModelProperty(notes = "User last name")
    private String lastName;

    @Column(name = "username", nullable = false)
    @ApiModelProperty(notes = "User's username")
    private String username;

    @Column(name = "password", nullable = false)
    @ApiModelProperty(notes = "User's password")
    private String password;

    @Column(name = "role", nullable = false)
    @ApiModelProperty(notes = "User role'")
    private String role;

    @Column(name = "enabled", nullable = false)
    @ApiModelProperty(notes = "Is the user enabled")
    private int enabled;

    /**
     * Constructors, getters and setters
     */
    public User() {

    }

    public User(String firstName, String lastName, String username, String password, String role,
                int enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}