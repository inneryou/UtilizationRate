package com.turedurenaru;

import javax.swing.JButton;

public class DeleteButton extends JButton{
  private int id;

  public DeleteButton(int id){
    this.id = id;
    setText("-");
  }
  public int getId(){
    return id;
  } 
}
