import java.io.*;

public class BackupDemo {
    static class BackupItem implements Serializable {
        private static final long serialVersionUID = 1L;
        String data;
        BackupItem(String d){ this.data = d; }
    }

    public static void main(String[] args) throws Exception {
        BackupItem item = new BackupItem("important");
        // Serialize to file (demo)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("backup.dat"))) {
            oos.writeObject(item);
            System.out.println("Serialized backup.dat");
        }
    }
}
