package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
interface v {

    /* loaded from: classes2.dex */
    public static class a implements v {

        /* renamed from: a, reason: collision with root package name */
        SparseArray f14517a = new SparseArray();

        /* renamed from: b, reason: collision with root package name */
        int f14518b = 0;

        /* renamed from: androidx.recyclerview.widget.v$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0121a implements c {

            /* renamed from: a, reason: collision with root package name */
            private SparseIntArray f14519a = new SparseIntArray(1);

            /* renamed from: b, reason: collision with root package name */
            private SparseIntArray f14520b = new SparseIntArray(1);

            /* renamed from: c, reason: collision with root package name */
            final k f14521c;

            C0121a(k kVar) {
                this.f14521c = kVar;
            }

            @Override // androidx.recyclerview.widget.v.c
            public int a(int i11) {
                int indexOfKey = this.f14520b.indexOfKey(i11);
                if (indexOfKey >= 0) {
                    return this.f14520b.valueAt(indexOfKey);
                }
                throw new IllegalStateException("requested global type " + i11 + " does not belong to the adapter:" + this.f14521c.f14480c);
            }

            @Override // androidx.recyclerview.widget.v.c
            public int b(int i11) {
                int indexOfKey = this.f14519a.indexOfKey(i11);
                if (indexOfKey > -1) {
                    return this.f14519a.valueAt(indexOfKey);
                }
                int c11 = a.this.c(this.f14521c);
                this.f14519a.put(i11, c11);
                this.f14520b.put(c11, i11);
                return c11;
            }
        }

        @Override // androidx.recyclerview.widget.v
        public k a(int i11) {
            k kVar = (k) this.f14517a.get(i11);
            if (kVar != null) {
                return kVar;
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i11);
        }

        @Override // androidx.recyclerview.widget.v
        public c b(k kVar) {
            return new C0121a(kVar);
        }

        int c(k kVar) {
            int i11 = this.f14518b;
            this.f14518b = i11 + 1;
            this.f14517a.put(i11, kVar);
            return i11;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements v {

        /* renamed from: a, reason: collision with root package name */
        SparseArray f14523a = new SparseArray();

        /* loaded from: classes2.dex */
        class a implements c {

            /* renamed from: a, reason: collision with root package name */
            final k f14524a;

            a(k kVar) {
                this.f14524a = kVar;
            }

            @Override // androidx.recyclerview.widget.v.c
            public int a(int i11) {
                return i11;
            }

            @Override // androidx.recyclerview.widget.v.c
            public int b(int i11) {
                List list = (List) b.this.f14523a.get(i11);
                if (list == null) {
                    list = new ArrayList();
                    b.this.f14523a.put(i11, list);
                }
                if (!list.contains(this.f14524a)) {
                    list.add(this.f14524a);
                }
                return i11;
            }
        }

        @Override // androidx.recyclerview.widget.v
        public k a(int i11) {
            List list = (List) this.f14523a.get(i11);
            if (list != null && !list.isEmpty()) {
                return (k) list.get(0);
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i11);
        }

        @Override // androidx.recyclerview.widget.v
        public c b(k kVar) {
            return new a(kVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        int a(int i11);

        int b(int i11);
    }

    k a(int i11);

    c b(k kVar);
}
