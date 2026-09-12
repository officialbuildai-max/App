package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.video.spherical.b;

/* loaded from: classes3.dex */
final class h extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, b.a {

    /* renamed from: c, reason: collision with root package name */
    private final a f28047c;

    /* renamed from: d, reason: collision with root package name */
    private final float f28048d;

    /* renamed from: e, reason: collision with root package name */
    private final GestureDetector f28049e;

    /* renamed from: a, reason: collision with root package name */
    private final PointF f28045a = new PointF();

    /* renamed from: b, reason: collision with root package name */
    private final PointF f28046b = new PointF();

    /* renamed from: f, reason: collision with root package name */
    private volatile float f28050f = 3.1415927f;

    /* loaded from: classes3.dex */
    public interface a {
        void b(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public h(Context context, a aVar, float f11) {
        this.f28047c = aVar;
        this.f28048d = f11;
        this.f28049e = new GestureDetector(context, this);
    }

    @Override // com.google.android.exoplayer2.video.spherical.b.a
    public void a(float[] fArr, float f11) {
        this.f28050f = -f11;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f28045a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        float x10 = (motionEvent2.getX() - this.f28045a.x) / this.f28048d;
        float y10 = motionEvent2.getY();
        PointF pointF = this.f28045a;
        float f13 = (y10 - pointF.y) / this.f28048d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d11 = this.f28050f;
        float cos = (float) Math.cos(d11);
        float sin = (float) Math.sin(d11);
        PointF pointF2 = this.f28046b;
        pointF2.x -= (cos * x10) - (sin * f13);
        float f14 = pointF2.y + (sin * x10) + (cos * f13);
        pointF2.y = f14;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f14));
        this.f28047c.b(this.f28046b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f28047c.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f28049e.onTouchEvent(motionEvent);
    }
}
