package c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public interface c extends IInterface {

    /* renamed from: h, reason: collision with root package name */
    public static final String f17046h = "android$support$customtabs$IEngagementSignalsCallback".replace('$', '.');

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements c {

        /* renamed from: c.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0163a implements c {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f17047a;

            C0163a(IBinder iBinder) {
                this.f17047a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f17047a;
            }

            @Override // c.c
            public void onGreatestScrollPercentageIncreased(int i11, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(c.f17046h);
                    obtain.writeInt(i11);
                    b.d(obtain, bundle, 0);
                    this.f17047a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // c.c
            public void onSessionEnded(boolean z10, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(c.f17046h);
                    obtain.writeInt(z10 ? 1 : 0);
                    b.d(obtain, bundle, 0);
                    this.f17047a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // c.c
            public void onVerticalScrollEvent(boolean z10, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(c.f17046h);
                    obtain.writeInt(z10 ? 1 : 0);
                    b.d(obtain, bundle, 0);
                    this.f17047a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, c.f17046h);
        }

        public static c Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(c.f17046h);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0163a(iBinder) : (c) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            String str = c.f17046h;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i11 == 2) {
                onVerticalScrollEvent(parcel.readInt() != 0, (Bundle) b.c(parcel, Bundle.CREATOR));
            } else if (i11 == 3) {
                onGreatestScrollPercentageIncreased(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
            } else {
                if (i11 != 4) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                onSessionEnded(parcel.readInt() != 0, (Bundle) b.c(parcel, Bundle.CREATOR));
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

    void onGreatestScrollPercentageIncreased(int i11, Bundle bundle);

    void onSessionEnded(boolean z10, Bundle bundle);

    void onVerticalScrollEvent(boolean z10, Bundle bundle);
}
