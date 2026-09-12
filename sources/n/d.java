package n;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class d {
    public static final void a(String message) {
        Intrinsics.h(message, "message");
        throw new IllegalArgumentException(message);
    }

    public static final void b(String message) {
        Intrinsics.h(message, "message");
        throw new IllegalStateException(message);
    }
}
