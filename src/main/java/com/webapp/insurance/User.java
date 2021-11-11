package com.webapp.insurance;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, unique = true, length = 16)
  private String name;

  @Column(nullable = false, length = 256)
  private String password;

  @Column(nullable = false, unique = true, length = 45)
  private String email;

  
  public User(String name, String password, String email) {
    this.name = name;
    this.password = password;
    this.email = email;
  }

  public User() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)){
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) && Objects.equals(this.name, user.name) &&  Objects.equals(this.password, user.password) && Objects.equals(this.email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.password, this.email);
  }

  @Override
  public String toString() {
    return "User [email=" + email + ", id=" + id + ", name=" + name + ", password=" + password + "]";
  }


  
}