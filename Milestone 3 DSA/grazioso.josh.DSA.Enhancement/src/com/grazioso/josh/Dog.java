package com.grazioso.josh;

public class Dog extends RescueAnimal {

    // Instance variable
    private String breed;

    // Constructor
    public Dog(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
    	super(name, "Dog", gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        setBreed(breed);
    }


	// Accessor Method
    public String getBreed() {
        return breed;
    }

    // Mutator Method
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }
    
    public String getDogInfo() {
        String dogInfo = "Name: " + getName() + "\n" +
                         "Breed: " + getBreed() + "\n" +
                         "Gender: " + getGender() + "\n" +
                         "Age: " + getAge() + "\n" +
                         "Weight: " + getWeight() + "\n" +
                         "Acquisition Date: " + getAcquisitionDate() + "\n" +
                         "Acquisition Country: " + super.getAcquisitionLocation() + "\n" +
                         "Training Status: " + getTrainingStatus() + "\n" +
                         "Reserved: " + super.getReserved() + "\n" +
                         "In-Service Country: " + super.getInServiceLocation() + "\n" +
        				 "id: " + super.getID() + "\n";
        return dogInfo;
    }
    
    // changes the format to human readable language.
    @Override
    public String toString() {
        return "[Dog Details: \n" +
               "Name: " + getName() + "\n" +
               "Type: Dog\n" +
               "Breed: " + getAnimalType() + "\n" + 
               "Gender: " + getGender() + "\n" +
               "Age: " + getAge() + "\n" +
               "Weight: " + getWeight() + "\n" +
               "Acquisition Date: " + getAcquisitionDate() + "\n" +
               "Acquisition Country: " + getAcquisitionLocation() + "\n" +
               "Training Status: " + getTrainingStatus() + "\n" +
               "Reserved: " + (getReserved() ? "Yes" : "No") + "\n" +
               "In-Service Country: " + getInServiceLocation() + "]" +
               "id: " + getID() + "\n";
    } // end of method



} // end of class

