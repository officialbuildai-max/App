package m9;

import com.google.android.exoplayer2.util.d0;
import g9.m;

/* loaded from: classes4.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f69542a = new d0(8);

    /* renamed from: b, reason: collision with root package name */
    private int f69543b;

    private long a(m mVar) {
        int i11 = 0;
        mVar.peekFully(this.f69542a.d(), 0, 1);
        int i12 = this.f69542a.d()[0] & 255;
        if (i12 == 0) {
            return Long.MIN_VALUE;
        }
        int i13 = 128;
        int i14 = 0;
        while ((i12 & i13) == 0) {
            i13 >>= 1;
            i14++;
        }
        int i15 = i12 & (~i13);
        mVar.peekFully(this.f69542a.d(), 1, i14);
        while (i11 < i14) {
            i11++;
            i15 = (this.f69542a.d()[i11] & 255) + (i15 << 8);
        }
        this.f69543b += i14 + 1;
        return i15;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x009a, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(g9.m r14) {
        /*
            r13 = this;
            long r0 = r14.getLength()
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r3 = 1024(0x400, double:5.06E-321)
            if (r2 == 0) goto L12
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 <= 0) goto L11
            goto L12
        L11:
            r3 = r0
        L12:
            int r3 = (int) r3
            com.google.android.exoplayer2.util.d0 r4 = r13.f69542a
            byte[] r4 = r4.d()
            r5 = 0
            r6 = 4
            r14.peekFully(r4, r5, r6)
            com.google.android.exoplayer2.util.d0 r4 = r13.f69542a
            long r7 = r4.F()
            r13.f69543b = r6
        L26:
            r9 = 440786851(0x1a45dfa3, double:2.1777764E-315)
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            r6 = 1
            if (r4 == 0) goto L54
            int r4 = r13.f69543b
            int r4 = r4 + r6
            r13.f69543b = r4
            if (r4 != r3) goto L36
            return r5
        L36:
            com.google.android.exoplayer2.util.d0 r4 = r13.f69542a
            byte[] r4 = r4.d()
            r14.peekFully(r4, r5, r6)
            r4 = 8
            long r6 = r7 << r4
            r8 = -256(0xffffffffffffff00, double:NaN)
            long r6 = r6 & r8
            com.google.android.exoplayer2.util.d0 r4 = r13.f69542a
            byte[] r4 = r4.d()
            r4 = r4[r5]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r8 = (long) r4
            long r7 = r6 | r8
            goto L26
        L54:
            long r3 = r13.a(r14)
            int r7 = r13.f69543b
            long r7 = (long) r7
            r9 = -9223372036854775808
            int r11 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r11 == 0) goto La1
            if (r2 == 0) goto L6a
            long r11 = r7 + r3
            int r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r0 < 0) goto L6a
            goto La1
        L6a:
            int r0 = r13.f69543b
            long r1 = (long) r0
            long r11 = r7 + r3
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 >= 0) goto L9b
            long r0 = r13.a(r14)
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 != 0) goto L7c
            return r5
        L7c:
            long r0 = r13.a(r14)
            r11 = 0
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 < 0) goto L9a
            r11 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r11 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r11 <= 0) goto L8e
            goto L9a
        L8e:
            if (r2 == 0) goto L6a
            int r0 = (int) r0
            r14.advancePeekPosition(r0)
            int r1 = r13.f69543b
            int r1 = r1 + r0
            r13.f69543b = r1
            goto L6a
        L9a:
            return r5
        L9b:
            long r0 = (long) r0
            int r14 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r14 != 0) goto La1
            r5 = r6
        La1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.f.b(g9.m):boolean");
    }
}
