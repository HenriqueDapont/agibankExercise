package agibank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public List<String> readFile(String file) {
        List<String> list = new ArrayList<>();
        try {
            InputStream input = new FileInputStream(file);
            Reader reader = new InputStreamReader(input);
            BufferedReader bufferReader = new BufferedReader(reader);

            String line = bufferReader.readLine();
            while(line != null) {
                list.add(line);
                line = bufferReader.readLine();
            }
            bufferReader.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean writeFile(String file, List<String> content) {
        try {
            OutputStream output = new FileOutputStream(file);
            Writer writer = new OutputStreamWriter(output);
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            for(String line : content) {
                bufferWriter.write(line);
                bufferWriter.newLine();
            }
            bufferWriter.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
