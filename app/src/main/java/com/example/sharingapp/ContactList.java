package com.example.sharingapp;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContactList extends Observerable {
  private ArrayList<Contact> contacts;
  private String FILENAME = "contacts.sav";

  public ContactList() {
    contacts = new ArrayList<Contact>();
  }

  public ArrayList<Contact> getContacts() {
    return contacts;
  }

  public void setContacts(ArrayList<Contact> contacts) {
    this.contacts = contacts;
    notifyObservers();
  }

  public ArrayList<String> getAllUsernames() {
    ArrayList<String> usernames = new ArrayList<>();
    for (Contact c: contacts) {
      usernames.add(c.getUsername());
    }
    return usernames;
  }

  public void addContact(Contact contact) {
    contacts.add(contact);
    notifyObservers();
  }

  public void deleteContact(Contact contact) {
    contacts.remove(contact);
    notifyObservers();
  }

  public Contact getContact(int index) {
    return contacts.get(index);
  }

  public int getSize() {
    return contacts.size();
  }

  public int getIndex(Contact contact) {
    int index = 0;
    for(Contact c: contacts) {
      if (c.getId().equals(contact.getId())) {
        return index;
      }
      index++;
    }
    return -1;
  }

  public boolean hasContact(Contact contact) {
    for (Contact c: contacts) {
      if (c.getId().equals(contact.getId())) {
        return true;
      }
    }
    return false;
  }

  public Contact getContactByUsername(String username) {
    for (Contact c: contacts) {
      if (c.getUsername().equals(username)) {
        return c;
      }
    }
    return null;
  }

  public void loadContacts(Context context) {
    try {
      FileInputStream fis = context.openFileInput(FILENAME);
      InputStreamReader isr = new InputStreamReader(fis);
      Gson gson = new Gson();
      Type listType = new TypeToken<ArrayList<Contact>>() {}.getType();
      contacts = gson.fromJson(isr, listType); // temporary
      fis.close();
    } catch (FileNotFoundException e) {
      contacts = new ArrayList<Contact>();
    } catch (IOException e) {
      contacts = new ArrayList<Contact>();
    }
    notifyObservers();
  }

  public boolean saveContacts(Context context) {
    try {
      FileOutputStream fos = context.openFileOutput(FILENAME, 0);
      OutputStreamWriter osw = new OutputStreamWriter(fos);
      Gson gson = new Gson();
      gson.toJson(contacts, osw);
      osw.flush();
      fos.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return false;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public boolean isUsernameAvailable(String username) {
    for (Contact c: contacts) {
      if (c.getUsername().equals(username)) {
        return false;
      }
    }
    return true;
  }

}
