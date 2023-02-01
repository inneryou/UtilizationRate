package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RecordPanel extends JPanel implements ItemListener{
  private JComboBox<String> comboBoxLarge;
  private JComboBox<String> comboBoxMiddle;
  private DefaultComboBoxModel<String> modelLarge;
  private DefaultComboBoxModel<String> modelMiddle;
  public ArrayList<DefaultComboBoxModel<String>> aryModelMiddle = new ArrayList<>();
  private JTextField textFieldComments;
  private JTextField textFieldFrom;
  private JTextField textFieldTo;
  private JTextField textFieldBetween;

  private String[] aryLarge = {"業務A","業務B","業務C","業務D","業務E"};
  private String[][] aryMiddle = {
    {"業務A-1","業務A-2","業務A-3","業務A-4"},
    {"業務B-1","業務B-2","業務B-3","業務B-4"},
    {"業務C-1","業務C-2","業務C-3","業務C-4"},
    {"業務D-1","業務D-2","業務D-3","業務D-4"},
    {"業務E-1","業務E-2","業務E-3","業務E-4"}
  };
  public RecordPanel(){
    modelLarge = new DefaultComboBoxModel<>(aryLarge);
    createAryModelMiddle();
    setLayout(new GridLayout(1,6));
    comboBoxLarge = new JComboBox<>(modelLarge);
    comboBoxLarge.addItemListener(this);
    add(comboBoxLarge);
    comboBoxMiddle = new JComboBox<>(aryModelMiddle.get(0));
    add(comboBoxMiddle);
    textFieldComments = new JTextField(6);
    add(textFieldComments);
    textFieldFrom = new JTextField(6);
    add(textFieldFrom);
    textFieldTo = new JTextField(6);
    add(textFieldTo);
    textFieldBetween = new JTextField(6);
    add(textFieldBetween);
  }
  
  private void createAryModelMiddle(){
    for(int i=0;i<aryMiddle.length;i++){
      DefaultComboBoxModel<String> md = new DefaultComboBoxModel<>(aryMiddle[i]);
      aryModelMiddle.add(md);
    }
  }
  @Override
  public void itemStateChanged(ItemEvent e) {
    if(e.getStateChange() == ItemEvent.SELECTED){
      String data = (String)modelLarge.getSelectedItem();
      System.out.println(data);
      switch(data){
        case "業務A":
          comboBoxMiddle.setModel(aryModelMiddle.get(0));
          break;
        case "業務B":
          comboBoxMiddle.setModel(aryModelMiddle.get(1));
          break;
        case "業務C":
          comboBoxMiddle.setModel(aryModelMiddle.get(2));
          break;
        case "業務D":
          comboBoxMiddle.setModel(aryModelMiddle.get(3));
          break;
        case "業務E":
          comboBoxMiddle.setModel(aryModelMiddle.get(4));
          break;
        default:
          comboBoxMiddle.setModel(aryModelMiddle.get(0));
          break;
      } 
    }
  }
}
