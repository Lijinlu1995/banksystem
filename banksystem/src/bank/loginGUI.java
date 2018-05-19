package bank;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class loginGUI extends JFrame{
	 JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14;
	  JButton button1,button2,button3,button4,button5;
	  JFrame frame,frame1,frame2;
	  JTextField hehe1,hehe2;
	  int sb1,sb2,b;
	  file file;
	  JComboBox nameJComboBox;
	  String []aa;
	  String selection;
	  ImageIcon bg = new ImageIcon("background.jpg");
	  ImageIcon f = new ImageIcon("sss.jpg");
	  JLabel g=new JLabel(f);
	  JLabel label = new JLabel(bg);
	  account account;
	    public loginGUI(){
			  sb();			  
}
	    public void sb(){
	    label1=new JLabel("pin");
	    label2=new JLabel("账户");
	    hehe1=new JTextField(5);
	    hehe2=new JTextField(5);
	    button1=new JButton("确认");
	    button2=new JButton("返回");
	    setLayout(new FlowLayout());    	
		setSize(800,600);
		setLayout(null);  
		label1.setFont(new Font("楷体",Font.BOLD, 31));
		label2.setFont(new Font("楷体",Font.BOLD, 31));
		label1.setForeground(Color.blue);
		label2.setForeground(Color.blue);
		label1.setBounds(250,50,80,50);
		hehe1.setBounds(330,50,220,50);
		hehe2.setBounds(330,150,220,50);
		label2.setBounds(250,150,80,50);
		button1.setBounds(250,250,300,50);
		button2.setBounds(250,350,300,50);
		
		setVisible(true);setLocationRelativeTo(null);
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);
		getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		add(label1);
		add(hehe1);
		add(label2);
		add(hehe2);
		add(button1);
		button1.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
			 
		     file= new file();
		      if(file.denglu(hehe1.getText(),hehe2.getText())==true){

		    	  aa=file.ha();		    	
		    	  account=new account(aa[0],aa[1],aa[2],aa[3],aa[4],aa[5],aa[6],aa[7],aa[8],aa[9],aa[10],aa[11]);
		    	  dispose();
		    	  frame=new JFrame();		    	     	
		    	  frame.setSize(800,600);
		    	  frame.setVisible(true);frame.setLocationRelativeTo(null);
		    	  label1=new JLabel("登陆成功");
		    	  frame.setLayout(null);
		    	  button1=new JButton("存钱");
		    	  button2=new JButton("取钱");
		    	  button3=new JButton("查看个人信息");
		    	  button4=new JButton("返回");
		    	  button5=new JButton("退出");
		    	  label1.setFont(new Font("宋体",Font.BOLD, 31));
		  		label1.setForeground(Color.blue);
		  		label1.setBounds(325,50,150,50);
		  		button1.setBounds(250,125,300,50);
		  		button2.setBounds(250,200,300,50);
		  		button3.setBounds(250,275,300,50);
		  		button4.setBounds(250,350,300,50);
		  		button5.setBounds(250,425,300,50);
		    	  label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		  		JPanel imagePanel = (JPanel) frame.getContentPane();  
		          imagePanel.setOpaque(false);
		  		frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		    	  frame.add(label1);
		    	  frame.add(button1);
		    	  frame.add(button2);
		    	  frame.add(button3);
		    	  frame.add(button4);
		    	  frame.add(button5);
		    	  button1.addActionListener(new ActionListener(){
					  public void actionPerformed(ActionEvent e) {						  
				              frame=new JFrame();
				              frame.setLayout(new FlowLayout());    	
					    	  frame.setSize(300,220);
					    	  frame.setVisible(true);frame.setLocationRelativeTo(null);
					    	  label1=new JLabel("请输入金额");
					    	  hehe1=new JTextField(5);					    	 		    	  
					    	  nameJComboBox = new JComboBox();
					          nameJComboBox.addItem( "clear" );
					          nameJComboBox.addItem( "unclear");
					          				    	  
					    	  button1=new JButton("确认");
					    	  if(account.isSuspended==false&&account.customer.creditStatus==true&&account.isActive==true){
					    	  button1.addActionListener(new ActionListener(){
								  public void actionPerformed(ActionEvent e) {
									  selection= nameJComboBox.getSelectedItem().toString();
									  frame.dispose();
									  frame=new JFrame();
									  frame.setLayout(new FlowLayout());    	
							    	  frame.setSize(300,220);
							    	  frame.setVisible(true);frame.setLocationRelativeTo(null);
									  label1=new JLabel("存款成功!");
									  frame.add(label1);
									  account.deposit(Double.parseDouble(hehe1.getText()),selection);
									  file.xiugai(account);
								  }
									});
					    	  }
					    	  else{
					    		  button1.addActionListener(new ActionListener(){
									  public void actionPerformed(ActionEvent e) {
										  frame.dispose();
										  frame=new JFrame();
										  frame.setLayout(new FlowLayout());    	
								    	  frame.setSize(300,220);
								    	  frame.setVisible(true);frame.setLocationRelativeTo(null);
										  label1=new JLabel("交易失败，请先确保账户状态正常!");
										  frame.add(label1);
		
									  }
										});
					    	  }
					    	  frame.add(label1);
					    	  frame.add(hehe1);
					    	  frame.add(nameJComboBox);
					    	  frame.add(button1);	
					  }
						});
		    	  button2.addActionListener(new ActionListener(){
					  public void actionPerformed(ActionEvent e) {
						  frame= new JFrame();
						  frame.setLayout(new FlowLayout());    	
				    	  frame.setSize(300,220);
				    	  frame.setVisible(true);frame.setLocationRelativeTo(null);
				    	  JLabel label1=new JLabel("请输入取款金额");
				    	  hehe1=new JTextField(5);
						  frame.add(label1);
				    	  frame.add(hehe1);
				    	  button1=new JButton("确认");
				    	  frame.add(button1);
				    	 
				    	  if(account.isSuspended==false&&account.customer.creditStatus==true&&account.isActive==true){
				    	  button1.addActionListener(new ActionListener(){
							  public void actionPerformed(ActionEvent e) {
						b=account.withdraw(Double.parseDouble(hehe1.getText()),account.type);
			
								  if( b==0){
								  frame.dispose();
								  frame1=new JFrame();
						          frame1.setLayout(new FlowLayout());    	
						    	  frame1.setSize(300,220);
						    	  frame1.setVisible(true);frame1.setLocationRelativeTo(null);
						    	  JLabel label1=new JLabel("取款成功！");
						    	  frame1.add(label1);
						    	  file.xiugai(account);
								  }
								  else{
									  frame.dispose();
									  frame1=new JFrame();
							          frame1.setLayout(new FlowLayout());    	
							    	  frame1.setSize(300,220);
							    	  frame1.setVisible(true);frame1.setLocationRelativeTo(null);
							    	  JLabel label1=new JLabel("取款失败！");
							    	  frame1.add(label1);
								   
								  }
							  }
								});}
				    	  else{
				
				    		  button1.addActionListener(new ActionListener(){
								  public void actionPerformed(ActionEvent e) {
				                      frame.dispose();
									  frame1=new JFrame();
							          frame1.setLayout(new FlowLayout());    	
							    	  frame1.setSize(300,220);
							    	  frame1.setVisible(true);frame1.setLocationRelativeTo(null);
							    	  JLabel label1=new JLabel("取款失败！");
							    	  frame1.add(label1);
								  }
									});   
				    	  }
  				    	 
					  }
						});
		    	  button3.addActionListener(new ActionListener(){
					  public void actionPerformed(ActionEvent e) {
						  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						    String dateStr = sdf.format(account.customer.birth.getTime());
						     frame1= new JFrame();
						     frame1.setLayout(null);    	
				    	     frame1.setSize(400,300);
				    	     frame1.setVisible(true);frame1.setLocationRelativeTo(null);
						     label3=new JLabel("姓名");
			 			     label4=new JLabel("地址");
			 			     label5=new JLabel("生日");
			 			     label6=new JLabel("类型");
			 			     label7=new JLabel("PIN");
			 			     label1=new JLabel("账户");
			 			     label8=new JLabel("余额");
			 			     JLabel label15=new JLabel("支票");
			 			     JLabel label16=new JLabel(""+account.clearmoney);
			 			     
			 			      label9=new JLabel(""+account.customer.name);
			 			       label10=new JLabel(""+account.customer.address);
			 			      label11=new JLabel(""+dateStr);
			 			     label12=new JLabel(""+account.type);
			 			    label13=new JLabel(""+account.pin);
			 			    label14=new JLabel(""+account.accNo);
			 			   label2=new JLabel(""+account.money);
			 			
			 			     button1=new JButton("返回");
			 			     frame1.add(label1);
			 			    frame1.add(label14);
			 			   frame1.add(label7);
			 			  frame1.add(label13);
			 			     frame1.add(label3);
			 			     frame1.add(label9);
			 			     frame1.add(label4);
			 			     frame1.add(label10);
			 			     frame1.add(label5);
			 			     frame1.add(label11);
			 			    frame1.add(label6);
			 			   frame1.add(label12);
			 			  frame1.add(label8);
			 			 frame1.add(label2);
			 			frame1.add(label15);
			 			frame1.add(label16);
			 			label1.setBounds(50,25,100,25);
			 			label14.setBounds(150,25,100,25);
			 			label7.setBounds(50,55,100,25);
			 			label13.setBounds(150,55,100,25);
			 			label3.setBounds(50,85,100,25);
			 			label9.setBounds(150,85,100,25);
			 			label4.setBounds(50,115,100,25);
			 			label10.setBounds(150,115,100,25);
			 			label5.setBounds(50,145,100,25);
			 			label11.setBounds(150,145,100,25);
			 			label6.setBounds(50,175,100,25);
			 			label12.setBounds(150,175,100,25);
			 			label8.setBounds(50,205,100,25);
			 			label2.setBounds(150,205,100,25);
			 			label15.setBounds(50,235,100,25);
			 			label16.setBounds(150,235,100,25);
			 			label1.setFont(new Font("宋体",Font.BOLD, 15));
			 			label1.setForeground(Color.blue);
			 			label2.setFont(new Font("宋体",Font.BOLD, 15));
			 			label2.setForeground(Color.blue);
			 			label3.setFont(new Font("宋体",Font.BOLD, 15));
			 			label3.setForeground(Color.blue);
			 			label4.setFont(new Font("宋体",Font.BOLD, 15));
			 			label4.setForeground(Color.blue);
			 			label5.setFont(new Font("宋体",Font.BOLD, 15));
			 			label5.setForeground(Color.blue);
			 			label6.setFont(new Font("宋体",Font.BOLD, 15));
			 			label6.setForeground(Color.blue);
			 			label7.setFont(new Font("宋体",Font.BOLD, 15));
			 			label7.setForeground(Color.blue);
			 			label8.setFont(new Font("宋体",Font.BOLD, 15));
			 			label8.setForeground(Color.blue);
			 			label9.setFont(new Font("宋体",Font.BOLD, 15));
			 			label9.setForeground(Color.blue);
			 			label10.setFont(new Font("宋体",Font.BOLD, 15));
			 			label10.setForeground(Color.blue);
			 			label11.setFont(new Font("宋体",Font.BOLD, 15));
			 			label11.setForeground(Color.blue);
			 			label12.setFont(new Font("宋体",Font.BOLD, 15));
			 			label12.setForeground(Color.blue);
			 			label13.setFont(new Font("宋体",Font.BOLD, 15));
			 			label13.setForeground(Color.blue);
			 			label14.setFont(new Font("宋体",Font.BOLD, 15));
			 			label14.setForeground(Color.blue);
			 			label15.setFont(new Font("宋体",Font.BOLD, 15));
			 			label15.setForeground(Color.blue);
			 			label16.setFont(new Font("宋体",Font.BOLD, 15));
			 			label16.setForeground(Color.blue);
			 			
			 			
					  }
						});
		    	  button4.addActionListener(new ActionListener(){
					  public void actionPerformed(ActionEvent e) {
						 
			              frame.dispose();
			              new loginGUI();
					  }
						});
		    	  button5.addActionListener(new ActionListener(){
					  public void actionPerformed(ActionEvent e) {
						  System.exit(0);
					  }
						});
		      }
		      else{
		    	  frame1=new JFrame();
		          frame1.setLayout(new FlowLayout());    	
		    	  frame1.setSize(300,220);
		    	  frame1.setVisible(true);frame1.setLocationRelativeTo(null);
		    	  JLabel label1=new JLabel("亲，您记错啦！");
		    	  frame1.add(label1);
		      }
		           
			  }
				});
		add(button2);
		button2.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
		              new startGUI(); 
		              dispose();
			  }
				});
	    }
}