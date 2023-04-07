import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO{
    private EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
   }

    public void cadastrar(Produto produto){
        this.entityManager.persist(produto);
    }
    public void atualizar(Produto produto){
        this.entityManager.merge(produto);
    }
    public void remover(Produto produto){
        produto = this.entityManager.merge(produto);
        this.entityManager.remove(produto);
    }
    public Produto buscarPorId(Long id){
        return this.entityManager.find(Produto.class, id);
    }
    public List<Produto> pegarProdutos(){
        String jpql = "SELECT p from Produto p";
        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }
    public List<Produto> pegarProdutosComParamento(String nome){
        String jpql = "SELECT p from Produto p where p.nome = :nome";
        return entityManager.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
    }
    public List<Produto> pegarProdutoPorCategoria(String nome){
        String jpql = "SELECT p from Produto p where p.categoria.nome = :nome";
        return entityManager.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
    }
    public String pegaApenasNome(String nome){
        return entityManager.createQuery("SELECT p.nome from Produto p where p.nome = :nome", String.class).setParameter("nome", nome).getSingleResult();
    }
}
