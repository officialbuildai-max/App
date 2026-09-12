package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: i, reason: collision with root package name */
    static final boolean f9792i = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: a, reason: collision with root package name */
    private f f9793a;

    /* renamed from: f, reason: collision with root package name */
    ConnectionRecord f9798f;

    /* renamed from: h, reason: collision with root package name */
    MediaSessionCompat.Token f9800h;

    /* renamed from: b, reason: collision with root package name */
    private final ServiceBinderImpl f9794b = new ServiceBinderImpl();

    /* renamed from: c, reason: collision with root package name */
    final ConnectionRecord f9795c = new ConnectionRecord("android.media.session.MediaController", -1, -1, null, null);

    /* renamed from: d, reason: collision with root package name */
    final ArrayList f9796d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    final androidx.collection.a f9797e = new androidx.collection.a();

    /* renamed from: g, reason: collision with root package name */
    final o f9799g = new o(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ConnectionRecord implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final String f9801a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9802b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9803c;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.media.b f9804d;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f9805e;

        /* renamed from: f, reason: collision with root package name */
        public final m f9806f;

        /* renamed from: g, reason: collision with root package name */
        public final HashMap f9807g = new HashMap();

        /* renamed from: h, reason: collision with root package name */
        public e f9808h;

        ConnectionRecord(String str, int i11, int i12, Bundle bundle, m mVar) {
            this.f9801a = str;
            this.f9802b = i11;
            this.f9803c = i12;
            this.f9804d = new androidx.media.b(str, i11, i12);
            this.f9805e = bundle;
            this.f9806f = mVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.f9799g.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ConnectionRecord.1
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = ConnectionRecord.this;
                    MediaBrowserServiceCompat.this.f9797e.remove(connectionRecord.f9806f.asBinder());
                }
            });
        }
    }

    /* loaded from: classes.dex */
    class MediaBrowserServiceImplApi21 implements f {

        /* renamed from: a, reason: collision with root package name */
        final List f9810a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        MediaBrowserService f9811b;

        /* renamed from: c, reason: collision with root package name */
        Messenger f9812c;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ String val$parentId;

            AnonymousClass3(String str, Bundle bundle) {
                this.val$parentId = str;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<Object> it = MediaBrowserServiceCompat.this.f9797e.keySet().iterator();
                while (it.hasNext()) {
                    MediaBrowserServiceImplApi21.this.c((ConnectionRecord) MediaBrowserServiceCompat.this.f9797e.get((IBinder) it.next()), this.val$parentId, this.val$options);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ String val$parentId;
            final /* synthetic */ androidx.media.b val$remoteUserInfo;

            AnonymousClass4(androidx.media.b bVar, String str, Bundle bundle) {
                this.val$remoteUserInfo = bVar;
                this.val$parentId = str;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i11 = 0; i11 < MediaBrowserServiceCompat.this.f9797e.size(); i11++) {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f9797e.valueAt(i11);
                    if (connectionRecord.f9804d.equals(this.val$remoteUserInfo)) {
                        MediaBrowserServiceImplApi21.this.c(connectionRecord, this.val$parentId, this.val$options);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends k {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ l f9814f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, l lVar) {
                super(obj);
                this.f9814f = lVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.k
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(List list) {
                List list2;
                if (list == null) {
                    list2 = Build.VERSION.SDK_INT >= 24 ? null : Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList(list.size());
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) it.next();
                        Parcel obtain = Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                    list2 = arrayList;
                }
                this.f9814f.b(list2);
            }
        }

        /* loaded from: classes.dex */
        class b extends MediaBrowserService {
            b(Context context) {
                attachBaseContext(context);
            }

            @Override // android.service.media.MediaBrowserService
            public MediaBrowserService.BrowserRoot onGetRoot(String str, int i11, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                e d11 = MediaBrowserServiceImplApi21.this.d(str, i11, bundle == null ? null : new Bundle(bundle));
                if (d11 == null) {
                    return null;
                }
                return new MediaBrowserService.BrowserRoot(d11.f9829a, d11.f9830b);
            }

            @Override // android.service.media.MediaBrowserService
            public void onLoadChildren(String str, MediaBrowserService.Result result) {
                MediaBrowserServiceImplApi21.this.e(str, new l(result));
            }
        }

        MediaBrowserServiceImplApi21() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.f
        public void a(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.f9799g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserServiceImplApi21.this.f(token);
                }
            });
        }

        @Override // androidx.media.MediaBrowserServiceCompat.f
        public IBinder b(Intent intent) {
            return this.f9811b.onBind(intent);
        }

        void c(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<androidx.core.util.e> list = (List) connectionRecord.f9807g.get(str);
            if (list != null) {
                for (androidx.core.util.e eVar : list) {
                    if (androidx.media.a.b(bundle, (Bundle) eVar.f8348b)) {
                        MediaBrowserServiceCompat.this.n(str, connectionRecord, (Bundle) eVar.f8348b, bundle);
                    }
                }
            }
        }

        public e d(String str, int i11, Bundle bundle) {
            Bundle bundle2;
            int i12 = -1;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove("extra_client_version");
                this.f9812c = new Messenger(MediaBrowserServiceCompat.this.f9799g);
                bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                androidx.core.app.f.b(bundle2, "extra_messenger", this.f9812c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f9800h;
                if (token != null) {
                    android.support.v4.media.session.b extraBinder = token.getExtraBinder();
                    androidx.core.app.f.b(bundle2, "extra_session_binder", extraBinder == null ? null : extraBinder.asBinder());
                } else {
                    this.f9810a.add(bundle2);
                }
                i12 = bundle.getInt("extra_calling_pid", -1);
                bundle.remove("extra_calling_pid");
            }
            ConnectionRecord connectionRecord = new ConnectionRecord(str, i12, i11, bundle, null);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f9798f = connectionRecord;
            e f11 = mediaBrowserServiceCompat.f(str, i11, bundle);
            MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat2.f9798f = null;
            if (f11 == null) {
                return null;
            }
            if (this.f9812c != null) {
                mediaBrowserServiceCompat2.f9796d.add(connectionRecord);
            }
            if (bundle2 == null) {
                bundle2 = f11.c();
            } else if (f11.c() != null) {
                bundle2.putAll(f11.c());
            }
            return new e(f11.d(), bundle2);
        }

        public void e(String str, l lVar) {
            a aVar = new a(str, lVar);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f9798f = mediaBrowserServiceCompat.f9795c;
            mediaBrowserServiceCompat.g(str, aVar);
            MediaBrowserServiceCompat.this.f9798f = null;
        }

        void f(MediaSessionCompat.Token token) {
            if (!this.f9810a.isEmpty()) {
                android.support.v4.media.session.b extraBinder = token.getExtraBinder();
                if (extraBinder != null) {
                    Iterator it = this.f9810a.iterator();
                    while (it.hasNext()) {
                        androidx.core.app.f.b((Bundle) it.next(), "extra_session_binder", extraBinder.asBinder());
                    }
                }
                this.f9810a.clear();
            }
            this.f9811b.setSessionToken((MediaSession.Token) token.getToken());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ServiceBinderImpl {
        ServiceBinderImpl() {
        }

        public void a(final String str, final IBinder iBinder, final Bundle bundle, final m mVar) {
            MediaBrowserServiceCompat.this.f9799g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f9797e.get(mVar.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.a(str, connectionRecord, iBinder, bundle);
                        return;
                    }
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                }
            });
        }

        public void b(final String str, final int i11, final int i12, final Bundle bundle, final m mVar) {
            if (MediaBrowserServiceCompat.this.d(str, i12)) {
                MediaBrowserServiceCompat.this.f9799g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IBinder asBinder = mVar.asBinder();
                        MediaBrowserServiceCompat.this.f9797e.remove(asBinder);
                        ConnectionRecord connectionRecord = new ConnectionRecord(str, i11, i12, bundle, mVar);
                        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                        mediaBrowserServiceCompat.f9798f = connectionRecord;
                        e f11 = mediaBrowserServiceCompat.f(str, i12, bundle);
                        connectionRecord.f9808h = f11;
                        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                        mediaBrowserServiceCompat2.f9798f = null;
                        if (f11 == null) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("No root for client ");
                            sb2.append(str);
                            sb2.append(" from service ");
                            sb2.append(getClass().getName());
                            try {
                                mVar.b();
                                return;
                            } catch (RemoteException unused) {
                                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str);
                                return;
                            }
                        }
                        try {
                            mediaBrowserServiceCompat2.f9797e.put(asBinder, connectionRecord);
                            asBinder.linkToDeath(connectionRecord, 0);
                            if (MediaBrowserServiceCompat.this.f9800h != null) {
                                mVar.c(connectionRecord.f9808h.d(), MediaBrowserServiceCompat.this.f9800h, connectionRecord.f9808h.c());
                            }
                        } catch (RemoteException unused2) {
                            Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str);
                            MediaBrowserServiceCompat.this.f9797e.remove(asBinder);
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i12 + " package=" + str);
        }

        public void c(final m mVar) {
            MediaBrowserServiceCompat.this.f9799g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f9797e.remove(mVar.asBinder());
                    if (connectionRecord != null) {
                        connectionRecord.f9806f.asBinder().unlinkToDeath(connectionRecord, 0);
                    }
                }
            });
        }

        public void d(final String str, final ResultReceiver resultReceiver, final m mVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f9799g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f9797e.get(mVar.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.o(str, connectionRecord, resultReceiver);
                        return;
                    }
                    Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str);
                }
            });
        }

        public void e(final m mVar, final String str, final int i11, final int i12, final Bundle bundle) {
            MediaBrowserServiceCompat.this.f9799g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord;
                    IBinder asBinder = mVar.asBinder();
                    MediaBrowserServiceCompat.this.f9797e.remove(asBinder);
                    Iterator it = MediaBrowserServiceCompat.this.f9796d.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ConnectionRecord connectionRecord2 = (ConnectionRecord) it.next();
                        if (connectionRecord2.f9803c == i12) {
                            connectionRecord = (TextUtils.isEmpty(str) || i11 <= 0) ? new ConnectionRecord(connectionRecord2.f9801a, connectionRecord2.f9802b, connectionRecord2.f9803c, bundle, mVar) : null;
                            it.remove();
                        }
                    }
                    if (connectionRecord == null) {
                        connectionRecord = new ConnectionRecord(str, i11, i12, bundle, mVar);
                    }
                    MediaBrowserServiceCompat.this.f9797e.put(asBinder, connectionRecord);
                    try {
                        asBinder.linkToDeath(connectionRecord, 0);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "IBinder is already dead.");
                    }
                }
            });
        }

        public void f(final String str, final IBinder iBinder, final m mVar) {
            MediaBrowserServiceCompat.this.f9799g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f9797e.get(mVar.asBinder());
                    if (connectionRecord == null) {
                        Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                        return;
                    }
                    if (MediaBrowserServiceCompat.this.q(str, connectionRecord, iBinder)) {
                        return;
                    }
                    Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                }
            });
        }

        public void g(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final m mVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f9799g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.8
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f9797e.get(mVar.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.p(str, bundle, connectionRecord, resultReceiver);
                        return;
                    }
                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str);
                }
            });
        }

        public void h(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final m mVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f9799g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f9797e.get(mVar.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.m(str, bundle, connectionRecord, resultReceiver);
                        return;
                    }
                    Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str + ", extras=" + bundle);
                }
            });
        }

        public void i(final m mVar) {
            MediaBrowserServiceCompat.this.f9799g.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    IBinder asBinder = mVar.asBinder();
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f9797e.remove(asBinder);
                    if (connectionRecord != null) {
                        asBinder.unlinkToDeath(connectionRecord, 0);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends k {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ConnectionRecord f9818f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9819g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Bundle f9820h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Bundle f9821i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, ConnectionRecord connectionRecord, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f9818f = connectionRecord;
            this.f9819g = str;
            this.f9820h = bundle;
            this.f9821i = bundle2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.k
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(List list) {
            if (MediaBrowserServiceCompat.this.f9797e.get(this.f9818f.f9806f.asBinder()) != this.f9818f) {
                if (MediaBrowserServiceCompat.f9792i) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
                    sb2.append(this.f9818f.f9801a);
                    sb2.append(" id=");
                    sb2.append(this.f9819g);
                    return;
                }
                return;
            }
            if ((a() & 1) != 0) {
                list = MediaBrowserServiceCompat.this.b(list, this.f9820h);
            }
            try {
                this.f9818f.f9806f.a(this.f9819g, list, this.f9820h, this.f9821i);
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.f9819g + " package=" + this.f9818f.f9801a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends k {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f9823f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f9823f = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.k
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(MediaBrowserCompat.MediaItem mediaItem) {
            if ((a() & 2) != 0) {
                this.f9823f.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", mediaItem);
            this.f9823f.send(0, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends k {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f9825f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f9825f = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.k
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(List list) {
            if ((a() & 4) != 0 || list == null) {
                this.f9825f.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f9825f.send(0, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends k {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f9827f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f9827f = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        void c(Bundle bundle) {
            this.f9827f.send(-1, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.k
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(Bundle bundle) {
            this.f9827f.send(0, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private final String f9829a;

        /* renamed from: b, reason: collision with root package name */
        private final Bundle f9830b;

        public e(String str, Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
            }
            this.f9829a = str;
            this.f9830b = bundle;
        }

        public Bundle c() {
            return this.f9830b;
        }

        public String d() {
            return this.f9829a;
        }
    }

    /* loaded from: classes.dex */
    interface f {
        void a(MediaSessionCompat.Token token);

        IBinder b(Intent intent);

        void onCreate();
    }

    /* loaded from: classes.dex */
    class g extends MediaBrowserServiceImplApi21 {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends k {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ l f9832f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, l lVar) {
                super(obj);
                this.f9832f = lVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.k
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.f9832f.b(null);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                this.f9832f.b(obtain);
            }
        }

        /* loaded from: classes.dex */
        class b extends MediaBrowserServiceImplApi21.b {
            b(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public void onLoadItem(String str, MediaBrowserService.Result result) {
                g.this.g(str, new l(result));
            }
        }

        g() {
            super();
        }

        public void g(String str, l lVar) {
            a aVar = new a(str, lVar);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f9798f = mediaBrowserServiceCompat.f9795c;
            mediaBrowserServiceCompat.i(str, aVar);
            MediaBrowserServiceCompat.this.f9798f = null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.f
        public void onCreate() {
            b bVar = new b(MediaBrowserServiceCompat.this);
            this.f9811b = bVar;
            bVar.onCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends g {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends k {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ l f9836f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ Bundle f9837g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, l lVar, Bundle bundle) {
                super(obj);
                this.f9836f = lVar;
                this.f9837g = bundle;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.k
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(List list) {
                if (list == null) {
                    this.f9836f.b(null);
                    return;
                }
                if ((a() & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.b(list, this.f9837g);
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (MediaBrowserCompat.MediaItem mediaItem : list) {
                    Parcel obtain = Parcel.obtain();
                    mediaItem.writeToParcel(obtain, 0);
                    arrayList.add(obtain);
                }
                this.f9836f.b(arrayList);
            }
        }

        /* loaded from: classes.dex */
        class b extends g.b {
            b(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                h hVar = h.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f9798f = mediaBrowserServiceCompat.f9795c;
                hVar.h(str, new l(result), bundle);
                MediaBrowserServiceCompat.this.f9798f = null;
            }
        }

        h() {
            super();
        }

        public void h(String str, l lVar, Bundle bundle) {
            a aVar = new a(str, lVar, bundle);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f9798f = mediaBrowserServiceCompat.f9795c;
            mediaBrowserServiceCompat.h(str, aVar, bundle);
            MediaBrowserServiceCompat.this.f9798f = null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g, androidx.media.MediaBrowserServiceCompat.f
        public void onCreate() {
            b bVar = new b(MediaBrowserServiceCompat.this);
            this.f9811b = bVar;
            bVar.onCreate();
        }
    }

    /* loaded from: classes.dex */
    class i extends h {
        i() {
            super();
        }
    }

    /* loaded from: classes.dex */
    class j implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaBrowserServiceCompat f9841a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract void c(ConnectionRecord connectionRecord, String str, Bundle bundle);
    }

    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        private final Object f9842a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f9843b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f9844c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f9845d;

        /* renamed from: e, reason: collision with root package name */
        private int f9846e;

        k(Object obj) {
            this.f9842a = obj;
        }

        int a() {
            return this.f9846e;
        }

        boolean b() {
            return this.f9843b || this.f9844c || this.f9845d;
        }

        void c(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f9842a);
        }

        abstract void d(Object obj);

        public void e(Bundle bundle) {
            if (!this.f9844c && !this.f9845d) {
                this.f9845d = true;
                c(bundle);
            } else {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f9842a);
            }
        }

        public void f(Object obj) {
            if (!this.f9844c && !this.f9845d) {
                this.f9844c = true;
                d(obj);
            } else {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f9842a);
            }
        }

        void g(int i11) {
            this.f9846e = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        MediaBrowserService.Result f9847a;

        l(MediaBrowserService.Result result) {
            this.f9847a = result;
        }

        List a(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Parcel parcel = (Parcel) it.next();
                parcel.setDataPosition(0);
                arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        public void b(Object obj) {
            if (obj instanceof List) {
                this.f9847a.sendResult(a((List) obj));
                return;
            }
            if (!(obj instanceof Parcel)) {
                this.f9847a.sendResult(null);
                return;
            }
            Parcel parcel = (Parcel) obj;
            parcel.setDataPosition(0);
            this.f9847a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface m {
        void a(String str, List list, Bundle bundle, Bundle bundle2);

        IBinder asBinder();

        void b();

        void c(String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class n implements m {

        /* renamed from: a, reason: collision with root package name */
        final Messenger f9848a;

        n(Messenger messenger) {
            this.f9848a = messenger;
        }

        private void d(int i11, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i11;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f9848a.send(obtain);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.m
        public void a(String str, List list, Bundle bundle, Bundle bundle2) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            d(3, bundle3);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.m
        public IBinder asBinder() {
            return this.f9848a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.m
        public void b() {
            d(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.m
        public void c(String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            d(1, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class o extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private MediaBrowserServiceCompat f9849a;

        o(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.f9849a = mediaBrowserServiceCompat;
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        public void b() {
            this.f9849a = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f9849a;
            if (mediaBrowserServiceCompat != null) {
                mediaBrowserServiceCompat.c(message);
            } else {
                removeCallbacksAndMessages(null);
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j11) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            int callingPid = Binder.getCallingPid();
            if (callingPid > 0) {
                data.putInt("data_calling_pid", callingPid);
            } else if (!data.containsKey("data_calling_pid")) {
                data.putInt("data_calling_pid", -1);
            }
            return super.sendMessageAtTime(message, j11);
        }
    }

    void a(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<androidx.core.util.e> list = (List) connectionRecord.f9807g.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        for (androidx.core.util.e eVar : list) {
            if (iBinder == eVar.f8347a && androidx.media.a.a(bundle, (Bundle) eVar.f8348b)) {
                return;
            }
        }
        list.add(new androidx.core.util.e(iBinder, bundle));
        connectionRecord.f9807g.put(str, list);
        n(str, connectionRecord, bundle, null);
        this.f9798f = connectionRecord;
        k(str, bundle);
        this.f9798f = null;
    }

    List b(List list, Bundle bundle) {
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

    void c(Message message) {
        Bundle data = message.getData();
        switch (message.what) {
            case 1:
                Bundle bundle = data.getBundle("data_root_hints");
                MediaSessionCompat.a(bundle);
                this.f9794b.b(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new n(message.replyTo));
                return;
            case 2:
                this.f9794b.c(new n(message.replyTo));
                return;
            case 3:
                Bundle bundle2 = data.getBundle("data_options");
                MediaSessionCompat.a(bundle2);
                this.f9794b.a(data.getString("data_media_item_id"), androidx.core.app.f.a(data, "data_callback_token"), bundle2, new n(message.replyTo));
                return;
            case 4:
                this.f9794b.f(data.getString("data_media_item_id"), androidx.core.app.f.a(data, "data_callback_token"), new n(message.replyTo));
                return;
            case 5:
                this.f9794b.d(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new n(message.replyTo));
                return;
            case 6:
                Bundle bundle3 = data.getBundle("data_root_hints");
                MediaSessionCompat.a(bundle3);
                this.f9794b.e(new n(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                return;
            case 7:
                this.f9794b.i(new n(message.replyTo));
                return;
            case 8:
                Bundle bundle4 = data.getBundle("data_search_extras");
                MediaSessionCompat.a(bundle4);
                this.f9794b.g(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new n(message.replyTo));
                return;
            case 9:
                Bundle bundle5 = data.getBundle("data_custom_action_extras");
                MediaSessionCompat.a(bundle5);
                this.f9794b.h(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new n(message.replyTo));
                return;
            default:
                Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                return;
        }
    }

    boolean d(String str, int i11) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i11)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void e(String str, Bundle bundle, k kVar) {
        kVar.e(null);
    }

    public abstract e f(String str, int i11, Bundle bundle);

    public abstract void g(String str, k kVar);

    public void h(String str, k kVar, Bundle bundle) {
        kVar.g(1);
        g(str, kVar);
    }

    public void i(String str, k kVar) {
        kVar.g(2);
        kVar.f(null);
    }

    public void j(String str, Bundle bundle, k kVar) {
        kVar.g(4);
        kVar.f(null);
    }

    public void k(String str, Bundle bundle) {
    }

    public void l(String str) {
    }

    void m(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        d dVar = new d(str, resultReceiver);
        this.f9798f = connectionRecord;
        e(str, bundle, dVar);
        this.f9798f = null;
        if (dVar.b()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    void n(String str, ConnectionRecord connectionRecord, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, connectionRecord, str, bundle, bundle2);
        this.f9798f = connectionRecord;
        if (bundle == null) {
            g(str, aVar);
        } else {
            h(str, aVar, bundle);
        }
        this.f9798f = null;
        if (aVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.f9801a + " id=" + str);
    }

    void o(String str, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        b bVar = new b(str, resultReceiver);
        this.f9798f = connectionRecord;
        i(str, bVar);
        this.f9798f = null;
        if (bVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f9793a.b(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            this.f9793a = new i();
        } else if (i11 >= 26) {
            this.f9793a = new h();
        } else {
            this.f9793a = new g();
        }
        this.f9793a.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f9799g.b();
    }

    void p(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        c cVar = new c(str, resultReceiver);
        this.f9798f = connectionRecord;
        j(str, bundle, cVar);
        this.f9798f = null;
        if (cVar.b()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    boolean q(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z10 = false;
        try {
            if (iBinder != null) {
                List list = (List) connectionRecord.f9807g.get(str);
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (iBinder == ((androidx.core.util.e) it.next()).f8347a) {
                            it.remove();
                            z10 = true;
                        }
                    }
                    if (list.size() == 0) {
                        connectionRecord.f9807g.remove(str);
                    }
                }
            } else if (connectionRecord.f9807g.remove(str) != null) {
                z10 = true;
            }
            return z10;
        } finally {
            this.f9798f = connectionRecord;
            l(str);
            this.f9798f = null;
        }
    }

    public void r(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null");
        }
        if (this.f9800h != null) {
            throw new IllegalStateException("The session token has already been set");
        }
        this.f9800h = token;
        this.f9793a.a(token);
    }
}
