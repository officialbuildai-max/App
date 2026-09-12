package kotlinx.serialization;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes7.dex */
public abstract class d {
    public static final a a(kotlinx.serialization.internal.b bVar, e00.c decoder, String str) {
        Intrinsics.h(bVar, "<this>");
        Intrinsics.h(decoder, "decoder");
        a c11 = bVar.c(decoder, str);
        if (c11 != null) {
            return c11;
        }
        kotlinx.serialization.internal.c.a(str, bVar.e());
        throw new KotlinNothingValueException();
    }

    public static final g b(kotlinx.serialization.internal.b bVar, e00.f encoder, Object value) {
        Intrinsics.h(bVar, "<this>");
        Intrinsics.h(encoder, "encoder");
        Intrinsics.h(value, "value");
        g d11 = bVar.d(encoder, value);
        if (d11 != null) {
            return d11;
        }
        kotlinx.serialization.internal.c.b(Reflection.b(value.getClass()), bVar.e());
        throw new KotlinNothingValueException();
    }
}
