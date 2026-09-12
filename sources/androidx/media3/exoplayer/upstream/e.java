package androidx.media3.exoplayer.upstream;

import android.os.Handler;
import androidx.media3.exoplayer.upstream.e;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public interface e {

    /* loaded from: classes2.dex */
    public interface a {

        /* renamed from: androidx.media3.exoplayer.upstream.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0110a {

            /* renamed from: a, reason: collision with root package name */
            private final CopyOnWriteArrayList f13044a = new CopyOnWriteArrayList();

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: androidx.media3.exoplayer.upstream.e$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0111a {

                /* renamed from: a, reason: collision with root package name */
                private final Handler f13045a;

                /* renamed from: b, reason: collision with root package name */
                private final a f13046b;

                /* renamed from: c, reason: collision with root package name */
                private boolean f13047c;

                public C0111a(Handler handler, a aVar) {
                    this.f13045a = handler;
                    this.f13046b = aVar;
                }

                public void d() {
                    this.f13047c = true;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void d(C0111a c0111a, int i11, long j11, long j12) {
                c0111a.f13046b.onBandwidthSample(i11, j11, j12);
            }

            public void b(Handler handler, a aVar) {
                androidx.media3.common.util.a.e(handler);
                androidx.media3.common.util.a.e(aVar);
                e(aVar);
                this.f13044a.add(new C0111a(handler, aVar));
            }

            public void c(final int i11, final long j11, final long j12) {
                Iterator it = this.f13044a.iterator();
                while (it.hasNext()) {
                    final C0111a c0111a = (C0111a) it.next();
                    if (!c0111a.f13047c) {
                        c0111a.f13045a.post(new Runnable() { // from class: androidx.media3.exoplayer.upstream.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.a.C0110a.d(e.a.C0110a.C0111a.this, i11, j11, j12);
                            }
                        });
                    }
                }
            }

            public void e(a aVar) {
                Iterator it = this.f13044a.iterator();
                while (it.hasNext()) {
                    C0111a c0111a = (C0111a) it.next();
                    if (c0111a.f13046b == aVar) {
                        c0111a.d();
                        this.f13044a.remove(c0111a);
                    }
                }
            }
        }

        void onBandwidthSample(int i11, long j11, long j12);
    }

    long a();

    w1.n b();

    void c(a aVar);

    void d(Handler handler, a aVar);

    long getBitrateEstimate();
}
