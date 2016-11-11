import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Container {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        App app = (App) ctx.getBean("app");
//        app.logEvent("Some event for user 1");
//        app.logEvent("Some event for user 2");
        Event event = (Event) ctx.getBean("event");
        event.setMsg("Some event for user 1");
        app.logEvent(event);
    }
}
