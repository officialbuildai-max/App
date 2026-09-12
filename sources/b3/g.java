package b3;

import androidx.media3.common.util.j0;
import androidx.media3.common.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public final class g extends b {

    /* renamed from: a, reason: collision with root package name */
    public final long f16292a;

    /* renamed from: b, reason: collision with root package name */
    public final long f16293b;

    private g(long j11, long j12) {
        this.f16292a = j11;
        this.f16293b = j12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g b(j0 j0Var, long j11, p0 p0Var) {
        long c11 = c(j0Var, j11);
        return new g(c11, p0Var.b(c11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long c(j0 j0Var, long j11) {
        long H = j0Var.H();
        return (128 & H) != 0 ? 8589934591L & ((((H & 1) << 32) | j0Var.J()) + j11) : C.TIME_UNSET;
    }

    @Override // b3.b
    public String toString() {
        return "SCTE-35 TimeSignalCommand { ptsTime=" + this.f16292a + ", playbackPositionUs= " + this.f16293b + " }";
    }
}
