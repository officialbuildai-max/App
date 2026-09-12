package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

/* loaded from: classes.dex */
public interface b extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: android.support.v4.media.session.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0016a implements b {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f907a;

            C0016a(IBinder iBinder) {
                this.f907a = iBinder;
            }

            @Override // android.support.v4.media.session.b
            public boolean E(KeyEvent keyEvent) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    C0017b.f(obtain, keyEvent, 0);
                    this.f907a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f907a;
            }

            @Override // android.support.v4.media.session.b
            public void e0(android.support.v4.media.session.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeStrongInterface(aVar);
                    this.f907a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void f(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(str);
                    C0017b.f(obtain, bundle, 0);
                    this.f907a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void next() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f907a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.b
            public void previous() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.f907a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "android.support.v4.media.session.IMediaSession");
        }

        public static b Y0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0016a(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
            }
            if (i11 == 1598968902) {
                parcel2.writeString("android.support.v4.media.session.IMediaSession");
                return true;
            }
            switch (i11) {
                case 1:
                    S(parcel.readString(), (Bundle) C0017b.d(parcel, Bundle.CREATOR), (MediaSessionCompat.ResultReceiverWrapper) C0017b.d(parcel, MediaSessionCompat.ResultReceiverWrapper.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    boolean E = E((KeyEvent) C0017b.d(parcel, KeyEvent.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(E ? 1 : 0);
                    return true;
                case 3:
                    e0(a.AbstractBinderC0014a.Y0(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    t0(a.AbstractBinderC0014a.Y0(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    boolean i02 = i0();
                    parcel2.writeNoException();
                    parcel2.writeInt(i02 ? 1 : 0);
                    return true;
                case 6:
                    String packageName = getPackageName();
                    parcel2.writeNoException();
                    parcel2.writeString(packageName);
                    return true;
                case 7:
                    String tag = getTag();
                    parcel2.writeNoException();
                    parcel2.writeString(tag);
                    return true;
                case 8:
                    PendingIntent k11 = k();
                    parcel2.writeNoException();
                    C0017b.f(parcel2, k11, 1);
                    return true;
                case 9:
                    long flags = getFlags();
                    parcel2.writeNoException();
                    parcel2.writeLong(flags);
                    return true;
                case 10:
                    ParcelableVolumeInfo O0 = O0();
                    parcel2.writeNoException();
                    C0017b.f(parcel2, O0, 1);
                    return true;
                case 11:
                    A0(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    g0(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    play();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    x(parcel.readString(), (Bundle) C0017b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    y(parcel.readString(), (Bundle) C0017b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    A((Uri) C0017b.d(parcel, Uri.CREATOR), (Bundle) C0017b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    X(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    pause();
                    parcel2.writeNoException();
                    return true;
                case 19:
                    stop();
                    parcel2.writeNoException();
                    return true;
                case 20:
                    next();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    previous();
                    parcel2.writeNoException();
                    return true;
                case 22:
                    u0();
                    parcel2.writeNoException();
                    return true;
                case 23:
                    b();
                    parcel2.writeNoException();
                    return true;
                case 24:
                    seekTo(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    f0((RatingCompat) C0017b.d(parcel, RatingCompat.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    f(parcel.readString(), (Bundle) C0017b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 27:
                    MediaMetadataCompat metadata = getMetadata();
                    parcel2.writeNoException();
                    C0017b.f(parcel2, metadata, 1);
                    return true;
                case 28:
                    PlaybackStateCompat playbackState = getPlaybackState();
                    parcel2.writeNoException();
                    C0017b.f(parcel2, playbackState, 1);
                    return true;
                case NOTIFICATION_REDIRECT_VALUE:
                    List M0 = M0();
                    parcel2.writeNoException();
                    C0017b.e(parcel2, M0, 1);
                    return true;
                case 30:
                    CharSequence s02 = s0();
                    parcel2.writeNoException();
                    if (s02 != null) {
                        parcel2.writeInt(1);
                        TextUtils.writeToParcel(s02, parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case TEMPLATE_HTML_SIZE_VALUE:
                    Bundle extras = getExtras();
                    parcel2.writeNoException();
                    C0017b.f(parcel2, extras, 1);
                    return true;
                case 32:
                    int l11 = l();
                    parcel2.writeNoException();
                    parcel2.writeInt(l11);
                    return true;
                case 33:
                    prepare();
                    parcel2.writeNoException();
                    return true;
                case 34:
                    s(parcel.readString(), (Bundle) C0017b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    m0(parcel.readString(), (Bundle) C0017b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    j((Uri) C0017b.d(parcel, Uri.CREATOR), (Bundle) C0017b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 37:
                    int repeatMode = getRepeatMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(repeatMode);
                    return true;
                case 38:
                    boolean h11 = h();
                    parcel2.writeNoException();
                    parcel2.writeInt(h11 ? 1 : 0);
                    return true;
                case 39:
                    setRepeatMode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 40:
                    Y(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 41:
                    j0((MediaDescriptionCompat) C0017b.d(parcel, MediaDescriptionCompat.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 42:
                    I((MediaDescriptionCompat) C0017b.d(parcel, MediaDescriptionCompat.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    h0((MediaDescriptionCompat) C0017b.d(parcel, MediaDescriptionCompat.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 44:
                    N(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    boolean O = O();
                    parcel2.writeNoException();
                    parcel2.writeInt(O ? 1 : 0);
                    return true;
                case 46:
                    F0(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 47:
                    int M = M();
                    parcel2.writeNoException();
                    parcel2.writeInt(M);
                    return true;
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                    a0(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    a(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 50:
                    Bundle u11 = u();
                    parcel2.writeNoException();
                    C0017b.f(parcel2, u11, 1);
                    return true;
                case AD_REWARD_USER_VALUE:
                    F((RatingCompat) C0017b.d(parcel, RatingCompat.CREATOR), (Bundle) C0017b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i11, parcel, parcel2, i12);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0017b {
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

    void A(Uri uri, Bundle bundle);

    void A0(int i11, int i12, String str);

    boolean E(KeyEvent keyEvent);

    void F(RatingCompat ratingCompat, Bundle bundle);

    void F0(boolean z10);

    void I(MediaDescriptionCompat mediaDescriptionCompat, int i11);

    int M();

    List M0();

    void N(int i11);

    boolean O();

    ParcelableVolumeInfo O0();

    void S(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper);

    void X(long j11);

    void Y(boolean z10);

    void a(float f11);

    void a0(int i11);

    void b();

    void e0(android.support.v4.media.session.a aVar);

    void f(String str, Bundle bundle);

    void f0(RatingCompat ratingCompat);

    void g0(int i11, int i12, String str);

    Bundle getExtras();

    long getFlags();

    MediaMetadataCompat getMetadata();

    String getPackageName();

    PlaybackStateCompat getPlaybackState();

    int getRepeatMode();

    String getTag();

    boolean h();

    void h0(MediaDescriptionCompat mediaDescriptionCompat);

    boolean i0();

    void j(Uri uri, Bundle bundle);

    void j0(MediaDescriptionCompat mediaDescriptionCompat);

    PendingIntent k();

    int l();

    void m0(String str, Bundle bundle);

    void next();

    void pause();

    void play();

    void prepare();

    void previous();

    void s(String str, Bundle bundle);

    CharSequence s0();

    void seekTo(long j11);

    void setRepeatMode(int i11);

    void stop();

    void t0(android.support.v4.media.session.a aVar);

    Bundle u();

    void u0();

    void x(String str, Bundle bundle);

    void y(String str, Bundle bundle);
}
