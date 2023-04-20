/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Airline;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.lang.*;

/**
 *
 * @author hetro
 */
public class ControlRoom extends javax.swing.JFrame {

    /**
     * Creates new form ControlRoom
     */
    DefaultTableModel model;

    public ControlRoom() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setRecordToTable();
        setFlightRecord();
        showPieChart(40);
        setFlightBookingStatus();

    }

    public void showPieChart(int i) {

        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();

        

        barDataset.setValue("Booked Seat", new Double(i));
        barDataset.setValue("Not Booked", new Double(42-i));

        //create chart
        org.jfree.chart.JFreeChart piechart = ChartFactory.createPieChart("", barDataset, false, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();

        //changing pie chart blocks colors
        piePlot.setSectionPaint("Booked Seat", new Color(102, 255, 102));
        piePlot.setSectionPaint("Not Booked", Color.red);

        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelChart.removeAll();
        panelChart.add(barChartPanel, BorderLayout.CENTER);
        panelChart.validate();
    }

    public void setRecordToTable() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("select * from accounts");

            while (rs.next()) {
                Object[] obj = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)};

                model = (DefaultTableModel) table_Account.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) Table_Flight.getModel();
        model.setRowCount(0);
        DefaultTableModel model1 = (DefaultTableModel) Booking_Status.getModel();
        model1.setRowCount(0);
    }

    public void setFlightBookingStatus() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");
            Statement stm = conn.createStatement();
            Statement stm1 = conn.createStatement();

            ResultSet rs = stm.executeQuery("select * from flight");

            while (rs.next()) {
                ResultSet rs1 = stm1.executeQuery("select * from ticket where Flight_No=" + rs.getInt(1) + "");

                int count = 0;
                String affortable;

                while (rs1.next()) {
                    String seat = rs1.getString(9);

                    for (int i = 0; i < seat.length(); i++) {
                        char t = seat.charAt(i);
                        if (t == ' ') {
                            count++;
                        }
                    }

                }
                if (count <= 20) {
                    affortable = "No";
                } else {
                    affortable = "Yes";
                }

                Object[] obj = {rs.getString(1), rs.getString(2) + "-" + rs.getString(3), rs.getString(5), rs.getString(6), count + " / 42", affortable};

                model = (DefaultTableModel) Booking_Status.getModel();
                model.addRow(obj);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFlightRecord() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("select * from flight ");

            while (rs.next()) {

                Object[] obj = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(5), rs.getString(7)};

                model = (DefaultTableModel) Table_Flight.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customUI1 = new necesario.CustomUI();
        verticalLabelIUI1 = new necesario.VerticalLabelIUI();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        time = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        flight = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        box1 = new javax.swing.JComboBox<>();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        box2 = new javax.swing.JComboBox<>();
        lable = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Account = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        update = new javax.swing.JToggleButton();
        Search = new javax.swing.JToggleButton();
        delete = new javax.swing.JToggleButton();
        jLabel16 = new javax.swing.JLabel();
        Flight = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Price = new javax.swing.JTextField();
        loc = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        Time = new javax.swing.JTextField();
        des = new javax.swing.JComboBox<>();
        label1 = new javax.swing.JLabel();
        d = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_Flight = new rojerusan.RSTableMetro();
        jPanel8 = new javax.swing.JPanel();
        panelChart = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        search1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Booking_Status = new rojerusan.RSTableMetro();
        Fno = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeActionPerformed(evt);
            }
        });
        jPanel1.add(time);
        time.setBounds(120, 310, 140, 30);

        jLabel1.setText("Time :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 310, 50, 30);

        jLabel2.setText("Date :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 360, 50, 30);

        jLabel3.setText("Flight :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 260, 50, 30);

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        jPanel1.add(price);
        price.setBounds(120, 210, 180, 30);

        flight.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        flight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Spicejet", "Vistara", "IndiGo", "AirAsia", " " }));
        flight.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        flight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightActionPerformed(evt);
            }
        });
        jPanel1.add(flight);
        flight.setBounds(120, 260, 140, 30);

        jLabel4.setText("Price :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 210, 50, 30);
        jPanel1.add(date);
        date.setBounds(120, 360, 190, 30);

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setLayout(null);

        box1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        box1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Delhi", "Ahemdabad", "Mumbai", "Bengaluru", "Chennai", "Kolkata", "Goa", "Pune" }));
        box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1ActionPerformed(evt);
            }
        });
        jPanel4.add(box1);
        box1.setBounds(50, 30, 200, 70);

        rSMaterialButtonCircle1.setText("Add Flight");
        rSMaterialButtonCircle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle1MouseClicked(evt);
            }
        });
        jPanel4.add(rSMaterialButtonCircle1);
        rSMaterialButtonCircle1.setBounds(60, 340, 210, 100);

        box2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        box2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahemdabad", "Delhi", "Mumbai", "Bengaluru", "Chennai", "Kolkata", "Goa", "Pune" }));
        box2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box2ActionPerformed(evt);
            }
        });
        jPanel4.add(box2);
        box2.setBounds(260, 30, 200, 70);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 70, 490, 490);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 0, 490, 600);

        lable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Airline/images/Add Flight.png"))); // NOI18N
        jPanel2.add(lable);
        lable.setBounds(490, 60, 840, 540);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel7.setText("Control Panel ");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(520, 10, 200, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Airline/images/airplane.png"))); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(1120, 0, 64, 60);

        jTabbedPane1.addTab("Add Flight", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        table_Account.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_Account.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Acc_No", "First Name", "Last Name", "Mobile", "Email", "Password", "Security ans"
            }
        ));
        table_Account.setRowHeight(30);
        table_Account.setRowMargin(5);
        table_Account.setShowGrid(false);
        table_Account.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(table_Account);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 1100, 490);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel5.setText("Search :");
        jLabel5.setOpaque(true);
        jPanel3.add(jLabel5);
        jLabel5.setBounds(120, 20, 100, 30);

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel3.add(search);
        search.setBounds(270, 20, 230, 30);

        jTabbedPane1.addTab("Accounts", jPanel3);

        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(0, 102, 255));
        jPanel6.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(255, 0, 0));
        jPanel7.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel6.setText("Manage Flight");
        jPanel7.add(jLabel6);
        jLabel6.setBounds(140, 20, 190, 32);

        jPanel6.add(jPanel7);
        jPanel7.setBounds(0, -10, 460, 60);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText(" Enter Flight Number");
        jLabel12.setOpaque(true);
        jPanel6.add(jLabel12);
        jLabel12.setBounds(140, 100, 170, 21);

        fn.setBackground(new java.awt.Color(0, 102, 255));
        fn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        fn.setForeground(new java.awt.Color(51, 255, 51));
        fn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        fn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fnKeyReleased(evt);
            }
        });
        jPanel6.add(fn);
        fn.setBounds(110, 140, 230, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Date");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(60, 400, 120, 21);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Location");
        jPanel6.add(jLabel14);
        jLabel14.setBounds(60, 320, 120, 20);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Destination");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(240, 310, 120, 21);

        update.setBackground(new java.awt.Color(255, 255, 102));
        update.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        update.setText("Update");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        jPanel6.add(update);
        update.setBounds(150, 550, 110, 30);

        Search.setBackground(new java.awt.Color(51, 255, 153));
        Search.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Search.setText("Search");
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
        });
        jPanel6.add(Search);
        Search.setBounds(90, 210, 110, 50);

        delete.setBackground(new java.awt.Color(255, 0, 0));
        delete.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        delete.setText("Delete");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        jPanel6.add(delete);
        delete.setBounds(250, 210, 110, 50);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Flight");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(240, 400, 120, 21);

        Flight.setBackground(new java.awt.Color(0, 102, 255));
        Flight.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Flight.setForeground(new java.awt.Color(51, 255, 51));
        Flight.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Flight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlightActionPerformed(evt);
            }
        });
        jPanel6.add(Flight);
        Flight.setBounds(240, 430, 150, 30);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Price");
        jPanel6.add(jLabel17);
        jLabel17.setBounds(30, 480, 120, 21);

        Price.setBackground(new java.awt.Color(0, 102, 255));
        Price.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Price.setForeground(new java.awt.Color(51, 255, 51));
        Price.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceActionPerformed(evt);
            }
        });
        jPanel6.add(Price);
        Price.setBounds(30, 500, 150, 30);

        loc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        loc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Delhi", "Ahemdabad", "Mumbai", "Bengaluru", "Chennai", "Kolkata", "Goa", "Pune" }));
        loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locActionPerformed(evt);
            }
        });
        jPanel6.add(loc);
        loc.setBounds(30, 340, 150, 40);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Time");
        jPanel6.add(jLabel18);
        jLabel18.setBounds(240, 480, 120, 21);

        Time.setBackground(new java.awt.Color(0, 102, 255));
        Time.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Time.setForeground(new java.awt.Color(51, 255, 51));
        Time.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeActionPerformed(evt);
            }
        });
        jPanel6.add(Time);
        Time.setBounds(240, 500, 150, 30);

        des.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        des.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahemdabad", "Delhi", "Mumbai", "Bengaluru", "Chennai", "Kolkata", "Goa", "Pune" }));
        des.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desActionPerformed(evt);
            }
        });
        jPanel6.add(des);
        des.setBounds(230, 340, 150, 40);

        label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Airline/images/Flight icon.png"))); // NOI18N
        jPanel6.add(label1);
        label1.setBounds(-40, 40, 500, 340);
        jPanel6.add(d);
        d.setBounds(30, 430, 150, 30);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(0, 0, 420, 590);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Airline/images/airplane.png"))); // NOI18N
        jPanel5.add(jLabel9);
        jLabel9.setBounds(1090, 0, 90, 70);

        Table_Flight.setForeground(new java.awt.Color(51, 255, 51));
        Table_Flight.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight_No", "Location", "Destination", "Price", "Flight", "Time", "Date"
            }
        ));
        Table_Flight.setColorBackgoundHead(new java.awt.Color(0, 102, 255));
        Table_Flight.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        Table_Flight.setColorSelBackgound(new java.awt.Color(255, 0, 0));
        Table_Flight.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Table_Flight.setRowHeight(30);
        Table_Flight.setSelectionBackground(new java.awt.Color(255, 0, 51));
        Table_Flight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_FlightMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Table_Flight);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(420, -10, 690, 600);

        jTabbedPane1.addTab("Manage Flight", jPanel5);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(null);

        panelChart.setLayout(new java.awt.BorderLayout());
        jPanel8.add(panelChart);
        panelChart.setBounds(20, 130, 440, 400);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel11.setText("Search Flight :");
        jLabel11.setOpaque(true);
        jPanel8.add(jLabel11);
        jLabel11.setBounds(500, 60, 180, 30);

        search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search1KeyReleased(evt);
            }
        });
        jPanel8.add(search1);
        search1.setBounds(700, 60, 230, 30);

        Booking_Status.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight_No", "Loc-Dest", "Time", "Flight", "Seat", "Affordable"
            }
        ));
        Booking_Status.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        Booking_Status.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        Booking_Status.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Booking_Status.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Booking_StatusMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Booking_Status);
        if (Booking_Status.getColumnModel().getColumnCount() > 0) {
            Booking_Status.getColumnModel().getColumn(3).setPreferredWidth(35);
            Booking_Status.getColumnModel().getColumn(4).setPreferredWidth(25);
            Booking_Status.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        jPanel8.add(jScrollPane2);
        jScrollPane2.setBounds(480, 130, 610, 402);

        Fno.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        Fno.setText("123");
        jPanel8.add(Fno);
        Fno.setBounds(320, 60, 70, 40);

        jLabel20.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel20.setText("Flight Number : ");
        jPanel8.add(jLabel20);
        jLabel20.setBounds(110, 60, 220, 40);

        jTabbedPane1.addTab("Flight Booking Status", jPanel8);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(30, 70, 1300, 600);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Airline/images/button-removebg-preview.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 10, 70, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        String searchString = search.getText();

        search(searchString);
    }//GEN-LAST:event_searchKeyReleased

    private void rSMaterialButtonCircle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseClicked
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date d = new Date();
        try {
            if (!price.getText().equals("") || !time.getText().equals("") || !((JTextField) date.getDateEditor().getUiComponent()).getText().equals("")) {
                if (d.compareTo(date.getDate()) < 0) {
                    if (!box1.getSelectedItem().equals(box2.getSelectedItem())) {
                        try {
                            Class.forName("com.mysql.jdbc.Driver");

                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");
                            PreparedStatement ps = con.prepareStatement("insert into flight(Location,Destination,Price,Time,flight,Date)values(?,?,?,?,?,?)");

                            ps.setString(1, (String) box1.getSelectedItem());
                            ps.setString(2, (String) box2.getSelectedItem());
                            ps.setString(3, price.getText());
                            ps.setString(4, time.getText());
                            ps.setString(5, (String) flight.getSelectedItem());
                            ps.setString(6, ((JTextField) date.getDateEditor().getUiComponent()).getText());

                            ps.executeUpdate();
                            clearTable();
                            setFlightRecord();
                            JOptionPane.showMessageDialog(this, "Created Successfully");

                        } catch (Exception ex) {
                            Logger.getLogger(CreateAccount.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Location And Destination Are Same");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Please Enter Valid Date");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Fill All Details");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please Enter Valid Date");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseClicked

    private void flightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flightActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeActionPerformed

    private void box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box1ActionPerformed

    private void box2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box2ActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void Table_FlightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_FlightMouseClicked
        int row = Table_Flight.getSelectedRow();
        TableModel m = Table_Flight.getModel();

        fn.setText(m.getValueAt(row, 0).toString());
        loc.setSelectedItem(m.getValueAt(row, 1).toString());
        des.setSelectedItem(m.getValueAt(row, 2).toString());

        try {

            SimpleDateFormat formatter = new SimpleDateFormat("MMM d, y");
            Date dt = new Date();

            dt = formatter.parse(m.getValueAt(row, 6).toString());
            d.setDate(dt);
        } catch (Exception e) {

        }
        Flight.setText(m.getValueAt(row, 4).toString());
        Time.setText(m.getValueAt(row, 5).toString());
        Price.setText(m.getValueAt(row, 3).toString());

    }//GEN-LAST:event_Table_FlightMouseClicked

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
        String str = fn.getText();

        search_flight(str);


    }//GEN-LAST:event_SearchMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");
            Statement s = con.createStatement();

            int Flight_no = Integer.parseInt(fn.getText());
            String Loc = (String) loc.getSelectedItem();
            String Des = (String) des.getSelectedItem();
            String Date = ((JTextField) d.getDateEditor().getUiComponent()).getText();
            String flight = Flight.getText();
            String price = Price.getText();
            String time = Time.getText();

            ResultSet rs = s.executeQuery("select * from flight where Flight_NO='" + Flight_no + "'");

            if (rs.next() == false) {
                JOptionPane.showMessageDialog(this, "No Any flight available of this details");
            } else {
                PreparedStatement ps = con.prepareStatement("UPDATE flight SET Location='" + Loc + "' ,Destination='" + Des + "' , Date='" + Date + "' , Flight='" + flight + "' , Price='" + price + "' , Time='" + time + "' where Flight_No='" + Flight_no + "'");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Flight Updated Successfully");
                clearTable();
                setFlightRecord();

            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateMouseClicked

    private void FlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FlightActionPerformed

    private void PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceActionPerformed

    private void TimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeActionPerformed

    private void locActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locActionPerformed

    private void desActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desActionPerformed

    private void fnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fnKeyReleased

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("select * from flight where Flight_No=" + Integer.parseInt(fn.getText()) + "");

            if (rs.next() != false) {
                //ResultSet r=stm.executeQuery("select * from Ticket where Flight_No="+Integer.parseInt(fn.getText())+"");

                PreparedStatement ps = conn.prepareStatement("delete from flight where Flight_No=" + Integer.parseInt(fn.getText()) + "");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Flight Deleted Successfully");
                clearTable();
                setFlightBookingStatus();
                setFlightRecord();

            } else {
                JOptionPane.showMessageDialog(this, "Please Check Your Flight_Number");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        SkyLinePage1 s = new SkyLinePage1();
        s.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyReleased
        String str = search1.getText();

        search_BookingStatus(str);
    }//GEN-LAST:event_search1KeyReleased

    private void Booking_StatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Booking_StatusMouseClicked
        int row = Booking_Status.getSelectedRow();
        TableModel m = Booking_Status.getModel();

        Fno.setText(m.getValueAt(row, 0).toString());
        String No_B = m.getValueAt(row, 4).toString();
        int No_Booking = 0;
        for (int i = 0; i < 2; i++) {
            char c = No_B.charAt(i);
            if (c == ' ') {
                No_Booking = Integer.parseInt(No_B.substring(0, i));
            }
        }

        showPieChart(No_Booking);


    }//GEN-LAST:event_Booking_StatusMouseClicked

    public void search_BookingStatus(String str) {
        model = (DefaultTableModel) Booking_Status.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        Booking_Status.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));

    }

    public void search(String str) {
        model = (DefaultTableModel) table_Account.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        table_Account.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));

    }

    public void search_flight(String s) {
        model = (DefaultTableModel) Table_Flight.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        Table_Flight.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(s));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControlRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Booking_Status;
    private javax.swing.JTextField Flight;
    private javax.swing.JLabel Fno;
    private javax.swing.JTextField Price;
    private javax.swing.JToggleButton Search;
    private rojerusan.RSTableMetro Table_Flight;
    private javax.swing.JTextField Time;
    private javax.swing.JComboBox<String> box1;
    private javax.swing.JComboBox<String> box2;
    private necesario.CustomUI customUI1;
    private com.toedter.calendar.JDateChooser d;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JToggleButton delete;
    private javax.swing.JComboBox<String> des;
    private javax.swing.JComboBox<String> flight;
    private javax.swing.JTextField fn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel lable;
    private javax.swing.JComboBox<String> loc;
    private javax.swing.JPanel panelChart;
    private javax.swing.JTextField price;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private javax.swing.JTextField search;
    private javax.swing.JTextField search1;
    private javax.swing.JTable table_Account;
    private javax.swing.JTextField time;
    private javax.swing.JToggleButton update;
    private necesario.VerticalLabelIUI verticalLabelIUI1;
    // End of variables declaration//GEN-END:variables
}
