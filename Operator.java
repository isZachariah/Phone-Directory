// Programmer: Zachariah Magee
// Class: CS 145
// Assignment: Linked List Phonebook
// Date: July 19, 2022

import java.util.Scanner;

public class Operator {
    Scanner input = new Scanner(System.in);
    boolean run = true;
    LinkedList list = new LinkedList();

    public Operator() {
        demoContacts();
        do {
            run = runProgram();
        } while(run);
    } // end operator

    public void save() {
        System.out.println("Create a new contact: ");
        System.out.print("Name: ");
        String[] name = input.nextLine().split(" ");
        String firstName = name[0]; String lastName = name[1];
        System.out.println("Please Input Phone number in format: 555-555-5555");
        System.out.print("Phone Number: ");
        String phone = input.nextLine();
        System.out.print("Address (Street and Number): ");
        String address = input.nextLine();
        System.out.print("City: ");
        String city = input.nextLine();
        System.out.println("");
        list.add(firstName, lastName, phone, address, city);
        System.out.println("Your contact has been added successfully!");
        System.out.println("");
    } // end save

    public void search() {
        System.out.println("Search for a Contact:");
        System.out.println("(N) by Full Name?");
        System.out.println("(P) by Phone Number?");
        System.out.print("Selection: ");
        String response = input.nextLine().toLowerCase();
        System.out.println("");
        switch (response.charAt(0)) {
            case 'n' -> searchName();
            case 'p' -> searchPhone();
        }
    } // end search

    public void searchName() {
        System.out.print("Full Name: ");
        String name = input.nextLine();
        System.out.println("");
        list.searchByFullName(name);
    } // end search by name

    public void searchPhone() {
        System.out.print("Phone Number: ");
        String phone = input.nextLine();
        System.out.println("");
        list.searchByPhone(phone);
    } // end search by phone

    public void delete() {
        System.out.print("Please input contact to be deleted: ");
        String name = input.nextLine();
        System.out.println("");
        list.delete(name);
    } // end delete

    public void modify() {
        System.out.println("What would you like to modify?");
        System.out.println("(L) Last Name");
        System.out.println("(P) Phone Number");
        System.out.println("(A) Address");
        System.out.print("Selection: ");
        String response = input.nextLine().toLowerCase();
        System.out.println("");
        switch (response.charAt(0)) {
            case 'l' -> modifyLastName();
            case 'p' -> modifyPhone();
            case 'a' -> modifyAddress();
        }
    } // end modify

    public void modifyLastName() {
        System.out.print("Please input contacts old sir name: ");
        String oldName = input.nextLine();
        System.out.print("Please input contacts new sir name: ");
        String newName = input.nextLine();
        System.out.println("");
        list.modifyLast(oldName, newName);
    } // end modify last name

    public void modifyPhone() {
        System.out.print("Please input contacts old phone number: ");
        String oldPhone = input.nextLine();
        System.out.print("Please input contacts new phone number: ");
        String newPhone = input.nextLine();
        System.out.println("");
        list.modifyPhone(oldPhone, newPhone);
    } // end modify phone

    public void modifyAddress() {
        System.out.print("Please input contacts full name: ");
        String name = input.nextLine();
        System.out.print("Please input contacts new address (street and number): ");
        String newAddress = input.nextLine();
        System.out.print("Please input contacts new city: ");
        String newCity = input.nextLine();
        System.out.println("");
        list.modifyAddress(name, newAddress, newCity);
    } // end modify address

    public void view() {
        list.printList();
    } // end view

    public boolean runProgram() {
        menu();
        System.out.print("Input a command: ");
        String response = input.nextLine();
        System.out.println("");
        switch(response.charAt(0)) {
            case '1' -> save();
            case '2' -> search();
            case '3' -> delete();
            case '4' -> modify();
            case '5' -> view();
            case '6' -> run = false;
        }
        return run;
    } // end runProgram

    public void menu() {
        System.out.println("""

                                The Address Book:\s

                                (1) Save New Contact
                                (2) Look for someone
                                (3) Delete
                                (4) Modify
                                (5) View All
                                (6) Quit Program
                        """
        );
    } // end of menu method

    public void demoContacts() {
        list.add("Zachariah", "Magee", "360-684-0482", "7171 Green Valley Dr", "Maple Falls");
        list.add("Jessica", "Espy", "206-305-6838", "310 H Street", "Bellingham");
        list.add("Emily", "Magee", "360-920-4204", "30225 30th Street", "Lake Forest Park");
        list.add("Michael", "Hoffer", "360-927-6767", "4226 Lee Court", "Bellingham");
    }

} // end of Operator class
