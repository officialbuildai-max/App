package com.google.android.exoplayer2.source;

import android.util.SparseArray;

/* loaded from: classes3.dex */
final class f0 {

    /* renamed from: a, reason: collision with root package name */
    private int f25957a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray f25958b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.i f25959c;

    public f0() {
        this(new com.google.android.exoplayer2.util.i() { // from class: com.google.android.exoplayer2.source.e0
            @Override // com.google.android.exoplayer2.util.i
            public final void accept(Object obj) {
                f0.i(obj);
            }
        });
    }

    public f0(com.google.android.exoplayer2.util.i iVar) {
        this.f25958b = new SparseArray();
        this.f25959c = iVar;
        this.f25957a = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Object obj) {
    }

    public void b(int i11, Object obj) {
        if (this.f25957a == -1) {
            com.google.android.exoplayer2.util.a.g(this.f25958b.size() == 0);
            this.f25957a = 0;
        }
        if (this.f25958b.size() > 0) {
            SparseArray sparseArray = this.f25958b;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            com.google.android.exoplayer2.util.a.a(i11 >= keyAt);
            if (keyAt == i11) {
                com.google.android.exoplayer2.util.i iVar = this.f25959c;
                SparseArray sparseArray2 = this.f25958b;
                iVar.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f25958b.append(i11, obj);
    }

    public void c() {
        for (int i11 = 0; i11 < this.f25958b.size(); i11++) {
            this.f25959c.accept(this.f25958b.valueAt(i11));
        }
        this.f25957a = -1;
        this.f25958b.clear();
    }

    public void d(int i11) {
        for (int size = this.f25958b.size() - 1; size >= 0 && i11 < this.f25958b.keyAt(size); size--) {
            this.f25959c.accept(this.f25958b.valueAt(size));
            this.f25958b.removeAt(size);
        }
        this.f25957a = this.f25958b.size() > 0 ? Math.min(this.f25957a, this.f25958b.size() - 1) : -1;
    }

    public void e(int i11) {
        int i12 = 0;
        while (i12 < this.f25958b.size() - 1) {
            int i13 = i12 + 1;
            if (i11 < this.f25958b.keyAt(i13)) {
                return;
            }
            this.f25959c.accept(this.f25958b.valueAt(i12));
            this.f25958b.removeAt(i12);
            int i14 = this.f25957a;
            if (i14 > 0) {
                this.f25957a = i14 - 1;
            }
            i12 = i13;
        }
    }

    public Object f(int i11) {
        if (this.f25957a == -1) {
            this.f25957a = 0;
        }
        while (true) {
            int i12 = this.f25957a;
            if (i12 <= 0 || i11 >= this.f25958b.keyAt(i12)) {
                break;
            }
            this.f25957a--;
        }
        while (this.f25957a < this.f25958b.size() - 1 && i11 >= this.f25958b.keyAt(this.f25957a + 1)) {
            this.f25957a++;
        }
        return this.f25958b.valueAt(this.f25957a);
    }

    public Object g() {
        return this.f25958b.valueAt(r0.size() - 1);
    }

    public boolean h() {
        return this.f25958b.size() == 0;
    }
}
