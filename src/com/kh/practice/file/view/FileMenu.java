package com.kh.practice.file.view;

import java.io.File;
import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {

	
	public void mainMenu() {
		
		while(true) {
		    System.out.println("**** My Note ****");
		    System.out.println("1.��Ʈ ���� �����\n"
				         + "2.��Ʈ����\n"
				         + "3.��Ʈ ��� �����ϱ�\n"
				         +"9.������\n");
		    System.out.print("�޴� ��ȣ : ");
		    
		    Scanner sc=new Scanner(System.in);
		    int cho=sc.nextInt();
		    String str="";
		    switch(cho) {
		    case 1 : fileSave(); break;
		    case 2 : fileOpen(); break;
		    case 3 : fileEdit(); break;
		    case 9 : System.out.println("���α׷��� �����մϴ�."); return;
		    default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
		  
		    
		    }
		}
		
	}//���θ޴����

	public void fileSave() {
		Scanner sc=new Scanner(System.in);
		
		FileController fc=new FileController();
		String str="";
		StringBuilder sb=new StringBuilder();
		
		while(!str.equals("exit")) {
			
			System.out.print("���Ͽ� ������ ������ �Է��ϼ��� (����:exit) :");
			str=sc.nextLine();
			
			if(!str.equals("exit") ){
			sb.append(str+" ");	}			
		}
		
		
		  System.out.print("������ ���ϸ� : ");
		  String file=sc.next();
		  String path=FileMenu.class.getResource("/").getPath();
		path=path.substring(0,path.lastIndexOf("bin"));
		
		 File f=new File(path+file+".txt");
		 //System.out.println(path+file+".txt");
		 
		 //"C:\\Users\\Master\\eclipse-workspace\\ClassDiagramIO1\\"+file+".txt"
				 //(FileMenu.class.getResource("/").getPath());
//		File[] file=f.listFiles();
//		for(File f2 : file) {
		  
		     if (f.exists()) {
			System.out.print("�̹� �����ϴ� �����Դϴ�. ����ðڽ��ϱ�?(y/n) :");
		    	 String cho=sc.next();
		    	 sc.nextLine();
		    	 if(cho.equals("y")) {
		    		 fc.fileSave(file, sb);
		    	 }else if(cho.equals("n")){
		    		 System.out.print("������ ���� ���� �Է����ּ��� :");
		    		 String file2=sc.nextLine();
		    		 fc.fileSave(file2, sb);
		    	 }
		    	 
		    	 
		     }else { 
		    	 fc.fileSave(file, sb);
		    	 //fc.fileSave(title,sb);
		    	 
		     }
		
		}
	//���� ��� ������ ���� ����
	
	
	public void fileOpen() {
		Scanner sc=new Scanner(System.in);
		FileController fc=new FileController();
		System.out.println("�� ���� ��:");
		String title=sc.nextLine();
		Boolean check=fc.checkName(title);
		if(check==true) {
			StringBuilder sb=new StringBuilder();
			sb=fc.fileOpen(title);
			System.out.println(sb.toString());
		}else {
			System.out.println("���� �����Դϴ�.");
		}
		
		
	}//���ϸ��� �޾� ����� ������ ���
	
	public void fileEdit() {
		Scanner sc=new Scanner(System.in);
		FileController fc=new FileController();
		String str="";
		StringBuilder sb=new StringBuilder();
		
		System.out.print("������ ���� ��:");
		String title=sc.nextLine();
		Boolean check=fc.checkName(title);
		
		if(check==false) {
			System.out.println("���� �����Դϴ�.");
		}else if(check==true){
			while(!str.equals("exit")) {
				
				System.out.print("���Ͽ� ������ ������ �Է��ϼ��� (����:exit) :");
				str=sc.nextLine();
				
				if(!str.equals("exit") ){
				sb.append(str+" ");	
				
				}			
			}
		}
		fc.fileEdit(title, sb);
	}// ���� ��� ������ ���� ����
	
	
	
	
	
}
