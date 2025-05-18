package commonLLDQuestions.cache.dataStructures;

public class DoublyLinkedList<T> {

    private T value;
    private DoublyLinkedList<T> next;
    private DoublyLinkedList<T> prev;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(T value) {
        this.value = value;
    }

    public DoublyLinkedList(T value, DoublyLinkedList<T> prev, DoublyLinkedList<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoublyLinkedList<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedList<T> next) {
        this.next = next;
    }

    public DoublyLinkedList<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedList<T> prev) {
        this.prev = prev;
    }
}
