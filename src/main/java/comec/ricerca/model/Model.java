package comec.ricerca.model;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comec.ricerca.db.DAO;
import comec.ricerca.model.Item.Categoria;

public class Model {
	
	private List<Item> items;
	private List<String> materials;
	List<Vendita> vendite;
	private DAO dao;
	
	public Model() {
		this.items = new ArrayList<>();
		this.materials = new ArrayList<>();
		this.vendite = new ArrayList<>();
		//this.readFile();
		dao = new DAO();
		dao.loadAllItems(items, materials);
		dao.loadVendite(vendite, items);
	}
	
	/*
	public void readFile() {
		try {
			BufferedReader br = new BufferedReader (new FileReader("items.txt"));
			String riga = br.readLine();
			Item item = null;
			while(riga!=null) {
				String s [] = riga.split(";");
				List<Double> num = new ArrayList <>();
				for(int i=3; i<=6; i++)
					num.add(Double.parseDouble(s[i].replace(',', '.')));
				if(s[1].equals("S1"))
					item = new Item(s[0], Categoria.S1, s[2], num.get(0), num.get(1), num.get(3), num.get(2));
				else if(s[1].equals("S2"))
					item = new Item(s[0], Categoria.S2, s[2], num.get(0), num.get(1), num.get(3), num.get(2));
				else
					item = new Item(s[0], Categoria.N, s[2], num.get(0), num.get(1), num.get(3), num.get(2));
				if(s[2]!=null && !s[2].equals(""))
					if(!materials.contains(s[2]))
						materials.add(s[2]);
				if(item!=null)
					items.add(item);
				riga = br.readLine();
			}
			//System.out.print(items);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore apertura file");
		}
	}
	*/
	
	public List<Item> getS1() {
		List <Item> list = new ArrayList<>();
		for(Item i : items) {
			if(i.getCategoria()==Categoria.S1)
				list.add(i);
		}
		Collections.sort(list);
		return list;
	}
	
	public List<Item> getS2() {
		List <Item> list = new ArrayList<>();
		for(Item i : items) {
			if(i.getCategoria()==Categoria.S2)
				list.add(i);
		}
		Collections.sort(list);
		return list;
	}
	
	public List<Item> getOthers() {
		List <Item> list = new ArrayList<>();
		for(Item i : items) {
			if(i.getCategoria()!=Categoria.S1 && i.getCategoria()!=Categoria.S2)
				list.add(i);
		}
		Collections.sort(list);
		return list;
	}
	
	public List<String> getMaterials(){
		return materials;
	}
	
	public List<Item> getResearch (List<Item> source, String material, Double minDint, Double maxDint, Double minDest, Double maxDest,
														Double minH, Double maxH, Double minSp, Double maxSp){
		if(material==null && minDint==null && maxDint==null && minDest==null && maxDest==null &&
				minH==null && maxH==null && minSp==null && maxSp==null)
			return source;
		else {
			List<Item> list = new ArrayList<>();
			for(Item i : source)
				if(material==null || (material!=null && i.getMateriale().equals(material)))
					if( (minDint==null && maxDint==null) ||
							(minDint==null && i.getDint()<=maxDint) ||
							(maxDint==null && i.getDint()>=minDint) ||
							(minDint!=null && maxDint!=null && i.getDint()>=minDint && i.getDint()<=maxDint) ) 
								if( (minDest==null && maxDest==null) ||
									(minDest==null && i.getDest()<=maxDest) ||
									(maxDest==null && i.getDest()>=minDest) ||
									(minDest!=null && maxDest!=null && i.getDest()>=minDest && i.getDest()<=maxDest) ) 
										if( (minH==null && maxH==null) ||
											(minH==null && i.getH()<=maxH) ||
											(maxH==null && i.getH()>=minH) ||
											(minH!=null && maxH!=null && i.getH()>=minH && i.getH()<=maxH) ) 
												if( (minSp==null && maxSp==null) ||
													(minSp==null && i.getSp()<=maxSp) ||
													(maxSp==null && i.getSp()>=minSp) ||
													(minSp!=null && maxSp!=null && i.getSp()>=minSp && i.getSp()<=maxSp) ) 
														list.add(i);
			return list;
		}
	}
	
