package androidx.core.util;

import android.util.SparseArray;
import kotlin.collections.IntIterator;

/* loaded from: classes.dex */
public abstract class k {

    /* loaded from: classes.dex */
    public static final class a extends IntIterator {

        /* renamed from: a, reason: collision with root package name */
        private int f8352a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SparseArray f8353b;

        a(SparseArray sparseArray) {
            this.f8353b = sparseArray;
        }

        @Override // kotlin.collections.IntIterator
        public int a() {
            SparseArray sparseArray = this.f8353b;
            int i11 = this.f8352a;
            this.f8352a = i11 + 1;
            return sparseArray.keyAt(i11);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8352a < this.f8353b.size();
        }
    }

    public static final IntIterator a(SparseArray sparseArray) {
        return new a(sparseArray);
    }
}
