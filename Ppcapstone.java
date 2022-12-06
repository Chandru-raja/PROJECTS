package dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ppcapstone {
	

	public static void main(String[] args) {
		JLabel l1,l2;
		JTextArea mt;  
		JTextField t0,t1,t2,t3; 
		
		// TODO Auto-generated method stub
		
		try{ 
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root123");
			Statement stmt=con.createStatement();
		 
		JFrame f=new JFrame();
		JPanel panel=new JPanel();  
        panel.setBounds(0,0,800,50); 
        panel.setBackground(Color.gray); 
        f.add(panel); 
        
        
        
        l1=new JLabel("INVENTORY MANAGEMENT SYSTEM");  
        l1.setBounds(280,10,100,100);  
        l1.setFont(new Font("Verdana", Font.BOLD, 30));
        panel.add(l1);
        
        
         
        t1=new JTextField("Product Name");  
        t1.setBounds(300,110,200,30);
        t2=new JTextField("Quantity");  
        t2.setBounds(300,160,200,30);  
        t3=new JTextField("Price");  
        t3.setBounds(300,210,200,30);
        t0=new JTextField("ID");  
        t0.setBounds(300,60,200,30);
        f.add(t0);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.setSize(400,400);
        
        
          
		JButton b1 = new JButton("UPDATE PRODUCT");
		b1.setBounds(10,100,190,30);
		b1.setFocusable(false);
		JButton b2 = new JButton("ADD NEW PRODUCT");
		b2.setBounds(10,140,190,30);
		JButton b3 = new JButton("DISPLAY PRODUCTS");
		b3.setBounds(10,180,190,30);
		JButton b4 = new JButton("DELETE PRODUCTS");
		b4.setBounds(10,220,190,30);
		b1.setFocusable(false);
		b2.setFocusable(false);
		b3.setFocusable(false);
		b4.setFocusable(false);

		l2=new JLabel();  
	     l2.setBounds(0,50,210,800);
	     l2.setBackground(Color.DARK_GRAY);
	     l2.setOpaque(true);
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(l2);
		
		
		mt=new JTextArea("  Details Display here:\n");  
        mt.setBounds(210,280,800,400);  
        mt.setBackground(Color.LIGHT_GRAY);
        mt.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 15));
        f.add(mt);
        
        b1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	
		    	try {
	            	String sql = "UPDATE inventory SET Product_Name = '"+t1.getText().toString()+"',quantity = "+t2.getText().toString()+",pirce = "+t3.getText()+" WHERE Product_ID = "+t0.getText()+";";
	            	PreparedStatement p = con.prepareStatement(sql);
	            	p.executeUpdate();
	            	mt.setText("INFORMATION UPDATED SUCCESSFULLY");
	            	}
		    	catch(Exception e2){
		    		System.out.println(e2);
		    	}
		    	
		    }});
        
        b2.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	String query1 = "INSERT INTO inventory " + "VALUES ("+t0.getText()+",'"+t1.getText()+"',"+t2.getText()+","+t3.getText()+");";
		        try {
					stmt.executeUpdate(query1);
					mt.setText("INFORMATION ADDED SUCCESSFULLY");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }});
        
        b3.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
	            try {
	            	String sql = "select * from inventory";
	            	PreparedStatement p = con.prepareStatement(sql);
	            	ResultSet rs = p.executeQuery();
	            	mt.setText("PRODUCT ID"+"\t"+"NAME"+"\t\t"+"QUANTITY"+"\t"+"PRICE\n");
	            	while (rs.next()) {
	                    int id = rs.getInt("Product_ID");
	                    String name = rs.getString("Product_Name");
	                    String Quantity = rs.getString("quantity");
	                    int Price = rs.getInt("pirce");
	                    mt.append(id + "\t" + name+ "\t\t" + Quantity+"\t" + Price+"\n");
	                }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    }  
	    }); 
        
        b4.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	String query1 = "delete from inventory where Product_ID="+t0.getText()+";";
		        try {
					stmt.executeUpdate(query1);
					mt.setText("INFORMATION DELETED SUCCESSFULLY");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }});
		 
		f.setTitle("INVENTORY MANAGEMENT SYSTEM");
		f.setSize(800,600);
		f.setLayout(null);
		f.setVisible(true);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		/*
		 * try{ Class.forName("com.mysql.jdbc.Driver"); Connection
		 * con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root",
		 * "root123");
		 * 
		 * Statement stmt=con.createStatement();
		 * stmt.executeUpdate("insert into testing values(4,'D',150);"); }
		 * catch(Exception e){ System.out.println(e); }
		 */

	}

}
