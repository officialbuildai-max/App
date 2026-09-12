package i2;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class e implements a {

    /* renamed from: b, reason: collision with root package name */
    private static final Ordering f65005b = Ordering.natural().onResultOf(new com.google.common.base.f() { // from class: i2.c
        @Override // com.google.common.base.f
        public final Object apply(Object obj) {
            Long h11;
            h11 = e.h((i3.e) obj);
            return h11;
        }
    }).compound(Ordering.natural().reverse().onResultOf(new com.google.common.base.f() { // from class: i2.d
        @Override // com.google.common.base.f
        public final Object apply(Object obj) {
            Long i11;
            i11 = e.i((i3.e) obj);
            return i11;
        }
    }));

    /* renamed from: a, reason: collision with root package name */
    private final List f65006a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long h(i3.e eVar) {
        return Long.valueOf(eVar.f65020b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long i(i3.e eVar) {
        return Long.valueOf(eVar.f65021c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i2.a
    public ImmutableList a(long j11) {
        if (!this.f65006a.isEmpty()) {
            if (j11 >= ((i3.e) this.f65006a.get(0)).f65020b) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < this.f65006a.size(); i11++) {
                    i3.e eVar = (i3.e) this.f65006a.get(i11);
                    if (j11 >= eVar.f65020b && j11 < eVar.f65022d) {
                        arrayList.add(eVar);
                    }
                    if (j11 < eVar.f65020b) {
                        break;
                    }
                }
                ImmutableList sortedCopyOf = ImmutableList.sortedCopyOf(f65005b, arrayList);
                ImmutableList.a builder = ImmutableList.builder();
                for (int i12 = 0; i12 < sortedCopyOf.size(); i12++) {
                    builder.l(((i3.e) sortedCopyOf.get(i12)).f65019a);
                }
                return builder.e();
            }
        }
        return ImmutableList.of();
    }

    @Override // i2.a
    public long b(long j11) {
        if (this.f65006a.isEmpty()) {
            return C.TIME_UNSET;
        }
        if (j11 < ((i3.e) this.f65006a.get(0)).f65020b) {
            return C.TIME_UNSET;
        }
        long j12 = ((i3.e) this.f65006a.get(0)).f65020b;
        for (int i11 = 0; i11 < this.f65006a.size(); i11++) {
            long j13 = ((i3.e) this.f65006a.get(i11)).f65020b;
            long j14 = ((i3.e) this.f65006a.get(i11)).f65022d;
            if (j14 > j11) {
                if (j13 > j11) {
                    break;
                }
                j12 = Math.max(j12, j13);
            } else {
                j12 = Math.max(j12, j14);
            }
        }
        return j12;
    }

    @Override // i2.a
    public long c(long j11) {
        int i11 = 0;
        long j12 = -9223372036854775807L;
        while (true) {
            if (i11 >= this.f65006a.size()) {
                break;
            }
            long j13 = ((i3.e) this.f65006a.get(i11)).f65020b;
            long j14 = ((i3.e) this.f65006a.get(i11)).f65022d;
            if (j11 < j13) {
                j12 = j12 == C.TIME_UNSET ? j13 : Math.min(j12, j13);
            } else {
                if (j11 < j14) {
                    j12 = j12 == C.TIME_UNSET ? j14 : Math.min(j12, j14);
                }
                i11++;
            }
        }
        if (j12 != C.TIME_UNSET) {
            return j12;
        }
        return Long.MIN_VALUE;
    }

    @Override // i2.a
    public void clear() {
        this.f65006a.clear();
    }

    @Override // i2.a
    public boolean d(i3.e eVar, long j11) {
        androidx.media3.common.util.a.a(eVar.f65020b != C.TIME_UNSET);
        androidx.media3.common.util.a.a(eVar.f65021c != C.TIME_UNSET);
        boolean z10 = eVar.f65020b <= j11 && j11 < eVar.f65022d;
        for (int size = this.f65006a.size() - 1; size >= 0; size--) {
            if (eVar.f65020b >= ((i3.e) this.f65006a.get(size)).f65020b) {
                this.f65006a.add(size + 1, eVar);
                return z10;
            }
        }
        this.f65006a.add(0, eVar);
        return z10;
    }

    @Override // i2.a
    public void e(long j11) {
        int i11 = 0;
        while (i11 < this.f65006a.size()) {
            long j12 = ((i3.e) this.f65006a.get(i11)).f65020b;
            if (j11 > j12 && j11 > ((i3.e) this.f65006a.get(i11)).f65022d) {
                this.f65006a.remove(i11);
                i11--;
            } else if (j11 < j12) {
                return;
            }
            i11++;
        }
    }
}
