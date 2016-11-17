package model;

public class Ticket {

	private  int id;
	private String name,surname,phone,email,creditcard,cardnumber,from,to,date1,date2,way,adult,child,infants,type;
	private static int x=0;
	
	
	public Ticket(){
		super();
		this.id=++x;
	}

	public Ticket(String name, String surname, String phone, String email,
			String creditcard, String cardnumber, String from, String to,
			String date1, String date2, String way,String adult,String child,String type) {
		super();
		this.id=++x;
		if(id>x) x=id++;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.creditcard = creditcard;
		this.cardnumber = cardnumber;
		this.from = from;
		this.to = to;
		this.date1 = date1;
		this.date2 = date2;
		this.way = way;
		this.adult=adult;
		this.child=child;
		this.infants=infants;
		this.type=type;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}
	

	public String getAdult() {
		return adult;
	}

	public void setAdult(String adult) {
		this.adult = adult;
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	public String getInfants() {
		return infants;
	}

	public void setInfants(String infants) {
		this.infants = infants;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", phone=" + phone + ", email=" + email + ", creditcard="
				+ creditcard + ", cardnumber=" + cardnumber + ", from=" + from
				+ ", to=" + to + ", date1=" + date1 + ", date2=" + date2
				+ ", way=" + way + ", adult=" + adult + ", child=" + child
				+ ", infants=" + infants + ", type=" + type + "]";
	}
}