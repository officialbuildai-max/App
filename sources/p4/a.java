package p4;

import android.graphics.PointF;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final PointF f72405a;

    /* renamed from: b, reason: collision with root package name */
    private final PointF f72406b;

    /* renamed from: c, reason: collision with root package name */
    private final PointF f72407c;

    public a() {
        this.f72405a = new PointF();
        this.f72406b = new PointF();
        this.f72407c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f72405a = pointF;
        this.f72406b = pointF2;
        this.f72407c = pointF3;
    }

    public PointF a() {
        return this.f72405a;
    }

    public PointF b() {
        return this.f72406b;
    }

    public PointF c() {
        return this.f72407c;
    }

    public void d(float f11, float f12) {
        this.f72405a.set(f11, f12);
    }

    public void e(float f11, float f12) {
        this.f72406b.set(f11, f12);
    }

    public void f(float f11, float f12) {
        this.f72407c.set(f11, f12);
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.f72407c.x), Float.valueOf(this.f72407c.y), Float.valueOf(this.f72405a.x), Float.valueOf(this.f72405a.y), Float.valueOf(this.f72406b.x), Float.valueOf(this.f72406b.y));
    }
}
