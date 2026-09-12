package com.google.android.exoplayer2.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes3.dex */
final class s {

    /* renamed from: a, reason: collision with root package name */
    private final a f24791a;

    /* renamed from: b, reason: collision with root package name */
    private int f24792b;

    /* renamed from: c, reason: collision with root package name */
    private long f24793c;

    /* renamed from: d, reason: collision with root package name */
    private long f24794d;

    /* renamed from: e, reason: collision with root package name */
    private long f24795e;

    /* renamed from: f, reason: collision with root package name */
    private long f24796f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final AudioTrack f24797a;

        /* renamed from: b, reason: collision with root package name */
        private final AudioTimestamp f24798b = new AudioTimestamp();

        /* renamed from: c, reason: collision with root package name */
        private long f24799c;

        /* renamed from: d, reason: collision with root package name */
        private long f24800d;

        /* renamed from: e, reason: collision with root package name */
        private long f24801e;

        public a(AudioTrack audioTrack) {
            this.f24797a = audioTrack;
        }

        public long a() {
            return this.f24801e;
        }

        public long b() {
            return this.f24798b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f24797a.getTimestamp(this.f24798b);
            if (timestamp) {
                long j11 = this.f24798b.framePosition;
                if (this.f24800d > j11) {
                    this.f24799c++;
                }
                this.f24800d = j11;
                this.f24801e = j11 + (this.f24799c << 32);
            }
            return timestamp;
        }
    }

    public s(AudioTrack audioTrack) {
        if (p0.f27680a >= 19) {
            this.f24791a = new a(audioTrack);
            g();
        } else {
            this.f24791a = null;
            h(3);
        }
    }

    private void h(int i11) {
        this.f24792b = i11;
        if (i11 == 0) {
            this.f24795e = 0L;
            this.f24796f = -1L;
            this.f24793c = System.nanoTime() / 1000;
            this.f24794d = 10000L;
            return;
        }
        if (i11 == 1) {
            this.f24794d = 10000L;
            return;
        }
        if (i11 == 2 || i11 == 3) {
            this.f24794d = 10000000L;
        } else {
            if (i11 != 4) {
                throw new IllegalStateException();
            }
            this.f24794d = 500000L;
        }
    }

    public void a() {
        if (this.f24792b == 4) {
            g();
        }
    }

    public long b() {
        a aVar = this.f24791a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    public long c() {
        a aVar = this.f24791a;
        return aVar != null ? aVar.b() : C.TIME_UNSET;
    }

    public boolean d() {
        return this.f24792b == 2;
    }

    public boolean e(long j11) {
        a aVar = this.f24791a;
        if (aVar == null || j11 - this.f24795e < this.f24794d) {
            return false;
        }
        this.f24795e = j11;
        boolean c11 = aVar.c();
        int i11 = this.f24792b;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (c11) {
                        g();
                    }
                } else if (!c11) {
                    g();
                }
            } else if (!c11) {
                g();
            } else if (this.f24791a.a() > this.f24796f) {
                h(2);
            }
        } else if (c11) {
            if (this.f24791a.b() < this.f24793c) {
                return false;
            }
            this.f24796f = this.f24791a.a();
            h(1);
        } else if (j11 - this.f24793c > 500000) {
            h(3);
        }
        return c11;
    }

    public void f() {
        h(4);
    }

    public void g() {
        if (this.f24791a != null) {
            h(0);
        }
    }
}
