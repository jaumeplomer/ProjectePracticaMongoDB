package cat.paucasesnovescifp.spaad.mongodb.dades;

import org.bson.Document;
import com.mongodb.Block;
import java.lang.constant.DynamicCallSiteDesc;
import java.util.HashMap;

public class Aspirant
{
    public String nif, nom, llinatges, codiPostal;

    public Aspirant(String nif, String nom, String llinatges, String codiPostal)
    {
        this.nif = nif;
        this.nom = nom;
        this.llinatges = llinatges;
        this.codiPostal = codiPostal;
    }

    public HashMap<String,Object> toMap()
    {
        HashMap<String,Object> retorna = new HashMap<>();
        retorna.put("nif",this.getNif());
        retorna.put("nom",this.getNom());
        retorna.put("llinatges",this.getLlinatges());
        retorna.put("codiPostal",this.getCodiPostal());
        return retorna;
    }

    @Override
    public String toString() {
        return "Aspirant{" +
                "nif='" + nif + '\'' +
                ", nom='" + nom + '\'' +
                ", llinatges='" + llinatges + '\'' +
                ", codiPostal='" + codiPostal + '\'' +
                '}';
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatges() {
        return llinatges;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    public String getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(String codiPostal) {
        this.codiPostal = codiPostal;
    }
}
