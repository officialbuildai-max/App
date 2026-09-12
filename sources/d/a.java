package d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: j, reason: collision with root package name */
    public static final String f61085j = "android$support$customtabs$trusted$ITrustedWebActivityCallback".replace('$', '.');

    /* renamed from: d.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0749a extends Binder implements a {

        /* renamed from: d.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0750a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f61086a;

            C0750a(IBinder iBinder) {
                this.f61086a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f61086a;
            }
        }

        public AbstractBinderC0749a() {
            attachInterface(this, a.f61085j);
        }

        public static a Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f61085j);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0750a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            String str = a.f61085j;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i11 != 2) {
                return super.onTransact(i11, parcel, parcel2, i12);
            }
            R0(parcel.readString(), (Bundle) b.b(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object b(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void R0(String str, Bundle bundle);
}
