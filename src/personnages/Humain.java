package personnages;

public class Humain {

	private String nom;
	private String boisson;
	private int argent;

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	public void parler(String texte) {
		System.out.println(texte);
	}

	public void direBonjour() {
		parler("Bonjour ! je m'appelle " + this.nom + " et j'aime boire du" + this.boisson);
	}

	public void boire() {
		parler("mmmm un bon verre de " + this.boisson + "! gloups");
	}

	private void gagnerArgent(int gain) {
		this.argent += gain;
	}

	private void perdreArgent(int perte) {
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
}
