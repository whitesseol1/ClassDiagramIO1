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
		path=path.substring(0,path.lastIndexOf("bin")); //bin�ձ��� ã��
			
    	File f=new File(path+file+".txt");
		checkName=f.exists();
		
    	return checkName;
    	
    }//�����ϴ� ������ �ִ��� Ȯ�� �� ��ȯ
    
    public void fileSave(String file,String s) {
    	//System.out.println(FileDao.class.getResource("/").getPath());  //bin���Ͽ� ����..
		String path=FileDao.class.getResource("/").getPath();
		path=path.substring(0,path.lastIndexOf("bin")); //bin�ձ��� ã��
			
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
    	
    }//�Ű������� ���� ���� �� ���ڿ� ����
    
    public StringBuilder fileOpen(String file) {
    	StringBuilder sb=new StringBuilder();
    	
    	String path=FileDao.class.getResource("/").getPath();
		path=path.substring(0,path.lastIndexOf("bin")); //bin�ձ��� ã��			
    	
    	
    	try(BufferedReader reader=new BufferedReader(new FileReader(path+file+".txt")) ){
    		
			String temp=null;
			while((temp=reader.readLine())!=null) {
				sb.append(temp+"\n"); //�ٺ��� ���� , �ٴ�������
			}
			//System.out.println(sb);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
    	
    	return sb;
    }
	//�Ű������� ���� ���ϸ��� �̿��Ͽ� ���� �Ǿ� �ִ� ������ ��ȯ
	
    public void fileEdit(String file, String s) {
    	StringBuilder sb=new StringBuilder();
    	String path=FileDao.class.getResource("/").getPath();
		path=path.substring(0,path.lastIndexOf("bin"));
		
            try(BufferedReader reader=new BufferedReader(new FileReader(path+file+".txt")) ){
    		
			String temp=null;
			while((temp=reader.readLine())!=null) {
				sb.append(temp+"\s"); //�ٺ��� ���� , �ٴ�������
			}
			
		    }catch(IOException e) {
			e.printStackTrace();
		    } //������ ���ϳ��� ���� �� �̾��
		
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(path+file+".txt"))) {
			String content=sb.toString();
			bw.write(content);	
			bw.write(s);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
    	
    }//�Ű������� ���� ���� �� ���ڿ� ����
    
    //������
    //1.��Ŭ���� ��Ͽ� ������ ���� �Ⱥ���
    //2.f.exist() ���� ���� ������ �� ���ϻ� �ƴ϶� ���ϵ� ������
    //���� �����Դϴ� ����� FileNotFoundException ������
    //3. StringBuilder�� ����� ���ڿ��� �ٸ� Ŭ�������� toString()���� ��ȯ�� �����ϸ� ������ o ���� �� "\n" X
	
}
