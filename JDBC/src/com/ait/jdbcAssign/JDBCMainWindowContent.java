package com.ait.jdbcAssign;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.sql.*;

@SuppressWarnings("serial")
public class JDBCMainWindowContent extends JInternalFrame implements ActionListener {
	private final String HACKER = "Hacker";
	private final String ATTACKS = "Attacks";
	private final String CYBER_ATTACK_LOG = "CyberAttack_Log";
	private final String SEC_ORG = "Organizations_discovered";
	private final String ATT_ORG = "Attacked_Organization";
	private final String CYBER_ATT = "BreaComp";
	private final String CYBER_SEC = "CyberDiscovered";
	private final String CYBER_HACKER = "CyberHack";
	private final String DATE_FORMAT = "yyyy-mm-dd";
	// DB Connectivity Attributes
	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	private Container content;

	private JPanel panelForCyberLog;
	private JPanel panelHacker;
	private JPanel panelAttOrg;
	private JPanel panelAttacks;
	private JPanel panelSecOrg;
	private JPanel exportButtonPanel;
	private JPanel exportConceptDataPanel;
	private JScrollPane attackLog;
	private JScrollPane hackers;
	private JScrollPane attacks;
	private JScrollPane attOrg;
	private JScrollPane secOrg;
	private JScrollPane cyber_attacked_org;
	private JScrollPane cyber_sec_org;
	private JScrollPane cyber_hacker;
	private JTabbedPane tabs;
	

	private Border lineBorder;
	// labels for cyberattacklog
	private JLabel cyber_ID_Label = new JLabel("Cyber_ID");
	private JLabel cyber_attack_ID_Label = new JLabel("Attack_ID");
	private JLabel cyber_sec_org_ID_Label = new JLabel("Sec_Org_ID");
	private JLabel cyber_hacker_ID_Label = new JLabel("Hacker_ID");
	private JLabel cyber_attOrg_ID_Label = new JLabel("Att_Org_ID");
	private JLabel cyber_date_Label = new JLabel("Date");
	private JLabel cyber_howAttDelivered_Label = new JLabel("Attack Description");
	private JLabel cyber_damage_Label = new JLabel("Damage");
	// textfields for cyberattacklog
	private JTextField cyber_ID_Text = new JTextField(11);
	private JTextField cyber_attack_ID_Text = new JTextField(50);
	private JTextField cyber_sec_org_ID_Text = new JTextField(50);
	private JTextField cyber_hacker_ID_Text = new JTextField(50);
	private JTextField cyber_attOrg_ID_Text = new JTextField(50);
	private JTextField cyber_date_Text = new JFormattedTextField(DATE_FORMAT);
	private JTextField cyber_howAttDelivered_Text = new JTextField(100);
	private JTextField cyber_damage_Text = new JTextField(10);

	// labels for hacker
	private JLabel hacker_ID_Label = new JLabel("Hacker_ID");
	private JLabel hacker_name_Label = new JLabel("Hacker_Name");
	private JLabel hacker_size_Label = new JLabel("Size");
	private JLabel hacker_location_Label = new JLabel("Location");
	// textfields for hacker
	private JTextField hacker_ID_Text = new JTextField(50);
	private JTextField hacker_name_Text = new JTextField(50);
	private JTextField hacker_size_Text = new JTextField(11);
	private JTextField hacker_location_Text = new JTextField(20);

	// labels for attacked organizations
	private JLabel attOrg_ID_Label = new JLabel("Attacked Org. ID");
	private JLabel attOrg_name_Label = new JLabel("Attacked Org. Name");
	private JLabel attOrg_business_Label = new JLabel("Type Of Business");
	private JLabel attOrg_size_Label = new JLabel("Size of Organization");
	private JLabel attOrg_location_Label = new JLabel("Location");
	private JLabel attOrg_worth_Label = new JLabel("Worth");
	// textfields for attacked organizations
	private JTextField attOrg_ID_Text = new JTextField();
	private JTextField attOrg_name_Text = new JTextField();
	private JTextField attOrg_business_Text = new JTextField();
	private JTextField attOrg_size_Text = new JTextField();
	private JTextField attOrg_location_Text = new JTextField();
	private JTextField attOrg_worth_Text = new JTextField();

	// labels for attacs
	private JLabel attack_ID_Label = new JLabel("Attack ID");
	private JLabel attack_name_Label = new JLabel("Attack Name");
	private JLabel attack_type_Label = new JLabel("Type Of Attack");
	private JLabel attack_description_Label = new JLabel("Description");
	// textfields for attacks
	private JTextField attack_ID_Text = new JTextField();
	private JTextField attack_name_Text = new JTextField();
	private JTextField attack_type_Text = new JTextField();
	private JTextField attack_description_Text = new JTextField();

