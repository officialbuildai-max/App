package n00;

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
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public abstract class e {

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f70194a;

        b(String str, boolean z10) {
            this.f70194a = str;
        }

        public String a() {
            return this.f70194a;
        }
    }

    /* loaded from: classes7.dex */
    private static final class c implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f70195a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue f70196b;

        private c() {
            this.f70195a = false;
            this.f70196b = new LinkedBlockingQueue(1);
        }

        public IBinder a() {
            if (this.f70195a) {
                throw new IllegalStateException();
            }
            this.f70195a = true;
            return (IBinder) this.f70196b.poll(10L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (this.f70196b.isEmpty()) {
                    this.f70196b.put(iBinder);
                }
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes7.dex */
    private static final class d implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f70197a;

        d(IBinder iBinder) {
            this.f70197a = iBinder;
        }

        public String Y0() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f70197a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        boolean Z0(boolean z10) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z10 ? 1 : 0);
                this.f70197a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f70197a;
        }
    }

    public static b a(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        c cVar = new c();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, cVar, 1)) {
            try {
                try {
                    IBinder a11 = cVar.a();
                    if (a11 != null) {
                        d dVar = new d(a11);
                        return new b(dVar.Y0(), dVar.Z0(true));
                    }
                } catch (Exception e11) {
                    throw e11;
                }
            } finally {
                context.unbindService(cVar);
            }
        }
        throw new IOException("Google Play connection failed");
    }
}
