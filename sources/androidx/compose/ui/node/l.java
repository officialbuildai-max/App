package androidx.compose.ui.node;

/* loaded from: classes.dex */
abstract class l {
    public static final int a(long j11, long j12) {
        boolean d11 = d(j11);
        return d11 != d(j12) ? d11 ? -1 : 1 : (int) Math.signum(c(j11) - c(j12));
    }

    public static long b(long j11) {
        return j11;
    }

    public static final float c(long j11) {
        return Float.intBitsToFloat((int) (j11 >> 32));
    }

    public static final boolean d(long j11) {
        return ((int) (j11 & 4294967295L)) != 0;
    }
}
