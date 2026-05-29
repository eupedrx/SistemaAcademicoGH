package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {

	// ATRIBUTOS

	private int id_turma;
	private String turno;
	private String situacao;
	private int vagas;
	private String sala;

	// ATRIBUTOS DE RELACIONAMENTO

	private List<Matricula> listaMatriculas;
	private List<Prova> listaProvas;

	private Disciplina disciplina;
	private Professor professor;

	// MÉTODOS

	public Turma(int id, String turno, String situacao, int vagas, String sala) {
		this.id_turma = id;
		this.turno = turno;
		this.situacao = situacao;
		this.vagas = vagas;
		this.sala = sala;
		this.listaMatriculas = new ArrayList<>();
		this.listaProvas = new ArrayList<>();
	}

	public int getId_turma() {
		return this.id_turma;
	}

	public void setId_turma(int id_turma) {
		this.id_turma = id_turma;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public int getVagas() {
		return this.vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getSala() {
		return this.sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	// GERENCIA MATRICULAS

	public List<Matricula> getListaMatriculas() {
		return new ArrayList<Matricula>(this.listaMatriculas);
	}

	public void setListaMatriculas(List<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}

	public void adicionarMatricula(Matricula matricula) {
		this.listaMatriculas.add(matricula);
		if (matricula.getTurma() != this) {
			matricula.setTurma(this);
		}
	}

	public void removerMatricula(Matricula matricula) {
		if (this.listaMatriculas.contains(matricula)) {
			this.listaMatriculas.remove(matricula);
			if (matricula.getTurma() == this) {
				matricula.setTurma(null);
			}
		}
	}

	// GERENCIA PROVAS

	public List<Prova> getListaProvas() {
		return new ArrayList<Prova>(this.listaProvas);
	}

	public void setListaProvas(List<Prova> listaProvas) {
		this.listaProvas = listaProvas;
	}

	public void adicionarProva(Prova prova) {
		this.listaProvas.add(prova);
		if (prova.getTurma() != this) {
			prova.setTurma(this);
		}
	}

	public void removerProva(Prova prova) {
		if (this.listaProvas.contains(prova)) {
			this.listaProvas.remove(prova);
			if (prova.getTurma() == this) {
				prova.setTurma(null);
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
		return "Turma{id=" + id_turma + ", turno=" + turno + ", situacao=" + situacao + ", vagas=" + vagas + ", sala="
				+ sala + "}";
	}

}
