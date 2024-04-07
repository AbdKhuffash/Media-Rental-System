package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MediaRentalManager implements MediaRentalInt {
	public ArrayList<Customer> customers = new ArrayList<>();
	public ArrayList<Media> Media = new ArrayList<>();
	private static int LIMITED_PLAN_LIMIT = 2;

	@Override
	public void addCustomer(String name, String address, String plan, int id, String mobile) {
		Customer newCustomer = new Customer(name, address, plan, id, mobile);
		customers.add(newCustomer);
		try {
			FileWriter write1 = new FileWriter(new File("Files/CustomersData.txt"), true);
			PrintWriter write = new PrintWriter(write1);
			String info = newCustomer.getId() + ">>" + newCustomer.getName() + ">>" + newCustomer.getAddress() + ">>"
					+ newCustomer.getMobile() + ">>" + newCustomer.getPLAN_TYPE();
			write.print(info + "\n");
			write.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}
	@Override
	public void setLimitedPlanLimit(int value) {

		LIMITED_PLAN_LIMIT = value;
	}

	@Override
	public void addMovie(String title, int NUMBER_OF_COPIES_AVAILABLE, String rating,int code) {
		Movie newMovie = new Movie(title, NUMBER_OF_COPIES_AVAILABLE, rating,code);
		Media.add(newMovie);
		try {
			FileWriter write1 = new FileWriter(new File("Files/MediaData.txt"), true);
			PrintWriter write = new PrintWriter(write1);
			String info=newMovie.code+">>"+newMovie.getType() + ">>" + newMovie.title + ">>" + newMovie.NUMBER_OF_COPIES_AVAILABLE + ">>"
					+ newMovie.getRating();
			write.print(info + "\n");
			write.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addGame(String title, int NUMBER_OF_COPIES_AVAILABLE, double weight,int code) {
		Game newGame = new Game(title, NUMBER_OF_COPIES_AVAILABLE, weight,code);
		Media.add(newGame);
		try {
		
			FileWriter write1 = new FileWriter(new File("Files/MediaData.txt"), true);
			PrintWriter write = new PrintWriter(write1);
			String info=newGame.code+">>"+newGame.getType() + ">>" + newGame.title + ">>" + newGame.NUMBER_OF_COPIES_AVAILABLE + ">>"
					+ newGame.getWeight() ;
			write.print(info + "\n");
			write.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addAlbum(String title, int NUMBER_OF_COPIES_AVAILABLE, String artist, String songs,int code) {
		Album newAlbum = new Album(title, NUMBER_OF_COPIES_AVAILABLE, artist, songs,code);
		Media.add(newAlbum);
		try {
			
			FileWriter write1 = new FileWriter(new File("Files/MediaData.txt"), true);
			PrintWriter write = new PrintWriter(write1);
			String info=newAlbum.code+">>"+newAlbum.getType() + ">>" + newAlbum.title + ">>" + newAlbum.NUMBER_OF_COPIES_AVAILABLE + ">>"
					+ newAlbum.getArtist() + ">>" + newAlbum.getSongs();
			write.print(info + "\n");
			write.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public String getAllInfoCustomer(int id) {
		String info="";
		Customer toBeFound=findcustomerid(id);
		info="Customer Name: " + toBeFound.getName() + " || Customer Address: " + toBeFound.getAddress() + " || Customer Mobile "
				+ toBeFound.getMobile() + " || Customer Plan type: " + toBeFound.getPLAN_TYPE();
		
		return info;
	}
	@Override
	public String getAllCustomersInfo() {
		Collections.sort(customers, new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		String Info = "";
		for (Customer C : customers) {
			Info +="Customer Id: " +C.getId()+" || Customer Name: " + C.getName() + " || Customer Address: " + C.getAddress() + " || Customer Mobile "
					+ C.getMobile() + " || Customer Plan type: " + C.getPLAN_TYPE() + "\n";
		}

		return Info;
	}

	public Customer findcustomerid(int id) {
		for (Customer c : customers) {
			if (c.getId() == id)
				return c;
		}
		return null;
	}
	public Media findmediaCode(int code) {
		for(Media m :Media) {
			if(m.getCode()==code)
				return m;
		}
		return null;
	}
	public  boolean removeFromMedia(int code) {
		Media toBeFound=null;
		for(Media m :Media) {
			if(m.getCode()==code) {
				toBeFound=m;
				break;
			}
		}
		if(toBeFound == null)
			return false;
		
		Media.remove(toBeFound);
		try {
			File media=new File("Files/MediaData.txt");
			Scanner reader = new Scanner(media);
			File tempFile = new File("Files/temp.txt");
			FileWriter write1 = new FileWriter(tempFile, true);
			PrintWriter writer = new PrintWriter(write1);
			//ArrayList<String[]> ListOfTokens = new ArrayList<String[]>();
			while (reader.hasNextLine()) {
				String inputLine = reader.nextLine();
				String[] select=inputLine.split(">>");
				if(toBeFound.getCode()!=Integer.parseInt(select[0])) {
					writer.append(inputLine + "\n");
				}
			}
			reader.close();
			writer.close();
			media.delete();
			tempFile.renameTo(new File("Files/MediaData.txt"));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean removeFromCustomer(int id) {

		Customer toBeFound = null;
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				toBeFound = customer;
				break;
			}
		}
		if (toBeFound == null)
			return false;

		customers.remove(toBeFound);
		try {
			File customer=new File("Files/CustomersData.txt");
			Scanner reader = new Scanner(customer);
			File tempFile = new File("Files/temp.txt");
			FileWriter write1 = new FileWriter(tempFile, true);
			PrintWriter writer = new PrintWriter(write1);
			while (reader.hasNextLine()) {
				String inputLine = reader.nextLine();
				String info = toBeFound.getId() + ">>" + toBeFound.getName() + ">>" + toBeFound.getAddress() + ">>"
						+ toBeFound.getMobile() + ">>" + toBeFound.getPLAN_TYPE();
				
				if (!inputLine.toLowerCase().trim().equals(info.trim().toLowerCase()))
					writer.append(inputLine + "\n");
			}
			reader.close();
			writer.close();
			customer.delete();
			tempFile.renameTo(new File("Files/CustomersData.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public String getMediaInfo(int code) {
		String info = "";
	    Media toBeFound=findmediaCode(code);
	    
	    info="Media Code:"+toBeFound.getCode()+"  || Media Type: " + toBeFound.getType() + " || Media Title: " + toBeFound.title + " || Number Of Copies Available: "
				+ toBeFound.NUMBER_OF_COPIES_AVAILABLE + "||" + toBeFound.toString() + "\n";
		return info;
	}
	@Override
	public String getAllMediaInfo() {
		String info = "";
		Collections.sort(Media);
		for (Media m : Media) {
			info += "Media Code:"+m.getCode()+"  || Media Type: " + m.getType() + " || Media Title: " + m.title + " || Number Of Copies Available: "
					+ m.NUMBER_OF_COPIES_AVAILABLE + m.toString() + "\n";
		}
		return info;
	}
	
	@Override
	public boolean addToCart(int id,int code) {
		Customer toBeFound=null;
		for(Customer customer : customers) {
			if(customer.getId()==id) {
			toBeFound=customer;
			break;
			}
		}
		if(toBeFound==null) return false;
		else {
			try {
				FileWriter write1 = new FileWriter(new File("Files/InterestedData.txt"), true);
				PrintWriter write = new PrintWriter(write1);
				String Info=id +">>"+code;
				write.print(Info + "\n");
				write.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return toBeFound.AddRequest(code,id);
		}
		
	}
	@Override
	public boolean removeFromCart(int id,int code) {
		Customer toBeFound=null;
		for(Customer customer:customers) {
			if(customer.getId()==id) {
				toBeFound=customer;
				break;
			}
		}
		if(toBeFound==null)return false;
		return toBeFound.removeRequest(id,code);
	}

	@Override
	public String ProcessRequests(){
		Collections.sort(customers, new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		String result="";
		for(Customer c:customers) {
			result += handleRequest(c);
		}
		return result;
	}
	
	public String handleRequest(Customer c) {
		String result= "";
		for(String token : c.requests) {
			String[] arr=token.split(">>");
			int id=Integer.parseInt(arr[0]);
			int code=Integer.parseInt(arr[1]);
			String info=id+">>"+code;
			Customer toBeFound=null;
			  for(Customer cust:customers) {
			    	if(id==cust.getId()) {
				    	toBeFound=cust;
				    }
			  }
			  if(toBeFound.getPLAN_TYPE().equals("LIMITED")) {
				  Media m=findmediaCode(code);
				  if(m.NUMBER_OF_COPIES_AVAILABLE>0 && m!=null && LIMITED_PLAN_LIMIT>0) {
					  toBeFound.Rented.add(info);
					  m.NUMBER_OF_COPIES_AVAILABLE--;
					  LIMITED_PLAN_LIMIT--;
					  result+="Sending: ["+m.title +"] to ["+ toBeFound.getName()+ "]\n";
					  try {
							FileWriter write1 = new FileWriter(new File("Files/RentingData.txt"), true);
							PrintWriter write = new PrintWriter(write1);
							write.print(id+">>"+code+"\n");
							write.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
				  }else {
					  toBeFound.removeRequest(id, code);
				  }
			  }else {
				  Media m=findmediaCode(code);
				  if(m!=null && m.NUMBER_OF_COPIES_AVAILABLE>0) {
					  toBeFound.Rented.add(info);
					  m.NUMBER_OF_COPIES_AVAILABLE--;
					  result+="Sending: ["+m.title +"] to ["+ toBeFound.getName()+ "]\n";
					  try {
							FileWriter write1 = new FileWriter(new File("Files/RentingData.txt"), true);
							PrintWriter write = new PrintWriter(write1);
							write.print(id+">>"+code+"\n");
							write.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
				  }else {
					  toBeFound.removeRequest(id, code);
				  }
			  }
			
		}
		return result;
	}

	
    public String PrintRequestedMedia(int custid) {
    	String result="";
    	Customer toBeFound=null;
    	for(Customer cust:customers) {
    		if(custid==cust.getId()) {
    			toBeFound=cust;
    		}
    	}
 
    	for(String token :toBeFound.requests) {
    		String[] arr=token.split(">>");
			int id=Integer.parseInt(arr[0]);
			int code=Integer.parseInt(arr[1]);
			if(id==custid) {
				result+=getMediaInfo(code);
			}
    	}
    	return result;
    }
    public String PrintRentedMedia(int custid) {
    	String result="";
    	Customer toBeFound=null;
    	for(Customer cust:customers) {
    		if(custid==cust.getId()) {
    			toBeFound=cust;
    		}
    	}
    	
    	for(String token :toBeFound.Rented) {
    		String[] arr=token.split(">>");
    		int id=Integer.parseInt(arr[0]);
			int code=Integer.parseInt(arr[1]);
			if(id==custid) {
				result+=getMediaInfo(code);
			}
    	}
    	return result;
    }
    @Override
	public boolean returnMedia(int custid,int medcode) {
		Customer c=findcustomerid(custid);
	    Media m=findmediaCode(medcode);
	    
	    if(c==null ||m==null) {
	    	return false;
	    }
	    for(String token :c.Rented) {
	    	String[] arr=token.split(">>");
	    	int id=Integer.parseInt(arr[0]);
			int code=Integer.parseInt(arr[1]);
			if(id==custid) {
				if(code==medcode) {
					c.Rented.remove(token);
					m.NUMBER_OF_COPIES_AVAILABLE++;
					if(c.getPLAN_TYPE().equals("LIMITED")) LIMITED_PLAN_LIMIT++;
					try {
						File rented=new File("Files/RentingData.txt");
						Scanner reader = new Scanner(rented);
						File tempFile = new File("Files/temp.txt");
						FileWriter write1 = new FileWriter(tempFile, true);
						PrintWriter writer = new PrintWriter(write1);
						while (reader.hasNextLine()) {
							String inputLine = reader.nextLine();
							if (!inputLine.equals(id + ">>" + code))
								writer.print(inputLine + "\n");

						}
						reader.close();
						writer.close();
						rented.delete();
						tempFile.renameTo(new File("Files/RentingData.txt"));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					return true;
				}
			}
	    }
		return false;

	}

    public boolean clearReq(int id) {
    	Customer c=findcustomerid(id);
    	try {
    		for(String check :c.Rented) {
        		for(String toBeDeleted :c.requests) {
        			if(check.equals(toBeDeleted)) {
        				c.requests.remove(toBeDeleted);
        				try {
        					File intrested=new File("Files/InterestedData.txt");
        					Scanner reader = new Scanner(intrested);
        					File tempFile = new File("Files/temp.txt");
        					FileWriter write1=new FileWriter(tempFile,true);
        					PrintWriter writer = new PrintWriter(write1);
        					while (reader.hasNextLine()) {
        						String inputLine = reader.nextLine();
        						if (!inputLine.equals(toBeDeleted))
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
        				
        				
        			}
        		}
        	}
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	return false;
    }
    
    
    
    ///PHASE 1-not needed methods.
    /*
	public boolean returnMedia(String CustomerName, String mediaTitle) {
		Customer c = findCustomer(CustomerName);
		Media m = findMedia(mediaTitle);
		if (c == null || m == null)
			return false;

		for (Media media : c.Rented) {
			if (m.equals(media)) {
				c.Rented.remove(m);
				m.NUMBER_OF_COPIES_AVAILABLE++;

				try {
					Scanner reader = new Scanner(new File("Files/RentingData.txt"));
					File tempFile = new File("Files/temp.txt");
					FileWriter write1 = new FileWriter(tempFile, true);
					PrintWriter writer = new PrintWriter(write1);
					while (reader.hasNextLine()) {
						String inputLine = reader.nextLine();
						if (!inputLine.equals(CustomerName + ">>" + mediaTitle))
							writer.print(inputLine + "\n");

					}
					reader.close();
					writer.close();
					tempFile.renameTo(new File("Files/RentingData.txt"));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return true;
			}
		}
		return false;
	}
*/
	/*
	 * ArrayList<String> searchMedia(String title, String rating, String artist,
	 * String songs) {
	 * 
	 * ArrayList<String> result = new ArrayList<>(); if (rating != null && (songs !=
	 * null || artist != null)) // There can't be a media with a rating and songs or
	 * // artists. return result; if (rating != null) { for (Media m : Media) { if
	 * (m instanceof Movie) { if (((Movie) m).getRating().equals(rating) &&
	 * m.title.equals(title)) { result.add(m.title); } } } } else if (songs != null
	 * || artist != null) { for (Media m : Media) { if (m instanceof Album) { if
	 * ((artist == null || ((Album) m).getArtist().equals(artist))) { if (songs ==
	 * null || ((Album) m).getSongs().equals(songs)) { result.add(m.title); } } } }
	 * } else if (songs == null && rating == null && artist == null) { for (Media m
	 * : Media) { if (m.title.equals(title)) { result.add(m.title); } } } else if
	 * (songs == null && rating == null && artist == null && title == null) { for
	 * (Media m : Media) { result.add(m.title); } } return result; }
	 */
	/*
	 * @Override public boolean addToCart(String CustomerName, String mediaTitle) {
	 * Customer toBeFound = null; for (Customer customer : customers) { if
	 * (customer.getName().equals(CustomerName)) { toBeFound = customer; break; } }
	 * if (toBeFound == null) return false;
	 * 
	 * else { try { FileWriter write1 = new FileWriter(new
	 * File("Files/InterestedData.txt"), true); PrintWriter write = new
	 * PrintWriter(write1); write.print(CustomerName + ">>" + mediaTitle + "\n"); }
	 * catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); } return toBeFound.AddRequest(mediaTitle);
	 * 
	 * } }
	 */
	/*
	 * @Override public boolean removeFromCart(String CustomerName, String
	 * mediaTitle) { Customer toBeFound = null; for (Customer customer : customers)
	 * { if (customer.getName().equals(CustomerName)) { toBeFound = customer; break;
	 * } } if (toBeFound == null) return false;
	 * 
	 * return toBeFound.removeRequest(mediaTitle); }
	 * 
	 */
	/*
	 * public String handleRequest(Customer c) { String result = "";
	 * ArrayList<String> toBeRemoved = new ArrayList<>(); for (String request :
	 * c.requests) { if (c.getPLAN_TYPE().equals("LIMITED")) { Media m =
	 * findMedia(request); if (c.Rented.size() < LIMITED_PLAN_LIMIT && m != null &&
	 * m.NUMBER_OF_COPIES_AVAILABLE > 0) { c.Rented.add(m);
	 * m.NUMBER_OF_COPIES_AVAILABLE--; result += "Sending: [" + m.title + "] to [" +
	 * c.getName() + "]+\n"; } } else { Media m = findMedia(request); if (m != null
	 * && m.NUMBER_OF_COPIES_AVAILABLE > 0) { c.Rented.add(m);
	 * m.NUMBER_OF_COPIES_AVAILABLE--; toBeRemoved.add(c.getName()); result +=
	 * "Sending: [" + m.title + "] to [" + c.getName() + "]+\n"; } } } for (String
	 * request : toBeRemoved) { c.removeRequest(request); } return result;
	 * 
	 * }
	 */
	/*
	 * @Override public String ProcessRequests() { Collections.sort(customers, new
	 * Comparator<Customer>() {
	 * 
	 * @Override public int compare(Customer o1, Customer o2) { return
	 * o1.getName().compareTo(o2.getName()); } }); String result = ""; for (Customer
	 * c : customers) { result += handleRequest(c); } return result; }
	 */

	/*
	 * public Media findMedia(String request) { for (Media m : Media) { if
	 * (m.equals(request)) return m; } return null; }
	 * 
	 * public Customer findCustomer(String name) { for (Customer c : customers) { if
	 * (c.equals(name)) return c; } return null; }
	 */

}
