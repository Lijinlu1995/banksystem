package bank;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Customer {
	protected String name;
	protected String address;
	protected Calendar birth;
	protected boolean creditStatus=true;
	String dateStr;

public Customer(String name,String address,Calendar birth){
	this.setName(name);
	this.address= address;
	this.setBirth(birth);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    dateStr = sdf.format(birth.getTime());
}

public String getname(){
	return this.getName();
}
public String getaddress(){
	return this.address;
}

public Calendar getbirth(){
    return this.getBirth();
}
public boolean getcreditStatus(){
	return this.isCreditStatus();
}
public String toString(){
	return this.getName()+" "+this.address+" "+dateStr+" "+isCreditStatus()+" ";
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public void setaddress(String address2) {
	// TODO 自动生成的方法存根
	this.address=address2;
}

public Calendar getBirth() {
	return birth;
}

public void setBirth(Calendar birth) {
	this.birth = birth;
}

public boolean isCreditStatus() {
	return creditStatus;
}

public void setCreditStatus(boolean creditStatus) {
	this.creditStatus = creditStatus;
}
}
