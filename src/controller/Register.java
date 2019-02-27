package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.User;

public class Register {
	
	public void register()
	{
		FileInputStream fileInputStream1;
		int j;int c1=0;
		
		try {
			fileInputStream1 = new FileInputStream("D:\\Programs\\bankUser2.txt");
			while((j=fileInputStream1.read()) != -1)
			{
				c1++;
			}
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			if(c1 == 0)
			{
				ArrayList<User> al = new ArrayList<>();
				
				al.add(setInfo());
				try {
					FileOutputStream fileOutputStream = new FileOutputStream("D:\\Programs\\bankUser2.txt");
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
					objectOutputStream.writeObject(al);
					System.out.println("Hello");
					Login l = new Login();
					l.login();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else
			{
				try {
					FileInputStream fileInputStream = new FileInputStream("D:\\Programs\\bankUser2.txt");
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
					int c=0;
					ArrayList<User> al =  (ArrayList<User>)objectInputStream.readObject();
					User u = setInfo();
					for(int i=0;i<al.size();i++) {
						User s = al.get(i);
						if(s.getAadharNo() == u.getAadharNo()) 
						{
							c++;
							break;
						}
						
						
					}
					if(c == 0)
					{
						System.out.println("Registration successful");
						al.add(u);
						try {
							FileOutputStream fileOutputStream = new FileOutputStream("D:\\Programs\\bankUser2.txt");
							ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
							objectOutputStream.writeObject(al);
							System.out.println("Your Account no is "+u.getAccountNo());
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						Login l = new Login();
						l.login();
					}
					else 
					{
						System.out.println("Customer already exists");
						Register r = new Register();
						r.register();
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
	public User setInfo()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Details " );
		User u = new User();
		long n = 10000 + new Random().nextInt(90000);
		u.setName(sc.next());
		u.setAadharNo(sc.nextLong());
		u.setAccountNo(n);
		u.setBalance(sc.nextDouble());
		u.setPassword(sc.next());
		
	
		return u;
	}
}
