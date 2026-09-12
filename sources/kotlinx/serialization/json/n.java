package kotlinx.serialization.json;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public abstract class n {
    public static final a a(a from, Function1 builderAction) {
        Intrinsics.h(from, "from");
        Intrinsics.h(builderAction, "builderAction");
        d dVar = new d(from);
        builderAction.invoke(dVar);
        return new m(dVar.a(), dVar.b());
    }

    public static /* synthetic */ a b(a aVar, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            aVar = a.f68354d;
        }
        return a(aVar, function1);
    }
}
