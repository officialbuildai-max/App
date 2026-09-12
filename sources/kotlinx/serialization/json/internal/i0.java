package kotlinx.serialization.json.internal;

import java.lang.annotation.Annotation;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.json.JsonObject;

/* loaded from: classes7.dex */
public abstract class i0 {
    public static final void b(kotlinx.serialization.descriptors.h kind) {
        Intrinsics.h(kind, "kind");
        if (kind instanceof h.b) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof kotlinx.serialization.descriptors.e) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof kotlinx.serialization.descriptors.d) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself");
        }
    }

    public static final String c(kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.json.a json) {
        Intrinsics.h(fVar, "<this>");
        Intrinsics.h(json, "json");
        for (Annotation annotation : fVar.getAnnotations()) {
            if (annotation instanceof kotlinx.serialization.json.e) {
                return ((kotlinx.serialization.json.e) annotation).discriminator();
            }
        }
        return json.e().c();
    }

    public static final Object d(kotlinx.serialization.json.g gVar, kotlinx.serialization.a deserializer) {
        kotlinx.serialization.json.u l11;
        Intrinsics.h(gVar, "<this>");
        Intrinsics.h(deserializer, "deserializer");
        if (!(deserializer instanceof kotlinx.serialization.internal.b) || gVar.d().e().k()) {
            return deserializer.deserialize(gVar);
        }
        String c11 = c(deserializer.getDescriptor(), gVar.d());
        kotlinx.serialization.json.h g11 = gVar.g();
        kotlinx.serialization.descriptors.f descriptor = deserializer.getDescriptor();
        if (g11 instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject) g11;
            kotlinx.serialization.json.h hVar = (kotlinx.serialization.json.h) jsonObject.get(c11);
            String a11 = (hVar == null || (l11 = kotlinx.serialization.json.j.l(hVar)) == null) ? null : l11.a();
            kotlinx.serialization.a c12 = ((kotlinx.serialization.internal.b) deserializer).c(gVar, a11);
            if (c12 != null) {
                return p0.b(gVar.d(), c11, jsonObject, c12);
            }
            e(a11, jsonObject);
            throw new KotlinNothingValueException();
        }
        throw w.e(-1, "Expected " + Reflection.b(JsonObject.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.b(g11.getClass()));
    }

    public static final Void e(String str, JsonObject jsonTree) {
        String str2;
        Intrinsics.h(jsonTree, "jsonTree");
        if (str == null) {
            str2 = "missing class discriminator ('null')";
        } else {
            str2 = "class discriminator '" + str + '\'';
        }
        throw w.f(-1, "Polymorphic serializer was not found for " + str2, jsonTree.toString());
    }

    public static final void f(kotlinx.serialization.g gVar, kotlinx.serialization.g gVar2, String str) {
    }
}
