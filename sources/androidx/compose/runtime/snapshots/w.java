package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w implements ListIterator, KMutableListIterator {

    /* renamed from: a, reason: collision with root package name */
    private final SnapshotStateList f4104a;

    /* renamed from: b, reason: collision with root package name */
    private int f4105b;

    /* renamed from: c, reason: collision with root package name */
    private int f4106c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f4107d;

    public w(SnapshotStateList snapshotStateList, int i11) {
        this.f4104a = snapshotStateList;
        this.f4105b = i11 - 1;
        this.f4107d = snapshotStateList.e();
    }

    private final void a() {
        if (this.f4104a.e() != this.f4107d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        a();
        this.f4104a.add(this.f4105b + 1, obj);
        this.f4106c = -1;
        this.f4105b++;
        this.f4107d = this.f4104a.e();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.f4105b < this.f4104a.size() - 1;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.f4105b >= 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        a();
        int i11 = this.f4105b + 1;
        this.f4106c = i11;
        s.g(i11, this.f4104a.size());
        Object obj = this.f4104a.get(i11);
        this.f4105b = i11;
        return obj;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f4105b + 1;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        a();
        s.g(this.f4105b, this.f4104a.size());
        int i11 = this.f4105b;
        this.f4106c = i11;
        this.f4105b--;
        return this.f4104a.get(i11);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f4105b;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        a();
        this.f4104a.remove(this.f4105b);
        this.f4105b--;
        this.f4106c = -1;
        this.f4107d = this.f4104a.e();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        a();
        int i11 = this.f4106c;
        if (i11 < 0) {
            s.e();
            throw new KotlinNothingValueException();
        }
        this.f4104a.set(i11, obj);
        this.f4107d = this.f4104a.e();
    }
}
