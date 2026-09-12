package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import androidx.browser.trusted.d;
import androidx.core.app.t;
import d.b;
import java.util.Locale;
import m.g;

/* loaded from: classes.dex */
public abstract class TrustedWebActivityService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private NotificationManager f2277a;

    /* renamed from: b, reason: collision with root package name */
    int f2278b = -1;

    /* renamed from: c, reason: collision with root package name */
    private final b.a f2279c = new a();

    /* loaded from: classes.dex */
    class a extends b.a {
        a() {
        }

        private void Y0() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            int i11 = trustedWebActivityService.f2278b;
            if (i11 != -1) {
                if (i11 != Binder.getCallingUid()) {
                    throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
                }
            } else {
                trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                TrustedWebActivityService.this.c();
                throw null;
            }
        }

        @Override // d.b
        public int C0() {
            Y0();
            return TrustedWebActivityService.this.i();
        }

        @Override // d.b
        public Bundle D0(Bundle bundle) {
            Y0();
            return new d.e(TrustedWebActivityService.this.d(d.c.a(bundle).f2285a)).a();
        }

        @Override // d.b
        public Bundle G() {
            Y0();
            return TrustedWebActivityService.this.h();
        }

        @Override // d.b
        public void H0(Bundle bundle) {
            Y0();
            d.b a11 = d.b.a(bundle);
            TrustedWebActivityService.this.e(a11.f2283a, a11.f2284b);
        }

        @Override // d.b
        public Bundle P(Bundle bundle) {
            Y0();
            d.C0026d a11 = d.C0026d.a(bundle);
            return new d.e(TrustedWebActivityService.this.j(a11.f2286a, a11.f2287b, a11.f2288c, a11.f2289d)).a();
        }

        @Override // d.b
        public Bundle k0() {
            Y0();
            return new d.a(TrustedWebActivityService.this.g()).a();
        }

        @Override // d.b
        public Bundle z(String str, Bundle bundle, IBinder iBinder) {
            Y0();
            return TrustedWebActivityService.this.f(str, bundle, c.a(iBinder));
        }
    }

    private static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    private void b() {
        if (this.f2277a == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    public abstract g c();

    public boolean d(String str) {
        b();
        if (!t.d(this).a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return b.b(this.f2277a, a(str));
    }

    public void e(String str, int i11) {
        b();
        this.f2277a.cancel(str, i11);
    }

    public Bundle f(String str, Bundle bundle, c cVar) {
        return null;
    }

    public Parcelable[] g() {
        b();
        return androidx.browser.trusted.a.a(this.f2277a);
    }

    public Bundle h() {
        int i11 = i();
        Bundle bundle = new Bundle();
        if (i11 == -1) {
            return bundle;
        }
        bundle.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(getResources(), i11));
        return bundle;
    }

    public int i() {
        try {
            Bundle bundle = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128).metaData;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public boolean j(String str, int i11, Notification notification, String str2) {
        b();
        if (!t.d(this).a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            String a11 = a(str2);
            notification = b.a(this, this.f2277a, notification, a11, str2);
            if (!b.b(this.f2277a, a11)) {
                return false;
            }
        }
        this.f2277a.notify(str, i11, notification);
        return true;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f2279c;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f2277a = (NotificationManager) getSystemService("notification");
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        this.f2278b = -1;
        return super.onUnbind(intent);
    }
}
