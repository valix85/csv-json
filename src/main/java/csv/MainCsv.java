package csv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainCsv {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Approfondimento File.separator VS File.pathSeparator
        // https://stackoverflow.com/questions/5971964/file-separator-or-file-pathseparator
        String ORIGINE = "C:"+File.separator+"Users"+File.separator+"Utente" + File.separator +"Desktop"+File.separator+"sample.csv";
        String DESTINAZIONE = "C:"+File.separator+"Users"+File.separator+"Utente"+File.separator+"Desktop"+File.separator+"generate.csv";
        DESTINAZIONE = "./generate.csv";

        ORIGINE = "./sample.csv";

        LettoreCsv l1 = new LettoreCsv();
        l1.setFile(ORIGINE);
        List <Rubrica> lista = l1.leggiRubricaCSV();
        for(int i=0;i<lista.size();i++){
            System.out.println(lista.get(i).toString());
        }



        l1.scriviRubricaCSV(lista,DESTINAZIONE);



        System.out.println("************************************************************");
        GestoreJson<Rubrica> json = new GestoreJson<>();
        String str = json.trasformaRubricaJson(lista);
        System.out.println("Da obj a json--->"+str);

        List<Rubrica> rubs = json.leggiRubricaJson(str);
        //System.out.println(Class.forName(json.leggiRubricaJson(str).getClass().getName()));

        //System.out.println(rubs.getClass());
        rubs.stream().forEach(System.out::println);
        //System.out.println(Class.forName(rubs.get(0).getClass().getName()));
        //System.out.println("Da json a oggetto-->" + rubs.get(0).getNome());



    }
}
