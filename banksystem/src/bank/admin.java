package bank;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class admin extends JFrame {
	JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12;
	  JButton button1,button2,button3,button4,button5;
	  JFrame frame,frame1,frame2;
	  JTextField hehe1,hehe2;
	  int sb1,sb2;
	  file file;
	  String[] aa;
	  account account;
	  ImageIcon bg = new ImageIcon("background.jpg");
	  JLabel label = new JLabel(bg);
	public admin(){
		caonima();
	}
	public void caonima(){
		setLayout(new FlowLayout());    	
		setSize(800,600);
		setVisible(true);
		setLocationRelativeTo(null);
		button1=new JButton("冻结");
		button2=new JButton("删除用户");
		button3=new JButton("到账");
		button4=new JButton("返回");
		button5=new JButton("退出");
		setLayout(null);  
		button1.setBounds(250,50,300,50);
		button2.setBounds(250,150,300,50);
		button3.setBounds(250,250,300,50);
		button4.setBounds(250,350,300,50);
		button5.setBounds(250,450,300,50);
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);
		getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		button1.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				     file =new file();
				     frame=new JFrame();				    
				     frame.setLayout(new FlowLayout());    	
					 frame.setSize(300,220);
					 frame.setVisible(true);frame.setLocationRelativeTo(null);
				     label1=new JLabel("请输入PIN:");
		             hehe1=new JTextField(5);
		             frame.add(label1);
		             frame.add(hehe1);
		             button1=new JButton("确认");
		             frame.add(button1);	
		             
		             button1.addActionListener(new ActionListener(){
		   			  public void actionPerformed(ActionEvent e) {
		   		
		   				   if(file.soupin(hehe1.getText())==true){
		   					 aa=file.hei();
		   					 account=new account(aa[0],aa[1],aa[2],aa[3],aa[4],aa[5],aa[6],aa[7],aa[8],aa[9],aa[10],aa[11]);
	
		   				     if(account.isSuspended==true){
		   				    	 frame.dispose();
		   				    	account.isSuspended=false;
		   				    	 file.xiugai(account);
		   				    	 frame=new JFrame();
		   				    	frame.setLayout(new FlowLayout());    	
		   					 frame.setSize(300,220);
		   					 frame.setVisible(true);frame.setLocationRelativeTo(null);
		   				     label1=new JLabel("解冻成功");
		   		             frame.add(label1);
		   				    	 
		   				    }
		   				     if(account.isSuspended==false){
		   				    	 System.out.println(1);	
		   				    	 frame.dispose();
		   				    	account.isSuspended=true;
		   				    	file.xiugai(account);
		   				     frame=new JFrame();
		   				    	frame.setLayout(new FlowLayout());    	
		   					 frame.setSize(300,220);
		   					 frame.setVisible(true);frame.setLocationRelativeTo(null);
		   				     label1=new JLabel("冻结成功");
		   		             frame.add(label1);
		   				    	 
		   				     }
		   				   }else{
		   					frame1=new JFrame();
					          frame1.setLayout(new FlowLayout());    	
					    	  frame1.setSize(300,220);
					    	  frame1.setVisible(true);frame1.setLocationRelativeTo(null);
					    	  JLabel label1=new JLabel("pin错了！");
					    	  frame1.add(label1);
		   				   }
		   			  }
		   				});
			  }
				});
		button2.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				     file =new file();
				     frame=new JFrame();				    
				     frame.setLayout(new FlowLayout());    	
				     frame.setSize(300,220);
				     frame.setVisible(true);frame.setLocationRelativeTo(null);
				     label1=new JLabel("请输入PIN:");
		             hehe1=new JTextField(5);
		             frame.add(label1);
		             frame.add(hehe1);
		             button1=new JButton("确认");
		             frame.add(button1);
		             button1.addActionListener(new ActionListener(){
		   			  public void actionPerformed(ActionEvent e) {
		   				if(file.soupin(hehe1.getText())==true){
		   				frame.dispose();		   				    	
   				    	file.shanchu(hehe1.getText());
   				     frame=new JFrame();
   				    	frame.setLayout(new FlowLayout());    	
   					 frame.setSize(300,220);
   					 frame.setVisible(true);
   				     label1=new JLabel("删除成功！");
   		             frame.add(label1);
		   			  }else{
		   				frame.dispose();		   				    	
   				    
   				     frame=new JFrame();
   				    	frame.setLayout(new FlowLayout());    	
   					 frame.setSize(300,220);
   					 frame.setVisible(true);frame.setLocationRelativeTo(null);
   				     label1=new JLabel("不存在该账户！");
   		             frame.add(label1);
		   			  }
		   				}
		   			
		   				});
			  }
				});
		button3.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  file =new file();
				     frame=new JFrame();				    
				     frame.setLayout(new FlowLayout());    	
				     frame.setSize(300,220);
				     frame.setVisible(true);frame.setLocationRelativeTo(null);
				     label1=new JLabel("请输入PIN:");
		             hehe1=new JTextField(5);
		             frame.add(label1);
		             frame.add(hehe1);
		             button1=new JButton("确认");
		             frame.add(button1);
		             button1.addActionListener(new ActionListener(){
		   			  public void actionPerformed(ActionEvent e) {
		   				 if(file.soupin(hehe1.getText())==true){
		   					 aa=file.hei();
		   					 account=new account(aa[0],aa[1],aa[2],aa[3],aa[4],aa[5],aa[6],aa[7],aa[8],aa[9],aa[10],aa[11]);
			   				 account.clear();	   				    		   						   				 		   				    	
			   				 frame.dispose();		   				    	
		   				    	file.xiugai(account);
		   				     frame=new JFrame();
		   				    	frame.setLayout(new FlowLayout());    	
		   					 frame.setSize(300,220);
		   					 frame.setVisible(true);frame.setLocationRelativeTo(null);
		   				     label1=new JLabel("兑现成功！");
		   		             frame.add(label1);
		   				     	 
		   				     
		   				   }else{
		   					frame1=new JFrame();
					          frame1.setLayout(new FlowLayout());    	
					    	  frame1.setSize(300,220);
					    	  frame1.setVisible(true);frame1.setLocationRelativeTo(null);
					    	  JLabel label1=new JLabel("pin错了！");
					    	  frame1.add(label1);
		   				   }
		   			  }
		   				});
			  }
				});
		button4.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
		          dispose();
				  new startGUI();
		          
			  }
				});
		button5.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  System.exit(0);  
			  }
				});
	}
}
