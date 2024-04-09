package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation;

	public int getReputation() {
		return reputation;
	}

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
		this.reputation = 0;
	}

	@Override
    public void direBonjour() {
        super.direBonjour(); // Appel à la méthode direBonjour de la classe parente
        this.parler("mon clan est celui de " + this.clan); // Affichage spécifique au Yakuza
    }

	
	public void extorquer(Commercant victime) {
		int montantExtorque = victime.seFaireExtorquer();
		this.gagnerArgent(montantExtorque);
		this.reputation += 1;
		parler("J’ai piqué les " + montantExtorque + " sous de " + victime.getNom() + ", ce qui me fait "
				+ this.getArgent() + " sous dans ma poche");
	}

	public void perdre() {
		int montantPerdu = this.argent;
		this.argent = 0;
		this.reputation -= 1;
		parler("J’ai perdu mon duel et mes " + montantPerdu + " sous, snif... J'ai déshonoré le clan de " + this.clan
				+ ".");
	}

	public void gagner(int gain) {
		this.argent += gain;
		this.reputation++;
		parler("Ce ronin pensait vraiment battre " + this.nom + " du clan de " + this.clan
				+ " ? Je l'ai dépouillé de ses " + gain + " sous.");
	}

}
