public class ConsoleEventLogger implements EventLogger{

    public ConsoleEventLogger() {
    }

    public void logEvent(String msg)
    {
        System.out.println(msg);
    }
}