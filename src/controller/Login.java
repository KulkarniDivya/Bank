package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import model.User;
import controller.Options;

public class Login {
	
	static Scanner scan = new Scanner(System.in); 
		public void login() {
		// TODO Auto-generated method stub
			System.out.println("Enter Account no and Password");
		long Ano = scan.nextLong();
		String password = scan.next();
		
		try {
			FileInputStream fileInputStream = new FileInputStream("D:\\Programs\\bankUser2.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			ArrayList<User> al =  (ArrayList<User>)objectInputStream.readObject();
			int c=0;
			for(int i=0;i<al.size();i++) {
				User s = al.get(i);
				//System.out.println(s.getAccountNo()+" "+s.getPassword());
				if((s.getAccountNo() == Ano) && (s.getPassword().equals(password))) 
				{
					//System.out.println("Good");
					//al.remove(i);
					Options o = new Options();
					s.setBalance(o.option(s));
					c++;
					try {
						FileOutputStream fileOutputStream = new FileOutputStream("D:\\Programs\\bankUser2.txt");
						ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
						objectOutputStream.writeObject(al);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
				
				
			}
			if(c == 0)
			{
				System.out.println("Give proper inputs");
				Login l = new Login();
				l.login();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
