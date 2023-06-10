package modele;

public enum TypeTomate {
	
	TOMATES_CERISES("Cerises & Cocktails (16)"), TOMATES("Autres Tomates (47)");
	
	private final String denomination;

	private TypeTomate(String denomination) {
		this.denomination  = denomination;
	}

	public String getDenomination() {
		return this.denomination;
	}
	
	public static TypeTomate getTypeTomate(String denomination) {
		for (TypeTomate t : TypeTomate.values()) {
			if (t.getDenomination().equals(denomination)) {
				return t;
			}
		}
		return null;
	}
	
	public static String[] getAllTypeTomate() {
		String[] tab = new String[TypeTomate.values().length];
		int i = 0;
		for (TypeTomate t : TypeTomate.values()) {
			tab[i] = t.getDenomination();
			i+=1;
		}
		return tab;
	}

}
