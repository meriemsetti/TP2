public class Client {
    private String cin;
    private String nom;
    private String prenom;
    private String telephone;

    // Constructeur
    public Client(String cin, String nom, String prenom, String telephone) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    // Getters
    public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    // Setters
    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Afficher les informations du client
    public void afficherClient() {
        System.out.println("[CIN: " + cin + "] Nom & Prénom: "
                + nom + " " + prenom + " | Tél: " + telephone);
    }
}