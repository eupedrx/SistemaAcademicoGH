package model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

	// ATRIBUTOS

	private int id_disciplina;
	private String nome;
	private int credito; // ?
	private String situacao;

	// ATRIBUTOS DE RELACIONAMENTO

	private List<Turma> listaTurmas;

	// MÉTODOS

	public Disciplina(int id, String nome, int credito) {
		this.id_disciplina = id;
		this.nome = nome;
		this.credito = credito;
		this.listaTurmas = new ArrayList<>();
	}

	public int getId_disciplina() {
		return this.id_disciplina;
	}

	public void setId_disciplina(int id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCredito() {
		return this.credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}

	// GERENCIA TURMAS

	public List<Turma> getListaTurmas() {
		return new ArrayList<Turma>(this.listaTurmas);
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}

	public void adicionarTurma(Turma t) {
		this.listaTurmas.add(t);
		if (t.getDisciplina() != this) {
			t.setDisciplina(this);
		}
	}

	public void removerTurma(Turma t) {
		if (this.listaTurmas.contains(t)) {
			this.listaTurmas.remove(t);
			if (t.getDisciplina() == this) {
				t.setDisciplina(null);
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
	
	// -----

	@Override
	public String toString() {
		return "Disciplina{id=" + id_disciplina + ", nome=" + nome + ", credito=" + credito + "}";
	}

}