	// labels for security organizations
	private JLabel sec_ID_Label = new JLabel("Security Org. Name");
	private JLabel secOrg_name_Label = new JLabel("Security Org. Name");
	private JLabel secOrg_size_Label = new JLabel("Size");
	private JLabel secOrg_location_Label = new JLabel("Location");
	// textfields for security organizations
	private JTextField secOrg_ID_Text = new JTextField();
	private JTextField secOrg_name_Text = new JTextField();
	private JTextField secOrg_size_Text = new JTextField();
	private JTextField secOrg_lovation_Text = new JTextField();

	private static QueryTableModel AttackLog = new QueryTableModel();
	private static QueryTableModel Hackers = new QueryTableModel();
	private static QueryTableModel Attacks = new QueryTableModel();
	private static QueryTableModel AttOrg = new QueryTableModel();
	private static QueryTableModel SecOrg = new QueryTableModel();
	private static QueryTableModel Cyber_Att = new QueryTableModel();
	private static QueryTableModel Cyber_Sec = new QueryTableModel();
	private static QueryTableModel Cyber_Hack = new QueryTableModel();

	// Add the models to JTabels
	private JTable TableofDBContents = new JTable(AttackLog);
	private JTable TableofDBContentsHack = new JTable(Hackers);
	private JTable TableofDBContentsAttacks = new JTable(Attacks);
	private JTable TableofDBContentsAttOrg = new JTable(AttOrg);
	private JTable TableofDBContentsSecOrg = new JTable(SecOrg);
	private JTable TableofDBContentsCyber_Attack = new JTable(Cyber_Att);
	private JTable TableofDBContentsCyber_sec_org = new JTable(Cyber_Sec);
	private JTable TableofDBContentsCyber_Hacker = new JTable(Cyber_Hack);

	// Buttons for inserting, and updating members
	// also a clear button to clear details panel
	private JButton updateButton = new JButton("Update");
	private JButton insertButton = new JButton("Insert");
	private JButton exportButton = new JButton("Export");
	private JButton deleteButton = new JButton("Delete");
	private JButton clearButton = new JButton("Clear");

	private JButton attacksInTime = new JButton("Sum Of Type Of Attack");
	private JTextField sumOfAttacks = new JTextField();
	private JTextField avgLossPerAttack_text = new JTextField();
	private JButton avgLostPerAttack = new JButton("Avg Loss per Attack");
	private JButton mostAttackedCompanies = new JButton("Most Attacked Company");
	private JButton chart = new JButton("Some Stats");
	private JButton numOfHackersInvovled = new JButton("Nr. Of Currently Hackers");

