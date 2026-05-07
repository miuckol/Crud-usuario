package aluno;

import java.util.List; 

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class GerenciarAluno {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public GerenciarAluno() {
		emf = Persistence.createEntityManagerFactory("xuxu");
		em = emf.createEntityManager();
	}
	
	public void cadastrar (Aluno aluno) {
		
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}
	
	public void editar (Aluno aluno) {
		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	public List<Aluno> listar() 
	{
		String hql = "from Aluno";
		Query queryHQL = 
				em.createQuery(hql);
		return queryHQL.getResultList();
		
	}
	
	public Aluno buscarPorId (int id) {
		return em.find(Aluno.class, id);
	}
	
	public void remover(int id)
	{
		Aluno aluno = buscarPorId(id);
		
		em.getTransaction().begin();
		em.remove(aluno);
		em.getTransaction().commit();
	}
}
