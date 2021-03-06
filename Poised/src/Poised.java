import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Poised {
	public static void main(String[] args) {
		
		// Menu
		System.out.println("OPTIONS:");
		System.out.println("a - Add New Project");
		System.out.println("b - Add Contact Information");
		System.out.println("c - Get Project Information");
		System.out.println("d - Get Contact Information");
		System.out.println("e - See All Projects");
		System.out.println("f - Finalize Project");
		System.out.println("g - Edit Project Information");
		System.out.println("h - Edit Contact Information");

		//Get user preference
		Scanner object = new Scanner(System.in);
		System.out.print("\nEnter option: ");
		String userInput = object.nextLine();
		
//=========================================================================================================
		// If user wants to add a new project
		if (userInput.equals("a")) {
			System.out.println("\nYou have chosen to add a new project");
			
			System.out.print("Project Number: ");
			String projectNumber = object.nextLine();
			
			System.out.print("Project Name: ");
			String projectName = object.nextLine();
			
			System.out.print("Building Type: ");
			String buildingType = object.nextLine();
			
			System.out.print("Project Address: ");
			String projectAddress = object.nextLine();
			
			System.out.print("ERF Number: ");
			String erfNumber = object.nextLine();
			
			System.out.print("Project Deadline: ");
			String projectDeadline = object.nextLine();
			
			System.out.print("Project Finalized (Yes/No): ");
			String finalizedStatus = object.nextLine();
			
			System.out.print("Project Fee: ");
			float projectFee = object.nextFloat();
			
			System.out.print("Amount Paid: ");
			float amountPaid = object.nextFloat();
			
			// Create Project variable 
			Project xyz = new Project(
					projectNumber,
					projectName,
					buildingType,
					projectAddress,
					erfNumber,
					projectFee,
					amountPaid,
					projectDeadline,
					finalizedStatus);
			
			// Display the information to be saved
			System.out.println("\n" + xyz);
			
			// Create a file to save project information
			// If the file exists, add to it
			try {
				File myObj = new File("Projects.txt");
				if (myObj.createNewFile()) {
					try {
						FileWriter myWriter = new FileWriter("Projects.txt");
					    myWriter.write(xyz + "\n");
					    myWriter.close();
					    System.out.println("\nInformation Successfully captured.");
					  } catch (IOException e) {
						  System.out.println("An error occurred.");
					      e.printStackTrace();
					  }
				} else {
					// If the file already exists then append to it
					try {
						FileWriter myFile = new FileWriter("Projects.txt", true);
					    myFile.write("\n" + xyz + "\n");
					    myFile.close();
					    System.out.println("\nInformation Successfully saved.");
					  } catch (IOException e) {
						  System.out.println("An error occurred.");
					      e.printStackTrace();
					  }
				}
			} catch (IOException e) {
				System.out.println("An Error Occured");
			}
			
		}
		
//=========================================================================================================
		// If user wants to add contact information
		else if (userInput.equals("b")) {
			System.out.println("\nYou have chosen to add contact information");
			
			// Capture the title of the person (Customer, Architect or Contractor) and project
			// name
			System.out.print("Enter Contact Type: ");
			String contactType = object.nextLine();
			
			System.out.print("Enter Project Number: ");
			String projectNumber = object.nextLine();
			
			System.out.print("Enter Full Name: ");
			String name = object.nextLine();
			
			System.out.print("Enter Contact Number: ");
			String contactNumber = object.nextLine();
			
			System.out.print("Enter Contact Email: ");
			String contactEmail = object.nextLine();
			
			System.out.print("Enter Address: ");
			String address = object.nextLine();
			
			Person xyz = new Person(
					contactType,
					projectNumber,
					name,
					contactNumber,
					contactEmail,
					address);		
			
			System.out.println("\n" + xyz);
			
			// Create a file to save contacts information
			// If the file exists, add to it
			try {
				File myObj = new File("Contacts.txt");
				if (myObj.createNewFile()) {
					try {
						FileWriter myWriter = new FileWriter("Contacts.txt");
					    myWriter.write(xyz + "\n");
					    myWriter.close();
					    System.out.println("\nInformation Successfully captured.");
					  } catch (IOException e) {
						  System.out.println("An error occurred.");
					      e.printStackTrace();
					  }
				} else {
					// If the file already exists then append to it
					try {
						FileWriter myFile = new FileWriter("Contacts.txt", true);
					    myFile.write("\n" + xyz + "\n");
					    myFile.close();
					    System.out.println("\nInformation Successfully saved.");
					  } catch (IOException e) {
						  System.out.println("An error occurred.");
					      e.printStackTrace();
					  }
				}
			} catch (IOException e) {
				System.out.println("An Error Occured");
			}
		}

//=========================================================================================================
		// If user wants to get user information
		else if (userInput.equals("c")) {
			System.out.println("\nYou have chosen to get project information");
			System.out.println("This function is not yet available");
		}

//=========================================================================================================		
		// If user wants to get contact information
		else if (userInput.equals("d")) {
			System.out.println("\nYou have chosen to get contact information");
			System.out.println("This function is not yet available");
		}

//=========================================================================================================		
		// If user wants to see all projects
		else if (userInput.equals("e")) {
			System.out.println("\nYou have chosen to see all projects");
			System.out.println("This function is not yet available");
		}
		
//=========================================================================================================
		// If user wants to finalize project
		else if (userInput.equals("f")) {
			System.out.println("\nYou have chosen to finalize a project");
			System.out.print("Enter the project number: ");
			String projectNumber = object.nextLine();
			String fileContents = "";
			
			// Read from file
			try {
		        File myObj = new File("Projects.txt");
		        Scanner myReader = new Scanner(myObj);
		        int a = 0;
		        int b = 0;
		        
		        while (myReader.hasNextLine()) {
		        	String data = myReader.nextLine();
		        	
		        	// Edit the project corresponding to the project number entered by user
		        	// Check the first line and every 10th line for the project number
		        	if (data.length() > 13) {
			        	if (data.substring(14).equals(projectNumber) && (a == 0 || a%10 == 0)) {
			        		b = 1;
			        	}
			        	
			        	if (b == 1 && data.substring(12).equals("No")) {
			        		data = data.substring(0, 12) + "Yes";
			        		b = 0;
			        	}
		        	}		        	
		        	a += 1;
		        	fileContents += data + "\n";
		        	
		        }
		        
		        // Close Scanner
		        myReader.close();
			} catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			}
			
		// Overwrite Project file contents with the updated information including
		// the project that has been finalized.
		try {
			FileWriter myFile = new FileWriter("Projects.txt");
		    myFile.write(fileContents);
		    myFile.close();
		    System.out.println("\nDone!");
		  } catch (IOException e) {
			  System.out.println("An error occurred.");
		      e.printStackTrace();
		  }	
		
		}

//=========================================================================================================	
		// If user wants to edit project
		else if (userInput.equals("g")) {
			System.out.println("\nYou have chosen to edit a project");
			System.out.print("Enter the project number: ");
			String projectNumber = object.nextLine();
			
			// Display options for editing
			System.out.println("OPTIONS:");
			System.out.println("a - Due Date");
			System.out.println("b - Amount Paid\n");
			System.out.print("Enter selection: ");
			String option = object.nextLine();
			
			// EDIT DUE DATE
			if (option.equals("a")) {				
				String fileContents = "";
				
				// Read from file
				try {
			        File myObj = new File("Projects.txt");
			        Scanner myReader = new Scanner(myObj);
			        int a = 0;
			        int b = 0;
			        
			        while (myReader.hasNextLine()) {
			        	String data = myReader.nextLine();
			        	
			        	// Edit the project corresponding to the project number entered by user
			        	// Check the first line and every 10th line for the project number
			        	if (data.length() > 13) {
				        	if (data.substring(14).equals(projectNumber) && (a == 0 || a%10 == 0)) {
				        		b = 1;
				        	}
				        	
				        	if (b == 1 && data.substring(0, 13).equals("Proj Deadline")) {
				        		System.out.print("\nEnter new project deadline (day month year): ");
				        		String deadline = object.nextLine();
				        		data = data.substring(0, 16) + deadline;
				        		b = 0;
				        	}
			        	}		        	
			        	a += 1;
			        	fileContents += data + "\n";
			        	
			        }
			        
			        // Close Scanner
			        myReader.close();
				} catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				}
				
			// Overwrite Project file contents with the updated information including.
			try {
				FileWriter myFile = new FileWriter("Projects.txt");
			    myFile.write(fileContents);
			    myFile.close();
			  } catch (IOException e) {
				  System.out.println("An error occurred.");
			      e.printStackTrace();
			  }		
			}
			
			
			
			// EDIT AMOUNT PAID
			else if (option.equals("b")) {
				System.out.println("You have chosen to edit the amount paid");
				String fileContents = "";
				
				// Read from file
				try {
			        File myObj = new File("Projects.txt");
			        Scanner myReader = new Scanner(myObj);
			        int a = 0;
			        int b = 0;
			        
			        while (myReader.hasNextLine()) {
			        	String data = myReader.nextLine();
			        	
			        	// Edit the project corresponding to the project number entered by user
			        	// Check the first line and every 10th line for the project number
			        	if (data.length() > 13) {
				        	if (data.substring(14).equals(projectNumber) && (a == 0 || a%10 == 0)) {
				        		b = 1;
				        	}
				        	
				        	if (b == 1 && data.substring(0, 11).equals("Amount Paid")) {
				        		System.out.print("\nEnter new amount: ");
				        		String newAmount = object.nextLine();
				        		data = data.substring(0, 15) + newAmount;
				        		b = 0;
				        	}
			        	}		        	
			        	a += 1;
			        	fileContents += data + "\n";
			        }
			        
			        // Close Scanner
			        myReader.close();
				} catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				}
				
			// Overwrite Project file contents with the updated information including.
			try {
				FileWriter myFile = new FileWriter("Projects.txt");
			    myFile.write(fileContents);
			    myFile.close();
			  } catch (IOException e) {
				  System.out.println("An error occurred.");
			      e.printStackTrace();
			  }		
			}
		
			else {
				System.out.print("Invalid option");
			}
		}