	public JDBCMainWindowContent(String aTitle) {
		// setting up the GUI
		super(aTitle, false, false, false, false);
		setEnabled(true);

		initiate_db_conn();
		// add the 'main' panel to the Internal Frame
		content = getContentPane();
		content.setLayout(null);
		content.setBackground(Color.lightGray);
		lineBorder = BorderFactory.createEtchedBorder(15, Color.red, Color.black);

		// setup cyberLog panel
		panelForCyberLog = new JPanel();
		panelForCyberLog.setLayout(new GridLayout(11, 2));
		panelForCyberLog.setBackground(Color.lightGray);
		panelForCyberLog.setBorder(BorderFactory.createTitledBorder(lineBorder, "Attack Log Details"));
		// labels for cyberLog
		panelForCyberLog.add(cyber_ID_Label);
		panelForCyberLog.add(cyber_ID_Text);
		panelForCyberLog.add(cyber_attack_ID_Label);
		panelForCyberLog.add(cyber_attack_ID_Text);
		panelForCyberLog.add(cyber_sec_org_ID_Label);
		panelForCyberLog.add(cyber_sec_org_ID_Text);
		panelForCyberLog.add(cyber_hacker_ID_Label);
		panelForCyberLog.add(cyber_hacker_ID_Text);
		panelForCyberLog.add(cyber_attOrg_ID_Label);
		panelForCyberLog.add(cyber_attOrg_ID_Text);
		panelForCyberLog.add(cyber_date_Label);
		panelForCyberLog.add(cyber_date_Text);
		panelForCyberLog.add(cyber_howAttDelivered_Label);
		panelForCyberLog.add(cyber_howAttDelivered_Text);
		panelForCyberLog.add(cyber_damage_Label);
		panelForCyberLog.add(cyber_damage_Text);

		// set up hacker panel
		panelHacker = new JPanel();
		panelHacker.setLayout(new GridLayout(4, 2));
		panelHacker.setBackground(Color.lightGray);
		panelHacker.setBorder(BorderFactory.createTitledBorder(lineBorder, "Hacker Details"));
		// labels for hacker
		panelHacker.add(hacker_ID_Label);
		panelHacker.add(hacker_ID_Text);
		panelHacker.add(hacker_name_Label);
		panelHacker.add(hacker_name_Text);
		panelHacker.add(hacker_size_Label);
		panelHacker.add(hacker_size_Text);
		panelHacker.add(hacker_location_Label);
		panelHacker.add(hacker_location_Text);

		// set up attacked organizations panel
		panelAttOrg = new JPanel();
		panelAttOrg.setLayout(new GridLayout(6, 2));
		panelAttOrg.setBackground(Color.lightGray);
		panelAttOrg.setBorder(BorderFactory.createTitledBorder(lineBorder, "Attacked Org. Details"));
		// labels for attacked organizations
		panelAttOrg.add(attOrg_ID_Label);
		panelAttOrg.add(attOrg_ID_Text);
		panelAttOrg.add(attOrg_name_Label);
		panelAttOrg.add(attOrg_name_Text);
		panelAttOrg.add(attOrg_business_Label);
		panelAttOrg.add(attOrg_business_Text);
		panelAttOrg.add(attOrg_size_Label);
		panelAttOrg.add(attOrg_size_Text);
		panelAttOrg.add(attOrg_location_Label);
		panelAttOrg.add(attOrg_location_Text);
		panelAttOrg.add(attOrg_worth_Label);
		panelAttOrg.add(attOrg_worth_Text);

		// set up attacks
		panelAttacks = new JPanel();
		panelAttacks.setLayout(new GridLayout(4, 2));
		panelAttacks.setBackground(Color.lightGray);
		panelAttacks.setBorder(BorderFactory.createTitledBorder(lineBorder, "Attacks Details"));
		// labels for attacks
		panelAttacks.add(attack_ID_Label);
		panelAttacks.add(attack_ID_Text);
		panelAttacks.add(attack_name_Label);
		panelAttacks.add(attack_name_Text);
		panelAttacks.add(attack_type_Label);
		panelAttacks.add(attack_type_Text);
		panelAttacks.add(attack_description_Label);
		panelAttacks.add(attack_description_Text);

		// set up security organizations
		panelSecOrg = new JPanel();
		panelSecOrg.setLayout(new GridLayout(4, 2));
		panelSecOrg.setBackground(Color.lightGray);
		panelSecOrg.setBorder(BorderFactory.createTitledBorder(lineBorder, "Security Org. Details"));
		// labels for security organizations
		panelSecOrg.add(sec_ID_Label);
		panelSecOrg.add(secOrg_ID_Text);
		panelSecOrg.add(secOrg_name_Label);
		panelSecOrg.add(secOrg_name_Text);
		panelSecOrg.add(secOrg_size_Label);
		panelSecOrg.add(secOrg_size_Text);
		panelSecOrg.add(secOrg_location_Label);
		panelSecOrg.add(secOrg_lovation_Text);

		// export data
		exportButtonPanel = new JPanel();
		exportButtonPanel.setLayout(new GridLayout(4, 0));
		exportButtonPanel.setBackground(Color.lightGray);
		exportButtonPanel.setBorder(BorderFactory.createTitledBorder(lineBorder, "Export Data"));
		exportButtonPanel.add(attacksInTime);
		exportButtonPanel.add(sumOfAttacks);
		exportButtonPanel.add(avgLostPerAttack);
		exportButtonPanel.add(avgLossPerAttack_text);
		exportButtonPanel.add(mostAttackedCompanies);
		exportButtonPanel.add(chart);
		exportButtonPanel.add(numOfHackersInvovled);
		exportButtonPanel.setSize(700, 200);
		exportButtonPanel.setLocation(3, 300);
		content.add(exportButtonPanel);

		insertButton.setSize(100, 30);
		updateButton.setSize(100, 30);
		exportButton.setSize(100, 30);
		deleteButton.setSize(100, 30);
		clearButton.setSize(100, 30);

		insertButton.setLocation(370, 10);
		updateButton.setLocation(370, 110);
		exportButton.setLocation(370, 160);
		deleteButton.setLocation(370, 60);
		clearButton.setLocation(370, 210);

		insertButton.addActionListener(this);
		updateButton.addActionListener(this);
		exportButton.addActionListener(this);
		deleteButton.addActionListener(this);
		clearButton.addActionListener(this);
		attacksInTime.addActionListener(this);
		avgLostPerAttack.addActionListener(this);
		mostAttackedCompanies.addActionListener(this);
		chart.addActionListener(this);
		numOfHackersInvovled.addActionListener(this);

		content.add(insertButton);
		content.add(updateButton);
		content.add(exportButton);
		content.add(deleteButton);
		content.add(clearButton);

		ChangeListener ch = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

				if (tabs.getSelectedIndex() == 0) {
					panelSecOrg.setVisible(false);
					panelHacker.setVisible(false);
					panelAttacks.setVisible(false);
					panelAttOrg.setVisible(false);
					panelForCyberLog.setVisible(true);
				} else if (tabs.getSelectedIndex() == 1) {
					// attack details
					panelAttacks.setSize(360, 140);
					panelAttacks.setLocation(3, 0);

					panelForCyberLog.setVisible(false);
					panelHacker.setVisible(false);
					panelSecOrg.setVisible(false);
					panelAttOrg.setVisible(false);
					panelAttacks.setVisible(true);

				} else if (tabs.getSelectedIndex() == 2) {
					// hacker details
					panelHacker.setSize(360, 150);
					panelHacker.setLocation(3, 0);

					panelForCyberLog.setVisible(false);
					panelAttOrg.setVisible(false);
					panelAttacks.setVisible(false);
					panelSecOrg.setVisible(false);
					panelHacker.setVisible(true);
				} else if (tabs.getSelectedIndex() == 3) {
					// attacked organizations details
					panelAttOrg.setSize(360, 220);
					panelAttOrg.setLocation(3, 0);

					panelForCyberLog.setVisible(false);
					panelHacker.setVisible(false);
					panelAttacks.setVisible(false);
					panelSecOrg.setVisible(false);
					panelAttOrg.setVisible(true);

				} else if (tabs.getSelectedIndex() == 4) {
					// security organizations details
					panelSecOrg.setSize(360, 150);
					panelSecOrg.setLocation(3, 0);

					panelForCyberLog.setVisible(false);
					panelHacker.setVisible(false);
					panelAttOrg.setVisible(false);
					panelAttacks.setVisible(false);
					panelSecOrg.setVisible(true);
				}
			}
		};

		// database content
		//TableofDBContents.setPreferredScrollableViewportSize(new Dimension(900, 300));

		attackLog = new JScrollPane(TableofDBContents, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		attackLog.setBackground(Color.lightGray);

		hackers = new JScrollPane(TableofDBContentsHack, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		hackers.setBackground(Color.lightGray);

		attacks = new JScrollPane(TableofDBContentsAttacks, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		attacks.setBackground(Color.lightGray);

		attOrg = new JScrollPane(TableofDBContentsAttOrg, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		attOrg.setBackground(Color.lightGray);

		secOrg = new JScrollPane(TableofDBContentsSecOrg, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		secOrg.setBackground(Color.lightGray);
		
		cyber_attacked_org = new JScrollPane(TableofDBContentsCyber_Attack, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		cyber_attacked_org.setBackground(Color.lightGray);
		
		cyber_sec_org = new JScrollPane(TableofDBContentsCyber_sec_org, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		cyber_sec_org.setBackground(Color.lightGray);
		
		cyber_hacker = new JScrollPane(TableofDBContentsCyber_Hacker, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		cyber_hacker.setBackground(Color.lightGray);

		tabs = new JTabbedPane();

		tabs.addTab("Attack Log", attackLog);
		tabs.add("Attacks", attacks);
		tabs.add("Hackers", hackers);
		tabs.add("Attacked Organization", attOrg);
		tabs.add("Security Companies", secOrg);
		tabs.add("CyberAttack/Attacked_Org", cyber_attacked_org);
		tabs.add("CyberAttack/Sec_Org", cyber_sec_org);
		tabs.add("CyberAttack/Hacker", cyber_hacker);
		tabs.addChangeListener(ch);

		tabs.setSize(1100, 300);
		tabs.setLocation(477, 0);
		tabs.setBorder(BorderFactory.createTitledBorder(lineBorder, "Database Content"));

		// detail size
		panelForCyberLog.setSize(360, 300);
		panelForCyberLog.setLocation(3, 0);

		content.add(panelForCyberLog);
		content.add(panelHacker).setVisible(false);
		content.add(panelAttOrg).setVisible(false);
		content.add(panelAttacks).setVisible(false);
		content.add(panelSecOrg).setVisible(false);
		content.add(tabs, BorderLayout.CENTER);

		setSize(982, 645);
		setVisible(true);

		AttackLog.refreshFromDB(stmt, CYBER_ATTACK_LOG);
		Attacks.refreshFromDB(stmt, ATTACKS);
		AttOrg.refreshFromDB(stmt, ATT_ORG);
		SecOrg.refreshFromDB(stmt, SEC_ORG);
		Hackers.refreshFromDB(stmt, HACKER);
		Cyber_Att.refreshFromDB(stmt, CYBER_ATT);
		Cyber_Hack.refreshFromDB(stmt, CYBER_HACKER);
		Cyber_Sec.refreshFromDB(stmt, CYBER_SEC);
	}

	public void initiate_db_conn() {
		try {
			// Load the JConnector Driver
			Class.forName("com.mysql.jdbc.Driver");
			// Specify the DB Name
			String url = "jdbc:mysql://localhost:3306/A00268649";
			// Connect to DB using DB URL, Username and password
			con = DriverManager.getConnection(url, "helmuts@localhost", "root");
			// Create a generic statement which is passed to the TestInternalFrame1
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("Error: Failed to connect to database\n" + e.getMessage());
		}
	}

	// event handling for members desktop
	public void actionPerformed(ActionEvent e)
	{
		 Object target=e.getSource();
		 if (target == clearButton)
		 {
			 if(tabs.getSelectedIndex() == 0) {
				 cyber_ID_Text.setText("");
				 cyber_attack_ID_Text.setText("");
				 cyber_sec_org_ID_Text.setText("");
				 cyber_hacker_ID_Text.setText("");
				 cyber_attOrg_ID_Text.setText("");
				 cyber_date_Text.setText(DATE_FORMAT);
				 cyber_howAttDelivered_Text.setText("");
				 cyber_damage_Text.setText("");	 
				 
			 } else if (tabs.getSelectedIndex() == 1 ) {
				 attack_ID_Text.setText(""); 
				 attack_name_Text.setText(""); 
				 attack_type_Text.setText("");
				 attack_description_Text.setText(""); 
					
			 } else if (tabs.getSelectedIndex() == 2) {
				 hacker_ID_Text.setText("");
				 hacker_name_Text.setText("");
				 hacker_size_Text.setText("");
				 hacker_location_Text.setText("");
			 } else if (tabs.getSelectedIndex() == 3) {
				 attOrg_ID_Text.setText("");
				 attOrg_name_Text.setText("");
				 attOrg_business_Text.setText("");
				 attOrg_size_Text.setText("");
				 attOrg_location_Text.setText("");
				 attOrg_worth_Text.setText("");
			 } else if (tabs.getSelectedIndex() == 4) {
				 secOrg_ID_Text.setText("");
				 secOrg_name_Text.setText("");
				 secOrg_size_Text.setText("");
				 secOrg_lovation_Text.setText("");
			 }
		 }
		
		 if (target == insertButton)
		 {		 
	 		try
	 		{
	 			if(tabs.getSelectedIndex() == 0) {
					//log
	 				//TODO stored procedure if does not exist create  
					String  insert = "INSERT INTO " + CYBER_ATTACK_LOG + "(Cyber_ID, Attack_ID, Disc_Org_ID, Hacker_ID, Attacked_Org_ID, Date, "
					  		+ "How_Attack_Delivered, Damage) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
					  ps = con.prepareStatement(insert);
					  ps.setString(1, null);
					  ps.setString(2, cyber_attack_ID_Text.getText());
					  ps.setString(3, cyber_sec_org_ID_Text.getText());
					  ps.setString(4, cyber_hacker_ID_Text.getText());
					  ps.setString(5, cyber_attOrg_ID_Text.getText());
					  ps.setString(6, cyber_date_Text.getText());
					  ps.setString(7, cyber_howAttDelivered_Text.getText());
					  ps.setDouble(8, Double.parseDouble(cyber_damage_Text.getText()));
				} else if (tabs.getSelectedIndex() == 1 ) {
					 //attacks
					String	insert = "INSERT INTO " + ATTACKS + "(attack_ID, Attack_Name, TypeOfAttack, Description) "
							+ " VALUES(?, ?, ?, ?)";
					ps = con.prepareStatement(insert);
					ps.setString(1, null);
					ps.setString(2, attack_name_Text.getText());
					ps.setString(3, attack_type_Text.getText());
					ps.setString(4, attack_description_Text.getText());
						
				} else if (tabs.getSelectedIndex() == 2) {
					//hacker
					String insert = "INSERT INTO " + HACKER + "(h_ID, Hacker_Name, Size, Location) VALUES(?, ?, ?, ?)";
					
					ps = con.prepareStatement(insert);
					ps.setString(1, null);		
					ps.setString(2, hacker_name_Text.getText());		
					ps.setInt(3, Integer.parseInt(hacker_size_Text.getText()));		
					ps.setString(4, hacker_location_Text.getText());		
							
				} else if (tabs.getSelectedIndex() == 3) {
					 //attorg
					String insert = "INSERT INTO " + ATT_ORG + "(attOrg_ID, Attack_Org_Name, Type_of_Business, Size_Of_Organization, Location, Worth) "
							+ "VALUES(?, ?, ?, ?, ?, ?)";
					
					ps = con.prepareStatement(insert);
					ps.setString(1, null);
					ps.setString(2, attOrg_name_Text.getText());
					ps.setString(3, attOrg_business_Text.getText());
					ps.setInt(4, Integer.parseInt(attOrg_size_Text.getText()));
					ps.setString(5, attOrg_location_Text.getText());
					ps.setDouble(6, Double.parseDouble(attOrg_worth_Text.getText()));
				} else if (tabs.getSelectedIndex() == 4) {
					 //secorg
					String insert = "INSERT INTO " + SEC_ORG + "(sec_ID, Discov_Org_Name, Size_Of_Organization, Location) "
							+ "VALUES(?, ?, ?, ?)";
					
					ps = con.prepareStatement(insert);
					ps.setString(1, null);
					ps.setString(2, secOrg_name_Text.getText());
					ps.setInt(3, Integer.parseInt(secOrg_size_Text.getText()));
					ps.setString(4, secOrg_lovation_Text.getText());
				} 
 					
	 			ps.execute();
 				//stmt.executeUpdate(insert);
 			
	 		}
	 		catch (SQLException sqle)
	 		{
	 			System.err.println("Error with members insert:\n"+sqle.toString());
	 		}
	 		finally
	 		{
	 			AttackLog.refreshFromDB(stmt, CYBER_ATTACK_LOG);
	 			Attacks.refreshFromDB(stmt, ATTACKS);
	 			AttOrg.refreshFromDB(stmt, ATT_ORG);
	 			SecOrg.refreshFromDB(stmt, SEC_ORG);
	 			Hackers.refreshFromDB(stmt, HACKER);
	 			Cyber_Att.refreshFromDB(stmt, CYBER_ATT);
	 			Cyber_Hack.refreshFromDB(stmt, CYBER_HACKER);
	 			Cyber_Sec.refreshFromDB(stmt, CYBER_SEC);
			}
		 }
		 if (target == deleteButton)
		 {
		 	
	 		try
	 		{
	 			if(tabs.getSelectedIndex() == 0) {
					//log
					String delete = "call deleteLog(?)";
					ps = con.prepareCall(delete);
					ps.setInt(1, Integer.parseInt(cyber_ID_Text.getText()));
					
				} else if (tabs.getSelectedIndex() == 1 ) {
					 //attacks
					String delete = "call deleteAttack(?)";
					ps = con.prepareCall(delete);
					ps.setString(1, attack_ID_Text.getText());
						
				} else if (tabs.getSelectedIndex() == 2) {
					//hacker
					String delete = "call deleteHacker(?)";
					ps = con.prepareCall(delete);
					ps.setInt(1, Integer.parseInt(hacker_ID_Text.getText()));
					
				} else if (tabs.getSelectedIndex() == 3) {
					 //attorg
					String delete = "call deleteAttOrg(?)";
					ps = con.prepareCall(delete);
					ps.setString(1, attOrg_ID_Text.getText());
				} else if (tabs.getSelectedIndex() == 4) {
					 //secorg
					String delete = "call deleteSecOrg(?)";
					ps = con.prepareCall(delete);
					ps.setInt(1, Integer.parseInt(secOrg_ID_Text.getText()));
				}
	 			ps.execute();
	 		}
	 		catch (SQLException sqle)
	 		{
	 			System.err.println("Error with delete:\n"+sqle.toString());
	 		}
	 		finally
	 		{
	 			AttackLog.refreshFromDB(stmt, CYBER_ATTACK_LOG);
	 			Attacks.refreshFromDB(stmt, ATTACKS);
	 			AttOrg.refreshFromDB(stmt, ATT_ORG);
	 			SecOrg.refreshFromDB(stmt, SEC_ORG);
	 			Hackers.refreshFromDB(stmt, HACKER);
	 			Cyber_Att.refreshFromDB(stmt, CYBER_ATT);
	 			Cyber_Hack.refreshFromDB(stmt, CYBER_HACKER);
	 			Cyber_Sec.refreshFromDB(stmt, CYBER_SEC);
			}
		 }
		 if (target == updateButton)
		 {	 	
	 		try
	 		{ 			
	 			if(tabs.getSelectedIndex() == 0) {
					//log
	 				if(cyber_hacker_ID_Text.getText().length() > 0 && cyber_sec_org_ID_Text.getText().length() > 0) {
	 					String update = "call updateLogSecHack(?, ?, ?)";
		 				ps = con.prepareCall(update);
		 				ps.setInt(1, Integer.parseInt(cyber_ID_Text.getText()));
		 				ps.setString(2, cyber_sec_org_ID_Text.getText());	
		 				ps.setString(3, cyber_hacker_ID_Text.getText());	
		 				
	 				} else if (cyber_hacker_ID_Text.getText().length() > 0) { 
	 					String update = "call updateLogHacker(?,?)";
		 				ps = con.prepareCall(update);
		 				ps.setInt(1, Integer.parseInt(cyber_ID_Text.getText()));
		 				ps.setString(2, cyber_hacker_ID_Text.getText());	
		 				
	 				} else if(cyber_sec_org_ID_Text.getText().length() > 0) {
	 					String update = "call updateLogSec(?,?)";
	 					
		 				ps = con.prepareCall(update);
		 				ps.setInt(1, Integer.parseInt(cyber_ID_Text.getText()));
		 				ps.setString(2, cyber_sec_org_ID_Text.getText());
	 				}
	 				
				} else if (tabs.getSelectedIndex() == 1 ) {
					 //attacks
					String update = "UPDATE " + ATTACKS + " SET Attack_name = (?) WHERE attack_ID = (?)";
					ps = con.prepareStatement(update);
					ps.setString(1, attack_name_Text.getText());
					ps.setString(2, attack_ID_Text.getText());
						
				} else if (tabs.getSelectedIndex() == 2) {
					//hacker
					String update = "UPDATE " + HACKER + " SET Hacker_name = (?) WHERE h_ID = (?)";
					ps = con.prepareStatement(update);
					ps.setString(1, hacker_name_Text.getText());
					ps.setString(2, hacker_ID_Text.getText());
					
				} else if (tabs.getSelectedIndex() == 3) {
					 //attorg
					String update = "UPDATE " + ATT_ORG + " SET Attack_Org_Name = (?) WHERE attOrg_ID = (?)";
					ps = con.prepareStatement(update);
					ps.setString(1, attOrg_name_Text.getText());
					ps.setString(2, attOrg_ID_Text.getText());
				} else if (tabs.getSelectedIndex() == 4) {
					 //secorg
					String update = "UPDATE " + SEC_ORG + " SET Discov_Org_Name = (?) WHERE sec_ID = (?)";
					ps = con.prepareStatement(update);
					ps.setString(1, secOrg_name_Text.getText());
					ps.setString(2, secOrg_ID_Text.getText());
				}
	 			ps.execute();
				
 			}
	 		catch (SQLException sqle){
	 			System.err.println("Error with members insert:\n"+sqle.toString());
	 		}
	 		finally{
	 			AttackLog.refreshFromDB(stmt, CYBER_ATTACK_LOG);
	 			Attacks.refreshFromDB(stmt, ATTACKS);
	 			AttOrg.refreshFromDB(stmt, ATT_ORG);
	 			SecOrg.refreshFromDB(stmt, SEC_ORG);
	 			Hackers.refreshFromDB(stmt, HACKER);
	 			Cyber_Att.refreshFromDB(stmt, CYBER_ATT);
	 			Cyber_Hack.refreshFromDB(stmt, CYBER_HACKER);
	 			Cyber_Sec.refreshFromDB(stmt, CYBER_SEC);
			}
		 }
		 if (target == exportButton){  		
				//set cmd to write out all the table data to the csv
			 try {
				 if(tabs.getSelectedIndex() == 0) {
					 String cmd = "SELECT * FROM logView";
					 rs = stmt.executeQuery(cmd);
				 } else if(tabs.getSelectedIndex() == 1) {
					 String cmd = "SELECT * FROM attacksView";
					 rs = stmt.executeQuery(cmd);
				 } else if (tabs.getSelectedIndex() == 2) {
					 String cmd = "SELECT * FROM hackerView";
					 rs = stmt.executeQuery(cmd);
				 } else if (tabs.getSelectedIndex() == 3) {
					 String cmd = "SELECT * FROM attacked_orgView";
					 rs = stmt.executeQuery(cmd);
				 } else if (tabs.getSelectedIndex() == 4) {
					 String cmd = "SELECT * FROM securityView";
					 rs = stmt.executeQuery(cmd);
				 }
					writeToFile(rs);
			 }catch(SQLException sqle) {
				 System.err.println("Error with export..." + sqle.toString());
			 }
				

		 }
		 if(target == attacksInTime) {
			
			try {
				String cmd = "CALL selectAttacks(?)";
				
				ps = con.prepareStatement(cmd);
				ps.setString(1, sumOfAttacks.getText());
				rs = ps.executeQuery();
				rs.next();
				JOptionPane.showMessageDialog(null, rs.getString(1), "Number Of Attacks", JOptionPane.INFORMATION_MESSAGE );

			} catch (SQLException sqle) {
				System.err.println("Attack time export error..." + sqle.toString());
			}
		 }
		 if(target == avgLostPerAttack) {
			
			 try {
					String cmd = "CALL avgLossPerAttack(?)";
					
					ps = con.prepareStatement(cmd);
					ps.setString(1, avgLossPerAttack_text.getText());
					rs = ps.executeQuery();
					rs.next();
					
					JOptionPane.showMessageDialog(null, rs.getDouble(1), "AVG Loss", JOptionPane.INFORMATION_MESSAGE );

				} catch (SQLException sqle) {
					System.err.println("AVG loss per attack error..." + sqle.toString());
				}
		 }
		 if(target == mostAttackedCompanies) {
			 
			 try {
				 String cmd = "CALL mostAttackedCompany(@company, @number)";
				 
				 rs = stmt.executeQuery(cmd);
				 rs.next();
				 
				 JOptionPane.showMessageDialog(null, rs.getString(1) + " attacked " + rs.getString(2) + " times.", "Most Attacked Company", JOptionPane.INFORMATION_MESSAGE );
				 
			 } catch (SQLException sqle) {
				 System.err.println("Most attacked companies..." + sqle.toString());
			 }
		 }
		 if(target == chart) {
			 
			 try {
				 String cmd = "CALL chart(@attack1, @attack2, @attack3)";
				 
				 rs = stmt.executeQuery(cmd);

				 pieGraph(rs, "Most Popular Attacks");
			 } catch (SQLException sqle) {
				 System.err.println("Most popular attacks..." + sqle.toString());
			 }
		 }
		 if(target == numOfHackersInvovled) {
			 
			 try {
				 String cmd = "SELECT numOfHackers()";
				 rs = stmt.executeQuery(cmd);
				 rs.next();
				 JOptionPane.showMessageDialog(null, rs.getString(1) + " hacker organizations are currently active! ", "Active Hackers", JOptionPane.INFORMATION_MESSAGE );
				
			 } catch (SQLException sqle) {
				 System.err.println("Number Of Active Hackers..." + sqle.toString());
			 }
		 }
	}
	
	public  void pieGraph(ResultSet rs, String title) {
		try {
			DefaultPieDataset dataset = new DefaultPieDataset();
			
			while (rs.next()) {
				String attack1 = rs.getString(1);
				String value = rs.getString(2);
				
				dataset.setValue(attack1 + " " + value, new Double(value));
			}
			JFreeChart chart = ChartFactory.createPieChart(title, dataset, false, true, true);

			ChartFrame frame = new ChartFrame(title, chart);
			chart.setBackgroundPaint(Color.WHITE);
			frame.pack();
			frame.setVisible(true);
			 
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void writeToFile(ResultSet rs){
		try{
			FileWriter outputFile = new FileWriter("Output.csv");
			PrintWriter printWriter = new PrintWriter(outputFile);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumns = rsmd.getColumnCount();

			for(int i=0;i<numColumns;i++){
				printWriter.print(rsmd.getColumnLabel(i+1)+",");
			}
			printWriter.print("\n");
			while(rs.next()){
				for(int i=0;i<numColumns;i++){
					printWriter.print(rs.getString(i+1)+",");
				}
				printWriter.print("\n");
				printWriter.flush();
			}
			printWriter.close();
		}
		catch(Exception e){e.printStackTrace();}
	}
}
