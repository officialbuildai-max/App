package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    private static Configuration f1336f;

    /* renamed from: a, reason: collision with root package name */
    private int f1337a;

    /* renamed from: b, reason: collision with root package name */
    private Resources.Theme f1338b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f1339c;

    /* renamed from: d, reason: collision with root package name */
    private Configuration f1340d;

    /* renamed from: e, reason: collision with root package name */
    private Resources f1341e;

    public d() {
        super(null);
    }

    public d(Context context, int i11) {
        super(context);
        this.f1337a = i11;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f1338b = theme;
    }

    private Resources b() {
        if (this.f1341e == null) {
            Configuration configuration = this.f1340d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) {
                this.f1341e = super.getResources();
            } else {
                this.f1341e = createConfigurationContext(this.f1340d).getResources();
            }
        }
        return this.f1341e;
    }

    private void d() {
        boolean z10 = this.f1338b == null;
        if (z10) {
            this.f1338b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1338b.setTo(theme);
            }
        }
        f(this.f1338b, this.f1337a, z10);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f1336f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f1336f = configuration2;
        }
        return configuration.equals(f1336f);
    }

    public void a(Configuration configuration) {
        if (this.f1341e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f1340d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f1340d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f1337a;
    }

    protected void f(Resources.Theme theme, int i11, boolean z10) {
        theme.applyStyle(i11, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1339c == null) {
            this.f1339c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1339c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1338b;
        if (theme != null) {
            return theme;
        }
        if (this.f1337a == 0) {
            this.f1337a = R$style.Theme_AppCompat_Light;
        }
        d();
        return this.f1338b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i11) {
        if (this.f1337a != i11) {
            this.f1337a = i11;
            d();
        }
    }
}
