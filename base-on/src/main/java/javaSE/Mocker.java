package javaSE;

import java.sql.SQLException;

/**
 *
 * Created by ss on 2017/2/16.
 */
public class Mocker<T extends Exception> {

    public static void main(String[] args) {
        new Mocker<RuntimeException>().pleaseThrow(new SQLException());
    }

    private void pleaseThrow(Exception t) throws T {
        throw (T)t;
    }
}
