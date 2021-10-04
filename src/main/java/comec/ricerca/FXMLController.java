/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package comec.ricerca;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import comec.ricerca.model.Item;
import comec.ricerca.model.Item.Categoria;
import comec.ricerca.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.RadioButton;

public class FXMLController {
	
	public Model model;
	private List<Item> result;
	private String lastInputMinDint;
	private String lastInputMaxDint;
	private String lastInputMinDest;
	private String lastInputMaxDest;
	private String lastInputMinH;
	private String lastInputMaxH;
	private String lastInputMinSp;
	private String lastInputMaxSp;
	
	private ToggleGroup group;
	
	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
	
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    
    //SEZIONE RICERCA 
    
    @FXML // fx:id="btnSpMaxEqualsMin"
    private Button btnSpMaxEqualsMin; // Value injected by FXMLLoader

    @FXML // fx:id="txtMinSp"
    private TextField txtMinSp; // Value injected by FXMLLoader

    @FXML // fx:id="txtMaxDint"
    private TextField txtMaxDint; // Value injected by FXMLLoader

    @FXML // fx:id="btnDintMinEqualsMax"
    private Button btnDintMinEqualsMax; // Value injected by FXMLLoader

    @FXML // fx:id="txtMinDint"
    private TextField txtMinDint; // Value injected by FXMLLoader

    @FXML // fx:id="btnDintMaxEqualsMin"
    private Button btnDintMaxEqualsMin; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpMinEqualsMax"
    private Button btnSpMinEqualsMax; // Value injected by FXMLLoader

    @FXML // fx:id="txtMaxSp"
    private TextField txtMaxSp; // Value injected by FXMLLoader

    @FXML // fx:id="checkS1"
    private CheckBox checkS1; // Value injected by FXMLLoader

    @FXML // fx:id="checkS2"
    private CheckBox checkS2; // Value injected by FXMLLoader
    
    @FXML // fx:id="checkAltro"
    private CheckBox checkAltro; // Value injected by FXMLLoader

    @FXML // fx:id="txtMinDest"
    private TextField txtMinDest; // Value injected by FXMLLoader

    @FXML // fx:id="btnDestMinEqualsMax"
    private Button btnDestMinEqualsMax; // Value injected by FXMLLoader

    @FXML // fx:id="txtMinH"
    private TextField txtMinH; // Value injected by FXMLLoader

    @FXML // fx:id="txtMaxDest"
    private TextField txtMaxDest; // Value injected by FXMLLoader

    @FXML // fx:id="txtMaxH"
    private TextField txtMaxH; // Value injected by FXMLLoader

    @FXML // fx:id="btnHMinEqualsMax"
    private Button btnHMinEqualsMax; // Value injected by FXMLLoader

    @FXML // fx:id="btnDestMaxEqualsMin"
    private Button btnDestMaxEqualsMin; // Value injected by FXMLLoader

    @FXML // fx:id="btnHMaxEqualsMin"
    private Button btnHMaxEqualsMin; // Value injected by FXMLLoader

    @FXML // fx:id="boxMaterial"
    private ComboBox<String> boxMaterial; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader
    
    
    //SEZIONE AGGIORNA
    
    @FXML // fx:id="aggTxtRicerca"
    private TextField aggTxtRicerca; // Value injected by FXMLLoader

    @FXML // fx:id="aggBoxCodice"
    private ComboBox<Item> aggBoxItem; // Value injected by FXMLLoader

    @FXML // fx:id="aggTxtCodice"
    private TextField aggTxtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="aggRadioS1"
    private RadioButton aggRadioS1; // Value injected by FXMLLoader

    @FXML // fx:id="aggRadioS2"
    private RadioButton aggRadioS2; // Value injected by FXMLLoader
    
    @FXML // fx:id="aggRadioAltro"
    private RadioButton aggRadioAltro; // Value injected by FXMLLoader

    @FXML // fx:id="aggBoxMateriale"
    private ComboBox<String> aggBoxMateriale; // Value injected by FXMLLoader

