package com.bykv.vk.openvk.preload.a;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public final class n extends i {

    /* renamed from: a, reason: collision with root package name */
    private final Object f20614a;

    public n(Boolean bool) {
        this.f20614a = com.bykv.vk.openvk.preload.falconx.a.a.a(bool);
    }

    public n(Number number) {
        this.f20614a = com.bykv.vk.openvk.preload.falconx.a.a.a(number);
    }

    public n(String str) {
        this.f20614a = com.bykv.vk.openvk.preload.falconx.a.a.a(str);
    }

    private static boolean a(n nVar) {
        Object obj = nVar.f20614a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final Number a() {
        Object obj = this.f20614a;
        return obj instanceof String ? new com.bykv.vk.openvk.preload.a.b.f((String) obj) : (Number) obj;
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final String b() {
        Object obj = this.f20614a;
        return obj instanceof Number ? a().toString() : obj instanceof Boolean ? ((Boolean) obj).toString() : (String) obj;
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final boolean c() {
        Object obj = this.f20614a;
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(b());
    }

    public final boolean d() {
        return this.f20614a instanceof Boolean;
    }

    public final boolean e() {
        return this.f20614a instanceof Number;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f20614a == null) {
            return nVar.f20614a == null;
        }
        if (a(this) && a(nVar)) {
            return a().longValue() == nVar.a().longValue();
        }
        Object obj2 = this.f20614a;
        if (!(obj2 instanceof Number) || !(nVar.f20614a instanceof Number)) {
            return obj2.equals(nVar.f20614a);
        }
        double doubleValue = a().doubleValue();
        double doubleValue2 = nVar.a().doubleValue();
        return doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2));
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (this.f20614a == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = a().longValue();
        } else {
            Object obj = this.f20614a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }
}
