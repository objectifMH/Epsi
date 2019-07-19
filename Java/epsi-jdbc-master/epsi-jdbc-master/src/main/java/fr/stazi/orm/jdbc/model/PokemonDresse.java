package fr.stazi.orm.jdbc.model;

public class PokemonDresse extends Pokemon {
	private String nickname;
	private Dresseur dresseur;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Dresseur getDresseur() {
		return dresseur;
	}

	public void setDresseur(Dresseur dresseur) {
		this.dresseur = dresseur;
	}

	@Override
	public String toString() {
		return "PokemonDresse [pokemon=" + super.toString() + ", dresseur=" + dresseur + ", nickname=" + nickname
				+ "]";
	}
}
