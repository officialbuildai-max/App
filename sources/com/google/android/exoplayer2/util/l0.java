package com.google.android.exoplayer2.util;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes3.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    private long f27657a;

    /* renamed from: b, reason: collision with root package name */
    private long f27658b;

    /* renamed from: c, reason: collision with root package name */
    private long f27659c;

    /* renamed from: d, reason: collision with root package name */
    private final ThreadLocal f27660d = new ThreadLocal();

    public l0(long j11) {
        g(j11);
    }

    public static long f(long j11) {
        return (j11 * 1000000) / 90000;
    }

    public static long i(long j11) {
        return (j11 * 90000) / 1000000;
    }

    public static long j(long j11) {
        return i(j11) % 8589934592L;
    }

    public synchronized long a(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        try {
            if (this.f27658b == C.TIME_UNSET) {
                long j12 = this.f27657a;
                if (j12 == 9223372036854775806L) {
                    j12 = ((Long) a.e((Long) this.f27660d.get())).longValue();
                }
                this.f27658b = j12 - j11;
                notifyAll();
            }
            this.f27659c = j11;
            return j11 + this.f27658b;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long b(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        try {
            long j12 = this.f27659c;
            if (j12 != C.TIME_UNSET) {
                long i11 = i(j12);
                long j13 = (TmcConstants.TEMP_FILE_RUNTIME_MAX_SIZE + i11) / 8589934592L;
                long j14 = ((j13 - 1) * 8589934592L) + j11;
                j11 += j13 * 8589934592L;
                if (Math.abs(j14 - i11) < Math.abs(j11 - i11)) {
                    j11 = j14;
                }
            }
            return a(f(j11));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long c() {
        long j11;
        j11 = this.f27657a;
        if (j11 == Long.MAX_VALUE || j11 == 9223372036854775806L) {
            j11 = C.TIME_UNSET;
        }
        return j11;
    }

    public synchronized long d() {
        long j11;
        try {
            j11 = this.f27659c;
        } catch (Throwable th2) {
            throw th2;
        }
        return j11 != C.TIME_UNSET ? j11 + this.f27658b : c();
    }

    public synchronized long e() {
        return this.f27658b;
    }

    public synchronized void g(long j11) {
        this.f27657a = j11;
        this.f27658b = j11 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f27659c = C.TIME_UNSET;
    }

    public synchronized void h(boolean z10, long j11) {
        try {
            a.g(this.f27657a == 9223372036854775806L);
            if (this.f27658b != C.TIME_UNSET) {
                return;
            }
            if (z10) {
                this.f27660d.set(Long.valueOf(j11));
            } else {
                while (this.f27658b == C.TIME_UNSET) {
                    wait();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
