package com.kh.practice.file.controller;

import java.io.File;

import com.kh.practice.file.model.dao.FileDao;

public class FileController {

	public boolean checkName(String file) {
		boolean checkName;
		FileDao fd=new FileDao();
		
		checkName=fd.checkName(file);
		return checkName;		
		
		
	}//DAO�� �Ű������� �����ϰ�, DAO�� ���� ���޹��� ���� �ٽ� ��ȯ
	
	public void fileSave(String file, StringBuilder sb) {
		FileDao fd=new FileDao();
		
		String str=sb.toString();
		//System.out.println(str);
		fd.fileSave(file,str);
		
		
	}//���޹��� �Ű������� �����ϰ� DAO�� ����
	
	public StringBuilder fileOpen(String file) {
		StringBuilder sb=new StringBuilder();		
		FileDao fd=new FileDao();
		sb=fd.fileOpen(file);
		
		return sb;
	}//DAO�� �Ű������� �����ϰ�, DAO�κ��� ���޹��� ���� �ٽ� ��ȯ
	
	public void fileEdit(String file, StringBuilder sb) {
		String str=sb.toString();
		System.out.println(str);						
		FileDao fd=new FileDao();
		
		fd.fileEdit(file,str);
		
	}//���޹��� �Ű������� �����ϰ� DAO�� ����
	
	
	
	
	
}
