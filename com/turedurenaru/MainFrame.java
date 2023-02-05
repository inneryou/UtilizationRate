package com.turedurenaru;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame implements ActionListener{
  private JPanel basePanel;
  private JPanel mainPanel;
  private RecordPanel recordPanel;
  private JScrollPane scrollPane;
  private JButton buttonClose;

  public MainFrame(String title){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle(title);
    setPreferredSize(new Dimension(800,600));

    basePanel = new JPanel();
    basePanel.setLayout(new BorderLayout());
    mainPanel = new JPanel();
    mainPanel.setLayout(new FlowLayout());
    recordPanel = new RecordPanel(10);

    buttonClose = new JButton("Close");
    buttonClose.addActionListener(this);

    scrollPane = new JScrollPane(recordPanel);
    getContentPane().add(buttonClose,BorderLayout.NORTH);
    getContentPane().add(scrollPane,BorderLayout.CENTER);
    
    pack();
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if(obj == buttonClose){
      System.exit(0);
    }
  }
}
