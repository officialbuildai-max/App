package androidx.media3.exoplayer.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.media3.exoplayer.video.spherical.b;

/* loaded from: classes2.dex */
final class h extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, b.a {

    /* renamed from: c, reason: collision with root package name */
    private final a f13381c;

    /* renamed from: d, reason: collision with root package name */
    private final float f13382d;

    /* renamed from: e, reason: collision with root package name */
    private final GestureDetector f13383e;

    /* renamed from: a, reason: collision with root package name */
    private final PointF f13379a = new PointF();

    /* renamed from: b, reason: collision with root package name */
    private final PointF f13380b = new PointF();

    /* renamed from: f, reason: collision with root package name */
    private volatile float f13384f = 3.1415927f;

    /* loaded from: classes2.dex */
    public interface a {
        void b(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public h(Context context, a aVar, float f11) {
        this.f13381c = aVar;
        this.f13382d = f11;
        this.f13383e = new GestureDetector(context, this);
    }

    @Override // androidx.media3.exoplayer.video.spherical.b.a
    public void a(float[] fArr, float f11) {
        this.f13384f = -f11;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f13379a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        float x10 = (motionEvent2.getX() - this.f13379a.x) / this.f13382d;
        float y10 = motionEvent2.getY();
        PointF pointF = this.f13379a;
        float f13 = (y10 - pointF.y) / this.f13382d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d11 = this.f13384f;
        float cos = (float) Math.cos(d11);
        float sin = (float) Math.sin(d11);
        PointF pointF2 = this.f13380b;
        pointF2.x -= (cos * x10) - (sin * f13);
        float f14 = pointF2.y + (sin * x10) + (cos * f13);
        pointF2.y = f14;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f14));
        this.f13381c.b(this.f13380b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f13381c.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f13383e.onTouchEvent(motionEvent);
    }
}
