package userGUI;

import jdbcDatabase.JdbcCon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserPage {
	
	private JFrame mainFrame;
	private JLabel col1_label, col2_label, message, first_name_label, last_name_label, street_label, 
			city_label, state_label, zip_label, phone_label, email_label, 
			birth_date_label, sex_label;
	private JTextField tffirst_name, tflast_name, tfstreet, tfcity, tfstate,
					tfzip, tfphone, tfemail, tfbirth_date, tfsex;
	private JButton btn;
	private JdbcCon connect;
	private String first_name = "", last_name = "" , street = "", city = "", state ="",
			zip = "", phone = "", email= "", birth_date = "", sex = "", result ="";
	
	public static void main(String[] args) {
		System.out.println("Beginning");
		UserPage user = new UserPage();
		user.setUpGUI();
		
		
	}	
	
	private void setUpGUI() {
		mainFrame = new JFrame("Client's Information Management");
		mainFrame.setSize(700, 500);
		mainFrame.setLayout(new GridLayout(12, 2));	
		col1_label = new JLabel("Enter Client's Information Below", JLabel.CENTER);	
		col2_label = new JLabel("Fill In Every Box", JLabel.CENTER);
		message = new JLabel();
		first_name_label = new JLabel("First Name : ", JLabel.LEFT);
		last_name_label = new JLabel("Last Name : ", JLabel.LEFT);
		street_label = new JLabel("Street : ", JLabel.LEFT);
		city_label = new JLabel("City : ", JLabel.LEFT);
		state_label = new JLabel("State : ", JLabel.LEFT);
		zip_label = new JLabel("Postal Code : ", JLabel.LEFT);
		phone_label = new JLabel("Phone Number : ", JLabel.LEFT);
		email_label = new JLabel("Email : ", JLabel.LEFT);
		birth_date_label = new JLabel("DOB", JLabel.LEFT);
		sex_label = new JLabel("Sex : ", JLabel.LEFT);
		
		connect = new JdbcCon();
		
		tffirst_name = new JTextField();
		tflast_name = new JTextField();
		tfstreet = new JTextField();
		tfcity = new JTextField();
		tfstate = new JTextField();
		tfzip = new JTextField();
		tfphone = new JTextField();
		tfemail = new JTextField();
		tfbirth_date = new JTextField();
		tfsex = new JTextField();
		
		btn = new JButton("Done");
		btn.setSize(200, 100);
		btn.addActionListener(new ButtonClickListener());
		
		mainFrame.add(col1_label);
		mainFrame.add(col2_label);
		mainFrame.add(first_name_label);
		mainFrame.add(tffirst_name);
		mainFrame.add(last_name_label);
		mainFrame.add(tflast_name);
		mainFrame.add(street_label);
		mainFrame.add(tfstreet);
		mainFrame.add(city_label);
		mainFrame.add(tfcity);
		mainFrame.add(state_label);
		mainFrame.add(tfstate);
		mainFrame.add(zip_label);
		mainFrame.add(tfzip);
		mainFrame.add(phone_label);
		mainFrame.add(tfphone);
		mainFrame.add(email_label);
		mainFrame.add(tfemail);
		mainFrame.add(birth_date_label);
		mainFrame.add(tfbirth_date);
		mainFrame.add(sex_label);
		mainFrame.add(tfsex);
		mainFrame.add(message);
		mainFrame.add(btn);
				
		mainFrame.setVisible(true);
	}
	
	private class ButtonClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==btn) {
				first_name = tffirst_name.getText();
				last_name = tflast_name.getText();
				street = tfstreet.getText();
				city = tfcity.getText();
				state = tfstate.getText();
				zip = tfzip.getText();
				phone = tfphone.getText();
				email = tfemail.getText();
				birth_date = tfbirth_date.getText();
				sex = tfsex.getText();
				result = connect.insertIntoTable(first_name, last_name, street, city, state, zip, phone, email, birth_date, sex);
				message.setText(result);
			}
		}
	}
		
}
