package comec.ricerca.model;

public class VariazionePeso implements Comparable<VariazionePeso>{
	
	Integer indice;
	Double valore;
	
	public VariazionePeso(Integer indice, Double valore) {
		super();
		this.indice = indice;
		this.valore = valore;
	}

	public Integer getIndice() {
		return indice;
	}

	public Double getValore() {
		return valore;
	}

	@Override
	public int compareTo(VariazionePeso o) {
		return o.valore.compareTo(this.valore);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((indice == null) ? 0 : indice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VariazionePeso other = (VariazionePeso) obj;
		if (indice == null) {
			if (other.indice != null)
				return false;
		} else if (!indice.equals(other.indice))
			return false;
		return true;
	}

}
