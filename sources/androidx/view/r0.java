package androidx.view;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class r0 {

    /* renamed from: a, reason: collision with root package name */
    private static final List f9728a = CollectionsKt.o(Application.class, l0.class);

    /* renamed from: b, reason: collision with root package name */
    private static final List f9729b = CollectionsKt.e(l0.class);

    public static final /* synthetic */ List a() {
        return f9728a;
    }

    public static final /* synthetic */ List b() {
        return f9729b;
    }

    public static final Constructor c(Class modelClass, List signature) {
        Intrinsics.h(modelClass, "modelClass");
        Intrinsics.h(signature, "signature");
        Constructor<?>[] constructors = modelClass.getConstructors();
        Intrinsics.g(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Intrinsics.g(parameterTypes, "constructor.parameterTypes");
            List K0 = ArraysKt.K0(parameterTypes);
            if (Intrinsics.c(signature, K0)) {
                Intrinsics.f(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (signature.size() == K0.size() && K0.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final t0 d(Class modelClass, Constructor constructor, Object... params) {
        Intrinsics.h(modelClass, "modelClass");
        Intrinsics.h(constructor, "constructor");
        Intrinsics.h(params, "params");
        try {
            return (t0) constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Failed to access " + modelClass, e11);
        } catch (InstantiationException e12) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e13.getCause());
        }
    }
}
