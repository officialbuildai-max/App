package ky;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ky.a;

/* loaded from: classes7.dex */
public interface b extends IInterface {

    /* loaded from: classes7.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: ky.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        private static class C0848a implements b {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f68531a;

            C0848a(IBinder iBinder) {
                this.f68531a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f68531a;
            }

            @Override // ky.b
            public void c0(ky.a aVar, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.transsnet.dispenselib.IDispenseCommonService");
                    obtain.writeStrongInterface(aVar);
                    obtain.writeString(str);
                    this.f68531a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.transsnet.dispenselib.IDispenseCommonService");
        }

        public static b Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.transsnet.dispenselib.IDispenseCommonService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0848a(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface("com.transsnet.dispenselib.IDispenseCommonService");
            }
            if (i11 == 1598968902) {
                parcel2.writeString("com.transsnet.dispenselib.IDispenseCommonService");
                return true;
            }
            if (i11 == 1) {
                c0(a.AbstractBinderC0846a.Y0(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
            } else if (i11 == 2) {
                v(a.AbstractBinderC0846a.Y0(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
            } else if (i11 == 3) {
                G0(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
            } else {
                if (i11 != 4) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                String i13 = i(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(i13);
            }
            return true;
        }
    }

    void G0(String str, String str2, String str3);

    void c0(ky.a aVar, String str);

    String i(String str, String str2, String str3);

    void v(ky.a aVar, String str);
}
