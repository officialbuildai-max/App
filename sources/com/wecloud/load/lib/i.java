package com.wecloud.load.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.wecloud.load.lib.h;

/* loaded from: classes7.dex */
public interface i extends IInterface {

    /* loaded from: classes7.dex */
    public static abstract class a extends Binder implements i {

        /* renamed from: com.wecloud.load.lib.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        private static class C0745a implements i {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f60968a;

            C0745a(IBinder iBinder) {
                this.f60968a = iBinder;
            }

            @Override // com.wecloud.load.lib.i
            public void D(SoDownloadRequest soDownloadRequest, h hVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wecloud.load.lib.ISoLoadService");
                    b.d(obtain, soDownloadRequest, 0);
                    obtain.writeStrongInterface(hVar);
                    this.f60968a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f60968a;
            }
        }

        public a() {
            attachInterface(this, "com.wecloud.load.lib.ISoLoadService");
        }

        public static i Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.wecloud.load.lib.ISoLoadService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof i)) ? new C0745a(iBinder) : (i) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface("com.wecloud.load.lib.ISoLoadService");
            }
            if (i11 == 1598968902) {
                parcel2.writeString("com.wecloud.load.lib.ISoLoadService");
                return true;
            }
            if (i11 == 1) {
                D((SoDownloadRequest) b.c(parcel, SoDownloadRequest.CREATOR), h.a.Z0(parcel.readStrongBinder()));
                parcel2.writeNoException();
            } else if (i11 == 2) {
                boolean K0 = K0(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(K0 ? 1 : 0);
            } else {
                if (i11 != 3) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                int C = C(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(C);
            }
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void d(Parcel parcel, Parcelable parcelable, int i11) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i11);
            }
        }
    }

    int C(String str);

    void D(SoDownloadRequest soDownloadRequest, h hVar);

    boolean K0(String str);
}
