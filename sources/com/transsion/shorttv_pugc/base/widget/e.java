package com.transsion.shorttv_pugc.base.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.blankj.utilcode.util.y;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    private Context f53909b;

    /* renamed from: c, reason: collision with root package name */
    private View f53910c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f53912e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f53913f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f53914g;

    /* renamed from: h, reason: collision with root package name */
    private GestureDetector f53915h;

    /* renamed from: i, reason: collision with root package name */
    private a f53916i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f53917j;

    /* renamed from: k, reason: collision with root package name */
    private View f53918k;

    /* renamed from: a, reason: collision with root package name */
    private final String f53908a = e.class.getSimpleName();

    /* renamed from: d, reason: collision with root package name */
    private boolean f53911d = true;

    /* renamed from: l, reason: collision with root package name */
    private final GestureDetector.OnGestureListener f53919l = new c();

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b(float f11, float f12);

        void c(float f11, float f12);

        void d(float f11, float f12);

        void e();

        void onDoubleTap(MotionEvent motionEvent);

        void onLongPress(MotionEvent motionEvent);
    }

    /* loaded from: classes6.dex */
    public static final class b implements GestureDetector.OnDoubleTapListener {
        b() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            a aVar = e.this.f53916i;
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
            a aVar = e.this.f53916i;
            if (aVar == null) {
                return false;
            }
            aVar.a();
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements GestureDetector.OnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private float f53921a;

        c() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            this.f53921a = e11.getX();
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
            a aVar = e.this.f53916i;
            if (aVar != null) {
                aVar.onLongPress(e11);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent e22, float f11, float f12) {
            Intrinsics.h(e22, "e2");
            if (!e.this.f53911d || motionEvent == null) {
                return false;
            }
            if (Math.abs(f11) <= Math.abs(f12)) {
                boolean unused = e.this.f53912e;
            } else if (!e.this.f53914g && !e.this.f53913f) {
                e.this.f53912e = true;
            }
            if (e.this.f53912e) {
                a aVar = e.this.f53916i;
                if (aVar != null) {
                    aVar.b(motionEvent.getX(), e22.getX());
                }
            } else if (e.this.f53917j) {
                e eVar = e.this;
                View view = eVar.f53918k;
                Intrinsics.e(view);
                if (eVar.o(view, (int) this.f53921a)) {
                    e.this.f53914g = true;
                    a aVar2 = e.this.f53916i;
                    if (aVar2 != null) {
                        aVar2.c(motionEvent.getY(), e22.getY());
                    }
                } else {
                    e eVar2 = e.this;
                    View view2 = eVar2.f53918k;
                    Intrinsics.e(view2);
                    if (eVar2.q(view2, (int) this.f53921a)) {
                        e.this.f53913f = true;
                        a aVar3 = e.this.f53916i;
                        if (aVar3 != null) {
                            aVar3.d(motionEvent.getY(), e22.getY());
                        }
                    }
                }
            } else if (e.this.n((int) this.f53921a)) {
                e.this.f53914g = true;
                a aVar4 = e.this.f53916i;
                if (aVar4 != null) {
                    aVar4.c(motionEvent.getY(), e22.getY());
                }
            } else if (e.this.p((int) this.f53921a)) {
                e.this.f53913f = true;
                a aVar5 = e.this.f53916i;
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

    public e(Context context, View view) {
        this.f53909b = context;
        this.f53910c = view;
        l();
    }

    private final void l() {
        this.f53915h = new GestureDetector(this.f53909b, this.f53919l);
        View view = this.f53910c;
        Intrinsics.e(view);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.shorttv_pugc.base.widget.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean m11;
                m11 = e.m(e.this, view2, motionEvent);
                return m11;
            }
        });
        GestureDetector gestureDetector = this.f53915h;
        Intrinsics.e(gestureDetector);
        gestureDetector.setOnDoubleTapListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(e eVar, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            a aVar = eVar.f53916i;
            if (aVar != null) {
                aVar.e();
            }
            eVar.f53914g = false;
            eVar.f53913f = false;
            eVar.f53912e = false;
        }
        GestureDetector gestureDetector = eVar.f53915h;
        Intrinsics.e(gestureDetector);
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public final boolean n(int i11) {
        return i11 < y.e() / 2;
    }

    public final boolean o(View view, int i11) {
        Intrinsics.h(view, "view");
        return i11 < view.getMeasuredWidth() / 2;
    }

    public final boolean p(int i11) {
        return i11 > y.e() / 2;
    }

    public final boolean q(View view, int i11) {
        Intrinsics.h(view, "view");
        return i11 > view.getMeasuredWidth() / 2;
    }

    public final void r(a aVar) {
        this.f53916i = aVar;
    }
}
