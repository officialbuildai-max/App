package androidx.media3.exoplayer.util;

import androidx.media3.common.util.m;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class b {

    /* loaded from: classes2.dex */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executor f13119a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f13120b;

        a(Executor executor, m mVar) {
            this.f13119a = executor;
            this.f13120b = mVar;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f13119a.execute(runnable);
        }

        @Override // androidx.media3.exoplayer.util.c
        public void release() {
            this.f13120b.accept(this.f13119a);
        }
    }

    public static c a(Executor executor, m mVar) {
        return new a(executor, mVar);
    }
}
