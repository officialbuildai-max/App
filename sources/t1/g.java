package t1;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.media3.common.util.a1;
import java.util.Objects;
import t1.g;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final int f76093a;

    /* renamed from: b, reason: collision with root package name */
    private final AudioManager.OnAudioFocusChangeListener f76094b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f76095c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.common.c f76096d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f76097e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f76098f;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private int f76099a;

        /* renamed from: b, reason: collision with root package name */
        private AudioManager.OnAudioFocusChangeListener f76100b;

        /* renamed from: c, reason: collision with root package name */
        private Handler f76101c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.media3.common.c f76102d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f76103e;

        public b(int i11) {
            this.f76102d = androidx.media3.common.c.f9989g;
            this.f76099a = i11;
        }

        private b(g gVar) {
            this.f76099a = gVar.e();
            this.f76100b = gVar.f();
            this.f76101c = gVar.d();
            this.f76102d = gVar.b();
            this.f76103e = gVar.g();
        }

        public g a() {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f76100b;
            if (onAudioFocusChangeListener != null) {
                return new g(this.f76099a, onAudioFocusChangeListener, (Handler) androidx.media3.common.util.a.e(this.f76101c), this.f76102d, this.f76103e);
            }
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }

        public b b(androidx.media3.common.c cVar) {
            androidx.media3.common.util.a.e(cVar);
            this.f76102d = cVar;
            return this;
        }

        public b c(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            androidx.media3.common.util.a.e(onAudioFocusChangeListener);
            androidx.media3.common.util.a.e(handler);
            this.f76100b = onAudioFocusChangeListener;
            this.f76101c = handler;
            return this;
        }

        public b d(boolean z10) {
            this.f76103e = z10;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f76104a;

        /* renamed from: b, reason: collision with root package name */
        private final AudioManager.OnAudioFocusChangeListener f76105b;

        c(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            this.f76105b = onAudioFocusChangeListener;
            this.f76104a = a1.z(handler.getLooper(), null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i11) {
            this.f76105b.onAudioFocusChange(i11);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i11) {
            a1.b1(this.f76104a, new Runnable() { // from class: t1.h
                @Override // java.lang.Runnable
                public final void run() {
                    g.c.this.b(i11);
                }
            });
        }
    }

    g(int i11, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, androidx.media3.common.c cVar, boolean z10) {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder willPauseWhenDucked;
        AudioFocusRequest.Builder onAudioFocusChangeListener2;
        AudioFocusRequest build;
        this.f76093a = i11;
        this.f76095c = handler;
        this.f76096d = cVar;
        this.f76097e = z10;
        int i12 = a1.f10432a;
        if (i12 < 26) {
            this.f76094b = new c(onAudioFocusChangeListener, handler);
        } else {
            this.f76094b = onAudioFocusChangeListener;
        }
        if (i12 < 26) {
            this.f76098f = null;
            return;
        }
        audioAttributes = t1.a.a(i11).setAudioAttributes(cVar.a().f10001a);
        willPauseWhenDucked = audioAttributes.setWillPauseWhenDucked(z10);
        onAudioFocusChangeListener2 = willPauseWhenDucked.setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler);
        build = onAudioFocusChangeListener2.build();
        this.f76098f = build;
    }

    public b a() {
        return new b();
    }

    public androidx.media3.common.c b() {
        return this.f76096d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioFocusRequest c() {
        return f.a(androidx.media3.common.util.a.e(this.f76098f));
    }

    public Handler d() {
        return this.f76095c;
    }

    public int e() {
        return this.f76093a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f76093a == gVar.f76093a && this.f76097e == gVar.f76097e && Objects.equals(this.f76094b, gVar.f76094b) && Objects.equals(this.f76095c, gVar.f76095c) && Objects.equals(this.f76096d, gVar.f76096d);
    }

    public AudioManager.OnAudioFocusChangeListener f() {
        return this.f76094b;
    }

    public boolean g() {
        return this.f76097e;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f76093a), this.f76094b, this.f76095c, this.f76096d, Boolean.valueOf(this.f76097e));
    }
}
