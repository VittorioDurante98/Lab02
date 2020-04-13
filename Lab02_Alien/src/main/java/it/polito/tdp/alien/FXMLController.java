package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button buttonTranslate;

    @FXML
    private TextArea txtRisutato;

    @FXML
    private Button buttonClear;

    @FXML
    void doClear(ActionEvent event) {
    	model.clearMap();
    	txtRisutato.clear();
    }

    @FXML
    void doTraduzione(ActionEvent event) {
    	String s = txtParola.getText();
    	String divisa[] = s.split(" ");
		String pInserita;
		String pTradotta;
		
    	if(divisa.length<2) {
    		try {
    			model.traduci(divisa[0]);
    		}catch(IllegalStateException ise) {
    			txtRisutato.appendText(ise.getMessage());
    		}
    		txtRisutato.appendText(model.traduci(divisa[0])+"\n");
    	}
    	else {
    		try {
    			model.addTraduzione(divisa[0], divisa[1]);
    		}catch(IllegalStateException ise) {
    			txtRisutato.appendText(ise.getMessage());
    		}
    	}
    	txtParola.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonTranslate != null : "fx:id=\"buttonTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisutato != null : "fx:id=\"txtRisutato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonClear != null : "fx:id=\"buttonClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model){
    	this.model = new Model();
    }
}
