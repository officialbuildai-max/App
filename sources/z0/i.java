package z0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.z;
import androidx.core.provider.k;
import java.util.List;
import y0.e;
import y0.h;

/* loaded from: classes2.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private static final o f79257a;

    /* renamed from: b, reason: collision with root package name */
    private static final z f79258b;

    /* loaded from: classes2.dex */
    public static class a extends k.c {

        /* renamed from: a, reason: collision with root package name */
        private h.e f79259a;

        public a(h.e eVar) {
            this.f79259a = eVar;
        }

        @Override // androidx.core.provider.k.c
        public void a(int i11) {
            h.e eVar = this.f79259a;
            if (eVar != null) {
                eVar.f(i11);
            }
        }

        @Override // androidx.core.provider.k.c
        public void b(Typeface typeface) {
            h.e eVar = this.f79259a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        f4.a.c("TypefaceCompat static init");
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            f79257a = new n();
        } else if (i11 >= 28) {
            f79257a = new m();
        } else if (i11 >= 26) {
            f79257a = new l();
        } else if (i11 < 24 || !k.k()) {
            f79257a = new j();
        } else {
            f79257a = new k();
        }
        f79258b = new z(16);
        f4.a.f();
    }

    public static Typeface a(Context context, Typeface typeface, int i11) {
        if (context != null) {
            return Typeface.create(typeface, i11);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, k.b[] bVarArr, int i11) {
        f4.a.c("TypefaceCompat.createFromFontInfo");
        try {
            return f79257a.b(context, cancellationSignal, bVarArr, i11);
        } finally {
            f4.a.f();
        }
    }

    public static Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i11) {
        f4.a.c("TypefaceCompat.createFromFontInfoWithFallback");
        try {
            return f79257a.c(context, cancellationSignal, list, i11);
        } finally {
            f4.a.f();
        }
    }

    public static Typeface d(Context context, e.b bVar, Resources resources, int i11, String str, int i12, int i13, h.e eVar, Handler handler, boolean z10) {
        Typeface a11;
        if (bVar instanceof e.C0993e) {
            e.C0993e c0993e = (e.C0993e) bVar;
            Typeface h11 = h(c0993e.d());
            if (h11 != null) {
                if (eVar != null) {
                    eVar.d(h11, handler);
                }
                return h11;
            }
            a11 = androidx.core.provider.k.c(context, c0993e.a() != null ? h.a(new Object[]{c0993e.c(), c0993e.a()}) : h.a(new Object[]{c0993e.c()}), i13, !z10 ? eVar != null : c0993e.b() != 0, z10 ? c0993e.e() : -1, h.e.e(handler), new a(eVar));
        } else {
            a11 = f79257a.a(context, (e.c) bVar, resources, i13);
            if (eVar != null) {
                if (a11 != null) {
                    eVar.d(a11, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (a11 != null) {
            f79258b.put(f(resources, i11, str, i12, i13), a11);
        }
        return a11;
    }

    public static Typeface e(Context context, Resources resources, int i11, String str, int i12, int i13) {
        Typeface e11 = f79257a.e(context, resources, i11, str, i13);
        if (e11 != null) {
            f79258b.put(f(resources, i11, str, i12, i13), e11);
        }
        return e11;
    }

    private static String f(Resources resources, int i11, String str, int i12, int i13) {
        return resources.getResourcePackageName(i11) + '-' + str + '-' + i12 + '-' + i11 + '-' + i13;
    }

    public static Typeface g(Resources resources, int i11, String str, int i12, int i13) {
        return (Typeface) f79258b.get(f(resources, i11, str, i12, i13));
    }

    private static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
