package cat.paucasesnovescifp.spaad.mongodb;

import cat.paucasesnovescifp.spaad.mongodb.controlador.ComBBDD;
import cat.paucasesnovescifp.spaad.mongodb.dades.Aspirant;
import org.bson.Document;

import java.util.ArrayList;

public class ProvesIniciacio
{

    public static void main(String[] args)
    {
        ComBBDD conexio = new ComBBDD("mongodb://localhost:27017", "TestDB", "AspirantsComplet");

        Aspirant aspirant = new Aspirant("12345678H","Antoño","Plomer Suau", "99999");

        Document document = new Document().append("nif","12312312A").append("nom","MiquelAngel");

        Document documentAsp = new Document()
                .append("nif",aspirant.getNif())
                .append("nom",aspirant.getNom())
                .append("llinatges",aspirant.getLlinatges())
                .append("codiPostal",aspirant.getCodiPostal());

        Document documentMap = new Document(aspirant.toMap());

        //conexio.insertaUnDocument(documentAsp);

        /*ArrayList<Aspirant> llista = conexio.tornaAspirants();
        for (Aspirant a: llista) {
            System.out.println(a);
        }*/

        //conexio.mostraBlock();

        /*ArrayList<Document> testDocuments = conexio.tornaAspirantsDoc();
        for (Document a: testDocuments) {
            System.out.println(a);
        }*/

        /*ArrayList<Document> testDocuments2 = conexio.tornaAspirantsDocPos(3,5);
        for (Document a: testDocuments2) {
            System.out.println(a);
        }*/

        /*ArrayList<Document> testDocuments3 = conexio.tornaAspirantsCP("07865");
        for (Document a: testDocuments3) {
            System.out.println(a);
        }*/



    }
}
