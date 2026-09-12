package t9;

import com.google.android.exoplayer2.source.b0;

/* loaded from: classes4.dex */
public class c implements b0 {

    /* renamed from: a, reason: collision with root package name */
    protected final b0[] f76220a;

    public c(b0[] b0VarArr) {
        this.f76220a = b0VarArr;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public boolean continueLoading(long j11) {
        boolean z10;
        boolean z11 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            z10 = false;
            for (b0 b0Var : this.f76220a) {
                long nextLoadPositionUs2 = b0Var.getNextLoadPositionUs();
                boolean z12 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= j11;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z12) {
                    z10 |= b0Var.continueLoading(j11);
                }
            }
            z11 |= z10;
        } while (z10);
        return z11;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public final long getBufferedPositionUs() {
        long j11 = Long.MAX_VALUE;
        for (b0 b0Var : this.f76220a) {
            long bufferedPositionUs = b0Var.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                j11 = Math.min(j11, bufferedPositionUs);
            }
        }
        if (j11 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public final long getNextLoadPositionUs() {
        long j11 = Long.MAX_VALUE;
        for (b0 b0Var : this.f76220a) {
            long nextLoadPositionUs = b0Var.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                j11 = Math.min(j11, nextLoadPositionUs);
            }
        }
        if (j11 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public boolean isLoading() {
        for (b0 b0Var : this.f76220a) {
            if (b0Var.isLoading()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public final void reevaluateBuffer(long j11) {
        for (b0 b0Var : this.f76220a) {
            b0Var.reevaluateBuffer(j11);
        }
    }
}
