package br.com.rogrs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="PLAYER")
public class Player extends AbstractPersistable<Long>{


	private static final long serialVersionUID = 1L;
	
	private String rep_file_num;
	private String CIK;
	private String entity_name;
	private String street1;
	private String street2;
	private String city;
	private String state_code;
	private String zip;
	private String filing_date;
	private String doc_type_code;
	
	public Player(){}
	
	public Player(String string, String string2, String string3, String string4, String string5, String string6,
			String string7, String string8, String string9) {
		
		
	}
	
	
	public String getRep_file_num() {
		return rep_file_num;
	}
	public void setRep_file_num(String rep_file_num) {
		this.rep_file_num = rep_file_num;
	}
	public String getCIK() {
		return CIK;
	}
	public void setCIK(String cIK) {
		CIK = cIK;
	}
	public String getEntity_name() {
		return entity_name;
	}
	public void setEntity_name(String entity_name) {
		this.entity_name = entity_name;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_code() {
		return state_code;
	}
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getFiling_date() {
		return filing_date;
	}
	public void setFiling_date(String filing_date) {
		this.filing_date = filing_date;
	}
	public String getDoc_type_code() {
		return doc_type_code;
	}
	public void setDoc_type_code(String doc_type_code) {
		this.doc_type_code = doc_type_code;
	}
    

}
