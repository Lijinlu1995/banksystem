package bank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class account{
	protected int accNo;
	protected int pin;
	protected Customer customer;
	protected String type;
	protected double money;
	protected double overDraftlimit=-99999;
	protected double withdrawlimit=99999;
	protected boolean isSuspended=false;
	protected boolean isActive=true;
	protected boolean noticeNeeded=false;
	protected double clearmoney;
public account(int accNo, String type,Customer customer){
	this.accNo= accNo;
	this.customer= customer;
	this.money=0.0;
	this.isActive=true;
	this.type=type;
	generatePin();
}
public account(String accNo,String pin,String name,String address,String birth,String iscredited,String type,String money,String clearmoney,String isSuspended,String isActive,String noticeNeeded) 
{
	this.accNo=Integer.parseInt(accNo);
	this.pin=Integer.parseInt(pin);
	this.type=type;
   

    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
    Date date;
	try {
		date = sdf.parse(birth);
	
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

	Customer customer=new Customer(name,address,calendar);
	this.customer=customer;
	this.money=Double.parseDouble(money);
	this.clearmoney=Double.parseDouble(clearmoney);
	this.isSuspended=Boolean.parseBoolean(isSuspended);
	this.isActive=Boolean.parseBoolean(isActive);
	this.noticeNeeded=Boolean.parseBoolean(noticeNeeded);
	} catch (ParseException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
}

private void generatePin(){
	Random r= new Random();
	pin= r.nextInt(900);
}

public int getAccNo(){
return accNo;
}
public Customer getCustomer(){
	return customer;
}
public double getBalance(){
	return money;
}
public int getPin(){
	return pin;
}
public boolean isSuspended(){
	return this.isSuspended;
}
public void deposit(double deposit, String clear){
	 if(clear=="clear") {
    money+=deposit;		 
	 }
	 if(clear=="unclear"){
    clearmoney+=deposit;
	 }
 }
public int withdraw(double withdraw,String type){
	  if(type=="junior"||type.equals("savor")){

		  if(money>=withdraw&&withdraw<=withdrawlimit){
			  money-=withdraw;
	
			  return 0;
		  }
		  else{
			   return 1; 
			 
	  	  }
	  }
	  if(type=="current"){
			  if((money-withdraw)>=overDraftlimit){
			  this.money=-withdraw;
			  
			  return 0;
			  }
			  else{
			  return 2;
			  }
		  
	
		  
	  }
	return 0;		  
}

public void clear(){
	  money+=clearmoney;
	  clearmoney=0;
}
public String toString(){
	return accNo+" "+pin+" "+customer.toString()+type+" "+money+" "+clearmoney+" "+isSuspended+" "+isActive+" "+noticeNeeded;
}
}




