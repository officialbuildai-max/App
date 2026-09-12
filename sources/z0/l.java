package z0;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.provider.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import y0.e;

/* loaded from: classes2.dex */
public class l extends j {

    /* renamed from: g, reason: collision with root package name */
    protected final Class f79269g;

    /* renamed from: h, reason: collision with root package name */
    protected final Constructor f79270h;

    /* renamed from: i, reason: collision with root package name */
    protected final Method f79271i;

    /* renamed from: j, reason: collision with root package name */
    protected final Method f79272j;

    /* renamed from: k, reason: collision with root package name */
    protected final Method f79273k;

    /* renamed from: l, reason: collision with root package name */
    protected final Method f79274l;

    /* renamed from: m, reason: collision with root package name */
    protected final Method f79275m;

    public l() {
        Class cls;
        Constructor constructor;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            cls = w();
            constructor = x(cls);
            method = t(cls);
            method2 = u(cls);
            method3 = y(cls);
            method4 = s(cls);
            method5 = v(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e11) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e11.getClass().getName(), e11);
            cls = null;
            constructor = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f79269g = cls;
        this.f79270h = constructor;
        this.f79271i = method;
        this.f79272j = method2;
        this.f79273k = method3;
        this.f79274l = method4;
        this.f79275m = method5;
    }

    private Object m() {
        try {
            return this.f79270h.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void n(Object obj) {
        try {
            this.f79274l.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean o(Context context, Object obj, String str, int i11, int i12, int i13, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f79271i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean p(Object obj, ByteBuffer byteBuffer, int i11, int i12, int i13) {
        try {
            return ((Boolean) this.f79272j.invoke(obj, byteBuffer, Integer.valueOf(i11), null, Integer.valueOf(i12), Integer.valueOf(i13))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean q(Object obj) {
        try {
            return ((Boolean) this.f79273k.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean r() {
        if (this.f79271i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f79271i != null;
    }

    @Override // z0.j, z0.o
    public Typeface a(Context context, e.c cVar, Resources resources, int i11) {
        if (!r()) {
            return super.a(context, cVar, resources, i11);
        }
        Object m11 = m();
        if (m11 == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            if (!o(context, m11, dVar.a(), dVar.c(), dVar.e(), dVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d()))) {
                n(m11);
                return null;
            }
        }
        if (q(m11)) {
            return j(m11);
        }
        return null;
    }

    @Override // z0.j, z0.o
    public Typeface b(Context context, CancellationSignal cancellationSignal, k.b[] bVarArr, int i11) {
        Typeface j11;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!r()) {
            k.b h11 = h(bVarArr, i11);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(h11.d(), CampaignEx.JSON_KEY_AD_R, cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(h11.e()).setItalic(h11.f()).build();
                    openFileDescriptor.close();
                    return build;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map h12 = p.h(context, bVarArr, cancellationSignal);
        Object m11 = m();
        if (m11 == null) {
            return null;
        }
        boolean z10 = false;
        for (k.b bVar : bVarArr) {
            ByteBuffer byteBuffer = (ByteBuffer) h12.get(bVar.d());
            if (byteBuffer != null) {
                if (!p(m11, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    n(m11);
                    return null;
                }
                z10 = true;
            }
        }
        if (!z10) {
            n(m11);
            return null;
        }
        if (q(m11) && (j11 = j(m11)) != null) {
            return Typeface.create(j11, i11);
        }
        return null;
    }

    @Override // z0.o
    public /* bridge */ /* synthetic */ Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i11) {
        return super.c(context, cancellationSignal, list, i11);
    }

    @Override // z0.o
    public Typeface e(Context context, Resources resources, int i11, String str, int i12) {
        if (!r()) {
            return super.e(context, resources, i11, str, i12);
        }
        Object m11 = m();
        if (m11 == null) {
            return null;
        }
        if (!o(context, m11, str, 0, -1, -1, null)) {
            n(m11);
            return null;
        }
        if (q(m11)) {
            return j(m11);
        }
        return null;
    }

    protected Typeface j(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.f79269g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f79275m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method s(Class cls) {
        return cls.getMethod("abortCreation", null);
    }

    protected Method t(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method u(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method v(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class w() {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor x(Class cls) {
        return cls.getConstructor(null);
    }

    protected Method y(Class cls) {
        return cls.getMethod("freeze", null);
    }
}
