package controller;

import java.time.LocalDate;

import model.Aluno;
import model.Disciplina;
import model.Matricula;
import model.Prova;
import model.Professor;
import model.RealizaProva;
import model.Turma;

public class CtrlPrograma {

	public static void main(String[] args) {

		// DISCIPLINA
		Disciplina d1 = new Disciplina(1, "Engenharia de Software", 4);

		// PROFESSOR
		Professor p1 = new Professor(1, "111.222.333-44", "George Hamilton", 45, "Niterói, RJ", "99999-0000");

		// TURMA
		Turma t1 = new Turma(1, "Noturno", "Ativa", 40, "Sala 12");
		d1.adicionarTurma(t1);
		p1.adicionarTurma(t1);

		// ALUNO
		Aluno a1 = new Aluno(1, "555.444.333-22", "Michel Soares", 20, "Niterói, RJ", "98888-7777");

		// MATRÍCULA
		Matricula m1 = new Matricula(1, LocalDate.now(), a1, t1);
		a1.adicionarMatricula(m1);
		t1.adicionarMatricula(m1);

		// PROVAS
		Prova pr1 = new Prova(1, LocalDate.of(2025, 5, 10), 2, t1);
		Prova pr2 = new Prova(2, LocalDate.of(2025, 6, 20), 3, t1);
		t1.adicionarProva(pr1);
		t1.adicionarProva(pr2);

		// REALIZAÇÕES
		RealizaProva r1 = new RealizaProva(1, 8.5f, m1, pr1);
		RealizaProva r2 = new RealizaProva(2, 7.0f, m1, pr2);

		m1.adicionarRealizacao(r1);
		m1.adicionarRealizacao(r2);
		pr1.adicionarRealizacao(r1);
		pr2.adicionarRealizacao(r2);

		// SAÍDA
		System.out.println("Aluno: " + a1.getNome());
		System.out.println("Turma: " + t1.getSala() + " - " + t1.getTurno());
		System.out.println("Disciplina: " + d1.getNome());
		System.out.println("Professor: " + p1.getNome());

		System.out.println("Provas realizadas:");
		for (RealizaProva r : m1.getListaRealizacoes()) {
			System.out.println("Prova ID " + r.getProva().getId_prova() + " - Nota: " + r.getNota());
		}

		// SAÍDA COM O MÉTODO TO STRING

		System.out.println("\nSaída usando toString\n");
		System.out.println(a1.toString());
		System.out.println(p1.toString());
		System.out.println(d1.toString());
		System.out.println(t1.toString());
		System.out.println(m1.toString());
		System.out.println(pr1.toString());
		System.out.println(pr2.toString());
		System.out.println(r1.toString());
		System.out.println(r2.toString());

	}
}
