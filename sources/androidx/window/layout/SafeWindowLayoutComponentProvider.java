package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: classes.dex */
public final class SafeWindowLayoutComponentProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final SafeWindowLayoutComponentProvider f15388a = new SafeWindowLayoutComponentProvider();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f15389b = LazyKt.b(new Function0<WindowLayoutComponent>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$windowLayoutComponent$2
        @Override // kotlin.jvm.functions.Function0
        public final WindowLayoutComponent invoke() {
            boolean i11;
            ClassLoader classLoader = SafeWindowLayoutComponentProvider.class.getClassLoader();
            if (classLoader != null) {
                i11 = SafeWindowLayoutComponentProvider.f15388a.i(classLoader);
                if (i11) {
                    try {
                        return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
                    } catch (UnsupportedOperationException unused) {
                        return null;
                    }
                }
            }
            return null;
        }
    });

    private SafeWindowLayoutComponentProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(ClassLoader classLoader) {
        return Build.VERSION.SDK_INT >= 24 && r(classLoader) && p(classLoader) && q(classLoader) && n(classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(Method method, Class cls) {
        return method.getReturnType().equals(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(Method method, KClass kClass) {
        return j(method, JvmClassMappingKt.a(kClass));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class l(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.FoldingFeature");
    }

    private final boolean n(final ClassLoader classLoader) {
        return s(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Class l11;
                boolean k11;
                boolean z10;
                boolean o11;
                boolean k12;
                boolean o12;
                boolean k13;
                boolean o13;
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.f15388a;
                l11 = safeWindowLayoutComponentProvider.l(classLoader);
                Method getBoundsMethod = l11.getMethod("getBounds", null);
                Method getTypeMethod = l11.getMethod("getType", null);
                Method getStateMethod = l11.getMethod("getState", null);
                Intrinsics.g(getBoundsMethod, "getBoundsMethod");
                k11 = safeWindowLayoutComponentProvider.k(getBoundsMethod, Reflection.b(Rect.class));
                if (k11) {
                    o11 = safeWindowLayoutComponentProvider.o(getBoundsMethod);
                    if (o11) {
                        Intrinsics.g(getTypeMethod, "getTypeMethod");
                        Class cls = Integer.TYPE;
                        k12 = safeWindowLayoutComponentProvider.k(getTypeMethod, Reflection.b(cls));
                        if (k12) {
                            o12 = safeWindowLayoutComponentProvider.o(getTypeMethod);
                            if (o12) {
                                Intrinsics.g(getStateMethod, "getStateMethod");
                                k13 = safeWindowLayoutComponentProvider.k(getStateMethod, Reflection.b(cls));
                                if (k13) {
                                    o13 = safeWindowLayoutComponentProvider.o(getStateMethod);
                                    if (o13) {
                                        z10 = true;
                                        return Boolean.valueOf(z10);
                                    }
                                }
                            }
                        }
                    }
                }
                z10 = false;
                return Boolean.valueOf(z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    private final boolean p(final ClassLoader classLoader) {
        return s(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Class t11;
                Class windowLayoutComponentClass;
                boolean o11;
                boolean z10;
                boolean j11;
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.f15388a;
                t11 = safeWindowLayoutComponentProvider.t(classLoader);
                Method getWindowLayoutComponentMethod = t11.getMethod("getWindowLayoutComponent", null);
                windowLayoutComponentClass = safeWindowLayoutComponentProvider.v(classLoader);
                Intrinsics.g(getWindowLayoutComponentMethod, "getWindowLayoutComponentMethod");
                o11 = safeWindowLayoutComponentProvider.o(getWindowLayoutComponentMethod);
                if (o11) {
                    Intrinsics.g(windowLayoutComponentClass, "windowLayoutComponentClass");
                    j11 = safeWindowLayoutComponentProvider.j(getWindowLayoutComponentMethod, windowLayoutComponentClass);
                    if (j11) {
                        z10 = true;
                        return Boolean.valueOf(z10);
                    }
                }
                z10 = false;
                return Boolean.valueOf(z10);
            }
        });
    }

    private final boolean q(final ClassLoader classLoader) {
        return s(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Class v11;
                boolean o11;
                boolean o12;
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.f15388a;
                v11 = safeWindowLayoutComponentProvider.v(classLoader);
                boolean z10 = false;
                Method addListenerMethod = v11.getMethod("addWindowLayoutInfoListener", Activity.class, s.a());
                Method removeListenerMethod = v11.getMethod("removeWindowLayoutInfoListener", s.a());
                Intrinsics.g(addListenerMethod, "addListenerMethod");
                o11 = safeWindowLayoutComponentProvider.o(addListenerMethod);
                if (o11) {
                    Intrinsics.g(removeListenerMethod, "removeListenerMethod");
                    o12 = safeWindowLayoutComponentProvider.o(removeListenerMethod);
                    if (o12) {
                        z10 = true;
                    }
                }
                return Boolean.valueOf(z10);
            }
        });
    }

    private final boolean r(final ClassLoader classLoader) {
        return s(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Class u11;
                Class windowExtensionsClass;
                boolean j11;
                boolean z10;
                boolean o11;
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.f15388a;
                u11 = safeWindowLayoutComponentProvider.u(classLoader);
                Method getWindowExtensionsMethod = u11.getDeclaredMethod("getWindowExtensions", null);
                windowExtensionsClass = safeWindowLayoutComponentProvider.t(classLoader);
                Intrinsics.g(getWindowExtensionsMethod, "getWindowExtensionsMethod");
                Intrinsics.g(windowExtensionsClass, "windowExtensionsClass");
                j11 = safeWindowLayoutComponentProvider.j(getWindowExtensionsMethod, windowExtensionsClass);
                if (j11) {
                    o11 = safeWindowLayoutComponentProvider.o(getWindowExtensionsMethod);
                    if (o11) {
                        z10 = true;
                        return Boolean.valueOf(z10);
                    }
                }
                z10 = false;
                return Boolean.valueOf(z10);
            }
        });
    }

    private final boolean s(Function0 function0) {
        try {
            return ((Boolean) function0.invoke()).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class t(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class u(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class v(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
    }

    public final WindowLayoutComponent m() {
        return (WindowLayoutComponent) f15389b.getValue();
    }
}
