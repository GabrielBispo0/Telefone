package br.com.teste.Telefone.model;


import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import br.com.teste.Telefone.repository.precosRepository;






@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Precos precos;

	private Long origem;
	private Long destino;
	private Long tempo;
	private boolean plano;
	private Long valorPlano;
	private Long minExcedente;
	private BigDecimal comPromocao;
	private BigDecimal semPromocao;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Precos getPrecos() {
		return precos;
	}


	public void setPrecos(Precos precos) {
		this.precos = precos;
	}


	public Long getOrigem() {
		return origem;
	}


	public void setOrigem(Long origem) {
		this.origem = origem;
	}


	public Long getDestino() {
		return destino;
	}


	public void setDestino(Long destino) {
		this.destino = destino;
	}


	public Long getTempo() {
		return tempo;
	}


	public void setTempo(Long tempo) {
		this.tempo = tempo;
	}


	public boolean isPlano() {
		return plano;
	}


	public void setPlano(boolean plano) {
		this.plano = plano;
	}


	public Long getValorPlano() {
		return valorPlano;
	}


	public Long setValorPlano(Long valorPlano) {
		return this.valorPlano = valorPlano;
	}


	public Long getMinExcedente() {
		return minExcedente;
	}


	public void setMinExcedente(Long minExcedente) {
		this.minExcedente = minExcedente;
	}


	public BigDecimal getComPromocao() {
		return comPromocao;
	}


	public void setComPromocao(BigDecimal comPromocao) {
		this.comPromocao = comPromocao;
	}


	public BigDecimal getSemPromocao() {
		return semPromocao;
	}


	public void setSemPromocao(BigDecimal semPromocao) {
		this.semPromocao = semPromocao;
	}


	
	public void calcularPromocao(Produto produto, precosRepository precosRepo) {
		Precos retorno = precosRepo.findByOrigemAndDestino(origem, destino);
		if(retorno != null) {
			if(produto.getTempo() <= this.getValorPlano()) {
				this.setComPromocao(new BigDecimal("0.00"));
				this.setSemPromocao(retorno.getPreco().multiply(new BigDecimal(produto.getTempo())).setScale(2));
			} else {
				BigDecimal diferenca = new BigDecimal(produto.getTempo()).subtract(new BigDecimal(produto.getValorPlano()));
				BigDecimal diferencaComPorcentagem = diferenca.multiply(new BigDecimal("0.1")).add(diferenca);
				BigDecimal promocaoResultado = diferencaComPorcentagem.multiply(retorno.getPreco());
				this.setComPromocao(promocaoResultado);
				this.setSemPromocao(retorno.getPreco().multiply(new BigDecimal(produto.getTempo())).setScale(2));
			}
			if(this.getValorPlano() > 0) {
				this.setPlano(true);
			}
		}
	}
	
		
	
	

	@Override
	public String toString() {
		return "Produto [id=" + id + ", precos=" + precos + ", origem=" + origem + ", destino=" + destino + ", tempo="
				+ tempo + ", plano=" + plano + ", valorPlano=" + valorPlano + ", minExcedente=" + minExcedente
				+ ", comPromocao=" + comPromocao + ", semPromocao=" + semPromocao + "]";
	}
	
	
	
	
	

}
