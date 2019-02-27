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

public class Options {
	static Scanner scan = new Scanner(System.in); 
	public double option(User s)
	{
		ArrayList<User> al = new ArrayList<>();
		int n=0;
		while(n!=3)
		{
			System.out.println("Enter '0' to Withdraw , '1' to Deposit and '2' to check balance. Press '3' to exit");
			n = scan.nextInt();
			switch(n)
			{
			case 0:System.out.println("Enter the amount u want to withdraw");
					int w = scan.nextInt();
					s.setBalance(withdraw(w,s.getBalance()));
					System.out.println("Ur Balance:"+s.getBalance());
					break;
			case 1:System.out.println("Enter the amount u want to deposit");
					int d = scan.nextInt();
					s.setBalance(deposit(d,s.getBalance()));
					System.out.println("Ur Balance:"+s.getBalance());
					break;
			case 2: System.out.println(s.getBalance());
					break;
			case 3: System.out.println("Thank You");
			}
		}
		return s.getBalance();
	}
	
	private double deposit(int d, double balance) {
		// TODO Auto-generated method stub
		balance = balance + d;
        System.out.println("Your Money has been successfully deposited");
        return balance;
	}
	private double withdraw(int w, double balance) {
		// TODO Auto-generated method stub
		 if(balance >= w)
         {
             balance = balance - w;
             System.out.println("Please collect your money");
         }
         else
         {
             System.out.println("Insufficient Balance");
         }
		 return balance;
	}
	
}
