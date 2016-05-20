package com.kevin.common.utils.uuid;

import java.util.UUID;

public class UuidTest {

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        System.out.println(UUID.randomUUID());
    }
}


