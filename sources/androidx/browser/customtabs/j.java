package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import c.c;
import java.util.List;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2264a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final c.b f2265b;

    /* renamed from: c, reason: collision with root package name */
    private final c.a f2266c;

    /* renamed from: d, reason: collision with root package name */
    private final ComponentName f2267d;

    /* renamed from: e, reason: collision with root package name */
    private final PendingIntent f2268e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends c.a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f2269a = new Handler(Looper.getMainLooper());

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f2270b;

        a(l lVar) {
            this.f2270b = lVar;
        }

        @Override // c.c
        public void onGreatestScrollPercentageIncreased(final int i11, final Bundle bundle) {
            Handler handler = this.f2269a;
            final l lVar = this.f2270b;
            handler.post(new Runnable() { // from class: androidx.browser.customtabs.h
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.onGreatestScrollPercentageIncreased(i11, bundle);
                }
            });
        }

        @Override // c.c
        public void onSessionEnded(final boolean z10, final Bundle bundle) {
            Handler handler = this.f2269a;
            final l lVar = this.f2270b;
            handler.post(new Runnable() { // from class: androidx.browser.customtabs.g
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.onSessionEnded(z10, bundle);
                }
            });
        }

        @Override // c.c
        public void onVerticalScrollEvent(final boolean z10, final Bundle bundle) {
            Handler handler = this.f2269a;
            final l lVar = this.f2270b;
            handler.post(new Runnable() { // from class: androidx.browser.customtabs.i
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.onVerticalScrollEvent(z10, bundle);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c.b bVar, c.a aVar, ComponentName componentName, PendingIntent pendingIntent) {
        this.f2265b = bVar;
        this.f2266c = aVar;
        this.f2267d = componentName;
        this.f2268e = pendingIntent;
    }

    private void a(Bundle bundle) {
        PendingIntent pendingIntent = this.f2268e;
        if (pendingIntent != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
        }
    }

    private Bundle b(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        a(bundle2);
        return bundle2;
    }

    private c.a c(l lVar) {
        return new a(lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder d() {
        return this.f2266c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComponentName e() {
        return this.f2267d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingIntent f() {
        return this.f2268e;
    }

    public boolean g(Bundle bundle) {
        try {
            return this.f2265b.B(this.f2266c, bundle);
        } catch (SecurityException e11) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e11);
        }
    }

    public boolean h(Uri uri, Bundle bundle, List list) {
        try {
            return this.f2265b.U(this.f2266c, uri, b(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public int i(String str, Bundle bundle) {
        int W;
        Bundle b11 = b(bundle);
        synchronized (this.f2264a) {
            try {
                try {
                    W = this.f2265b.W(this.f2266c, str, b11);
                } catch (RemoteException unused) {
                    return -2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return W;
    }

    public boolean j(l lVar, Bundle bundle) {
        try {
            return this.f2265b.Q0(this.f2266c, c(lVar).asBinder(), bundle);
        } catch (SecurityException e11) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e11);
        }
    }
}
