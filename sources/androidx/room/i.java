package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface i extends IInterface {

    /* renamed from: d, reason: collision with root package name */
    public static final String f14778d = "androidx$room$IMultiInstanceInvalidationCallback".replace('$', '.');

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements i {

        /* renamed from: androidx.room.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0125a implements i {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f14779a;

            C0125a(IBinder iBinder) {
                this.f14779a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14779a;
            }

            @Override // androidx.room.i
            public void n(String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(i.f14778d);
                    obtain.writeStringArray(strArr);
                    this.f14779a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, i.f14778d);
        }

        public static i Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(i.f14778d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof i)) ? new C0125a(iBinder) : (i) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            String str = i.f14778d;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            }
            n(parcel.createStringArray());
            return true;
        }
    }

    void n(String[] strArr);
}
