package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.internal.v1;

/* loaded from: classes7.dex */
public abstract class b {
    public static final KClass a(f fVar) {
        Intrinsics.h(fVar, "<this>");
        if (fVar instanceof c) {
            return ((c) fVar).f68172b;
        }
        if (fVar instanceof v1) {
            return a(((v1) fVar).k());
        }
        return null;
    }

    public static final f b(f00.c cVar, f descriptor) {
        kotlinx.serialization.b c11;
        Intrinsics.h(cVar, "<this>");
        Intrinsics.h(descriptor, "descriptor");
        KClass a11 = a(descriptor);
        if (a11 == null || (c11 = f00.c.c(cVar, a11, null, 2, null)) == null) {
            return null;
        }
        return c11.getDescriptor();
    }

    public static final f c(f fVar, KClass context) {
        Intrinsics.h(fVar, "<this>");
        Intrinsics.h(context, "context");
        return new c(fVar, context);
    }
}
