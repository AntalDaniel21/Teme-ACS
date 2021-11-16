import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AssertTest {
    @Test
    public void TestIncorrectPath() {
        boolean trown = false;
        try {
            File file = new File("IncorrectPath.txt");
            FileUtils.readFileToString(file, Charset.defaultCharset());
        } catch (FileNotFoundException e) {
            trown = true;
        } catch (NullPointerException e) {
            Assertions.fail("Unexpected exception while reading the file");
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail("Unexpected exception while reading the file");
        } finally {
            Assertions.assertTrue(trown);
        }
    }

    @Test
    public void TestNullFile() {
        boolean trown = false;
        try {
            File file = null;
            FileUtils.readFileToString(file, Charset.defaultCharset());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Assertions.fail("Unexpected exception while reading the file");
        } catch (NullPointerException e) {
            trown = true;
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail("Unexpected exception while reading the file");
        } finally {
            Assertions.assertTrue(trown);
        }
    }
}