//=========================================================================================================
		// If user wants to edit a contact
		else if (userInput.equals("h")) {
			System.out.println("\nYou have chosen to edit a contact");
			System.out.print("Enter their project number: ");
			String projectNumber = object.nextLine();
			
			// Display options for editing
			System.out.println("OPTIONS:");
			System.out.println("a - Contact Number");
			System.out.println("b - Email Address\n");
			System.out.print("Enter selection: ");
			String option = object.nextLine();
						
			String fileContents = "";
			
			if (option.equals("a")) {
				// Read from file
				try {
			        File myObj = new File("Contacts.txt");
			        Scanner myReader = new Scanner(myObj);
			        int a = 0;
			        int b = 0;
			        
			        while (myReader.hasNextLine()) {
			        	String data = myReader.nextLine();
			        	
			        	// Edit the contractor corresponding to the project number entered by user
			        	// Check the first line and every 7th line for the project number
			        	if (data.length() > 13) {
				        	if (data.substring(17).equals(projectNumber) && (a == 0 || a%7 == 0)) {
				        		b = 1;
				        	}
				        	
				        	if (b == 1 && data.substring(0, 14).equals("Contact Number")) {
				        		System.out.print("\nEnter new contact number: ");
				        		String newNumber = object.nextLine();
				        		data = data.substring(0, 17) + newNumber;
				        		b = 0;
				        	}
			        	}		        	
			        	a += 1;
			        	fileContents += data + "\n";
			        }
			        
			        // Close Scanner
			        myReader.close();
				} catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				}
				
				// Overwrite Contacts file contents with the updated information including.
				try {
					FileWriter myFile = new FileWriter("Contacts.txt");
				    myFile.write(fileContents);
				    myFile.close();
				  } catch (IOException e) {
					  System.out.println("An error occurred.");
				      e.printStackTrace();
				  }		
				}
				
			else if (option.equals("b")) {
				
				// Read from file
				try {
			        File myObj = new File("Contacts.txt");
			        Scanner myReader = new Scanner(myObj);
			        int a = 0;
			        int b = 0;
			        
			        while (myReader.hasNextLine()) {
			        	String data = myReader.nextLine();
			        	
			        	// Edit the contractor corresponding to the project number entered by user
			        	// Check the first line and every 7th line for the project number
			        	if (data.length() > 13) {
				        	if (data.substring(17).equals(projectNumber) && (a == 0 || a%7 == 0)) {
				        		b = 1;
				        	}
				        	
				        	if (b == 1 && data.substring(0, 13).equals("Contact Email")) {
				        		System.out.print("\nEnter new email: ");
				        		String newEmail = object.nextLine();
				        		data = data.substring(0, 16) + newEmail;
				        		b = 0;
				        	}
			        	}		        	
			        	a += 1;
			        	fileContents += data + "\n";
			        }
			        
			        // Close Scanner
			        myReader.close();
				} catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				}
				
				// Overwrite Contacts file contents with the updated information including.
				try {
					FileWriter myFile = new FileWriter("Contacts.txt");
				    myFile.write(fileContents);
				    myFile.close();
				  } catch (IOException e) {
					  System.out.println("An error occurred.");
				      e.printStackTrace();
				  }		
				}

				
			else {
				System.out.print("Invalid selection");
			}
		}
	
//=========================================================================================================
		// If the user input is not one of the defined options
		else {
			System.out.println("Invalid selection");
		}

//=========================================================================================================		
		object.close();
	}
}

/*
REFERENCES

I got help from w3schools under "Java Create and Write To Files" (https://www.w3schools.com/java/java_files_create.asp)
and "Java Read Files" (https://www.w3schools.com/java/java_files_read.asp) and DelftStack under 
"Append Text to a Text File in Java" (https://www.delftstack.com/howto/java/append-to-a-text-file-in-java/)
with regards to creating a text file and appending to it.

I learnt about substring() from GeeksforGeeks (https://www.geeksforgeeks.org/substring-in-java/)
*/
