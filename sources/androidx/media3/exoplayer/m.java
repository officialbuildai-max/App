package androidx.media3.exoplayer;

import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.u2;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class m implements u2 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.h f12186a;

    /* renamed from: b, reason: collision with root package name */
    private final long f12187b;

    /* renamed from: c, reason: collision with root package name */
    private final long f12188c;

    /* renamed from: d, reason: collision with root package name */
    private final long f12189d;

    /* renamed from: e, reason: collision with root package name */
    private final long f12190e;

    /* renamed from: f, reason: collision with root package name */
    private final int f12191f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f12192g;

    /* renamed from: h, reason: collision with root package name */
    private final long f12193h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f12194i;

    /* renamed from: j, reason: collision with root package name */
    private final HashMap f12195j;

    /* renamed from: k, reason: collision with root package name */
    private long f12196k;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private androidx.media3.exoplayer.upstream.h f12197a;

        /* renamed from: b, reason: collision with root package name */
        private int f12198b = DefaultLoadControl.DEFAULT_MAX_BUFFER_MS;

        /* renamed from: c, reason: collision with root package name */
        private int f12199c = DefaultLoadControl.DEFAULT_MAX_BUFFER_MS;

        /* renamed from: d, reason: collision with root package name */
        private int f12200d = 1000;

        /* renamed from: e, reason: collision with root package name */
        private int f12201e = 2000;

        /* renamed from: f, reason: collision with root package name */
        private int f12202f = -1;

        /* renamed from: g, reason: collision with root package name */
        private boolean f12203g = false;

        /* renamed from: h, reason: collision with root package name */
        private int f12204h = 0;

        /* renamed from: i, reason: collision with root package name */
        private boolean f12205i = false;

        /* renamed from: j, reason: collision with root package name */
        private boolean f12206j;

        public m a() {
            androidx.media3.common.util.a.g(!this.f12206j);
            this.f12206j = true;
            if (this.f12197a == null) {
                this.f12197a = new androidx.media3.exoplayer.upstream.h(true, 65536);
            }
            return new m(this.f12197a, this.f12198b, this.f12199c, this.f12200d, this.f12201e, this.f12202f, this.f12203g, this.f12204h, this.f12205i);
        }

        public b b(int i11, int i12, int i13, int i14) {
            androidx.media3.common.util.a.g(!this.f12206j);
            m.k(i13, 0, "bufferForPlaybackMs", "0");
            m.k(i14, 0, "bufferForPlaybackAfterRebufferMs", "0");
            m.k(i11, i13, "minBufferMs", "bufferForPlaybackMs");
            m.k(i11, i14, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            m.k(i12, i11, "maxBufferMs", "minBufferMs");
            this.f12198b = i11;
            this.f12199c = i12;
            this.f12200d = i13;
            this.f12201e = i14;
            return this;
        }

        public b c(boolean z10) {
            androidx.media3.common.util.a.g(!this.f12206j);
            this.f12203g = z10;
            return this;
        }

        public b d(int i11) {
            androidx.media3.common.util.a.g(!this.f12206j);
            this.f12202f = i11;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12207a;

        /* renamed from: b, reason: collision with root package name */
        public int f12208b;

        private c() {
        }
    }

    public m() {
        this(new androidx.media3.exoplayer.upstream.h(true, 65536), DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, 1000, 2000, -1, false, 0, false);
    }

    protected m(androidx.media3.exoplayer.upstream.h hVar, int i11, int i12, int i13, int i14, int i15, boolean z10, int i16, boolean z11) {
        k(i13, 0, "bufferForPlaybackMs", "0");
        k(i14, 0, "bufferForPlaybackAfterRebufferMs", "0");
        k(i11, i13, "minBufferMs", "bufferForPlaybackMs");
        k(i11, i14, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        k(i12, i11, "maxBufferMs", "minBufferMs");
        k(i16, 0, "backBufferDurationMs", "0");
        this.f12186a = hVar;
        this.f12187b = androidx.media3.common.util.a1.R0(i11);
        this.f12188c = androidx.media3.common.util.a1.R0(i12);
        this.f12189d = androidx.media3.common.util.a1.R0(i13);
        this.f12190e = androidx.media3.common.util.a1.R0(i14);
        this.f12191f = i15;
        this.f12192g = z10;
        this.f12193h = androidx.media3.common.util.a1.R0(i16);
        this.f12194i = z11;
        this.f12195j = new HashMap();
        this.f12196k = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(int i11, int i12, String str, String str2) {
        androidx.media3.common.util.a.b(i11 >= i12, str + " cannot be less than " + str2);
    }

    private static int n(int i11) {
        switch (i11) {
            case -2:
                return 0;
            case -1:
                return C.DEFAULT_VIDEO_BUFFER_SIZE;
            case 0:
                return 144310272;
            case 1:
                return C.DEFAULT_VIDEO_BUFFER_SIZE;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void o(y1.f4 f4Var) {
        if (this.f12195j.remove(f4Var) != null) {
            q();
        }
    }

    private void p(y1.f4 f4Var) {
        c cVar = (c) androidx.media3.common.util.a.e((c) this.f12195j.get(f4Var));
        int i11 = this.f12191f;
        if (i11 == -1) {
            i11 = C.DEFAULT_VIDEO_BUFFER_SIZE;
        }
        cVar.f12208b = i11;
        cVar.f12207a = false;
    }

    private void q() {
        if (this.f12195j.isEmpty()) {
            this.f12186a.d();
        } else {
            this.f12186a.e(m());
        }
    }

    @Override // androidx.media3.exoplayer.u2
    public boolean a(u2.a aVar) {
        long l02 = androidx.media3.common.util.a1.l0(aVar.f13014e, aVar.f13015f);
        long j11 = aVar.f13017h ? this.f12190e : this.f12189d;
        long j12 = aVar.f13018i;
        if (j12 != C.TIME_UNSET) {
            j11 = Math.min(j12 / 2, j11);
        }
        return j11 <= 0 || l02 >= j11 || (!this.f12192g && this.f12186a.c() >= m());
    }

    @Override // androidx.media3.exoplayer.u2
    public void b(y1.f4 f4Var) {
        o(f4Var);
        if (this.f12195j.isEmpty()) {
            this.f12196k = -1L;
        }
    }

    @Override // androidx.media3.exoplayer.u2
    public void c(y1.f4 f4Var) {
        long id2 = Thread.currentThread().getId();
        long j11 = this.f12196k;
        androidx.media3.common.util.a.h(j11 == -1 || j11 == id2, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.f12196k = id2;
        if (!this.f12195j.containsKey(f4Var)) {
            this.f12195j.put(f4Var, new c());
        }
        p(f4Var);
    }

    @Override // androidx.media3.exoplayer.u2
    public void d(y1.f4 f4Var) {
        o(f4Var);
    }

    @Override // androidx.media3.exoplayer.u2
    public boolean e(androidx.media3.common.e0 e0Var, r.b bVar, long j11) {
        Iterator it = this.f12195j.values().iterator();
        while (it.hasNext()) {
            if (((c) it.next()).f12207a) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.u2
    public boolean f(u2.a aVar) {
        c cVar = (c) androidx.media3.common.util.a.e((c) this.f12195j.get(aVar.f13010a));
        boolean z10 = true;
        boolean z11 = this.f12186a.c() >= m();
        long j11 = this.f12187b;
        float f11 = aVar.f13015f;
        if (f11 > 1.0f) {
            j11 = Math.min(androidx.media3.common.util.a1.g0(j11, f11), this.f12188c);
        }
        long max = Math.max(j11, 500000L);
        long j12 = aVar.f13014e;
        if (j12 < max) {
            if (!this.f12192g && z11) {
                z10 = false;
            }
            cVar.f12207a = z10;
            if (!z10 && j12 < 500000) {
                androidx.media3.common.util.u.h("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j12 >= this.f12188c || z11) {
            cVar.f12207a = false;
        }
        return cVar.f12207a;
    }

    @Override // androidx.media3.exoplayer.u2
    public void g(u2.a aVar, g2.z zVar, j2.z[] zVarArr) {
        c cVar = (c) androidx.media3.common.util.a.e((c) this.f12195j.get(aVar.f13010a));
        int i11 = this.f12191f;
        if (i11 == -1) {
            i11 = l(zVarArr);
        }
        cVar.f12208b = i11;
        q();
    }

    @Override // androidx.media3.exoplayer.u2
    public androidx.media3.exoplayer.upstream.b getAllocator() {
        return this.f12186a;
    }

    @Override // androidx.media3.exoplayer.u2
    public long h(y1.f4 f4Var) {
        return this.f12193h;
    }

    @Override // androidx.media3.exoplayer.u2
    public boolean i(y1.f4 f4Var) {
        return this.f12194i;
    }

    protected int l(j2.z[] zVarArr) {
        int i11 = 0;
        for (j2.z zVar : zVarArr) {
            if (zVar != null) {
                i11 += n(zVar.getTrackGroup().f10055c);
            }
        }
        return Math.max(C.DEFAULT_VIDEO_BUFFER_SIZE, i11);
    }

    int m() {
        Iterator it = this.f12195j.values().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i11 += ((c) it.next()).f12208b;
        }
        return i11;
    }
}
