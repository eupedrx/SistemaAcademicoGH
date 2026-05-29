package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prova {

	// ATRIBUTOS

	private int id_prova;
	private LocalDate data;
	private int peso;
	private String situacao;

	// ATRIBUTOS DE RELACIONAMENTO

	private List<RealizaProva> listaRealizacoes;
	private Turma turma;

	// MÉTODOS

	public Prova(int id, LocalDate data, int peso, Turma t) {
		this.id_prova = id;
		this.data = data;
		this.peso = peso;
		this.turma = t;
		this.listaRealizacoes = new ArrayList<>();
	}

	public int getId_prova() {
		return this.id_prova;
	}

	public void setId_prova(int id_prova) {
		this.id_prova = id_prova;
	}

	public LocalDate getData() {
		return this.data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPeso() {
		return this.peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	// GERENCIA REALIZAÇÕES

	public List<RealizaProva> getListaRealizacoes() {
		return new ArrayList<RealizaProva>(this.listaRealizacoes);
	}

	public void setListaRealizacoes(List<RealizaProva> listaRealizacoes) {
		this.listaRealizacoes = listaRealizacoes;
	}

	public void adicionarRealizacao(RealizaProva r) {
		this.listaRealizacoes.add(r);
		if (r.getProva() != this) {
			r.setProva(this);
		}
	}

	public void removerRealizacao(RealizaProva r) {
		if (this.listaRealizacoes.contains(r)) {
			this.listaRealizacoes.remove(r);
			if (r.getProva() == this) {
				r.setProva(null);
			}
		}
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	// MÉTODOS RELACIONADOS AO DIAGRAMA DE ESTADO / SEQUENCIA
	
	public void cadastrar() {
		this.situacao = "Análise";
	}
	public void validar() {
		if(this.situacao.equals("Análise")) {
			this.situacao = "Válido";
		}
	}
	public void invalidar() {
		if(this.situacao.equals("Análise")) {
			this.situacao = "Inválido";
		}
	}
	public void aplicar() {
		if(this.situacao.equals("Válido")) {
			this.situacao = "Realizado";
		}
	}
	public void corrigir() {
		if(this.situacao.equals("Realizado")) {
			this.situacao = "Corrigido";
		}
	}
	public void revisar() {
		if(this.situacao.equals("Realizado")) {
			this.situacao = "Revisada";
		}
	}
	
	// -----
	
	@Override
	public String toString() {
		return "Prova{id=" + id_prova + ", data=" + data + ", peso=" + peso + ", turma="
				+ (turma != null ? turma.getId_turma() : "null") + "}";
	}

}
