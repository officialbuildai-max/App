package com.transsion.shorttv_pugc.base.locale;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.shorttv_pugc.base.locale.d;
import com.transsion.shorttv_pugc.utils.h;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    public static final b f53835f = new b(null);

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f53836g = {null, "English", "Bahasa Indonesia", "Français", "Português", "العربية", "বাংলা", "Русский", "ਪੰਜਾਬੀ", "اردو", "Filipino"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f53837h = {null, Locale.ENGLISH.getLanguage(), "in", "fr", "pt", "ar", "bn", "ru", "pa", "ur", "fil"};

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy f53838i = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.base.locale.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            d i11;
            i11 = d.i();
            return i11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private Locale f53839a;

    /* renamed from: b, reason: collision with root package name */
    private Locale f53840b;

    /* renamed from: c, reason: collision with root package name */
    private String f53841c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f53842d;

    /* renamed from: e, reason: collision with root package name */
    private final e f53843e;

    /* loaded from: classes6.dex */
    public static final class a implements ComponentCallbacks2 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f53845b;

        a(Context context) {
            this.f53845b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(d dVar, Locale locale, Locale locale2, Context context) {
            if (dVar.h() == locale) {
                String country = locale2.getCountry();
                Intrinsics.g(country, "getCountry(...)");
                dVar.k(null, country, true);
            } else {
                Intrinsics.e(context);
                dVar.m(context, dVar.h());
            }
            a.C0856a.f(lg.a.f68962a, "LocaleManager", "onConfigurationChanged()-> locale = " + locale2, false, 4, null);
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            final Locale locale;
            LocaleList locales;
            Intrinsics.h(newConfig, "newConfig");
            if (Build.VERSION.SDK_INT >= 24) {
                locales = newConfig.getLocales();
                locale = locales.get(0);
            } else {
                locale = newConfig.locale;
            }
            final Locale locale2 = d.this.f53840b;
            if (Intrinsics.c(locale, locale2)) {
                return;
            }
            d dVar = d.this;
            Intrinsics.e(locale);
            dVar.f53840b = locale;
            final d dVar2 = d.this;
            final Context context = this.f53845b;
            ThreadUtils.k(new Runnable() { // from class: com.transsion.shorttv_pugc.base.locale.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.b(d.this, locale2, locale, context);
                }
            });
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i11) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Locale f(String str, String str2) {
            if (str == null || str.length() == 0) {
                return null;
            }
            return new Locale(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String g() {
            return h.f54499a.g().getString("k_language_short_name", null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(String str) {
            if (str != null) {
                int length = str.length() - 1;
                int i11 = 0;
                boolean z10 = false;
                while (i11 <= length) {
                    boolean z11 = Intrinsics.j(str.charAt(!z10 ? i11 : length), 32) <= 0;
                    if (z10) {
                        if (!z11) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z11) {
                        i11++;
                    } else {
                        z10 = true;
                    }
                }
                if (str.subSequence(i11, length + 1).toString().length() != 0) {
                    h.f54499a.g().putString("k_language_short_name", str);
                    return;
                }
            }
            h.f54499a.g().remove("k_language_short_name");
        }

        public final Locale d(Context context) {
            LocaleList locales;
            Locale locale;
            Intrinsics.h(context, "context");
            a.C0856a.f(lg.a.f68962a, "LocaleManager", "getContextLocale()-> context = " + context, false, 4, null);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 24) {
                Locale locale2 = configuration.locale;
                Intrinsics.e(locale2);
                return locale2;
            }
            locales = configuration.getLocales();
            locale = locales.get(0);
            Intrinsics.e(locale);
            return locale;
        }

        public final d e() {
            return (d) d.f53838i.getValue();
        }

        public final Context i(Context context, Locale locale) {
            Intrinsics.h(context, "context");
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            if (Build.VERSION.SDK_INT >= 24) {
                com.transsion.baselib.locale.e.a();
                LocaleList a11 = androidx.compose.ui.text.platform.extensions.a.a(new Locale[]{locale});
                configuration.setLocales(a11);
                LocaleList.setDefault(a11);
            } else {
                configuration.setLocale(locale);
            }
            Context createConfigurationContext = context.createConfigurationContext(configuration);
            Intrinsics.g(createConfigurationContext, "createConfigurationContext(...)");
            return createConfigurationContext;
        }
    }

    private d(Context context) {
        e eVar = new e();
        this.f53843e = eVar;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.f(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Application application = (Application) applicationContext;
        Context baseContext = application.getBaseContext();
        Intrinsics.e(baseContext);
        this.f53842d = baseContext;
        b bVar = f53835f;
        Locale d11 = bVar.d(baseContext);
        this.f53840b = d11;
        String country = d11.getCountry();
        a.C0856a.f(lg.a.f68962a, "LocaleManager", "LocaleManager()->  system locale =" + this.f53840b + ", countryCode = " + country, false, 4, null);
        application.registerActivityLifecycleCallbacks(eVar);
        application.registerComponentCallbacks(new a(baseContext));
        String g11 = bVar.g();
        Intrinsics.e(country);
        k(g11, country, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d i() {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return new d(a11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String str, String str2, boolean z10) {
        yg.b.f79132a.l(str);
        Context context = this.f53842d;
        if (str != null) {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = Intrinsics.j(str.charAt(!z11 ? i11 : length), 32) <= 0;
                if (z11) {
                    if (!z12) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z12) {
                    i11++;
                } else {
                    z11 = true;
                }
            }
            if (str.subSequence(i11, length + 1).toString().length() == 0) {
                str = null;
            }
        }
        if (z10 || !TextUtils.equals(str, this.f53841c)) {
            b bVar = f53835f;
            final Locale f11 = bVar.f(str, str2);
            if (f11 == null) {
                f11 = this.f53840b;
            }
            a.C0856a.f(lg.a.f68962a, "LocaleManager", "setLocale()-> locale = " + f11 + " , language = " + ((Object) str), false, 4, null);
            synchronized (this) {
                this.f53841c = str;
                this.f53839a = f11;
                Locale.setDefault(f11);
                Unit unit = Unit.f67184a;
            }
            m(context, f11);
            bVar.h(str);
            ThreadUtils.k(new Runnable() { // from class: com.transsion.shorttv_pugc.base.locale.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.l(d.this, f11);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(d dVar, Locale locale) {
        a.C0856a.f(lg.a.f68962a, "LocaleManager", "notify changed()-> ", false, 4, null);
        dVar.f53843e.e(locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Context context, Locale locale) {
        Locale locale2;
        LocaleList locales;
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            locales = configuration.getLocales();
            locale2 = locales.get(0);
            Intrinsics.e(locale2);
        } else {
            locale2 = configuration.locale;
            Intrinsics.e(locale2);
        }
        a.C0856a.f(lg.a.f68962a, "LocaleManager", "updateConfig()-> old app locale = " + locale2 + " , new app locale = " + locale, false, 4, null);
        Configuration configuration2 = new Configuration(configuration);
        configuration2.setLocale(locale);
        resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
    }

    public final synchronized Locale h() {
        return this.f53839a;
    }

    public final void j(String str) {
        if (Build.VERSION.SDK_INT == 23 && Intrinsics.c("ur", str)) {
            k(str, "PK", false);
            return;
        }
        String country = this.f53840b.getCountry();
        Intrinsics.g(country, "getCountry(...)");
        k(str, country, false);
    }
}
