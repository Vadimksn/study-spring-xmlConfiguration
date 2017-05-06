import beans.Client;
import beans.Event;
import enums.EventType;
import logger.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType,EventLogger> loggersMap;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        Client cl = (Client) context.getBean("client");

        Event event = context.getBean(Event.class);
        app.logEvent(EventType.ERROR,event, "Some event for userR 1");

        event = context.getBean(Event.class);
        app.logEvent(EventType.INFO,event, "Some event for userRR 1");

        event = context.getBean(Event.class);
        app.logEvent(null,event, "Some event for userRRR 1");

        System.out.println(cl.getGreeting());


        context.close();
    }

    private void logEvent(EventType eventType, Event event, String message) {
        String msg = message.replaceAll(client.getId(), client.getFullName());
        event.setMessage(msg);
        EventLogger eventLogger = loggersMap.get(eventType);
        if (eventLogger == null){
            eventLogger = defaultLogger;
        }
        eventLogger.logEvent(event);
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public EventLogger getDefaultLogger() {
        return defaultLogger;
    }

    public void setDefaultLogger(EventLogger defaultLogger) {
        this.defaultLogger = defaultLogger;
    }

    public Map<EventType, EventLogger> getLoggersMap() {
        return loggersMap;
    }

    public void setLoggersMap(Map<EventType, EventLogger> loggersMap) {
        this.loggersMap = loggersMap;
    }
}
