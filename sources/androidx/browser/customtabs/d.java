package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f2241a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f2242b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        @Nullable
        static String a() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        private ArrayList f2245c;

        /* renamed from: d, reason: collision with root package name */
        private Bundle f2246d;

        /* renamed from: e, reason: collision with root package name */
        private ArrayList f2247e;

        /* renamed from: f, reason: collision with root package name */
        private SparseArray f2248f;

        /* renamed from: g, reason: collision with root package name */
        private Bundle f2249g;

        /* renamed from: a, reason: collision with root package name */
        private final Intent f2243a = new Intent("android.intent.action.VIEW");

        /* renamed from: b, reason: collision with root package name */
        private final b.a f2244b = new b.a();

        /* renamed from: h, reason: collision with root package name */
        private int f2250h = 0;

        /* renamed from: i, reason: collision with root package name */
        private boolean f2251i = true;

        public b() {
        }

        public b(j jVar) {
            if (jVar != null) {
                c(jVar);
            }
        }

        private void b() {
            String a11 = a.a();
            if (TextUtils.isEmpty(a11)) {
                return;
            }
            Bundle bundleExtra = this.f2243a.hasExtra("com.android.browser.headers") ? this.f2243a.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (bundleExtra.containsKey("Accept-Language")) {
                return;
            }
            bundleExtra.putString("Accept-Language", a11);
            this.f2243a.putExtra("com.android.browser.headers", bundleExtra);
        }

        private void d(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            androidx.core.app.f.b(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f2243a.putExtras(bundle);
        }

        public d a() {
            if (!this.f2243a.hasExtra("android.support.customtabs.extra.SESSION")) {
                d(null, null);
            }
            ArrayList<? extends Parcelable> arrayList = this.f2245c;
            if (arrayList != null) {
                this.f2243a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<? extends Parcelable> arrayList2 = this.f2247e;
            if (arrayList2 != null) {
                this.f2243a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f2243a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f2251i);
            this.f2243a.putExtras(this.f2244b.a().a());
            Bundle bundle = this.f2249g;
            if (bundle != null) {
                this.f2243a.putExtras(bundle);
            }
            if (this.f2248f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f2248f);
                this.f2243a.putExtras(bundle2);
            }
            this.f2243a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f2250h);
            if (Build.VERSION.SDK_INT >= 24) {
                b();
            }
            return new d(this.f2243a, this.f2246d);
        }

        public b c(j jVar) {
            this.f2243a.setPackage(jVar.e().getPackageName());
            d(jVar.d(), jVar.f());
            return this;
        }

        public b e(int i11) {
            if (i11 < 0 || i11 > 2) {
                throw new IllegalArgumentException("Invalid value for the shareState argument");
            }
            this.f2250h = i11;
            if (i11 == 1) {
                this.f2243a.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
            } else if (i11 == 2) {
                this.f2243a.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", false);
            } else {
                this.f2243a.removeExtra("android.support.customtabs.extra.SHARE_MENU_ITEM");
            }
            return this;
        }

        public b f(boolean z10) {
            this.f2243a.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", z10);
            return this;
        }
    }

    d(Intent intent, Bundle bundle) {
        this.f2241a = intent;
        this.f2242b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f2241a.setData(uri);
        androidx.core.content.b.startActivity(context, this.f2241a, this.f2242b);
    }
}
