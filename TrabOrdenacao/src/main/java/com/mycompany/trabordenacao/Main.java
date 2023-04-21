package com.mycompany.trabordenacao;
import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {
        boolean status = true;
        
        //Do-While para o Programa repetir conforme a necessidade do Usuário
        do{
            //Criando as Variáveis
            int inptResp;
            int tamVetor = 0;
            int[] primVetor = {0};
            int[] selVetor = {0};
            int[] insVetor = {0};
            int[] bolVetor = {0};
            int vlInfo;


             //Adicionando o Tamanho aos Vetores
            for(int i = 0; i != 1; i++){
                tamVetor = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Informe o Tamanho do Vetor: "));

                if(tamVetor <= 0){
                    JOptionPane.showMessageDialog(null, "Valor Informado "
                            + "Inválido!");
                    i--;
                }else{
                    primVetor = new int[tamVetor];
                    selVetor = new int[tamVetor];
                    insVetor = new int[tamVetor];
                    bolVetor = new int[tamVetor];
                }
            }

            //Adicionado os Valores aos Vetores
            for(int i = 0; i < primVetor.length; i++){
                vlInfo = Integer.parseInt(JOptionPane.showInputDialog(null, 
                        "Informe o "+ (i+1) +"º Valor para Adicionar "
                                + "no Vetor: "));

                primVetor[i] = vlInfo;
                selVetor[i] = vlInfo;
                insVetor[i] = vlInfo;
                bolVetor[i] = vlInfo;
            }

            //Solicitando qual Método de Ordenação deseja utilizar
            inptResp = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Selecione um Método de Ordenação: \n"
                            + "1 - Ordenação Seleção \n"
                            + "2 - Ordenação Inserção \n"
                            + "3 - Ordenação Bolha \n"
                            + "4 - Todos Métodos \n"
                            + "0 - Encerrar"));
            
            //Realizando conforme a Opção Selecionada                
            if(inptResp == 1){
                ordSelecao(primVetor, selVetor);
            }else if(inptResp == 2){
                ordInsercao(primVetor, insVetor);
            }else if(inptResp == 3){
                ordBolha(primVetor, bolVetor);
            }else if(inptResp == 4){
                JOptionPane.showMessageDialog(null, "Realizando Ordenação tipo "
                        + "Seleção!");
                ordSelecao(primVetor, selVetor);

                JOptionPane.showMessageDialog(null, "Realizando Ordenação tipo "
                        + "Inserção!");
                ordInsercao(primVetor, insVetor);

                JOptionPane.showMessageDialog(null, "Realizando Ordenação tipo "
                        + "Bolha!");
                ordBolha(primVetor, bolVetor);
            }else{
                JOptionPane.showMessageDialog(null, "Programa Encerrado!");
            }
            
            inptResp = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Deseja realizar outra Ordenação? \n"
                            + "0 - Não \n"
                            + "1 - Sim \n"));
            if(inptResp == 0){
                JOptionPane.showMessageDialog(null, "Programa Encerrado!");
                status = false;
            }
            
        }while(status == true);   
    }
    
    //Métodos de Ordenação
    public static void ordSelecao(int[] primVetor, int[] selVetor){
        //Variáveis para informar o Tempo de Execução do Programa
        long tempInicio;
        long tempFim;
        long tempExec;
        
        //Variáveis para Imprimir os Valores dos Vetor Não Ordenado e Ordenado
        String msgPrimVetor = "Primeiros Valores Informados: \n";
        String msgSelVetor = "Valores Ordenados: \n";
        
        tempInicio = System.nanoTime();
        for (int i = 0; i < selVetor.length; i++){
            int posMenor = i;
            for(int j = posMenor + 1; j < selVetor.length; j++){
                if(selVetor[j] < selVetor[posMenor]){
                    posMenor = j;
                }
                
            }
            if(posMenor != i){
                int aux = selVetor[i];
                selVetor[i] = selVetor[posMenor];
                selVetor[posMenor] = aux;
            }
        }
        tempFim = System.nanoTime();
        
        //Finalizando a Ordenação e a Marcação do Tempo
        tempExec = tempFim - tempInicio;
        
        //Imprimindo os Valores Informados
        for(int i = 0; i < primVetor.length; i++){
            msgPrimVetor += (i + 1)+"º Valor Informado: "+primVetor[i]+" \n";
        }
        JOptionPane.showMessageDialog(null, msgPrimVetor);
        
        //Imprimindo os Valores Ordenados
        for(int i = 0; i < selVetor.length; i++){
            msgSelVetor += (i + 1)+"º Valor Ordenado: "+selVetor[i]+"\n";
        }
        JOptionPane.showMessageDialog(null, msgSelVetor);
        
        //Imprimindo o Tempo de Execução do Programa
        JOptionPane.showMessageDialog(null, "Tempo de Execução do "
                + "Programa: "+tempExec+"ns");
    }
    public static void ordInsercao(int[]primVetor, int[]insVetor){
        //Variáveis para Informar o Tempo de Execução do Programa
        long tempInicio;
        long tempFim;
        long tempExec;
        
        //Variáveis para Imprimir os Valores dos Vetor Não Ordenado e Ordenado
        String msgPrimVetor = "Primeiros Valores Informados: \n";
        String msgInsVetor = "Valores Ordenados: \n";
        
        //Inicio da Ordenação com a Marcação do Tempo
        tempInicio = System.nanoTime();
        int chave, j;
        
        for(int i = 1; i < insVetor.length; i++){
            chave = insVetor[i];
            for(j = i - 1; j >= 0 && insVetor[j] > chave; j--){
                insVetor[j + 1] = insVetor[j];
            }
            insVetor[j + 1] = chave;
        }
        tempFim = System.nanoTime();
        
        //Finalizando a Ordenação e a Marcação do Tempo
        tempExec = tempFim - tempInicio;
        
        //Imprimindo os Valores Informados
        for(int t = 0; t < primVetor.length; t++){
            msgPrimVetor += (t + 1)+"º Valor Informado: "+primVetor[t]+" \n";
        }
        JOptionPane.showMessageDialog(null, msgPrimVetor);
        
        //Imprimindo os Valores Ordenados
        for(int t = 0; t < insVetor.length; t++){
            msgInsVetor += (t + 1)+"º Valor Ordenado: "+insVetor[t]+"\n";
        }
        JOptionPane.showMessageDialog(null, msgInsVetor);
        
        //Imprimindo o Tempo de Execução do Programa
        JOptionPane.showMessageDialog(null, "Tempo de Execução do "
                + "Programa: "+tempExec+"ns");
    }
    public static void ordBolha(int[]primVetor, int[]bolVetor){
        //Variáveis para Informar o Tempo de Execução do Programa
        long tempInicio;
        long tempFim;
        long tempExec;
        
        //Variáveis para Imprimir os Valores dos Vetor Não Ordenado e Ordenado
        String msgPrimVetor = "Primeiros Valores Informados: \n";
        String msgBolVetor = "Valores Ordenados: \n";
        
        //Inicio da Ordenação com a Marcação do Tempo
        tempInicio = System.nanoTime();        
        int aux;
         boolean status = true;
         
         while(status){
             status = false;
             
             for(int i = 0; i < bolVetor.length - 1; i++){
                 if(bolVetor[i] > bolVetor[i + 1]){
                     aux = bolVetor[i];
                     bolVetor[i] = bolVetor[i + 1];
                     bolVetor[i + 1] = aux;
                     
                     status = true;
                 }
             }
         }
         tempFim = System.nanoTime();
         
        //Finalizando a Ordenação e a Marcação do Tempo
        tempExec = tempFim - tempInicio;
        
        //Imprimindo os Valores Informados
        for(int i = 0; i < primVetor.length; i++){
            msgPrimVetor += (i + 1)+"º Valor Informado: "+primVetor[i]+" \n";
        }
        JOptionPane.showMessageDialog(null, msgPrimVetor);
        
        //Imprimindo os Valores Ordenados
        for(int i = 0; i < bolVetor.length; i++){
            msgBolVetor += (i + 1)+"º Valor Ordenado: "+bolVetor[i]+"\n";
        }
        JOptionPane.showMessageDialog(null, msgBolVetor);
        
        //Imprimindo o Tempo de Execução do Programa
        JOptionPane.showMessageDialog(null, "Tempo de Execução do "
                + "Programa: "+tempExec+"ns");
    }
}
