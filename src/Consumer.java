import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import spark.Request;

public class Consumer implements Messenger{
    private MongoCollection mongoCollection;
    private MongoDatabase db;
    @Override
    public void setUpMongoDb() {
        MongoClient mongoClient = new MongoClient(StringConstants.host, StringConstants.mongoDbPort);
        db = mongoClient.getDatabase(StringConstants.database);
        mongoCollection = db.getCollection(StringConstants.producerCollection);
    }

    @Override
    public String putToMongoDb(Request r) {
        String movieT, movieR;
        movieT = r.params(":movie");
        movieR = r.params(":rating");

        BasicDBObject query = new BasicDBObject();
        query.put("Title", movieT);
        query.append("Processed", "FALSE");
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("Title", movieT.toUpperCase());
        newDocument.append("Processed", "TRUE");
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);

        mongoCollection.updateOne(query, updateObject);

        return "Successfully updated " + movieT + " " + movieR + " in Database " + db.getName() + " and collection " + StringConstants.producerCollection + "\n";
    }
}