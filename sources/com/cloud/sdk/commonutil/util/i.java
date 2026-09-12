package com.cloud.sdk.commonutil.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class i {

    /* renamed from: c, reason: collision with root package name */
    private static Map f23277c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static final Set f23278d = new HashSet(0);

    /* renamed from: e, reason: collision with root package name */
    private static final Object f23279e = null;

    /* renamed from: f, reason: collision with root package name */
    private static Context f23280f = null;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f23281a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f23282b;

    private i(String str) {
        Context context = f23280f;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            this.f23281a = sharedPreferences;
            if (sharedPreferences != null) {
                this.f23282b = sharedPreferences.edit();
            }
        }
    }

    public static void a(Context context) {
        f23280f = context;
    }

    public static synchronized i d(String str) {
        i iVar;
        synchronized (i.class) {
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("please make sure you have valid file name");
            }
            iVar = (i) f23277c.get(str);
            if (iVar == null) {
                iVar = new i(str);
                f23277c.put(str, iVar);
            }
        }
        return iVar;
    }

    public void b() {
        SharedPreferences.Editor editor = this.f23282b;
        if (editor != null) {
            editor.clear();
            this.f23282b.apply();
        }
    }

    public boolean c(String str, boolean z10) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f23281a) == null) ? z10 : sharedPreferences.getBoolean(str, z10);
    }

    public int e(String str, int i11) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f23281a) == null) ? i11 : sharedPreferences.getInt(str, i11);
    }

    public long f(String str, long j11) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f23281a) == null) ? j11 : sharedPreferences.getLong(str, j11);
    }

    public String g(String str, String str2) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f23281a) == null) ? str2 : sharedPreferences.getString(str, str2);
    }

    public Set h(String str, Set set) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f23281a) == null) ? set : sharedPreferences.getStringSet(str, set);
    }

    public void i(String str, boolean z10) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f23282b) == null) {
            return;
        }
        editor.putBoolean(str, z10);
        this.f23282b.apply();
    }

    public void j(String str, int i11) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f23282b) == null) {
            return;
        }
        editor.putInt(str, i11);
        this.f23282b.apply();
    }

    public void k(String str, long j11) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f23282b) == null) {
            return;
        }
        editor.putLong(str, j11);
        this.f23282b.apply();
    }

    public void l(String str, String str2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (editor = this.f23282b) == null) {
            return;
        }
        editor.putString(str, str2);
        this.f23282b.apply();
    }

    public void m(String str) {
        SharedPreferences.Editor editor = this.f23282b;
        if (editor != null) {
            editor.remove(str);
            this.f23282b.apply();
        }
    }
}
