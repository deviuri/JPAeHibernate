import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class cadrastoDeProduto {
    public static void main(String[] args) {
        cadastrar();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO pDAO = new ProdutoDAO(em);

        Produto p = pDAO.buscarPorId(1l);
        System.out.println("ID: " + p.getId());
        System.out.println("NOME: " + p.getNome());

        List<Produto> todos =  pDAO.pegarProdutos();
        List<Produto> paramento =  pDAO.pegarProdutosComParamento("Xiaomi");
        todos.forEach(p2 -> System.out.println(p2.getNome() + " "+p2.getId()));
        paramento.forEach(p2 -> System.out.println(p2.getNome()));
    }

    private static void cadastrar() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi", "Xiaomi e", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO dao = new ProdutoDAO(em);
        CategoriaDAO daoCate = new CategoriaDAO(em);


        celulares.setNome("Aaa");
        em.getTransaction().begin();
        daoCate.cadastrar(celulares);
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
