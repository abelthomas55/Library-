/**
 * The CheckInOut interface defines methods for checking out and checking in items,
 * as well as checking if an item is currently checked out.
 */
package src.library.inventory;
/**
 * Checks out an item.
 * @throws Exception If an error occurs during the check-out process.
 */
public interface CheckInOut {
    /**
     * Checks in an item.
     * @throws Exception If an error occurs during the check-in process.
     */
    void checkOut() throws Exception;

    /**
     * Checks in an item.
     * @throws Exception If an error occurs during the check-in process.
     */

    void checkIn() throws Exception;

    /**
     * Checks if an item is currently checked out.
     * @return True if the item is checked out, false otherwise.
     */
    boolean isCheckedOut();

}
