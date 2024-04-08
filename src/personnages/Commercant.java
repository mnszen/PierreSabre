package personnages;

public class Commercant extends Humain {

    public Commercant(String nom, int argent) {
        super(nom, "thé", argent);
    }

    public int seFaireExtorquer() {
        int montantExtorque = getArgent();
        setArgent(0);
        parler("J’ai tout perdu! Le monde est trop injuste...");
        return montantExtorque;
    }

    public void recevoir(int argent) {
        gagnerArgent(argent); 
        parler("Merci pour les " + argent + " sous, je vous suis très reconnaissant!");
    }
}
