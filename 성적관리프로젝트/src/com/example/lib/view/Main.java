package com.example.lib.view;
import java.util.Scanner;

import com.example.lib.controller.InsertController;
import com.example.lib.controller.SelectAllController;

public class Main {
	private Scanner scan;
	private InsertController ic;
	private SelectAllController sc;
	public final static String path = "C:/Temp/linuxdbinfo.properties";
	
	public Main() {
		this.scan = new Scanner(System.in);
		this.ic = new InsertController(this.scan);
		this.sc = new SelectAllController();
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Main main = new Main();
		System.out.println("WELCOME !!! �������� ���α׷�");
		int choice = main.showMenu();
		while (true) {
			switch (choice) {
			case 1: 
				main.ic.doInsert();
				break;
			case 2:
				main.sc.doSelectAll();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
			}
		}
	}

	private int showMenu() {
		System.out.println("####MENU####");
		System.out.println("1.�л� �Է�");
		System.out.println("2.�л� ������");
		System.out.println("3.�л� �˻�");
		System.out.println("4.�л� ������ ����");
		System.out.println("5.�л� ����");
		System.out.println("6.���α׷� ����");
		System.out.print("��ȣ�� �����ϼ��� >>>");
		return this.scan.nextInt();
	}
}
