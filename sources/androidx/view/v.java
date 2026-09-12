package androidx.view;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class v {
    public static final LifecycleCoroutineScope a(u uVar) {
        Intrinsics.h(uVar, "<this>");
        return s.a(uVar.getLifecycle());
    }
}
