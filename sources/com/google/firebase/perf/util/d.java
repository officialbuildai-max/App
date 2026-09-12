package com.google.firebase.perf.util;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    private static final sc.a f32421b = sc.a.e();

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f32422a;

    public d() {
        this(new Bundle());
    }

    public d(Bundle bundle) {
        this.f32422a = (Bundle) bundle.clone();
    }

    private e d(String str) {
        if (!a(str)) {
            return e.a();
        }
        try {
            return e.b((Integer) this.f32422a.get(str));
        } catch (ClassCastException e11) {
            f32421b.b("Metadata key %s contains type other than int: %s", str, e11.getMessage());
            return e.a();
        }
    }

    public boolean a(String str) {
        return str != null && this.f32422a.containsKey(str);
    }

    public e b(String str) {
        if (!a(str)) {
            return e.a();
        }
        try {
            return e.b((Boolean) this.f32422a.get(str));
        } catch (ClassCastException e11) {
            f32421b.b("Metadata key %s contains type other than boolean: %s", str, e11.getMessage());
            return e.a();
        }
    }

    public e c(String str) {
        Object obj;
        if (a(str) && (obj = this.f32422a.get(str)) != null) {
            if (obj instanceof Float) {
                return e.e(Double.valueOf(((Float) obj).doubleValue()));
            }
            if (obj instanceof Double) {
                return e.e((Double) obj);
            }
            f32421b.b("Metadata key %s contains type other than double: %s", str);
            return e.a();
        }
        return e.a();
    }

    public e e(String str) {
        return d(str).d() ? e.e(Long.valueOf(((Integer) r3.c()).intValue())) : e.a();
    }
}
