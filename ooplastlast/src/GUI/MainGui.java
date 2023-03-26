package GUI;

import Main.Doctor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;


public class MainGui extends JFrame {

        private ArrayList<Doctor> doctors;
        private ArrayList<Consultation> consultations;

        // Constructor
        public MainGui(ArrayList<Doctor> doctors,ArrayList<Consultation> consultations) {
            this.doctors = doctors;
            this.consultations=consultations;



            setTitle("");
            setSize(530, 600);
            setLayout(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setBackground(new Color(0x050110));



            // label create

            JLabel label = new JLabel("Hello!!!", SwingConstants.CENTER);
            label.setFont(new Font(Font.SERIF, Font.PLAIN,  30));
            label.setLayout(null);
            label.setBounds(150,50,200,50);
            label.setBackground(new Color(0x050110));
            label.setVisible(true);

//display doc btn
            JButton all_doc = new JButton("Display All Doctors");
            all_doc.setFont(new Font("Arial", Font.PLAIN, 30));
            all_doc.setBackground(new Color(0xFFFFFF));
            all_doc.setLayout(null);
            all_doc.setBounds(100,120,300,50);
            all_doc.setVisible(true);

//view a chanel
            JButton all_cha = new JButton("View a Chanel");
            all_cha.setFont(new Font("Arial", Font.PLAIN, 30));
            all_cha.setBackground(new Color(0xFFFFFF));
            all_cha.setLayout(null);
            all_cha.setBounds(100,260,300,50);
            all_cha.setVisible(true);

//chanel doc btn
            JButton cha_doc = new JButton("Chanel a Doctor ");
            cha_doc.setFont(new Font("Arial", Font.PLAIN, 30));
            cha_doc.setBackground(new Color(0xFFFFFF));
            cha_doc.setLayout(null);
            cha_doc.setBounds(100,390,300,50);
            cha_doc.setVisible(true);


            add(all_doc);
            add(all_cha);
            add(cha_doc);
            add(label);


            // Add action listeners to the buttons
            all_doc.addActionListener(new DisplayButtonListener());
            all_cha.addActionListener(new ViewButtonListner());
            cha_doc.addActionListener(new ChanelButtonListener());
        }

    // Inner class for display button listener
        class DisplayButtonListener implements ActionListener {
                public void actionPerformed(ActionEvent e) {

                        JFrame tabframe = new JFrame();
                        tabframe.getContentPane();
                        tabframe.setSize(900, 700);
                        tabframe.setVisible(true);
                        doctors.sort(new Comparator<Doctor>() {
                            @Override
                            public int compare(Doctor o1, Doctor o2) {
                                return o1.getSurname().compareTo(o2.getSurname());
                            }
                        });


                        DoctorModel tableM = new DoctorModel(doctors);
                        JTable table = new JTable(tableM);
                        JScrollPane sp = new JScrollPane(table);
                        tabframe.add(sp);


                }

        }

        class ChanelButtonListener implements ActionListener {
                public void actionPerformed(ActionEvent e) {


                        JFrame frame = new JFrame();
                        frame.setTitle("Chanel Your Doctor");
                        frame.setSize(1200,900);
                        frame.setLayout(null);
                        frame.setBackground(new Color(0xDCDCDA));
                        frame.setVisible(true);


                        JLabel lab1 = new JLabel("Patient Details");
                        lab1.setFont(new Font(Font.SERIF, Font.PLAIN,  35));
                        lab1.setBounds(150,30,300,50);
                        frame.add(lab1);

                        //Name
                        JLabel lab2 = new JLabel("Patient Name : ");
                        lab2.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                        lab2.setBounds(90,95,200,50);
                        frame.add(lab2);


                        JLabel lab3 = new JLabel("Patient Surname : ");
                        lab3.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                        lab3.setBounds(90,190,200,30);
                        frame.add(lab3);


                        JLabel lab4 = new JLabel("Date Of Birth : ");
                        lab4.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                        lab4.setBounds(90,285,200,30);
                        frame.add(lab4);


                       JLabel lab7 = new JLabel(" Patient Mobile No : ");
                       lab7.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                       lab7.setBounds(90,375,200,30);
                       frame.add(lab7);

                       JLabel lab6 = new JLabel("Patient NIC No: ");
                       lab6.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                       lab6.setBounds(100,465,200,30);
                       frame.add(lab6);

                       JLabel labb = new JLabel("Doctors Details: ");
                       labb.setFont(new Font(Font.SERIF, Font.PLAIN,  35));
                       labb.setBounds(690,30,300,30);
                       frame.add(labb);


                       JLabel lab8 = new JLabel("Doctor Name: ");
                       lab8.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                       lab8.setBounds(650,95,200,30);
                       frame.add(lab8);

                       JLabel lab9= new JLabel("Appointment Date: ");
                       lab9.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                       lab9.setBounds(650,190,200,30);
                       frame.add(lab9);

                       JLabel lab10 = new JLabel("Start Time: ");
                       lab10.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                       lab10.setBounds(650,285,200,30);
                       frame.add(lab10);

                      JLabel laba = new JLabel("Hours : ");
                      laba.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                      laba.setBounds(650,375,200,30);
                      frame.add(laba);

                      JLabel lab = new JLabel("End Time: ");
                      lab.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                      lab.setBounds(650,465,200,30);
                      frame.add(lab);

                      JLabel lab12 = new JLabel("Notes: ");
                      lab12.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                      lab12.setBounds(650,555,200,30);
                      frame.add(lab12);

                      JLabel lab11 = new JLabel(" Is this your first consultation : ");
                      lab11.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                      lab11.setBounds(650,645,300,30);
                      frame.add(lab11);


                      JLabel lab123 = new JLabel("Cost: ");
                      lab123.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                      lab123.setBounds(650,690,100,30);
                      frame.add(lab123);

                      JTextField co = new JTextField();
                      co.setBounds(850,690,60,30);
                      frame.add(co);

                     JButton newLab = new JButton("Submit");
                     newLab.setFont(new Font(Font.SERIF, Font.PLAIN,  30));
                     newLab.setBounds(450,745,200,50);
                     frame.add(newLab);


                     JTextField t1 = new JTextField();
                     t1.setBounds(260,105,200,30);
                     t1.setFont(new Font(Font.SERIF, Font.PLAIN,  30));
                     frame.add(t1);

                     JTextField m = new JTextField();
                     m.setBounds(260,380,200,30);
                     frame.add(m);

                     JTextField t2 = new JTextField();
                     t2.setBounds(260,190,200,30);
                     frame.add(t2);

                     JTextField t3 = new JTextField();
                     t3.setBounds(260,285,200,30);
                     frame.add(t3);

                     JButton b1 = new JButton("CLICK");
                     b1.setBounds(461, 285, 70, 30);
                     frame.add(b1);
                     b1.addActionListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent e) {
                               t3.setText(new Calander(frame).setPickedDate());

                           }
                       });

