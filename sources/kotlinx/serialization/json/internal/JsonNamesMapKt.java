package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.internal.u;

/* loaded from: classes7.dex */
public abstract class JsonNamesMapKt {

    /* renamed from: a, reason: collision with root package name */
    private static final u.a f68400a = new u.a();

    public static final Map a(kotlinx.serialization.descriptors.f fVar) {
        String[] names;
        Intrinsics.h(fVar, "<this>");
        int e11 = fVar.e();
        Map map = null;
        for (int i11 = 0; i11 < e11; i11++) {
            List g11 = fVar.g(i11);
            ArrayList arrayList = new ArrayList();
            for (Object obj : g11) {
                if (obj instanceof kotlinx.serialization.json.q) {
                    arrayList.add(obj);
                }
            }
            kotlinx.serialization.json.q qVar = (kotlinx.serialization.json.q) CollectionsKt.G0(arrayList);
            if (qVar != null && (names = qVar.names()) != null) {
                for (String str : names) {
                    if (map == null) {
                        map = t.a(fVar.e());
                    }
                    Intrinsics.e(map);
                    b(map, fVar, str, i11);
                }
            }
        }
        return map == null ? MapsKt.h() : map;
    }

    private static final void b(Map map, kotlinx.serialization.descriptors.f fVar, String str, int i11) {
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i11));
            return;
        }
        throw new JsonException("The suggested name '" + str + "' for property " + fVar.f(i11) + " is already one of the names for property " + fVar.f(((Number) MapsKt.i(map, str)).intValue()) + " in " + fVar);
    }

    public static final u.a c() {
        return f68400a;
    }

    public static final int d(kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.json.a json, String name) {
        Intrinsics.h(fVar, "<this>");
        Intrinsics.h(json, "json");
        Intrinsics.h(name, "name");
        int c11 = fVar.c(name);
        if (c11 != -3 || !json.e().j()) {
            return c11;
        }
        Integer num = (Integer) ((Map) kotlinx.serialization.json.w.a(json).b(fVar, f68400a, new JsonNamesMapKt$getJsonNameIndex$alternativeNamesMap$1(fVar))).get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final int e(kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.json.a json, String name, String suffix) {
        Intrinsics.h(fVar, "<this>");
        Intrinsics.h(json, "json");
        Intrinsics.h(name, "name");
        Intrinsics.h(suffix, "suffix");
        int d11 = d(fVar, json, name);
        if (d11 != -3) {
            return d11;
        }
        throw new SerializationException(fVar.i() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static /* synthetic */ int f(kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.json.a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        return e(fVar, aVar, str, str2);
    }
}
