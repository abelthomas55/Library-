package inventory;

public interface CheckInOut {
    boolean checkOut();
    void checkIn();

    boolean isCheckedOut();
}
