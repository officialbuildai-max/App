package com.mbridge.msdk.tracker.network;

import android.text.TextUtils;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final String f38630a;

    /* renamed from: b, reason: collision with root package name */
    private final String f38631b;

    public g(String str, String str2) {
        this.f38630a = str;
        this.f38631b = str2;
    }

    public final String a() {
        return this.f38630a;
    }

    public final String b() {
        return this.f38631b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return TextUtils.equals(this.f38630a, gVar.f38630a) && TextUtils.equals(this.f38631b, gVar.f38631b);
    }

    public int hashCode() {
        return (this.f38630a.hashCode() * 31) + this.f38631b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f38630a + ",value=" + this.f38631b + "]";
    }
}
