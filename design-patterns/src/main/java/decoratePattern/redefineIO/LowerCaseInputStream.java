package decoratePattern.redefineIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LowerCaseInputStream extends FileInputStream {

    public LowerCaseInputStream(String name) throws FileNotFoundException {
        super(System.getProperty("user.dir") + System.getProperty("file.separator") + name);
    }

    @Override
    public int read() throws IOException {
        int i = super.read();
        return i == -1 ? i : Character.toLowerCase((char) i);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int x = super.read(b, off, len);
        b = new String(b).toUpperCase().getBytes();
        return x == -1 ? x : b.length;
    }
}
