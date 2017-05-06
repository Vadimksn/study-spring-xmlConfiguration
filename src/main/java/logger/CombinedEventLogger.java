package logger;

import beans.Event;

import java.util.ArrayList;
import java.util.Collection;

public class CombinedEventLogger implements EventLogger {
    private Collection<EventLogger> loggers;

    @Override
    public void logEvent(Event event) {
        for(EventLogger eventLogger : loggers){
            eventLogger.logEvent(event);
        }
    }

    public void setLoggers(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }
}
