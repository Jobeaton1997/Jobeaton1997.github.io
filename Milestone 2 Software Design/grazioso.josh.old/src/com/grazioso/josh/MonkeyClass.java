package com.grazioso.josh;


public class MonkeyClass extends RescueAnimal {
	
	private String tailLength;
	private String height;
	private String bodyLength;
	private String species;
	
	public MonkeyClass(String name, String gender, String age, String weight, String acquisitionDate, String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry, String tailLength, String height, String bodyLength, String species) {
	    super(name, "Monkey", gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
	    
	    setTailLength(tailLength);
	    setHeight(height);
	    setBodyLength(bodyLength);
	    setSpecies(species);
	}
	

	
	public void setTailLength(String tailLength) {
		this.tailLength = tailLength;
	}
	
	public String getTailLength () {
		return tailLength;
	}
	
	public void setHeight(String height) {
		this.height = height;
	}
	
	public String getHeight () {
		return height;
	}
	public void setBodyLength(String bodyLength) {
		this.bodyLength = bodyLength;
	}
	
	public String getBodyLength( ) {
		return bodyLength;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public String getSpecies () {
		return species;
	}
	
    public String getMonkeyInfo() {
        String monkeyInfo = "Name: " + getName() + "\n" +
                            "Type: " + getAnimalType() + "\n" +
                            "Gender: " + getGender() + "\n" +
                            "Age: " + getAge() + "\n" +
                            "Weight: " + getWeight() + "\n" +
                            "Acquisition Date: " + getAcquisitionDate() + "\n" +
                            "Acquisition Country: " + super.getAcquisitionLocation() + "\n" +
                            "Training Status: " + getTrainingStatus() + "\n" +
                            "Reserved: " + (getReserved() ? "Yes" : "No") + "\n" +
                            "In-Service Country: " + super.getInServiceLocation() + "\n" +
                            "Tail Length: " + getTailLength() + "\n" +
                            "Height: " + getHeight() + "\n" +
                            "Body Length: " + getBodyLength() + "\n" +
                            "Species: " + getSpecies();
        return monkeyInfo;
    }
	
	@Override
	public String toString() {
	    return "Monkey Details: \n" +
	           "Name: " + getName() + "\n" +
	           "Type: " + getAnimalType() + "\n" +
	           "Gender: " + getGender() + "\n" +
	           "Age: " + getAge() + "\n" +
	           "Weight: " + getWeight() + "\n" +
	           "Acquisition Date: " + getAcquisitionDate() + "\n" +
	           "Acquisition Country: " + getAcquisitionLocation() + "\n" +
	           "Training Status: " + getTrainingStatus() + "\n" +
	           "Reserved: " + (getReserved() ? "Yes" : "No") + "\n" +
	           "In-Service Country: " + getInServiceLocation() + "\n" +
	           "Tail Length: " + getTailLength() + "\n" +
	           "Height: " + getHeight() + "\n" +
	           "Body Length: " + getBodyLength() + "\n" +
	           "Species: " + getSpecies();
	}


}

