package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class g0 extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f2103c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList f2104d;

    /* renamed from: a, reason: collision with root package name */
    private final Resources f2105a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources.Theme f2106b;

    private g0(Context context) {
        super(context);
        if (!t0.c()) {
            this.f2105a = new i0(this, context.getResources());
            this.f2106b = null;
            return;
        }
        t0 t0Var = new t0(this, context.getResources());
        this.f2105a = t0Var;
        Resources.Theme newTheme = t0Var.newTheme();
        this.f2106b = newTheme;
        newTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        if ((context instanceof g0) || (context.getResources() instanceof i0) || (context.getResources() instanceof t0)) {
            return false;
        }
        return t0.c();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f2103c) {
            try {
                ArrayList arrayList = f2104d;
                if (arrayList == null) {
                    f2104d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f2104d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f2104d.remove(size);
                        }
                    }
                    for (int size2 = f2104d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f2104d.get(size2);
                        g0 g0Var = weakReference2 != null ? (g0) weakReference2.get() : null;
                        if (g0Var != null && g0Var.getBaseContext() == context) {
                            return g0Var;
                        }
                    }
                }
                g0 g0Var2 = new g0(context);
                f2104d.add(new WeakReference(g0Var2));
                return g0Var2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f2105a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f2105a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2106b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i11) {
        Resources.Theme theme = this.f2106b;
        if (theme == null) {
            super.setTheme(i11);
        } else {
            theme.applyStyle(i11, true);
        }
    }
}
