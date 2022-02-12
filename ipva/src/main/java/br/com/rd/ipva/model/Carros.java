package br.com.rd.ipva.model;

public class Carros {
	
	Integer id;
	String model;
	String ano;
	
	
	public Carros(String model, String ano) {
		super();
		this.model = model;
		this.ano = ano;
	}


	public Carros(Integer id, String model, String ano) {
		super();
		this.id = id;
		this.model = model;
		this.ano = ano;
	}


	public int getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	@Override
	public String toString() {
		return "Carros [id=" + id + ", model=" + model + ", ano=" + ano + "]";
	}
	
	
	

}//end Carros
