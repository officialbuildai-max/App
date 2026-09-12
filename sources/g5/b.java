package g5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;
import na.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b extends g5.a {

    /* renamed from: a, reason: collision with root package name */
    private int f63460a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final Context f63461b;

    /* renamed from: c, reason: collision with root package name */
    private na.a f63462c;

    /* renamed from: d, reason: collision with root package name */
    private ServiceConnection f63463d;

    /* renamed from: g5.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private final class ServiceConnectionC0792b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final c f63464a;

        private ServiceConnectionC0792b(c cVar) {
            if (cVar == null) {
                throw new RuntimeException("Please specify a listener to know when setup is done.");
            }
            this.f63464a = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h5.a.a("InstallReferrerClient", "Install Referrer service connected.");
            b.this.f63462c = a.AbstractBinderC0874a.Z0(iBinder);
            b.this.f63460a = 2;
            this.f63464a.onInstallReferrerSetupFinished(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h5.a.b("InstallReferrerClient", "Install Referrer service disconnected.");
            b.this.f63462c = null;
            b.this.f63460a = 0;
            this.f63464a.onInstallReferrerServiceDisconnected();
        }
    }

    public b(Context context) {
        this.f63461b = context.getApplicationContext();
    }

    private boolean g() {
        return this.f63461b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
    }

    @Override // g5.a
    public void a() {
        this.f63460a = 3;
        if (this.f63463d != null) {
            h5.a.a("InstallReferrerClient", "Unbinding from service.");
            this.f63461b.unbindService(this.f63463d);
            this.f63463d = null;
        }
        this.f63462c = null;
    }

    @Override // g5.a
    public d b() {
        if (!h()) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.f63461b.getPackageName());
        try {
            return new d(this.f63462c.w(bundle));
        } catch (RemoteException e11) {
            h5.a.b("InstallReferrerClient", "RemoteException getting install referrer information");
            this.f63460a = 0;
            throw e11;
        }
    }

    @Override // g5.a
    public void d(c cVar) {
        ServiceInfo serviceInfo;
        if (h()) {
            h5.a.a("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            cVar.onInstallReferrerSetupFinished(0);
            return;
        }
        int i11 = this.f63460a;
        if (i11 == 1) {
            h5.a.b("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            cVar.onInstallReferrerSetupFinished(3);
            return;
        }
        if (i11 == 3) {
            h5.a.b("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            cVar.onInstallReferrerSetupFinished(3);
            return;
        }
        h5.a.a("InstallReferrerClient", "Starting install referrer service setup.");
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        List<ResolveInfo> queryIntentServices = this.f63461b.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty() || (serviceInfo = queryIntentServices.get(0).serviceInfo) == null) {
            this.f63460a = 0;
            h5.a.a("InstallReferrerClient", "Install Referrer service unavailable on device.");
            cVar.onInstallReferrerSetupFinished(2);
            return;
        }
        String str = serviceInfo.packageName;
        String str2 = serviceInfo.name;
        if (!"com.android.vending".equals(str) || str2 == null || !g()) {
            h5.a.b("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
            this.f63460a = 0;
            cVar.onInstallReferrerSetupFinished(2);
            return;
        }
        Intent intent2 = new Intent(intent);
        ServiceConnectionC0792b serviceConnectionC0792b = new ServiceConnectionC0792b(cVar);
        this.f63463d = serviceConnectionC0792b;
        try {
            if (this.f63461b.bindService(intent2, serviceConnectionC0792b, 1)) {
                h5.a.a("InstallReferrerClient", "Service was bonded successfully.");
                return;
            }
            h5.a.b("InstallReferrerClient", "Connection to service is blocked.");
            this.f63460a = 0;
            cVar.onInstallReferrerSetupFinished(1);
        } catch (SecurityException unused) {
            h5.a.b("InstallReferrerClient", "No permission to connect to service.");
            this.f63460a = 0;
            cVar.onInstallReferrerSetupFinished(4);
        }
    }

    public boolean h() {
        return (this.f63460a != 2 || this.f63462c == null || this.f63463d == null) ? false : true;
    }
}
