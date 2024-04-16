package library.inventory;

public interface CheckInOut {
    void checkOut() throws Exception;
    void checkIn() throws Exception;
    boolean isCheckedOut();
}
