package androidx.room;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class p0 {
    public static final Object b(p pVar, String str, Continuation continuation) {
        Object d11 = pVar.d(str, new Function1() { // from class: androidx.room.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean c11;
                c11 = p0.c((z3.e) obj);
                return Boolean.valueOf(c11);
            }
        }, continuation);
        return d11 == IntrinsicsKt.f() ? d11 : Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(z3.e it) {
        Intrinsics.h(it, "it");
        return it.A0();
    }
}
