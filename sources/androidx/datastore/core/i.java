package androidx.datastore.core;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class i extends r {

    /* renamed from: b, reason: collision with root package name */
    private final Throwable f8677b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Throwable finalException) {
        super(Integer.MAX_VALUE, null);
        Intrinsics.h(finalException, "finalException");
        this.f8677b = finalException;
    }

    public final Throwable b() {
        return this.f8677b;
    }
}
