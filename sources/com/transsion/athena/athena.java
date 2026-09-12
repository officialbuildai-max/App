package com.transsion.athena;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.transsion.athena.data.TrackData;

/* loaded from: classes5.dex */
public interface athena extends IInterface {

    /* renamed from: com.transsion.athena.athena$athena, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static abstract class AbstractBinderC0603athena extends Binder implements athena {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f42616a = 0;

        /* renamed from: com.transsion.athena.athena$athena$athena, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        private static class C0604athena implements athena {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f42617a;

            C0604athena(IBinder iBinder) {
                this.f42617a = iBinder;
            }

            @Override // com.transsion.athena.athena
            public void a(String str, TrackData trackData, long j11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.transsion.athena.IAthenaTrackInterface");
                    obtain.writeString(str);
                    if (trackData != null) {
                        obtain.writeInt(1);
                        trackData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j11);
                    if (!this.f42617a.transact(1, obtain, obtain2, 0)) {
                        int i11 = AbstractBinderC0603athena.f42616a;
                    }
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f42617a;
            }
        }

        public AbstractBinderC0603athena() {
            attachInterface(this, "com.transsion.athena.IAthenaTrackInterface");
        }

        public static athena a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.transsion.athena.IAthenaTrackInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof athena)) ? new C0604athena(iBinder) : (athena) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 != 1) {
                if (i11 != 1598968902) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                parcel2.writeString("com.transsion.athena.IAthenaTrackInterface");
                return true;
            }
            parcel.enforceInterface("com.transsion.athena.IAthenaTrackInterface");
            a(parcel.readString(), parcel.readInt() != 0 ? TrackData.CREATOR.createFromParcel(parcel) : null, parcel.readLong());
            parcel2.writeNoException();
            return true;
        }
    }

    void a(String str, TrackData trackData, long j11) throws RemoteException;
}
