package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: c, reason: collision with root package name */
    public static final String f909c = "android$support$v4$os$IResultReceiver".replace('$', '.');

    /* renamed from: android.support.v4.os.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0018a extends Binder implements a {

        /* renamed from: android.support.v4.os.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0019a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f910a;

            C0019a(IBinder iBinder) {
                this.f910a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f910a;
            }

            @Override // android.support.v4.os.a
            public void b0(int i11, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f909c);
                    obtain.writeInt(i11);
                    b.d(obtain, bundle, 0);
                    this.f910a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0018a() {
            attachInterface(this, a.f909c);
        }

        public static a Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f909c);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0019a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            String str = a.f909c;
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
            b0(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
            return true;
        }
    }

    /* loaded from: classes.dex */
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

    void b0(int i11, Bundle bundle);
}
