package commonLLDQuestions.cache.factory;

import commonLLDQuestions.cache.enums.StorageTypes;
import commonLLDQuestions.cache.repository.HashMapBasedStorage;
import commonLLDQuestions.cache.repository.Storage;

public class StorageFactory<K,V> {

    private Storage<K,V> storage;

    public Storage<K,V> getStorageType(StorageTypes storageTypes, int capacity) {

        switch (storageTypes) {
            case HASHMAP :
                storage = new HashMapBasedStorage<>(capacity);
                break;
        }

        return storage;
    }
}
