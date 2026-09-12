package androidx.work;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f16106a;

    /* renamed from: b, reason: collision with root package name */
    private final WorkerParameters f16107b;

    /* renamed from: c, reason: collision with root package name */
    private final Throwable f16108c;

    public l0(String workerClassName, WorkerParameters workerParameters, Throwable throwable) {
        Intrinsics.h(workerClassName, "workerClassName");
        Intrinsics.h(workerParameters, "workerParameters");
        Intrinsics.h(throwable, "throwable");
        this.f16106a = workerClassName;
        this.f16107b = workerParameters;
        this.f16108c = throwable;
    }
}
