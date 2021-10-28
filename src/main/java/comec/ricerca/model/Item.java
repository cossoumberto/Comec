package comec.ricerca.model;

public class Item implements Comparable<Item> {
		public enum Categoria {S1, S2, N};
		
		private String codice;
		private Categoria categoria;
		private String materiale;
		private Double dint;
		private Double dest;
		private Double sp;
		private Double h;
		
		public Item(String codice, Categoria categoria, String materiale, Double dint, Double dest, Double h, Double sp) {
			super();
			this.codice = codice;
			this.categoria = categoria;
			this.materiale = materiale;
			this.dint = dint;
			this.dest = dest;
			this.sp = sp;
			this.h = h;
		}

		public String getCodice() {
			return codice;
		}

		public void setCodice(String codice) {
			this.codice = codice;
		}
		
		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public String getMateriale() {
			return materiale;
		}

		public void setMateriale(String materiale) {
			this.materiale = materiale;
		}

		public Double getDint() {
			return dint;
		}

		public void setDint(Double dint) {
			this.dint = dint;
		}

		public Double getDest() {
			return dest;
		}

		public void setDest(Double dest) {
			this.dest = dest;
		}

		public Double getSp() {
			return sp;
		}

		public void setSp(Double sp) {
			this.sp = sp;
		}

		public Double getH() {
			return h;
		}

		public void setH(Double h) {
			this.h = h;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((codice == null) ? 0 : codice.hashCode());
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
			Item other = (Item) obj;
			if (codice == null) {
				if (other.codice != null)
					return false;
			} else if (!codice.equals(other.codice))
				return false;
			return true;
		}

		@Override
		public String toString() {
			if(this.categoria==Categoria.S1 || this.categoria==Categoria.S2)
			return this.codice + "  Descrizione: " + this.categoria + " " + this.materiale + " " + this.dest + "x" 
					+ this.dint + "x" + this.h + " Sp " + this.sp;
			else
				return this.codice + "  Descrizione: / " + this.materiale + " " + this.dest + "x" 
				+ this.dint + "x" + this.h + " Sp " + this.sp;
		}
		
		/*public String toFile() {
			if(this.categoria==Categoria.S1 || this.categoria==Categoria.S2)
			return this.codice + ";" + this.categoria + ";" + this.materiale + ";" + this.dint + ";" 
					+ this.dest + ";" + this.sp + ";" + this.h + ";";
			else
				return this.codice + ";;" + this.materiale + ";" + this.dint + ";" 
				+ this.dest + ";" + this.sp + ";" + this.h + ";";
		}*/


		@Override
		public int compareTo(Item o) {
			return this.codice.compareTo(o.codice);
		}
}