    @FXML // fx:id="aggTxtNewMateriale"
    private TextField aggTxtNewMateriale; // Value injected by FXMLLoader

    @FXML // fx:id="aggTxtDint"
    private TextField aggTxtDint; // Value injected by FXMLLoader

    @FXML // fx:id="aggTxtDest"
    private TextField aggTxtDest; // Value injected by FXMLLoader

    @FXML // fx:id="aggTxtH"
    private TextField aggTxtH; // Value injected by FXMLLoader

    @FXML // fx:id="aggTxtSp"
    private TextField aggTxtSp; // Value injected by FXMLLoader

    @FXML // fx:id="aggBtnInserisci"
    private Button aggBtnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="aggBtnAgg"
    private Button aggBtnAgg; // Value injected by FXMLLoader
    
    @FXML // fx:id="aggBtnElimina"
    private Button aggBtnElimina; // Value injected by FXMLLoader
    
    @FXML // fx:id="aggBtnAnnulla"
    private Button aggBtnAnnulla; // Value injected by FXMLLoader

    @FXML // fx:id="aggBtnReset"
    private Button aggBtnReset; // Value injected by FXMLLoader

    @FXML // fx:id="aggTxtResult"
    private TextArea aggTxtResult; // Value injected by FXMLLoader
    
    //SEZIONE VALUTA
    
    @FXML // fx:id="valTxtSp"
    private TextField valTxtSp; // Value injected by FXMLLoader

    @FXML // fx:id="valTxtDint"
    private TextField valTxtDint; // Value injected by FXMLLoader

    @FXML // fx:id="valTxtDest"
    private TextField valTxtDest; // Value injected by FXMLLoader

    @FXML // fx:id="valTxtH"
    private TextField valTxtH; // Value injected by FXMLLoader

    @FXML // fx:id="valBoxMateriale"
    private ComboBox<String> valBoxMateriale; // Value injected by FXMLLoader

    @FXML // fx:id="valCheckS1"
    private CheckBox valCheckS1; // Value injected by FXMLLoader

    @FXML // fx:id="valCheckS2"
    private CheckBox valCheckS2; // Value injected by FXMLLoader

    @FXML // fx:id="valCheckAltro"
    private CheckBox valCheckAltro; // Value injected by FXMLLoader

    @FXML // fx:id="valTxtNPezzi"
    private TextField valTxtNPezzi; // Value injected by FXMLLoader

    @FXML // fx:id="valTxtPrezzo"
    private TextField valTxtPrezzo; // Value injected by FXMLLoader

    @FXML // fx:id="btnValuta"
    private Button btnValuta; // Value injected by FXMLLoader

    @FXML // fx:id="valTxtResult"
    private TextArea valTxtResult; // Value injected by FXMLLoader

    @FXML // fx:id="valBtnReset"
    private Button valBtnReset; // Value injected by FXMLLoader

    
    //FUNZIONI SEZIONE RICERCA
    
    @FXML
    void destMaxEqualsMin(ActionEvent event) {
    	if(txtMinDest.isEditable()) {
    		if(!txtMaxDest.isEditable())
    			txtMaxDest.setEditable(true);
    		txtMaxDest.setText(txtMinDest.getText());
    	}
    }
    
    @FXML
    void destMinEqualsMax(ActionEvent event) {
    	if(txtMaxDest.isEditable()) {
    		if(!txtMinDest.isEditable())
    			txtMinDest.setEditable(true);
    		txtMinDest.setText(txtMaxDest.getText());
    	}
    }

    @FXML
    void dintMaxEqualsMin(ActionEvent event) {
    	if(txtMinDint.isEditable()) {
    		if(!txtMaxDint.isEditable())
    			txtMaxDint.setEditable(true);
    		txtMaxDint.setText(txtMinDint.getText());
    	}
    }

    @FXML
    void dintMinEqualsMax(ActionEvent event) {
    	if(txtMaxDint.isEditable()) {
    		if(!txtMinDint.isEditable())
    			txtMinDint.setEditable(true);
    		txtMinDint.setText(txtMaxDint.getText());
    	}
    }

