package z0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.provider.k;
import com.google.logging.type.LogSeverity;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import y0.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap f79276a = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements b {
        a() {
        }

        @Override // z0.o.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(k.b bVar) {
            return bVar.e();
        }

        @Override // z0.o.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(k.b bVar) {
            return bVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        boolean a(Object obj);

        int b(Object obj);
    }

    private static Object f(Object[] objArr, int i11, b bVar) {
        return g(objArr, (i11 & 1) == 0 ? 400 : LogSeverity.ALERT_VALUE, (i11 & 2) != 0, bVar);
    }

    private static Object g(Object[] objArr, int i11, boolean z10, b bVar) {
        Object obj = null;
        int i12 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int abs = (Math.abs(bVar.b(obj2) - i11) * 2) + (bVar.a(obj2) == z10 ? 0 : 1);
            if (obj == null || i12 > abs) {
                obj = obj2;
                i12 = abs;
            }
        }
        return obj;
    }

    public abstract Typeface a(Context context, e.c cVar, Resources resources, int i11);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, k.b[] bVarArr, int i11);

    public Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i11) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface d(Context context, InputStream inputStream) {
        File e11 = p.e(context);
        if (e11 == null) {
            return null;
        }
        try {
            if (p.d(e11, inputStream)) {
                return Typeface.createFromFile(e11.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e11.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i11, String str, int i12) {
        File e11 = p.e(context);
        if (e11 == null) {
            return null;
        }
        try {
            if (p.c(e11, resources, i11)) {
                return Typeface.createFromFile(e11.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e11.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k.b h(k.b[] bVarArr, int i11) {
        return (k.b) f(bVarArr, i11, new a());
    }
}
