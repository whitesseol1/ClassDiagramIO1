package com.kh.practice.file.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class FileDao {

    public boolean checkName(String file) {
    	boolean checkName;
    	String path=FileDao.class.getResource("/").getPath();
		path=path.substring(0,path.lastIndexOf("bin")); //bin앞까지 찾음
			
    	File f=new File(path+file+".txt");
		checkName=f.exists();
		
    	return checkName;
    	
    }//존재하는 파일이 있는지 확인 후 반환
    
    public void fileSave(String file,String s) {
    	//System.out.println(FileDao.class.getResource("/").getPath());  //bin파일에 접근..
		String path=FileDao.class.getResource("/").getPath();
		path=path.substring(0,path.lastIndexOf("bin")); //bin앞까지 찾음
			
    	File f=new File(path+file+".txt");
    	
    	if(!f.exists()) {
    	   try {
    		f.createNewFile();
    	   }catch(IOException e) {
    		e.printStackTrace();
    	   }
    	}
    	try(BufferedWriter bw=new BufferedWriter(new FileWriter(file+".txt"))){
    		bw.write(s);
    		bw.flush();
    	}catch(IOException e) {
			e.printStackTrace();
		}
    	
    	//System.out.println(path);
    	//C:\Users\Master\eclipse-workspace\ClassDiagramIO1\pr3.txt
    	
    }//매개변수로 받은 파일 명에 문자열 저장
    
    public StringBuilder fileOpen(String file) {
    	StringBuilder sb=new StringBuilder();
    	
    	String path=FileDao.class.getResource("/").getPath();
		path=path.substring(0,path.lastIndexOf("bin")); //bin앞까지 찾음			
    	
    	
    	try(BufferedReader reader=new BufferedReader(new FileReader(path+file+".txt")) ){
    		
			String temp=null;
			while((temp=reader.readLine())!=null) {
				sb.append(temp+"\n"); //줄별로 읽음 , 줄단위개행
			}
			//System.out.println(sb);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
    	
    	return sb;
    }
	//매개변수로 받은 파일명을 이용하여 저장 되어 있는 데이터 반환
	
    public void fileEdit(String file, String s) {
    	StringBuilder sb=new StringBuilder();
    	String path=FileDao.class.getResource("/").getPath();
		path=path.substring(0,path.lastIndexOf("bin"));
		
            try(BufferedReader reader=new BufferedReader(new FileReader(path+file+".txt")) ){
    		
			String temp=null;
			while((temp=reader.readLine())!=null) {
				sb.append(temp+"\s"); //줄별로 읽음 , 줄단위개행
			}
			
		    }catch(IOException e) {
			e.printStackTrace();
		    } //기존의 파일내용 읽은 후 이어쓰기
		
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(path+file+".txt"))) {
			String content=sb.toString();
			bw.write(content);	
			bw.write(s);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
    	
    }//매개변수로 받은 파일 명에 문자열 저장
    
    //문제점
    //1.이클립스 목록에 생성된 파일 안보임
    //2.f.exist() 파일 존재 논리연산 값 리턴뿐 아니라 파일도 생성됨
    //없는 파일입니다 출력후 FileNotFoundException 에러뜸
    //3. StringBuilder에 저장된 문자열을 다른 클래스에서 toString()으로 변환해 저장하면 개행이 o 으로 됨 "\n" X
	
}
