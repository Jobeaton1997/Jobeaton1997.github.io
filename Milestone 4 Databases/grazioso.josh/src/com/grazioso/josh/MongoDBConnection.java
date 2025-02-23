package com.grazioso.josh;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.HashMap;

public class MongoDBConnection {
	private static final String URI = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "animalRescue";
    private static final String COLLECTION_NAME = "animals";

    private static MongoClient mongoClient = MongoClients.create(URI);
    private static MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
    private static MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

    public static MongoCollection<Document> getCollection() {
        return collection;
    }

    // Save a dog
    public static void saveDog(Dog dog) {
        Document doc = new Document("name", dog.getName())
                .append("type", "Dog")
                .append("breed", dog.getBreed())
                .append("gender", dog.getGender())
                .append("age", dog.getAge())
                .append("weight", dog.getWeight())
                .append("acquisitionDate", dog.getAcquisitionDate())
                .append("acquisitionCountry", dog.getAcquisitionLocation())
                .append("trainingStatus", dog.getTrainingStatus())
                .append("reserved", dog.getReserved())
                .append("inServiceCountry", dog.getInServiceLocation());
        collection.insertOne(doc);
    } // end of saveDog

    // Save a monkey
    public static void saveMonkey(MonkeyClass monkey) {
        Document doc = new Document("name", monkey.getName())
                .append("type", "Monkey")
                .append("species", monkey.getSpecies())
                .append("gender", monkey.getGender())
                .append("age", monkey.getAge())
                .append("weight", monkey.getWeight())
                .append("acquisitionDate", monkey.getAcquisitionDate())
                .append("acquisitionCountry", monkey.getAcquisitionLocation())
                .append("trainingStatus", monkey.getTrainingStatus())
                .append("reserved", monkey.getReserved())
                .append("inServiceCountry", monkey.getInServiceLocation())
                .append("tailLength", monkey.getTailLength())
                .append("height", monkey.getHeight())
                .append("bodyLength", monkey.getBodyLength());
        collection.insertOne(doc);
    } // end of saveMonkey

    // puts animals into HashMaps
    public static void loadAnimals(HashMap<Integer, Dog> dogMap, HashMap<Integer, MonkeyClass> monkeyMap) {
        int dogId = 1;
        int monkeyId = 1;

        // Check if initialized correctly
        if (collection == null) {
            System.out.println("Collection is not initialized.");
            return;
        }

        // Fetch documents
        for (Document doc : collection.find()) {
            System.out.println("Fetched Document: " + doc.toJson()); // Print each fetched document
            String type = doc.getString("type");
            
            // Output for debugging
            System.out.println("Type found: " + type);

            if ("Dog".equals(type)) {
                Dog dog = new Dog(
                    doc.getString("name"),
                    doc.getString("breed"),
                    doc.getString("gender"),
                    String.valueOf(doc.getInteger("age")),
                    String.valueOf(doc.getInteger("weight")),
                    doc.getString("acquisitionDate"),
                    doc.getString("acquisitionCountry"),
                    doc.getString("trainingStatus"),
                    doc.getBoolean("reserved"),
                    doc.getString("inServiceCountry")
                );
                dogMap.put(dogId++, dog);
            } else if ("Monkey".equals(type)) {
                MonkeyClass monkey = new MonkeyClass(
                    doc.getString("name"),
                    doc.getString("gender"),
                    String.valueOf(doc.getInteger("age")),
                    String.valueOf(doc.getInteger("weight")),
                    doc.getString("acquisitionDate"),
                    doc.getString("acquisitionCountry"),
                    doc.getString("trainingStatus"),
                    doc.getBoolean("reserved"),
                    doc.getString("inServiceCountry"),
                    doc.getString("tailLength"),
                    doc.getString("height"),
                    doc.getString("bodyLength"),
                    doc.getString("species")
                );
                monkeyMap.put(monkeyId++, monkey);
            } else {
                System.out.println("Unknown type: " + type); // Print if the type is not recognized
            } // end of else
        } // end of for loop
        
        // Print the results after loading
        System.out.println("Total Dogs Loaded: " + dogMap.size());
        System.out.println("Total Monkeys Loaded: " + monkeyMap.size());
    } // end of load animals
    
    // Method to get the URI
    public static String getURI() {
        return URI;
    } // End of getUri

    public static String getDatabaseName() {
        return DATABASE_NAME;
    } // end of getDatabaseName

} // end of class
