package androidx.browser.trusted;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class d {

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Parcelable[] f2282a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Parcelable[] parcelableArr) {
            this.f2282a = parcelableArr;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", this.f2282a);
            return bundle;
        }
    }

    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f2283a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2284b;

        b(String str, int i11) {
            this.f2283a = str;
            this.f2284b = i11;
        }

        public static b a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            return new b(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }
    }

    /* loaded from: classes.dex */
    static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f2285a;

        c(String str) {
            this.f2285a = str;
        }

        public static c a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new c(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    /* renamed from: androidx.browser.trusted.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0026d {

        /* renamed from: a, reason: collision with root package name */
        public final String f2286a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2287b;

        /* renamed from: c, reason: collision with root package name */
        public final Notification f2288c;

        /* renamed from: d, reason: collision with root package name */
        public final String f2289d;

        C0026d(String str, int i11, Notification notification, String str2) {
            this.f2286a = str;
            this.f2287b = i11;
            this.f2288c = notification;
            this.f2289d = str2;
        }

        public static C0026d a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            d.a(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            d.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new C0026d(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    /* loaded from: classes.dex */
    static class e {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f2290a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(boolean z10) {
            this.f2290a = z10;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.f2290a);
            return bundle;
        }
    }

    static void a(Bundle bundle, String str) {
        if (bundle.containsKey(str)) {
            return;
        }
        throw new IllegalArgumentException("Bundle must contain " + str);
    }
}