    @FXML
    void hMaxEqualsMin(ActionEvent event) {
    	if(txtMinH.isEditable()) {
    		if(!txtMaxH.isEditable())
    			txtMaxH.setEditable(true);
    		txtMaxH.setText(txtMinH.getText());
    	}
    }

    @FXML
    void hMinEqualsMax(ActionEvent event) {
    	if(txtMaxH.isEditable()) {
    		if(!txtMinH.isEditable())
    			txtMinH.setEditable(true);
    		txtMinH.setText(txtMaxH.getText());
    	}
    }

    @FXML
    void reset(ActionEvent event) {
    	checkS1.setSelected(false);
    	checkS2.setSelected(false);
    	checkAltro.setSelected(false);
    	boxMaterial.setValue(null);
    	txtMinDint.clear();
    	txtMinDint.setEditable(true);
    	txtMaxDint.clear();
    	txtMaxDint.setEditable(true);
    	txtMinDest.clear();
    	txtMinDest.setEditable(true);
    	txtMaxDest.clear();
    	txtMaxDest.setEditable(true);
    	txtMinH.clear();
    	txtMinH.setEditable(true);
    	txtMaxH.clear();
    	txtMaxH.setEditable(true);
    	txtMinSp.clear();
    	txtMinSp.setEditable(true);
    	txtMaxSp.clear();
    	txtMaxSp.setEditable(true);
    	txtResult.clear();
    	result.clear();
    }

