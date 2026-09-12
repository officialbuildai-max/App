package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.f;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    static c f1236a = new c(new d());

    /* renamed from: b, reason: collision with root package name */
    private static int f1237b = -100;

    /* renamed from: c, reason: collision with root package name */
    private static androidx.core.os.i f1238c = null;

    /* renamed from: d, reason: collision with root package name */
    private static androidx.core.os.i f1239d = null;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f1240e = null;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f1241f = false;

    /* renamed from: g, reason: collision with root package name */
    private static final androidx.collection.b f1242g = new androidx.collection.b();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f1243h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static final Object f1244i = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Object f1245a = new Object();

        /* renamed from: b, reason: collision with root package name */
        final Queue f1246b = new ArrayDeque();

        /* renamed from: c, reason: collision with root package name */
        final Executor f1247c;

        /* renamed from: d, reason: collision with root package name */
        Runnable f1248d;

        c(Executor executor) {
            this.f1247c = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                c();
            }
        }

        protected void c() {
            synchronized (this.f1245a) {
                try {
                    Runnable runnable = (Runnable) this.f1246b.poll();
                    this.f1248d = runnable;
                    if (runnable != null) {
                        this.f1247c.execute(runnable);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this.f1245a) {
                try {
                    this.f1246b.add(new Runnable() { // from class: androidx.appcompat.app.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.c.this.b(runnable);
                        }
                    });
                    if (this.f1248d == null) {
                        c();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    static class d implements Executor {
        d() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void I(f fVar) {
        synchronized (f1243h) {
            J(fVar);
        }
    }

    private static void J(f fVar) {
        synchronized (f1243h) {
            try {
                Iterator it = f1242g.iterator();
                while (it.hasNext()) {
                    f fVar2 = (f) ((WeakReference) it.next()).get();
                    if (fVar2 == fVar || fVar2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void O(int i11) {
        if ((i11 == -1 || i11 == 0 || i11 == 1 || i11 == 2 || i11 == 3) && f1237b != i11) {
            f1237b = i11;
            g();
        }
    }

    static void U(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (n().f()) {
                    String b11 = androidx.core.app.d.b(context);
                    Object systemService = context.getSystemService("locale");
                    if (systemService != null) {
                        b.b(systemService, a.a(b11));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void V(final Context context) {
        if (y(context)) {
            if (Build.VERSION.SDK_INT >= 33) {
                if (f1241f) {
                    return;
                }
                f1236a.execute(new Runnable() { // from class: androidx.appcompat.app.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.z(context);
                    }
                });
                return;
            }
            synchronized (f1244i) {
                try {
                    androidx.core.os.i iVar = f1238c;
                    if (iVar == null) {
                        if (f1239d == null) {
                            f1239d = androidx.core.os.i.c(androidx.core.app.d.b(context));
                        }
                        if (f1239d.f()) {
                        } else {
                            f1238c = f1239d;
                        }
                    } else if (!iVar.equals(f1239d)) {
                        androidx.core.os.i iVar2 = f1238c;
                        f1239d = iVar2;
                        androidx.core.app.d.a(context, iVar2.h());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(f fVar) {
        synchronized (f1243h) {
            J(fVar);
            f1242g.add(new WeakReference(fVar));
        }
    }

    private static void g() {
        synchronized (f1243h) {
            try {
                Iterator it = f1242g.iterator();
                while (it.hasNext()) {
                    f fVar = (f) ((WeakReference) it.next()).get();
                    if (fVar != null) {
                        fVar.f();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static f j(Activity activity, androidx.appcompat.app.d dVar) {
        return new AppCompatDelegateImpl(activity, dVar);
    }

    public static f k(Dialog dialog, androidx.appcompat.app.d dVar) {
        return new AppCompatDelegateImpl(dialog, dVar);
    }

    public static androidx.core.os.i n() {
        if (Build.VERSION.SDK_INT >= 33) {
            Object s11 = s();
            if (s11 != null) {
                return androidx.core.os.i.j(b.a(s11));
            }
        } else {
            androidx.core.os.i iVar = f1238c;
            if (iVar != null) {
                return iVar;
            }
        }
        return androidx.core.os.i.e();
    }

    public static int p() {
        return f1237b;
    }

    static Object s() {
        Context o11;
        Iterator it = f1242g.iterator();
        while (it.hasNext()) {
            f fVar = (f) ((WeakReference) it.next()).get();
            if (fVar != null && (o11 = fVar.o()) != null) {
                return o11.getSystemService("locale");
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static androidx.core.os.i u() {
        return f1238c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean y(Context context) {
        if (f1240e == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    f1240e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f1240e = Boolean.FALSE;
            }
        }
        return f1240e.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(Context context) {
        U(context);
        f1241f = true;
    }

    public abstract void A(Configuration configuration);

    public abstract void B(Bundle bundle);

    public abstract void C();

    public abstract void D(Bundle bundle);

    public abstract void E();

    public abstract void F(Bundle bundle);

    public abstract void G();

    public abstract void H();

    public abstract boolean K(int i11);

    public abstract void L(int i11);

    public abstract void M(View view);

    public abstract void N(View view, ViewGroup.LayoutParams layoutParams);

    public void P(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void Q(Toolbar toolbar);

    public abstract void R(int i11);

    public abstract void S(CharSequence charSequence);

    public abstract androidx.appcompat.view.b T(b.a aVar);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean f();

    public void h(Context context) {
    }

    public Context i(Context context) {
        h(context);
        return context;
    }

    public abstract View l(View view, String str, Context context, AttributeSet attributeSet);

    public abstract View m(int i11);

    public abstract Context o();

    public abstract androidx.appcompat.app.b q();

    public abstract int r();

    public abstract MenuInflater t();

    public abstract androidx.appcompat.app.a v();

    public abstract void w();

    public abstract void x();
}
