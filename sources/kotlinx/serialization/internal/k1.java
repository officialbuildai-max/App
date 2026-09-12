package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.PolymorphicSerializer;

/* loaded from: classes7.dex */
public abstract class k1 {
    private static final Object a(Class cls) {
        try {
            Field declaredField = cls.getDeclaredField("Companion");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final kotlinx.serialization.b b(KClass kClass) {
        Intrinsics.h(kClass, "<this>");
        return d(kClass, new kotlinx.serialization.b[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlinx.serialization.b c(java.lang.Class r8, kotlinx.serialization.b... r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.h(r9, r0)
            boolean r0 = r8.isEnum()
            if (r0 == 0) goto L1b
            boolean r0 = j(r8)
            if (r0 == 0) goto L1b
            kotlinx.serialization.b r8 = e(r8)
            return r8
        L1b:
            boolean r0 = r8.isInterface()
            if (r0 == 0) goto L28
            kotlinx.serialization.b r0 = g(r8)
            if (r0 == 0) goto L28
            return r0
        L28:
            int r0 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r0)
            kotlinx.serialization.b[] r9 = (kotlinx.serialization.b[]) r9
            kotlinx.serialization.b r9 = h(r8, r9)
            if (r9 == 0) goto L36
            return r9
        L36:
            kotlinx.serialization.b r9 = f(r8)
            if (r9 == 0) goto L3d
            return r9
        L3d:
            r9 = 0
            java.lang.Class[] r0 = r8.getDeclaredClasses()     // Catch: java.lang.NoSuchFieldException -> L7e
            java.lang.String r1 = "declaredClasses"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)     // Catch: java.lang.NoSuchFieldException -> L7e
            int r1 = r0.length     // Catch: java.lang.NoSuchFieldException -> L7e
            r2 = 0
            r4 = r9
            r3 = r2
        L4b:
            if (r2 >= r1) goto L64
            r5 = r0[r2]     // Catch: java.lang.NoSuchFieldException -> L7e
            java.lang.String r6 = r5.getSimpleName()     // Catch: java.lang.NoSuchFieldException -> L7e
            java.lang.String r7 = "$serializer"
            boolean r6 = kotlin.jvm.internal.Intrinsics.c(r6, r7)     // Catch: java.lang.NoSuchFieldException -> L7e
            if (r6 == 0) goto L61
            if (r3 == 0) goto L5f
        L5d:
            r4 = r9
            goto L67
        L5f:
            r3 = 1
            r4 = r5
        L61:
            int r2 = r2 + 1
            goto L4b
        L64:
            if (r3 != 0) goto L67
            goto L5d
        L67:
            if (r4 == 0) goto L76
            java.lang.String r0 = "INSTANCE"
            java.lang.reflect.Field r0 = r4.getField(r0)     // Catch: java.lang.NoSuchFieldException -> L7e
            if (r0 == 0) goto L76
            java.lang.Object r0 = r0.get(r9)     // Catch: java.lang.NoSuchFieldException -> L7e
            goto L77
        L76:
            r0 = r9
        L77:
            boolean r1 = r0 instanceof kotlinx.serialization.b     // Catch: java.lang.NoSuchFieldException -> L7e
            if (r1 == 0) goto L7e
            kotlinx.serialization.b r0 = (kotlinx.serialization.b) r0     // Catch: java.lang.NoSuchFieldException -> L7e
            goto L7f
        L7e:
            r0 = r9
        L7f:
            if (r0 == 0) goto L82
            return r0
        L82:
            boolean r0 = k(r8)
            if (r0 == 0) goto L91
            kotlinx.serialization.PolymorphicSerializer r9 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r8 = kotlin.jvm.JvmClassMappingKt.c(r8)
            r9.<init>(r8)
        L91:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.k1.c(java.lang.Class, kotlinx.serialization.b[]):kotlinx.serialization.b");
    }

    public static final kotlinx.serialization.b d(KClass kClass, kotlinx.serialization.b... args) {
        Intrinsics.h(kClass, "<this>");
        Intrinsics.h(args, "args");
        return c(JvmClassMappingKt.a(kClass), (kotlinx.serialization.b[]) Arrays.copyOf(args, args.length));
    }

    private static final kotlinx.serialization.b e(Class cls) {
        Object[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        Intrinsics.g(canonicalName, "canonicalName");
        Intrinsics.f(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer(canonicalName, (Enum[]) enumConstants);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0084, code lost:
    
        if (r4 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x003d, code lost:
    
        if (r5 == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlinx.serialization.b f(java.lang.Class r11) {
        /*
            java.lang.reflect.Field[] r0 = r11.getDeclaredFields()
            java.lang.String r1 = "declaredFields"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            int r1 = r0.length
            r2 = 0
            r3 = 0
            r6 = r2
            r4 = r3
            r5 = r4
        Lf:
            r7 = 1
            if (r4 >= r1) goto L3d
            r8 = r0[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "INSTANCE"
            boolean r9 = kotlin.jvm.internal.Intrinsics.c(r9, r10)
            if (r9 == 0) goto L3a
            java.lang.Class r9 = r8.getType()
            boolean r9 = kotlin.jvm.internal.Intrinsics.c(r9, r11)
            if (r9 == 0) goto L3a
            int r9 = r8.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L3a
            if (r5 == 0) goto L38
        L36:
            r6 = r2
            goto L40
        L38:
            r5 = r7
            r6 = r8
        L3a:
            int r4 = r4 + 1
            goto Lf
        L3d:
            if (r5 != 0) goto L40
            goto L36
        L40:
            if (r6 != 0) goto L43
            return r2
        L43:
            java.lang.Object r0 = r6.get(r2)
            java.lang.reflect.Method[] r11 = r11.getMethods()
            java.lang.String r1 = "methods"
            kotlin.jvm.internal.Intrinsics.g(r11, r1)
            int r1 = r11.length
            r5 = r2
            r4 = r3
        L53:
            if (r3 >= r1) goto L84
            r6 = r11[r3]
            java.lang.String r8 = r6.getName()
            java.lang.String r9 = "serializer"
            boolean r8 = kotlin.jvm.internal.Intrinsics.c(r8, r9)
            if (r8 == 0) goto L81
            java.lang.Class[] r8 = r6.getParameterTypes()
            java.lang.String r9 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.g(r8, r9)
            int r8 = r8.length
            if (r8 != 0) goto L81
            java.lang.Class r8 = r6.getReturnType()
            java.lang.Class<kotlinx.serialization.b> r9 = kotlinx.serialization.b.class
            boolean r8 = kotlin.jvm.internal.Intrinsics.c(r8, r9)
            if (r8 == 0) goto L81
            if (r4 == 0) goto L7f
        L7d:
            r5 = r2
            goto L87
        L7f:
            r5 = r6
            r4 = r7
        L81:
            int r3 = r3 + 1
            goto L53
        L84:
            if (r4 != 0) goto L87
            goto L7d
        L87:
            if (r5 != 0) goto L8a
            return r2
        L8a:
            java.lang.Object r11 = r5.invoke(r0, r2)
            boolean r0 = r11 instanceof kotlinx.serialization.b
            if (r0 == 0) goto L95
            r2 = r11
            kotlinx.serialization.b r2 = (kotlinx.serialization.b) r2
        L95:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.k1.f(java.lang.Class):kotlinx.serialization.b");
    }

    private static final kotlinx.serialization.b g(Class cls) {
        kotlinx.serialization.f fVar = (kotlinx.serialization.f) cls.getAnnotation(kotlinx.serialization.f.class);
        if (fVar == null || Intrinsics.c(Reflection.b(fVar.with()), Reflection.b(PolymorphicSerializer.class))) {
            return new PolymorphicSerializer(JvmClassMappingKt.c(cls));
        }
        return null;
    }

    private static final kotlinx.serialization.b h(Class cls, kotlinx.serialization.b... bVarArr) {
        Class[] clsArr;
        Object a11 = a(cls);
        if (a11 == null) {
            return null;
        }
        try {
            if (bVarArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = bVarArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i11 = 0; i11 < length; i11++) {
                    clsArr2[i11] = kotlinx.serialization.b.class;
                }
                clsArr = clsArr2;
            }
            Object invoke = a11.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(a11, Arrays.copyOf(bVarArr, bVarArr.length));
            if (invoke instanceof kotlinx.serialization.b) {
                return (kotlinx.serialization.b) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause == null) {
                throw e11;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e11.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }

    public static final boolean i(Object obj, KClass kclass) {
        Intrinsics.h(obj, "<this>");
        Intrinsics.h(kclass, "kclass");
        return JvmClassMappingKt.b(kclass).isInstance(obj);
    }

    private static final boolean j(Class cls) {
        return cls.getAnnotation(kotlinx.serialization.f.class) == null && cls.getAnnotation(kotlinx.serialization.c.class) == null;
    }

    private static final boolean k(Class cls) {
        if (cls.getAnnotation(kotlinx.serialization.c.class) != null) {
            return true;
        }
        kotlinx.serialization.f fVar = (kotlinx.serialization.f) cls.getAnnotation(kotlinx.serialization.f.class);
        return fVar != null && Intrinsics.c(Reflection.b(fVar.with()), Reflection.b(PolymorphicSerializer.class));
    }

    public static final boolean l(KClass rootClass) {
        Intrinsics.h(rootClass, "rootClass");
        return JvmClassMappingKt.a(rootClass).isArray();
    }

    public static final Void m(KClass kClass) {
        Intrinsics.h(kClass, "<this>");
        l1.d(kClass);
        throw new KotlinNothingValueException();
    }

    public static final Object[] n(ArrayList arrayList, KClass eClass) {
        Intrinsics.h(arrayList, "<this>");
        Intrinsics.h(eClass, "eClass");
        Object newInstance = Array.newInstance((Class<?>) JvmClassMappingKt.a(eClass), arrayList.size());
        Intrinsics.f(newInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        Object[] array = arrayList.toArray((Object[]) newInstance);
        Intrinsics.g(array, "toArray(java.lang.reflec….java, size) as Array<E>)");
        return array;
    }
}
