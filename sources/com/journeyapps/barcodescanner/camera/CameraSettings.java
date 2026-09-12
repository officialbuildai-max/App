package com.journeyapps.barcodescanner.camera;

/* loaded from: classes4.dex */
public class CameraSettings {

    /* renamed from: a, reason: collision with root package name */
    private int f34003a = -1;

    /* renamed from: b, reason: collision with root package name */
    private boolean f34004b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f34005c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f34006d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34007e = true;

    /* renamed from: f, reason: collision with root package name */
    private boolean f34008f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f34009g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f34010h = false;

    /* renamed from: i, reason: collision with root package name */
    private FocusMode f34011i = FocusMode.AUTO;

    /* loaded from: classes4.dex */
    public enum FocusMode {
        AUTO,
        CONTINUOUS,
        INFINITY,
        MACRO
    }

    public FocusMode a() {
        return this.f34011i;
    }

    public int b() {
        return this.f34003a;
    }

    public boolean c() {
        return this.f34007e;
    }

    public boolean d() {
        return this.f34010h;
    }

    public boolean e() {
        return this.f34005c;
    }

    public boolean f() {
        return this.f34009g;
    }

    public boolean g() {
        return this.f34006d;
    }

    public boolean h() {
        return this.f34004b;
    }

    public void i(int i11) {
        this.f34003a = i11;
    }
}
