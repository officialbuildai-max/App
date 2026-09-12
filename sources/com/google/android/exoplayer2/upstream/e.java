package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import com.google.android.exoplayer2.upstream.e;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public interface e {

    /* loaded from: classes3.dex */
    public interface a {

        /* renamed from: com.google.android.exoplayer2.upstream.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0382a {

            /* renamed from: a, reason: collision with root package name */
            private final CopyOnWriteArrayList f27450a = new CopyOnWriteArrayList();

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: com.google.android.exoplayer2.upstream.e$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0383a {

                /* renamed from: a, reason: collision with root package name */
                private final Handler f27451a;

                /* renamed from: b, reason: collision with root package name */
                private final a f27452b;

                /* renamed from: c, reason: collision with root package name */
                private boolean f27453c;

                public C0383a(Handler handler, a aVar) {
                    this.f27451a = handler;
                    this.f27452b = aVar;
                }

                public void d() {
                    this.f27453c = true;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void d(C0383a c0383a, int i11, long j11, long j12) {
                c0383a.f27452b.onBandwidthSample(i11, j11, j12);
            }

            public void b(Handler handler, a aVar) {
                com.google.android.exoplayer2.util.a.e(handler);
                com.google.android.exoplayer2.util.a.e(aVar);
                e(aVar);
                this.f27450a.add(new C0383a(handler, aVar));
            }

            public void c(final int i11, final long j11, final long j12) {
                Iterator it = this.f27450a.iterator();
                while (it.hasNext()) {
                    final C0383a c0383a = (C0383a) it.next();
                    if (!c0383a.f27453c) {
                        c0383a.f27451a.post(new Runnable() { // from class: com.google.android.exoplayer2.upstream.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.a.C0382a.d(e.a.C0382a.C0383a.this, i11, j11, j12);
                            }
                        });
                    }
                }
            }

            public void e(a aVar) {
                Iterator it = this.f27450a.iterator();
                while (it.hasNext()) {
                    C0383a c0383a = (C0383a) it.next();
                    if (c0383a.f27452b == aVar) {
                        c0383a.d();
                        this.f27450a.remove(c0383a);
                    }
                }
            }
        }

        void onBandwidthSample(int i11, long j11, long j12);
    }

    long a();

    k0 b();

    void d(a aVar);

    void f(Handler handler, a aVar);

    long getBitrateEstimate();
}
