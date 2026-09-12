package com.transsion.baselib.locale;

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
import com.transsion.baselib.locale.d;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    public static final b f43351f = new b(null);

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f43352g = {null, "English", "Bahasa Indonesia", "Français", "Português", "العربية", "বাংলা", "Русский", "ਪੰਜਾਬੀ", "اردو", "Filipino", "Bahasa Melayu", "Español"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f43353h = {null, Locale.ENGLISH.getLanguage(), "in", "fr", "pt", "ar", "bn", "ru", "pa", "ur", "fil", "ms", "es"};

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy f43354i = LazyKt.b(new Function0() { // from class: com.transsion.baselib.locale.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            d m11;
            m11 = d.m();
            return m11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private Locale f43355a;

    /* renamed from: b, reason: collision with root package name */
    private Locale f43356b;

    /* renamed from: c, reason: collision with root package name */
    private String f43357c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f43358d;

    /* renamed from: e, reason: collision with root package name */
    private final f f43359e;

    /* loaded from: classes5.dex */
    public static final class a implements ComponentCallbacks2 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f43361b;

        a(Context context) {
            this.f43361b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(d dVar, Locale locale, Locale locale2, Context context) {
            if (dVar.j() == locale) {
                String country = locale2.getCountry();
                Intrinsics.g(country, "getCountry(...)");
                dVar.o(null, country, true);
            } else {
                Intrinsics.e(context);
                dVar.r(context, dVar.j());
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
            final Locale locale2 = d.this.f43356b;
            if (Intrinsics.c(locale, locale2)) {
                return;
            }
            d dVar = d.this;
            Intrinsics.e(locale);
            dVar.f43356b = locale;
            final d dVar2 = d.this;
            final Context context = this.f43361b;
            ThreadUtils.k(new Runnable() { // from class: com.transsion.baselib.locale.c
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

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Locale h(String str, String str2) {
            if (str == null || str.length() == 0) {
                return null;
            }
            return new Locale(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String i() {
            return com.transsion.baselib.report.launch.b.f43424a.b().getString("k_language_short_name", null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j(String str) {
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
                    com.transsion.baselib.report.launch.b.f43424a.b().putString("k_language_short_name", str);
                    return;
                }
            }
            com.transsion.baselib.report.launch.b.f43424a.b().remove("k_language_short_name");
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
            return (d) d.f43354i.getValue();
        }

        public final String[] f() {
            return d.f43353h;
        }

        public final String[] g() {
            return d.f43352g;
        }

        public final Context k(Context context, Locale locale) {
            Intrinsics.h(context, "context");
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            if (Build.VERSION.SDK_INT >= 24) {
                e.a();
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
        f fVar = new f();
        this.f43359e = fVar;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.f(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Application application = (Application) applicationContext;
        Context baseContext = application.getBaseContext();
        Intrinsics.e(baseContext);
        this.f43358d = baseContext;
        b bVar = f43351f;
        Locale d11 = bVar.d(baseContext);
        this.f43356b = d11;
        String country = d11.getCountry();
        a.C0856a.f(lg.a.f68962a, "LocaleManager", "LocaleManager()->  system locale =" + this.f43356b + ", countryCode = " + country, false, 4, null);
        application.registerActivityLifecycleCallbacks(fVar);
        application.registerComponentCallbacks(new a(baseContext));
        String i11 = bVar.i();
        Intrinsics.e(country);
        o(i11, country, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d m() {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return new d(a11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String str, String str2, boolean z10) {
        yg.b.f79132a.l(str);
        Context context = this.f43358d;
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
        if (z10 || !TextUtils.equals(str, this.f43357c)) {
            b bVar = f43351f;
            final Locale h11 = bVar.h(str, str2);
            if (h11 == null) {
                h11 = this.f43356b;
            }
            a.C0856a.f(lg.a.f68962a, "LocaleManager", "setLocale()-> locale = " + h11 + " , language = " + ((Object) str), false, 4, null);
            synchronized (this) {
                this.f43357c = str;
                this.f43355a = h11;
                Locale.setDefault(h11);
                Unit unit = Unit.f67184a;
            }
            r(context, h11);
            bVar.j(str);
            ThreadUtils.k(new Runnable() { // from class: com.transsion.baselib.locale.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.p(d.this, h11);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(d dVar, Locale locale) {
        a.C0856a.f(lg.a.f68962a, "LocaleManager", "notify changed()-> ", false, 4, null);
        dVar.f43359e.e(locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(Context context, Locale locale) {
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

    public final synchronized Locale j() {
        return this.f43355a;
    }

    public final Locale k() {
        return this.f43355a;
    }

    public final Locale l() {
        return this.f43356b;
    }

    public final void n(String str) {
        if (Build.VERSION.SDK_INT == 23 && Intrinsics.c("ur", str)) {
            o(str, "PK", false);
            return;
        }
        String country = this.f43356b.getCountry();
        Intrinsics.g(country, "getCountry(...)");
        o(str, country, false);
    }

    public final boolean q(Locale locale) {
        Intrinsics.h(locale, "locale");
        return this.f43356b == locale;
    }
}
