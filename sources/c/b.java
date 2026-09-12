package c;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import c.a;
import java.util.List;

/* loaded from: classes.dex */
public interface b extends IInterface {

    /* renamed from: g, reason: collision with root package name */
    public static final String f17044g = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: c.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0161a implements b {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f17045a;

            C0161a(IBinder iBinder) {
                this.f17045a = iBinder;
            }

            @Override // c.b
            public boolean B(c.a aVar, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17044g);
                    obtain.writeStrongInterface(aVar);
                    C0162b.f(obtain, bundle, 0);
                    this.f17045a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.b
            public boolean Q0(c.a aVar, IBinder iBinder, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17044g);
                    obtain.writeStrongInterface(aVar);
                    obtain.writeStrongBinder(iBinder);
                    C0162b.f(obtain, bundle, 0);
                    this.f17045a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.b
            public boolean U(c.a aVar, Uri uri, Bundle bundle, List list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17044g);
                    obtain.writeStrongInterface(aVar);
                    C0162b.f(obtain, uri, 0);
                    C0162b.f(obtain, bundle, 0);
                    C0162b.e(obtain, list, 0);
                    this.f17045a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.b
            public int W(c.a aVar, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17044g);
                    obtain.writeStrongInterface(aVar);
                    obtain.writeString(str);
                    C0162b.f(obtain, bundle, 0);
                    this.f17045a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f17045a;
            }

            @Override // c.b
            public boolean d(c.a aVar, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17044g);
                    obtain.writeStrongInterface(aVar);
                    C0162b.f(obtain, bundle, 0);
                    this.f17045a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.b
            public boolean q(c.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17044g);
                    obtain.writeStrongInterface(aVar);
                    this.f17045a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.b
            public boolean w0(long j11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f17044g);
                    obtain.writeLong(j11);
                    this.f17045a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, b.f17044g);
        }

        public static b Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(b.f17044g);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0161a(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            String str = b.f17044g;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i11) {
                case 2:
                    boolean w02 = w0(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(w02 ? 1 : 0);
                    return true;
                case 3:
                    boolean q11 = q(a.AbstractBinderC0159a.Y0(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(q11 ? 1 : 0);
                    return true;
                case 4:
                    c.a Y0 = a.AbstractBinderC0159a.Y0(parcel.readStrongBinder());
                    Uri uri = (Uri) C0162b.d(parcel, Uri.CREATOR);
                    Parcelable.Creator creator = Bundle.CREATOR;
                    boolean U = U(Y0, uri, (Bundle) C0162b.d(parcel, creator), parcel.createTypedArrayList(creator));
                    parcel2.writeNoException();
                    parcel2.writeInt(U ? 1 : 0);
                    return true;
                case 5:
                    Bundle t11 = t(parcel.readString(), (Bundle) C0162b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0162b.f(parcel2, t11, 1);
                    return true;
                case 6:
                    boolean g11 = g(a.AbstractBinderC0159a.Y0(parcel.readStrongBinder()), (Bundle) C0162b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(g11 ? 1 : 0);
                    return true;
                case 7:
                    boolean x02 = x0(a.AbstractBinderC0159a.Y0(parcel.readStrongBinder()), (Uri) C0162b.d(parcel, Uri.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(x02 ? 1 : 0);
                    return true;
                case 8:
                    int W = W(a.AbstractBinderC0159a.Y0(parcel.readStrongBinder()), parcel.readString(), (Bundle) C0162b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(W);
                    return true;
                case 9:
                    boolean l02 = l0(a.AbstractBinderC0159a.Y0(parcel.readStrongBinder()), parcel.readInt(), (Uri) C0162b.d(parcel, Uri.CREATOR), (Bundle) C0162b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(l02 ? 1 : 0);
                    return true;
                case 10:
                    boolean d11 = d(a.AbstractBinderC0159a.Y0(parcel.readStrongBinder()), (Bundle) C0162b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(d11 ? 1 : 0);
                    return true;
                case 11:
                    boolean V0 = V0(a.AbstractBinderC0159a.Y0(parcel.readStrongBinder()), (Uri) C0162b.d(parcel, Uri.CREATOR), (Bundle) C0162b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(V0 ? 1 : 0);
                    return true;
                case 12:
                    boolean T = T(a.AbstractBinderC0159a.Y0(parcel.readStrongBinder()), (Uri) C0162b.d(parcel, Uri.CREATOR), parcel.readInt(), (Bundle) C0162b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(T ? 1 : 0);
                    return true;
                case 13:
                    boolean B = B(a.AbstractBinderC0159a.Y0(parcel.readStrongBinder()), (Bundle) C0162b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(B ? 1 : 0);
                    return true;
                case 14:
                    boolean Q0 = Q0(a.AbstractBinderC0159a.Y0(parcel.readStrongBinder()), parcel.readStrongBinder(), (Bundle) C0162b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(Q0 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i11, parcel, parcel2, i12);
            }
        }
    }

    /* renamed from: c.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0162b {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object d(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void e(Parcel parcel, List list, int i11) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                f(parcel, (Parcelable) list.get(i12), i11);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void f(Parcel parcel, Parcelable parcelable, int i11) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i11);
            }
        }
    }

    boolean B(c.a aVar, Bundle bundle);

    boolean Q0(c.a aVar, IBinder iBinder, Bundle bundle);

    boolean T(c.a aVar, Uri uri, int i11, Bundle bundle);

    boolean U(c.a aVar, Uri uri, Bundle bundle, List list);

    boolean V0(c.a aVar, Uri uri, Bundle bundle);

    int W(c.a aVar, String str, Bundle bundle);

    boolean d(c.a aVar, Bundle bundle);

    boolean g(c.a aVar, Bundle bundle);

    boolean l0(c.a aVar, int i11, Uri uri, Bundle bundle);

    boolean q(c.a aVar);

    Bundle t(String str, Bundle bundle);

    boolean w0(long j11);

    boolean x0(c.a aVar, Uri uri);
}
