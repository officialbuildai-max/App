package c;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: f, reason: collision with root package name */
    public static final String f17042f = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

    /* renamed from: c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0159a extends Binder implements a {

        /* renamed from: c.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0160a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f17043a;

            C0160a(IBinder iBinder) {
                this.f17043a = iBinder;
            }

            @Override // c.a
            public void B0(int i11, int i12, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f17042f);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    b.d(obtain, bundle, 0);
                    this.f17043a.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // c.a
            public void L(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f17042f);
                    obtain.writeString(str);
                    b.d(obtain, bundle, 0);
                    this.f17043a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // c.a
            public void L0(int i11, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f17042f);
                    obtain.writeInt(i11);
                    b.d(obtain, bundle, 0);
                    this.f17043a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // c.a
            public void P0(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f17042f);
                    obtain.writeString(str);
                    b.d(obtain, bundle, 0);
                    this.f17043a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.a
            public void S0(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f17042f);
                    b.d(obtain, bundle, 0);
                    this.f17043a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.a
            public void U0(int i11, Uri uri, boolean z10, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f17042f);
                    obtain.writeInt(i11);
                    b.d(obtain, uri, 0);
                    obtain.writeInt(z10 ? 1 : 0);
                    b.d(obtain, bundle, 0);
                    this.f17043a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f17043a;
            }

            @Override // c.a
            public Bundle r(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f17042f);
                    obtain.writeString(str);
                    b.d(obtain, bundle, 0);
                    this.f17043a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) b.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0159a() {
            attachInterface(this, a.f17042f);
        }

        public static a Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f17042f);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0160a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            String str = a.f17042f;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i11) {
                case 2:
                    L0(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                case 3:
                    L(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                case 4:
                    S0((Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    P0(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    U0(parcel.readInt(), (Uri) b.c(parcel, Uri.CREATOR), parcel.readInt() != 0, (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                case 7:
                    Bundle r11 = r(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    b.d(parcel2, r11, 1);
                    return true;
                case 8:
                    B0(parcel.readInt(), parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                default:
                    return super.onTransact(i11, parcel, parcel2, i12);
            }
        }
    }

    /* loaded from: classes2.dex */
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

    void B0(int i11, int i12, Bundle bundle);

    void L(String str, Bundle bundle);

    void L0(int i11, Bundle bundle);

    void P0(String str, Bundle bundle);

    void S0(Bundle bundle);

    void U0(int i11, Uri uri, boolean z10, Bundle bundle);

    Bundle r(String str, Bundle bundle);
}
