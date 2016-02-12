package projetoed2.com.br.estruturadedados;

import projetoed2.com.br.model.Contato;

/**
 * Created by Vagner on 12/02/2016.
 */
public class Ordenacao {

    //Ordenamos pelo nome
    public Contato[] shellSort(Contato contato[]) {
        int h = 0;
        while (h < contato.length) {
            h = 3 * h + 1;
        }
        h = h / 3;
        Contato aux;
        while (h > 0) {
            for (int i = 0; i < contato.length; i++) {
                for (int j = h; j < contato.length; j++) {
                    if (contato[j - h].compareTo(contato[j]) == 1) {
                        aux = contato[j - h];
                        contato[j - h] = contato[j];
                        contato[j] = aux;
                    }
                }
            }
            h = h / 3;
        }
        return contato;
    }
}

