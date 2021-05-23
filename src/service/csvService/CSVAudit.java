package service.csvService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

public class CSVAudit {
    private static CSVAudit single_instance = null;
    public static synchronized CSVAudit getInstance(){
        if (single_instance == null){
            single_instance = new CSVAudit();
        }
        return single_instance;
    }

    public void write_in_audit(String action, String object) throws IOException {
        Timestamp timestamp= Timestamp.from(Instant.now());
        File file = new File("./src/resources/audit.csv");
        if (file.isFile()) {
            if (file.length() <= 1) {
                FileWriter csvWriter = new FileWriter("./src/resources/audit.csv", true);
                csvWriter.append("Action,Object,Timestamp\n");
                csvWriter.close();
            }
            FileWriter csvWriter = new FileWriter("./src/resources/audit.csv", true);
            csvWriter.append(action + " " + object + "," + timestamp + "\n");
            csvWriter.close();
        }
    }
}
