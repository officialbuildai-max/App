package ky;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes7.dex */
public interface a extends IInterface {

    /* renamed from: ky.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static abstract class AbstractBinderC0846a extends Binder implements a {

        /* renamed from: ky.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        private static class C0847a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f68530a;

            C0847a(IBinder iBinder) {
                this.f68530a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f68530a;
            }
        }

        public AbstractBinderC0846a() {
            attachInterface(this, "com.transsnet.dispenselib.IDispenseCommonCallBack");
        }

        public static a Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.transsnet.dispenselib.IDispenseCommonCallBack");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0847a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface("com.transsnet.dispenselib.IDispenseCommonCallBack");
            }
            if (i11 == 1598968902) {
                parcel2.writeString("com.transsnet.dispenselib.IDispenseCommonCallBack");
                return true;
            }
            if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            }
            N0(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void N0(String str, String str2);
}
