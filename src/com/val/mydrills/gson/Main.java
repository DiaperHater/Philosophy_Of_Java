package com.val.mydrills.gson;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        serializeSimpleUser();

        deserializeSimpleUser();

    }

    private static void serializeSimpleUser() {
        SimpleUser user = new SimpleUser(
                "Valery Pronin",
                "valone100@gami.com",
                29,
                true
        );

        Gson gson = new Gson();
        String json = gson.toJson(user);
    }

    private static void deserializeSimpleUser() {
        String userJson = "{ 'name': 'valery', 'mail': 'valone100@gamil.com', 'age': 29, 'isDeveloper': true }";

        Gson gson = new Gson();
        SimpleUser simpleUser = gson.fromJson(userJson, SimpleUser.class);

    }
}
