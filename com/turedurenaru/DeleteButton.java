package com.turedurenaru;

import javax.swing.JButton;

public class DeleteButton extends JButton{
  private int id;

  public DeleteButton(int id,String text){
    this.id = id;
    setText(text);
  }
  public int getId(){
    return id;
  } 
}
