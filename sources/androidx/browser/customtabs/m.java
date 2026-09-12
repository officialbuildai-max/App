package androidx.browser.customtabs;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import c.c;

/* loaded from: classes.dex */
final class m implements l {

    /* renamed from: a, reason: collision with root package name */
    private final c.c f2276a;

    private m(c.c cVar) {
        this.f2276a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(IBinder iBinder) {
        return new m(c.a.Y0(iBinder));
    }

    @Override // androidx.browser.customtabs.l
    public void onGreatestScrollPercentageIncreased(int i11, Bundle bundle) {
        try {
            this.f2276a.onGreatestScrollPercentageIncreased(i11, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.l
    public void onSessionEnded(boolean z10, Bundle bundle) {
        try {
            this.f2276a.onSessionEnded(z10, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.l
    public void onVerticalScrollEvent(boolean z10, Bundle bundle) {
        try {
            this.f2276a.onVerticalScrollEvent(z10, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }
}
