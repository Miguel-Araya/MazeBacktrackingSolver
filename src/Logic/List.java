// Source code recreated by Apache Netbeans (NB Java Decompiler) 
/*
 * Decompiled with CFR 0.152.
 */
package Logic;

public interface List {
    public void add(Object var1);

    public void delete(Object var1);

    public void delete(int var1);

    public int getSize();

    public boolean isEmpty();

    public Object lastInList() throws ListException;

    public Object firstInList();

    public Object getByPosition(int var1) throws ListException;

    public void reset();

    public boolean exists(Object var1);
}
