package br.com.rd.ipva.model;

public class Ipva {
	
	Integer id;
	String ano;
	
	public Ipva(String ano) {
		super();
		this.ano = ano;
	}

	public Ipva(Integer id, String ano) {
		super();
		this.id = id;
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Ipva [id=" + id + ", ano=" + ano + "]";
	}
	
	
	

}
