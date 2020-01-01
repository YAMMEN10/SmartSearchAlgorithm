package File_Manager;

import java.io.*;

public class FileReader {
    private String path;


    public FileReader(String path) {
        this.path = path;
    }

    public String ReadInput() {
        InputStream input_data = null;
        try {
            input_data = new FileInputStream(this.path);

            BufferedReader buf = new BufferedReader(new InputStreamReader(input_data));

            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }

            String fileAsString = sb.toString();
            return fileAsString;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
