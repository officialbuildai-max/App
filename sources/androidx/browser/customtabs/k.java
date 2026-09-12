package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    final c.a f2272a;

    /* renamed from: b, reason: collision with root package name */
    private final PendingIntent f2273b;

    /* renamed from: c, reason: collision with root package name */
    private final c f2274c;

    /* loaded from: classes.dex */
    class a extends c {
        a() {
        }

        @Override // androidx.browser.customtabs.c
        public void extraCallback(String str, Bundle bundle) {
            try {
                k.this.f2272a.L(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public Bundle extraCallbackWithResult(String str, Bundle bundle) {
            try {
                return k.this.f2272a.r(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                return null;
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onActivityResized(int i11, int i12, Bundle bundle) {
            try {
                k.this.f2272a.B0(i11, i12, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onMessageChannelReady(Bundle bundle) {
            try {
                k.this.f2272a.S0(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onNavigationEvent(int i11, Bundle bundle) {
            try {
                k.this.f2272a.L0(i11, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onPostMessage(String str, Bundle bundle) {
            try {
                k.this.f2272a.P0(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onRelationshipValidationResult(int i11, Uri uri, boolean z10, Bundle bundle) {
            try {
                k.this.f2272a.U0(i11, uri, z10, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c.a aVar, PendingIntent pendingIntent) {
        if (aVar == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f2272a = aVar;
        this.f2273b = pendingIntent;
        this.f2274c = aVar == null ? null : new a();
    }

    private IBinder b() {
        c.a aVar = this.f2272a;
        if (aVar != null) {
            return aVar.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        c.a aVar = this.f2272a;
        if (aVar == null) {
            return null;
        }
        return aVar.asBinder();
    }

    PendingIntent c() {
        return this.f2273b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        PendingIntent c11 = kVar.c();
        PendingIntent pendingIntent = this.f2273b;
        if ((pendingIntent == null) != (c11 == null)) {
            return false;
        }
        return pendingIntent != null ? pendingIntent.equals(c11) : b().equals(kVar.b());
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.f2273b;
        return pendingIntent != null ? pendingIntent.hashCode() : b().hashCode();
    }
}
