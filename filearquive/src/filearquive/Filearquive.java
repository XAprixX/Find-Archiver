package filearquive;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Filearquive {

    public static void main(String[] args) {
        Vector<File> tarefas = new Vector<>();

        //iniciando pela pasta do usuário
        tarefas.add(new File("C:\\Users\\0063429"));
        Scanner entrada = new Scanner(System.in);
        String Nome = entrada.nextLine();

        //enquanto houver arquivos e pastas para serem verificados
        while (!tarefas.isEmpty()) {

            //quando encontrar uma pasta add o conteudo pro tarefas
            //se encontra um arquivo mostra nome
            File arquivoAtual = tarefas.remove(0);

            if (arquivoAtual.isFile()) {
               
                if (arquivoAtual.getAbsolutePath().contains(Nome)){
                     System.out.println(arquivoAtual.getAbsolutePath());
                }
            } else {
                //listando todos os arquivos e diretorios de um caminho
                File conteudo[] = arquivoAtual.listFiles();
                
                //existe conteudo dentro desta pasta (diretorio)?
                if(conteudo != null){
                    //mostrando todos os caminhos dos arquivos listados
                    for (int i = 0; i < conteudo.length; i++) {
                        tarefas.add(conteudo[i]);
                    }
                }
            }

        }

    }
}