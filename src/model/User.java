package model;



import java.io.Serializable;

public class User implements Serializable {
	
	private String user;
	private String pass;
	
	
	
	
	public User() {
		
	}
	public User( String user, String pass) {
		super();

		
		this.user = user;
		this.pass = pass;
		
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String toString(){
		return "\nUser: "+this.getUser()+
				"\nPass: "+this.getPass();
	}
//	/**
//	* Always treat de-serialization as a full-blown constructor, by validating
//	* the final state of the de-serialized object.
//	*/
//	private void readObject(ObjectInputStream aInputStream)
//			throws ClassNotFoundException, IOException {
//			    // always perform the default de-serialization first
//	    aInputStream.defaultReadObject();
//	}
//			 
//	/**
//	* This is the default implementation of writeObject. Customise if
//	* necessary.
//	*/
//	private void writeObject(ObjectOutputStream aOutputStream)
//	throws IOException {
//	    // perform the default serialization for all non-transient, non-static
//	    // fields
//	    aOutputStream.defaultWriteObject();
//	}
}
