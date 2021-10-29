package com.datastructure.vector;

import java.util.Scanner;

public class UserListPlayground {

    public static void main(String[] args) {

        //create variables
        Scanner scan = new Scanner(System.in);

        //create vector with capacity of 20
        List<Contact> list = new List<Contact>(20);

        //create and add 30 contacts to this list
        createContact(5, list);

        //create a menu so user can choose an option

    }

    private static int menu(Scanner scan) {
        //TODO: use all the options for list
        return 0;
    }

    private static void createContact(int quantity, List<Contact> list) {
        Contact contact;

        for (int i = 0; i <= quantity; i++) {
            contact = new Contact();
            contact.setName("Contact" + i);
            contact.setPhone("1" + i);
            contact.setEmail("email" + i + "@gmail.com");

            list.addElementGoodWay(contact);
        }
    }
}
