package csv;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.*;


public class LettoreCsv {
    private CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',').withQuote('"');
    private CSVParser parser;

    public LettoreCsv() throws IOException {
    }


    public void setFile(String pathfile) {
        try {
            CSVParser parsert = new CSVParser(new FileReader(pathfile), this.format);
            this.parser = parsert;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Rubrica> leggiRubricaCSV() throws IOException {
        List<Rubrica> lrub = new ArrayList<>();
        for (CSVRecord record : parser) {
            //System.out.println(record);
            Rubrica rub = new Rubrica();
            rub.setNome(record.get("Nome"));
            rub.setCognome(record.get("Cognome"));
            rub.setNmedaglie(Integer.parseInt(record.get("Medaglie")));
            lrub.add(rub);
        }
        parser.close();
        return lrub;
    }

    public void scriviRubricaCSV(List<Rubrica> lrub, String path) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));
        CSVFormat format = CSVFormat.RFC4180
                .withDelimiter(';')
                .withQuote('"')
                .withQuoteMode(QuoteMode.ALL)
                .withHeader("Nome", "Cognome", "Medaglie");
        CSVPrinter printer = new CSVPrinter(writer, format );
        for (Rubrica rub : lrub) {
            List<String> rubData = new ArrayList<String>();
            rubData.add(rub.getNome());
            rubData.add(rub.getCognome());
            rubData.add("" + rub.getNmedaglie());
            printer.printRecord(rubData);
        }
        printer.flush();
        System.out.println("File scritto su " + path);
    }
}
