package upei.project;

public interface ManagementSystem<T> {
    void add(T item);
    void remove(T item);
    boolean contains(T item);
    void reportAll();
}
