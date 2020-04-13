package it.polito.tdp.alien.model;

import java.util.*;
import java.security.InvalidParameterException;

public class Model {
	
	
	private Map<String, String> traduzioni;
	
	public Model() {
		//this.inserita = inserita;
		traduzioni = new TreeMap<String, String>();
	}
	
	public void addTraduzione(String pInserita,String pTradotta) {
		//if(traduzioni.containsKey(pInserita))
			//traduzioni.put(pInserita, pTradotta);
		
		pInserita = pInserita.toUpperCase();
		pTradotta = pTradotta.toUpperCase();
		if(this.isDigital(pInserita))
			throw new IllegalStateException("senza numeri\n");
		if(this.isDigital(pTradotta))
			throw new IllegalStateException("senza numeri\n");
		traduzioni.put(pInserita, pTradotta);
	}
	
	public String traduci(String s) {
		s = s.toUpperCase();
		if(this.isDigital(s))
			throw new IllegalStateException("senza numeri\n");
		if(this.traduzioni.containsKey(s)) {
			return traduzioni.get(s);
		}
		else
			return "";
	}

	public Map<String, String> getTraduzioni() {
		return traduzioni;
	}
  	
	public void clearMap() {
		traduzioni.clear();
	}

	public boolean isDigital(String s) {
		for(int i = 0 ; i<s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				return true;
			}
		}
		
		return false;
		
	}
	
	

}
