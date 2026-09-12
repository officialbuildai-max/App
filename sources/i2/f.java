package i2;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.g3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;

/* loaded from: classes2.dex */
final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f65007a = new ArrayList();

    private int f(long j11) {
        for (int i11 = 0; i11 < this.f65007a.size(); i11++) {
            if (j11 < ((i3.e) this.f65007a.get(i11)).f65020b) {
                return i11;
            }
        }
        return this.f65007a.size();
    }

    @Override // i2.a
    public ImmutableList a(long j11) {
        int f11 = f(j11);
        if (f11 == 0) {
            return ImmutableList.of();
        }
        i3.e eVar = (i3.e) this.f65007a.get(f11 - 1);
        long j12 = eVar.f65022d;
        return (j12 == C.TIME_UNSET || j11 < j12) ? eVar.f65019a : ImmutableList.of();
    }

    @Override // i2.a
    public long b(long j11) {
        if (this.f65007a.isEmpty() || j11 < ((i3.e) this.f65007a.get(0)).f65020b) {
            return C.TIME_UNSET;
        }
        for (int i11 = 1; i11 < this.f65007a.size(); i11++) {
            long j12 = ((i3.e) this.f65007a.get(i11)).f65020b;
            if (j11 == j12) {
                return j12;
            }
            if (j11 < j12) {
                i3.e eVar = (i3.e) this.f65007a.get(i11 - 1);
                long j13 = eVar.f65022d;
                return (j13 == C.TIME_UNSET || j13 > j11) ? eVar.f65020b : j13;
            }
        }
        i3.e eVar2 = (i3.e) g3.g(this.f65007a);
        long j14 = eVar2.f65022d;
        return (j14 == C.TIME_UNSET || j11 < j14) ? eVar2.f65020b : j14;
    }

    @Override // i2.a
    public long c(long j11) {
        if (this.f65007a.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j11 < ((i3.e) this.f65007a.get(0)).f65020b) {
            return ((i3.e) this.f65007a.get(0)).f65020b;
        }
        for (int i11 = 1; i11 < this.f65007a.size(); i11++) {
            i3.e eVar = (i3.e) this.f65007a.get(i11);
            if (j11 < eVar.f65020b) {
                long j12 = ((i3.e) this.f65007a.get(i11 - 1)).f65022d;
                return (j12 == C.TIME_UNSET || j12 <= j11 || j12 >= eVar.f65020b) ? eVar.f65020b : j12;
            }
        }
        long j13 = ((i3.e) g3.g(this.f65007a)).f65022d;
        if (j13 == C.TIME_UNSET || j11 >= j13) {
            return Long.MIN_VALUE;
        }
        return j13;
    }

    @Override // i2.a
    public void clear() {
        this.f65007a.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    @Override // i2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(i3.e r10, long r11) {
        /*
            r9 = this;
            long r0 = r10.f65020b
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r4 = 1
            if (r0 == 0) goto Lf
            r0 = r4
            goto L10
        Lf:
            r0 = r1
        L10:
            androidx.media3.common.util.a.a(r0)
            long r5 = r10.f65020b
            int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r0 > 0) goto L25
            long r5 = r10.f65022d
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 == 0) goto L23
            int r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r0 >= 0) goto L25
        L23:
            r0 = r4
            goto L26
        L25:
            r0 = r1
        L26:
            java.util.ArrayList r2 = r9.f65007a
            int r2 = r2.size()
            int r2 = r2 - r4
        L2d:
            if (r2 < 0) goto L58
            long r5 = r10.f65020b
            java.util.ArrayList r3 = r9.f65007a
            java.lang.Object r3 = r3.get(r2)
            i3.e r3 = (i3.e) r3
            long r7 = r3.f65020b
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L46
            java.util.ArrayList r11 = r9.f65007a
            int r2 = r2 + r4
            r11.add(r2, r10)
            return r0
        L46:
            java.util.ArrayList r3 = r9.f65007a
            java.lang.Object r3 = r3.get(r2)
            i3.e r3 = (i3.e) r3
            long r5 = r3.f65020b
            int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r3 > 0) goto L55
            r0 = r1
        L55:
            int r2 = r2 + (-1)
            goto L2d
        L58:
            java.util.ArrayList r11 = r9.f65007a
            r11.add(r1, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.f.d(i3.e, long):boolean");
    }

    @Override // i2.a
    public void e(long j11) {
        int f11 = f(j11);
        if (f11 == 0) {
            return;
        }
        long j12 = ((i3.e) this.f65007a.get(f11 - 1)).f65022d;
        if (j12 == C.TIME_UNSET || j12 >= j11) {
            f11--;
        }
        this.f65007a.subList(0, f11).clear();
    }
}
