package z0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.provider.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import y0.e;

/* loaded from: classes2.dex */
class j extends o {

    /* renamed from: b, reason: collision with root package name */
    private static Class f79260b;

    /* renamed from: c, reason: collision with root package name */
    private static Constructor f79261c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f79262d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f79263e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f79264f;

    private static boolean i(Object obj, String str, int i11, boolean z10) {
        l();
        try {
            return ((Boolean) f79262d.invoke(obj, str, Integer.valueOf(i11), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    private static Typeface j(Object obj) {
        l();
        try {
            Object newInstance = Array.newInstance((Class<?>) f79260b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f79263e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    private File k(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void l() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f79264f) {
            return;
        }
        f79264f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e11) {
            Log.e("TypefaceCompatApi21Impl", e11.getClass().getName(), e11);
            method = null;
            cls = null;
            method2 = null;
        }
        f79261c = constructor;
        f79260b = cls;
        f79262d = method2;
        f79263e = method;
    }

    private static Object m() {
        l();
        try {
            return f79261c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // z0.o
    public Typeface a(Context context, e.c cVar, Resources resources, int i11) {
        Object m11 = m();
        for (e.d dVar : cVar.a()) {
            File e11 = p.e(context);
            if (e11 == null) {
                return null;
            }
            try {
                if (!p.c(e11, resources, dVar.b())) {
                    return null;
                }
                if (!i(m11, e11.getPath(), dVar.e(), dVar.f())) {
                    return null;
                }
                e11.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e11.delete();
            }
        }
        return j(m11);
    }

    @Override // z0.o
    public Typeface b(Context context, CancellationSignal cancellationSignal, k.b[] bVarArr, int i11) {
        if (bVarArr.length < 1) {
            return null;
        }
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
                File k11 = k(openFileDescriptor);
                if (k11 != null && k11.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(k11);
                    openFileDescriptor.close();
                    return createFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    Typeface d11 = super.d(context, fileInputStream);
                    fileInputStream.close();
                    openFileDescriptor.close();
                    return d11;
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    openFileDescriptor.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