	public Item inserisci(Item item) {
		items.add(item);
		return dao.inserisci(item);
	}
	/*
	public Item inserisci(Item item) {
		String path = "items.txt";
		try {
			FileWriter fw = new FileWriter(path, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(item.toFile());
			pw.flush();
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Errore scrittura file");
		}
		items.add(item);
		return item;
	}
	*/

	public Item aggiorna(Item item, String codice, Categoria categoria, String materiale, Double dint, Double dest, Double h, Double sp) {
		Item oldItem = new Item (item.getCodice(), item.getCategoria(), item.getMateriale(),
				item.getDint(), item.getDest(), item.getH(), item.getSp());
		if(codice!=null && !codice.equals(""))
			item.setCodice(codice);
		if(categoria!=null)
			item.setCategoria(categoria);
		if(materiale!=null)
			item.setMateriale(materiale);
		if(dint!=null)
			item.setDint(dint);
		if(dest!=null)
			item.setDest(dest);
		if(h!=null)
			item.setH(h);
		if(sp!=null)
			item.setSp(sp);
		dao.elimina(oldItem);
		return dao.inserisci(item);
	}
		/*
		if(codice!=null && !codice.equals(""))
			item.setCodice(codice);
		if(categoria!=null)
			item.setCategoria(categoria);
		if(materiale!=null)
			item.setMateriale(materiale);
		if(dint!=null)
			item.setDint(dint);
		if(dest!=null)
			item.setDest(dest);
		if(h!=null)
			item.setH(h);
		if(sp!=null)
			item.setSp(sp);
		String path = "items.txt";
		try {
			FileWriter fw = new FileWriter(path, false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for(Item i : items)
				pw.println(i.toFile());
			pw.flush();
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Errore scrittura file");
		}
		return item;
		*/

	public Item elimina(Item item) {
		items.remove(item);
		return dao.elimina(item);
	}
		/*
		String path = "items.txt";
		try {
			FileWriter fw = new FileWriter(path, false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for(Item i : items)
				pw.println(i.toFile());
			pw.flush();
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Errore scrittura file");
		}
		return item;*/
	
	public List<Confronto> confronta (Item newItem) {
		List<Confronto> confronti = new ArrayList<>();
		List<ItemStandard> standardList = this.standardizza(newItem);
		ItemStandard newItSt = standardList.get(standardList.size()-1);
		standardList.remove(newItSt);
		for(ItemStandard is : standardList)	
			confronti.add(new Confronto(is.getItem(), 
					Math.abs(is.getStDint()-newItSt.getStDint()),
					Math.abs(is.getStDest()-newItSt.getStDest()),
					Math.abs(is.getStH()-newItSt.getStH()),
					Math.abs(is.getStSp()-newItSt.getStSp()),
					newItem.getDint()/is.getItem().getDint(),
					newItem.getDest()/is.getItem().getDest(),
					newItem.getH()/is.getItem().getH(),
					newItem.getSp()/is.getItem().getSp()));	
		Collections.sort(confronti);
		return confronti;
	}
	
	public List<VariazionePeso> getVariazioniPeso(List<Confronto> confronti){
		List <VariazionePeso> variazioni =  new ArrayList<>();
		for(int i = 0; i<confronti.size()-1; i++) {
			variazioni.add(new VariazionePeso(confronti.indexOf(confronti.get(i))+1,
					confronti.get(i+1).getPeso()-confronti.get(i).getPeso()));
		}
		Collections.sort(variazioni);
		return variazioni;
	}

