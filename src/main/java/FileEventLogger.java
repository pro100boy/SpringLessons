import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger{
    private final String fileName;

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
}
