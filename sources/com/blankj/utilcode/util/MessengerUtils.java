package com.blankj.utilcode.util;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.blankj.utilcode.util.s;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class MessengerUtils {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap f20093a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Map f20094b = new HashMap();

    /* loaded from: classes2.dex */
    public static class ServerService extends Service {

        /* renamed from: a, reason: collision with root package name */
        private final ConcurrentHashMap f20095a = new ConcurrentHashMap();

        /* renamed from: b, reason: collision with root package name */
        private final Handler f20096b;

        /* renamed from: c, reason: collision with root package name */
        private final Messenger f20097c;

        /* loaded from: classes2.dex */
        class a extends Handler {
            a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i11 = message.what;
                if (i11 == 0) {
                    ServerService.this.f20095a.put(Integer.valueOf(message.arg1), message.replyTo);
                    return;
                }
                if (i11 == 1) {
                    ServerService.this.f20095a.remove(Integer.valueOf(message.arg1));
                } else if (i11 != 2) {
                    super.handleMessage(message);
                } else {
                    ServerService.this.e(message);
                    ServerService.this.d(message);
                }
            }
        }

        public ServerService() {
            a aVar = new a();
            this.f20096b = aVar;
            this.f20097c = new Messenger(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Message message) {
            String string;
            Bundle data = message.getData();
            if (data == null || (string = data.getString("MESSENGER_UTILS")) == null) {
                return;
            }
            android.support.v4.media.session.c.a(MessengerUtils.f20093a.get(string));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(Message message) {
            Message obtain = Message.obtain(message);
            for (Messenger messenger : this.f20095a.values()) {
                if (messenger != null) {
                    try {
                        messenger.send(Message.obtain(obtain));
                    } catch (RemoteException e11) {
                        e11.printStackTrace();
                    }
                }
            }
            obtain.recycle();
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return this.f20097c.getBinder();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i11, int i12) {
            Bundle extras;
            if (Build.VERSION.SDK_INT >= 26) {
                startForeground(1, e0.q(s.a.f20176b, null));
            }
            if (intent != null && (extras = intent.getExtras()) != null) {
                Message obtain = Message.obtain(this.f20096b, 2);
                obtain.replyTo = this.f20097c;
                obtain.setData(extras);
                e(obtain);
                d(obtain);
            }
            return 2;
        }
    }
}
