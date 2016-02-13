package projetoed2.com.br.arquivo;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Wagner on 12/02/2016.
 */
public class Arquivo {

    /*
     * -Possui um caminho especifico para a busca dos daods no arquivo e caso não possua o arquivo ele o cria
     * -Retorna uma lista de strings
     */
    public LinkedList<String> readFile() throws IOException {
        LinkedList<String> lista = new LinkedList<>();

        String fileName;
        File file;
        String linha;
        fileName = "arquivo_de_contatos.txt";

        file = new File(Environment.getExternalStorageDirectory(),fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReaderr = new BufferedReader(fileReader);

        while ((linha = bufferedReaderr.readLine()) != null)
        {
            lista.add(linha);
        }
        return lista;
    }

    /* Recebe uma String e as escreve no arquivo
     */
    public void writeFile(String texto) throws IOException {

        String fileName;
        File file;
        byte[] dados;
        fileName = "arquivo_de_contatos.txt";

        file = new File(Environment.getExternalStorageDirectory(),fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        dados = texto.getBytes();

        fileOutputStream.write(dados);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
