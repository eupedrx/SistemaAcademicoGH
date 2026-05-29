# 📚 Sistema de Gerenciamento Acadêmico em Java

[![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)](https://github.com/SEU_USUARIO/SEU_REPOSITORIO)
[![Linguagem](https://img.shields.io/badge/Linguagem-Java%2017%2B-blue)](https://www.java.com/)

## 📜 Sobre o Projeto

Este projeto consiste na implementação de um **Sistema de Gerenciamento Acadêmico** desenvolvido em Java. Ele modela o relacionamento complexo entre alunos, turmas, disciplinas e avaliações, utilizando conceitos avançados de **Orientação a Objetos (POO)** e **Integridade Referencial**.

O sistema foi arquitetado seguindo o modelo conceitual de classes, com foco em **encapsulamento**, inicialização segura de objetos e gerenciamento de relacionamentos *muitos-para-muitos* através de classes associativas (`Matricula` e `RealizaProva`).

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia | Descrição |
| :--- | :--- |
| **Linguagem** | Java |
| **IDE** | Eclipse (Estrutura de pacotes `model` e `controller`) |
| **Data/Hora** | `java.time.LocalDate` para gerenciamento de datas. |
| **Coleções** | `java.util.List` e `ArrayList` para gerenciar coleções e relacionamentos. |

---

## 🏗️ Arquitetura e Estrutura de Classes

O projeto é dividido em dois pacotes principais, seguindo uma arquitetura de separação de responsabilidades (Modelo de Domínio e Controle de Aplicação).

### 📦 `model`

Contém todas as classes de entidade do sistema.

| Classe | Tipo de Classe | Responsabilidade |
| :--- | :--- | :--- |
| `Aluno` | Entidade | Representa o estudante. |
| `Professor` | Entidade | Representa o docente. |
| `Disciplina` | Entidade | Representa a matéria (Ex: Eng. de Software). |
| `Turma` | Entidade | Agrupa alunos em uma disciplina específica. |
| `Matricula` | **Classe Associativa** | Liga um `Aluno` a uma `Turma`. |
| `Prova` | Entidade | Representa uma avaliação agendada. |
| `RealizaProva` | **Classe Associativa** | Liga uma `Matricula` a uma `Prova` e armazena a **nota**. |

### 📦 `controller`

| Classe | Descrição |
| :--- | :--- |
| `CtrlPrograma` | Classe principal (`main`) que instancia, associa e manipula todos os objetos do sistema para simular o fluxo acadêmico (cadastro, matrícula, lançamento de notas e relatórios). |

---

## 🛡️ Consistência Bidirecional

Todas as classes com relacionamento de lista (`List<T>`) implementam métodos `adicionarX()` e `removerX()`. Esses métodos garantem que o relacionamento seja mantido em ambos os sentidos (por exemplo, se o `Aluno` adiciona uma `Matricula`, a `Matricula` automaticamente aponta de volta para aquele `Aluno`), prevenindo referências quebradas e garantindo a integridade dos dados.

---

## 🏃 Como Rodar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/UNI-MichelSoares/ONG-Traballho-Web3
    ```
2.  **Importe na IDE:**
    * Importe a pasta clonada como um projeto Java existente.
3.  **Execute a Aplicação:**
    * Execute a classe **`controller.CtrlPrograma.java`** como uma **Java Application**. O console exibirá o fluxo de simulação completo.

---

## 🚀 Próximos Passos e Melhorias Futuras

Embora este projeto atenda aos requisitos de modelagem orientada a objetos do escopo acadêmico, o desenvolvimento para um sistema de produção exige as seguintes extensões:

### 1. Camada de Persistência (Banco de Dados)
* **Implementação com JPA/Hibernate:** Adicionar uma camada de persistência para salvar os dados em um banco de dados relacional (ex: PostgreSQL ou MySQL), substituindo o armazenamento em memória atual.

### 2. Tratamento de Erros e Validações
* **Métodos de Validação:** Implementar validações nos *setters* e construtores para garantir a integridade dos dados.
* **Tratamento de Exceções:** Implementar tratamento de exceções específico.

### 3. Interface de Usuário
* **Pacote `view` / `ui`:** Criar uma camada de interface (ex: *swing*, terminal avançado ou uma API REST) para interagir com o sistema de forma mais amigável, separando a lógica de apresentação da lógica de domínio.

### 4. Aperfeiçoamento do Domínio
* **Lógica de Negócios:** Implementar métodos complexos, como cálculo de média ponderada por peso das provas e lógica de aprovação/reprovação.

---
