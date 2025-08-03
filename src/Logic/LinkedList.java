// Source code recreated by Apache Netbeans (NB Java Decompiler) 
/*
 * Decompiled with CFR 0.152.
 */
package Logic;

import Logic.List;
import Logic.ListException;
import Logic.Node;

public class LinkedList
implements List {
    Node start = null;

    public boolean exists(Object element) {
        Node aux = this.start;
        while (aux != null) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public void delete(int position) {
        Node aux = this.start;
        Node auxPrev = null;
        int count = 0;
        if (position == 0) {
            if (aux.next != null) {
                this.start = aux.next;
                return;
            }
            this.start = null;
            return;
        }
        while (aux.next != null) {
            auxPrev = aux;
            aux = aux.next;
            if (++count != position || aux.next == null) continue;
            auxPrev.next = aux.next;
            return;
        }
        if (count == position) {
            auxPrev.next = null;
        }
    }

    public void add(Object element) {
        Node aux = this.start;
        Node newNode = new Node(element);
        if (this.isEmpty()) {
            this.start = newNode;
        } else {
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = newNode;
        }
    }

    public void delete(Object element) {
        Node aux = this.start;
        Node auxPrev = null;
        if (aux.element.equals(element)) {
            if (aux.next != null) {
                this.start = aux.next;
                return;
            }
            this.start = null;
            return;
        }
        while (aux.next != null) {
            auxPrev = aux;
            aux = aux.next;
            if (!aux.element.equals(element) || aux.next == null) continue;
            auxPrev.next = aux.next;
            return;
        }
        if (aux.element.equals(element)) {
            auxPrev.next = null;
        }
    }

    public int getSize() {
        int count = 0;
        Node aux = this.start;
        if (this.isEmpty()) {
            return 0;
        }
        while (aux != null) {
            ++count;
            aux = aux.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return this.start == null;
    }

    public void reset() {
        this.start = null;
    }

    public Object lastInList() throws ListException {
        if (this.isEmpty()) {
            throw new ListException("The list is empty");
        }
        Node aux = this.start;
        while (aux.next != null) {
            aux = aux.next;
        }
        return aux.element;
    }

    public Node startNode() {
        return this.start;
    }

    public Object firstInList() {
        return this.start.element;
    }

    public Object getByPosition(int pos) throws ListException {
        if (this.isEmpty()) {
            throw new ListException("The list is empty");
        }
        Node aux = this.start;
        int count = 0;
        while (aux != null) {
            if (count == pos) {
                return aux.element;
            }
            ++count;
            aux = aux.next;
        }
        throw new ListException("Element not found");
    }

    public Node getNode(int pos) throws ListException {
        if (this.isEmpty()) {
            throw new ListException("The list is empty");
        }
        Node aux = this.start;
        int count = 0;
        while (aux != null) {
            if (count == pos) {
                return aux;
            }
            ++count;
            aux = aux.next;
        }
        throw new ListException("Element not found");
    }

    public String toString() {
        String content = "";
        Node aux = this.start;
        while (aux != null) {
            content = content + aux.element + "-";
            aux = aux.next;
        }
        return content;
    }
}
