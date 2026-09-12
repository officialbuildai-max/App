package p1;

import androidx.view.t0;
import androidx.view.v0;
import androidx.view.x0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import q1.g;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    private final x0 f72394a;

    /* renamed from: b */
    private final v0.c f72395b;

    /* renamed from: c */
    private final a f72396c;

    public c(x0 store, v0.c factory, a extras) {
        Intrinsics.h(store, "store");
        Intrinsics.h(factory, "factory");
        Intrinsics.h(extras, "extras");
        this.f72394a = store;
        this.f72395b = factory;
        this.f72396c = extras;
    }

    public static /* synthetic */ t0 b(c cVar, KClass kClass, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = g.f73174a.c(kClass);
        }
        return cVar.a(kClass, str);
    }

    public final t0 a(KClass modelClass, String key) {
        Intrinsics.h(modelClass, "modelClass");
        Intrinsics.h(key, "key");
        t0 b11 = this.f72394a.b(key);
        if (!modelClass.d(b11)) {
            b bVar = new b(this.f72396c);
            bVar.c(g.a.f73175a, key);
            t0 a11 = d.a(this.f72395b, modelClass, bVar);
            this.f72394a.d(key, a11);
            return a11;
        }
        Object obj = this.f72395b;
        if (obj instanceof v0.e) {
            Intrinsics.e(b11);
            ((v0.e) obj).a(b11);
        }
        Intrinsics.f(b11, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
        return b11;
    }
}
