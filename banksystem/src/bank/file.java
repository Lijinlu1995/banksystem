package bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class file {
    String fileName1="zhanghu.txt";
    String a;
    account account;
    String []ss;
     String []aa,bb;
    public String[] ha(){
    	return aa;
    }
    public String[] hei(){
    	return bb;
    }
	public void cunru(account account){
		 try
	        {
	        	    File file = new File(fileName1);
	        	    
	        	    FileOutputStream a = new FileOutputStream(file,true);
	        	    OutputStreamWriter osw = new OutputStreamWriter(a);
	                BufferedWriter out=new BufferedWriter(osw);
	                out.append(account.accNo+" "+account.pin+" "+account.customer.toString()+account.type+" "+account.money+" "+account.clearmoney+" "+account.isSuspended+" "+account.isActive+" "+account.noticeNeeded);  
	                out.newLine();  
	                out.close();
	        } catch (IOException e)
	        {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	        }   	
	    	
	    }
	public void xiugai(account account){
		 try
	        {
             String c;
			 File file = new File(fileName1);
			 Scanner s=new Scanner(new File(fileName1));
			 ArrayList<String> list=new ArrayList<String>();
			 while(s.hasNextLine()){
			 list.add(s.nextLine());
			 }
	        	    FileOutputStream b = new FileOutputStream(file,false);
	        	    OutputStreamWriter osw = new OutputStreamWriter(b);
	                BufferedWriter out=new BufferedWriter(osw);	   
	                for(int i=0;i<list.size();i++)
	                {
	                String[] ss=list.get(i).split(" ");//正则似乎是这个
	                //修改吧
			        	
			        	if(account.pin==Integer.parseInt(ss[1]) &&account.accNo==Integer.parseInt(ss[0]))
			        	{  list.remove(list.get(i));
			        	list.add(account.toString());}
			        }
	                for(int i=0;i<list.size();i++)
	                {
	                	out.append(list.get(i));  
		                out.newLine();  
	                }
  

	                out.close();
	                
	                
	        } catch (IOException e)
	        {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	        }   	
	    	
	    }
	public void shanchu(String pin){
		 try
	        {
            String c;
			 File file = new File(fileName1);
			 Scanner s=new Scanner(new File(fileName1));
			 ArrayList<String> list=new ArrayList<String>();
			 while(s.hasNextLine()){
			 list.add(s.nextLine());
			 }
	        	    FileOutputStream b = new FileOutputStream(file,false);
	        	    OutputStreamWriter osw = new OutputStreamWriter(b);
	                BufferedWriter out=new BufferedWriter(osw);	   
	                for(int i=0;i<list.size();i++)
	                {
	                String[] ss=list.get(i).split(" ");//正则似乎是这个
	                //修改吧
			        	System.out.println(ss[1]);
			        	if(pin.equals(ss[1]))
			        	{ System.out.print(123213);
			        		list.remove(list.get(i));
			        	}
			        }
	                for(int i=0;i<list.size();i++)
	                {
	                	out.append(list.get(i));  
		                out.newLine();  
	                }
 

	                out.close();
	                
	                
	        } catch (IOException e)
	        {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	        }   	
	    	
	    }
	
	public boolean denglu(String pin,String AccNo){
		
		
		int i = 0;
		try{
	    	   File file=new File(fileName1);
	    
	    	   BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
    	       
			        
			        for(int o=0;o<getLineNumber(file);o++)
			        {
			        	a=new String(bufferedReader.readLine());
			        
			        	ss=a.split(" ");
			
			        	if(pin.equals(ss[1]) &&AccNo.equals(ss[0]))
			        		              i =1; aa=ss;		        		          
			        		             
			        	}
			        bufferedReader.close();    
		      } catch(Exception e){
		    	    System.out.print(i);
			        System.out.println("error")	;
			        }
  
		if(i == 1) return true;
		else return false;
	    }
	public boolean soupin(String pin){
		
		
		int i = 0;
		try{
	    	   File file=new File(fileName1);
	    
	    	   BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
    	       
			        
			        for(int o=0;o<getLineNumber(file);o++)
			        {
			        	a=new String(bufferedReader.readLine());
			        
			        	ss=a.split(" ");
			
			        	if(pin.equals(ss[1]))
			        		              i =1; bb=ss;		        		          
			        		             
			        	}
			        bufferedReader.close();    
		      } catch(Exception e){
		    	    System.out.print(i);
			        System.out.println("error")	;
			        }
  
		if(i == 1) return true;
		else return false;
	
			        
				
	}
		
	public int getLineNumber(File file) {
        BufferedReader reader = null;
        int lines = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        return lines;
    }
	

}