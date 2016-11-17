package model;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class AccessUsers {
	//
	public static final String filename = "Users.ser";

	private ArrayList<User> users = new ArrayList<User>();
	InputStream file, buffer;
	OutputStream bf, fl;
	ObjectInput input;
	ObjectOutput output;
	File uf = new File(filename);

	public AccessUsers() {
		readF();
	}

	public User checkUser(String user, String pass) {
		for (User x : users)
			if (x.getUser().equals(user) && x.getPass().equals(pass)) {
				return x;
			}
		return null;
	}

	public String readS() {
		readF();
		String read = "";
		for (User x : users)
			read += "\n-------------User " + x.getUser()
			+ "--------------------\n" + x.toString()
			+ "\n>---------------------------<\n";
		return read;
	}
	public void addUser(User user) {
		users.add(user);
		writeF();
	}

	public ArrayList<User> getUsers()
	{
		this.readF();
		return this.users;
	}

	public int getPosition(User u)
	{
		//this.readF();
		System.out.println("--------------");
		System.out.println(u);
		System.out.println("--------------");
		for(int i=0; i<users.size(); i++)
		{
			if(users.get(i).toString().equals(u.toString()))
				return i;
		}
		
		return -1;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private void readF() {
		try {
			// use buffering
			file = new FileInputStream(uf);
			buffer = new BufferedInputStream(file);
			input = new ObjectInputStream(buffer);
			// deserialize the List
			users = (ArrayList<User>) input.readObject();
			// display its data
			for (User user : users) {
				System.out.println("Data: " + user.toString());
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
				ex.printStackTrace();;
		}
		closeFile();
	}

	private void writeF() {
		// TODO Auto-generated method stub
		// serialize the List
		try {
			fl = new FileOutputStream(uf);
			bf = new BufferedOutputStream(fl);
			output = new ObjectOutputStream(bf);
			output.writeObject(users);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		closeFile();
	}

	public void closeFile() {
		try {
			if (input != null) {
				input.close();
				buffer.close();
				file.close();
			}
			if (output != null) {
				output.close();
				bf.close();
				fl.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}