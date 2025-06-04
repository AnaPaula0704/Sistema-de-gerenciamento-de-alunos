 # Sistema de Gerenciamento de Alunos
 
## Visão Geral
Este projeto implementa um sistema de gerenciamento de alunos desenvolvido em Java, utilizando conceitos de Programação Orientada a Objetos (POO) e Collections. O sistema permite o cadastro de alunos, cálculo de médias, controle de frequência, aprovação/reprovação, atualização de notas, gerenciamento de disciplinas e busca por matrícula, oferecendo uma solução completa para a gestão acadêmica.

## Funcionalidades
- Cadastro de Alunos: Permite adicionar alunos com informações como nome, idade, matrícula, notas e disciplinas.
- Cálculo de Médias: Calcula a média das notas dos alunos para determinar sua situação acadêmica.
- Atualização de Notas: Permite atualizar as notas de um aluno, seja da Nota 1 ou Nota 2.
- Controle de Frequência: Monitora a frequência dos alunos; frequência abaixo de 75% resulta em reprovação.
- Gerenciamento de Disciplinas: Associa alunos às disciplinas em que estão matriculados.
- Busca por Matrícula: Facilita a busca de alunos através de sua matrícula.
- Listagem de Alunos: Exibe todos os alunos cadastrados no sistema.
- Exclusão de Alunos: Permite remover alunos do sistema.

## Tecnologias Utilizadas
- Linguagem: Java 
- Paradigma: Programação Orientada a Objetos (POO)
- Estruturas de Dados: Collections (ArrayList, HashMap)
- Entrada/Saída: Scanner para entrada de dados via console
- Controle de Fluxo: Estruturas de repetição e decisão para navegação no menu

## Estrutura do Projeto
- Classe Alunos: Representa um aluno, contendo atributos como nome, idade, matrícula, notas, disciplinas e frequência.
- Classe Disciplinas: Define as disciplinas oferecidas, com nome e código.
- Classe Alunos_teste: Classe principal que implementa o menu interativo e gerencia as operações do sistema.
