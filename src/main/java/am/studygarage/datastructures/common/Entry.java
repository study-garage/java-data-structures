package am.studygarage.datastructures.common;

public interface Entry<K, V> {
    /**
     *
     * @return the key stored in the entry
     */
    K getKey();

    /**
     *
     * @return the value stored in the entry
     */
    V getValue();
}
