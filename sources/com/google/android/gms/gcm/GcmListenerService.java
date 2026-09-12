package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import com.transsion.push.PushConstants;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class GcmListenerService extends com.google.android.gms.iid.zze {
    private com.google.android.gms.internal.gcm.zzl zzg = com.google.android.gms.internal.gcm.zzm.zzdk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzd(Bundle bundle) {
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && next.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    @Override // com.google.android.gms.iid.zze
    public void handleIntent(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            String valueOf = String.valueOf(intent.getAction());
            Log.w("GcmListenerService", valueOf.length() != 0 ? "Unknown intent action: ".concat(valueOf) : new String("Unknown intent action: "));
            return;
        }
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
                onDeletedMessages();
                return;
            case 1:
                Bundle extras = intent.getExtras();
                extras.remove(PushConstants.EXTRA_PUSH_MESSAGE_TYPE);
                extras.remove("androidx.contentpager.content.wakelockid");
                if ("1".equals(zzd.zzd(extras, "gcm.n.e")) || zzd.zzd(extras, "gcm.n.icon") != null) {
                    if (!((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                        int myPid = Process.myPid();
                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
                        if (runningAppProcesses != null) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    ActivityManager.RunningAppProcessInfo next = it.next();
                                    if (next.pid == myPid) {
                                        if (next.importance == 100) {
                                            Bundle bundle = new Bundle();
                                            Iterator<String> it2 = extras.keySet().iterator();
                                            while (it2.hasNext()) {
                                                String next2 = it2.next();
                                                String string = extras.getString(next2);
                                                if (next2.startsWith("gcm.notification.")) {
                                                    next2 = next2.replace("gcm.notification.", "gcm.n.");
                                                }
                                                if (next2.startsWith("gcm.n.")) {
                                                    if (!"gcm.n.e".equals(next2)) {
                                                        bundle.putString(next2.substring(6), string);
                                                    }
                                                    it2.remove();
                                                }
                                            }
                                            String string2 = bundle.getString("sound2");
                                            if (string2 != null) {
                                                bundle.remove("sound2");
                                                bundle.putString("sound", string2);
                                            }
                                            if (!bundle.isEmpty()) {
                                                extras.putBundle("notification", bundle);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    zzd.zzd(this).zze(extras);
                    return;
                }
                String string3 = extras.getString("from");
                extras.remove("from");
                zzd(extras);
                this.zzg.zzl("onMessageReceived");
                onMessageReceived(string3, extras);
                return;
            case 2:
                String stringExtra2 = intent.getStringExtra("google.message_id");
                if (stringExtra2 == null) {
                    stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_PUSH_MESSAGE_ID);
                }
                onSendError(stringExtra2, intent.getStringExtra("error"));
                return;
            case 3:
                onMessageSent(intent.getStringExtra("google.message_id"));
                return;
            default:
                Log.w("GcmListenerService", stringExtra.length() != 0 ? "Received message with unknown type: ".concat(stringExtra) : new String("Received message with unknown type: "));
                return;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.google.android.gms.internal.gcm.zzm.zzab();
        this.zzg = com.google.android.gms.internal.gcm.zzm.zzdk;
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(String str, Bundle bundle) {
    }

    public void onMessageSent(String str) {
    }

    public void onSendError(String str, String str2) {
    }
}
