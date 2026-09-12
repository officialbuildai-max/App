package com.android.volley;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f19314a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19315b;

    public e(String str, String str2) {
        this.f19314a = str;
        this.f19315b = str2;
    }

    public final String a() {
        return this.f19314a;
    }

    public final String b() {
        return this.f19315b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return TextUtils.equals(this.f19314a, eVar.f19314a) && TextUtils.equals(this.f19315b, eVar.f19315b);
    }

    public int hashCode() {
        return (this.f19314a.hashCode() * 31) + this.f19315b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f19314a + ",value=" + this.f19315b + "]";
    }
}
