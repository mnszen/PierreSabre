package personnages;

public class Humain {

	private String nom;
	private String boisson;
	protected int argent;
	protected int Nbconnaissance = 0;
	protected Humain[] connaissances = new Humain[MAX_CONNAISSANCES];
    private static final int MAX_CONNAISSANCES = 30;

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}

	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	public void parler(String texte) {
		System.out.println("(" + this.nom + ") " + texte);
	}

	public void direBonjour() {
		parler("Bonjour ! je m'appelle " + this.nom + " et j'aime boire du" + this.boisson);
	}

	public void boire() {
		parler("mmmm un bon verre de " + this.boisson + "! gloups");
	}

	protected void gagnerArgent(int gain) {
		this.argent += gain;
	}

	protected void perdreArgent(int perte) {
		this.argent -= perte;
	}

	public void acheter(String bien, int prix) {
		if (this.argent >= prix) {
			parler("J'ai " + this.argent + " sous en poche. Je vais pouvoir m'offrir une boisson à " + prix + " sous");
			this.argent -= prix;
		} else {
			parler("Je n'ai plus que " + this.argent + " sous en poche. Je ne peux même pas m'offrir un " + bien + " à "
					+ prix + " sous");
		}
	}

	private int Nbreinstalisé = 0;

    public void memoriser(Humain humain) {
        if (Nbconnaissance < MAX_CONNAISSANCES) {
            connaissances[Nbconnaissance] = humain;
            Nbconnaissance++;
        } else {
            if (Nbreinstalisé < MAX_CONNAISSANCES) {
                connaissances[Nbreinstalisé] = humain;
                Nbreinstalisé++;
            } else {
                Nbreinstalisé = 0;
                connaissances[Nbreinstalisé] = humain;
                Nbreinstalisé++;
            }
        }
    }

	private void repondre(Humain humain1) {
		direBonjour();
		memoriser(humain1);
	}

	public void faireConnaissanceAvec(Humain humain2) {
		direBonjour();
		humain2.repondre(this);
		this.memoriser(humain2);
	}

	public String listerConnaissance() {
		String hommeConnus = "";
		for (int i = 0; i <= Nbconnaissance; i++) {
			if (connaissances[i] != null) {
				hommeConnus += connaissances[i].getNom() + ",";
			}
		}
		return hommeConnus;
	}

}
