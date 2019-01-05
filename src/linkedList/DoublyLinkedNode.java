package linkedList;

public class DoublyLinkedNode<E> {

	private E data;
	@SuppressWarnings("rawtypes")
	private DoublyLinkedNode next;
	@SuppressWarnings("rawtypes")
	private DoublyLinkedNode prev;

	public DoublyLinkedNode() {
	}

	public DoublyLinkedNode(E data, DoublyLinkedNode next, DoublyLinkedNode prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public DoublyLinkedNode getNext() {
		return next;
	}

	public void setNext(DoublyLinkedNode next) {
		this.next = next;
	}

	public DoublyLinkedNode getPrev() {
		return prev;
	}

	public void setPrev(DoublyLinkedNode prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "DoublyLinkedNode [data=" + data + ", next=" + next + ", prev=" + prev + "]";
	}
	

}
