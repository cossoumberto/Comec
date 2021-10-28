package comec.ricerca.model;

public class Confronto implements Comparable<Confronto> {
	
	private Item item;
	
	private Double deltaDint;
	private Double deltaDest;
	private Double deltaH;
	private Double deltaSp;
	private Double peso;
	
	private Double divDint;
	private Double divDest;
	private Double divH;
	private Double divSp;
	private Double coeff;
	
	public Confronto(Item item, Double deltaDint, Double deltaDest, Double deltaH, Double deltaSp,
								Double divDint, Double divDest, Double divH, Double divSp) {
		super();
		this.item = item;
		
		this.deltaDint = deltaDint;
		this.deltaDest = deltaDest;
		this.deltaH = deltaH;
		this.deltaSp = deltaSp;
		if(this.deltaDint!=null && this.deltaDest!=null && this.deltaH!=null && this.deltaSp!=null)
			this.setPeso();
		else 
			this.peso = null;
		
		this.divDint = divDint;
		this.divDest = divDest;
		this.divH = divH;
		this.divSp = divSp;
		if(this.divDint!=null && this.divDest!=null && this.divH!=null && this.divSp!=null) {
			if(this.divDint<1)
				this.divDint = 2 - this.divDint;
			if(this.divDest<1)
				this.divDest = 2 - this.divDest;
			if(this.divH<1)
				this.divH = 2 - this.divH;
			if(this.divSp<1)
				this.divSp = 2 - this.divSp;
			this.setCoeff();
		} else 
			this.coeff = null;
	}

	public Item getItem() {
		return item;
	}


	public Double getPeso() {
		return peso;
	}
	
	public Double getCoeff() {
		return coeff;
	}
	
	
	@Override
	public int compareTo(Confronto o) {
		return this.peso.compareTo(o.peso);
	}

	public void setStandardDeltaDint(Double midDeltaDint, Double devStDeltaDint) {
		this.deltaDint = Math.abs(deltaDint - midDeltaDint)/devStDeltaDint;
	}
	
	public void setStandardDeltaDest(Double midDeltaDest, Double devStDeltaDest) {
		this.deltaDest = Math.abs(deltaDest - midDeltaDest)/devStDeltaDest;
	}
	
	public void setStandardDeltaH(Double midDeltaH, Double devStDeltaH) {
		this.deltaH = Math.abs(deltaH - midDeltaH)/devStDeltaH;
	}
	
	public void setStandardDeltaSp(Double midDeltaSp, Double devStDeltaSp) {
		this.deltaSp = Math.abs(deltaSp - midDeltaSp)/devStDeltaSp;
	}
	
	private void setPeso() {
		this.peso = (this.deltaDest + this.deltaDint + this.deltaH + this.deltaSp)/4;
	}
	

	private void setCoeff() {
		this.coeff = (this.divDint + this.divDest + this.divH + this.divSp)/4;
	}

	@Override
	public String toString() {
		return "P = " + this.peso + " C = " + this.coeff + " " + this.item;
	}
	
	
}
