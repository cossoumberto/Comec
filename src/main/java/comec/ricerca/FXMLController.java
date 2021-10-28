/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package comec.ricerca;

import java.net.URL;


import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import comec.ricerca.model.Confronto;
import comec.ricerca.model.Item;
import comec.ricerca.model.Item.Categoria;
import comec.ricerca.model.Model;
import comec.ricerca.model.VariazionePeso;
import comec.ricerca.model.Vendita;
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
	private List<Confronto> confronti;
	private Double costo;
	
	private String lastInputMinDint;
	private String lastInputMaxDint;
	private String lastInputMinDest;
	private String lastInputMaxDest;
	private String lastInputMinH;
	private String lastInputMaxH;
	private String lastInputMinSp;
	private String lastInputMaxSp;
	
	private String valLastInputDint;
	private String valLastInputDest;
	private String valLastInputH;
	private String valLastInputSp;
	private String valLastInputNumV;
	private String valLastInputNumItem;
	private String valLastInputNumReq;
	private String valLastInputPrezzo;
	private String valLastInputCosto;
	
	private ToggleGroup aggGroup;
	private ToggleGroup valGroup;
	
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

    @FXML // fx:id="valRadioS1"
    private RadioButton valRadioS1; // Value injected by FXMLLoader

    @FXML // fx:id="valRadioS2"
    private RadioButton valRadioS2; // Value injected by FXMLLoader

    @FXML // fx:id="valRadioAltro"
    private RadioButton valRadioAltro; // Value injected by FXMLLoader
    
    @FXML // fx:id="valTxtNumVar"
    private TextField valTxtNumVar; // Value injected by FXMLLoader
    
    @FXML // fx:id="valTxtNumItem"
    private TextField valTxtNumItem; // Value injected by FXMLLoader

    @FXML // fx:id="valBtnConfronta"
    private Button valBtnConfronta; // Value injected by FXMLLoader    
    
    @FXML // fx:id="valBtnAggiorna"
    private Button valBtnAggiorna; // Value injected by FXMLLoader

    @FXML // fx:id="valBtnCalcola"
    private Button valBtnCalcola; // Value injected by FXMLLoader
    
    @FXML // fx:id="valTxtNumReq"
    private TextField valTxtNumReq; // Value injected by FXMLLoader

    @FXML // fx:id="valTxtPrezzo"
    private TextField valTxtPrezzo; // Value injected by FXMLLoader
    
    @FXML // fx:id="valTxtCosto"
    private TextField valTxtCosto; // Value injected by FXMLLoader

    @FXML // fx:id="valBtnUtilizza"
    private Button valBtnUtilizza; // Value injected by FXMLLoader

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
    void setMaxDestEditableMouse(MouseEvent event) {
    	if(!txtMaxDest.isEditable()) {
	    	txtMaxDest.setText(lastInputMaxDest);
	    	txtMaxDest.setEditable(true);
    	}
    }
    
    @FXML
    void setMaxDestEditableAction(ActionEvent event) {
    	if(!txtMaxDest.isEditable()) {
	    	txtMaxDest.setText(lastInputMaxDest);
	    	txtMaxDest.setEditable(true);
    	}
    }

    @FXML
    void setMaxDintEditableMouse(MouseEvent event) {
    	if(!txtMaxDint.isEditable()) {
	    	txtMaxDint.setText(lastInputMaxDint);
	    	txtMaxDint.setEditable(true);
    	}
    }
    
    @FXML
    void setMaxDintEditableAction(ActionEvent event) {
    	if(!txtMaxDint.isEditable()) {
	    	txtMaxDint.setText(lastInputMaxDint);
	    	txtMaxDint.setEditable(true);
    	}
    }

    @FXML
    void setMaxHEditableMouse(MouseEvent event) {
    	if(!txtMaxH.isEditable()) {
	    	txtMaxH.setText(lastInputMaxH);
	    	txtMaxH.setEditable(true);
    	}
    }
    
    @FXML
    void setMaxHEditableAction(ActionEvent event) {
    	if(!txtMaxH.isEditable()) {
	    	txtMaxH.setText(lastInputMaxH);
	    	txtMaxH.setEditable(true);
    	}
    }

    @FXML
    void setMaxSpEditableMouse(MouseEvent event) {
    	if(!txtMaxSp.isEditable()) {
	    	txtMaxSp.setText(lastInputMaxSp);
	    	txtMaxSp.setEditable(true);
    	}
    }
    
    @FXML
    void setMaxSpEditableAction(ActionEvent event) {
    	if(!txtMaxSp.isEditable()) {
	    	txtMaxSp.setText(lastInputMaxSp);
	    	txtMaxSp.setEditable(true);
    	}
    }
    
    @FXML
    void setMinDestEditableMouse(MouseEvent event) {
    	if(!txtMinDest.isEditable()) {
	    	txtMinDest.setText(lastInputMinDest);
	    	txtMinDest.setEditable(true);
    	}
    }
    
    @FXML
    void setMinDestEditableAction(ActionEvent event) {
    	if(!txtMinDest.isEditable()) {
	    	txtMinDest.setText(lastInputMinDest);
	    	txtMinDest.setEditable(true);
    	}
    }

    @FXML
    void setMinDintEditableMouse(MouseEvent event) {
    	if(!txtMinDint.isEditable()) {
	    	txtMinDint.setText(lastInputMinDint);
	    	txtMinDint.setEditable(true);
    	}
    }
    
    @FXML
    void setMinDintEditableAction(ActionEvent event) {
    	if(!txtMinDint.isEditable()) {
	    	txtMinDint.setText(lastInputMinDint);
	    	txtMinDint.setEditable(true);
    	}
    }

    @FXML
    void setMinHEditableMouse(MouseEvent event) {
    	if(!txtMinH.isEditable()) {
	    	txtMinH.setText(lastInputMinH);
	    	txtMinH.setEditable(true);
    	}
    }
    
    @FXML
    void setMinHEditableAction(ActionEvent event) {
    	if(!txtMinH.isEditable()) {
	    	txtMinH.setText(lastInputMinH);
	    	txtMinH.setEditable(true);
    	}
    }
    
    @FXML
    void setMinSpEditableMouse(MouseEvent event) {
    	if(!txtMinSp.isEditable()) {
	    	txtMinSp.setText(lastInputMinSp);
	    	txtMinSp.setEditable(true);
    	}
    }
    
    @FXML
    void setMinSpEditableAction(ActionEvent event) {
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
    		if(dint>=dest || sp>h)
    			throw new NumberFormatException();
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
    				materiale==null )
    			throw new NumberFormatException();
    		dint = Double.parseDouble(strDint);
    		dest = Double.parseDouble(strDest);
    		h = Double.parseDouble(strH);
    		sp = Double.parseDouble(strSp);
    		if(dint>=dest || sp>h)
    			throw new NumberFormatException();
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
    void valSetDintEditableMouse(MouseEvent event) {
    	if(!valTxtDint.isEditable() && valTxtDint.getText().equals("Inserimento non valido")) {
	    	valTxtDint.setText(valLastInputDint);
	    	valTxtDint.setEditable(true);
    	}
    }
    
    @FXML
    void valSetDintEditableAction(ActionEvent event) {
    	if(!valTxtDint.isEditable() && valTxtDint.getText().equals("Inserimento non valido")) {
	    	valTxtDint.setText(valLastInputDint);
	    	valTxtDint.setEditable(true);
    	}
    }

    @FXML
    void valSetDestEditableMouse(MouseEvent event) {
    	if(!valTxtDest.isEditable() && valTxtDest.getText().equals("Inserimento non valido")) {
	    	valTxtDest.setText(valLastInputDest);
	    	valTxtDest.setEditable(true);
    	}
    }
    
    @FXML
    void valSetDestEditableAction(ActionEvent event) {
    	if(!valTxtDest.isEditable() && valTxtDest.getText().equals("Inserimento non valido")) {
	    	valTxtDest.setText(valLastInputDest);
	    	valTxtDest.setEditable(true);
    	}
    }

    @FXML
    void valSetHEditableMouse(MouseEvent event) {
    	if(!valTxtH.isEditable() && valTxtH.getText().equals("Inserimento non valido")) {
	    	valTxtH.setText(valLastInputH);
	    	valTxtH.setEditable(true);
    	}
    }
    
    @FXML
    void valSetHEditableAction(ActionEvent event) {
    	if(!valTxtH.isEditable() && valTxtH.getText().equals("Inserimento non valido")) {
	    	valTxtH.setText(valLastInputH);
	    	valTxtH.setEditable(true);
    	}
    }
    
    @FXML
    void valSetSpEditableMouse(MouseEvent event) {
    	if(!valTxtSp.isEditable() && valTxtSp.getText().equals("Inserimento non valido")) {
	    	valTxtSp.setText(valLastInputSp);
	    	valTxtSp.setEditable(true);
    	}
    }

    @FXML
    void valSetSpEditableAction(ActionEvent event) {
    	if(!valTxtSp.isEditable() && valTxtSp.getText().equals("Inserimento non valido")) {
	    	valTxtSp.setText(valLastInputSp);
	    	valTxtSp.setEditable(true);
    	}
    }
    
    @FXML
    void valSetNumItemEditableMouse(MouseEvent event) {
    	if(!valTxtNumItem.isEditable()) {
	    	valTxtNumItem.setText(valLastInputNumItem);
	    	valTxtNumItem.setEditable(true);
    	}
    }
    
    
    @FXML
    void valSetNumItemEditableAction(ActionEvent event) {
    	if(!valTxtNumItem.isEditable()) {
	    	valTxtNumItem.setText(valLastInputNumItem);
	    	valTxtNumItem.setEditable(true);
    	}
    }
    

    @FXML
    void valSetNumVEditableMouse(MouseEvent event) {
    	if(!valTxtNumVar.isEditable()) {
	    	valTxtNumVar.setText(valLastInputNumV);
	    	valTxtNumVar.setEditable(true);
    	}
    }
    
    @FXML
    void valSetNumVEditableAction(ActionEvent event) {
    	if(!valTxtNumVar.isEditable()) {
	    	valTxtNumVar.setText(valLastInputNumV);
	    	valTxtNumVar.setEditable(true);
    	}
    }
    
    @FXML
    void valSetNumReqEditableMouse(MouseEvent event) {
    	if(!valTxtNumReq.isEditable()) {
	    	valTxtNumReq.setText(valLastInputNumReq);
	    	valTxtNumReq.setEditable(true);
    	}
    }
    
    @FXML
    void valSetNumReqEditableAction(ActionEvent event) {
    	if(!valTxtNumReq.isEditable()) {
	    	valTxtNumReq.setText(valLastInputNumReq);
	    	valTxtNumReq.setEditable(true);
    	}
    }
    
    @FXML
    void valSetPrezzoEditableMouse(MouseEvent event) {
    	if(!valTxtPrezzo.isEditable()) {
	    	valTxtPrezzo.setText(valLastInputPrezzo);
	    	valTxtPrezzo.setEditable(true);
    	}
    }
    
    @FXML
    void valSetPrezzoEditableAction(ActionEvent event) {
    	if(!valTxtPrezzo.isEditable()) {
	    	valTxtPrezzo.setText(valLastInputPrezzo);
	    	valTxtPrezzo.setEditable(true);
    	}
    }
    
    @FXML
    void valSetCostoEditableMouse(MouseEvent event) {
    	if(!valTxtCosto.isEditable()) {
	    	valTxtCosto.setText(valLastInputCosto);
	    	valTxtCosto.setEditable(true);
    	}
    }
    
    @FXML
    void valSetCostoEditableAction(ActionEvent event) {
    	if(!valTxtCosto.isEditable()) {
	    	valTxtCosto.setText(valLastInputCosto);
	    	valTxtCosto.setEditable(true);
    	}
    }
    
    @FXML
    void valConfronta(ActionEvent event) {
    	String strDint = null;
    	Double dint = null;
    	if(!valTxtDint.getText().equals("Inserimento non valido")) {
    		strDint = valTxtDint.getText().trim();
			if(!strDint.equals("")) {
	    		if(strDint.contains(",")) {
	        		strDint = strDint.replace(',', '.');
	    		}
	    		try {
	    			dint = Double.parseDouble(strDint);
	    			if(dint<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			valLastInputDint = valTxtDint.getText().trim();
					valTxtDint.setEditable(false);
					valTxtDint.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	String strDest = null;
    	Double dest = null;
    	if(!valTxtDest.getText().equals("Inserimento non valido")) {
    		strDest = valTxtDest.getText().trim();
			if(!strDest.equals("")) {
	    		if(strDest.contains(",")) {
	        		strDest = strDest.replace(',', '.');
	    		}
	    		try {
	    			dest = Double.parseDouble(strDest);
	    			if(dest<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			valLastInputDest = valTxtDest.getText().trim();
					valTxtDest.setEditable(false);
					valTxtDest.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	String strH = null;
    	Double h = null;
    	if(!valTxtH.getText().equals("Inserimento non valido")) {
    		strH = valTxtH.getText().trim();
			if(!strH.equals("")) {
	    		if(strH.contains(",")) {
	        		strH = strH.replace(',', '.');
	    		}
	    		try {
	    			h = Double.parseDouble(strH);
	    			if(h<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			valLastInputH = valTxtH.getText().trim();
					valTxtH.setEditable(false);
					valTxtH.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	String strSp = null;
    	Double sp = null;
    	if(!valTxtSp.getText().equals("Inserimento non valido")) {
    		strSp = valTxtSp.getText().trim();
			if(!strSp.equals("")) {
	    		if(strSp.contains(",")) {
	        		strSp = strSp.replace(',', '.');
	    		}
	    		try {
	    			sp = Double.parseDouble(strSp);
	    			if(sp<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			valLastInputSp = valTxtSp.getText().trim();
					valTxtSp.setEditable(false);
					valTxtSp.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	String strNumV = null;
    	Integer numV = null;
    	if(valTxtNumVar.isEditable()) {
    		strNumV = valTxtNumVar.getText().trim();
			if(!strNumV.equals("") && strNumV!=null) {
	    		try {
	    			numV = Integer.parseInt(strNumV);
	    			if(numV<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			valLastInputNumV = valTxtNumVar.getText().trim();
					valTxtNumVar.setEditable(false);
					valTxtNumVar.setText("Ins. non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	if(!valTxtDint.isEditable() && valTxtDint.getText().equals("Inserimento non valido") || 
    			!valTxtDest.isEditable() && valTxtDest.getText().equals("Inserimento non valido") || 
    			!valTxtH.isEditable() && valTxtH.getText().equals("Inserimento non valido")|| 
    			!valTxtSp.isEditable() && valTxtSp.getText().equals("Inserimento non valido")|| 
    			!valTxtNumVar.isEditable())
    		return;
    	if( (valRadioS1.isSelected()==false && valRadioS2.isSelected()==false && valRadioAltro.isSelected()==false) ||
    			dint==null || dest==null || h==null || sp==null || dint>=dest || sp>h) {
    		valTxtResult.setText("Impossibile eseguire ricerca\nControllare di aver inserito tutti i dati correttamente");
    		return;
    	}
    	if(numV==null)
    		numV = 0;
    	Categoria categoria = null;
    	if(valRadioS1.isSelected() == true)
    		categoria = Categoria.S1;
    	if(valRadioS2.isSelected() == true)
    		categoria = Categoria.S2;
    	if(valRadioAltro.isSelected() == true)
    		categoria = Categoria.N;
    	Item newItem = new Item(null, categoria, null, dint, dest, h, sp);
    	this.confronti = model.confronta(newItem);
    	if(numV>confronti.size()-1)
    		numV = confronti.size()-1;
    	if(numV<0)
    		valTxtResult.setText("Per la categoria selezionata non sono presenti item");
    	else {
    		String txtUguale = null;
    		for(Confronto c : confronti)
    			if(c.getPeso()==0) {
    				if(txtUguale==null)
    					txtUguale = "Le caratteristiche dell'item proposto corrispondono con le caratteristiche dei seguenti item:\n";
    				txtUguale += c.getItem();
    				if(model.getCostoItem(c.getItem())!=null)
    					txtUguale += " [Costo singolo: " + model.getCostoItem(c.getItem()) + " €/pezzo]\n";
    				else txtUguale+= " [Costo non disponibile]\n";
    			} else break;
    		if(txtUguale!=null)
    			valTxtResult.setText(txtUguale + "\n");
    		else valTxtResult.clear();
    		if(confronti.size()==1)
    			valTxtResult.appendText("Per la categoria selezionata è presente un solo Item\n\n");
    		if(numV>0) {
    			if(numV==1)
					valTxtResult.appendText("La maggiore variazione di peso è: ");
				else
					valTxtResult.appendText("Le " + numV + " maggiori variazioni di peso sono:");
    			for(VariazionePeso v : model.getVariazioniPeso(confronti)) {
    				valTxtResult.appendText("\n" + model.setDecimali(v.getValore(),5) + " tra la riga " + v.getIndice() 
    					+ " [Item: " + confronti.get(v.getIndice()-1).getItem().getCodice() +  
    					"] e la riga " + (v.getIndice()+1) + " [Item: " + confronti.get(v.getIndice()).getItem().getCodice() + "]");
    				if(model.getVariazioniPeso(confronti).indexOf(v)+1>=numV) {
    					valTxtResult.appendText("\n\n");
    					break;
    				}
    			}
    		}
			valTxtResult.appendText("Lista degli Item appartenenti alla categoria selezionata,\n"
					+ "ordinati dal più simile al meno simile, a seconda del peso P");
			for(Confronto c : confronti) {
				valTxtResult.appendText("\n" + (confronti.indexOf(c)+1) + ") P = " + model.setDecimali(c.getPeso(), 5) + " " + c.getItem());
				if(model.getCostoItem(c.getItem())!=null)
					valTxtResult.appendText(" [Costo singolo: " + model.getCostoItem(c.getItem())+ " €/pezzo]");
				else valTxtResult.appendText(" [Costo non disponibile]");
			}
			if(valRadioS1.isSelected()) {
				valRadioS2.setDisable(true);
				valRadioAltro.setDisable(true);
			}
			if(valRadioS2.isSelected()) {
				valRadioS1.setDisable(true);
				valRadioAltro.setDisable(true);
			}
			if(valRadioAltro.isSelected()) {
				valRadioS2.setDisable(true);
				valRadioS1.setDisable(true);
			}
			valTxtDint.setEditable(false);
			valTxtDest.setEditable(false);
			valTxtH.setEditable(false);
			valTxtSp.setEditable(false);
			valBtnAggiorna.setDisable(false);
	 		valBtnCalcola.setDisable(true);
	 	   	valBtnUtilizza.setDisable(true);
    	}
    }
    
    @FXML
    void valAggiorna(ActionEvent event) {
    	String strNumV = null;
    	Integer numV = null;
    	if(valTxtNumVar.isEditable()) {
    		strNumV = valTxtNumVar.getText().trim();
			if(!strNumV.equals("") && strNumV!=null) {
	    		try {
	    			numV = Integer.parseInt(strNumV);
	    			if(numV<0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			valLastInputNumV = valTxtNumVar.getText().trim();
					valTxtNumVar.setEditable(false);
					valTxtNumVar.setText("Ins. non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	if(!valTxtNumVar.isEditable())
    		return;
    	if(numV==null)
    		numV = 0;
		List<Confronto> confrontiCosti = new ArrayList<>();
		for(Confronto c : confronti)
			if(model.getCostoItem(c.getItem())!=null)
					confrontiCosti.add(c);
		if(confrontiCosti.size()==0) {
			valTxtResult.setText("Per la ricerca effettuata non sono disponibili item con costi noti");
			valRadioS1.setDisable(false);
	    	valRadioS2.setDisable(false);
	    	valRadioAltro.setDisable(false);
	    	valTxtDint.setEditable(true);
	    	valTxtDest.setEditable(true);
	    	valTxtH.setEditable(true);
	    	valTxtSp.setEditable(true);
	    	valBtnAggiorna.setDisable(true);
		} else {
			confronti.clear();
			confronti = confrontiCosti;
			valTxtResult.clear();
			if(numV>0) {
				if(confronti.size()==1)
	    			valTxtResult.appendText("Per la categoria selezionata è presente un solo Item\n\n");
				else {
					if(numV>confronti.size())
						numV = confronti.size();
					if(numV==1)
						valTxtResult.appendText("La maggiore variazione di peso è: ");
					else
						valTxtResult.appendText("Le " + numV + " maggiori variazioni di peso sono:");
	    			for(VariazionePeso v : model.getVariazioniPeso(confrontiCosti)) {
	    				valTxtResult.appendText("\n" + model.setDecimali(v.getValore(),5) + " tra la riga " + v.getIndice() 
	    					+ " [Item: " + confrontiCosti.get(v.getIndice()-1).getItem().getCodice() +  
	    					"] e la riga " + (v.getIndice()+1) + " [Item: " + confrontiCosti.get(v.getIndice()).getItem().getCodice() + "]");
	    				if(model.getVariazioniPeso(confrontiCosti).indexOf(v)+1>=numV) {
	    					valTxtResult.appendText("\n\n");
	    					break;
	    				}
	    			}
				}
    		}
			valTxtResult.appendText("Lista degli Item appartenenti alla categoria selezionata,\n"
					+ "ordinati dal più simile al meno simile, a seconda del peso P, i cui costi risultano noti:");
    		for(Confronto c : confrontiCosti) 
    			valTxtResult.appendText("\n" + (confrontiCosti.indexOf(c)+1) + ") P = " + model.setDecimali(c.getPeso(), 5) + " " + c.getItem() +  
    					" [Costo singolo: " + model.getCostoItem(c.getItem())+ " €/pezzo] [Costo corretto: "
    					+ model.setDecimali((model.getCostoItem(c.getItem()))*c.getCoeff(), 3) + " €/pezzo]");
    		valBtnCalcola.setDisable(false);
		}
	   	valBtnUtilizza.setDisable(true);
    }

    @FXML
    void valCalcola(ActionEvent event) {
     	String strNumI = null;
    	Integer numI = null;
    	if(valTxtNumItem.isEditable()) {
    		strNumI = valTxtNumItem.getText().trim();
			if(!strNumI.equals("") && strNumI!=null) {
	    		try {
	    			numI = Integer.parseInt(strNumI);
	    			if(numI<=0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			valLastInputNumItem = valTxtNumItem.getText().trim();
					valTxtNumItem.setEditable(false);
					valTxtNumItem.setText("Ins. non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	if(!valTxtNumItem.isEditable())
    		return;
    	if(numI==null) {
    		valTxtResult.setText("Inserire numero di item da considerare per il calcolo");
    		return;
    	} else if (confronti.size()==1) {
    		valTxtResult.setText("Per l'item proposto, il costo calcolato considerando l'unico item disponibile con costo noto");
    		numI = 1;
    	} else if(numI==1)
			valTxtResult.setText("Per l'item proposto, il costo calcolato considerando l'item più simile con costo noto");
		else if(numI>=confronti.size()) {
			numI = confronti.size();
			valTxtResult.setText("Per l'item proposto, il costo calcolato considerando tutti i " +
					numI + " item più simili, con costi noti,");
		} else 
			valTxtResult.setText("Per l'item proposto, il costo calcolato considerando i " +
					numI + " item più simili, con costi noti,");
    	costo = model.setDecimali(model.calcolaNewCosto(confronti, numI), 3);
		valTxtResult.appendText(" risulta essere di " + costo + " €/pezzo" 
				+ "\n\nSeleziona \"Utilizza Costo calcolato\" per valutare un'offerta considerando il costo appena calcolato" 
				+ "\nSeleziona \"Reset\" per effettuare una nuova ricerca");
		valBtnUtilizza.setDisable(false);
    }
    
    @FXML
    void valUtilizza(ActionEvent event) {
    	valTxtCosto.setText(costo.toString());
    }

    @FXML
    void valuta(ActionEvent event) {
    	String strNumReq = null;
    	Integer numReq = null;
    	if(valTxtNumReq.isEditable()) {
    		strNumReq = valTxtNumReq.getText().trim();
			if(!strNumReq.equals("") && strNumReq!=null) {
	    		try {
	    			numReq = Integer.parseInt(strNumReq);
	    			if(numReq<=0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			valLastInputNumReq = valTxtNumReq.getText().trim();
					valTxtNumReq.setEditable(false);
					valTxtNumReq.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	String strPrezzo = null;
    	Double prezzo = null;
    	if(valTxtPrezzo.isEditable()) {
    		strPrezzo = valTxtPrezzo.getText().trim();
			if(!strPrezzo.equals("") && strPrezzo!=null) {
	    		try {
	    			prezzo = Double.parseDouble(strPrezzo);
	    			if(prezzo<=0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			valLastInputPrezzo = valTxtPrezzo.getText().trim();
					valTxtPrezzo.setEditable(false);
					valTxtPrezzo.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	String strCosto = null;
    	Double costo = null;
    	if(valTxtCosto.isEditable()) {
    		strCosto = valTxtCosto.getText().trim();
			if(!strCosto.equals("") && strCosto!=null) {
	    		try {
	    			costo = Double.parseDouble(strCosto);
	    			if(costo<=0)
	    				throw new NumberFormatException();
	    		} catch (NumberFormatException e) {
	    			valLastInputCosto = valTxtCosto.getText().trim();
					valTxtCosto.setEditable(false);
					valTxtCosto.setText("Inserimento non valido");
					//e.printStackTrace();
	    		}
			}
    	}
    	if(!valTxtNumReq.isEditable() || !valTxtPrezzo.isEditable() || !valTxtCosto.isEditable())
    		return;
    	Vendita v = new Vendita(null, numReq, prezzo, costo);
    	Double percM = model.confrontaMargine(v);
    	if(percM!=null) {
    		valTxtResult.setText("Il prezzo di vendita applicato risulta essere " + v.getPrezzo_singolo() + " €/pezzo con un margine di "
    						+ model.setDecimali((v.getPrezzo_singolo()-v.getCosto_primo()), 2) + " €/pezzo\n"
    						+ "Il margine calcolato per l'offerta proposta è pari a " + v.getMargine() + " € ed è maggiore del "
    						+ model.setDecimali(percM,2) + " % delle vendite note (" + model.numVenditeNote() + ")\n"
    						+ "Il margine rappresenta il " 
    						+ model.setDecimali(100*(v.getMargine()/v.getImporto()), 2) + " % dell'importo"
    						+ " (in media questa percentuale è pari al " 
    						+ model.setDecimali((model.totMargini()/model.totImporti())*100, 2) + " %)");
    	} else valTxtResult.setText("Non sono disponibili vendite note");
    	
    }
    
    @FXML
    void valReset(ActionEvent event) {
    	confronti = null;
    	valRadioS1.setDisable(false);
    	valRadioS2.setDisable(false);
    	valRadioAltro.setDisable(false);
    	valRadioS1.setSelected(false);
    	valRadioS2.setSelected(false);
    	valRadioAltro.setSelected(false);
    	valTxtDint.clear();
    	valTxtDint.setEditable(true);
    	valTxtDest.clear();
    	valTxtDest.setEditable(true);
    	valTxtH.clear();
    	valTxtH.setEditable(true);
    	valTxtSp.clear();
    	valTxtSp.setEditable(true);
    	valTxtNumVar.clear();
    	valTxtNumVar.setEditable(true);
    	valTxtNumItem.clear();
    	valTxtNumItem.setEditable(true);
    	valBtnAggiorna.setDisable(true);
    	valBtnCalcola.setDisable(true);
    	valTxtNumReq.clear();
    	valTxtNumReq.setEditable(true);
    	valTxtPrezzo.clear();
    	valTxtPrezzo.setEditable(true);
    	valTxtCosto.clear();
    	valTxtCosto.setEditable(true);
    	valBtnUtilizza.setDisable(true);
    	valTxtResult.clear();
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
        assert valRadioS1 != null : "fx:id=\"valRadioS1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valRadioS2 != null : "fx:id=\"valRadioS2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valRadioAltro != null : "fx:id=\"valRadioAltro\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valTxtNumVar != null : "fx:id=\"valTxtNumVar\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valTxtNumItem != null : "fx:id=\"valTxtNumItem\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valBtnCalcola != null : "fx:id=\"valBtnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valBtnAggiorna != null : "fx:id=\"valBtnAggiorna\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valTxtNumReq != null : "fx:id=\"valTxtNumReq\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valTxtPrezzo != null : "fx:id=\"valTxtPrezzo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnValuta != null : "fx:id=\"btnValuta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valBtnConfronta != null : "fx:id=\"valBtnConfronta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valTxtResult != null : "fx:id=\"valTxtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert valBtnReset != null : "fx:id=\"valBtnReset\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel (Model model) {
    	this.model = model;
    	result = new ArrayList<>();
    	confronti = null;
    	costo = null;
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
    	aggGroup = new ToggleGroup();
    	aggRadioS1.setToggleGroup(aggGroup);
    	aggRadioS2.setToggleGroup(aggGroup);
    	aggRadioAltro.setToggleGroup(aggGroup);
    	valLastInputDint = null;
    	valLastInputDest = null;
    	valLastInputH = null;
    	valLastInputSp = null;
    	valLastInputNumV = null;
    	valLastInputNumItem = null;
    	valLastInputNumReq = null;
    	valLastInputPrezzo = null;
    	valLastInputCosto = null;
    	valGroup = new ToggleGroup();
    	valRadioS1.setToggleGroup(valGroup);
    	valRadioS2.setToggleGroup(valGroup);
    	valRadioAltro.setToggleGroup(valGroup);
    	valBtnAggiorna.setDisable(true);
    	valBtnCalcola.setDisable(true);
    	valBtnUtilizza.setDisable(true);
    }
}

