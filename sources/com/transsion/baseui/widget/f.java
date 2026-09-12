package com.transsion.baseui.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.blankj.utilcode.util.y;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    private Context f43679b;

    /* renamed from: c, reason: collision with root package name */
    private View f43680c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f43682e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f43683f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f43684g;

    /* renamed from: h, reason: collision with root package name */
    private GestureDetector f43685h;

    /* renamed from: i, reason: collision with root package name */
    private a f43686i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f43687j;

    /* renamed from: k, reason: collision with root package name */
    private View f43688k;

    /* renamed from: a, reason: collision with root package name */
    private final String f43678a = f.class.getSimpleName();

    /* renamed from: d, reason: collision with root package name */
    private boolean f43681d = true;

    /* renamed from: l, reason: collision with root package name */
    private final GestureDetector.OnGestureListener f43689l = new c();

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b(float f11, float f12);

        void c(float f11, float f12);

        void d(float f11, float f12);

        void e();

        void onDoubleTap(MotionEvent motionEvent);

        void onLongPress(MotionEvent motionEvent);
    }

    /* loaded from: classes5.dex */
    public static final class b implements GestureDetector.OnDoubleTapListener {
        b() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            a aVar = f.this.f43686i;
            if (aVar == null) {
                return false;
            }
            aVar.onDoubleTap(e11);
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            a aVar = f.this.f43686i;
            if (aVar == null) {
                return false;
            }
            aVar.a();
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements GestureDetector.OnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private float f43691a;

        c() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            this.f43691a = e11.getX();
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent e22, float f11, float f12) {
            Intrinsics.h(e22, "e2");
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            a aVar = f.this.f43686i;
            if (aVar != null) {
                aVar.onLongPress(e11);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent e22, float f11, float f12) {
            Intrinsics.h(e22, "e2");
            if (!f.this.f43681d || motionEvent == null) {
                return false;
            }
            if (Math.abs(f11) <= Math.abs(f12)) {
                boolean unused = f.this.f43682e;
            } else if (!f.this.f43684g && !f.this.f43683f) {
                f.this.f43682e = true;
            }
            if (f.this.f43682e) {
                a aVar = f.this.f43686i;
                if (aVar != null) {
                    aVar.b(motionEvent.getX(), e22.getX());
                }
            } else if (f.this.f43687j) {
                f fVar = f.this;
                View view = fVar.f43688k;
                Intrinsics.e(view);
                if (fVar.p(view, (int) this.f43691a)) {
                    f.this.f43684g = true;
                    a aVar2 = f.this.f43686i;
                    if (aVar2 != null) {
                        aVar2.c(motionEvent.getY(), e22.getY());
                    }
                } else {
                    f fVar2 = f.this;
                    View view2 = fVar2.f43688k;
                    Intrinsics.e(view2);
                    if (fVar2.r(view2, (int) this.f43691a)) {
                        f.this.f43683f = true;
                        a aVar3 = f.this.f43686i;
                        if (aVar3 != null) {
                            aVar3.d(motionEvent.getY(), e22.getY());
                        }
                    }
                }
            } else if (f.this.o((int) this.f43691a)) {
                f.this.f43684g = true;
                a aVar4 = f.this.f43686i;
                if (aVar4 != null) {
                    aVar4.c(motionEvent.getY(), e22.getY());
                }
            } else if (f.this.q((int) this.f43691a)) {
                f.this.f43683f = true;
                a aVar5 = f.this.f43686i;
                if (aVar5 != null) {
                    aVar5.d(motionEvent.getY(), e22.getY());
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent e11) {
            Intrinsics.h(e11, "e");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            return false;
        }
    }

    public f(Context context, View view) {
        this.f43679b = context;
        this.f43680c = view;
        m();
    }

    private final void m() {
        this.f43685h = new GestureDetector(this.f43679b, this.f43689l);
        View view = this.f43680c;
        Intrinsics.e(view);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.baseui.widget.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean n11;
                n11 = f.n(f.this, view2, motionEvent);
                return n11;
            }
        });
        GestureDetector gestureDetector = this.f43685h;
        Intrinsics.e(gestureDetector);
        gestureDetector.setOnDoubleTapListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(f fVar, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            a aVar = fVar.f43686i;
            if (aVar != null) {
                aVar.e();
            }
            fVar.f43684g = false;
            fVar.f43683f = false;
            fVar.f43682e = false;
        }
        GestureDetector gestureDetector = fVar.f43685h;
        Intrinsics.e(gestureDetector);
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public final void l(boolean z10) {
        this.f43681d = z10;
    }

    public final boolean o(int i11) {
        return i11 < y.e() / 2;
    }

    public final boolean p(View view, int i11) {
        Intrinsics.h(view, "view");
        return i11 < view.getMeasuredWidth() / 2;
    }

    public final boolean q(int i11) {
        return i11 > y.e() / 2;
    }

    public final boolean r(View view, int i11) {
        Intrinsics.h(view, "view");
        return i11 > view.getMeasuredWidth() / 2;
    }

    public final void s(a aVar) {
        this.f43686i = aVar;
    }
}
