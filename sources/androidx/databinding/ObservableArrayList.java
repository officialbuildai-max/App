package androidx.databinding;

import androidx.databinding.j;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public class ObservableArrayList<T> extends ArrayList<T> implements j {
    private transient h mListeners = new h();

    private void notifyAdd(int i11, int i12) {
        h hVar = this.mListeners;
        if (hVar != null) {
            hVar.p(this, i11, i12);
        }
    }

    private void notifyRemove(int i11, int i12) {
        h hVar = this.mListeners;
        if (hVar != null) {
            hVar.q(this, i11, i12);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i11, T t11) {
        super.add(i11, t11);
        notifyAdd(i11, 1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t11) {
        super.add(t11);
        notifyAdd(size() - 1, 1);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i11, Collection<? extends T> collection) {
        boolean addAll = super.addAll(i11, collection);
        if (addAll) {
            notifyAdd(i11, collection.size());
        }
        return addAll;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> collection) {
        int size = size();
        boolean addAll = super.addAll(collection);
        if (addAll) {
            notifyAdd(size, size() - size);
        }
        return addAll;
    }

    public void addOnListChangedCallback(j.a aVar) {
        if (this.mListeners == null) {
            this.mListeners = new h();
        }
        this.mListeners.a(aVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int size = size();
        super.clear();
        if (size != 0) {
            notifyRemove(0, size);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T remove(int i11) {
        T t11 = (T) super.remove(i11);
        notifyRemove(i11, 1);
        return t11;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public void removeOnListChangedCallback(j.a aVar) {
        h hVar = this.mListeners;
        if (hVar != null) {
            hVar.j(aVar);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    protected void removeRange(int i11, int i12) {
        super.removeRange(i11, i12);
        notifyRemove(i11, i12 - i11);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T set(int i11, T t11) {
        T t12 = (T) super.set(i11, t11);
        h hVar = this.mListeners;
        if (hVar != null) {
            hVar.o(this, i11, 1);
        }
        return t12;
    }
}
