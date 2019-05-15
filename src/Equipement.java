package FileRouge;

class Equipement {

	private String nomEquipement;
	private TypeEquipement typeEquipement; 
  	private int bonus;
  	
	public Equipement(String nomEquipement, TypeEquipement typeEquipement, int bonus) {
		this.nomEquipement = nomEquipement;
		this.typeEquipement = typeEquipement;
		this.bonus = bonus;
	}

	public String getNomEquipement() {
		return nomEquipement;
	}

	public void setNomEquipement(String nomEquipement) {
		this.nomEquipement = nomEquipement;
	}

	public TypeEquipement getTypeEquipement() {
		return typeEquipement;
	}

	public void setTypeEquipement(TypeEquipement typeEquipement) {
		this.typeEquipement = typeEquipement;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	

	
	
}