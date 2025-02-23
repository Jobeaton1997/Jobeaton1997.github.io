package com.grazioso.josh;
// allows use of arrays
import java.util.ArrayList;

// allows user input and output
import java.util.Scanner;
// driver class runs the program
public class Driver {
	
	// array holding list of dogs
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // Instance variables (if needed)

    //array holding list of monkeys
    private static ArrayList<MonkeyClass> monkeyList = new ArrayList<MonkeyClass>();
    
    // runs the program
    public static void main(String[] args) {
    	
    	// allows user to input
        Scanner scanner = new Scanner(System.in);
        
        // holds the value that user inputted
        String choice;


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
                    System.out.println(dogList);
                    break; // breaks to next choice
                case "5":
                	System.out.println(monkeyList);
                    break; // breaks to next choice
                case "6":
                    System.out.println("available");
                    printAnimals();
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

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

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
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    } // end of initializeDogList


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    	monkeyList.add(new MonkeyClass("Boone", "male", "2", "15.3", "03-14-2020", "Brazil", "intake", false, "Brazil", "15cm", "30cm", "40cm", "Capuchin"));
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine(); // saves name to users input
        for(Dog dog: dogList) {
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
        System.out.println("What is the dog's reservation status");
        boolean reserved = scanner.hasNextBoolean();
        System.out.println("What is the dog's in service country?");
        String inServiceCountry = scanner.nextLine();
        
        // create new dog object
        Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        dogList.add(dog); // add dog to list
        System.out.println("Your dog has been added.");
        
        
       
      
        // Here you would do something similar for each of the properties needed to make a Dog (all the properties in its constructor)
        
        // Add the code to instantiate a new dog and add it to the appropriate list
        //Dog dog = new Dog(name, breed, ...); // for the ... you would pass the rest of the variables you create and take in from the user.
        //dogList.add(dog);
    } // end of intake new dog


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("What is the monkey's name?");
            String name = scanner.nextLine(); // save monkeys name to users input
            // loop to check if monkey is already on list
            for(MonkeyClass monkey: monkeyList) {
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
            System.out.println("Is the monkey reserved?");
            Boolean reserved = scanner.nextBoolean();
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
            MonkeyClass monkey = new MonkeyClass(name, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength, species);
            monkeyList.add(monkey);
            
        } // end of intake monkey method

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("Enter animal type dog/monkey: ");
            String animalType = scanner.nextLine();
            if (animalType.equalsIgnoreCase("Monkey")) {
                System.out.println("Enter the monkey's country of acquisiton: ");
                String country = scanner.nextLine();
                for(MonkeyClass monkey: monkeyList) {
                    if(monkey.getAcquisitionLocation().equalsIgnoreCase(country)) {
                        monkey.setReserved(true);
                        return;
                    } // end of if
                } // end of loop
                System.out.println("The monkey is not in the system.");
            } // end of if
            else if (animalType.equalsIgnoreCase("Dog")) {
                    System.out.println("Enter the dog's country of acquisition: ");
                    String country = scanner.nextLine();
                    for(Dog dog: dogList){
                    if(dog.getAcquisitionLocation().equalsIgnoreCase(country)){
                        dog.setReserved(true);
                        return;
                    } // end of if

                } // end of loop
                System.out.println("The dog is not in the system");
                }  else {
                System.out.println("Invalid input");
                } // end of else
        
        } // end of reserve animal function.
            
        // prints dogs and monkeys.

        public static void printAnimals() {
        	for (Dog dog : dogList) {
        	    System.out.println(dog.getDogInfo());
        	}
        	
        	for (MonkeyClass monkey : monkeyList) {
        	    System.out.println(monkey.getMonkeyInfo());
        	}

        }
}

