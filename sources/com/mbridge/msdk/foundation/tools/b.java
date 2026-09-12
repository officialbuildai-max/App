package com.mbridge.msdk.foundation.tools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: com.mbridge.msdk.foundation.tools.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public final class C0496b {

        /* renamed from: a, reason: collision with root package name */
        private final String f35738a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f35739b;

        C0496b(String str, boolean z10) {
            this.f35738a = str;
            this.f35739b = z10;
        }

        public String a() {
            return this.f35738a;
        }

        public boolean b() {
            return this.f35739b;
        }
    }

    /* loaded from: classes5.dex */
    private final class c implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f35741a;

        /* renamed from: b, reason: collision with root package name */
        boolean f35742b;

        private c() {
            this.f35741a = new LinkedBlockingQueue<>(1);
            this.f35742b = false;
        }

        public IBinder a() throws InterruptedException {
            if (this.f35742b) {
                throw new IllegalStateException();
            }
            this.f35742b = true;
            return this.f35741a.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f35741a.put(iBinder);
            } catch (InterruptedException e11) {
                o0.b("AdvertisingIdClient", e11.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes5.dex */
    private final class d implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f35744a;

        public d(IBinder iBinder) {
            this.f35744a = iBinder;
        }

        public boolean a(boolean z10) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z10 ? 1 : 0);
                this.f35744a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                r2 = obtain2.readInt() != 0;
            } catch (Throwable th2) {
                try {
                    o0.b("AdvertisingIdClient", th2.getMessage());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            return r2;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f35744a;
        }

        public String getId() throws RemoteException {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f35744a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th2) {
                try {
                    o0.b("AdvertisingIdClient", th2.getMessage());
                    str = null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            return str;
        }
    }

    public C0496b a(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        c cVar = new c();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, cVar, 1)) {
            throw new IOException("Google Play connection failed");
        }
        try {
            try {
                d dVar = new d(cVar.a());
                return new C0496b(dVar.getId(), dVar.a(true));
            } catch (Exception e11) {
                throw e11;
            }
        } finally {
            context.unbindService(cVar);
        }
    }
}
