package agibank;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainApplication {

    public static void main(String[] args) throws InterruptedException, IOException {

        while(true) {
            List<String> finalReport = new ArrayList<>();
            FileUtil fileUtil = new FileUtil();
            List<String> requestList = new ArrayList<>();

            Path pathIn = Paths.get("D:/Documentos/NTConsult/agibank/HOMEPATH/data/in");
            List<Path> files = GetPath.findByFileExtension(pathIn, ".txt");

            for(Path file : files) {
                List<String> array = fileUtil.readFile(file.toString());
                requestList.addAll(array);
            }

            finalReport.add(GetData.countClients(requestList));
            finalReport.add(GetData.countSellers(requestList));
            finalReport.add(GetData.findMoreExpensiveSale(requestList));
            finalReport.add(GetData.findWorstSeller(requestList));
            fileUtil.writeFile("D:/Documentos/NTConsult/agibank/HOMEPATH/data/out/DataReading.txt", finalReport);

            TimeUnit.SECONDS.sleep(10);
        }
    }
}
