package com.transsion.core.deviceinfo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes5.dex */
abstract class a {

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f44068a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f44069b;

        b(String str, boolean z10) {
            this.f44068a = str;
            this.f44069b = z10;
        }

        public String a() {
            return this.f44068a;
        }
    }

    /* loaded from: classes5.dex */
    private static final class c implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f44070a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue f44071b;

        private c() {
            this.f44070a = false;
            this.f44071b = new LinkedBlockingQueue(1);
        }

        public IBinder a() {
            if (this.f44070a) {
                throw new IllegalStateException();
            }
            this.f44070a = true;
            return (IBinder) this.f44071b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (this.f44071b.size() == 0) {
                    this.f44071b.put(iBinder);
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            try {
                this.f44071b.clear();
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class d implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f44072a;

        d(IBinder iBinder) {
            this.f44072a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f44072a;
        }

        public String getId() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f44072a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        boolean isLimitAdTrackingEnabled(boolean z10) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z10 ? 1 : 0);
                this.f44072a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(Context context) {
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
                return new b(dVar.getId(), dVar.isLimitAdTrackingEnabled(true));
            } catch (Exception e11) {
                throw e11;
            }
        } finally {
            context.unbindService(cVar);
        }
    }
}
