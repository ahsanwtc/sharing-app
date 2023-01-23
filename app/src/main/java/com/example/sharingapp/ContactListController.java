package com.example.sharingapp;

import android.content.Context;

import java.util.ArrayList;

public class ContactListController {
  private ContactList contacts;

  public ContactListController(ContactList contacts) {
    this.contacts = contacts;
  }

  public void setContacts(ArrayList<Contact> contacts) {
    this.contacts.setContacts(contacts);
  }

  public ArrayList<Contact> getContacts() {
    return contacts.getContacts();
  }

  public ArrayList<String> getAllUsernames() {
    return contacts.getAllUsernames();
  }

  public Contact getContact(int index) {
    return contacts.getContact(index);
  }

  public int getIndex(Contact contact) {
    return contacts.getIndex(contact);
  }

  public int getSize() {
    return contacts.getSize();
  }

  public void loadContacts(Context context) {
    contacts.loadContacts(context);
  }

  public boolean hasContact(Contact contact) {
    return contacts.hasContact(contact);
  }

  public Contact getContactByUsername(String username) {
    return contacts.getContactByUsername(username);
  }

  public boolean saveContacts(Context context) {
    return contacts.saveContacts(context);
  }

  public boolean isUsernameAvailable(String username) {
    return contacts.isUsernameAvailable(username);
  }

  public void addObserver(Observer observer) {
    contacts.addObserver(observer);
  }

  public void removeObserver(Observer observer) {
    contacts.removeObserver(observer);
  }
}
