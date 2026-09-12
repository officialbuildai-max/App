package com.transsion.sdk.oneid;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.transsion.sdk.oneid.data.AppIdInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class OneID {

    /* renamed from: c, reason: collision with root package name */
    static transient boolean f51961c = true;

    /* renamed from: d, reason: collision with root package name */
    static int f51962d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile OneID f51963e;

    /* renamed from: a, reason: collision with root package name */
    private final e f51964a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f51965b;

    /* loaded from: classes.dex */
    class a extends TypeToken<ConcurrentHashMap<Integer, AppIdInfo>> {
        a(OneID oneID) {
        }
    }

    private OneID(Context context) {
        this.f51965b = context;
        this.f51964a = e.a(context.getApplicationContext());
        dm.a.b(context.getApplicationContext());
    }

    public static void c(Context context, int i11) {
        e eVar;
        if (context != null && f51963e == null) {
            synchronized (OneID.class) {
                try {
                    if (f51963e == null) {
                        f51963e = new OneID(context);
                    }
                } finally {
                }
            }
        }
        OneID oneID = f51963e;
        if (oneID.f51965b == null || (eVar = oneID.f51964a) == null) {
            return;
        }
        eVar.b(i11);
    }

    public static void d(Context context, int i11, int i12) {
        if (f51962d == 0) {
            f51962d = i12;
        }
        c(context, i11);
    }

    public static OneID e() {
        if (f51963e != null) {
            return f51963e;
        }
        throw new IllegalStateException("You should call OneID.init first!");
    }

    public static boolean f() {
        return f51961c;
    }

    public String a(int i11) {
        AppIdInfo appIdInfo;
        if (this.f51965b == null) {
            throw new OneIDException("OneID not init yet");
        }
        e eVar = this.f51964a;
        String str = "";
        String i12 = eVar != null ? eVar.i(i11) : "";
        if (!TextUtils.isEmpty(i12)) {
            return i12;
        }
        try {
            String h11 = n00.b.b(this.f51965b).h("appid_info_list");
            if (!TextUtils.isEmpty(h11) && (appIdInfo = (AppIdInfo) ((ConcurrentHashMap) new Gson().fromJson(h11, new a(this).getType())).get(Integer.valueOf(i11))) != null) {
                i12 = appIdInfo.odid;
                str = appIdInfo.msg;
            }
        } catch (Exception e11) {
            b.m(Log.getStackTraceString(e11));
        }
        if (!TextUtils.isEmpty(i12)) {
            return i12;
        }
        if (TextUtils.isEmpty(str)) {
            str = "Please try later";
        }
        throw new OneIDException(str);
    }

    public String b() {
        e eVar = this.f51964a;
        return eVar != null ? eVar.h() : "";
    }
}
