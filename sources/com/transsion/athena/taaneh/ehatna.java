package com.transsion.athena.taaneh;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.push.PushConstants;
import com.transsion.sdk.oneid.OneID;
import java.util.UUID;
import k4.b;

/* loaded from: classes5.dex */
public class ehatna {

    /* renamed from: a, reason: collision with root package name */
    private static String f42864a = "";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f42865b;

    public static String a() {
        if (!TextUtils.isEmpty(f42864a)) {
            return f42864a;
        }
        if (OneID.f()) {
            aethna.a("OneID isEnable = true");
            f42864a = f42865b ? OneID.e().b() : "";
        }
        return f42864a;
    }

    private static void a(Context context) {
        if (TextUtils.isEmpty(f42864a)) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (!TextUtils.isEmpty(string)) {
                        f42864a = UUID.nameUUIDFromBytes((context.getPackageName() + string).getBytes()).toString();
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(f42864a)) {
                f42864a = UUID.randomUUID().toString();
            }
            try {
                b.b(context).c(PushConstants.PROVIDER_VAID, f42864a);
            } catch (Exception e12) {
                aethna.b(Log.getStackTraceString(e12));
            }
        }
    }

    public static void a(Context context, int i11, int i12) {
        try {
            OneID.d(context, i11, i12);
            f42865b = true;
        } catch (Exception e11) {
            aethna.b(Log.getStackTraceString(e11));
        }
    }

    public static String b(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e11) {
            aethna.b(Log.getStackTraceString(e11));
            a(context);
        }
        if (!TextUtils.isEmpty(f42864a)) {
            return f42864a;
        }
        if (OneID.f()) {
            aethna.a("OneID isEnable = true");
            f42864a = f42865b ? OneID.e().b() : "";
        }
        if (TextUtils.isEmpty(f42864a)) {
            f42864a = b.b(context).a(PushConstants.PROVIDER_VAID);
            a(context);
        }
        aethna.a("*******************/ vaid cost : " + (System.currentTimeMillis() - currentTimeMillis) + " /*******************");
        return f42864a;
    }
}
