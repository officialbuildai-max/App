package com.google.firebase.remoteconfig.internal;

/* loaded from: classes4.dex */
public class t implements yc.k {

    /* renamed from: a, reason: collision with root package name */
    private final String f32625a;

    /* renamed from: b, reason: collision with root package name */
    private final int f32626b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(String str, int i11) {
        this.f32625a = str;
        this.f32626b = i11;
    }

    private String f() {
        return b().trim();
    }

    private void g() {
        if (this.f32625a == null) {
            throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        }
    }

    @Override // yc.k
    public int a() {
        return this.f32626b;
    }

    @Override // yc.k
    public String b() {
        if (this.f32626b == 0) {
            return "";
        }
        g();
        return this.f32625a;
    }

    @Override // yc.k
    public long c() {
        if (this.f32626b == 0) {
            return 0L;
        }
        String f11 = f();
        try {
            return Long.valueOf(f11).longValue();
        } catch (NumberFormatException e11) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", f11, "long"), e11);
        }
    }

    @Override // yc.k
    public double d() {
        if (this.f32626b == 0) {
            return 0.0d;
        }
        String f11 = f();
        try {
            return Double.valueOf(f11).doubleValue();
        } catch (NumberFormatException e11) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", f11, "double"), e11);
        }
    }

    @Override // yc.k
    public boolean e() {
        if (this.f32626b == 0) {
            return false;
        }
        String f11 = f();
        if (m.f32585f.matcher(f11).matches()) {
            return true;
        }
        if (m.f32586g.matcher(f11).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", f11, "boolean"));
    }
}
