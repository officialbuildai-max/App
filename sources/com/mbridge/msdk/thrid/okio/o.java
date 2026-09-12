package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    final byte[] f38518a;

    /* renamed from: b, reason: collision with root package name */
    int f38519b;

    /* renamed from: c, reason: collision with root package name */
    int f38520c;

    /* renamed from: d, reason: collision with root package name */
    boolean f38521d;

    /* renamed from: e, reason: collision with root package name */
    boolean f38522e;

    /* renamed from: f, reason: collision with root package name */
    o f38523f;

    /* renamed from: g, reason: collision with root package name */
    o f38524g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this.f38518a = new byte[8192];
        this.f38522e = true;
        this.f38521d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(byte[] bArr, int i11, int i12, boolean z10, boolean z11) {
        this.f38518a = bArr;
        this.f38519b = i11;
        this.f38520c = i12;
        this.f38521d = z10;
        this.f38522e = z11;
    }

    public final o a(int i11) {
        o a11;
        if (i11 <= 0 || i11 > this.f38520c - this.f38519b) {
            throw new IllegalArgumentException();
        }
        if (i11 >= 1024) {
            a11 = c();
        } else {
            a11 = p.a();
            System.arraycopy(this.f38518a, this.f38519b, a11.f38518a, 0, i11);
        }
        a11.f38520c = a11.f38519b + i11;
        this.f38519b += i11;
        this.f38524g.a(a11);
        return a11;
    }

    public final o a(o oVar) {
        oVar.f38524g = this;
        oVar.f38523f = this.f38523f;
        this.f38523f.f38524g = oVar;
        this.f38523f = oVar;
        return oVar;
    }

    public final void a() {
        o oVar = this.f38524g;
        if (oVar == this) {
            throw new IllegalStateException();
        }
        if (oVar.f38522e) {
            int i11 = this.f38520c - this.f38519b;
            if (i11 > (8192 - oVar.f38520c) + (oVar.f38521d ? 0 : oVar.f38519b)) {
                return;
            }
            a(oVar, i11);
            b();
            p.a(this);
        }
    }

    public final void a(o oVar, int i11) {
        if (!oVar.f38522e) {
            throw new IllegalArgumentException();
        }
        int i12 = oVar.f38520c;
        int i13 = i12 + i11;
        if (i13 > 8192) {
            if (oVar.f38521d) {
                throw new IllegalArgumentException();
            }
            int i14 = oVar.f38519b;
            if (i13 - i14 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = oVar.f38518a;
            System.arraycopy(bArr, i14, bArr, 0, i12 - i14);
            oVar.f38520c -= oVar.f38519b;
            oVar.f38519b = 0;
        }
        System.arraycopy(this.f38518a, this.f38519b, oVar.f38518a, oVar.f38520c, i11);
        oVar.f38520c += i11;
        this.f38519b += i11;
    }

    @Nullable
    public final o b() {
        o oVar = this.f38523f;
        o oVar2 = oVar != this ? oVar : null;
        o oVar3 = this.f38524g;
        oVar3.f38523f = oVar;
        this.f38523f.f38524g = oVar3;
        this.f38523f = null;
        this.f38524g = null;
        return oVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o c() {
        this.f38521d = true;
        return new o(this.f38518a, this.f38519b, this.f38520c, true, false);
    }
}
