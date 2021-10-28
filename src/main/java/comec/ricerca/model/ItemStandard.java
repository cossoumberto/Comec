package comec.ricerca.model;

public class ItemStandard {
	
	private Item item;
	private Double stDint;
	private Double stDest;
	private Double stH;
	private Double stSp;
	
	public ItemStandard(Item item, Double stDint, Double stDest, Double stH, Double stSp) {
		super();
		this.item = item;
		this.stDint = stDint;
		this.stDest = stDest;
		this.stH = stH;
		this.stSp = stSp;
	}

	public Item getItem() {
		return item;
	}

	public Double getStDint() {
		return stDint;
	}

	public Double getStDest() {
		return stDest;
	}

	public Double getStH() {
		return stH;
	}

	public Double getStSp() {
		return stSp;
	}

	public void setStDint(Double stDint) {
		this.stDint = stDint;
	}

	public void setStDest(Double stDest) {
		this.stDest = stDest;
	}

	public void setStH(Double stH) {
		this.stH = stH;
	}

	public void setStSp(Double stSp) {
		this.stSp = stSp;
	}
	
}
