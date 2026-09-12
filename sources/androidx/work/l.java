package androidx.work;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class l {
    public abstract k a(String str);

    public final k b(String className) {
        Intrinsics.h(className, "className");
        k a11 = a(className);
        return a11 == null ? m.a(className) : a11;
    }
}
