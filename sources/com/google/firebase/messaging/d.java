package com.google.firebase.messaging;

import android.R;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import java.util.concurrent.atomic.AtomicInteger;
import org.mvel2.ast.ASTNode;

/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f32114a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final NotificationCompat.m f32115a;

        /* renamed from: b, reason: collision with root package name */
        public final String f32116b;

        /* renamed from: c, reason: collision with root package name */
        public final int f32117c;

        a(NotificationCompat.m mVar, String str, int i11) {
            this.f32115a = mVar;
            this.f32116b = str;
            this.f32117c = i11;
        }
    }

    private static PendingIntent a(Context context, k0 k0Var, String str, PackageManager packageManager) {
        Intent f11 = f(str, k0Var, packageManager);
        if (f11 == null) {
            return null;
        }
        f11.addFlags(67108864);
        f11.putExtras(k0Var.y());
        if (q(k0Var)) {
            f11.putExtra("gcm.n.analytics_data", k0Var.x());
        }
        return PendingIntent.getActivity(context, g(), f11, l(1073741824));
    }

    private static PendingIntent b(Context context, Context context2, k0 k0Var) {
        if (q(k0Var)) {
            return c(context, context2, new Intent(CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_DISMISS).putExtras(k0Var.x()));
        }
        return null;
    }

    private static PendingIntent c(Context context, Context context2, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.android.c2dm.intent.RECEIVE").setPackage(context2.getPackageName()).putExtra(CloudMessagingReceiver.IntentKeys.WRAPPED_INTENT, intent), l(1073741824));
    }

    public static a d(Context context, Context context2, k0 k0Var, String str, Bundle bundle) {
        String packageName = context2.getPackageName();
        Resources resources = context2.getResources();
        PackageManager packageManager = context2.getPackageManager();
        NotificationCompat.m mVar = new NotificationCompat.m(context2, str);
        String n11 = k0Var.n(resources, packageName, "gcm.n.title");
        if (!TextUtils.isEmpty(n11)) {
            mVar.q(n11);
        }
        String n12 = k0Var.n(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(n12)) {
            mVar.p(n12);
            mVar.L(new NotificationCompat.k().q(n12));
        }
        mVar.J(m(packageManager, resources, packageName, k0Var.p("gcm.n.icon"), bundle));
        Uri n13 = n(packageName, k0Var, resources);
        if (n13 != null) {
            mVar.K(n13);
        }
        mVar.o(a(context, k0Var, packageName, packageManager));
        PendingIntent b11 = b(context, context2, k0Var);
        if (b11 != null) {
            mVar.u(b11);
        }
        Integer h11 = h(context2, k0Var.p("gcm.n.color"), bundle);
        if (h11 != null) {
            mVar.n(h11.intValue());
        }
        mVar.l(!k0Var.a("gcm.n.sticky"));
        mVar.C(k0Var.a("gcm.n.local_only"));
        String p11 = k0Var.p("gcm.n.ticker");
        if (p11 != null) {
            mVar.M(p11);
        }
        Integer m11 = k0Var.m();
        if (m11 != null) {
            mVar.G(m11.intValue());
        }
        Integer r11 = k0Var.r();
        if (r11 != null) {
            mVar.O(r11.intValue());
        }
        Integer l11 = k0Var.l();
        if (l11 != null) {
            mVar.D(l11.intValue());
        }
        Long j11 = k0Var.j("gcm.n.event_time");
        if (j11 != null) {
            mVar.I(true);
            mVar.P(j11.longValue());
        }
        long[] q11 = k0Var.q();
        if (q11 != null) {
            mVar.N(q11);
        }
        int[] e11 = k0Var.e();
        if (e11 != null) {
            mVar.B(e11[0], e11[1], e11[2]);
        }
        mVar.t(i(k0Var));
        return new a(mVar, o(k0Var), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a e(Context context, k0 k0Var) {
        Bundle j11 = j(context.getPackageManager(), context.getPackageName());
        return d(context, context, k0Var, k(context, k0Var.k(), j11), j11);
    }

    private static Intent f(String str, k0 k0Var, PackageManager packageManager) {
        String p11 = k0Var.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(p11)) {
            Intent intent = new Intent(p11);
            intent.setPackage(str);
            intent.setFlags(ASTNode.DEOP);
            return intent;
        }
        Uri f11 = k0Var.f();
        if (f11 != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(f11);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static int g() {
        return f32114a.incrementAndGet();
    }

    private static Integer h(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                Log.w("FirebaseMessaging", "Color is invalid: " + str + ". Notification will use default color.");
            }
        }
        int i11 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i11 == 0) {
            return null;
        }
        try {
            return Integer.valueOf(androidx.core.content.b.getColor(context, i11));
        } catch (Resources.NotFoundException unused2) {
            Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static int i(k0 k0Var) {
        boolean a11 = k0Var.a("gcm.n.default_sound");
        ?? r02 = a11;
        if (k0Var.a("gcm.n.default_vibrate_timings")) {
            r02 = (a11 ? 1 : 0) | 2;
        }
        return k0Var.a("gcm.n.default_light_settings") ? r02 | 4 : r02;
    }

    private static Bundle j(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle;
                }
            }
        } catch (PackageManager.NameNotFoundException e11) {
            Log.w("FirebaseMessaging", "Couldn't get own application info: " + e11);
        }
        return Bundle.EMPTY;
    }

    public static String k(Context context, String str, Bundle bundle) {
        NotificationChannel notificationChannel;
        String string;
        NotificationChannel notificationChannel2;
        NotificationChannel notificationChannel3;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                notificationChannel3 = notificationManager.getNotificationChannel(str);
                if (notificationChannel3 != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", "Notification Channel requested (" + str + ") has not been created by the app. Manifest configuration, or default, value will be used.");
            }
            String string2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string2)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else {
                notificationChannel2 = notificationManager.getNotificationChannel(string2);
                if (notificationChannel2 != null) {
                    return string2;
                }
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            notificationChannel = notificationManager.getNotificationChannel("fcm_fallback_notification_channel");
            if (notificationChannel == null) {
                int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName());
                if (identifier == 0) {
                    Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                    string = "Misc";
                } else {
                    string = context.getString(identifier);
                }
                notificationManager.createNotificationChannel(m.f.a("fcm_fallback_notification_channel", string, 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static int l(int i11) {
        return i11 | 67108864;
    }

    private static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            Log.w("FirebaseMessaging", "Icon resource " + str2 + " not found. Notification will use default icon.");
        }
        int i11 = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i11 == 0 || !p(resources, i11)) {
            try {
                i11 = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e11) {
                Log.w("FirebaseMessaging", "Couldn't get own application info: " + e11);
            }
        }
        return (i11 == 0 || !p(resources, i11)) ? R.drawable.sym_def_app_icon : i11;
    }

    private static Uri n(String str, k0 k0Var, Resources resources) {
        String o11 = k0Var.o();
        if (TextUtils.isEmpty(o11)) {
            return null;
        }
        if ("default".equals(o11) || resources.getIdentifier(o11, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        return Uri.parse("android.resource://" + str + "/raw/" + o11);
    }

    private static String o(k0 k0Var) {
        String p11 = k0Var.p("gcm.n.tag");
        if (!TextUtils.isEmpty(p11)) {
            return p11;
        }
        return "FCM-Notification:" + SystemClock.uptimeMillis();
    }

    private static boolean p(Resources resources, int i11) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!c.a(resources.getDrawable(i11, null))) {
                return true;
            }
            Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i11);
            return false;
        } catch (Resources.NotFoundException unused) {
            Log.e("FirebaseMessaging", "Couldn't find resource " + i11 + ", treating it as an invalid icon");
            return false;
        }
    }

    static boolean q(k0 k0Var) {
        return k0Var.a("google.c.a.e");
    }
}
