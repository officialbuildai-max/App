package w0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: m, reason: collision with root package name */
    public static final String f77612m = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', '.');

    /* renamed from: w0.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0982a extends Binder implements a {

        /* renamed from: w0.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0983a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f77613a;

            C0983a(IBinder iBinder) {
                this.f77613a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f77613a;
            }
        }

        public AbstractBinderC0982a() {
            attachInterface(this, a.f77612m);
        }

        public static a Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f77612m);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0983a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            String str = a.f77612m;
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
            V(parcel.readInt() != 0, parcel.readInt() != 0);
            return true;
        }
    }

    void V(boolean z10, boolean z11);
}
