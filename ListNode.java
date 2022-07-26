// Programmer: Zachariah Magee
// Class: CS 145
// Assignment: Linked List Phonebook
// Date: July 19, 2022

import static java.lang.String.format;

public class ListNode {
    Contact data;
    ListNode next;

    ListNode() {
        this.next = null;
    }

    public ListNode(Contact data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(Contact data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public void setData(Contact data) { this.data = data; }

    public void setNext(ListNode next) { this.next = next; }

    public Contact getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    static class Contact {
        String firstName;
        String lastName;
        String phone;
        String address;
        String city;


        public Contact(String firstName, String lastName, String phone, String address, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.address = address;
            this.city = city;
        }

        // setters:
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public void setLastName(String lastName) { this.lastName = lastName; }

        public void setPhone(String phone) { this.phone = phone; }

        public void setAddress(String address) { this.address = address; }

        public void setCity(String city) { this.city = city; }

        // getters:
        public String getFirstName() { return firstName; }

        public String getLastName() { return lastName; }

        public String getFullName() {
            return format("%s %s", firstName, lastName);
        }

        public String getPhone() {
            return phone;
        }

        public String getAddress() { return address; }

        public String getCity() { return city; }

        @Override
        public String toString() {
            return format("Contact: %s %s\nPhone Number: %s\nAddress: %s\nCity: %s\n\n",
                    this.firstName, this.lastName, this.phone, this.address, this.city);
        }
    }
}
