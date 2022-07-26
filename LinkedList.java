// Programmer: Zachariah Magee
// Class: CS 145
// Assignment: Linked List Phonebook
// Date: July 19, 2022

import java.util.List;
import static java.lang.String.format;

public class LinkedList {
    private ListNode head;  // first value in the list
    private ListNode tail;   // last value in the list
    private int length;

    // post: constructs an empty list
    public LinkedList() {
        head = null;
        length = 0;
    }

    // create a method to add node (contact)
    public void add(String firstName, String lastName, String phone, String address, String city) {
        ListNode current = head;
        // ListNode tail = null;
        ListNode newNode = new ListNode(new ListNode.Contact(firstName, lastName, phone, address, city));

        if (isEmpty()) {
            head = newNode;
            length++;
        } else {
            // compare last names of entries to alphabetize
            for (int i = 0; i < length; i++) {
                String currentName = current.data.getLastName();
                String newName = newNode.data.getLastName();

                int result = currentName.compareToIgnoreCase(newName);

                // if newNode goes before head it becomes the head
                if (result > 0) {
                    if (tail == null) {
                        newNode.setNext(current);
                        head = newNode;
                        length++;
                        break;
                    } // end if
                    tail.setNext(newNode);
                    newNode.setNext(current);
                    length++;
                    break;
                } else {
                    // newNode becomes the tail
                    if (current.getNext() == null) {
                        current.setNext(newNode);
                        newNode.setNext(null);
                        length++;
                        break;
                    } // end if
                    tail = current;
                    current = current.getNext();
                } // end inner else
            } // end for loop
        } // end else statement
    } // end of add method (adds a list node to linked list)

    // create method to delete contact node
    public void delete(String name) {
        ListNode current = head;
        // tail = null;
        boolean empty = true;
        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            // iterates over list finding index and deleting it
            while (current.next != null) {
                if (current.data.getFullName().equals(name)) {
                    if (tail == null) {
                        head = head.getNext();
                        length--;
                        empty = false;
                        break;
                    } else if (current.getNext() == null){
                        tail.setNext(null);
                        length--;
                        empty = false;
                        break;
                    } else {
                        tail.setNext(current.getNext());
                        length--;
                        empty = false;
                        break;
                    } // end inner - inner if/ else
                } else {
                    tail = current;
                    current = current.getNext();
                } // end inner if/ else
            } // end for loop
            if (empty) {
                System.out.println("Contact does not exist!");
            } else {
                // notification of successful deletion
                System.out.printf("Successfully deleted Contact: %s\n", name);
            } // end inner else
        } // end else
    } // end delete node(contact) method

    // below are methods used to modify contacts
    public void modifyLast(String originalFullName, String newName) {
        ListNode current = head;
        boolean empty = true;
        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            // iterates over list finding index and modifying it
            while(current.next != null) {
                if(current.data.getFullName().equals(originalFullName)) {
                    current.data.setLastName(newName);
                    System.out.println("Updated Contact Information: ");
                    System.out.print(current.toString());
                    empty = false;
                }
                current = current.next;
            } // end while loop
            if (empty) {
                System.out.println("The name you entered did not a match a contact");
            } // end if empty
        } // end else
    } // end modify last method

    public void modifyPhone(String originalPhone, String newPhone) {
        ListNode current = head;
        boolean empty = true;
        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            // iterates over list finding index and modifying it
            while(current.next != null) {
                if(current.data.getPhone().equals(originalPhone)) {
                    current.data.setPhone(newPhone);
                    System.out.println("Updated Contact Information: ");
                    System.out.print(current.toString());
                    empty = false;
                }
                current = current.next;
            } // end while loop
            if (empty) {
                System.out.println("The number you entered did not a match a contact");
            } // end if empty
        } // end else
    } // end modify last method

    public void modifyAddress(String fullName, String newAddress, String newCity) {
        ListNode current = head;
        boolean empty = true;
        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            // iterates over list finding index and modifying it
            while(current.next != null) {
                if(current.data.getFullName().equals(fullName)) {
                    current.data.setAddress(newAddress);
                    current.data.setCity(newCity);
                    System.out.println("Updated Contact Information: ");
                    System.out.print(current.toString());
                    empty = false;
                }
                current = current.next;
            } // end while loop
            if (empty) {
                System.out.println("The name you entered did not a match a contact");
            } // end if empty
        } // end else
    } // end modify last method

    // below are methods used to search for contacts
    // create a method to search by full name
    public void searchByFullName(String name) {
        ListNode current = head;
        boolean empty = true;
        // check to see if the list is empty
        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            for (int i = 0; i < length; i++) {
                String currentName = current.data.getFullName().toLowerCase();
                if (currentName.contains(name.toLowerCase())) {
                    System.out.printf("Index = %s\n", (i+1));
                    System.out.println(current.toString());
                    empty = false;
                } // if contact is not within that node, go to the next
                current = current.getNext();
            } // end of for loop
            if (empty) {
                System.out.printf("No matches for name: %s", name);
            }
        } // end of else
    } // end of search by full name

    // create a method to search by phone
    public void searchByPhone(String phone) {
        ListNode current = head;
        boolean empty = true;
        // check to see if list is empty
        if (isEmpty()) {
            System.out.println("The list is Empty!");
        } else {
            for (int i = 0; i < length; i++) {
                String currentPhone = current.data.getPhone();
                if (currentPhone.equals(phone)) {
                    System.out.printf("Index = %s\n", (i + 1));
                    System.out.println(current.toString());
                    empty = false;
                } // end inner if
                current = current.getNext();
            } // end for loop
            if (empty) {
                System.out.printf("No matches found for phone number: %s\n", phone);
            } // end inner if
        } // end else
    } // end search by phone method

    public boolean isEmpty() { return (length == 0); }

    public int size() { return length; }

    public void printList() {
        ListNode tempNode = head;
        if (head == null) {
            System.out.println("The list is empty!");
        } else {
            // print the list in order
            for (int i = 0; i < length; i++) {
                System.out.printf("Index = %s\n", (i+1));
                System.out.print(tempNode.data.toString());
                tempNode = tempNode.getNext();
            }
        } // end of printList method
    }

    @Override
    public String toString() {
        ListNode temp = head;
        String contacts = "";
        for (int i = 0; i < length; i++) {
            contacts += format("Index = %s\n%s\n", (i), temp.data.toString());
            temp = temp.getNext();
        } return contacts;
    } // end toString method
}
