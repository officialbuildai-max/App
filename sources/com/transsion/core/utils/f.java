package com.transsion.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    private static Map f44130c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static final Set f44131d = new HashSet(0);

    /* renamed from: e, reason: collision with root package name */
    private static final Object f44132e = null;

    /* renamed from: f, reason: collision with root package name */
    private static Context f44133f = null;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f44134a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f44135b;

    private f(String str) {
        Context context = f44133f;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            this.f44134a = sharedPreferences;
            if (sharedPreferences != null) {
                this.f44135b = sharedPreferences.edit();
            }
        }
    }

    public static void a(Context context) {
        f44133f = context;
    }

    public static synchronized f e(String str) {
        f fVar;
        synchronized (f.class) {
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("please make sure you have valid file name");
            }
            fVar = (f) f44130c.get(str);
            if (fVar == null) {
                fVar = new f(str);
                f44130c.put(str, fVar);
            }
        }
        return fVar;
    }

    public boolean b(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str) || (sharedPreferences = this.f44134a) == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, false);
    }

    public boolean c(String str, boolean z10) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f44134a) == null) ? z10 : sharedPreferences.getBoolean(str, z10);
    }

    public float d(String str, float f11) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f44134a) == null) ? f11 : sharedPreferences.getFloat(str, f11);
    }

    public int f(String str, int i11) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f44134a) == null) ? i11 : sharedPreferences.getInt(str, i11);
    }

    public long g(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str) || (sharedPreferences = this.f44134a) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str, 0L);
    }

    public long h(String str, long j11) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f44134a) == null) ? j11 : sharedPreferences.getLong(str, j11);
    }

    public String i(String str) {
        return !TextUtils.isEmpty(str) ? j(str, "") : "";
    }

    public String j(String str, String str2) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f44134a) == null) ? str2 : sharedPreferences.getString(str, str2);
    }

    public Set k(String str, Set set) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.f44134a) == null) ? set : sharedPreferences.getStringSet(str, set);
    }

    public void l(String str, boolean z10) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f44135b) == null) {
            return;
        }
        editor.putBoolean(str, z10);
        this.f44135b.apply();
    }

    public void m(String str, float f11) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f44135b) == null) {
            return;
        }
        editor.putFloat(str, f11);
        this.f44135b.apply();
    }

    public void n(String str, int i11) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f44135b) == null) {
            return;
        }
        editor.putInt(str, i11);
        this.f44135b.apply();
    }

    public void o(String str, long j11) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f44135b) == null) {
            return;
        }
        editor.putLong(str, j11);
        this.f44135b.apply();
    }

    public void p(String str, String str2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (editor = this.f44135b) == null) {
            return;
        }
        editor.putString(str, str2);
        this.f44135b.apply();
    }

    public void q(String str, Set set) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.f44135b) == null) {
            return;
        }
        editor.putStringSet(str, set);
        this.f44135b.apply();
    }

    public void r(String str) {
        SharedPreferences.Editor editor = this.f44135b;
        if (editor != null) {
            editor.remove(str);
            this.f44135b.apply();
        }
    }
}
