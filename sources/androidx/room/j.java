package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.room.i;

/* loaded from: classes2.dex */
public interface j extends IInterface {

    /* renamed from: e, reason: collision with root package name */
    public static final String f14781e = "androidx$room$IMultiInstanceInvalidationService".replace('$', '.');

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements j {

        /* renamed from: androidx.room.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0126a implements j {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f14782a;

            C0126a(IBinder iBinder) {
                this.f14782a = iBinder;
            }

            @Override // androidx.room.j
            public void W0(i iVar, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(j.f14781e);
                    obtain.writeStrongInterface(iVar);
                    obtain.writeInt(i11);
                    this.f14782a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // androidx.room.j
            public void Z(int i11, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(j.f14781e);
                    obtain.writeInt(i11);
                    obtain.writeStringArray(strArr);
                    this.f14782a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14782a;
            }

            @Override // androidx.room.j
            public int r0(i iVar, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(j.f14781e);
                    obtain.writeStrongInterface(iVar);
                    obtain.writeString(str);
                    this.f14782a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, j.f14781e);
        }

        public static j Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(j.f14781e);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof j)) ? new C0126a(iBinder) : (j) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            String str = j.f14781e;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i11 == 1) {
                int r02 = r0(i.a.Y0(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(r02);
            } else if (i11 == 2) {
                W0(i.a.Y0(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i11 != 3) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                Z(parcel.readInt(), parcel.createStringArray());
            }
            return true;
        }
    }

    void W0(i iVar, int i11);

    void Z(int i11, String[] strArr);

    int r0(i iVar, String str);
}
