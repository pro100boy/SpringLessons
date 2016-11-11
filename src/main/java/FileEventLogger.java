import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger{
    private final String fileName;
    //private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) {
        // append to file
        try {
            FileUtils.writeStringToFile(new File(fileName), event.toString() + "\n", "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException
    {
        //this.file = new File(fileName);
        //check file write access
        if (!new File(fileName).canWrite()) throw new IOException("fileName isn't access");
    }
}
