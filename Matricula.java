package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Matricula {

	// ATRIBUTOS

	private int id_matricula;
	private LocalDate data;
	private String situacao;

	// ATRIBUTOS DE RELACIONAMENTO

	private Aluno aluno;
	private Turma turma;

	private List<RealizaProva> listaRealizacoes;

	// MÉTODOS

	public Matricula(int id, LocalDate data, Aluno aluno, Turma turma) {
		this.id_matricula = id;
		this.data = data;
		this.aluno = aluno;
		this.turma = turma;
		this.listaRealizacoes = new ArrayList<>();
	}

	public int getId_matricula() {
		return this.id_matricula;
	}

	public void setId_matricula(int id_matricula) {
		this.id_matricula = id_matricula;
	}

	public LocalDate getData() {
		return this.data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<RealizaProva> getListaRealizacoes() {
		return new ArrayList<RealizaProva>(this.listaRealizacoes);
	}

	public void setListaRealizacoes(List<RealizaProva> listaRealizacoes) {
		this.listaRealizacoes = listaRealizacoes;
	}

	public void adicionarRealizacao(RealizaProva r) {
		this.listaRealizacoes.add(r);
		if (r.getMatricula() != this) {
			r.setMatricula(this);
		}
	}

	public void removerRealizacao(RealizaProva r) {
		if (this.listaRealizacoes.contains(r)) {
			this.listaRealizacoes.remove(r);
			if (r.getMatricula() == this) {
				r.setMatricula(null);
			}
		}
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
	public void confirmar() {
		if(this.situacao.equals("Válido")) {
			this.situacao = "Ativo";
		}
	}
	
	// -----
	
	@Override
	public String toString() {
		return "Matricula{id=" + id_matricula + ", data=" + data + ", aluno="
				+ (aluno != null ? aluno.getNome() : "null") + ", turma="
				+ (turma != null ? turma.getId_turma() : "null") + "}";
	}

}
