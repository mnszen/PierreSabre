package personnages;

public class Ronin extends Humain {
	private int honneur;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		this.honneur = 1;
	}

	public void donner(Commercant beneficiaire) {
		int montantDonne = (int) ((this.argent) * 0.1);
		this.perdreArgent(montantDonne);
		parler(beneficiaire.getNom() + " prend ces " + montantDonne + " sous");
		beneficiaire.recevoir(montantDonne);
	}

	public void provoquer(Yakuza adversaire) {
		int force = this.honneur * 2;
		if (force >= adversaire.getReputation()) {
			int argentYakuza = adversaire.getArgent();
			this.gagnerArgent(argentYakuza);
			this.honneur++;
			adversaire.perdre();
			parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
			parler("Je t’ai eu petit yakusa!");
		} else {
			adversaire.gagner(this.argent);
			this.argent = 0;
			if (this.honneur >= 1) {
				this.honneur = -1;
			} else {
				this.honneur = 0;
			}
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
		}
	}
}
