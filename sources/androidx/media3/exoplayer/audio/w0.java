package androidx.media3.exoplayer.audio;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final /* synthetic */ class w0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f11324a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f11324a.post(runnable);
    }
}
