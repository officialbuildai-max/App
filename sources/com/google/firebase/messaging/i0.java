package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.integration.event.EventConstants;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.transsion.push.PushConstants;
import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
public class i0 {
    static void A(String str, Bundle bundle) {
        try {
            com.google.firebase.f.l();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String d11 = d(bundle);
            if (d11 != null) {
                bundle2.putString("_nmid", d11);
            }
            String e11 = e(bundle);
            if (e11 != null) {
                bundle2.putString("_nmn", e11);
            }
            String i11 = i(bundle);
            if (!TextUtils.isEmpty(i11)) {
                bundle2.putString("label", i11);
            }
            String g11 = g(bundle);
            if (!TextUtils.isEmpty(g11)) {
                bundle2.putString("message_channel", g11);
            }
            String r11 = r(bundle);
            if (r11 != null) {
                bundle2.putString("_nt", r11);
            }
            String l11 = l(bundle);
            if (l11 != null) {
                try {
                    bundle2.putInt("_nmt", Integer.parseInt(l11));
                } catch (NumberFormatException e12) {
                    Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e12);
                }
            }
            String t11 = t(bundle);
            if (t11 != null) {
                try {
                    bundle2.putInt("_ndt", Integer.parseInt(t11));
                } catch (NumberFormatException e13) {
                    Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e13);
                }
            }
            String n11 = n(bundle);
            if ("_nr".equals(str) || "_nf".equals(str)) {
                bundle2.putString("_nmc", n11);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Logging to scion event=");
                sb2.append(str);
                sb2.append(" scionPayload=");
                sb2.append(bundle2);
            }
            kb.a aVar = (kb.a) com.google.firebase.f.l().j(kb.a.class);
            if (aVar != null) {
                aVar.b(AppMeasurement.FCM_ORIGIN, str, bundle2);
            } else {
                Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
            }
        } catch (IllegalStateException unused) {
            Log.e("FirebaseMessaging", "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    private static void B(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!"1".equals(bundle.getString("google.c.a.tc"))) {
            Log.isLoggable("FirebaseMessaging", 3);
            return;
        }
        kb.a aVar = (kb.a) com.google.firebase.f.l().j(kb.a.class);
        Log.isLoggable("FirebaseMessaging", 3);
        if (aVar == null) {
            Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
            return;
        }
        String string = bundle.getString("google.c.a.c_id");
        aVar.c(AppMeasurement.FCM_ORIGIN, "_ln", string);
        Bundle bundle2 = new Bundle();
        bundle2.putString(EventConstants.KEY_SOURCE, "Firebase");
        bundle2.putString("medium", "notification");
        bundle2.putString(MBInterstitialActivity.INTENT_CAMAPIGN, string);
        aVar.b(AppMeasurement.FCM_ORIGIN, "_cmp", bundle2);
    }

    public static boolean C(Intent intent) {
        if (intent == null || u(intent)) {
            return false;
        }
        return a();
    }

    public static boolean D(Intent intent) {
        if (intent == null || u(intent)) {
            return false;
        }
        return E(intent.getExtras());
    }

    public static boolean E(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "1".equals(bundle.getString("google.c.a.e"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        Context k11;
        SharedPreferences sharedPreferences;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            com.google.firebase.f.l();
            k11 = com.google.firebase.f.l().k();
            sharedPreferences = k11.getSharedPreferences("com.google.firebase.messaging", 0);
        } catch (PackageManager.NameNotFoundException | IllegalStateException unused) {
        }
        if (sharedPreferences.contains("export_to_big_query")) {
            return sharedPreferences.getBoolean("export_to_big_query", false);
        }
        PackageManager packageManager = k11.getPackageManager();
        if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(k11.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
            return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
        }
        return false;
    }

    static MessagingClientEvent b(MessagingClientEvent.Event event, Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = Bundle.EMPTY;
        }
        MessagingClientEvent.a j11 = MessagingClientEvent.p().n(s(extras)).e(event).f(f(extras)).i(o()).l(MessagingClientEvent.SDKPlatform.ANDROID).h(m(extras)).j(k(extras));
        String h11 = h(extras);
        if (h11 != null) {
            j11.g(h11);
        }
        String r11 = r(extras);
        if (r11 != null) {
            j11.m(r11);
        }
        String c11 = c(extras);
        if (c11 != null) {
            j11.c(c11);
        }
        String i11 = i(extras);
        if (i11 != null) {
            j11.b(i11);
        }
        String e11 = e(extras);
        if (e11 != null) {
            j11.d(e11);
        }
        long q11 = q(extras);
        if (q11 > 0) {
            j11.k(q11);
        }
        return j11.a();
    }

    static String c(Bundle bundle) {
        return bundle.getString("collapse_key");
    }

    static String d(Bundle bundle) {
        return bundle.getString("google.c.a.c_id");
    }

    static String e(Bundle bundle) {
        return bundle.getString("google.c.a.c_l");
    }

    static String f(Bundle bundle) {
        String string = bundle.getString("google.to");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return (String) Tasks.await(com.google.firebase.installations.c.q(com.google.firebase.f.l()).getId());
        } catch (InterruptedException | ExecutionException e11) {
            throw new RuntimeException(e11);
        }
    }

    static String g(Bundle bundle) {
        return bundle.getString("google.c.a.m_c");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(Bundle bundle) {
        String string = bundle.getString("google.message_id");
        return string == null ? bundle.getString(PushConstants.EXTRA_PUSH_MESSAGE_ID) : string;
    }

    static String i(Bundle bundle) {
        return bundle.getString("google.c.a.m_l");
    }

    private static int j(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    static int k(Bundle bundle) {
        int p11 = p(bundle);
        if (p11 == 2) {
            return 5;
        }
        return p11 == 1 ? 10 : 0;
    }

    static String l(Bundle bundle) {
        return bundle.getString("google.c.a.ts");
    }

    static MessagingClientEvent.MessageType m(Bundle bundle) {
        return (bundle == null || !k0.t(bundle)) ? MessagingClientEvent.MessageType.DATA_MESSAGE : MessagingClientEvent.MessageType.DISPLAY_NOTIFICATION;
    }

    static String n(Bundle bundle) {
        return (bundle == null || !k0.t(bundle)) ? "data" : "display";
    }

    static String o() {
        return com.google.firebase.f.l().k().getPackageName();
    }

    static int p(Bundle bundle) {
        String string = bundle.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(bundle.getString("google.priority_reduced"))) {
                return 2;
            }
            string = bundle.getString("google.priority");
        }
        return j(string);
    }

    static long q(Bundle bundle) {
        if (bundle.containsKey("google.c.sender.id")) {
            try {
                return Long.parseLong(bundle.getString("google.c.sender.id"));
            } catch (NumberFormatException e11) {
                Log.w("FirebaseMessaging", "error parsing project number", e11);
            }
        }
        com.google.firebase.f l11 = com.google.firebase.f.l();
        String d11 = l11.n().d();
        if (d11 != null) {
            try {
                return Long.parseLong(d11);
            } catch (NumberFormatException e12) {
                Log.w("FirebaseMessaging", "error parsing sender ID", e12);
            }
        }
        String c11 = l11.n().c();
        if (c11.startsWith("1:")) {
            String[] split = c11.split(":");
            if (split.length < 2) {
                return 0L;
            }
            String str = split[1];
            if (str.isEmpty()) {
                return 0L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e13) {
                Log.w("FirebaseMessaging", "error parsing app ID", e13);
            }
        } else {
            try {
                return Long.parseLong(c11);
            } catch (NumberFormatException e14) {
                Log.w("FirebaseMessaging", "error parsing app ID", e14);
            }
        }
        return 0L;
    }

    static String r(Bundle bundle) {
        String string = bundle.getString("from");
        if (string == null || !string.startsWith("/topics/")) {
            return null;
        }
        return string;
    }

    static int s(Bundle bundle) {
        Object obj = bundle.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
            return 0;
        }
    }

    static String t(Bundle bundle) {
        if (bundle.containsKey("google.c.a.udt")) {
            return bundle.getString("google.c.a.udt");
        }
        return null;
    }

    private static boolean u(Intent intent) {
        return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction());
    }

    public static void v(Intent intent) {
        A("_nd", intent.getExtras());
    }

    public static void w(Intent intent) {
        A("_nf", intent.getExtras());
    }

    public static void x(Bundle bundle) {
        B(bundle);
        A("_no", bundle);
    }

    public static void y(Intent intent) {
        if (D(intent)) {
            A("_nr", intent.getExtras());
        }
        if (C(intent)) {
            z(MessagingClientEvent.Event.MESSAGE_DELIVERED, intent, FirebaseMessaging.u());
        }
    }

    private static void z(MessagingClientEvent.Event event, Intent intent, r8.i iVar) {
        if (iVar == null) {
            Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
            return;
        }
        MessagingClientEvent b11 = b(event, intent);
        if (b11 == null) {
            return;
        }
        try {
            iVar.b("FCM_CLIENT_EVENT_LOGGING", nc.a.class, r8.c.b("proto"), new r8.g() { // from class: com.google.firebase.messaging.h0
                @Override // r8.g
                public final Object apply(Object obj) {
                    return ((nc.a) obj).c();
                }
            }).b(r8.d.g(nc.a.b().b(b11).a(), r8.f.b(Integer.valueOf(intent.getIntExtra("google.product_id", 111881503)))));
        } catch (RuntimeException e11) {
            Log.w("FirebaseMessaging", "Failed to send big query analytics payload.", e11);
        }
    }
}
