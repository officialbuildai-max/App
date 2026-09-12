package jh;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public interface a extends IInterface {

    /* renamed from: jh.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractBinderC0829a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: jh.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0830a implements a {

            /* renamed from: b, reason: collision with root package name */
            public static a f66138b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f66139a;

            C0830a(IBinder iBinder) {
                this.f66139a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f66139a;
            }

            @Override // jh.a
            public String getId() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (!this.f66139a.transact(1, obtain, obtain2, 0) && AbstractBinderC0829a.Z0() != null) {
                        return AbstractBinderC0829a.Z0().getId();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0829a() {
            attachInterface(this, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        }

        public static a Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0830a(iBinder) : (a) queryLocalInterface;
        }

        public static a Z0() {
            return C0830a.f66138b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String id2 = getId();
                parcel2.writeNoException();
                parcel2.writeString(id2);
                return true;
            }
            if (i11 != 2) {
                if (i11 != 1598968902) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            boolean isLimitAdTrackingEnabled = isLimitAdTrackingEnabled(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(isLimitAdTrackingEnabled ? 1 : 0);
            return true;
        }
    }

    String getId();

    boolean isLimitAdTrackingEnabled(boolean z10);
}
