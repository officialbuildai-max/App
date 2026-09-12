package androidx.work.impl.utils;

import androidx.work.l0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class g0 {
    public static final void a(androidx.core.util.a aVar, l0 info, String tag) {
        Intrinsics.h(aVar, "<this>");
        Intrinsics.h(info, "info");
        Intrinsics.h(tag, "tag");
        try {
            aVar.accept(info);
        } catch (Throwable th2) {
            androidx.work.t.e().d(tag, "Exception handler threw an exception", th2);
        }
    }
}
