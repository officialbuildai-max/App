package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.transsion.push.PushConstants;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class FirebaseMessagingService extends EnhancedIntentService {

    /* renamed from: g, reason: collision with root package name */
    private static final Queue f32038g = new ArrayDeque(10);

    /* renamed from: f, reason: collision with root package name */
    private Rpc f32039f;

    private boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue queue = f32038g;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        }
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Received duplicate message: ");
        sb2.append(str);
        return true;
    }

    private void m(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (k0.t(extras)) {
            k0 k0Var = new k0(extras);
            ExecutorService e11 = n.e();
            try {
                if (new f(this, k0Var, e11).a()) {
                    return;
                }
                e11.shutdown();
                if (i0.D(intent)) {
                    i0.w(intent);
                }
            } finally {
                e11.shutdown();
            }
        }
        r(new RemoteMessage(extras));
    }

    private String n(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra(PushConstants.EXTRA_PUSH_MESSAGE_ID) : stringExtra;
    }

    private Rpc o(Context context) {
        if (this.f32039f == null) {
            this.f32039f = new Rpc(context.getApplicationContext());
        }
        return this.f32039f;
    }

    private void p(Intent intent) {
        if (!l(intent.getStringExtra("google.message_id"))) {
            v(intent);
        }
        o(this).messageHandled(new CloudMessage(intent));
    }

    private void v(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_PUSH_MESSAGE_TYPE);
        if (stringExtra == null) {
            stringExtra = GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE;
        }
        char c11 = 65535;
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_DELETED)) {
                    c11 = 0;
                    break;
                }
                break;
            case 102161:
                if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
                    c11 = 1;
                    break;
                }
                break;
            case 814694033:
                if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR)) {
                    c11 = 2;
                    break;
                }
                break;
            case 814800675:
                if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_EVENT)) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                q();
                return;
            case 1:
                i0.y(intent);
                m(intent);
                return;
            case 2:
                u(n(intent), new SendException(intent.getStringExtra("error")));
                return;
            case 3:
                s(intent.getStringExtra("google.message_id"));
                return;
            default:
                Log.w("FirebaseMessaging", "Received message with unknown type: " + stringExtra);
                return;
        }
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    protected Intent e(Intent intent) {
        return v0.b().c();
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void f(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            p(intent);
        } else {
            if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
                t(intent.getStringExtra("token"));
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown intent action: ");
            sb2.append(intent.getAction());
        }
    }

    public void q() {
    }

    public void r(RemoteMessage remoteMessage) {
    }

    public void s(String str) {
    }

    public void t(String str) {
    }

    public void u(String str, Exception exc) {
    }
}
