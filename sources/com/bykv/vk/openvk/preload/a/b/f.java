package com.bykv.vk.openvk.preload.a.b;

import java.math.BigDecimal;

/* loaded from: classes2.dex */
public final class f extends Number {

    /* renamed from: a, reason: collision with root package name */
    private final String f20522a;

    public f(String str) {
        this.f20522a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f20522a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        String str = this.f20522a;
        String str2 = ((f) obj).f20522a;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f20522a);
    }

    public final int hashCode() {
        return this.f20522a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        try {
            try {
                return Integer.parseInt(this.f20522a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f20522a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f20522a).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        try {
            return Long.parseLong(this.f20522a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f20522a).longValue();
        }
    }

    public final String toString() {
        return this.f20522a;
    }
}
