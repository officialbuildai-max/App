package com.google.common.reflect;

import com.google.common.base.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: classes4.dex */
public abstract class a implements AnnotatedElement, Member {

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f31004c = b();

    /* renamed from: a, reason: collision with root package name */
    private final AccessibleObject f31005a;

    /* renamed from: b, reason: collision with root package name */
    private final Member f31006b;

    /* renamed from: com.google.common.reflect.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0416a extends a {

        /* renamed from: d, reason: collision with root package name */
        final Constructor f31007d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0416a(Constructor constructor) {
            super(constructor);
            this.f31007d = constructor;
        }

        private boolean d() {
            Class declaringClass = this.f31007d.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            return declaringClass.getEnclosingMethod() != null ? !Modifier.isStatic(r1.getModifiers()) : (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Type[] c() {
            Type[] genericParameterTypes = this.f31007d.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !d()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f31007d.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }
    }

    /* loaded from: classes4.dex */
    static class b extends a {

        /* renamed from: d, reason: collision with root package name */
        final Method f31008d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Method method) {
            super(method);
            this.f31008d = method;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    a(AccessibleObject accessibleObject) {
        m.o(accessibleObject);
        this.f31005a = accessibleObject;
        this.f31006b = (Member) accessibleObject;
    }

    private static boolean b() {
        try {
            Class.forName("java.lang.reflect.AnnotatedType");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public abstract TypeToken a();

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return a().equals(aVar.a()) && this.f31006b.equals(aVar.f31006b);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation getAnnotation(Class cls) {
        return this.f31005a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f31005a.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f31005a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public final Class getDeclaringClass() {
        return this.f31006b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f31006b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f31006b.getName();
    }

    public int hashCode() {
        return this.f31006b.hashCode();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class cls) {
        return this.f31005a.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f31006b.isSynthetic();
    }

    public String toString() {
        return this.f31006b.toString();
    }
}
