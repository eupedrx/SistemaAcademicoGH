package model;

import java.util.ArrayList;
import java.util.List;

public class Professor {

	// ATRIBUTOS

	private int id_professor;
	private String cpf;
	private String nome;
	private int idade;
	private String endereco;
	private String telefone;
	private String situacao;

	// ATRIBUTOS DE RELACIONAMENTO

	private List<Turma> listaTurmas;

	// MÉTODOS

	public Professor(int id, String cpf, String nome, int idade, String endereco, String telefone) {
		this.id_professor = id;
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.telefone = telefone;
		this.listaTurmas = new ArrayList<>();
	}

	public int getId_professor() {
		return this.id_professor;
	}

	public void setId_professor(int id_professor) {
		this.id_professor = id_professor;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		if (t.getProfessor() != this) {
			t.setProfessor(this);
		}
	}

	public void removerTurma(Turma t) {
		if (this.listaTurmas.contains(t)) {
			this.listaTurmas.remove(t);
			if (t.getProfessor() == this) {
				t.setProfessor(null);
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
		return "Professor{id=" + id_professor + ", cpf=" + cpf + ", nome=" + nome + ", idade=" + idade + ", endereco="
				+ endereco + ", telefone=" + telefone + "}";
	}

}
