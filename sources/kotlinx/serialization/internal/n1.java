package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public abstract class n1 {
    public static final int a(kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.descriptors.f[] typeParams) {
        Intrinsics.h(fVar, "<this>");
        Intrinsics.h(typeParams, "typeParams");
        int hashCode = (fVar.i().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable a11 = kotlinx.serialization.descriptors.g.a(fVar);
        Iterator it = a11.iterator();
        int i11 = 1;
        int i12 = 1;
        while (true) {
            int i13 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i14 = i12 * 31;
            String i15 = ((kotlinx.serialization.descriptors.f) it.next()).i();
            if (i15 != null) {
                i13 = i15.hashCode();
            }
            i12 = i14 + i13;
        }
        Iterator it2 = a11.iterator();
        while (it2.hasNext()) {
            int i16 = i11 * 31;
            kotlinx.serialization.descriptors.h d11 = ((kotlinx.serialization.descriptors.f) it2.next()).d();
            i11 = i16 + (d11 != null ? d11.hashCode() : 0);
        }
        return (((hashCode * 31) + i12) * 31) + i11;
    }
}
