package z0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.x0;
import androidx.core.provider.k;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import y0.e;

/* loaded from: classes2.dex */
class k extends o {

    /* renamed from: b, reason: collision with root package name */
    private static final Class f79265b;

    /* renamed from: c, reason: collision with root package name */
    private static final Constructor f79266c;

    /* renamed from: d, reason: collision with root package name */
    private static final Method f79267d;

    /* renamed from: e, reason: collision with root package name */
    private static final Method f79268e;

    static {
        Method method;
        Class<?> cls;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e11) {
            Log.e("TypefaceCompatApi24Impl", e11.getClass().getName(), e11);
            method = null;
            cls = null;
            method2 = null;
        }
        f79266c = constructor;
        f79265b = cls;
        f79267d = method2;
        f79268e = method;
    }

    private static boolean i(Object obj, ByteBuffer byteBuffer, int i11, int i12, boolean z10) {
        try {
            return ((Boolean) f79267d.invoke(obj, byteBuffer, Integer.valueOf(i11), null, Integer.valueOf(i12), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface j(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) f79265b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f79268e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean k() {
        Method method = f79267d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object l() {
        try {
            return f79266c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // z0.o
    public Typeface a(Context context, e.c cVar, Resources resources, int i11) {
        Object l11 = l();
        if (l11 == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            ByteBuffer b11 = p.b(context, resources, dVar.b());
            if (b11 == null || !i(l11, b11, dVar.c(), dVar.e(), dVar.f())) {
                return null;
            }
        }
        return j(l11);
    }

    @Override // z0.o
    public Typeface b(Context context, CancellationSignal cancellationSignal, k.b[] bVarArr, int i11) {
        Object l11 = l();
        if (l11 == null) {
            return null;
        }
        x0 x0Var = new x0();
        for (k.b bVar : bVarArr) {
            Uri d11 = bVar.d();
            ByteBuffer byteBuffer = (ByteBuffer) x0Var.get(d11);
            if (byteBuffer == null) {
                byteBuffer = p.f(context, cancellationSignal, d11);
                x0Var.put(d11, byteBuffer);
            }
            if (byteBuffer == null || !i(l11, byteBuffer, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface j11 = j(l11);
        if (j11 == null) {
            return null;
        }
        return Typeface.create(j11, i11);
    }
}
