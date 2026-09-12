package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.b;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.media.session.MediaButtonReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.mvel2.ast.ASTNode;

/* loaded from: classes.dex */
public class MediaSessionCompat {

    /* renamed from: d, reason: collision with root package name */
    static int f865d;

    /* renamed from: a, reason: collision with root package name */
    private final c f866a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaControllerCompat f867b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList f868c;

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private MediaSession.QueueItem mItemFwk;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i11) {
                return new QueueItem[i11];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class b {
            static MediaSession.QueueItem a(MediaDescription mediaDescription, long j11) {
                return new MediaSession.QueueItem(mediaDescription, j11);
            }

            static MediaDescription b(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            static long c(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }

        private QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j11) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j11 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.mDescription = mediaDescriptionCompat;
            this.mId = j11;
            this.mItemFwk = queueItem;
        }

        QueueItem(Parcel parcel) {
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j11) {
            this(null, mediaDescriptionCompat, j11);
        }

        public static QueueItem fromQueueItem(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
            return new QueueItem(queueItem, MediaDescriptionCompat.fromMediaDescription(b.b(queueItem)), b.c(queueItem));
        }

        public static List<QueueItem> fromQueueItemList(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromQueueItem(it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public Object getQueueItem() {
            MediaSession.QueueItem queueItem = this.mItemFwk;
            if (queueItem != null) {
                return queueItem;
            }
            MediaSession.QueueItem a11 = b.a((MediaDescription) this.mDescription.getMediaDescription(), this.mId);
            this.mItemFwk = a11;
            return a11;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            this.mDescription.writeToParcel(parcel, i11);
            parcel.writeLong(this.mId);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        ResultReceiver f869a;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i11) {
                return new ResultReceiverWrapper[i11];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f869a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            this.f869a.writeToParcel(parcel, i11);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();
        private android.support.v4.media.session.b mExtraBinder;
        private final Object mInner;
        private final Object mLock;
        private androidx.versionedparcelable.c mSession2Token;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i11) {
                return new Token[i11];
            }
        }

        Token(Object obj) {
            this(obj, null, null);
        }

        Token(Object obj, android.support.v4.media.session.b bVar) {
            this(obj, bVar, null);
        }

        Token(Object obj, android.support.v4.media.session.b bVar, androidx.versionedparcelable.c cVar) {
            this.mLock = new Object();
            this.mInner = obj;
            this.mExtraBinder = bVar;
            this.mSession2Token = cVar;
        }

        public static Token fromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            bundle.setClassLoader(Token.class.getClassLoader());
            android.support.v4.media.session.b Y0 = b.a.Y0(androidx.core.app.f.a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
            androidx.versionedparcelable.c b11 = androidx.versionedparcelable.a.b(bundle, "android.support.v4.media.session.SESSION_TOKEN2");
            Token token = (Token) bundle.getParcelable("android.support.v4.media.session.TOKEN");
            if (token == null) {
                return null;
            }
            return new Token(token.mInner, Y0, b11);
        }

        public static Token fromToken(Object obj) {
            return fromToken(obj, null);
        }

        public static Token fromToken(Object obj, android.support.v4.media.session.b bVar) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof MediaSession.Token) {
                return new Token(obj, bVar);
            }
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.mInner;
            if (obj2 == null) {
                return token.mInner == null;
            }
            Object obj3 = token.mInner;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public android.support.v4.media.session.b getExtraBinder() {
            android.support.v4.media.session.b bVar;
            synchronized (this.mLock) {
                bVar = this.mExtraBinder;
            }
            return bVar;
        }

        public androidx.versionedparcelable.c getSession2Token() {
            androidx.versionedparcelable.c cVar;
            synchronized (this.mLock) {
                cVar = this.mSession2Token;
            }
            return cVar;
        }

        public Object getToken() {
            return this.mInner;
        }

        public int hashCode() {
            Object obj = this.mInner;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void setExtraBinder(android.support.v4.media.session.b bVar) {
            synchronized (this.mLock) {
                this.mExtraBinder = bVar;
            }
        }

        public void setSession2Token(androidx.versionedparcelable.c cVar) {
            synchronized (this.mLock) {
                this.mSession2Token = cVar;
            }
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.TOKEN", this);
            synchronized (this.mLock) {
                try {
                    android.support.v4.media.session.b bVar = this.mExtraBinder;
                    if (bVar != null) {
                        androidx.core.app.f.b(bundle, "android.support.v4.media.session.EXTRA_BINDER", bVar.asBinder());
                    }
                    androidx.versionedparcelable.c cVar = this.mSession2Token;
                    if (cVar != null) {
                        androidx.versionedparcelable.a.c(bundle, "android.support.v4.media.session.SESSION_TOKEN2", cVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return bundle;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeParcelable((Parcelable) this.mInner, i11);
        }
    }

    /* loaded from: classes.dex */
    class a extends b {
        a() {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {

        /* renamed from: c, reason: collision with root package name */
        private boolean f873c;

        /* renamed from: e, reason: collision with root package name */
        a f875e;

        /* renamed from: a, reason: collision with root package name */
        final Object f871a = new Object();

        /* renamed from: b, reason: collision with root package name */
        final MediaSession.Callback f872b = new C0013b();

        /* renamed from: d, reason: collision with root package name */
        WeakReference f874d = new WeakReference(null);

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class a extends Handler {
            a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c cVar;
                b bVar;
                a aVar;
                if (message.what == 1) {
                    synchronized (b.this.f871a) {
                        cVar = (c) b.this.f874d.get();
                        bVar = b.this;
                        aVar = bVar.f875e;
                    }
                    if (cVar == null || bVar != cVar.f() || aVar == null) {
                        return;
                    }
                    cVar.i((androidx.media.b) message.obj);
                    b.this.a(cVar, aVar);
                    cVar.i(null);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private class C0013b extends MediaSession.Callback {
            C0013b() {
            }

            private void a(c cVar) {
                cVar.i(null);
            }

            private d b() {
                d dVar;
                synchronized (b.this.f871a) {
                    dVar = (d) b.this.f874d.get();
                }
                if (dVar == null || b.this != dVar.f()) {
                    return null;
                }
                return dVar;
            }

            private void c(c cVar) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                String e11 = cVar.e();
                if (TextUtils.isEmpty(e11)) {
                    e11 = "android.media.session.MediaController";
                }
                cVar.i(new androidx.media.b(e11, -1, -1));
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b11);
                try {
                    QueueItem queueItem = null;
                    IBinder asBinder = null;
                    queueItem = null;
                    if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        Bundle bundle2 = new Bundle();
                        Token a11 = b11.a();
                        android.support.v4.media.session.b extraBinder = a11.getExtraBinder();
                        if (extraBinder != null) {
                            asBinder = extraBinder.asBinder();
                        }
                        androidx.core.app.f.b(bundle2, "android.support.v4.media.session.EXTRA_BINDER", asBinder);
                        androidx.versionedparcelable.a.c(bundle2, "android.support.v4.media.session.SESSION_TOKEN2", a11.getSession2Token());
                        resultReceiver.send(0, bundle2);
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        b.this.b((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        b.this.c((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                    } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                        b.this.q((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (!str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                        b.this.d(str, bundle, resultReceiver);
                    } else if (b11.f886i != null) {
                        int i11 = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                        if (i11 >= 0 && i11 < b11.f886i.size()) {
                            queueItem = (QueueItem) b11.f886i.get(i11);
                        }
                        if (queueItem != null) {
                            b.this.q(queueItem.getDescription());
                        }
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCustomAction(String str, Bundle bundle) {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b11);
                try {
                    if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                        Uri uri = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle2);
                        b.this.l(uri, bundle2);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                        b.this.m();
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                        String string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                        Bundle bundle3 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle3);
                        b.this.n(string, bundle3);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                        String string2 = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                        Bundle bundle4 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle4);
                        b.this.o(string2, bundle4);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                        Uri uri2 = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        Bundle bundle5 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle5);
                        b.this.p(uri2, bundle5);
                    } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                        b.this.t(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                        b.this.x(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                        b.this.y(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                        RatingCompat ratingCompat = (RatingCompat) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING");
                        Bundle bundle6 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.a(bundle6);
                        b.this.w(ratingCompat, bundle6);
                    } else if (str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                        b.this.u(bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
                    } else {
                        b.this.e(str, bundle);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the data.");
                }
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onFastForward() {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                c(b11);
                b.this.f();
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent intent) {
                d b11 = b();
                if (b11 == null) {
                    return false;
                }
                c(b11);
                boolean g11 = b.this.g(intent);
                a(b11);
                return g11 || super.onMediaButtonEvent(intent);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPause() {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                c(b11);
                b.this.h();
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlay() {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                c(b11);
                b.this.i();
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromMediaId(String str, Bundle bundle) {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b11);
                b.this.j(str, bundle);
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromSearch(String str, Bundle bundle) {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b11);
                b.this.k(str, bundle);
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b11);
                b.this.l(uri, bundle);
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepare() {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                c(b11);
                b.this.m();
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b11);
                b.this.n(str, bundle);
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromSearch(String str, Bundle bundle) {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b11);
                b.this.o(str, bundle);
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                MediaSessionCompat.a(bundle);
                c(b11);
                b.this.p(uri, bundle);
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onRewind() {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                c(b11);
                b.this.r();
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSeekTo(long j11) {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                c(b11);
                b.this.s(j11);
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetPlaybackSpeed(float f11) {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                c(b11);
                b.this.u(f11);
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetRating(Rating rating) {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                c(b11);
                b.this.v(RatingCompat.fromRating(rating));
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToNext() {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                c(b11);
                b.this.z();
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToPrevious() {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                c(b11);
                b.this.A();
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToQueueItem(long j11) {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                c(b11);
                b.this.B(j11);
                a(b11);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onStop() {
                d b11 = b();
                if (b11 == null) {
                    return;
                }
                c(b11);
                b.this.C();
                a(b11);
            }
        }

        public void A() {
        }

        public void B(long j11) {
        }

        public void C() {
        }

        void D(c cVar, Handler handler) {
            synchronized (this.f871a) {
                try {
                    this.f874d = new WeakReference(cVar);
                    a aVar = this.f875e;
                    a aVar2 = null;
                    if (aVar != null) {
                        aVar.removeCallbacksAndMessages(null);
                    }
                    if (cVar != null && handler != null) {
                        aVar2 = new a(handler.getLooper());
                    }
                    this.f875e = aVar2;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        void a(c cVar, Handler handler) {
            if (this.f873c) {
                this.f873c = false;
                handler.removeMessages(1);
                PlaybackStateCompat playbackState = cVar.getPlaybackState();
                long actions = playbackState == null ? 0L : playbackState.getActions();
                boolean z10 = playbackState != null && playbackState.getState() == 3;
                boolean z11 = (516 & actions) != 0;
                boolean z12 = (actions & 514) != 0;
                if (z10 && z12) {
                    h();
                } else {
                    if (z10 || !z11) {
                        return;
                    }
                    i();
                }
            }
        }

        public void b(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void c(MediaDescriptionCompat mediaDescriptionCompat, int i11) {
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void e(String str, Bundle bundle) {
        }

        public void f() {
        }

        public boolean g(Intent intent) {
            c cVar;
            a aVar;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.f871a) {
                cVar = (c) this.f874d.get();
                aVar = this.f875e;
            }
            if (cVar == null || aVar == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            androidx.media.b j11 = cVar.j();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 79 && keyCode != 85) {
                a(cVar, aVar);
                return false;
            }
            if (keyEvent.getRepeatCount() != 0) {
                a(cVar, aVar);
            } else if (this.f873c) {
                aVar.removeMessages(1);
                this.f873c = false;
                PlaybackStateCompat playbackState = cVar.getPlaybackState();
                if (((playbackState == null ? 0L : playbackState.getActions()) & 32) != 0) {
                    z();
                }
            } else {
                this.f873c = true;
                aVar.sendMessageDelayed(aVar.obtainMessage(1, j11), ViewConfiguration.getDoubleTapTimeout());
            }
            return true;
        }

        public void h() {
        }

        public void i() {
        }

        public void j(String str, Bundle bundle) {
        }

        public void k(String str, Bundle bundle) {
        }

        public void l(Uri uri, Bundle bundle) {
        }

        public void m() {
        }

        public void n(String str, Bundle bundle) {
        }

        public void o(String str, Bundle bundle) {
        }

        public void p(Uri uri, Bundle bundle) {
        }

        public void q(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void r() {
        }

        public void s(long j11) {
        }

        public void t(boolean z10) {
        }

        public void u(float f11) {
        }

        public void v(RatingCompat ratingCompat) {
        }

        public void w(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void x(int i11) {
        }

        public void y(int i11) {
        }

        public void z() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        Token a();

        void b(b bVar, Handler handler);

        void c(MediaMetadataCompat mediaMetadataCompat);

        void d(PlaybackStateCompat playbackStateCompat);

        String e();

        b f();

        void g(PendingIntent pendingIntent);

        PlaybackStateCompat getPlaybackState();

        void h(boolean z10);

        void i(androidx.media.b bVar);

        androidx.media.b j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d implements c {

        /* renamed from: a, reason: collision with root package name */
        final MediaSession f878a;

        /* renamed from: b, reason: collision with root package name */
        final a f879b;

        /* renamed from: c, reason: collision with root package name */
        final Token f880c;

        /* renamed from: e, reason: collision with root package name */
        Bundle f882e;

        /* renamed from: h, reason: collision with root package name */
        PlaybackStateCompat f885h;

        /* renamed from: i, reason: collision with root package name */
        List f886i;

        /* renamed from: j, reason: collision with root package name */
        MediaMetadataCompat f887j;

        /* renamed from: k, reason: collision with root package name */
        int f888k;

        /* renamed from: l, reason: collision with root package name */
        boolean f889l;

        /* renamed from: m, reason: collision with root package name */
        int f890m;

        /* renamed from: n, reason: collision with root package name */
        int f891n;

        /* renamed from: o, reason: collision with root package name */
        b f892o;

        /* renamed from: p, reason: collision with root package name */
        androidx.media.b f893p;

        /* renamed from: d, reason: collision with root package name */
        final Object f881d = new Object();

        /* renamed from: f, reason: collision with root package name */
        boolean f883f = false;

        /* renamed from: g, reason: collision with root package name */
        final RemoteCallbackList f884g = new RemoteCallbackList();

        /* loaded from: classes.dex */
        private static class a extends b.a {

            /* renamed from: a, reason: collision with root package name */
            private final AtomicReference f894a;

            a(d dVar) {
                this.f894a = new AtomicReference(dVar);
            }

            @Override // android.support.v4.media.session.b
            public void A(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void A0(int i11, int i12, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean E(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void F(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void F0(boolean z10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void I(MediaDescriptionCompat mediaDescriptionCompat, int i11) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int M() {
                d dVar = (d) this.f894a.get();
                if (dVar != null) {
                    return dVar.f891n;
                }
                return -1;
            }

            @Override // android.support.v4.media.session.b
            public List M0() {
                return null;
            }

            @Override // android.support.v4.media.session.b
            public void N(int i11) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean O() {
                d dVar = (d) this.f894a.get();
                return dVar != null && dVar.f889l;
            }

            @Override // android.support.v4.media.session.b
            public ParcelableVolumeInfo O0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void S(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void X(long j11) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void Y(boolean z10) {
            }

            @Override // android.support.v4.media.session.b
            public void a(float f11) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void a0(int i11) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void b() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void e0(android.support.v4.media.session.a aVar) {
                d dVar = (d) this.f894a.get();
                if (dVar == null) {
                    return;
                }
                dVar.f884g.register(aVar, new androidx.media.b("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
                synchronized (dVar.f881d) {
                }
            }

            @Override // android.support.v4.media.session.b
            public void f(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void f0(RatingCompat ratingCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void g0(int i11, int i12, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public long getFlags() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public String getPackageName() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public PlaybackStateCompat getPlaybackState() {
                d dVar = (d) this.f894a.get();
                if (dVar != null) {
                    return MediaSessionCompat.c(dVar.f885h, dVar.f887j);
                }
                return null;
            }

            @Override // android.support.v4.media.session.b
            public int getRepeatMode() {
                d dVar = (d) this.f894a.get();
                if (dVar != null) {
                    return dVar.f890m;
                }
                return -1;
            }

            @Override // android.support.v4.media.session.b
            public String getTag() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean h() {
                return false;
            }

            @Override // android.support.v4.media.session.b
            public void h0(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean i0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void j(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void j0(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public PendingIntent k() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int l() {
                d dVar = (d) this.f894a.get();
                if (dVar != null) {
                    return dVar.f888k;
                }
                return 0;
            }

            @Override // android.support.v4.media.session.b
            public void m0(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void next() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void pause() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void play() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void prepare() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void previous() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void s(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public CharSequence s0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void seekTo(long j11) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void setRepeatMode(int i11) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void stop() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void t0(android.support.v4.media.session.a aVar) {
                d dVar = (d) this.f894a.get();
                if (dVar == null) {
                    return;
                }
                dVar.f884g.unregister(aVar);
                Binder.getCallingPid();
                Binder.getCallingUid();
                synchronized (dVar.f881d) {
                }
            }

            @Override // android.support.v4.media.session.b
            public Bundle u() {
                d dVar = (d) this.f894a.get();
                if (dVar.f882e == null) {
                    return null;
                }
                return new Bundle(dVar.f882e);
            }

            @Override // android.support.v4.media.session.b
            public void u0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void x(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void y(String str, Bundle bundle) {
                throw new AssertionError();
            }
        }

        d(Context context, String str, androidx.versionedparcelable.c cVar, Bundle bundle) {
            MediaSession k11 = k(context, str, bundle);
            this.f878a = k11;
            a aVar = new a(this);
            this.f879b = aVar;
            this.f880c = new Token(k11.getSessionToken(), aVar, cVar);
            this.f882e = bundle;
            l(3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Token a() {
            return this.f880c;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void b(b bVar, Handler handler) {
            synchronized (this.f881d) {
                try {
                    this.f892o = bVar;
                    this.f878a.setCallback(bVar == null ? null : bVar.f872b, handler);
                    if (bVar != null) {
                        bVar.D(this, handler);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void c(MediaMetadataCompat mediaMetadataCompat) {
            this.f887j = mediaMetadataCompat;
            this.f878a.setMetadata(mediaMetadataCompat == null ? null : (MediaMetadata) mediaMetadataCompat.getMediaMetadata());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void d(PlaybackStateCompat playbackStateCompat) {
            this.f885h = playbackStateCompat;
            synchronized (this.f881d) {
                for (int beginBroadcast = this.f884g.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.a) this.f884g.getBroadcastItem(beginBroadcast)).X0(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.f884g.finishBroadcast();
            }
            this.f878a.setPlaybackState(playbackStateCompat == null ? null : (PlaybackState) playbackStateCompat.getPlaybackState());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public String e() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                return (String) this.f878a.getClass().getMethod("getCallingPackage", null).invoke(this.f878a, null);
            } catch (Exception e11) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e11);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public b f() {
            b bVar;
            synchronized (this.f881d) {
                bVar = this.f892o;
            }
            return bVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void g(PendingIntent pendingIntent) {
            this.f878a.setMediaButtonReceiver(pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public PlaybackStateCompat getPlaybackState() {
            return this.f885h;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void h(boolean z10) {
            this.f878a.setActive(z10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void i(androidx.media.b bVar) {
            synchronized (this.f881d) {
                this.f893p = bVar;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public androidx.media.b j() {
            androidx.media.b bVar;
            synchronized (this.f881d) {
                bVar = this.f893p;
            }
            return bVar;
        }

        public MediaSession k(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str);
        }

        public void l(int i11) {
            this.f878a.setFlags(i11 | 3);
        }
    }

    /* loaded from: classes.dex */
    static class e extends d {
        e(Context context, String str, androidx.versionedparcelable.c cVar, Bundle bundle) {
            super(context, str, cVar, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class f extends e {
        f(Context context, String str, androidx.versionedparcelable.c cVar, Bundle bundle) {
            super(context, str, cVar, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d, android.support.v4.media.session.MediaSessionCompat.c
        public void i(androidx.media.b bVar) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d, android.support.v4.media.session.MediaSessionCompat.c
        public final androidx.media.b j() {
            MediaSessionManager.RemoteUserInfo currentControllerInfo;
            currentControllerInfo = this.f878a.getCurrentControllerInfo();
            return new androidx.media.b(currentControllerInfo);
        }
    }

    /* loaded from: classes.dex */
    static class g extends f {
        g(Context context, String str, androidx.versionedparcelable.c cVar, Bundle bundle) {
            super(context, str, cVar, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d
        public MediaSession k(Context context, String str, Bundle bundle) {
            return android.support.v4.media.session.e.a(context, str, bundle);
        }
    }

    public MediaSessionCompat(Context context, String str) {
        this(context, str, null, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle, androidx.versionedparcelable.c cVar) {
        this.f868c = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        if (componentName == null && (componentName = MediaButtonReceiver.c(context)) == null) {
            Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
        }
        if (componentName != null && pendingIntent == null) {
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(componentName);
            pendingIntent = PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? ASTNode.PCTX_STORED : 0);
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            this.f866a = new g(context, str, cVar, bundle);
        } else if (i11 >= 28) {
            this.f866a = new f(context, str, cVar, bundle);
        } else {
            this.f866a = new e(context, str, cVar, bundle);
        }
        f(new a(), new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
        this.f866a.g(pendingIntent);
        this.f867b = new MediaControllerCompat(context, this);
        if (f865d == 0) {
            f865d = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    static PlaybackStateCompat c(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j11 = -1;
        if (playbackStateCompat.getPosition() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getState() != 3 && playbackStateCompat.getState() != 4 && playbackStateCompat.getState() != 5) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getLastPositionUpdateTime() <= 0) {
            return playbackStateCompat;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long playbackSpeed = (playbackStateCompat.getPlaybackSpeed() * ((float) (elapsedRealtime - r0))) + playbackStateCompat.getPosition();
        if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
            j11 = mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
        }
        return new PlaybackStateCompat.d(playbackStateCompat).d(playbackStateCompat.getState(), (j11 < 0 || playbackSpeed <= j11) ? playbackSpeed < 0 ? 0L : playbackSpeed : j11, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).a();
    }

    public static Bundle j(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        a(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public Token b() {
        return this.f866a.a();
    }

    public void d(boolean z10) {
        this.f866a.h(z10);
        Iterator it = this.f868c.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            throw null;
        }
    }

    public void e(b bVar) {
        f(bVar, null);
    }

    public void f(b bVar, Handler handler) {
        if (bVar == null) {
            this.f866a.b(null, null);
            return;
        }
        c cVar = this.f866a;
        if (handler == null) {
            handler = new Handler();
        }
        cVar.b(bVar, handler);
    }

    public void g(PendingIntent pendingIntent) {
        this.f866a.g(pendingIntent);
    }

    public void h(MediaMetadataCompat mediaMetadataCompat) {
        this.f866a.c(mediaMetadataCompat);
    }

    public void i(PlaybackStateCompat playbackStateCompat) {
        this.f866a.d(playbackStateCompat);
    }
}
