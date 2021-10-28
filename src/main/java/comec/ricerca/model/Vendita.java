package comec.ricerca.model;

public class Vendita {
	
	private Item item;
	private Integer num_pezzi;
	private Double importo;
	private Double costo_primo;
	private Double prezzo_singolo;
	private Double margine;
	
	public Vendita(Item item, Integer num_pezzi, Double importo, Double costo_primo) {
		super();
		this.item = item;
		this.num_pezzi = num_pezzi;
		this.importo = importo;
		this.costo_primo = costo_primo;
		this.prezzo_singolo = this.num_pezzi/this.importo;
		if(this.costo_primo!=null)
			this.margine = this.importo - (this.num_pezzi*this.costo_primo);
		else
			this.margine = null;
	}

	public Item getItem() {
		return item;
	}

	public Integer getNum_pezzi() {
		return num_pezzi;
	}

	public Double getImporto() {
		return importo;
	}

	public Double getCosto_primo() {
		return costo_primo;
	}

	public Double getPrezzo_singolo() {
		return prezzo_singolo;
	}

	public Double getMargine() {
		return margine;
	}

}
