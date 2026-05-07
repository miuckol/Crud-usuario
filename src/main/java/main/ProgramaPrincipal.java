package main;

import java.util.Collection;

import aluno.Aluno;
import aluno.GerenciarAluno;
import console.Console;

public class ProgramaPrincipal {

	private static final int CADASTRAR = 1;
	private static final int EDITAR = 2;
	private static final int LISTAR = 3;
	private static final int REMOVER = 4;
	private static final int SAIR = 5;
	private Console console;
	private GerenciarAluno gerAluno;
	
	public ProgramaPrincipal() {
		console = new Console();
		gerAluno = new GerenciarAluno();
	}
	
	public static void main(String[] args) {
		ProgramaPrincipal pp = new ProgramaPrincipal();
		pp.executar();
	}
	
	public void executar () {
		int opcao = 0;
		
		do {
			mostrarMenu();
			
			opcao = console.readInt("Escolha uma opção:");
			
			if (opcao == CADASTRAR) {
				cadastrar();
			}
			
			else if (opcao == EDITAR) {
				editarAluno();
			}
			
			else if (opcao == LISTAR) {
				listar();
			}
			
			else if (opcao == REMOVER) {
				remover();
			}
			
		} while (opcao != SAIR);
		
	}
		private void cadastrar() {
			
			Aluno aluno = new Aluno();
			
			String nome = console.readLine("Digite seu nome:");
			String login = console.readLine("Digite seu login:");
	
			aluno.setNome(nome);
			aluno.setLogin(login);
			
			gerAluno.cadastrar(aluno);
	}
		
		private void editarAluno () {
			
			listar();
			
			
			int idParaEditar = console.readInt("Digite o id para editar:");
			
			Aluno aluno = gerAluno.buscarPorId(idParaEditar);
			
			String novoNome = console.readLine("Digite seu novo nome: ");
			String novaMatricula = console.readLine("Digite sua nova matricula:");
			String novoLogin = console.readLine("Digite seu nome login:");
			
			aluno.setNome(novoNome);
			aluno.setMatricula(novaMatricula);
			aluno.setLogin(novoLogin);
		}
		
		private void listar() {
			Collection<Aluno> alunos = gerAluno.listar();
			for (Aluno aluno : alunos) {
				System.out.println("ID:" + aluno.getId());
				System.out.println("NOME: " + aluno.getNome());
				System.out.println("LOGIN: " + aluno.getLogin());
			}
		}
		
		private void remover() {
			
			listar();
			
			int idParaRemover = console.readInt("Digite o id para remover: ");	
			
			gerAluno.buscarPorId(idParaRemover);
			
			System.out.println("Aluno Removido com Sucesso!");
			
			}
		
		private void mostrarMenu () {
			System.out.println("----SUPER PROGRAMA DE CADASTRO----");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Editar");
			System.out.println("3 - Listar");
			System.out.println("4 - Remover");
			System.out.println("9 - Sair");
		}
}
