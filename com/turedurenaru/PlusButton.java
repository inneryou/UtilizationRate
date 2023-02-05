package com.turedurenaru;

import javax.swing.JButton;

public class PlusButton extends JButton{
  private int id;

  public PlusButton(int id){
    this.id = id;
    setText("+");
  }
  public int getId(){
    return id;
  }
}
