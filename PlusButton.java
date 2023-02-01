package com.turedurenaru;

import javax.swing.JButton;

public class PlusButton extends JButton{
  private int id;

  public PlusButton(int id,String text){
    this.id = id;
    setText(text);
  }
  public int getId(){
    return id;
  }
}
