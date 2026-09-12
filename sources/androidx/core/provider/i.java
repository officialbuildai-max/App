package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import androidx.collection.x0;
import androidx.collection.z;
import androidx.core.provider.k;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    static final z f8277a = new z(16);

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f8278b = RequestExecutor.a("fonts-androidx", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    static final Object f8279c = new Object();

    /* renamed from: d, reason: collision with root package name */
    static final x0 f8280d = new x0();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8281a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f8282b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.core.provider.e f8283c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f8284d;

        a(String str, Context context, androidx.core.provider.e eVar, int i11) {
            this.f8281a = str;
            this.f8282b = context;
            this.f8283c = eVar;
            this.f8284d = i11;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            List a11;
            String str = this.f8281a;
            Context context = this.f8282b;
            a11 = z0.h.a(new Object[]{this.f8283c});
            return i.c(str, context, a11, this.f8284d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements androidx.core.util.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallbackWrapper f8285a;

        b(CallbackWrapper callbackWrapper) {
            this.f8285a = callbackWrapper;
        }

        @Override // androidx.core.util.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f8285a.b(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8286a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f8287b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f8288c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f8289d;

        c(String str, Context context, List list, int i11) {
            this.f8286a = str;
            this.f8287b = context;
            this.f8288c = list;
            this.f8289d = i11;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return i.c(this.f8286a, this.f8287b, this.f8288c, this.f8289d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements androidx.core.util.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8290a;

        d(String str) {
            this.f8290a = str;
        }

        @Override // androidx.core.util.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (i.f8279c) {
                try {
                    x0 x0Var = i.f8280d;
                    ArrayList arrayList = (ArrayList) x0Var.get(this.f8290a);
                    if (arrayList == null) {
                        return;
                    }
                    x0Var.remove(this.f8290a);
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        ((androidx.core.util.a) arrayList.get(i11)).accept(eVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        final Typeface f8291a;

        /* renamed from: b, reason: collision with root package name */
        final int f8292b;

        e(int i11) {
            this.f8291a = null;
            this.f8292b = i11;
        }

        e(Typeface typeface) {
            this.f8291a = typeface;
            this.f8292b = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return this.f8292b == 0;
        }
    }

    private static String a(List list, int i11) {
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 0; i12 < list.size(); i12++) {
            sb2.append(((androidx.core.provider.e) list.get(i12)).d());
            sb2.append("-");
            sb2.append(i11);
            if (i12 < list.size() - 1) {
                sb2.append(";");
            }
        }
        return sb2.toString();
    }

    private static int b(k.a aVar) {
        int i11 = 1;
        if (aVar.e() != 0) {
            return aVar.e() != 1 ? -3 : -2;
        }
        k.b[] c11 = aVar.c();
        if (c11 != null && c11.length != 0) {
            i11 = 0;
            for (k.b bVar : c11) {
                int b11 = bVar.b();
                if (b11 != 0) {
                    if (b11 < 0) {
                        return -3;
                    }
                    return b11;
                }
            }
        }
        return i11;
    }

    static e c(String str, Context context, List list, int i11) {
        f4.a.c("getFontSync");
        try {
            z zVar = f8277a;
            Typeface typeface = (Typeface) zVar.get(str);
            if (typeface != null) {
                return new e(typeface);
            }
            k.a e11 = androidx.core.provider.d.e(context, list, null);
            int b11 = b(e11);
            if (b11 != 0) {
                return new e(b11);
            }
            Typeface b12 = (!e11.f() || Build.VERSION.SDK_INT < 29) ? z0.i.b(context, null, e11.c(), i11) : z0.i.c(context, null, e11.d(), i11);
            if (b12 == null) {
                return new e(-3);
            }
            zVar.put(str, b12);
            return new e(b12);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        } finally {
            f4.a.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface d(Context context, List list, int i11, Executor executor, CallbackWrapper callbackWrapper) {
        String a11 = a(list, i11);
        Typeface typeface = (Typeface) f8277a.get(a11);
        if (typeface != null) {
            callbackWrapper.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(callbackWrapper);
        synchronized (f8279c) {
            try {
                x0 x0Var = f8280d;
                ArrayList arrayList = (ArrayList) x0Var.get(a11);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                x0Var.put(a11, arrayList2);
                c cVar = new c(a11, context, list, i11);
                if (executor == null) {
                    executor = f8278b;
                }
                RequestExecutor.c(executor, cVar, new d(a11));
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface e(Context context, androidx.core.provider.e eVar, CallbackWrapper callbackWrapper, int i11, int i12) {
        List a11;
        List a12;
        a11 = z0.h.a(new Object[]{eVar});
        String a13 = a(a11, i11);
        Typeface typeface = (Typeface) f8277a.get(a13);
        if (typeface != null) {
            callbackWrapper.b(new e(typeface));
            return typeface;
        }
        if (i12 == -1) {
            a12 = z0.h.a(new Object[]{eVar});
            e c11 = c(a13, context, a12, i11);
            callbackWrapper.b(c11);
            return c11.f8291a;
        }
        try {
            e eVar2 = (e) RequestExecutor.d(f8278b, new a(a13, context, eVar, i11), i12);
            callbackWrapper.b(eVar2);
            return eVar2.f8291a;
        } catch (InterruptedException unused) {
            callbackWrapper.b(new e(-3));
            return null;
        }
    }
}
