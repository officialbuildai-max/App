package yc;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yc.j;

/* loaded from: classes5.dex */
public abstract class n {
    public static final com.google.firebase.remoteconfig.a a(com.google.firebase.c cVar) {
        Intrinsics.h(cVar, "<this>");
        com.google.firebase.remoteconfig.a k11 = com.google.firebase.remoteconfig.a.k();
        Intrinsics.g(k11, "getInstance()");
        return k11;
    }

    public static final j b(Function1 init) {
        Intrinsics.h(init, "init");
        j.b bVar = new j.b();
        init.invoke(bVar);
        j c11 = bVar.c();
        Intrinsics.g(c11, "builder.build()");
        return c11;
    }
}
