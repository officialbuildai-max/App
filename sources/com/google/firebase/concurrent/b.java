package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b implements ThreadFactory {

    /* renamed from: e, reason: collision with root package name */
    private static final ThreadFactory f31136e = Executors.defaultThreadFactory();

    /* renamed from: a, reason: collision with root package name */
    private final AtomicLong f31137a = new AtomicLong();

    /* renamed from: b, reason: collision with root package name */
    private final String f31138b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31139c;

    /* renamed from: d, reason: collision with root package name */
    private final StrictMode.ThreadPolicy f31140d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, int i11, StrictMode.ThreadPolicy threadPolicy) {
        this.f31138b = str;
        this.f31139c = i11;
        this.f31140d = threadPolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        Process.setThreadPriority(this.f31139c);
        StrictMode.ThreadPolicy threadPolicy = this.f31140d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread newThread = f31136e.newThread(new Runnable() { // from class: com.google.firebase.concurrent.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.b(runnable);
            }
        });
        newThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f31138b, Long.valueOf(this.f31137a.getAndIncrement())));
        return newThread;
    }
}
