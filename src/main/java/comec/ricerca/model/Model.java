package comec.ricerca.model;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comec.ricerca.model.Item.Categoria;

public class Model {
	
	List<Item> uchiyama;
	List<String> materials;
	
	public Model() {
		this.uchiyama = new ArrayList<>();
		this.materials = new ArrayList<>();
		this.readFile();
	}
	
	public void readFile() {
		try {
			BufferedReader br = new BufferedReader (new FileReader("C:\\Users\\um_bi\\Desktop\\CO.MEC\\DB_Uchiyama.txt"));
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
					uchiyama.add(item);
				riga = br.readLine();
			}
			//System.out.print(uchiyama);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore apertura file");
		}
	}
	
	public List<Item> getS1() {
		List <Item> list = new ArrayList<>();
		for(Item i : uchiyama) {
			if(i.getCategoria()==Categoria.S1)
				list.add(i);
		}
		Collections.sort(list);
		return list;
	}
	
	public List<Item> getS2() {
		List <Item> list = new ArrayList<>();
		for(Item i : uchiyama) {
			if(i.getCategoria()==Categoria.S2)
				list.add(i);
		}
		Collections.sort(list);
		return list;
	}
	
	public List<Item> getOthers() {
		List <Item> list = new ArrayList<>();
		for(Item i : uchiyama) {
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
		String path = "C:\\Users\\um_bi\\Desktop\\CO.MEC\\DB_Uchiyama.txt";
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
		uchiyama.add(item);
		return item;
	}

	public Item aggiorna(Item item, String codice, Categoria categoria, String materiale, Double dint, Double dest, Double h, Double sp) {
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
		String path = "C:\\Users\\um_bi\\Desktop\\CO.MEC\\DB_Uchiyama.txt";
		try {
			FileWriter fw = new FileWriter(path, false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for(Item i : uchiyama)
				pw.println(i.toFile());
			pw.flush();
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Errore scrittura file");
		}
		return item;
	}

	public Item elimina(Item item) {
		uchiyama.remove(item);
		String path = "C:\\Users\\um_bi\\Desktop\\CO.MEC\\DB_Uchiyama.txt";
		try {
			FileWriter fw = new FileWriter(path, false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for(Item i : uchiyama)
				pw.println(i.toFile());
			pw.flush();
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Errore scrittura file");
		}
		return item;
	}
	
	
	
}