    @FXML
    void search(ActionEvent event) {
    	String strMinDint = null;
    	String strMaxDint = null;
    	Double minDint = null;
    	Double maxDint = null;
    	if(txtMinDint.isEditable()) {
    		strMinDint = txtMinDint.getText().trim();
			if(!strMinDint.equals("")) {
	    		if(strMinDint.contains(",")) {
	        		strMinDint = strMinDint.replace(',', '.');
	    		}
	    		try {
	    			minDint = Double.parseDouble(strMinDint);
	    			if(minDint<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			lastInputMinDint = txtMinDint.getText().trim();
					txtMinDint.setEditable(false);
					txtMinDint.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	if(txtMaxDint.isEditable()) {
    		strMaxDint = txtMaxDint.getText().trim();
    		if(!strMaxDint.equals("")) {
	    		if(strMaxDint.contains(","))
	        		strMaxDint = strMaxDint.replace(",", ".");
	    		try {
	    			maxDint = Double.parseDouble(strMaxDint);
	    			if(maxDint<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			lastInputMaxDint = txtMaxDint.getText().trim();
					txtMaxDint.setEditable(false);
					txtMaxDint.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
    		}
    	}
    	String strMinDest = null;
    	String strMaxDest = null;
    	Double minDest = null;
    	Double maxDest = null;
    	if(txtMinDest.isEditable()) {
    		strMinDest = txtMinDest.getText().trim();
			if(!strMinDest.equals("")) {
	    		if(strMinDest.contains(",")) {
	        		strMinDest = strMinDest.replace(',', '.');
	    		}
	    		try {
	    			minDest = Double.parseDouble(strMinDest);
	    			if(minDest<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			lastInputMinDest = txtMinDest.getText().trim();
					txtMinDest.setEditable(false);
					txtMinDest.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	if(txtMaxDest.isEditable()) {
    		strMaxDest = txtMaxDest.getText().trim();
    		if(!strMaxDest.equals("")) {
	    		if(strMaxDest.contains(","))
	        		strMaxDest = strMaxDest.replace(",", ".");
	    		try {
	    			maxDest = Double.parseDouble(strMaxDest);
	    			if(maxDest<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			lastInputMaxDest = txtMaxDest.getText().trim();
					txtMaxDest.setEditable(false);
					txtMaxDest.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
    		}
    	}
    	String strMinH = null;
    	String strMaxH = null;
    	Double minH = null;
    	Double maxH = null;
    	if(txtMinH.isEditable()) {
    		strMinH = txtMinH.getText().trim();
			if(!strMinH.equals("")) {
	    		if(strMinH.contains(",")) {
	        		strMinH = strMinH.replace(',', '.');
	    		}
	    		try {
	    			minH = Double.parseDouble(strMinH);
	    			if(minH<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			lastInputMinH = txtMinH.getText().trim();
					txtMinH.setEditable(false);
					txtMinH.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	if(txtMaxH.isEditable()) {
    		strMaxH = txtMaxH.getText().trim();
    		if(!strMaxH.equals("")) {
	    		if(strMaxH.contains(","))
	        		strMaxH = strMaxH.replace(",", ".");
	    		try {
	    			maxH = Double.parseDouble(strMaxH);
	    			if(maxH<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			lastInputMaxH = txtMaxH.getText().trim();
					txtMaxH.setEditable(false);
					txtMaxH.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
    		}
    	}
    	String strMinSp = null;
    	String strMaxSp = null;
    	Double minSp = null;
    	Double maxSp = null;
    	if(txtMinSp.isEditable()) {
    		strMinSp = txtMinSp.getText().trim();
			if(!strMinSp.equals("")) {
	    		if(strMinSp.contains(",")) {
	        		strMinSp = strMinSp.replace(',', '.');
	    		}
	    		try {
	    			minSp = Double.parseDouble(strMinSp);
	    			if(minSp<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			lastInputMinSp = txtMinSp.getText().trim();
					txtMinSp.setEditable(false);
					txtMinSp.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	if(txtMaxSp.isEditable()) {
    		strMaxSp = txtMaxSp.getText().trim();
    		if(!strMaxSp.equals("")) {
	    		if(strMaxSp.contains(","))
	        		strMaxSp = strMaxSp.replace(",", ".");
	    		try {
	    			maxSp = Double.parseDouble(strMaxSp);
	    			if(maxSp<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			lastInputMaxSp = txtMaxSp.getText().trim();
					txtMaxSp.setEditable(false);
					txtMaxSp.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
    		}
    	}
    	if(!txtMinDint.isEditable() || !txtMaxDint.isEditable() || !txtMinDest.isEditable() || !txtMaxDest.isEditable() || 
    			!txtMinH.isEditable() || !txtMaxH.isEditable() || !txtMinSp.isEditable() || !txtMaxSp.isEditable())
    		return;
    	txtResult.clear();
    	result.clear();
    	if(checkS1.isSelected())
    		result.addAll(model.getS1());
    	if(checkS2.isSelected())
    		result.addAll(model.getS2());
    	if(checkAltro.isSelected())
    		result.addAll(model.getOthers());
    	for(Item i : model.getResearch(result, boxMaterial.getValue(), minDint, maxDint, minDest, maxDest, minH, maxH, minSp, maxSp))
    		txtResult.appendText(i.toString() + "\n");
    }
    
    @FXML
    void setMaxDestEditable(MouseEvent event) {
    	if(!txtMaxDest.isEditable()) {
	    	txtMaxDest.setText(lastInputMaxDest);
	    	txtMaxDest.setEditable(true);
    	}
    }

    @FXML
    void setMaxDintEditable(MouseEvent event) {
    	if(!txtMaxDint.isEditable()) {
	    	txtMaxDint.setText(lastInputMaxDint);
	    	txtMaxDint.setEditable(true);
    	}
    }

    @FXML
    void setMaxHEditable(MouseEvent event) {
    	if(!txtMaxH.isEditable()) {
	    	txtMaxH.setText(lastInputMaxH);
	    	txtMaxH.setEditable(true);
    	}
    }

    @FXML
    void setMaxSpEditable(MouseEvent event) {
    	if(!txtMaxSp.isEditable()) {
	    	txtMaxSp.setText(lastInputMaxSp);
	    	txtMaxSp.setEditable(true);
    	}
    }
    
    @FXML
    void setMinDestEditable(MouseEvent event) {
    	if(!txtMinDest.isEditable()) {
	    	txtMinDest.setText(lastInputMinDest);
	    	txtMinDest.setEditable(true);
    	}
    }

    @FXML
    void setMinDintEditable(MouseEvent event) {
    	if(!txtMinDint.isEditable()) {
	    	txtMinDint.setText(lastInputMinDint);
	    	txtMinDint.setEditable(true);
    	}
    }

    @FXML
    void setMinHEditable(MouseEvent event) {
    	if(!txtMinH.isEditable()) {
	    	txtMinH.setText(lastInputMinH);
	    	txtMinH.setEditable(true);
    	}
    }
    
    @FXML
    void setMinSpEditable(MouseEvent event) {
    	if(!txtMinSp.isEditable()) {
	    	txtMinSp.setText(lastInputMinSp);
	    	txtMinSp.setEditable(true);
    	}
    }
    
    @FXML
    void spMaxEqualsMin(ActionEvent event) {
    	if(txtMinSp.isEditable()) {
    		if(!txtMaxSp.isEditable())
    			txtMaxSp.setEditable(true);
    		txtMaxSp.setText(txtMinSp.getText());
    	}
    }

    @FXML
    void spMinEqualsMax(ActionEvent event) {
    	if(txtMaxSp.isEditable()) {
    		if(!txtMinSp.isEditable())
    			txtMinSp.setEditable(true);
    		txtMinSp.setText(txtMaxSp.getText());
    	}
    }
    
    
    //FUNZIONI SEZIONE AGGIORNA
    
    @FXML
    void aggiorna(ActionEvent event) {
    	Item item = aggBoxItem.getValue();
    	if(item == null) {
    		aggTxtResult.setText("Selezionare Item da aggiornare");
    		return;
    	}
    	String oldMaterial = item.getMateriale();
    	String codice = aggTxtCodice.getText().trim().toUpperCase();
    	String materiale = null;
    	if(aggBoxMateriale.getValue()!=null)
    		materiale = aggBoxMateriale.getValue();
    	else if(aggTxtNewMateriale.getText().trim()!=null && !aggTxtNewMateriale.getText().trim().equals(""))
    		materiale = aggTxtNewMateriale.getText().trim().toUpperCase();
    	String strDint = aggTxtDint.getText().trim();
    	if(strDint.contains(","))
    		strDint = strDint.replace(",", ".");
    	String strDest = aggTxtDest.getText().trim();
    	if(strDest.contains(","))
    		strDest = strDest.replace(",", ".");
    	String strH = aggTxtH.getText().trim();
    	if(strH.contains(","))
    		strH = strH.replace(",", ".");
    	String strSp = aggTxtSp.getText().trim();
    	if(strSp.contains(","))
    		strSp = strSp.replace(",", ".");
    	Double dint = null;
    	Double dest = null;
    	Double h = null;
    	Double sp = null;
    	try {
    		if(!strDint.equals("") && strDint!=null)
    			dint = Double.parseDouble(strDint);
    		if(!strDest.equals("") && strDest!=null)
    			dest = Double.parseDouble(strDest);
    		if(!strH.equals("") && strH!=null)
    			h = Double.parseDouble(strH);
    		if(!strSp.equals("") && strSp!=null)
    			sp = Double.parseDouble(strSp);
    	} catch (NumberFormatException e) {
    		aggTxtResult.setText("Impossibile aggionare dati Item\nControllare di aver inserito i dati correttamente");
    		//e.printStackTrace();
    		return;
    	}
    	if(aggRadioS1.isSelected())
    		model.aggiorna(item, codice, Categoria.S1, materiale, dint, dest, h, sp);
    	else if(aggRadioS2.isSelected())
        	model.aggiorna(item, codice, Categoria.S2, materiale, dint, dest, h, sp);
    	else if(aggRadioAltro.isSelected())
    		model.aggiorna(item, codice, Categoria.N, materiale, dint, dest, h, sp);
    	else
    		model.aggiorna(item, codice, null, materiale, dint, dest, h, sp);
    	aggTxtResult.setText("Dati Item aggiornati correttamente: [" + item.toString() + "]");
    	aggTxtRicerca.clear();
    	aggBoxItem.getItems().clear();
    	aggBoxItem.getItems().addAll(model.getS1());
    	aggBoxItem.getItems().addAll(model.getS2());
    	aggBoxItem.getItems().addAll(model.getOthers());
    	aggBoxItem.setValue(item);
    	if(materiale!=null && !boxMaterial.getItems().contains(materiale)) {
    		boxMaterial.getItems().add(materiale);
    		aggBoxMateriale.getItems().add(materiale);
    	}
    	for(Item i : aggBoxItem.getItems())
    		if(i.getMateriale().equals(oldMaterial))
    			return;
    	boxMaterial.getItems().remove(oldMaterial);
    	aggBoxMateriale.getItems().remove(oldMaterial);
    	
    }
    
    @FXML
    void aggReset(ActionEvent event) {
    	aggTxtRicerca.clear();
    	aggBoxItem.setValue(null);
    	aggTxtCodice.clear();
    	aggRadioS1.setSelected(false);
    	aggRadioS2.setSelected(false);
    	aggRadioAltro.setSelected(false);
    	aggBoxMateriale.setValue(null);
    	aggTxtNewMateriale.clear();
    	aggTxtDint.clear();
    	aggTxtDest.clear();
    	aggTxtH.clear();
    	aggTxtSp.clear();
    	aggTxtResult.clear();
    }
    
    @FXML
    void completa(ActionEvent event) {
    	Item i = aggBoxItem.getValue();
    	if(i!=null) {
	    	aggTxtCodice.setText(i.getCodice());
	    	if(i.getCategoria()==Categoria.S1)
	    		aggRadioS1.setSelected(true);
	    	else if(i.getCategoria()==Categoria.S2)
	    		aggRadioS2.setSelected(true);
	    	else 
	    		aggRadioAltro.setSelected(true);
	    	aggBoxMateriale.setValue(i.getMateriale());
	    	aggTxtDint.setText(i.getDint().toString());
	    	aggTxtDest.setText(i.getDest().toString());
	    	aggTxtH.setText(i.getH().toString());
	    	aggTxtSp.setText(i.getSp().toString());
    	}
    }
    
    @FXML
    void elimina(ActionEvent event) {
    	Item item = aggBoxItem.getValue();
    	if(item==null)
    		aggTxtResult.setText("Selezionare Item da eliminare");
    	else {
    		aggTxtResult.setText("[" + model.elimina(item).toString() + "]\nItem eliminato correttamente");
    		aggTxtRicerca.clear();
    		aggBoxItem.getItems().clear();
        	aggBoxItem.getItems().addAll(model.getS1());
        	aggBoxItem.getItems().addAll(model.getS2());
        	aggBoxItem.getItems().addAll(model.getOthers());
	    	for(Item i : aggBoxItem.getItems())
	    		if(i.getMateriale().equals(item.getMateriale()))
	    			return;
	    	boxMaterial.getItems().remove(item.getMateriale());
	    	aggBoxMateriale.getItems().remove(item.getMateriale());
	    	boxMaterial.setValue(null);
	    	aggBoxMateriale.setValue(null);
	    	}
    }

    @FXML
    void inserisci(ActionEvent event) {
    	String codice = aggTxtCodice.getText().trim().toUpperCase();
    	for(Item i : model.getS1())
    		if(i.getCodice().equals(codice)) {
    			aggTxtResult.setText("Impossibile inserire nuovo Item\nCodice già esistente: [" + i.toString() + "]");
    			return;
    		}
    	for(Item i : model.getS2())
    		if(i.getCodice().equals(codice)) {
    			aggTxtResult.setText("Impossibile inserire nuovo Item\nCodice già esistente: [" + i.toString() + "]");
    			return;
    		}
    	for(Item i : model.getOthers())
    		if(i.getCodice().equals(codice)) {
    			aggTxtResult.setText("Impossibile inserire nuovo Item\nCodice già esistente: [" + i.toString() + "]");
    			return;
    		}
    	String materiale = null;
    	if(aggBoxMateriale.getValue()!=null)
    		materiale = aggBoxMateriale.getValue();
    	else if(aggTxtNewMateriale.getText().trim()!=null && !aggTxtNewMateriale.getText().trim().equals(""))
    		materiale = aggTxtNewMateriale.getText().trim().toUpperCase();
    	String strDint = aggTxtDint.getText().trim();
    	if(strDint.contains(","))
    		strDint = strDint.replace(",", ".");
    	String strDest = aggTxtDest.getText().trim();
    	if(strDest.contains(","))
    		strDest = strDest.replace(",", ".");
    	String strH = aggTxtH.getText().trim();
    	if(strH.contains(","))
    		strH = strH.replace(",", ".");
    	String strSp = aggTxtSp.getText().trim();
    	if(strSp.contains(","))
    		strSp = strSp.replace(",", ".");
    	Double dint = null;
    	Double dest = null;
    	Double h = null;
    	Double sp = null;
    	try {
    		if(codice.equals("") || (!aggRadioS1.isSelected() && !aggRadioS2.isSelected() && !aggRadioAltro.isSelected()) ||
    				materiale==null)
    			throw new NumberFormatException();
    		dint = Double.parseDouble(strDint);
    		dest = Double.parseDouble(strDest);
    		h = Double.parseDouble(strH);
    		sp = Double.parseDouble(strSp);
    	} catch (NumberFormatException e) {
    		aggTxtResult.setText("Impossibile inserire nuovo Item\nControllare di aver inserito tutti i dati correttamente");
    		//e.printStackTrace();
    		return;
    	}
    	Item i = null;
    	if(aggRadioS1.isSelected())
    		i = new Item(codice, Categoria.S1, materiale, dint, dest, h, sp);
    	else if(aggRadioS2.isSelected())
    		i = new Item(codice, Categoria.S2, materiale, dint, dest, h, sp);
    	else 
    		i = new Item(codice, Categoria.N, materiale, dint, dest, h, sp);
    	aggTxtResult.setText("Nuovo Item inserito correttamente: [" + model.inserisci(i).toString() + "]");
    	if(!boxMaterial.getItems().contains(materiale)) {
    		boxMaterial.getItems().add(materiale);
    		aggBoxMateriale.getItems().add(materiale);
    	}
    	aggBoxItem.getItems().clear();
    	aggBoxItem.getItems().addAll(model.getS1());
    	aggBoxItem.getItems().addAll(model.getS2());
    	aggBoxItem.getItems().addAll(model.getOthers());
    	aggBoxItem.setValue(i);
    }
    
    @FXML
    void ricercaBoxItem(KeyEvent event) {
    	String codice = aggTxtRicerca.getText().trim().toUpperCase();
    	List<Item> newItemList = new ArrayList<>();
    	for(Item i : model.getS1())
    		if(i.getCodice().contains(codice))
    			newItemList.add(i);
    	for(Item i : model.getS2())
    		if(i.getCodice().contains(codice))
    			newItemList.add(i);
    	for(Item i : model.getOthers())
    		if(i.getCodice().contains(codice))
    			newItemList.add(i);
    	aggBoxItem.getItems().clear();
    	aggBoxItem.getItems().addAll(newItemList);
    }
    
    @FXML
    void selectingOldMaterial(ActionEvent event) {
    	aggTxtNewMateriale.clear();
    }
    
    @FXML
    void writingNewMaterial(MouseEvent event) {
    	aggBoxMateriale.setValue(null);
    }
    
    //FUNZIONI SEZIONE VALUTA
    
    @FXML
    void valReset(ActionEvent event) {

    }

    @FXML
    void valuta(ActionEvent event) {

    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert btnSpMaxEqualsMin != null : "fx:id=\"btnSpMaxEqualsMin\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMinSp != null : "fx:id=\"txtMinSp\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMaxDint != null : "fx:id=\"txtMaxDint\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDintMinEqualsMax != null : "fx:id=\"btnDintMinEqualsMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMinDint != null : "fx:id=\"txtMinDint\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDintMaxEqualsMin != null : "fx:id=\"btnDintMaxEqualsMin\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpMinEqualsMax != null : "fx:id=\"btnSpMinEqualsMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMaxSp != null : "fx:id=\"txtMaxSp\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMinDest != null : "fx:id=\"txtMinDest\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDestMinEqualsMax != null : "fx:id=\"btnDestMinEqualsMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMinH != null : "fx:id=\"txtMinH\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMaxDest != null : "fx:id=\"txtMaxDest\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMaxH != null : "fx:id=\"txtMaxH\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnHMinEqualsMax != null : "fx:id=\"btnHMinEqualsMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDestMaxEqualsMin != null : "fx:id=\"btnDestMaxEqualsMin\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnHMaxEqualsMin != null : "fx:id=\"btnHMaxEqualsMin\" was not injected: check your FXML file 'Scene.fxml'.";
        assert boxMaterial != null : "fx:id=\"boxMaterial\" was not injected: check your FXML file 'Scene.fxml'.";
        assert checkS1 != null : "fx:id=\"checkS1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert checkS2 != null : "fx:id=\"checkS2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert checkAltro != null : "fx:id=\"checkAltro\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggTxtRicerca != null : "fx:id=\"aggTxtRicerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggBoxItem != null : "fx:id=\"aggBoxCodice\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggTxtCodice != null : "fx:id=\"aggTxtCodice\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggRadioS1 != null : "fx:id=\"aggRadioS1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggRadioS2 != null : "fx:id=\"aggRadioS2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggRadioAltro != null : "fx:id=\"aggRadioAltro\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggBoxMateriale != null : "fx:id=\"aggBoxMateriale\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggTxtNewMateriale != null : "fx:id=\"aggTxtNewMateriale\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggTxtDint != null : "fx:id=\"aggTxtDint\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggTxtDest != null : "fx:id=\"aggTxtDest\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggTxtH != null : "fx:id=\"aggTxtH\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggTxtSp != null : "fx:id=\"aggTxtSp\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggBtnInserisci != null : "fx:id=\"aggBtnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggBtnAgg != null : "fx:id=\"aggBtnAgg\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggBtnElimina != null : "fx:id=\"aggBtnElimina\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggBtnReset != null : "fx:id=\"aggBtnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert aggTxtResult != null : "fx:id=\"aggTxtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valTxtSp != null : "fx:id=\"valTxtSp\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valTxtDint != null : "fx:id=\"valTxtDint\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valTxtDest != null : "fx:id=\"valTxtDest\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valTxtH != null : "fx:id=\"valTxtH\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valBoxMateriale != null : "fx:id=\"valBoxMateriale\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valCheckS1 != null : "fx:id=\"valCheckS1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valCheckS2 != null : "fx:id=\"valCheckS2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valCheckAltro != null : "fx:id=\"valCheckAltro\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valTxtNPezzi != null : "fx:id=\"valTxtNPezzi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valTxtPrezzo != null : "fx:id=\"valTxtPrezzo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnValuta != null : "fx:id=\"btnValuta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valTxtResult != null : "fx:id=\"valTxtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valBtnReset != null : "fx:id=\"valBtnReset\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel (Model model) {
    	this.model = model;
    	result = new ArrayList<>();
    	boxMaterial.getItems().add(null);
    	boxMaterial.getItems().addAll(model.getMaterials());
    	lastInputMinDint = null;
    	lastInputMaxDint = null;
    	lastInputMinDest = null;
    	lastInputMaxDest = null;
    	lastInputMinH = null;
    	lastInputMaxH = null;
    	lastInputMinSp = null;
    	lastInputMaxSp = null;
    	aggBoxItem.getItems().addAll(model.getS1());
    	aggBoxItem.getItems().addAll(model.getS2());
    	aggBoxItem.getItems().addAll(model.getOthers());
    	aggBoxMateriale.getItems().add(null);
    	aggBoxMateriale.getItems().addAll(model.getMaterials());
    	group = new ToggleGroup();
    	aggRadioS1.setToggleGroup(group);
    	aggRadioS2.setToggleGroup(group);
    	aggRadioAltro.setToggleGroup(group);
    }
}

