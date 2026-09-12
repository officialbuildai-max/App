package androidx.media3.exoplayer.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final a f11173a;

    /* renamed from: b, reason: collision with root package name */
    private int f11174b;

    /* renamed from: c, reason: collision with root package name */
    private long f11175c;

    /* renamed from: d, reason: collision with root package name */
    private long f11176d;

    /* renamed from: e, reason: collision with root package name */
    private long f11177e;

    /* renamed from: f, reason: collision with root package name */
    private long f11178f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final AudioTrack f11179a;

        /* renamed from: b, reason: collision with root package name */
        private final AudioTimestamp f11180b = new AudioTimestamp();

        /* renamed from: c, reason: collision with root package name */
        private long f11181c;

        /* renamed from: d, reason: collision with root package name */
        private long f11182d;

        /* renamed from: e, reason: collision with root package name */
        private long f11183e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f11184f;

        /* renamed from: g, reason: collision with root package name */
        private long f11185g;

        public a(AudioTrack audioTrack) {
            this.f11179a = audioTrack;
        }

        public void a() {
            this.f11184f = true;
        }

        public long b() {
            return this.f11183e;
        }

        public long c() {
            return this.f11180b.nanoTime / 1000;
        }

        public boolean d() {
            boolean timestamp = this.f11179a.getTimestamp(this.f11180b);
            if (timestamp) {
                long j11 = this.f11180b.framePosition;
                long j12 = this.f11182d;
                if (j12 > j11) {
                    if (this.f11184f) {
                        this.f11185g += j12;
                        this.f11184f = false;
                    } else {
                        this.f11181c++;
                    }
                }
                this.f11182d = j11;
                this.f11183e = j11 + this.f11185g + (this.f11181c << 32);
            }
            return timestamp;
        }
    }

    public a0(AudioTrack audioTrack) {
        this.f11173a = new a(audioTrack);
        h();
    }

    private void i(int i11) {
        this.f11174b = i11;
        if (i11 == 0) {
            this.f11177e = 0L;
            this.f11178f = -1L;
            this.f11175c = System.nanoTime() / 1000;
            this.f11176d = 10000L;
            return;
        }
        if (i11 == 1) {
            this.f11176d = 10000L;
            return;
        }
        if (i11 == 2 || i11 == 3) {
            this.f11176d = 10000000L;
        } else {
            if (i11 != 4) {
                throw new IllegalStateException();
            }
            this.f11176d = 500000L;
        }
    }

    public void a() {
        if (this.f11174b == 4) {
            h();
        }
    }

    public void b() {
        a aVar = this.f11173a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public long c() {
        a aVar = this.f11173a;
        if (aVar != null) {
            return aVar.b();
        }
        return -1L;
    }

    public long d() {
        a aVar = this.f11173a;
        return aVar != null ? aVar.c() : C.TIME_UNSET;
    }

    public boolean e() {
        return this.f11174b == 2;
    }

    public boolean f(long j11) {
        a aVar = this.f11173a;
        if (aVar == null || j11 - this.f11177e < this.f11176d) {
            return false;
        }
        this.f11177e = j11;
        boolean d11 = aVar.d();
        int i11 = this.f11174b;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (d11) {
                        h();
                    }
                } else if (!d11) {
                    h();
                }
            } else if (!d11) {
                h();
            } else if (this.f11173a.b() > this.f11178f) {
                i(2);
            }
        } else if (d11) {
            if (this.f11173a.c() < this.f11175c) {
                return false;
            }
            this.f11178f = this.f11173a.b();
            i(1);
        } else if (j11 - this.f11175c > 500000) {
            i(3);
        }
        return d11;
    }

    public void g() {
        i(4);
    }

    public void h() {
        if (this.f11173a != null) {
            i(0);
        }
    }
}