	private List<ItemStandard> standardizza(Item newItem) {
		List<Item> nonStandard = null;
		List<ItemStandard> standard = new ArrayList<ItemStandard>();
		if(newItem.getCategoria() == Categoria.S1)
			nonStandard = this.getS1();
		if(newItem.getCategoria() == Categoria.S2)
			nonStandard = this.getS2();
		if(newItem.getCategoria() == Categoria.N)
			nonStandard = this.getOthers();
		Double sumDint = 0.0;
		Double sumDest = 0.0;
		Double sumH = 0.0;
		Double sumSp = 0.0;
		for(Item i : nonStandard) {
			sumDint += i.getDint();
			sumDest += i.getDest();
			sumH += i.getH();
			sumSp += i.getSp();
		}
		Double midDint = sumDint/nonStandard.size();
		Double midDest = sumDest/nonStandard.size();
		Double midH = sumH/nonStandard.size();
		Double midSp = sumSp/nonStandard.size();
		Double numVarDint = 0.0;
		Double numVarDest = 0.0;
		Double numVarH = 0.0;
		Double numVarSp = 0.0;
		for(Item i : nonStandard) {
			numVarDint += Math.pow(i.getDint() - midDint, 2);
			numVarDest += Math.pow(i.getDest() - midDest, 2);
			numVarH += Math.pow(i.getH() - midH, 2);
			numVarSp += Math.pow(i.getSp() - midSp, 2);
		}
		Double devStDint = Math.sqrt(numVarDint/nonStandard.size());
		Double devStDest = Math.sqrt(numVarDest/nonStandard.size());
		Double devStH = Math.sqrt(numVarH/nonStandard.size());
		Double devStSp = Math.sqrt(numVarSp/nonStandard.size());
		if(devStDint!=0 && devStDest!=0 && devStH!=0 && devStSp!=0) {
			for(Item i : nonStandard)
				standard.add(new ItemStandard(i, (i.getDint()-midDint)/devStDint, (i.getDest()-midDest)/devStDest,
						(i.getH()-midH)/devStH, (i.getSp()-midSp)/devStSp));
			standard.add(new ItemStandard(newItem, (newItem.getDint()-midDint)/devStDint, (newItem.getDest()-midDest)/devStDest,
					(newItem.getH()-midH)/devStH, (newItem.getSp()-midSp)/devStSp));
		} else {
			ItemStandard is = null; 
			for(Item i : nonStandard) {
				is = new ItemStandard(i, i.getDint(), i.getDest(), i.getH(), i.getSp());
				if(devStDint!=0.0)
					is.setStDint((i.getDint()-midDint)/devStDint);
				if(devStDest!=0.0)
					is.setStDest((i.getDest()-midDest)/devStDest);
				if(devStH!=0.0)
					is.setStH((i.getH()-midH/devStH));
				if(devStSp!=0.0)
					is.setStSp((i.getSp()-midSp/devStSp));
				standard.add(is);
			}
			ItemStandard newItemSt = new ItemStandard(newItem, newItem.getDint(), newItem.getDest(), newItem.getH(), newItem.getSp());
			if(devStDint!=0.0)
				newItemSt.setStDint((newItem.getDint()-midDint)/devStDint);
			if(devStDest!=0.0)
				newItemSt.setStDest((newItem.getDest()-midDest)/devStDest);
			if(devStH!=0.0)
				newItemSt.setStH((newItem.getH()-midH/devStH));
			if(devStSp!=0.0)
				newItemSt.setStSp((newItem.getSp()-midSp/devStSp));
			standard.add(newItemSt);
		}
		return standard;
	}
	
	public Double getCostoItem(Item item) {
		for(Vendita v : vendite)
			if(v.getItem().equals(item))
				return v.getCosto_primo();
		return null;
	}
	
	public Double setDecimali (Double d, Integer decimali) {
		Double temp = Math.pow(10, decimali);
		return Math.ceil(d*temp)/temp;
	}

	public Double calcolaNewCosto(List<Confronto> confronti, Integer numI) {
			Double somma = 0.0;
			Double sommaPesi = 0.0;
			Double max= confronti.get(numI-1).getPeso() + confronti.get(0).getPeso();
		for(Confronto c : confronti) {
			if(confronti.indexOf(c)>=numI)
				break;
			somma += (max-c.getPeso())*c.getCoeff()*this.getCostoItem(c.getItem());
			sommaPesi += (max-c.getPeso());
		}
		if(sommaPesi == 0)
			return null;
		return somma/sommaPesi;
	}
	
	public Integer numVenditeNote() {
		Integer i = 0;
		for(Vendita v : vendite) {
			if(v.getCosto_primo()!=null)
				i++;
		}
		return i;
	}
	
	public Double confrontaMargine (Vendita newV) {
		Double d = 0.0;
		for(Vendita v : vendite)
			if(newV.getMargine()>=v.getMargine())
				d++;
		if(this.numVenditeNote()!=0)
			return (d/this.numVenditeNote())*100;
		else return null;
	}
	
	public Double totImporti() {
		Double d = 0.0;
		for(Vendita v : vendite)
			if(v.getCosto_primo()!=null)
				d+= v.getImporto();
		return d;
	}
	
	public Double totMargini() {
		Double d = 0.0;
		for(Vendita v : vendite)
			if(v.getCosto_primo()!=null)
				d+= v.getMargine();
		return d;
	}
}

