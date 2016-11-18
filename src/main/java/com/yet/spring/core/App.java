package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.beans.EventType;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class App {

    @Autowired
    private Client client;

    @Resource(name="defaultLogger")
    private EventLogger defaultLogger;

    @Resource(name="loggerMap")
    private Map<EventType, EventLogger> loggers;

    public App() {}

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        //super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }
}