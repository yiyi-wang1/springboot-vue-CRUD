package com.example.yiyi.javaspringbootdemo.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    public int id;

    public String name;
    public String email;
    public String password;

}
