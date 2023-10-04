package ru.drmteamdev.step_definition;

import com.github.javafaker.Faker;

public class Practice {

    String fakeEmail;
    String password;
    Faker faker = new Faker();

    public void initilizer(){

        fakeEmail = faker.name().name();
        password = faker.number().digits(4);

    }

    public static void main(String[] args) {

        Practice pr = new Practice();
        pr.initilizer();
        System.out.println(pr.password);
        System.out.println(pr.fakeEmail);
    }

}
