package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;




public class RWTicket {

	ArrayList<Ticket> p;
	
	File file;
	ObjectOutputStream oos;
	FileOutputStream  fos;
	ObjectInputStream ois;
	FileInputStream fis;
	public RWTicket (){
		p= new ArrayList<Ticket>();
		file=new File("ticket.ser");
	
	}
	public String read (){
		String s= "";
		for(Ticket x:p){
			s+= "ID:"+x.getId()+x.toString();
			
		}
		return s;
	}
	
	public void add (Ticket o )
	{
		p.add(o);
		writeF();
	}
	
	public void remove (int id){
		Boolean t= false;
		for(Ticket x:p){
			if (x.getId()==id){
				p.remove(x);
				t= true;
				break;
			}
		if (!t) System.err.println("Not found:");
			
		}
	}
	public void readF(){
		try{
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			p= (ArrayList<Ticket>)ois.readObject();
		}
			catch(FileNotFoundException e){
				System.out.println("does not exist");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void writeF(){
		
		try {
			fos = new FileOutputStream(file);
			oos= new ObjectOutputStream(fos);
			oos.writeObject(p);
			
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<Ticket> readAP(){
		return p;
	}
	
}


