package androidx.media3.exoplayer.source;

import android.util.SparseArray;

/* loaded from: classes2.dex */
final class j0 {

    /* renamed from: a, reason: collision with root package name */
    private int f12917a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray f12918b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.m f12919c;

    public j0() {
        this(new androidx.media3.common.util.m() { // from class: androidx.media3.exoplayer.source.i0
            @Override // androidx.media3.common.util.m
            public final void accept(Object obj) {
                j0.i(obj);
            }
        });
    }

    public j0(androidx.media3.common.util.m mVar) {
        this.f12918b = new SparseArray();
        this.f12919c = mVar;
        this.f12917a = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Object obj) {
    }

    public void b(int i11, Object obj) {
        if (this.f12917a == -1) {
            androidx.media3.common.util.a.g(this.f12918b.size() == 0);
            this.f12917a = 0;
        }
        if (this.f12918b.size() > 0) {
            SparseArray sparseArray = this.f12918b;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            androidx.media3.common.util.a.a(i11 >= keyAt);
            if (keyAt == i11) {
                androidx.media3.common.util.m mVar = this.f12919c;
                SparseArray sparseArray2 = this.f12918b;
                mVar.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f12918b.append(i11, obj);
    }

    public void c() {
        for (int i11 = 0; i11 < this.f12918b.size(); i11++) {
            this.f12919c.accept(this.f12918b.valueAt(i11));
        }
        this.f12917a = -1;
        this.f12918b.clear();
    }

    public void d(int i11) {
        for (int size = this.f12918b.size() - 1; size >= 0 && i11 < this.f12918b.keyAt(size); size--) {
            this.f12919c.accept(this.f12918b.valueAt(size));
            this.f12918b.removeAt(size);
        }
        this.f12917a = this.f12918b.size() > 0 ? Math.min(this.f12917a, this.f12918b.size() - 1) : -1;
    }

    public void e(int i11) {
        int i12 = 0;
        while (i12 < this.f12918b.size() - 1) {
            int i13 = i12 + 1;
            if (i11 < this.f12918b.keyAt(i13)) {
                return;
            }
            this.f12919c.accept(this.f12918b.valueAt(i12));
            this.f12918b.removeAt(i12);
            int i14 = this.f12917a;
            if (i14 > 0) {
                this.f12917a = i14 - 1;
            }
            i12 = i13;
        }
    }

    public Object f(int i11) {
        if (this.f12917a == -1) {
            this.f12917a = 0;
        }
        while (true) {
            int i12 = this.f12917a;
            if (i12 <= 0 || i11 >= this.f12918b.keyAt(i12)) {
                break;
            }
            this.f12917a--;
        }
        while (this.f12917a < this.f12918b.size() - 1 && i11 >= this.f12918b.keyAt(this.f12917a + 1)) {
            this.f12917a++;
        }
        return this.f12918b.valueAt(this.f12917a);
    }

    public Object g() {
        return this.f12918b.valueAt(r0.size() - 1);
    }

    public boolean h() {
        return this.f12918b.size() == 0;
    }
}
