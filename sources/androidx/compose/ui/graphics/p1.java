package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class p1 {

    /* renamed from: a, reason: collision with root package name */
    public static final p1 f4686a = new p1();

    /* renamed from: b, reason: collision with root package name */
    private static Method f4687b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f4688c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f4689d;

    private p1() {
    }

    public final void a(Canvas canvas, boolean z10) {
        Method method;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            s1.f4711a.a(canvas, z10);
            return;
        }
        if (!f4689d) {
            try {
                if (i11 == 28) {
                    Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass());
                    f4687b = (Method) declaredMethod.invoke(Canvas.class, "insertReorderBarrier", new Class[0]);
                    f4688c = (Method) declaredMethod.invoke(Canvas.class, "insertInorderBarrier", new Class[0]);
                } else {
                    f4687b = Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                    f4688c = Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
                }
                Method method2 = f4687b;
                if (method2 != null) {
                    method2.setAccessible(true);
                }
                Method method3 = f4688c;
                if (method3 != null) {
                    method3.setAccessible(true);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            f4689d = true;
        }
        if (z10) {
            try {
                Method method4 = f4687b;
                if (method4 != null) {
                    Intrinsics.e(method4);
                    method4.invoke(canvas, null);
                }
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return;
            }
        }
        if (z10 || (method = f4688c) == null) {
            return;
        }
        Intrinsics.e(method);
        method.invoke(canvas, null);
    }
}
