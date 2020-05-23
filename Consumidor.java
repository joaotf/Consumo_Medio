public class Consumidor {
    private String nome;
    private int num_residencia;
    private double quantidade_khw;
    private double valor_bruto;
    private double valor_liquido;

    public Consumidor(String nome,int num_residencia,double quantidade_khw){
        this.nome = nome;
        this.num_residencia = num_residencia;
        this.quantidade_khw = quantidade_khw;
    }
    
    public void setNome(String nome){
      this.nome = nome;
    } 

    public String getNome(){
      return this.nome;
    }

    public void setNumero_Residencia(int num_residencia){
      this.num_residencia = num_residencia;
    }

    public int getNumero_Residencia(){
      return this.num_residencia;
    }

    public void setQuantidade_KHw(int quantidade_khw){
      this.quantidade_khw = quantidade_khw;
    }

    public double getQuantidade_KHw(){
      return this.quantidade_khw;
    }

    public double getValorLiquido(){
      return this.valor_liquido;
    }

    public double getValorBruto(){
      return this.valor_bruto;
    }

    public void setValorLiquido(double valor_liquido){
      this.valor_liquido = valor_liquido;
    }

    public void setValorBruto(double valor_bruto){
      this.valor_bruto = valor_bruto;
    }
}