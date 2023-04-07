import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "produtos")
public class Produto{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nome;
   private String descricao;
   private BigDecimal preco;
   private LocalDate dataCadastro = LocalDate.now();
   @ManyToOne
     private Categoria categoria;

   public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
      this.nome = nome;
      this.descricao = descricao;
      this.preco = preco;
      this.categoria = categoria;
   }
   public Produto(){

   }

   public LocalDate getDataCadastro() {
      return dataCadastro;
   }

   public void setDataCadastro(LocalDate dataCadastro) {
      this.dataCadastro = dataCadastro;
   }

   public Categoria getCategoria() {
      return categoria;
   }


   public Long getId() {
      return id;
   }

   public String getNome() {
      return nome;
   }


   public String getDescricao() {
      return descricao;
   }


   public BigDecimal getPreco() {
      return preco;
   }
}
