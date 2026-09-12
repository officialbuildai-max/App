package android.support.v4.media;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* renamed from: b, reason: collision with root package name */
    static final boolean f797b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a, reason: collision with root package name */
    private final f f798a;

    /* loaded from: classes.dex */
    private static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final d mCallback;
        private final Bundle mExtras;

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int i11, Bundle bundle) {
            if (this.mCallback == null) {
                return;
            }
            MediaSessionCompat.a(bundle);
            if (i11 == -1) {
                this.mCallback.a(this.mAction, this.mExtras, bundle);
                return;
            }
            if (i11 == 0) {
                this.mCallback.c(this.mAction, this.mExtras, bundle);
                return;
            }
            if (i11 == 1) {
                this.mCallback.b(this.mAction, this.mExtras, bundle);
                return;
            }
            Log.w("MediaBrowserCompat", "Unknown result code: " + i11 + " (extras=" + this.mExtras + ", resultData=" + bundle + ")");
        }
    }

    /* loaded from: classes.dex */
    private static class ItemReceiver extends ResultReceiver {
        private final e mCallback;
        private final String mMediaId;

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int i11, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.j(bundle);
            }
            if (i11 != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.mCallback.a(this.mMediaId);
                return;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.mCallback.b((MediaItem) parcelable);
            } else {
                this.mCallback.a(this.mMediaId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MediaBrowserImplBase implements f, j {

        /* renamed from: a, reason: collision with root package name */
        final Context f799a;

        /* renamed from: b, reason: collision with root package name */
        final ComponentName f800b;

        /* renamed from: c, reason: collision with root package name */
        final c f801c;

        /* renamed from: d, reason: collision with root package name */
        final Bundle f802d;

        /* renamed from: e, reason: collision with root package name */
        final b f803e;

        /* renamed from: f, reason: collision with root package name */
        int f804f;

        /* renamed from: g, reason: collision with root package name */
        MediaServiceConnection f805g;

        /* renamed from: h, reason: collision with root package name */
        l f806h;

        /* renamed from: i, reason: collision with root package name */
        Messenger f807i;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ MediaBrowserImplBase this$0;

            AnonymousClass1(MediaBrowserImplBase mediaBrowserImplBase) {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z10;
                MediaBrowserImplBase mediaBrowserImplBase = this.this$0;
                if (mediaBrowserImplBase.f804f == 0) {
                    return;
                }
                mediaBrowserImplBase.f804f = 2;
                if (MediaBrowserCompat.f797b && mediaBrowserImplBase.f805g != null) {
                    throw new RuntimeException("mServiceConnection should be null. Instead it is " + this.this$0.f805g);
                }
                if (mediaBrowserImplBase.f806h != null) {
                    throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.this$0.f806h);
                }
                if (mediaBrowserImplBase.f807i != null) {
                    throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.this$0.f807i);
                }
                Intent intent = new Intent("android.media.browse.MediaBrowserService");
                intent.setComponent(this.this$0.f800b);
                MediaBrowserImplBase mediaBrowserImplBase2 = this.this$0;
                mediaBrowserImplBase2.f805g = new MediaServiceConnection(mediaBrowserImplBase2);
                try {
                    MediaBrowserImplBase mediaBrowserImplBase3 = this.this$0;
                    z10 = mediaBrowserImplBase3.f799a.bindService(intent, mediaBrowserImplBase3.f805g, 1);
                } catch (Exception unused) {
                    Log.e("MediaBrowserCompat", "Failed binding to service " + this.this$0.f800b);
                    z10 = false;
                }
                if (!z10) {
                    this.this$0.f();
                    this.this$0.f801c.b();
                }
                if (MediaBrowserCompat.f797b) {
                    this.this$0.d();
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$2, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ MediaBrowserImplBase this$0;

            AnonymousClass2(MediaBrowserImplBase mediaBrowserImplBase) {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaBrowserImplBase mediaBrowserImplBase = this.this$0;
                Messenger messenger = mediaBrowserImplBase.f807i;
                if (messenger != null) {
                    try {
                        mediaBrowserImplBase.f806h.c(messenger);
                    } catch (RemoteException unused) {
                        Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.this$0.f800b);
                    }
                }
                MediaBrowserImplBase mediaBrowserImplBase2 = this.this$0;
                int i11 = mediaBrowserImplBase2.f804f;
                mediaBrowserImplBase2.f();
                if (i11 != 0) {
                    this.this$0.f804f = i11;
                }
                if (MediaBrowserCompat.f797b) {
                    this.this$0.d();
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$3, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ MediaBrowserImplBase this$0;
            final /* synthetic */ e val$cb;
            final /* synthetic */ String val$mediaId;

            AnonymousClass3(MediaBrowserImplBase mediaBrowserImplBase, e eVar, String str) {
                this.val$cb = eVar;
                this.val$mediaId = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$cb.a(this.val$mediaId);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$4, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ MediaBrowserImplBase this$0;
            final /* synthetic */ e val$cb;
            final /* synthetic */ String val$mediaId;

            AnonymousClass4(MediaBrowserImplBase mediaBrowserImplBase, e eVar, String str) {
                this.val$cb = eVar;
                this.val$mediaId = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$cb.a(this.val$mediaId);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$5, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass5 implements Runnable {
            final /* synthetic */ MediaBrowserImplBase this$0;
            final /* synthetic */ k val$callback;
            final /* synthetic */ Bundle val$extras;
            final /* synthetic */ String val$query;

            AnonymousClass5(MediaBrowserImplBase mediaBrowserImplBase, k kVar, String str, Bundle bundle) {
                this.val$callback = kVar;
                this.val$query = str;
                this.val$extras = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$callback.a(this.val$query, this.val$extras);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$6, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass6 implements Runnable {
            final /* synthetic */ MediaBrowserImplBase this$0;
            final /* synthetic */ String val$action;
            final /* synthetic */ d val$callback;
            final /* synthetic */ Bundle val$extras;

            AnonymousClass6(MediaBrowserImplBase mediaBrowserImplBase, d dVar, String str, Bundle bundle) {
                this.val$callback = dVar;
                this.val$action = str;
                this.val$extras = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$callback.a(this.val$action, this.val$extras, null);
            }
        }

        /* loaded from: classes.dex */
        private class MediaServiceConnection implements ServiceConnection {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ MediaBrowserImplBase f808a;

            MediaServiceConnection(MediaBrowserImplBase mediaBrowserImplBase) {
            }

            private void b(Runnable runnable) {
                if (Thread.currentThread() == this.f808a.f803e.getLooper().getThread()) {
                    runnable.run();
                } else {
                    this.f808a.f803e.post(runnable);
                }
            }

            boolean a(String str) {
                int i11;
                MediaBrowserImplBase mediaBrowserImplBase = this.f808a;
                if (mediaBrowserImplBase.f805g == this && (i11 = mediaBrowserImplBase.f804f) != 0 && i11 != 1) {
                    return true;
                }
                int i12 = mediaBrowserImplBase.f804f;
                if (i12 == 0 || i12 == 1) {
                    return false;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" for ");
                sb2.append(this.f808a.f800b);
                sb2.append(" with mServiceConnection=");
                sb2.append(this.f808a.f805g);
                sb2.append(" this=");
                sb2.append(this);
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                b(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z10 = MediaBrowserCompat.f797b;
                        if (z10) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("MediaServiceConnection.onServiceConnected name=");
                            sb2.append(componentName);
                            sb2.append(" binder=");
                            sb2.append(iBinder);
                            MediaServiceConnection.this.f808a.d();
                        }
                        if (MediaServiceConnection.this.a("onServiceConnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaServiceConnection.this.f808a;
                            mediaBrowserImplBase.f806h = new l(iBinder, mediaBrowserImplBase.f802d);
                            MediaServiceConnection.this.f808a.f807i = new Messenger(MediaServiceConnection.this.f808a.f803e);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaServiceConnection.this.f808a;
                            mediaBrowserImplBase2.f803e.a(mediaBrowserImplBase2.f807i);
                            MediaServiceConnection.this.f808a.f804f = 2;
                            if (z10) {
                                try {
                                    MediaServiceConnection.this.f808a.d();
                                } catch (RemoteException unused) {
                                    Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaServiceConnection.this.f808a.f800b);
                                    if (MediaBrowserCompat.f797b) {
                                        MediaServiceConnection.this.f808a.d();
                                        return;
                                    }
                                    return;
                                }
                            }
                            MediaBrowserImplBase mediaBrowserImplBase3 = MediaServiceConnection.this.f808a;
                            mediaBrowserImplBase3.f806h.b(mediaBrowserImplBase3.f799a, mediaBrowserImplBase3.f807i);
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName componentName) {
                b(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.f797b) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("MediaServiceConnection.onServiceDisconnected name=");
                            sb2.append(componentName);
                            sb2.append(" this=");
                            sb2.append(this);
                            sb2.append(" mServiceConnection=");
                            sb2.append(MediaServiceConnection.this.f808a.f805g);
                            MediaServiceConnection.this.f808a.d();
                        }
                        if (MediaServiceConnection.this.a("onServiceDisconnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaServiceConnection.this.f808a;
                            mediaBrowserImplBase.f806h = null;
                            mediaBrowserImplBase.f807i = null;
                            mediaBrowserImplBase.f803e.a(null);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaServiceConnection.this.f808a;
                            mediaBrowserImplBase2.f804f = 4;
                            mediaBrowserImplBase2.f801c.c();
                        }
                    }
                });
            }
        }

        abstract void d();

        abstract void f();
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public MediaItem[] newArray(int i11) {
                return new MediaItem[i11];
            }
        }

        MediaItem(Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i11) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.mFlags = i11;
            this.mDescription = mediaDescriptionCompat;
        }

        public static MediaItem fromMediaItem(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(a.a(mediaItem)), a.b(mediaItem));
        }

        public static List<MediaItem> fromMediaItemList(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromMediaItem(it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @Nullable
        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        @NonNull
        public String toString() {
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel, i11);
        }
    }

    /* loaded from: classes.dex */
    private static class SearchResultReceiver extends ResultReceiver {
        private final k mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int i11, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.j(bundle);
            }
            if (i11 != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.mCallback.a(this.mQuery, this.mExtras);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            if (parcelableArray == null) {
                this.mCallback.a(this.mQuery, this.mExtras);
                return;
            }
            ArrayList arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaItem) parcelable);
            }
            this.mCallback.b(this.mQuery, this.mExtras, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        static MediaDescription a(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getDescription();
        }

        static int b(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getFlags();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f809a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference f810b;

        b(j jVar) {
            this.f809a = new WeakReference(jVar);
        }

        void a(Messenger messenger) {
            this.f810b = new WeakReference(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference weakReference = this.f810b;
            if (weakReference == null || weakReference.get() == null || this.f809a.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.a(data);
            j jVar = (j) this.f809a.get();
            Messenger messenger = (Messenger) this.f810b.get();
            try {
                int i11 = message.what;
                if (i11 == 1) {
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    jVar.e(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle);
                } else if (i11 == 2) {
                    jVar.h(messenger);
                } else if (i11 != 3) {
                    Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                } else {
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    Bundle bundle3 = data.getBundle("data_notify_children_changed_options");
                    MediaSessionCompat.a(bundle3);
                    jVar.b(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle2, bundle3);
                }
            } catch (BadParcelableException unused) {
                Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                if (message.what == 1) {
                    jVar.h(messenger);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final MediaBrowser.ConnectionCallback f811a = new a();

        /* renamed from: b, reason: collision with root package name */
        b f812b;

        /* loaded from: classes.dex */
        private class a extends MediaBrowser.ConnectionCallback {
            a() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                b bVar = c.this.f812b;
                if (bVar != null) {
                    bVar.onConnected();
                }
                c.this.a();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                b bVar = c.this.f812b;
                if (bVar != null) {
                    bVar.d();
                }
                c.this.b();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                b bVar = c.this.f812b;
                if (bVar != null) {
                    bVar.f();
                }
                c.this.c();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface b {
            void d();

            void f();

            void onConnected();
        }

        public void a() {
        }

        public void b() {
        }

        public void c() {
        }

        void d(b bVar) {
            this.f812b = bVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public void a(String str, Bundle bundle, Bundle bundle2) {
        }

        public void b(String str, Bundle bundle, Bundle bundle2) {
        }

        public void c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        final MediaBrowser.ItemCallback f814a = new a();

        /* loaded from: classes.dex */
        private class a extends MediaBrowser.ItemCallback {
            a() {
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onError(String str) {
                e.this.a(str);
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
                e.this.b(MediaItem.fromMediaItem(mediaItem));
            }
        }

        public void a(String str) {
        }

        public void b(MediaItem mediaItem) {
        }
    }

    /* loaded from: classes.dex */
    interface f {
        MediaSessionCompat.Token a();

        void c();

        void disconnect();

        void g(String str, Bundle bundle, n nVar);

        String getRoot();

        void i(String str, n nVar);

        boolean isConnected();
    }

    /* loaded from: classes.dex */
    static class g implements f, j, c.b {

        /* renamed from: a, reason: collision with root package name */
        final Context f816a;

        /* renamed from: b, reason: collision with root package name */
        protected final MediaBrowser f817b;

        /* renamed from: c, reason: collision with root package name */
        protected final Bundle f818c;

        /* renamed from: d, reason: collision with root package name */
        protected final b f819d = new b(this);

        /* renamed from: e, reason: collision with root package name */
        private final androidx.collection.a f820e = new androidx.collection.a();

        /* renamed from: f, reason: collision with root package name */
        protected int f821f;

        /* renamed from: g, reason: collision with root package name */
        protected l f822g;

        /* renamed from: h, reason: collision with root package name */
        protected Messenger f823h;

        /* renamed from: i, reason: collision with root package name */
        private MediaSessionCompat.Token f824i;

        /* renamed from: j, reason: collision with root package name */
        private Bundle f825j;

        g(Context context, ComponentName componentName, c cVar, Bundle bundle) {
            this.f816a = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.f818c = bundle2;
            bundle2.putInt("extra_client_version", 1);
            bundle2.putInt("extra_calling_pid", Process.myPid());
            cVar.d(this);
            this.f817b = new MediaBrowser(context, componentName, cVar.f811a, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f
        public MediaSessionCompat.Token a() {
            if (this.f824i == null) {
                this.f824i = MediaSessionCompat.Token.fromToken(this.f817b.getSessionToken());
            }
            return this.f824i;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void b(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.f823h != messenger) {
                return;
            }
            m mVar = (m) this.f820e.get(str);
            if (mVar == null) {
                if (MediaBrowserCompat.f797b) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onLoadChildren for id that isn't subscribed id=");
                    sb2.append(str);
                    return;
                }
                return;
            }
            n a11 = mVar.a(bundle);
            if (a11 != null) {
                if (bundle == null) {
                    if (list == null) {
                        a11.c(str);
                        return;
                    }
                    this.f825j = bundle2;
                    a11.a(str, list);
                    this.f825j = null;
                    return;
                }
                if (list == null) {
                    a11.d(str, bundle);
                    return;
                }
                this.f825j = bundle2;
                a11.b(str, list, bundle);
                this.f825j = null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f
        public void c() {
            this.f817b.connect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c.b
        public void d() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f
        public void disconnect() {
            Messenger messenger;
            l lVar = this.f822g;
            if (lVar != null && (messenger = this.f823h) != null) {
                try {
                    lVar.g(messenger);
                } catch (RemoteException unused) {
                }
            }
            this.f817b.disconnect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void e(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c.b
        public void f() {
            this.f822g = null;
            this.f823h = null;
            this.f824i = null;
            this.f819d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f
        public void g(String str, Bundle bundle, n nVar) {
            m mVar = (m) this.f820e.get(str);
            if (mVar == null) {
                mVar = new m();
                this.f820e.put(str, mVar);
            }
            nVar.e(mVar);
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            mVar.e(bundle2, nVar);
            l lVar = this.f822g;
            if (lVar == null) {
                this.f817b.subscribe(str, nVar.f830a);
                return;
            }
            try {
                lVar.a(str, nVar.f831b, bundle2, this.f823h);
            } catch (RemoteException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Remote error subscribing media item: ");
                sb2.append(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f
        public String getRoot() {
            return this.f817b.getRoot();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void h(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f
        public void i(String str, n nVar) {
            m mVar = (m) this.f820e.get(str);
            if (mVar == null) {
                return;
            }
            l lVar = this.f822g;
            if (lVar != null) {
                try {
                    if (nVar == null) {
                        lVar.e(str, null, this.f823h);
                    } else {
                        List b11 = mVar.b();
                        List c11 = mVar.c();
                        for (int size = b11.size() - 1; size >= 0; size--) {
                            if (b11.get(size) == nVar) {
                                this.f822g.e(str, nVar.f831b, this.f823h);
                                b11.remove(size);
                                c11.remove(size);
                            }
                        }
                    }
                } catch (RemoteException unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("removeSubscription failed with RemoteException parentId=");
                    sb2.append(str);
                }
            } else if (nVar == null) {
                this.f817b.unsubscribe(str);
            } else {
                List b12 = mVar.b();
                List c12 = mVar.c();
                for (int size2 = b12.size() - 1; size2 >= 0; size2--) {
                    if (b12.get(size2) == nVar) {
                        b12.remove(size2);
                        c12.remove(size2);
                    }
                }
                if (b12.size() == 0) {
                    this.f817b.unsubscribe(str);
                }
            }
            if (mVar.d() || nVar == null) {
                this.f820e.remove(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f
        public boolean isConnected() {
            return this.f817b.isConnected();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c.b
        public void onConnected() {
            try {
                Bundle extras = this.f817b.getExtras();
                if (extras == null) {
                    return;
                }
                this.f821f = extras.getInt("extra_service_version", 0);
                IBinder a11 = androidx.core.app.f.a(extras, "extra_messenger");
                if (a11 != null) {
                    this.f822g = new l(a11, this.f818c);
                    Messenger messenger = new Messenger(this.f819d);
                    this.f823h = messenger;
                    this.f819d.a(messenger);
                    try {
                        this.f822g.d(this.f816a, this.f823h);
                    } catch (RemoteException unused) {
                    }
                }
                android.support.v4.media.session.b Y0 = b.a.Y0(androidx.core.app.f.a(extras, "extra_session_binder"));
                if (Y0 != null) {
                    this.f824i = MediaSessionCompat.Token.fromToken(this.f817b.getSessionToken(), Y0);
                }
            } catch (IllegalStateException e11) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e11);
            }
        }
    }

    /* loaded from: classes.dex */
    static class h extends g {
        h(Context context, ComponentName componentName, c cVar, Bundle bundle) {
            super(context, componentName, cVar, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class i extends h {
        i(Context context, ComponentName componentName, c cVar, Bundle bundle) {
            super(context, componentName, cVar, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g, android.support.v4.media.MediaBrowserCompat.f
        public void g(String str, Bundle bundle, n nVar) {
            if (this.f822g != null && this.f821f >= 2) {
                super.g(str, bundle, nVar);
            } else if (bundle == null) {
                this.f817b.subscribe(str, nVar.f830a);
            } else {
                this.f817b.subscribe(str, bundle, nVar.f830a);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g, android.support.v4.media.MediaBrowserCompat.f
        public void i(String str, n nVar) {
            if (this.f822g != null && this.f821f >= 2) {
                super.i(str, nVar);
            } else if (nVar == null) {
                this.f817b.unsubscribe(str);
            } else {
                this.f817b.unsubscribe(str, nVar.f830a);
            }
        }
    }

    /* loaded from: classes.dex */
    interface j {
        void b(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void e(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void h(Messenger messenger);
    }

    /* loaded from: classes.dex */
    public static abstract class k {
        public void a(String str, Bundle bundle) {
        }

        public void b(String str, Bundle bundle, List list) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        private Messenger f826a;

        /* renamed from: b, reason: collision with root package name */
        private Bundle f827b;

        public l(IBinder iBinder, Bundle bundle) {
            this.f826a = new Messenger(iBinder);
            this.f827b = bundle;
        }

        private void f(int i11, Bundle bundle, Messenger messenger) {
            Message obtain = Message.obtain();
            obtain.what = i11;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f826a.send(obtain);
        }

        void a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            androidx.core.app.f.b(bundle2, "data_callback_token", iBinder);
            bundle2.putBundle("data_options", bundle);
            f(3, bundle2, messenger);
        }

        void b(Context context, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putInt("data_calling_pid", Process.myPid());
            bundle.putBundle("data_root_hints", this.f827b);
            f(1, bundle, messenger);
        }

        void c(Messenger messenger) {
            f(2, null, messenger);
        }

        void d(Context context, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putInt("data_calling_pid", Process.myPid());
            bundle.putBundle("data_root_hints", this.f827b);
            f(6, bundle, messenger);
        }

        void e(String str, IBinder iBinder, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString("data_media_item_id", str);
            androidx.core.app.f.b(bundle, "data_callback_token", iBinder);
            f(4, bundle, messenger);
        }

        void g(Messenger messenger) {
            f(7, null, messenger);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class m {

        /* renamed from: a, reason: collision with root package name */
        private final List f828a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private final List f829b = new ArrayList();

        public n a(Bundle bundle) {
            for (int i11 = 0; i11 < this.f829b.size(); i11++) {
                if (androidx.media.a.a((Bundle) this.f829b.get(i11), bundle)) {
                    return (n) this.f828a.get(i11);
                }
            }
            return null;
        }

        public List b() {
            return this.f828a;
        }

        public List c() {
            return this.f829b;
        }

        public boolean d() {
            return this.f828a.isEmpty();
        }

        public void e(Bundle bundle, n nVar) {
            for (int i11 = 0; i11 < this.f829b.size(); i11++) {
                if (androidx.media.a.a((Bundle) this.f829b.get(i11), bundle)) {
                    this.f828a.set(i11, nVar);
                    return;
                }
            }
            this.f828a.add(nVar);
            this.f829b.add(bundle);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {

        /* renamed from: a, reason: collision with root package name */
        final MediaBrowser.SubscriptionCallback f830a;

        /* renamed from: b, reason: collision with root package name */
        final IBinder f831b = new Binder();

        /* renamed from: c, reason: collision with root package name */
        WeakReference f832c;

        /* loaded from: classes.dex */
        private class a extends MediaBrowser.SubscriptionCallback {
            a() {
            }

            List a(List list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i11 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i12 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (i11 == -1 && i12 == -1) {
                    return list;
                }
                int i13 = i12 * i11;
                int i14 = i13 + i12;
                if (i11 < 0 || i12 < 1 || i13 >= list.size()) {
                    return Collections.emptyList();
                }
                if (i14 > list.size()) {
                    i14 = list.size();
                }
                return list.subList(i13, i14);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(String str, List list) {
                WeakReference weakReference = n.this.f832c;
                m mVar = weakReference == null ? null : (m) weakReference.get();
                if (mVar == null) {
                    n.this.a(str, MediaItem.fromMediaItemList(list));
                    return;
                }
                List<MediaItem> fromMediaItemList = MediaItem.fromMediaItemList(list);
                List b11 = mVar.b();
                List c11 = mVar.c();
                for (int i11 = 0; i11 < b11.size(); i11++) {
                    Bundle bundle = (Bundle) c11.get(i11);
                    if (bundle == null) {
                        n.this.a(str, fromMediaItemList);
                    } else {
                        n.this.b(str, a(fromMediaItemList, bundle), bundle);
                    }
                }
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(String str) {
                n.this.c(str);
            }
        }

        /* loaded from: classes.dex */
        private class b extends a {
            b() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(String str, List list, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                n.this.b(str, MediaItem.fromMediaItemList(list), bundle);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(String str, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                n.this.d(str, bundle);
            }
        }

        public n() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f830a = new b();
            } else {
                this.f830a = new a();
            }
        }

        public void a(String str, List list) {
        }

        public void b(String str, List list, Bundle bundle) {
        }

        public void c(String str) {
        }

        public void d(String str, Bundle bundle) {
        }

        void e(m mVar) {
            this.f832c = new WeakReference(mVar);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, c cVar, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f798a = new i(context, componentName, cVar, bundle);
        } else {
            this.f798a = new h(context, componentName, cVar, bundle);
        }
    }

    public void a() {
        this.f798a.c();
    }

    public void b() {
        this.f798a.disconnect();
    }

    public String c() {
        return this.f798a.getRoot();
    }

    public MediaSessionCompat.Token d() {
        return this.f798a.a();
    }

    public boolean e() {
        return this.f798a.isConnected();
    }

    public void f(String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.f798a.g(str, null, nVar);
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        this.f798a.i(str, null);
    }
}
