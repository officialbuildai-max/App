package com.transsion.athena.aatnhe;

import android.text.TextUtils;
import java.util.Objects;

/* loaded from: classes5.dex */
public class athena {

    /* renamed from: a, reason: collision with root package name */
    public String f42592a;

    /* renamed from: b, reason: collision with root package name */
    public String f42593b;

    /* renamed from: c, reason: collision with root package name */
    public int f42594c;

    /* renamed from: d, reason: collision with root package name */
    public int f42595d;

    /* renamed from: e, reason: collision with root package name */
    public int f42596e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f42597f;

    public athena() {
    }

    public athena(String str, String str2, int i11, int i12, int i13, boolean z10) {
        this.f42592a = str;
        this.f42593b = str2;
        this.f42594c = i11;
        this.f42595d = i12;
        this.f42596e = i13;
        this.f42597f = z10;
    }

    public String a() {
        return this.f42592a + "-" + this.f42593b + "-" + this.f42595d + "-" + this.f42594c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof athena) {
            return TextUtils.equals(a(), ((athena) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f42592a, this.f42593b, Integer.valueOf(this.f42594c), Integer.valueOf(this.f42595d), Integer.valueOf(this.f42596e), Boolean.valueOf(this.f42597f));
    }
}
