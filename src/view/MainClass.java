package view;

import java.util.Scanner;

import controller.Login;
import controller.Register;

public class MainClass {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter '0' to Register and '1' to Login");
		int n = scan.nextInt();
		switch(n)
		{
		case 0: Register r = new Register();
			r.register();
			break;
		case 1: Login l = new Login();
			l.login();
			break;
		}
	}

}
