package i3;

import androidx.media3.common.util.a1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public final class g implements k {

    /* renamed from: c, reason: collision with root package name */
    private static final Ordering f65023c = Ordering.natural().onResultOf(new com.google.common.base.f() { // from class: i3.f
        @Override // com.google.common.base.f
        public final Object apply(Object obj) {
            Comparable c11;
            c11 = g.c((e) obj);
            return c11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableList f65024a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f65025b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g(java.util.List r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = 2
            r2 = 0
            r17.<init>()
            int r3 = r18.size()
            r4 = 1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 != r4) goto L4c
            java.lang.Object r3 = com.google.common.collect.g3.j(r18)
            i3.e r3 = (i3.e) r3
            long r7 = r3.f65020b
            long r7 = d(r7)
            long r9 = r3.f65021c
            int r5 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r5 != 0) goto L34
            com.google.common.collect.ImmutableList r1 = r3.f65019a
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.of(r1)
            r0.f65024a = r1
            long[] r1 = new long[r4]
            r1[r2] = r7
            r0.f65025b = r1
            goto L4b
        L34:
            com.google.common.collect.ImmutableList r5 = r3.f65019a
            com.google.common.collect.ImmutableList r6 = com.google.common.collect.ImmutableList.of()
            com.google.common.collect.ImmutableList r5 = com.google.common.collect.ImmutableList.of(r5, r6)
            r0.f65024a = r5
            long r5 = r3.f65021c
            long r5 = r5 + r7
            long[] r1 = new long[r1]
            r1[r2] = r7
            r1[r4] = r5
            r0.f65025b = r1
        L4b:
            return
        L4c:
            int r3 = r18.size()
            int r3 = r3 * r1
            long[] r1 = new long[r3]
            r0.f65025b = r1
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.util.Arrays.fill(r1, r7)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.google.common.collect.Ordering r3 = i3.g.f65023c
            r7 = r18
            com.google.common.collect.ImmutableList r3 = com.google.common.collect.ImmutableList.sortedCopyOf(r3, r7)
            r7 = r2
        L6b:
            int r8 = r3.size()
            if (r2 >= r8) goto Ld6
            java.lang.Object r8 = r3.get(r2)
            i3.e r8 = (i3.e) r8
            long r9 = r8.f65020b
            long r9 = d(r9)
            long r11 = r8.f65021c
            long r11 = r11 + r9
            if (r7 == 0) goto Lb4
            long[] r13 = r0.f65025b
            int r14 = r7 + (-1)
            r15 = r13[r14]
            int r13 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r13 >= 0) goto L8d
            goto Lb4
        L8d:
            int r13 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r13 != 0) goto La3
            java.lang.Object r13 = r1.get(r14)
            com.google.common.collect.ImmutableList r13 = (com.google.common.collect.ImmutableList) r13
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto La3
            com.google.common.collect.ImmutableList r9 = r8.f65019a
            r1.set(r14, r9)
            goto Lc0
        La3:
            java.lang.String r13 = "CuesWithTimingSubtitle"
            java.lang.String r15 = "Truncating unsupported overlapping cues."
            androidx.media3.common.util.u.h(r13, r15)
            long[] r13 = r0.f65025b
            r13[r14] = r9
            com.google.common.collect.ImmutableList r9 = r8.f65019a
            r1.set(r14, r9)
            goto Lc0
        Lb4:
            long[] r13 = r0.f65025b
            int r14 = r7 + 1
            r13[r7] = r9
            com.google.common.collect.ImmutableList r7 = r8.f65019a
            r1.add(r7)
            r7 = r14
        Lc0:
            long r8 = r8.f65021c
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 == 0) goto Ld4
            long[] r8 = r0.f65025b
            int r9 = r7 + 1
            r8[r7] = r11
            com.google.common.collect.ImmutableList r7 = com.google.common.collect.ImmutableList.of()
            r1.add(r7)
            r7 = r9
        Ld4:
            int r2 = r2 + r4
            goto L6b
        Ld6:
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.copyOf(r1)
            r0.f65024a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.g.<init>(java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Comparable c(e eVar) {
        return Long.valueOf(d(eVar.f65020b));
    }

    private static long d(long j11) {
        if (j11 == C.TIME_UNSET) {
            return 0L;
        }
        return j11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i3.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ImmutableList getCues(long j11) {
        int h11 = a1.h(this.f65025b, j11, true, false);
        return h11 == -1 ? ImmutableList.of() : (ImmutableList) this.f65024a.get(h11);
    }

    @Override // i3.k
    public long getEventTime(int i11) {
        androidx.media3.common.util.a.a(i11 < this.f65024a.size());
        return this.f65025b[i11];
    }

    @Override // i3.k
    public int getEventTimeCount() {
        return this.f65024a.size();
    }

    @Override // i3.k
    public int getNextEventTimeIndex(long j11) {
        int d11 = a1.d(this.f65025b, j11, false, false);
        if (d11 < this.f65024a.size()) {
            return d11;
        }
        return -1;
    }
}
