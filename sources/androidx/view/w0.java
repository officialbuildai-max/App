package androidx.view;

import androidx.view.v0;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import p1.a;
import q1.g;

/* loaded from: classes.dex */
public abstract /* synthetic */ class w0 {
    public static t0 a(v0.c cVar, Class modelClass) {
        Intrinsics.h(modelClass, "modelClass");
        return g.f73174a.d();
    }

    public static t0 b(v0.c cVar, Class modelClass, a extras) {
        Intrinsics.h(modelClass, "modelClass");
        Intrinsics.h(extras, "extras");
        return cVar.create(modelClass);
    }

    public static t0 c(v0.c cVar, KClass modelClass, a extras) {
        Intrinsics.h(modelClass, "modelClass");
        Intrinsics.h(extras, "extras");
        return cVar.create(JvmClassMappingKt.a(modelClass), extras);
    }
}
