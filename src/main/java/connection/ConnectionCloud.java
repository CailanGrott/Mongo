package connection;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class ConnectionCloud {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://cailangrott:Caica122014@carros.ktzqf8z.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoDatabase database = mongoClient.getDatabase("Carros");

        database.createCollection("Honda");

        MongoCollection<Document> veiculosCollection = database.getCollection("Honda");

        Document carro = new Document("Modelo", "Civic")
                .append("Ano", 2016)
                .append("Valor", 10000);
        veiculosCollection.insertOne(carro);

        Document consulta = veiculosCollection.find(eq("Marca", "Honda")).first();
        System.out.println(consulta);
    }
}