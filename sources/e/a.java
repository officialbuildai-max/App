package e;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: l, reason: collision with root package name */
    public static final String f61584l = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    /* renamed from: e.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0762a extends Binder implements a {

        /* renamed from: e.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0763a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f61585a;

            C0763a(IBinder iBinder) {
                this.f61585a = iBinder;
            }

            @Override // e.a
            public void K(String str, int i11, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f61584l);
                    obtain.writeString(str);
                    obtain.writeInt(i11);
                    obtain.writeString(str2);
                    this.f61585a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // e.a
            public void T0(String str, int i11, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f61584l);
                    obtain.writeString(str);
                    obtain.writeInt(i11);
                    obtain.writeString(str2);
                    b.d(obtain, notification, 0);
                    this.f61585a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f61585a;
            }

            @Override // e.a
            public void p0(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f61584l);
                    obtain.writeString(str);
                    this.f61585a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0762a() {
            attachInterface(this, a.f61584l);
        }

        public static a Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f61584l);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0763a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            String str = a.f61584l;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i11 == 1) {
                T0(parcel.readString(), parcel.readInt(), parcel.readString(), (Notification) b.c(parcel, Notification.CREATOR));
            } else if (i11 == 2) {
                K(parcel.readString(), parcel.readInt(), parcel.readString());
            } else {
                if (i11 != 3) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                p0(parcel.readString());
            }
            return true;
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

    void K(String str, int i11, String str2);

    void T0(String str, int i11, String str2, Notification notification);

    void p0(String str);
}
