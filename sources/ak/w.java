package ak;

import android.support.v4.media.session.PlaybackStateCompat;

/* loaded from: classes5.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final w f730a = new w();

    /* renamed from: b, reason: collision with root package name */
    private static long f731b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static long f732c;

    private w() {
    }

    private final long a() {
        return System.currentTimeMillis();
    }

    private final long c(long j11) {
        long a11 = a();
        while (a11 <= j11) {
            a11 = a();
        }
        return a11;
    }

    public final synchronized long b() {
        long a11;
        try {
            a11 = a();
            long j11 = f731b;
            if (a11 < j11) {
                throw new IllegalStateException(("系统时钟回拨，拒绝生成 ID（lastTimestamp=" + j11 + ", now=" + a11 + "）").toString());
            }
            if (a11 == j11) {
                long j12 = (f732c + 1) & 4095;
                f732c = j12;
                if (j12 == 0) {
                    a11 = c(j11);
                }
            } else {
                f732c = 0L;
            }
            f731b = a11;
        } catch (Throwable th2) {
            throw th2;
        }
        return ((a11 - 1704067200000L) << 22) | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM | f732c;
    }
}
