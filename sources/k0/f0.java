package k0;

import android.text.Layout;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    private final Layout f66649a;

    /* renamed from: b, reason: collision with root package name */
    private final List f66650b;

    /* renamed from: c, reason: collision with root package name */
    private final List f66651c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean[] f66652d;

    /* renamed from: e, reason: collision with root package name */
    private char[] f66653e;

    /* renamed from: f, reason: collision with root package name */
    private final int f66654f;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f66655a;

        /* renamed from: b, reason: collision with root package name */
        private final int f66656b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f66657c;

        public a(int i11, int i12, boolean z10) {
            this.f66655a = i11;
            this.f66656b = i12;
            this.f66657c = z10;
        }

        public final int a() {
            return this.f66656b;
        }

        public final int b() {
            return this.f66655a;
        }

        public final boolean c() {
            return this.f66657c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f66655a == aVar.f66655a && this.f66656b == aVar.f66656b && this.f66657c == aVar.f66657c;
        }

        public int hashCode() {
            return (((this.f66655a * 31) + this.f66656b) * 31) + androidx.compose.foundation.e.a(this.f66657c);
        }

        public String toString() {
            return "BidiRun(start=" + this.f66655a + ", end=" + this.f66656b + ", isRtl=" + this.f66657c + ')';
        }
    }

    public f0(Layout layout) {
        this.f66649a = layout;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        do {
            int n02 = StringsKt.n0(this.f66649a.getText(), '\n', i11, false, 4, null);
            i11 = n02 < 0 ? this.f66649a.getText().length() : n02 + 1;
            arrayList.add(Integer.valueOf(i11));
        } while (i11 < this.f66649a.getText().length());
        this.f66650b = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            arrayList2.add(null);
        }
        this.f66651c = arrayList2;
        this.f66652d = new boolean[this.f66650b.size()];
        this.f66654f = this.f66650b.size();
    }

    private final float b(int i11, boolean z10) {
        int i12 = RangesKt.i(i11, this.f66649a.getLineEnd(this.f66649a.getLineForOffset(i11)));
        return z10 ? this.f66649a.getPrimaryHorizontal(i12) : this.f66649a.getSecondaryHorizontal(i12);
    }

    private final int i(int i11, int i12) {
        while (i11 > i12 && g(this.f66649a.getText().charAt(i11 - 1))) {
            i11--;
        }
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        if (r0.getRunCount() == 1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.text.Bidi a(int r12) {
        /*
            r11 = this;
            boolean[] r0 = r11.f66652d
            boolean r0 = r0[r12]
            if (r0 == 0) goto Lf
            java.util.List r0 = r11.f66651c
            java.lang.Object r12 = r0.get(r12)
            java.text.Bidi r12 = (java.text.Bidi) r12
            return r12
        Lf:
            r0 = 0
            if (r12 != 0) goto L14
            r1 = r0
            goto L22
        L14:
            java.util.List r1 = r11.f66650b
            int r2 = r12 + (-1)
            java.lang.Object r1 = r1.get(r2)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
        L22:
            java.util.List r2 = r11.f66650b
            java.lang.Object r2 = r2.get(r12)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            int r8 = r2 - r1
            char[] r3 = r11.f66653e
            if (r3 == 0) goto L3a
            int r4 = r3.length
            if (r4 >= r8) goto L38
            goto L3a
        L38:
            r10 = r3
            goto L3d
        L3a:
            char[] r3 = new char[r8]
            goto L38
        L3d:
            android.text.Layout r3 = r11.f66649a
            java.lang.CharSequence r3 = r3.getText()
            android.text.TextUtils.getChars(r3, r1, r2, r10, r0)
            boolean r0 = java.text.Bidi.requiresBidi(r10, r0, r8)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L62
            boolean r9 = r11.h(r12)
            java.text.Bidi r0 = new java.text.Bidi
            r6 = 0
            r7 = 0
            r5 = 0
            r3 = r0
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8, r9)
            int r3 = r0.getRunCount()
            if (r3 != r2) goto L63
        L62:
            r0 = r1
        L63:
            java.util.List r3 = r11.f66651c
            r3.set(r12, r0)
            boolean[] r3 = r11.f66652d
            r3[r12] = r2
            if (r0 == 0) goto L75
            char[] r12 = r11.f66653e
            if (r10 != r12) goto L74
            r10 = r1
            goto L75
        L74:
            r10 = r12
        L75:
            r11.f66653e = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.f0.a(int):java.text.Bidi");
    }

    public final float c(int i11, boolean z10, boolean z11) {
        int i12 = i11;
        if (!z11) {
            return b(i11, z10);
        }
        int a11 = e0.a(this.f66649a, i12, z11);
        int lineStart = this.f66649a.getLineStart(a11);
        int lineEnd = this.f66649a.getLineEnd(a11);
        if (i12 != lineStart && i12 != lineEnd) {
            return b(i11, z10);
        }
        if (i12 == 0 || i12 == this.f66649a.getText().length()) {
            return b(i11, z10);
        }
        int e11 = e(i12, z11);
        boolean h11 = h(e11);
        int i13 = i(lineEnd, lineStart);
        int f11 = f(e11);
        int i14 = lineStart - f11;
        int i15 = i13 - f11;
        Bidi a12 = a(e11);
        Bidi createLineBidi = a12 != null ? a12.createLineBidi(i14, i15) : null;
        boolean z12 = false;
        if (createLineBidi == null || createLineBidi.getRunCount() == 1) {
            boolean isRtlCharAt = this.f66649a.isRtlCharAt(lineStart);
            if (z10 || h11 == isRtlCharAt) {
                h11 = !h11;
            }
            if (i12 == lineStart) {
                z12 = h11;
            } else if (!h11) {
                z12 = true;
            }
            Layout layout = this.f66649a;
            return z12 ? layout.getLineLeft(a11) : layout.getLineRight(a11);
        }
        int runCount = createLineBidi.getRunCount();
        a[] aVarArr = new a[runCount];
        for (int i16 = 0; i16 < runCount; i16++) {
            aVarArr[i16] = new a(createLineBidi.getRunStart(i16) + lineStart, createLineBidi.getRunLimit(i16) + lineStart, createLineBidi.getRunLevel(i16) % 2 == 1);
        }
        int runCount2 = createLineBidi.getRunCount();
        byte[] bArr = new byte[runCount2];
        for (int i17 = 0; i17 < runCount2; i17++) {
            bArr[i17] = (byte) createLineBidi.getRunLevel(i17);
        }
        Bidi.reorderVisually(bArr, 0, aVarArr, 0, runCount);
        int i18 = -1;
        if (i12 == lineStart) {
            int i19 = 0;
            while (true) {
                if (i19 >= runCount) {
                    break;
                }
                if (aVarArr[i19].b() == i12) {
                    i18 = i19;
                    break;
                }
                i19++;
            }
            a aVar = aVarArr[i18];
            if (z10 || h11 == aVar.c()) {
                h11 = !h11;
            }
            return (i18 == 0 && h11) ? this.f66649a.getLineLeft(a11) : (i18 != ArraysKt.b0(aVarArr) || h11) ? h11 ? this.f66649a.getPrimaryHorizontal(aVarArr[i18 - 1].b()) : this.f66649a.getPrimaryHorizontal(aVarArr[i18 + 1].b()) : this.f66649a.getLineRight(a11);
        }
        if (i12 > i13) {
            i12 = i(i12, lineStart);
        }
        int i20 = 0;
        while (true) {
            if (i20 >= runCount) {
                break;
            }
            if (aVarArr[i20].a() == i12) {
                i18 = i20;
                break;
            }
            i20++;
        }
        a aVar2 = aVarArr[i18];
        if (!z10 && h11 != aVar2.c()) {
            h11 = !h11;
        }
        return (i18 == 0 && h11) ? this.f66649a.getLineLeft(a11) : (i18 != ArraysKt.b0(aVarArr) || h11) ? h11 ? this.f66649a.getPrimaryHorizontal(aVarArr[i18 - 1].a()) : this.f66649a.getPrimaryHorizontal(aVarArr[i18 + 1].a()) : this.f66649a.getLineRight(a11);
    }

    public final int d(int i11) {
        return i(this.f66649a.getLineEnd(i11), this.f66649a.getLineStart(i11));
    }

    public final int e(int i11, boolean z10) {
        int k11 = CollectionsKt.k(this.f66650b, Integer.valueOf(i11), 0, 0, 6, null);
        int i12 = k11 < 0 ? -(k11 + 1) : k11 + 1;
        if (z10 && i12 > 0) {
            int i13 = i12 - 1;
            if (i11 == ((Number) this.f66650b.get(i13)).intValue()) {
                return i13;
            }
        }
        return i12;
    }

    public final int f(int i11) {
        if (i11 == 0) {
            return 0;
        }
        return ((Number) this.f66650b.get(i11 - 1)).intValue();
    }

    public final boolean g(char c11) {
        return c11 == ' ' || c11 == '\n' || c11 == 5760 || (Intrinsics.j(c11, 8192) >= 0 && Intrinsics.j(c11, 8202) <= 0 && c11 != 8199) || c11 == 8287 || c11 == 12288;
    }

    public final boolean h(int i11) {
        return this.f66649a.getParagraphDirection(this.f66649a.getLineForOffset(f(i11))) == -1;
    }
}
