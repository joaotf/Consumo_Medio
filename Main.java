import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Collections;
import java.util.Comparator;

public class Main {
  public static void main(String args[]){
      // Variáveis para o Consumidor
      List<Consumidor> consumidores = new ArrayList<Consumidor>();
      String nome;
      String cons = "";
      int residencia = -1;
      double quantidade_khw = -1;
      int menu = 0;
      //
      String valores = "";
      int maiores_consumidores = 0;

      do {
        menu = Integer.parseInt(JOptionPane.showInputDialog("Menu\n1) Cadastro de Consumidor\n2) Visualizar Consumidores\n3) Resultado\n"));
        switch (menu) {
          case 1:
            nome = JOptionPane.showInputDialog("Digite o nome do consumidor");
            try {
              while(residencia < 0) residencia = Integer.parseInt(JOptionPane.showInputDialog("Digite o N° da Residência"));  
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Formato inválido!");
                break;
            }

            try {              
              while(quantidade_khw < 0) quantidade_khw = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de quilowatts consumida")); 
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Formato inválido!");
                break; 
            }

            consumidores.add(new Consumidor( nome, residencia, quantidade_khw ));
            JOptionPane.showMessageDialog(null,"Consumidor cadastrado com sucesso!");
            residencia = -1;
            quantidade_khw = -1;
            break;

          case 2:
            for (Consumidor consumidor : consumidores) {
              cons += "\nNome : "+consumidor.getNome()+"\n"+"Número : "+consumidor.getNumero_Residencia()+"\n"+
              "Quantidade consumida :"+consumidor.getQuantidade_KHw()+"\n";
            }
            JOptionPane.showMessageDialog(null,cons);
            cons = "";
            break;
          case 3:
              for (Consumidor consumidor : consumidores) {
                consumidor.setValorBruto(consumidor.getQuantidade_KHw() * 0.3);
                if(consumidor.getValorBruto() < 100){
                  consumidor.setValorLiquido(consumidor.getValorBruto() - ((consumidor.getValorBruto() * 15)/100));
                }else{
                  consumidor.setValorLiquido(consumidor.getValorBruto());
                  maiores_consumidores++;
                }
                valores += "\nNome : "+consumidor.getNome()+"\nNúmero : "+consumidor.getNumero_Residencia()+
                "\nValor Bruto : R$"+consumidor.getValorBruto()+"\nValor Líquido : R$"+consumidor.getValorLiquido()+"\n"+"--------------------";
              }
              Consumidor menor = Collections.min(consumidores,Comparator.comparing(s -> s.getQuantidade_KHw()));

              valores += "\n"+"Porcentagem de Residências > R$100 : "+(float)((maiores_consumidores*100)/consumidores.size())+"%\nMenor consumo : Casa "+menor.getNumero_Residencia();
              
              JOptionPane.showMessageDialog(null,valores);
              valores = "";
              maiores_consumidores = 0;
              break;
          default:
            break;
        }
      } while(residencia != 0);
  }
}