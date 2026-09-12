package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Looper;
import androidx.media3.common.util.g;
import androidx.media3.exoplayer.k4;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k4 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12140a;

    /* renamed from: b, reason: collision with root package name */
    private final b f12141b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.g f12142c;

    /* renamed from: d, reason: collision with root package name */
    private AudioManager f12143d;

    /* renamed from: e, reason: collision with root package name */
    private d f12144e;

    /* renamed from: f, reason: collision with root package name */
    private int f12145f;

    /* loaded from: classes2.dex */
    public interface b {
        void l(int i11);

        void r(int i11, boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f12146a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12147b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f12148c;

        /* renamed from: d, reason: collision with root package name */
        public final int f12149d;

        /* renamed from: e, reason: collision with root package name */
        public final int f12150e;

        public c(int i11, int i12, boolean z10, int i13, int i14) {
            this.f12146a = i11;
            this.f12147b = i12;
            this.f12148c = z10;
            this.f12149d = i13;
            this.f12150e = i14;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class d extends BroadcastReceiver {
        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (k4.this.f12144e == null) {
                return;
            }
            k4.this.f12142c.i(k4.this.j(((c) k4.this.f12142c.d()).f12146a));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            k4.this.f12142c.h(new Runnable() { // from class: androidx.media3.exoplayer.l4
                @Override // java.lang.Runnable
                public final void run() {
                    k4.d.this.b();
                }
            });
        }
    }

    public k4(Context context, b bVar, final int i11, Looper looper, Looper looper2, androidx.media3.common.util.i iVar) {
        this.f12140a = context.getApplicationContext();
        this.f12141b = bVar;
        androidx.media3.common.util.g gVar = new androidx.media3.common.util.g(new c(i11, 0, false, 0, 0), looper, looper2, iVar, new g.a() { // from class: androidx.media3.exoplayer.e4
            @Override // androidx.media3.common.util.g.a
            public final void a(Object obj, Object obj2) {
                k4.this.s((k4.c) obj, (k4.c) obj2);
            }
        });
        this.f12142c = gVar;
        gVar.h(new Runnable() { // from class: androidx.media3.exoplayer.f4
            @Override // java.lang.Runnable
            public final void run() {
                k4.this.n(i11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c j(int i11) {
        androidx.media3.common.util.a.e(this.f12143d);
        return new c(i11, t1.m.f(this.f12143d, i11), t1.m.g(this.f12143d, i11), t1.m.e(this.f12143d, i11), t1.m.d(this.f12143d, i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(int i11) {
        this.f12143d = (AudioManager) androidx.media3.common.util.a.i((AudioManager) this.f12140a.getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        d dVar = new d();
        try {
            this.f12140a.registerReceiver(dVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f12144e = dVar;
        } catch (RuntimeException e11) {
            androidx.media3.common.util.u.i("StreamVolumeManager", "Error registering stream volume receiver", e11);
        }
        this.f12142c.i(j(i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c o(c cVar) {
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ c p(c cVar) {
        d dVar = this.f12144e;
        if (dVar != null) {
            try {
                this.f12140a.unregisterReceiver(dVar);
            } catch (RuntimeException e11) {
                androidx.media3.common.util.u.i("StreamVolumeManager", "Error unregistering stream volume receiver", e11);
            }
            this.f12144e = null;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ c q(boolean z10, int i11, c cVar) {
        if (cVar.f12148c == z10) {
            return cVar;
        }
        androidx.media3.common.util.a.e(this.f12143d);
        if (androidx.media3.common.util.a1.f10432a >= 23) {
            this.f12143d.adjustStreamVolume(cVar.f12146a, z10 ? -100 : 100, i11);
        } else {
            this.f12143d.setStreamMute(cVar.f12146a, z10);
        }
        return j(cVar.f12146a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ c r(boolean z10, c cVar) {
        return new c(cVar.f12146a, cVar.f12148c == z10 ? cVar.f12147b : z10 ? 0 : this.f12145f, z10, cVar.f12149d, cVar.f12150e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(c cVar, c cVar2) {
        boolean z10 = cVar.f12148c;
        if (!z10 && cVar2.f12148c) {
            this.f12145f = cVar.f12147b;
        }
        int i11 = cVar.f12147b;
        int i12 = cVar2.f12147b;
        if (i11 != i12 || z10 != cVar2.f12148c) {
            this.f12141b.r(i12, cVar2.f12148c);
        }
        int i13 = cVar.f12146a;
        int i14 = cVar2.f12146a;
        if (i13 == i14 && cVar.f12149d == cVar2.f12149d && cVar.f12150e == cVar2.f12150e) {
            return;
        }
        this.f12141b.l(i14);
    }

    public int k() {
        return ((c) this.f12142c.d()).f12150e;
    }

    public int l() {
        return ((c) this.f12142c.d()).f12149d;
    }

    public boolean m() {
        return ((c) this.f12142c.d()).f12148c;
    }

    public void t() {
        this.f12142c.j(new com.google.common.base.f() { // from class: androidx.media3.exoplayer.i4
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                k4.c o11;
                o11 = k4.o((k4.c) obj);
                return o11;
            }
        }, new com.google.common.base.f() { // from class: androidx.media3.exoplayer.j4
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                k4.c p11;
                p11 = k4.this.p((k4.c) obj);
                return p11;
            }
        });
    }

    public void u(final boolean z10, final int i11) {
        this.f12142c.j(new com.google.common.base.f() { // from class: androidx.media3.exoplayer.g4
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                k4.c r11;
                r11 = k4.this.r(z10, (k4.c) obj);
                return r11;
            }
        }, new com.google.common.base.f() { // from class: androidx.media3.exoplayer.h4
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                k4.c q11;
                q11 = k4.this.q(z10, i11, (k4.c) obj);
                return q11;
            }
        });
    }
}
