package com.google.common.reflect;

import com.google.common.base.j;
import com.google.common.base.m;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final c f31009a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f31010b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Type f31011c;

        a(Map map, Type type) {
            this.f31010b = map;
            this.f31011c = type;
        }

        @Override // com.google.common.reflect.g
        void b(Class cls) {
            if (this.f31011c instanceof WildcardType) {
                return;
            }
            throw new IllegalArgumentException("No type mapping from " + cls + " to " + this.f31011c);
        }

        @Override // com.google.common.reflect.g
        void c(GenericArrayType genericArrayType) {
            Type type = this.f31011c;
            if (type instanceof WildcardType) {
                return;
            }
            Type i11 = Types.i(type);
            m.j(i11 != null, "%s is not an array type.", this.f31011c);
            e.g(this.f31010b, genericArrayType.getGenericComponentType(), i11);
        }

        @Override // com.google.common.reflect.g
        void d(ParameterizedType parameterizedType) {
            Type type = this.f31011c;
            if (type instanceof WildcardType) {
                return;
            }
            ParameterizedType parameterizedType2 = (ParameterizedType) e.e(ParameterizedType.class, type);
            if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                e.g(this.f31010b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
            }
            m.k(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f31011c);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            m.k(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
            for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
                e.g(this.f31010b, actualTypeArguments[i11], actualTypeArguments2[i11]);
            }
        }

        @Override // com.google.common.reflect.g
        void e(TypeVariable typeVariable) {
            this.f31010b.put(new d(typeVariable), this.f31011c);
        }

        @Override // com.google.common.reflect.g
        void f(WildcardType wildcardType) {
            Type type = this.f31011c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                m.k(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f31011c);
                for (int i11 = 0; i11 < upperBounds.length; i11++) {
                    e.g(this.f31010b, upperBounds[i11], upperBounds2[i11]);
                }
                for (int i12 = 0; i12 < lowerBounds.length; i12++) {
                    e.g(this.f31010b, lowerBounds[i12], lowerBounds2[i12]);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static final class b extends g {

        /* renamed from: b, reason: collision with root package name */
        private final Map f31012b = Maps.o();

        private b() {
        }

        static ImmutableMap g(Type type) {
            m.o(type);
            b bVar = new b();
            bVar.a(type);
            return ImmutableMap.copyOf(bVar.f31012b);
        }

        private void h(d dVar, Type type) {
            if (this.f31012b.containsKey(dVar)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (dVar.a(type2)) {
                    while (type != null) {
                        type = (Type) this.f31012b.remove(d.c(type));
                    }
                    return;
                }
                type2 = (Type) this.f31012b.get(d.c(type2));
            }
            this.f31012b.put(dVar, type);
        }

        @Override // com.google.common.reflect.g
        void b(Class cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.g
        void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            m.u(typeParameters.length == actualTypeArguments.length);
            for (int i11 = 0; i11 < typeParameters.length; i11++) {
                h(new d(typeParameters[i11]), actualTypeArguments[i11]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.g
        void e(TypeVariable typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.g
        void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final ImmutableMap f31013a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a extends c {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ TypeVariable f31014b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f31015c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f31016d;

            a(c cVar, TypeVariable typeVariable, c cVar2) {
                this.f31014b = typeVariable;
                this.f31015c = cVar2;
                this.f31016d = cVar;
            }

            @Override // com.google.common.reflect.e.c
            public Type b(TypeVariable typeVariable, c cVar) {
                return typeVariable.getGenericDeclaration().equals(this.f31014b.getGenericDeclaration()) ? typeVariable : this.f31015c.b(typeVariable, cVar);
            }
        }

        c() {
            this.f31013a = ImmutableMap.of();
        }

        private c(ImmutableMap immutableMap) {
            this.f31013a = immutableMap;
        }

        final Type a(TypeVariable typeVariable) {
            return b(typeVariable, new a(this, typeVariable, this));
        }

        Type b(TypeVariable typeVariable, c cVar) {
            Type type = (Type) this.f31013a.get(new d(typeVariable));
            a aVar = null;
            if (type != null) {
                return new e(cVar, aVar).j(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] k11 = new e(cVar, aVar).k(bounds);
            return (Types.b.f30998a && Arrays.equals(bounds, k11)) ? typeVariable : Types.k(typeVariable.getGenericDeclaration(), typeVariable.getName(), k11);
        }

        final c c(Map map) {
            ImmutableMap.b builder = ImmutableMap.builder();
            builder.k(this.f31013a);
            for (Map.Entry entry : map.entrySet()) {
                d dVar = (d) entry.getKey();
                Type type = (Type) entry.getValue();
                m.j(!dVar.a(type), "Type variable %s bound to itself", dVar);
                builder.h(dVar, type);
            }
            return new c(builder.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final TypeVariable f31017a;

        d(TypeVariable typeVariable) {
            this.f31017a = (TypeVariable) m.o(typeVariable);
        }

        private boolean b(TypeVariable typeVariable) {
            return this.f31017a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f31017a.getName().equals(typeVariable.getName());
        }

        static d c(Type type) {
            if (type instanceof TypeVariable) {
                return new d((TypeVariable) type);
            }
            return null;
        }

        boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).f31017a);
            }
            return false;
        }

        public int hashCode() {
            return j.b(this.f31017a.getGenericDeclaration(), this.f31017a.getName());
        }

        public String toString() {
            return this.f31017a.toString();
        }
    }

    /* renamed from: com.google.common.reflect.e$e, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0417e {

        /* renamed from: b, reason: collision with root package name */
        static final C0417e f31018b = new C0417e();

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f31019a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.reflect.e$e$a */
        /* loaded from: classes4.dex */
        public class a extends C0417e {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ TypeVariable f31020c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ C0417e f31021d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C0417e c0417e, AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.f31020c = typeVariable;
                this.f31021d = c0417e;
            }

            @Override // com.google.common.reflect.e.C0417e
            TypeVariable b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.f31020c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        private C0417e() {
            this(new AtomicInteger());
        }

        private C0417e(AtomicInteger atomicInteger) {
            this.f31019a = atomicInteger;
        }

        /* synthetic */ C0417e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        private Type c(Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        private C0417e d(TypeVariable typeVariable) {
            return new a(this, this.f31019a, typeVariable);
        }

        private C0417e e() {
            return new C0417e(this.f31019a);
        }

        final Type a(Type type) {
            m.o(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.j(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (!(type instanceof ParameterizedType)) {
                if (!(type instanceof WildcardType)) {
                    throw new AssertionError("must have been one of the known types");
                }
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
                actualTypeArguments[i11] = d(typeParameters[i11]).a(actualTypeArguments[i11]);
            }
            return Types.m(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
        }

        TypeVariable b(Type[] typeArr) {
            return Types.k(C0417e.class, "capture#" + this.f31019a.incrementAndGet() + "-of ? extends " + com.google.common.base.g.g('&').f(typeArr), typeArr);
        }
    }

    public e() {
        this.f31009a = new c();
    }

    private e(c cVar) {
        this.f31009a = cVar;
    }

    /* synthetic */ e(c cVar, a aVar) {
        this(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e d(Type type) {
        return new e().o(b.g(type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object e(Class cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e f(Type type) {
        return new e().o(b.g(C0417e.f31018b.a(type)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Map map, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new a(map, type2).a(type);
    }

    private Type h(GenericArrayType genericArrayType) {
        return Types.j(j(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.m(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i11 = 0; i11 < typeArr.length; i11++) {
            typeArr2[i11] = j(typeArr[i11]);
        }
        return typeArr2;
    }

    private WildcardType m(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public Type j(Type type) {
        m.o(type);
        return type instanceof TypeVariable ? this.f31009a.a((TypeVariable) type) : type instanceof ParameterizedType ? i((ParameterizedType) type) : type instanceof GenericArrayType ? h((GenericArrayType) type) : type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type[] l(Type[] typeArr) {
        for (int i11 = 0; i11 < typeArr.length; i11++) {
            typeArr[i11] = j(typeArr[i11]);
        }
        return typeArr;
    }

    public e n(Type type, Type type2) {
        HashMap o11 = Maps.o();
        g(o11, (Type) m.o(type), (Type) m.o(type2));
        return o(o11);
    }

    e o(Map map) {
        return new e(this.f31009a.c(map));
    }
}
