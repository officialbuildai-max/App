package com.transsion.shorttv_pugc.base.locale;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class e implements Application.ActivityLifecycleCallbacks {

    /* renamed from: d, reason: collision with root package name */
    public static final a f53846d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray f53847a = new SparseArray(4);

    /* renamed from: b, reason: collision with root package name */
    private int f53848b;

    /* renamed from: c, reason: collision with root package name */
    private Integer f53849c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Activity f53850a;

        /* renamed from: b, reason: collision with root package name */
        private Locale f53851b;

        /* renamed from: c, reason: collision with root package name */
        private Locale f53852c;

        public b(Activity activity) {
            Intrinsics.h(activity, "activity");
            this.f53850a = activity;
        }

        public final Activity a() {
            return this.f53850a;
        }

        public final Locale b() {
            return this.f53852c;
        }

        public final Locale c() {
            return this.f53851b;
        }

        public final void d(Locale locale) {
            this.f53852c = locale;
        }

        public final void e(Locale locale) {
            this.f53851b = locale;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(View view) {
        if (view instanceof ft.a) {
            ((ft.a) view).changeLocal();
        } else if (view instanceof ViewGroup) {
            Iterator f67553a = ViewGroupKt.getChildren((ViewGroup) view).getF67553a();
            while (f67553a.hasNext()) {
                a((View) f67553a.next());
            }
        }
    }

    private final void b(Activity activity) {
        a.C0856a.f(lg.a.f68962a, "LocaleManagerCB", "notifyActivityChangedLocale()-> activity = " + activity + " , waitChangedCount = " + this.f53848b, false, 4, null);
        if (this.f53848b <= 0) {
            return;
        }
        b bVar = (b) this.f53847a.get(System.identityHashCode(activity));
        if ((bVar != null ? bVar.c() : null) == null) {
            return;
        }
        this.f53848b--;
        boolean z10 = TextUtils.getLayoutDirectionFromLocale(bVar.b()) == TextUtils.getLayoutDirectionFromLocale(bVar.c());
        bVar.d(bVar.c());
        bVar.e(null);
        if (z10) {
            return;
        }
        d(activity);
    }

    private final void c() {
        Integer num = this.f53849c;
        if (num == null) {
            return;
        }
        SparseArray sparseArray = this.f53847a;
        Intrinsics.e(num);
        b bVar = (b) sparseArray.get(num.intValue());
        if (bVar == null) {
            return;
        }
        b(bVar.a());
    }

    private final void d(Activity activity) {
        activity.finish();
        Intent intent = activity.getIntent();
        intent.putExtra("extra_language_activity_restart", true);
        activity.startActivity(intent);
    }

    public final void e(Locale locale) {
        int i11;
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new UnsupportedOperationException();
        }
        int size = this.f53847a.size();
        boolean z10 = false;
        if (size <= 0) {
            this.f53848b = 0;
            return;
        }
        int i12 = this.f53848b;
        int i13 = 0;
        while (i13 < size) {
            b bVar = (b) this.f53847a.valueAt(i13);
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, "LocaleManagerCB", "setLocaleChanged()-> localeState = " + bVar, false, 4, null);
            if (bVar != null) {
                Activity a11 = bVar.a();
                boolean z11 = (a11.isFinishing() || a11.isDestroyed()) ? true : z10;
                boolean z12 = z11;
                a.C0856a.f(c0856a, "LocaleManagerCB", "setLocaleChanged()-> activityFinished = " + z11, false, 4, null);
                if (!z12) {
                    Locale b11 = bVar.b();
                    Intrinsics.e(b11);
                    String language = b11.getLanguage();
                    Intrinsics.e(locale);
                    String language2 = locale.getLanguage();
                    Locale c11 = bVar.c();
                    boolean z13 = TextUtils.getLayoutDirectionFromLocale(b11) != TextUtils.getLayoutDirectionFromLocale(locale) ? z10 : true;
                    i11 = size;
                    a.C0856a.f(c0856a, "LocaleManagerCB", "setLocaleChanged()-> locale = " + locale + " , activityLocale = " + b11 + " , expectLocale = " + c11 + " , isSameDirection = " + z13, false, 4, null);
                    if (Intrinsics.c(language, language2)) {
                        bVar.e(null);
                        if (c11 != null) {
                            i12--;
                            a.C0856a.f(c0856a, "LocaleManagerCB", "setLocaleChanged()-> waitChangedCount--", false, 4, null);
                        }
                    } else {
                        bVar.e(locale);
                        if (c11 == null) {
                            i12++;
                            a.C0856a.f(c0856a, "LocaleManagerCB", "setLocaleChanged()-> waitChangedCount++", false, 4, null);
                        }
                        if (z13) {
                            Configuration configuration = a11.getResources().getConfiguration();
                            Intrinsics.g(configuration, "getConfiguration(...)");
                            Resources resources = a11.getResources();
                            Intrinsics.g(resources, "getResources(...)");
                            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                            Intrinsics.g(displayMetrics, "getDisplayMetrics(...)");
                            bVar.d(locale);
                            bVar.e(null);
                            configuration.setLocale(locale);
                            resources.updateConfiguration(configuration, displayMetrics);
                            View findViewById = a11.getWindow().getDecorView().findViewById(R.id.content);
                            if (findViewById != null) {
                                a(findViewById);
                            }
                        }
                    }
                    i13++;
                    size = i11;
                    z10 = false;
                }
            }
            i11 = size;
            i13++;
            size = i11;
            z10 = false;
        }
        this.f53848b = i12;
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.h(activity, "activity");
        int identityHashCode = System.identityHashCode(activity);
        b bVar = new b(activity);
        bVar.d(d.f53835f.d(activity));
        a.C0856a.f(lg.a.f68962a, "LocaleManagerCB", "onActivityCreated()-> " + activity + " , curLocale = " + bVar.b(), false, 4, null);
        this.f53847a.put(identityHashCode, bVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.h(activity, "activity");
        int identityHashCode = System.identityHashCode(activity);
        b bVar = (b) this.f53847a.get(identityHashCode);
        if ((bVar != null ? bVar.c() : null) != null) {
            bVar.e(null);
            this.f53848b--;
        }
        this.f53847a.remove(identityHashCode);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.h(activity, "activity");
        int identityHashCode = System.identityHashCode(activity);
        Integer num = this.f53849c;
        if (num == null || num == null || identityHashCode != num.intValue()) {
            return;
        }
        this.f53849c = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.h(activity, "activity");
        a.C0856a.f(lg.a.f68962a, "LocaleManagerCB", "onActivityResumed()-> " + activity, false, 4, null);
        this.f53849c = Integer.valueOf(System.identityHashCode(activity));
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.h(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.h(activity, "activity");
    }
}
