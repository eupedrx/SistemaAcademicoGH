package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	// ATRIBUTOS

	private int id_aluno;
	private String cpf;
	private String nome;
	private int idade;
	private String endereco;
	private String telefone;
	private String situacao;

	// ATRIBUTOS DE RELACIONAMENTO

	private List<Matricula> listaMatriculas;

	// MÉTODOS

	public Aluno(int id, String cpf, String nome, int idade, String endereco, String telefone) {
		this.id_aluno = id;
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.telefone = telefone;
		this.listaMatriculas = new ArrayList<>();
	}

	public int getId_aluno() {
		return this.id_aluno;
	}

	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
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

	// GERENCIA MATRICULAS

	public List<Matricula> getListaMatriculas() {
		return new ArrayList<>(this.listaMatriculas);
	}

	public void setListaMatriculas(List<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}

	public void adicionarMatricula(Matricula matricula) {
		this.listaMatriculas.add(matricula);
		if (matricula.getAluno() != this) {
			matricula.setAluno(this);
		}
	}

	public void removerMatricula(Matricula matricula) {
		if (this.listaMatriculas.contains(matricula)) {
			this.listaMatriculas.remove(matricula);
			if (matricula.getAluno() == this) {
				matricula.setAluno(null);
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
		return "Aluno{id=" + id_aluno + ", cpf=" + cpf + ", nome=" + nome + ", idade=" + idade + ", endereco="
				+ endereco + ", telefone=" + telefone + "}";
	}

}
