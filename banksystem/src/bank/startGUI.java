package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class startGUI extends JFrame{
	  JLabel label1,label2,label3,label4,label5,label6,label7,label8;
	  JButton button1,button2,button3,button4;
	  JTextField textfield1,textfield2,textfield3,textfield4,textfield5,textfield6;
	  ImageIcon bg = new ImageIcon("background.jpg");
	  JLabel label = new JLabel(bg);
	  ImageIcon f = new ImageIcon("sss.jpg");
	  JLabel g=new JLabel(f);
  public startGUI(){
	  cao();
  }
  public void cao(){
		button1=new JButton("注册");
		button2=new JButton("登陆");
		button3=new JButton("管理");
		button4=new JButton("退出");
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);
		getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		setLayout(null);    
		JLabel label1=new JLabel("欢迎使用银行系统！");
		add(label1);
		label1.setFont(new Font("宋体",Font.BOLD, 31));
		label1.setForeground(Color.blue);
		label1.setBounds(250,50,300,50);
		button1.setBounds(250,125,300,50);
		button2.setBounds(250,225,300,50);
		button3.setBounds(250,325,300,50);
		button4.setBounds(250,425,300,50);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);setLocationRelativeTo(null);
button1.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e) {
	          new registerGUI();
	          dispose();
			  }
				});
button2.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e) {
              new loginGUI(); 
              dispose();
	  }
		});
button3.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e) {
              new admin();
              dispose();
	  }
		});
button4.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e) {
		     System.exit(0);
	  }
		});
		
  }

public static void main(String args[]){
	JFrame.setDefaultLookAndFeelDecorated(true); 
	startGUI a=new startGUI();

}
}