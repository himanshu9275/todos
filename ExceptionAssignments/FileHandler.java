import java.io.*;

class FileHandler {
    private BufferedReader br;
    public FileHandler(String path) throws IOException {
        File f = new File(path);
        if (!f.exists()) throw new IOException("File not found: " + path);
        br = new BufferedReader(new FileReader(f));
    }
    public void close() throws IOException { if (br!=null) br.close(); }
}

public class FileHandlerDemo {
    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler("missing.txt");
            // use fh...
            fh.close();
        } catch (IOException e) {
            System.out.println("Error constructing FileHandler: " + e.getMessage());
        }
    }
}
