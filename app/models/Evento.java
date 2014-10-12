package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;
import play.data.validation.ValidationError;
import play.db.ebean.Model;
import utils.FromNow;

@Entity
public class Evento extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@Required
	private String emailParaContato;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	@Column(columnDefinition = "text")
	@Required
	private String descricao;
	
	private String site;
	private String twitter;
	@Required
	private String nome;
	@FromNow
	private Calendar dataDeInicio;
	private Calendar dataDeFim;
	private String caminhoImagem;
	private boolean aprovado;
	
	
	public List<ValidationError> validate(){
		ArrayList<ValidationError> errors = new ArrayList<>();
		
		if(this.dataDeFim == null){
			this.dataDeFim = (Calendar) dataDeInicio.clone();
			return null;
		}
		
		if(!dataDeFim.after(dataDeInicio)){
			errors.add(
					new ValidationError("dataDeFim", "O fim deve ser após o inicio"));
		}
		
		return errors.isEmpty() ? null : errors;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmailParaContato() {
		return emailParaContato;
	}


	public void setEmailParaContato(String emailParaContato) {
		this.emailParaContato = emailParaContato;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getSite() {
		return site;
	}


	public void setSite(String site) {
		this.site = site;
	}


	public String getTwitter() {
		return twitter;
	}


	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Calendar getDataDeInicio() {
		return dataDeInicio;
	}


	public void setDataDeInicio(Calendar dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}


	public Calendar getDataDeFim() {
		return dataDeFim;
	}


	public void setDataDeFim(Calendar dataDeFim) {
		this.dataDeFim = dataDeFim;
	}


	public String getCaminhoImagem() {
		return caminhoImagem;
	}


	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}


	public boolean isAprovado() {
		return aprovado;
	}


	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}
}
