package com.example.sharingapp;
import android.graphics.Bitmap;

import java.util.UUID;

public class ContactController {
  private Contact contact;
  
  public ContactController(Contact contact) {
    this.contact = contact;
  }

  public String getUsername() {
    return contact.getUsername();
  }

  public void setUsername(String username) {
    contact.setUsername(username);
  }

  public String getEmail() {
    return contact.getEmail();
  }

  public void setEmail(String email) {
    contact.setEmail(email);
  }

  public String getId() {
    return contact.getId();
  }

  public void setId() {
    contact.setId();
  }

  public void updateId(String id) {
    contact.updateId(id);
  }

  public void addObserver(Observer observer) {
    contact.addObserver(observer);
  }

  public void removeObserver(Observer observer) {
    contact.removeObserver(observer);
  }
}
