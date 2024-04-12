package inventory;

public interface Checkoutable {
    void checkout();
    void returned();

    boolean isCheckedOut();
}
