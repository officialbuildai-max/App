package com.google.firebase.sessions;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;

/* loaded from: classes4.dex */
public final class SessionLifecycleClient {

    /* renamed from: f, reason: collision with root package name */
    public static final a f32662f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final CoroutineContext f32663a;

    /* renamed from: b, reason: collision with root package name */
    private Messenger f32664b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f32665c;

    /* renamed from: d, reason: collision with root package name */
    private final LinkedBlockingDeque f32666d;

    /* renamed from: e, reason: collision with root package name */
    private final b f32667e;

    /* loaded from: classes4.dex */
    public static final class ClientUpdateHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final CoroutineContext f32668a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClientUpdateHandler(CoroutineContext backgroundDispatcher) {
            super(Looper.getMainLooper());
            Intrinsics.h(backgroundDispatcher, "backgroundDispatcher");
            this.f32668a = backgroundDispatcher;
        }

        private final void a(String str) {
            kotlinx.coroutines.k.d(o0.a(this.f32668a), null, null, new SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(str, null), 3, null);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            String str;
            Intrinsics.h(msg, "msg");
            if (msg.what == 3) {
                Bundle data = msg.getData();
                if (data == null || (str = data.getString("SessionUpdateExtra")) == null) {
                    str = "";
                }
                a(str);
                return;
            }
            Log.w("SessionLifecycleClient", "Received unexpected event from the SessionLifecycleService: " + msg);
            super.handleMessage(msg);
        }
    }

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Connected to SessionLifecycleService. Queue size ");
            sb2.append(SessionLifecycleClient.this.f32666d.size());
            SessionLifecycleClient.this.f32664b = new Messenger(iBinder);
            SessionLifecycleClient.this.f32665c = true;
            SessionLifecycleClient sessionLifecycleClient = SessionLifecycleClient.this;
            sessionLifecycleClient.o(sessionLifecycleClient.j());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SessionLifecycleClient.this.f32664b = null;
            SessionLifecycleClient.this.f32665c = false;
        }
    }

    public SessionLifecycleClient(CoroutineContext backgroundDispatcher) {
        Intrinsics.h(backgroundDispatcher, "backgroundDispatcher");
        this.f32663a = backgroundDispatcher;
        this.f32666d = new LinkedBlockingDeque(20);
        this.f32667e = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List j() {
        ArrayList arrayList = new ArrayList();
        this.f32666d.drainTo(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Message l(List list, int i11) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((Message) obj2).what == i11) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long when = ((Message) next).getWhen();
                do {
                    Object next2 = it.next();
                    long when2 = ((Message) next2).getWhen();
                    if (when < when2) {
                        next = next2;
                        when = when2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Message) obj;
    }

    private final void m(Message message) {
        if (!this.f32666d.offer(message)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to enqueue message ");
            sb2.append(message.what);
            sb2.append(". Dropping.");
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Queued message ");
        sb3.append(message.what);
        sb3.append(". Queue size ");
        sb3.append(this.f32666d.size());
    }

    private final void n(int i11) {
        List j11 = j();
        Message obtain = Message.obtain(null, i11, 0, 0);
        Intrinsics.g(obtain, "obtain(null, messageCode, 0, 0)");
        j11.add(obtain);
        o(j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final t1 o(List list) {
        t1 d11;
        d11 = kotlinx.coroutines.k.d(o0.a(this.f32663a), null, null, new SessionLifecycleClient$sendLifecycleEvents$1(this, list, null), 3, null);
        return d11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Message message) {
        if (this.f32664b == null) {
            m(message);
            return;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Sending lifecycle ");
            sb2.append(message.what);
            sb2.append(" to service");
            Messenger messenger = this.f32664b;
            if (messenger != null) {
                messenger.send(message);
            }
        } catch (RemoteException e11) {
            Log.w("SessionLifecycleClient", "Unable to deliver message: " + message.what, e11);
            m(message);
        }
    }

    public final void h() {
        n(2);
    }

    public final void i(y sessionLifecycleServiceBinder) {
        Intrinsics.h(sessionLifecycleServiceBinder, "sessionLifecycleServiceBinder");
        sessionLifecycleServiceBinder.a(new Messenger(new ClientUpdateHandler(this.f32663a)), this.f32667e);
    }

    public final void k() {
        n(1);
    }
}
