package com.pgl.ssdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes5.dex */
public class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile i0 f40207a;

    /* renamed from: b, reason: collision with root package name */
    private Context f40208b;

    /* renamed from: c, reason: collision with root package name */
    private List<Integer> f40209c = new ArrayList();

    private i0(Context context) {
        this.f40208b = null;
        this.f40208b = context;
    }

    public static i0 a(Context context) {
        if (f40207a == null) {
            synchronized (i0.class) {
                try {
                    if (f40207a == null) {
                        f40207a = new i0(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f40207a;
    }

    public void a() {
        int f11 = f();
        if (f11 == -1) {
            return;
        }
        this.f40209c.add(Integer.valueOf(f11));
        try {
            int size = this.f40209c.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f40209c.subList(size - 10, size));
                this.f40209c.clear();
                this.f40209c = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public int b() {
        Intent registerReceiver = this.f40208b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return 0;
        }
        return registerReceiver.getIntExtra("plugged", 0);
    }

    public int c() {
        if (this.f40208b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) == null) {
            return 0;
        }
        return Math.round(((r0.getIntExtra(PermissionConstant.level, 0) / r0.getIntExtra("scale", 0)) * 100.0f) * 10.0f) / 10;
    }

    public synchronized String d() {
        if (this.f40209c.size() <= 0) {
            return TmcConstants.COLD_OPEN_TYPE;
        }
        return String.valueOf(this.f40209c.get(r0.size() - 1).intValue() % 10000);
    }

    public synchronized String e() {
        return new JSONArray((Collection) this.f40209c).toString();
    }

    @SuppressLint({"DefaultLocale"})
    public int f() {
        int c11;
        int i11 = 0;
        try {
            synchronized (this) {
                i11 = b();
                c11 = c();
            }
            return (i11 * 10000) + c11;
        } catch (Exception unused) {
            return i11 * 10000;
        }
    }
}
