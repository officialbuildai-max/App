package rx;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import kotlin.jvm.internal.Intrinsics;
import rx.a;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f74863a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f74864b;

    /* renamed from: c, reason: collision with root package name */
    private final ScaleGestureDetector f74865c;

    /* renamed from: d, reason: collision with root package name */
    private final GestureDetector f74866d;

    /* renamed from: rx.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0940a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private float f74867a;

        /* renamed from: b, reason: collision with root package name */
        private float f74868b;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f74870d;

        C0940a(c cVar) {
            this.f74870d = cVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            this.f74867a = e11.getRawX();
            this.f74868b = e11.getRawY();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent e22, float f11, float f12) {
            Intrinsics.h(e22, "e2");
            if (a.this.f74863a) {
                return false;
            }
            this.f74870d.b(e22.getRawX() - this.f74867a, e22.getRawY() - this.f74868b);
            this.f74867a = e22.getRawX();
            this.f74868b = e22.getRawY();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            this.f74870d.a();
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements ScaleGestureDetector.OnScaleGestureListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f74871a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f74872b;

        b(c cVar, a aVar) {
            this.f74871a = cVar;
            this.f74872b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(a aVar) {
            aVar.f74863a = false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            Intrinsics.h(detector, "detector");
            this.f74871a.onScale(detector);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Intrinsics.h(detector, "detector");
            this.f74872b.f74863a = true;
            this.f74872b.f74864b.removeCallbacksAndMessages(null);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector detector) {
            Intrinsics.h(detector, "detector");
            this.f74872b.f74864b.removeCallbacksAndMessages(null);
            Handler handler = this.f74872b.f74864b;
            final a aVar = this.f74872b;
            handler.postDelayed(new Runnable() { // from class: rx.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.b(a.this);
                }
            }, 700L);
        }
    }

    public a(Context context, c videoFloatGestureListener) {
        Intrinsics.h(context, "context");
        Intrinsics.h(videoFloatGestureListener, "videoFloatGestureListener");
        this.f74864b = new Handler(Looper.getMainLooper());
        this.f74865c = new ScaleGestureDetector(context, new b(videoFloatGestureListener, this));
        this.f74866d = new GestureDetector(context, new C0940a(videoFloatGestureListener));
    }

    public final boolean d(MotionEvent ev2) {
        Intrinsics.h(ev2, "ev");
        return this.f74865c.onTouchEvent(ev2) || this.f74866d.onTouchEvent(ev2);
    }
}
