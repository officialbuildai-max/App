package kotlinx.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.internal.k0;
import kotlinx.serialization.internal.k1;
import kotlinx.serialization.internal.l1;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.t1;
import kotlinx.serialization.internal.v0;
import kotlinx.serialization.internal.x0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract /* synthetic */ class i {
    private static final b a(KClass kClass, List list, List list2) {
        if (Intrinsics.c(kClass, Reflection.b(Collection.class)) ? true : Intrinsics.c(kClass, Reflection.b(List.class)) ? true : Intrinsics.c(kClass, Reflection.b(List.class)) ? true : Intrinsics.c(kClass, Reflection.b(ArrayList.class))) {
            return new kotlinx.serialization.internal.f((b) list2.get(0));
        }
        if (Intrinsics.c(kClass, Reflection.b(HashSet.class))) {
            return new m0((b) list2.get(0));
        }
        if (Intrinsics.c(kClass, Reflection.b(Set.class)) ? true : Intrinsics.c(kClass, Reflection.b(Set.class)) ? true : Intrinsics.c(kClass, Reflection.b(LinkedHashSet.class))) {
            return new x0((b) list2.get(0));
        }
        if (Intrinsics.c(kClass, Reflection.b(HashMap.class))) {
            return new k0((b) list2.get(0), (b) list2.get(1));
        }
        if (Intrinsics.c(kClass, Reflection.b(Map.class)) ? true : Intrinsics.c(kClass, Reflection.b(Map.class)) ? true : Intrinsics.c(kClass, Reflection.b(LinkedHashMap.class))) {
            return new v0((b) list2.get(0), (b) list2.get(1));
        }
        if (Intrinsics.c(kClass, Reflection.b(Map.Entry.class))) {
            return d00.a.j((b) list2.get(0), (b) list2.get(1));
        }
        if (Intrinsics.c(kClass, Reflection.b(Pair.class))) {
            return d00.a.l((b) list2.get(0), (b) list2.get(1));
        }
        if (Intrinsics.c(kClass, Reflection.b(Triple.class))) {
            return d00.a.n((b) list2.get(0), (b) list2.get(1), (b) list2.get(2));
        }
        if (!k1.l(kClass)) {
            return null;
        }
        KClassifier c11 = ((KType) list.get(0)).c();
        Intrinsics.f(c11, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        return d00.a.a((KClass) c11, (b) list2.get(0));
    }

    private static final b b(KClass kClass, List list) {
        Object[] array = list.toArray(new b[0]);
        Intrinsics.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        b[] bVarArr = (b[]) array;
        return k1.d(kClass, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
    }

    private static final b c(b bVar, boolean z10) {
        if (z10) {
            return d00.a.s(bVar);
        }
        Intrinsics.f(bVar, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return bVar;
    }

    public static final b d(KClass kClass, List types, List serializers) {
        Intrinsics.h(kClass, "<this>");
        Intrinsics.h(types, "types");
        Intrinsics.h(serializers, "serializers");
        b a11 = a(kClass, types, serializers);
        return a11 == null ? b(kClass, serializers) : a11;
    }

    public static final b e(f00.c cVar, KType type) {
        Intrinsics.h(cVar, "<this>");
        Intrinsics.h(type, "type");
        b f11 = f(cVar, type, true);
        if (f11 != null) {
            return f11;
        }
        k1.m(l1.c(type));
        throw new KotlinNothingValueException();
    }

    private static final b f(f00.c cVar, KType kType, boolean z10) {
        b bVar;
        b b11;
        KClass c11 = l1.c(kType);
        boolean a11 = kType.a();
        List h11 = kType.h();
        ArrayList arrayList = new ArrayList(CollectionsKt.v(h11, 10));
        Iterator it = h11.iterator();
        while (it.hasNext()) {
            KType type = ((KTypeProjection) it.next()).getType();
            if (type == null) {
                throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + kType).toString());
            }
            arrayList.add(type);
        }
        if (arrayList.isEmpty()) {
            bVar = SerializersCacheKt.a(c11, a11);
        } else {
            Object b12 = SerializersCacheKt.b(c11, arrayList, a11);
            if (z10) {
                if (Result.m1191isFailureimpl(b12)) {
                    b12 = null;
                }
                bVar = (b) b12;
            } else {
                if (Result.m1188exceptionOrNullimpl(b12) != null) {
                    return null;
                }
                bVar = (b) b12;
            }
        }
        if (bVar != null) {
            return bVar;
        }
        if (arrayList.isEmpty()) {
            b11 = f00.c.c(cVar, c11, null, 2, null);
        } else {
            List e11 = h.e(cVar, arrayList, z10);
            if (e11 == null) {
                return null;
            }
            b a12 = h.a(c11, arrayList, e11);
            b11 = a12 == null ? cVar.b(c11, e11) : a12;
        }
        if (b11 != null) {
            return c(b11, a11);
        }
        return null;
    }

    public static final b g(f00.c cVar, KType type) {
        Intrinsics.h(cVar, "<this>");
        Intrinsics.h(type, "type");
        return f(cVar, type, false);
    }

    public static final b h(KClass kClass) {
        Intrinsics.h(kClass, "<this>");
        b b11 = k1.b(kClass);
        return b11 == null ? t1.b(kClass) : b11;
    }

    public static final List i(f00.c cVar, List typeArguments, boolean z10) {
        ArrayList arrayList;
        Intrinsics.h(cVar, "<this>");
        Intrinsics.h(typeArguments, "typeArguments");
        if (z10) {
            List list = typeArguments;
            arrayList = new ArrayList(CollectionsKt.v(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(h.b(cVar, (KType) it.next()));
            }
        } else {
            List list2 = typeArguments;
            arrayList = new ArrayList(CollectionsKt.v(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                b c11 = h.c(cVar, (KType) it2.next());
                if (c11 == null) {
                    return null;
                }
                arrayList.add(c11);
            }
        }
        return arrayList;
    }
}
