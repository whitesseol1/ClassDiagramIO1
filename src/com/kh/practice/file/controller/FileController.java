package com.kh.practice.file.controller;

import java.io.File;

import com.kh.practice.file.model.dao.FileDao;

public class FileController {

	public boolean checkName(String file) {
		boolean checkName;
		FileDao fd=new FileDao();
		
		checkName=fd.checkName(file);
		return checkName;		
		
		
	}//DAO에 매개변수를 전달하고, DAO로 부터 전달받은 값을 다시 반환
	
	public void fileSave(String file, StringBuilder sb) {
		FileDao fd=new FileDao();
		
		String str=sb.toString();
		//System.out.println(str);
		fd.fileSave(file,str);
		
		
	}//전달받은 매개변수를 변경하고 DAO에 전달
	
	public StringBuilder fileOpen(String file) {
		StringBuilder sb=new StringBuilder();		
		FileDao fd=new FileDao();
		sb=fd.fileOpen(file);
		
		return sb;
	}//DAO에 매개변수를 전달하고, DAO로부터 전달받은 값을 다시 반환
	
	public void fileEdit(String file, StringBuilder sb) {
		String str=sb.toString();
		System.out.println(str);						
		FileDao fd=new FileDao();
		
		fd.fileEdit(file,str);
		
	}//전달받은 매개변수를 변경하고 DAO에 전달
	
	
	
	
	
}
