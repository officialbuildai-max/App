package q8;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f73296a;

    /* renamed from: b, reason: collision with root package name */
    private final String f73297b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder) {
        this.f73296a = iBinder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel Y0() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f73297b);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel Z0(Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f73296a.transact(1, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e11) {
                obtain.recycle();
                throw e11;
            }
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f73296a;
    }
}
