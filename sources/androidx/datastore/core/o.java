package androidx.datastore.core;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class o extends r {

    /* renamed from: b, reason: collision with root package name */
    private final Throwable f8686b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Throwable readException, int i11) {
        super(i11, null);
        Intrinsics.h(readException, "readException");
        this.f8686b = readException;
    }

    public final Throwable b() {
        return this.f8686b;
    }
}
