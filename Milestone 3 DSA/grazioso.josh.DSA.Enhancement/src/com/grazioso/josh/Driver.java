package com.grazioso.josh;
// allows use of arrays
//import java.util.ArrayList;

import java.util.HashMap;

// allows user input and output
import java.util.Scanner;
// driver class runs the program
public class Driver {
	
	// array holding list of dogs
	
    //private static ArrayList<Dog> dogList = new ArrayList<Dog>();
	
	// changed to HashMap
	private static HashMap<Integer, Dog> dogMap = new HashMap<>();

    //array holding list of monkeys
    //private static ArrayList<MonkeyClass> monkeyList = new ArrayList<MonkeyClass>();
	
	private static HashMap<Integer, MonkeyClass> monkeyMap = new HashMap<>(); // changed to HashMap
    
    // runs the program
    public static void main(String[] args) {
    	
    	// allows user to input
        Scanner scanner = new Scanner(System.in);
        
        // holds the value that user inputted
        String choice;
        
        try {

        // Initializes the dog list
        initializeDogList();
        
        // Initializes the monkey list
        initializeMonkeyList();
        // loop start that displays menu until user exits
        while (true) {
            displayMenu(); // function that displays menu
            choice = scanner.nextLine(); // holds users input

            // allows user to keep choosing until they exit
            switch (choice) {
                case "1":
                    intakeNewDog(scanner); // Prompts user to intake new dog information
                    break; // breaks to next choice
                case "2":
                    intakeNewMonkey(scanner); // function to prompt to intake a new monkey
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break; // breaks to next choice
                case "4":
                    System.out.println(dogMap);
                    break; // breaks to next choice
                case "5":
                	System.out.println(monkeyMap);
                    break; // breaks to next choice
                case "6":
                    System.out.println("available");
                    printNonReservedAnimals();
                    break; // breaks to next choice
                case "q":
                    System.out.println("Quitting application");
                    scanner.close(); //closes scanner that accepts input
                    break; // exits loop and switch statement
                default:
                    System.out.println("Invalid choice"); // if users choice is invalid, output invalid choice
                    break; // break back to beginning
            } // end of switch

        } // end of while loop.
        
        } catch(Exception e) {
        	System.out.println("Error, try again."); // catches various errors.
        }
        
        finally {
        	scanner.close(); // closes the scanner
        }
    } // end of driver

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        dogMap.put(1, new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States"));
        dogMap.put(2, new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States"));
        dogMap.put(3, new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada"));
    } // end of initializeDogList


    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
    	monkeyMap.put(1, new MonkeyClass("Boone", "male", "2", "15.3", "03-14-2020", "Brazil", "intake", false, "Brazil", "15cm", "30cm", "40cm", "Capuchin"));
    }


    // Method to intake a new dog
    public static void intakeNewDog(Scanner scanner) {
    	try {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine(); // saves name to users input
        for(Dog dog: dogMap.values()) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            } // end of if
        } // end of loop
      
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();
        System.out.println("What is the dog's acquisition date?");
        String acquisitionDate = scanner.nextLine();
        System.out.println("What is the dogs acquisition country?");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();
        boolean reserved = animalReservedStatus(scanner);
        System.out.println("What is the dog's in service country?");
        String inServiceCountry = scanner.nextLine();
        
        // create new dog object
        int dogId = dogMap.size() + 1; // make next id for hashmap
        Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        dogMap.put(dogId, dog); // dog added to hashmap
        System.out.println("Your dog has been added.");
        // catches for various errors.
    	} catch (Exception e ) {
    		System.out.println("Error, Please try again.");
    	} // end of catch
    } // end of intake new dog


    	// Function to intake a new monkey
        public static void intakeNewMonkey(Scanner scanner) {
            try {
        	System.out.println("What is the monkey's name?");
            String name = scanner.nextLine(); // save monkeys name to users input
            // loop to check if monkey is already on list
            for(MonkeyClass monkey : monkeyMap.values()) {
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                } // end of if
        }
            System.out.println("What is the monkey's gender?");
            String gender = scanner.nextLine();
            System.out.println("What is the monkey's age?");
            String age = scanner.nextLine();
            System.out.println("What is the monkey's weight?");
            String weight = scanner.nextLine();
            System.out.println("What is the monkey's acquisition date?");
            String acquisitionDate = scanner.nextLine();
            System.out.println("What is the monkeys acquisition country?");
            String acquisitionCountry = scanner.nextLine();
            System.out.println("What is the monkeys training status?");
            String trainingStatus = scanner.nextLine();
            boolean reserved = animalReservedStatus(scanner);
            System.out.println("Is the monkey in service country?");
            String inServiceCountry = scanner.nextLine();
            System.out.println("What is the monkey's tailLength");
            String tailLength = scanner.nextLine();
            System.out.println("What is the monkey's height?");
            String height = scanner.nextLine();
            System.out.println("What is the monkey's body length?");
            String bodyLength = scanner.nextLine();
            System.out.println("What type of species is the monkey?");
            String species = scanner.nextLine();
            int monkeyId = monkeyMap.size() + 1; // add id for new monkey
            MonkeyClass monkey = new MonkeyClass(name, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength, species);
            monkeyMap.put(monkeyId, monkey); // monkey added to monkey hash map.
            System.out.println("Your monkey has been added.");
            // catches for various errors.
            } catch (Exception e) {
            	System.out.println("Error please try again.");
            } // end of catch
            
        } // end of intake monkey method
        // reserves an animal by name and country.
        public static void reserveAnimal(Scanner scanner) {
        	try {
            System.out.println("Enter animal type dog/monkey: ");
            String animalType = scanner.nextLine();
            if (animalType.equalsIgnoreCase("Monkey")) {
                System.out.println("Enter the monkey's country of acquisiton: ");
                String country = scanner.nextLine();
                for(MonkeyClass monkey : monkeyMap.values()) {
                    if(monkey.getAcquisitionLocation().equalsIgnoreCase(country)) {
                        if (monkey.getReserved()) {
                            System.out.println("This monkey is already reserved.");
                            return;
                        } // end of if
                        monkey.setReserved(true);
                        System.out.println("The monkey has been reserved.");
                        return;
                    } // end of if
                } // end of loop
                System.out.println("The monkey is not in the system.");
            } // end of if
            else if (animalType.equalsIgnoreCase("Dog")) {
                    System.out.println("Enter the dog's country of acquisition: ");
                    String country = scanner.nextLine();
                    for(Dog dog : dogMap.values()){
                        if(dog.getAcquisitionLocation().equalsIgnoreCase(country)) {
                            if (dog.getReserved()) {
                                System.out.println("This dog is already reserved.");
                                return;
                            } // end of if
                            dog.setReserved(true);
                            System.out.println("The dog has been reserved.");
                            return;
                        } // end of if 
                    } // end of loop
                System.out.println("The dog is not in the system");
                }  else {
                System.out.println("Invalid input");
                } // end of else
        	} catch(Exception e) {
        		System.out.println("Error, please try again");
                } // end of catch
        
        } // end of reserve animal function.
            
        // prints dogs and monkeys.
        public static void printNonReservedAnimals() {
        	try {
            for (Dog dog : dogMap.values()) {
                if (!dog.getReserved()) {  // Check status of dog. If not reserved output
                    System.out.println(dog.getDogInfo());
                } // end of if
            } // end of for loop
            
            // Print non-reserved monkeys
            for (MonkeyClass monkey : monkeyMap.values()) {
                if (!monkey.getReserved()) {  // Check status of monkey. If not reserved output
                    System.out.println(monkey.getMonkeyInfo());
                } // end of if
            } // end of for loop
        	} catch(Exception e) {
        		System.out.println("Error, try again."); // catches various errors.
        	} // end of catch
        } // end of printNonReservedAnimals
        
        public static boolean animalReservedStatus(Scanner scanner) {
            boolean reserved = false;
            boolean input = false;
            while (!input) {
            	try {
                System.out.println("What is the animals reservation status? (true/false)");
                String reservedInput = scanner.nextLine().toLowerCase();
                if (reservedInput.equals("true")) {
                    reserved = true;
                    input = true;
                } else if (reservedInput.equals("false")) {
                    reserved = false;
                    input = true;
                } else {
                    System.out.println("Please enter true or false.");
                }
            	} catch(Exception e) {
            		System.out.println("Error, try again."); // catches various errors.
            	}
            } // end of loop
            return reserved;
        } // end of method
} // end of driver

