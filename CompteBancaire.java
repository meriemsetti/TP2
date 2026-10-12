public class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private Client titulaire;

    private static int nombreComptes = 0;

    // Constructeur
    public CompteBancaire(String numeroCompte, double soldeInitial,
                          Client titulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial >= 0 ? soldeInitial : 0.0;
        this.titulaire = titulaire;
        nombreComptes++;
    }

    // Getters
    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public Client getTitulaire() {
        return titulaire;
    }

    public static int getNombreComptes() {
        return nombreComptes;
    }

    // Setter
    public void setTitulaire(Client titulaire) {
        this.titulaire = titulaire;
    }

    // Déposer de l'argent
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.printf("Dépôt de %.2f TND effectué sur le compte %s.%n",
                    montant, numeroCompte);
        } else {
            System.out.println("Erreur : le montant du dépôt doit être positif.");
        }
    }

    // Retirer de l'argent
    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Erreur : le montant doit être positif.");
        } else if (montant > solde) {
            System.out.printf(
                    "Échec : solde insuffisant sur le compte %s (Solde actuel : %.2f TND).%n",
                    numeroCompte, solde);
        } else {
            solde -= montant;
            System.out.printf("Retrait de %.2f TND effectué sur le compte %s.%n",
                    montant, numeroCompte);
        }
    }

    // Virement entre deux comptes
    public void virer(CompteBancaire destinataire, double montant) {
        if (destinataire == null || destinataire == this) {
            System.out.println("Erreur : compte destinataire invalide.");
            return;
        }

        if (montant <= 0) {
            System.out.println("Erreur : le montant doit être positif.");
            return;
        }

        if (montant > solde) {
            System.out.println("Échec du virement : solde insuffisant.");
            return;
        }

        this.solde -= montant;
        destinataire.solde += montant;

        System.out.printf(
                "Virement de %.2f TND du compte %s vers le compte %s effectué.%n",
                montant, numeroCompte, destinataire.numeroCompte);
    }

    // Afficher les détails du compte
    public void afficherDetails() {
        System.out.println("Compte N° : " + numeroCompte);

        System.out.print("Titulaire : ");
        if (titulaire != null) {
            titulaire.afficherClient();
        } else {
            System.out.println("Aucun titulaire");
        }

        System.out.printf("Solde Actuel : %.2f TND%n", solde);
    }
}