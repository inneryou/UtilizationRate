package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.JPanel;

public class RecordPanel extends JPanel implements ActionListener{
  private ArrayList<RecordRow> aryRecordRow = new ArrayList<>();
  private int maxNum = -1;
  public RecordPanel(int row){
    for(int i = 0;i<row;i++){
      addAryRecordRow();
    }
  }
  
  public void addAryRecordRow(){
    maxNum++;
    setLayout(new GridLayout(aryRecordRow.size()+1,1));
    RecordRow rr = new RecordRow(maxNum);
    PlusButton pb = new PlusButton(maxNum);
    pb.addActionListener(this);
    DeleteButton db = new DeleteButton(maxNum);
    db.addActionListener(this);
    rr.add(pb);
    rr.add(db);
    aryRecordRow.add(rr);
    reValidatePanel();
  }
  
  private void deleteAryRecordRow(int id){
    setLayout(new GridLayout(aryRecordRow.size()-1,1));
    for(int i = 0;i<aryRecordRow.size();i++){
      if(aryRecordRow.get(i).getId() == id){
        aryRecordRow.remove(i);
      }
    }
    reValidatePanel();
  }
  
  private void reValidatePanel(){
    removeAll();
    for(RecordRow arr:aryRecordRow){
      add(arr);
    }
    revalidate();
  }

  @Override
  public void actionPerformed(ActionEvent e){
    Object obj = e.getSource();
    if(obj instanceof PlusButton){
      addAryRecordRow();
    }
    if(obj instanceof DeleteButton){
      int id = ((DeleteButton)obj).getId();
      deleteAryRecordRow(id);
    }
  }
}
