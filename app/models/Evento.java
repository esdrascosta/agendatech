package models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.URL;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;

@Entity
public class Evento {

	@Id
	@GeneratedValue
	private Integer id;
	@Email
	private String emailParaContato;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	@Column(columnDefinition = "text")
	@Required
	private String descricao;
	@URL
	private String site;
	private String twitter;
	@Required
	private String nome;
	private Calendar dataDeInicio;
	private Calendar dataDeFim;

	/* getters and sertters */
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
}
