package hotel;

import java.time.LocalDate;

/**
 * @author radum
 */
public class Client {

    private String nom;
    private String nif;
    private LocalDate dataNeix;

    public Client(String nom, String nif, LocalDate dataNeix) {
        this.nom = nom;
        this.nif = nif;
        this.dataNeix = dataNeix;
    }
    public String getNom() {
        return nom;
    }

    public String getNif() {
        return nif;
    }

    public LocalDate getDataNeix() {
        return dataNeix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setDataNeix(LocalDate dataNeix) {
        this.dataNeix = dataNeix;
    }

    public String showData() {
        return "nom: " + nom + ", nif: " + nif + ", data neixement: " + dataNeix + ". ";
    }

}
