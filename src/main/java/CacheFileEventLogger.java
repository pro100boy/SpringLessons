import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger{
    private int cacheSize; //cache size
    private final List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize)
        {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache()
    {
        for (Event event : cache)
            super.logEvent(event);
    }

    public void destroy()
    {
        if (!cache.isEmpty())
            writeEventsFromCache();
    }
}
