package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.descriptors.i;

/* loaded from: classes7.dex */
public abstract class q0 {
    public static final kotlinx.serialization.descriptors.f a(kotlinx.serialization.descriptors.f fVar, f00.c module) {
        kotlinx.serialization.descriptors.f a11;
        Intrinsics.h(fVar, "<this>");
        Intrinsics.h(module, "module");
        if (!Intrinsics.c(fVar.d(), h.a.f68191a)) {
            return fVar.isInline() ? a(fVar.h(0), module) : fVar;
        }
        kotlinx.serialization.descriptors.f b11 = kotlinx.serialization.descriptors.b.b(module, fVar);
        return (b11 == null || (a11 = a(b11, module)) == null) ? fVar : a11;
    }

    public static final WriteMode b(kotlinx.serialization.json.a aVar, kotlinx.serialization.descriptors.f desc) {
        Intrinsics.h(aVar, "<this>");
        Intrinsics.h(desc, "desc");
        kotlinx.serialization.descriptors.h d11 = desc.d();
        if (d11 instanceof kotlinx.serialization.descriptors.d) {
            return WriteMode.POLY_OBJ;
        }
        if (Intrinsics.c(d11, i.b.f68194a)) {
            return WriteMode.LIST;
        }
        if (!Intrinsics.c(d11, i.c.f68195a)) {
            return WriteMode.OBJ;
        }
        kotlinx.serialization.descriptors.f a11 = a(desc.h(0), aVar.a());
        kotlinx.serialization.descriptors.h d12 = a11.d();
        if ((d12 instanceof kotlinx.serialization.descriptors.e) || Intrinsics.c(d12, h.b.f68192a)) {
            return WriteMode.MAP;
        }
        if (aVar.e().b()) {
            return WriteMode.LIST;
        }
        throw w.d(a11);
    }
}
