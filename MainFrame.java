package com.turedurenaru;

import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame implements ActionListener{
  private JPanel basePanel;
  private JPanel mainPanel;
  private JScrollPane scrollPane;
  private ArrayList<RecordPanel> listRecords;
  private ArrayList<PlusButton> listButton;
  private ArrayList<DeleteButton> listDeleteButton;
  private PlusButton buttonPlus;
  private DeleteButton buttonDelete;
  private JButton buttonClose;
  private int maxId;

  public MainFrame(String title){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle(title);
    setPreferredSize(new Dimension(800,600));

    maxId = 10;
    listRecords = new ArrayList<>();
    listButton = new ArrayList<>();
    listDeleteButton = new ArrayList<>();

    basePanel = new JPanel();
    basePanel.setLayout(new BorderLayout());
    mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(10,1));

    buttonClose = new JButton("Close");
    buttonClose.addActionListener(this);

    scrollPane = new JScrollPane(mainPanel);
    for(int i = 0; i < maxId;i++){
      addRecordPanel(i);
    }
    
    for(RecordPanel rp: listRecords){
      mainPanel.add(rp);
    }

    getContentPane().add(buttonClose,BorderLayout.NORTH);
    getContentPane().add(scrollPane,BorderLayout.CENTER);
    
    pack();
    setVisible(true);
  }
  
  private void addRecordPanel(int i){
    RecordPanel rp = new RecordPanel(i);
    addPlusButton(i, rp);
    addDeleteButton(i, rp);
    listRecords.add(rp);
  }
  
  public void addPlusButton(int id,JPanel jp){
    buttonPlus = new PlusButton(id,"+");
    buttonPlus.addActionListener(this);
    listButton.add(buttonPlus);
    jp.add(buttonPlus);
  }

  public void addDeleteButton(int id,JPanel jp){
    buttonDelete = new DeleteButton(id,"-");
    buttonDelete.addActionListener(this);
    listDeleteButton.add(buttonDelete);
    jp.add(buttonDelete);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if(obj == buttonClose){
      System.exit(0);
    }
    maxId++;
    mainPanel.removeAll();
    int myId = e.getID();
    int cnt = 0;
    listRecords.add(cnt,new RecordPanel(maxId));
    PlusButton pb = new PlusButton(maxId,"++");
    pb.addActionListener(this);
    listButton.add(cnt,pb);
    System.out.println(listRecords.size() + " " + listButton.size());
    mainPanel.setLayout(new GridLayout(listRecords.size(),1));
    for(RecordPanel rp: listRecords){
      mainPanel.add(rp);
      for(PlusButton pbb:listButton){
        System.out.println(rp.getId() + " " + pbb.getId());
        if(rp.getId() == pbb.getId()){
          rp.add(pbb);
          mainPanel.add(rp);
        }
      }
      // addPlusButton(jp);
      // addDeleteButton(jp);
    }
    revalidate();
    // repaint();
  }
}
