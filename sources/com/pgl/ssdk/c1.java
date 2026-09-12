package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes5.dex */
public class c1 {

    /* renamed from: a, reason: collision with root package name */
    public static int f40146a = 504;

    /* renamed from: b, reason: collision with root package name */
    public static String f40147b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f40148c = "";

    /* renamed from: d, reason: collision with root package name */
    static boolean f40149d;

    /* renamed from: e, reason: collision with root package name */
    private static long f40150e;

    /* renamed from: f, reason: collision with root package name */
    private static Context f40151f;

    public static synchronized Object a(byte[] bArr) {
        synchronized (c1.class) {
            if (bArr == null) {
                return null;
            }
            return com.pgl.ssdk.ces.a.meta(Sdk$SDKError.Reason.INVALID_IFA_STATUS_VALUE, f40151f, bArr);
        }
    }

    public static synchronized String a() {
        String str;
        synchronized (c1.class) {
            try {
                if (TextUtils.isEmpty(f40148c)) {
                    f40148c = (String) com.pgl.ssdk.ces.a.meta(303, f40151f, null);
                }
                str = f40148c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }

    public static void a(Context context, String str) {
        if (f40151f == null) {
            f40151f = context;
        }
        int i11 = f40146a;
        if (i11 == 102 || i11 == 202 || i11 == 200) {
            return;
        }
        f40150e = System.currentTimeMillis();
        f40149d = false;
        f40147b = str;
        f40146a = 102;
        o0.b(new l0(context, Sdk$SDKError.Reason.MRAID_ERROR_VALUE, null));
    }

    public static void b() {
        Context context = f40151f;
        if (context != null) {
            o0.b(new l0(context, Sdk$SDKError.Reason.MRAID_ERROR_VALUE, null));
            f40146a = 102;
            com.pgl.ssdk.ces.b.h().a();
            x.a();
        }
    }
}
