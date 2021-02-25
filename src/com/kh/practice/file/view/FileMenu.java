package com.kh.practice.file.view;

import java.io.File;
import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {

	
	public void mainMenu() {
		
		while(true) {
		    System.out.println("**** My Note ****");
		    System.out.println("1.노트 새로 만들기\n"
				         + "2.노트열기\n"
				         + "3.노트 열어서 수정하기\n"
				         +"9.끝내기\n");
		    System.out.print("메뉴 번호 : ");
		    
		    Scanner sc=new Scanner(System.in);
		    int cho=sc.nextInt();
		    String str="";
		    switch(cho) {
		    case 1 : fileSave(); break;
		    case 2 : fileOpen(); break;
		    case 3 : fileEdit(); break;
		    case 9 : System.out.println("프로그램을 종료합니다."); return;
		    default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		  
		    
		    }
		}
		
	}//메인메뉴출력

	public void fileSave() {
		Scanner sc=new Scanner(System.in);
		
		FileController fc=new FileController();
		String str="";
		StringBuilder sb=new StringBuilder();
		
		while(!str.equals("exit")) {
			
			System.out.print("파일에 저장할 내용을 입력하세요 (종료:exit) :");
			str=sc.nextLine();
			
			if(!str.equals("exit") ){
			sb.append(str+" ");	}			
		}
		
		
		  System.out.print("저장할 파일명 : ");
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
			System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n) :");
		    	 String cho=sc.next();
		    	 sc.nextLine();
		    	 if(cho.equals("y")) {
		    		 fc.fileSave(file, sb);
		    	 }else if(cho.equals("n")){
		    		 System.out.print("저장할 파일 명을 입력해주세요 :");
		    		 String file2=sc.nextLine();
		    		 fc.fileSave(file2, sb);
		    	 }
		    	 
		    	 
		     }else { 
		    	 fc.fileSave(file, sb);
		    	 //fc.fileSave(title,sb);
		    	 
		     }
		
		}
	//파일 명과 저장할 값을 받음
	
	
	public void fileOpen() {
		Scanner sc=new Scanner(System.in);
		FileController fc=new FileController();
		System.out.println("열 파일 명:");
		String title=sc.nextLine();
		Boolean check=fc.checkName(title);
		if(check==true) {
			StringBuilder sb=new StringBuilder();
			sb=fc.fileOpen(title);
			System.out.println(sb.toString());
		}else {
			System.out.println("없는 파일입니다.");
		}
		
		
	}//파일명을 받아 저장된 데이터 출력
	
	public void fileEdit() {
		Scanner sc=new Scanner(System.in);
		FileController fc=new FileController();
		String str="";
		StringBuilder sb=new StringBuilder();
		
		System.out.print("수정할 파일 명:");
		String title=sc.nextLine();
		Boolean check=fc.checkName(title);
		
		if(check==false) {
			System.out.println("없는 파일입니다.");
		}else if(check==true){
			while(!str.equals("exit")) {
				
				System.out.print("파일에 저장할 내용을 입력하세요 (종료:exit) :");
				str=sc.nextLine();
				
				if(!str.equals("exit") ){
				sb.append(str+" ");	
				
				}			
			}
		}
		fc.fileEdit(title, sb);
	}// 파일 명과 저장할 값을 받음
	
	
	
	
	
}
