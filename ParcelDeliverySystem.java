import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Define ParcelSize enum
enum ParcelSize {
    SMALL, MEDIUM, LARGE;
}

// Define Parcel class
class Parcel {
    private String sender;
    private String recipient;
    private ParcelSize size;
    private String identifier; // Add identifier field

    public Parcel(String sender, String recipient, ParcelSize size) {
        this.sender = sender;
        this.recipient = recipient;
        this.size = size;
        this.identifier = generateIdentifier(); // Generate unique identifier
    }

    // Getters and setters
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public ParcelSize getSize() {
        return size;
    }

    public void setSize(ParcelSize size) {
        this.size = size;
    }

    public String getIdentifier() {
        return identifier;
    }

    // Method to generate unique identifier (can be implemented based on
    // requirements)
    private String generateIdentifier() {
        // Implement unique identifier generation logic here
        return ""; // Placeholder
    }
}

// Define ParcelLocker class
class ParcelLocker {
    private String lockerId;
    private String address;
    private HashMap<ParcelSize, Integer> slots;
    private List<Parcel> storedParcels;

    public ParcelLocker(String lockerId, String address, HashMap<ParcelSize, Integer> slots) {
        this.lockerId = lockerId;
        this.address = address;
        this.slots = slots;
        this.storedParcels = new ArrayList<>(); // Initialize storedParcels list
    }

    public void depositParcel(Parcel parcel) {
        storedParcels.add(parcel); // Add parcel to storedParcels list
    }

    public Parcel collectParcel(String parcelIdentifier) {
        for (Parcel parcel : storedParcels) {
            if (parcel.getIdentifier().equals(parcelIdentifier)) {
                storedParcels.remove(parcel);
                return parcel;
            }
        }
        return null; // Parcel not found
    }

    // Getters and setters
    public String getLockerId() {
        return lockerId;
    }

    public void setLockerId(String lockerId) {
        this.lockerId = lockerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HashMap<ParcelSize, Integer> getSlots() {
        return slots;
    }

    public void setSlots(HashMap<ParcelSize, Integer> slots) {
        this.slots = slots;
    }
}

// Define ExternalStorage class
class ExternalStorage {
    private List<Parcel> storedParcels;

    public ExternalStorage() {
        this.storedParcels = new ArrayList<>();
    }

    public void storeParcel(Parcel parcel) {
        storedParcels.add(parcel);
    }

    public boolean isParcelStored(String parcelIdentifier) {
        for (Parcel parcel : storedParcels) {
            if (parcel.getIdentifier().equals(parcelIdentifier)) {
                return true;
            }
        }
        return false;
    }

    public Parcel retrieveParcel(String parcelIdentifier) {
        for (Parcel parcel : storedParcels) {
            if (parcel.getIdentifier().equals(parcelIdentifier)) {
                storedParcels.remove(parcel);
                return parcel;
            }
        }
        return null; // Parcel not found
    }

    public List<Parcel> getStoredParcels() {
        return storedParcels;
    }
}

// Define UserPortal class
class UserPortal {
    public String registerParcel(Parcel parcel) {
        // Implement registerParcel method
        return ""; // return parcel identifier
    }
}

// Define ParcelDeliverySystem class
public class ParcelDeliverySystem {
    public static void main(String[] args) {
        // Create objects
        HashMap<ParcelSize, Integer> senderLockerSlots = new HashMap<>();
        senderLockerSlots.put(ParcelSize.SMALL, 5);
        senderLockerSlots.put(ParcelSize.MEDIUM, 10);
        senderLockerSlots.put(ParcelSize.LARGE, 15);
        ParcelLocker senderLocker = new ParcelLocker("SenderLocker1", "Address1", senderLockerSlots);

        HashMap<ParcelSize, Integer> receivingLockerSlots = new HashMap<>();
        receivingLockerSlots.put(ParcelSize.SMALL, 10);
        receivingLockerSlots.put(ParcelSize.MEDIUM, 15);
        receivingLockerSlots.put(ParcelSize.LARGE, 20);
        ParcelLocker receivingLocker = new ParcelLocker("ReceivingLocker1", "Address2", receivingLockerSlots);

        ExternalStorage externalStorage = new ExternalStorage();
        UserPortal userPortal = new UserPortal();

        // Simulate parcel registration and depositing
        Parcel parcel = new Parcel("SenderName", "RecipientName", ParcelSize.MEDIUM);
        String parcelIdentifier = userPortal.registerParcel(parcel);
        senderLocker.depositParcel(parcel);

        // Simulate parcel transit
        receivingLocker.depositParcel(senderLocker.collectParcel(parcelIdentifier));

        // Simulate parcel collection
        Parcel collectedParcel = receivingLocker.collectParcel(parcelIdentifier);
        if (collectedParcel != null) {
            System.out.println("Parcel collected by: " + collectedParcel.getRecipient());
        } else {
            System.out.println("Parcel not found!");
        }
    }
}
