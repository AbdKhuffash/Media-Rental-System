package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	private int id;
	private String Name;
	private String address;
	private String mobile;
	//protected ArrayList<Media> Rented = new ArrayList<>();
	protected ArrayList<String> Rented = new ArrayList<>();

	//protected ArrayList<Media> Interested = new ArrayList<>();
	private String PLAN_TYPE = "LIMITED";
	protected ArrayList<String> requests = new ArrayList<>();
	
	public Customer(String name, String address, String plan,int id,String mobile) {
		this.Name = name;
		this.address = address;
		this.PLAN_TYPE = plan;
		this.id=id;
		this.mobile=mobile;
	}


	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPLAN_TYPE() {
		return PLAN_TYPE;
	}
	

	public void setPLAN_TYPE(String PLAN_TYPE) {
		this.PLAN_TYPE = PLAN_TYPE;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public boolean AddRequest(int mediacode,int custid) {
		String info=custid+">>"+mediacode;
		for(String find : requests) {
			if(find.equals(info)) {
				return false;
			}
		}
		return requests.add(info);
	}



	public boolean removeRequest(int custid,int mediacode) {
		String info=custid+">>"+mediacode;
		if(requests.remove(info)) {
			try {
				File intrested=new File("Files/InterestedData.txt");
				Scanner reader = new Scanner(intrested);
				File tempFile = new File("Files/temp.txt");
				FileWriter write1=new FileWriter(tempFile,true);
				PrintWriter writer = new PrintWriter(write1);
				while (reader.hasNextLine()) {
					String inputLine = reader.nextLine();
					if (!inputLine.equals(custid+">>"+mediacode))
						writer.append(inputLine+"\n");
				}
				reader.close();
				writer.close();
				intrested.delete();
				tempFile.renameTo(new File("Files/InterestedData.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	
}
//PHASE 1-not needed methods
/*
 * public boolean AddRequest(String mediaTitle) { for (String title: requests) {
 * if (title.equals(mediaTitle)) return false; } try { PrintWriter writer = new
 * PrintWriter(new File("Files/InterestedData.txt"));
 * writer.append(Name+">>"+mediaTitle+"\n"); } catch (FileNotFoundException e) {
 * e.printStackTrace(); } requests.add(mediaTitle); try { Scanner reader = new
 * Scanner(new File("Files/InterestedData.txt")); File tempFile = new
 * File("Files/temp.txt"); FileWriter write1=new FileWriter(tempFile,true);
 * PrintWriter writer = new PrintWriter(write1); while (reader.hasNextLine()) {
 * String inputLine = reader.nextLine(); if
 * (!inputLine.equals(this.Name+">>"+mediaTitle)) writer.append(inputLine+"\n");
 * } reader.close(); writer.close(); tempFile.renameTo(new
 * File("Files/InterestedData.txt")); } catch (FileNotFoundException e) {
 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); } return
 * true; }
 */
/*
 * public boolean removeRequest(String mediaTitle) {
 * if(requests.remove(mediaTitle)){ try { Scanner reader = new Scanner(new
 * File("Files/InterestedData.txt")); File tempFile = new File("Files/temp.txt");
 * FileWriter write1=new FileWriter(tempFile,true); PrintWriter writer = new
 * PrintWriter(write1); while (reader.hasNextLine()) { String inputLine =
 * reader.nextLine(); if (!inputLine.equals(this.Name+">>"+mediaTitle))
 * writer.append(inputLine+"\n"); } reader.close(); writer.close();
 * tempFile.renameTo(new File("Files/InterestedData.txt")); } catch
 * (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) {
 * e.printStackTrace(); } return true; }
 * 
 * return false; }
 */
