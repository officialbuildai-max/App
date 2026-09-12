package na;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import q8.b;
import q8.c;

/* loaded from: classes4.dex */
public interface a extends IInterface {

    /* renamed from: na.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractBinderC0874a extends b implements a {

        /* renamed from: na.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0875a extends q8.a implements a {
            C0875a(IBinder iBinder) {
                super(iBinder);
            }

            @Override // na.a
            public final Bundle w(Bundle bundle) {
                Parcel Y0 = Y0();
                c.b(Y0, bundle);
                Parcel Z0 = Z0(Y0);
                Bundle bundle2 = (Bundle) c.a(Z0, Bundle.CREATOR);
                Z0.recycle();
                return bundle2;
            }
        }

        public static a Z0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return queryLocalInterface instanceof a ? (a) queryLocalInterface : new C0875a(iBinder);
        }

        @Override // q8.b
        protected final boolean Y0(int i11, Parcel parcel, Parcel parcel2) {
            if (i11 != 1) {
                return false;
            }
            Bundle w11 = w((Bundle) c.a(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            c.c(parcel2, w11);
            return true;
        }
    }

    Bundle w(Bundle bundle);
}
