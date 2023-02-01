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
  private ArrayList<JPanel> listRecords;
  private ArrayList<JButton> listButton;
  private JButton buttonPlus;
  private JButton buttonDelete;

  public MainFrame(String title){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle(title);
    setPreferredSize(new Dimension(800,600));

    listRecords = new ArrayList<>();
    listButton = new ArrayList<>();

    basePanel = new JPanel();
    basePanel.setLayout(new BorderLayout());
    mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(10,1));

    scrollPane = new JScrollPane(mainPanel);
    for(int i = 0; i < 10;i++){
      addRecordPanel();
    }
    
    for(JPanel jp: listRecords){
      mainPanel.add(jp);
    }
    getContentPane().add(scrollPane,BorderLayout.CENTER);
    pack();
    setVisible(true);
  }
  
  private void addRecordPanel(){
    JPanel jp = new JPanel();
    RecordPanel rp = new RecordPanel();
    jp.add(rp);
    addPlusButton(jp);
    addDeleteButton(jp);
    listRecords.add(jp);
  }
  
  public void addPlusButton(JPanel jp){
    buttonPlus = new JButton("+");
    buttonPlus.addActionListener(this);
    jp.add(buttonPlus);
  }

  public void addDeleteButton(JPanel jp){
    buttonDelete = new JButton("-");
    buttonDelete.addActionListener(this);
    jp.add(buttonDelete);
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    mainPanel.removeAll();
    Object obj = e.getSource();
    int cnt = 0;
    listRecords.add(cnt,new RecordPanel());
    listButton.add(cnt,new JButton());
    for(JButton j: listButton){
      if(j == obj){
      }
      cnt++;
    }
    System.out.println(listRecords.size());
    mainPanel.setLayout(new GridLayout(listRecords.size(),1));
    listButton = new ArrayList<>();
    for(JPanel jp: listRecords){
      mainPanel.add(jp);
      // addPlusButton(jp);
      // addDeleteButton(jp);
    }
    revalidate();
    // repaint();
  }
}
