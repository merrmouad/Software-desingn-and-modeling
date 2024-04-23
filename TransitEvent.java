import java.util.Date;

public class TransitEvent {
    private Date timestamp;
    private String location;
    private EventType eventType;

    // Constructors
    public TransitEvent(Date timestamp, String location, EventType eventType) {
        this.timestamp = timestamp;
        this.location = location;
        this.eventType = eventType;
    }

    // Getters and setters
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public enum EventType {
        ARRIVAL,
        DEPARTURE,
        CHANGE_OF_TERMS,
        // Add more event types as needed
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "TransitEvent{" +
                "timestamp=" + timestamp +
                ", location='" + location + '\'' +
                ", eventType=" + eventType +
                '}';
    }
}
