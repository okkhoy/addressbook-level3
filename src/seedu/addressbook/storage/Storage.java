package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.storage.Storage.StorageOperationException;

/**
 * Represents the storage object used to store the addressbook data.
 * The subclass extending this class should provide impementation of 
 * the methods depending on the type of storage object that is underlying.
 */
public abstract class Storage {

    /**
     * Saves all data to this storage obect. The subclass should implement the save method appropriately
     * dependng on the type of Storage object (e.g., database, file etc.)
     *
     * @throws StorageOperationException if there were errors converting and/or storing data to file.
     */
    public abstract void save(AddressBook addressBook) throws StorageOperationException;
    
    /**
     * Loads data from this storage object. The subclass should implement the load method appropriately
     * depending on the type of Storage object (e.g., database, file etc.)
     *
     * @throws StorageOperationException if there were errors reading and/or converting data from file.
     */
    public abstract AddressBook load() throws StorageOperationException;
    
    public abstract String getPath();
    
    /**
     * Signals that some error has occured while trying to convert and read/write data between the application
     * and the storage file.
     */
    public static class StorageOperationException extends Exception {
        public StorageOperationException(String message) {
            super(message);
        }
    }
    
    /**
     * Signals that the given file path does not fulfill the storage filepath constraints.
     */
    public static class InvalidStorageFilePathException extends IllegalValueException {
        public InvalidStorageFilePathException(String message) {
            super(message);
        }
    }
}
