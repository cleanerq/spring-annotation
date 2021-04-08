package com.qby.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author qby
 * @date 2020/6/9 11:07
 */
public class Person {

//    @Value("张三")
    private String name;
//    @Value("#{20-2}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Person() {
    }
}
