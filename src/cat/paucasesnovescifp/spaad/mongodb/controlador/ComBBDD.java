package cat.paucasesnovescifp.spaad.mongodb.controlador;

import cat.paucasesnovescifp.spaad.mongodb.dades.Aspirant;
import com.mongodb.Block;
import com.mongodb.client.*;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;

public class ComBBDD
{
    MongoClient mongoClient;
    MongoDatabase db;
    MongoCollection<Document> col;
    Block<Document> block;

    public ComBBDD(String ruta, String dbNom, String colNom )
    {
        mongoClient = MongoClients.create(ruta);
        db = mongoClient.getDatabase(dbNom);
        col = db.getCollection(colNom);

        block = new Block<>() {
            @Override
            public void apply(Document document) {
                System.out.println("--------------------");
                System.out.println(document.getString("nif"));
                System.out.println(document.getString("nom"));
                System.out.println(document.getString("llinatges"));
                System.out.println("--------------------");
            }
        };
    }

    public void insertaUnDocument(Document doc)
    {
        col.insertOne(doc);
    }

    public ArrayList<Aspirant> tornaAspirants()
    {
        ArrayList<Aspirant> torna = new ArrayList<>();

        MongoCursor<Document> cursor = col.find().iterator();

        try{
            while(cursor.hasNext()) {
                Document doc = cursor.next();

                String nif = doc.getString("nif");
                String nom = doc.getString("nom");
                String llinatges = doc.getString("llinatges");
                String codiPostal = doc.getString("codiPostal");

                Aspirant a = new Aspirant(nif, nom, llinatges, codiPostal);
                torna.add(a);
            }
        } finally {
            cursor.close();
        }
        return torna;
    }

    public void mostraBlock()
    {
        MongoCursor<Document> cursor = col.find().iterator();
        try {
            while (cursor.hasNext()){
                Document doc = cursor.next();
                block.apply(doc);
            }
        } finally {
            cursor.close();
        }
    }

    public ArrayList<Document> tornaAspirantsDoc()
    {
        ArrayList<Document> torna = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().iterator();
        try {
            while (cursor.hasNext()){
                Document doc = cursor.next();
                torna.add(doc);
            }
        } finally {
            cursor.close();
        }
        return torna;
    }

    public ArrayList<Document> tornaAspirantsDocPos(int primer, int quantitat)
    {
        ArrayList<Document> torna = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().skip(primer).limit(quantitat).iterator();

        try {
            while (cursor.hasNext()){
                Document doc = cursor.next();
                torna.add(doc);
            }
        }finally {
            cursor.close();
        }
        return torna;
    }

    public ArrayList<Document> tornaAspirantsCP(String cp)
    {
        ArrayList<Document> torna = new ArrayList<>();
        return col.find(new Document("codiPostal", cp)).into(torna);
    }
}
