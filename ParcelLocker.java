import java.util.ArrayList;
import java.util.List;

public class ParcelLocker {
    private String lockerId;
    private String physicalAddress;
    private int largeSlots;
    private int mediumSlots;
    private int smallSlots;
    private List<Parcel> parcelHistory;

    // Constructors
    public ParcelLocker(String lockerId, String physicalAddress, int largeSlots, int mediumSlots, int smallSlots) {
        this.lockerId = lockerId;
        this.physicalAddress = physicalAddress;
        this.largeSlots = largeSlots;
        this.mediumSlots = mediumSlots;
        this.smallSlots = smallSlots;
        this.parcelHistory = new ArrayList<>();
    }

    // Getters and setters
    public String getLockerId() {
        return lockerId;
    }

    public void setLockerId(String lockerId) {
        this.lockerId = lockerId;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public int getLargeSlots() {
        return largeSlots;
    }

    public void setLargeSlots(int largeSlots) {
        this.largeSlots = largeSlots;
    }

    public int getMediumSlots() {
        return mediumSlots;
    }

    public void setMediumSlots(int mediumSlots) {
        this.mediumSlots = mediumSlots;
    }

    public int getSmallSlots() {
        return smallSlots;
    }

    public void setSmallSlots(int smallSlots) {
        this.smallSlots = smallSlots;
    }

    public List<Parcel> getParcelHistory() {
        return parcelHistory;
    }

    public void setParcelHistory(List<Parcel> parcelHistory) {
        this.parcelHistory = parcelHistory;
    }

    // Additional methods
    public void addParcelToHistory(Parcel parcel) {
        parcelHistory.add(parcel);
    }

    public void removeParcelFromHistory(Parcel parcel) {
        parcelHistory.remove(parcel);
    }

    @Override
    public String toString() {
        return "ParcelLocker{" +
                "lockerId='" + lockerId + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                ", largeSlots=" + largeSlots +
                ", mediumSlots=" + mediumSlots +
                ", smallSlots=" + smallSlots +
                ", parcelHistory=" + parcelHistory +
                '}';
    }
}