                     JTextField t4 = new JTextField();
                     t4.setBounds(850,463,200,30);
                     frame.add(t4);

                     JTextField t5 = new JTextField();
                     t5.setBounds(260,460,200,30);
                     frame.add(t5);

                      String []dctrName=new String[10];
                      for (int i = 0; i < doctors.size(); i++) {
                        dctrName[i]=doctors.get(i).getName();
                      }
                      JComboBox c1=new JComboBox(dctrName);
                      c1.setSize(150,20);
                      c1.setBounds(850,97,200,30);
                      frame.add(c1);

                      JTextField t7 = new JTextField();
                      t7.setBounds(850,190,200,30);
                      frame.add(t7);

                      JButton b2 = new JButton("CLICK");
                      b2.setBounds(1050, 190, 70, 30);
                      frame.add(b2);
                      b2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            t7.setText(new Calander(frame).setPickedDate());

                        }
                    });

                    String []startTimearray=new String[18];
                    for (int i = 1; i < 18; i++) {
                        startTimearray[i]= String.valueOf(i);
                    }

                    JComboBox t8 = new JComboBox(startTimearray);
                    t8.setBounds(850,285,200,30);
                    frame.add(t8);


                    String []hours=new String[100];
                    for (int i = 0; i <12; i++) {
                        hours[i]= String.valueOf(i+1);

                    }

                    JComboBox aa=new JComboBox(hours);
                    aa.setBounds(850,375,200,30);
                    frame.add(aa);

                    aa.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int getStartTime =Integer.parseInt(t8.getSelectedItem().toString());
                            int patHours =Integer.parseInt(aa.getSelectedItem().toString());
                            int endTime =getStartTime+patHours;
                            t4.setText(String.valueOf(endTime));
                        }
                    });


                    JButton btYes = new JButton("Yes");
                    btYes.setBounds(900, 645, 70, 30);
                    frame.add(btYes);
                    btYes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int hourscal= Integer.parseInt(aa.getSelectedItem().toString());
                            int finalCost=hourscal*15;
                            co.setText(String.valueOf(finalCost));


                        }
                    });

                    JButton btNo = new JButton("No");
                    btNo.setBounds(970, 645, 70, 30);
                    frame.add(btNo);
                    btNo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int hourscalNo= Integer.parseInt(aa.getSelectedItem().toString());
                            int finalCost=hourscalNo*25;
                            co.setText(String.valueOf(finalCost));


                        }
                    });

                    JTextField t9 = new JTextField();
                    t9.setBounds(850,375,200,30);
                    frame.add(t9);

                    JTextField t10 = new JTextField();
                    t10.setBounds(850,555,200,30);
                    frame.add(t10);

                    newLab.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            System.out.println("booking start");

                            Consultation consultation1 = new Consultation();
                            consultation1.setDocName(c1.getSelectedItem().toString());
                            consultation1.setDate(t7.getText());
                            consultation1.setStTime(t8.getSelectedItem().toString());
                            consultation1.setNotes(t10.getText());
                            consultation1.setEnTime(t4.getText());
                            consultation1.setPatName(b1.getText());
                            consultation1.setCost(Integer.parseInt(co.getText()));
                            consultation1.setPatDOB(t3.getText());
                            consultation1.setPatMobNo(Integer.parseInt(m.getText()));
                            consultation1.setPatSurName(b2.getText());

                            if (consultations.isEmpty()){
                                consultations.add(consultation1);
                            }else {
                                for (Consultation consultation:consultations) {
                                    if (consultation.getDocName().equals(consultation1.getDocName())){
                                        if (consultation.getConDate().equals(consultation1.getConDate())){
                                            int c1= Integer.parseInt(consultation.getStTime());
                                            int c2= Integer.parseInt(consultation.getEnTime());
                                            int d1= Integer.parseInt(consultation1.getEnTime());
                                            int d2= Integer.parseInt(consultation1.getStTime());
                                            if (c1>d1 || c2<d2){
                                                consultations.add(consultation1);
                                            }else{
                                                System.out.println("this doctor is booked..");
                                                JOptionPane.showMessageDialog(null, "booked");
                                            }
                                        }else{
                                            consultations.add(consultation1);
                                        }

                                    }else {
                                        consultations.add(consultation1);
                                    }
                                }
                            }


                        }
                    });


                }

        }

    // Inner class for view consultation listener

        class ViewButtonListner implements ActionListener{
            public void actionPerformed(ActionEvent e){

                JFrame frame2 = new JFrame();
                frame2.setTitle("View All Chanel");
                frame2.setSize(610,400);
                frame2.setLayout(null);
                frame2.setBackground(new Color(0xD9D9CC));
                frame2.setVisible(true);

                JLabel lab = new JLabel("Enter Your Name :");
                lab.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
                lab.setBounds(100,80,200,30);
                frame2.add(lab);

                JTextField t1 = new JTextField();
                t1.setBounds(300,80,200,30);
                frame2.add(t1);

                JLabel lab2 =new JLabel("Enter your Surname :");
                lab2.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
                lab2.setBounds(100,140,200,30);
                frame2.add(lab2);

                JTextField t2 = new JTextField();
                t2.setBounds(300,140,200,30);
                frame2.add(t2);

                JButton but = new JButton("SUBMIT");
                but.setBounds(200,240,205,50);
                but.setFont(new Font(Font.SERIF, Font.PLAIN,  30));
                frame2.add(but);

                but.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JFrame table1 = new JFrame();
                        JPanel panelOnly = new JPanel();
                        table1.getContentPane();
                        panelOnly.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                        table1 .add(panelOnly);
                        table1.setSize(1300, 800);
                        table1.setVisible(true);
                        if (consultations != null && !consultations.isEmpty()){
                            for (Consultation consultation:consultations){
                                if (consultation.getPatName().equals(t1.getText()) && consultation.getPatSurName().
                                        equals(t2.getText())){
                                    consultations.add(consultation);
                                }else{

                                }
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "No consultations available");
                        }

                        String[] cols = { "Date", "Doctor_Name", "Start Time", "End Time","Cost","Notes" };
                        DefaultTableModel tableMa = new DefaultTableModel(cols, 0);
                        JTable table = new JTable(tableMa);
                        JScrollPane sp = new JScrollPane(table);
                        table1.add(sp);

                        for (Consultation consultation:consultations) {

                            String Date = consultation.getConDate();
                            String Doctor_Name = consultation.getDocName();
                            String Start_Time = consultation.getStTime();
                            String End_Time = consultation.getEnTime();
                            int Cost = consultation.getCost();
                            String Notes = consultation.getNotes();

                            Object[] data = {Date,Doctor_Name, Start_Time, End_Time, Cost, Notes};

                            tableMa.addRow(data);


                        }

                    }
                }

                );





            }
        }



}










