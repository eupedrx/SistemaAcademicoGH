package model;

public class RealizaProva {

	// ATRIBUTOS

	private int id_realizacao;
	private float nota;

	// ATRIBUTOS DE RELACIONAMENTO

	private Matricula matricula;
	private Prova prova;

	// MÉTODOS

	public RealizaProva(int id, float nota, Matricula m, Prova p) {
		this.id_realizacao = id;
		this.nota = nota;
		this.matricula = m;
		this.prova = p;
	}

	public int getId_realizacao() {
		return this.id_realizacao;
	}

	public void setId_realizacao(int id_realizacao) {
		this.id_realizacao = id_realizacao;
	}

	public float getNota() {
		return this.nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public Matricula getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Prova getProva() {
		return this.prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	@Override
	public String toString() {
		return "RealizaProva{id=" + id_realizacao + ", nota=" + nota + ", matricula="
				+ (matricula != null ? matricula.getId_matricula() : "null") + ", prova="
				+ (prova != null ? prova.getId_prova() : "null") + "}";
	}

}
