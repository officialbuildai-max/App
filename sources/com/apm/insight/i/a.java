package com.apm.insight.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.apm.insight.runtime.o;
import java.util.UUID;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile UUID f19635a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f19636b = "";

    @SuppressLint({"MissingPermission", "HardwareIds"})
    private a(Context context) {
        String str;
        if (f19635a == null) {
            synchronized (a.class) {
                if (f19635a == null) {
                    String c11 = o.a().c();
                    if (c11 != null) {
                        f19635a = UUID.fromString(c11);
                    } else {
                        try {
                            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        } catch (Throwable unused) {
                            str = null;
                        }
                        try {
                            if (str != null) {
                                f19635a = UUID.nameUUIDFromBytes(str.getBytes("utf8"));
                            } else {
                                f19635a = UUID.randomUUID();
                            }
                        } catch (Throwable unused2) {
                        }
                        try {
                            o.a().b(f19635a.toString());
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        }
    }

    public static synchronized String a(Context context) {
        String str;
        synchronized (a.class) {
            try {
                if (TextUtils.isEmpty(f19636b)) {
                    new a(context);
                    UUID uuid = f19635a;
                    if (uuid != null) {
                        f19636b = uuid.toString();
                    }
                }
                str = f19636b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }
}
