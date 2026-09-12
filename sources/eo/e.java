package eo;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.blankj.utilcode.util.y;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private Context f62055a;

    /* renamed from: b, reason: collision with root package name */
    private View f62056b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f62058d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f62059e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f62060f;

    /* renamed from: g, reason: collision with root package name */
    private GestureDetector f62061g;

    /* renamed from: h, reason: collision with root package name */
    private a f62062h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f62063i;

    /* renamed from: j, reason: collision with root package name */
    private View f62064j;

    /* renamed from: c, reason: collision with root package name */
    private boolean f62057c = true;

    /* renamed from: k, reason: collision with root package name */
    private final GestureDetector.OnGestureListener f62065k = new c();

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
            a aVar = e.this.f62062h;
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
            a aVar = e.this.f62062h;
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
        private float f62067a;

        c() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            this.f62067a = e11.getX();
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
            a aVar = e.this.f62062h;
            if (aVar != null) {
                aVar.onLongPress(e11);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent e22, float f11, float f12) {
            Intrinsics.h(e22, "e2");
            if (!e.this.f62057c || motionEvent == null) {
                return false;
            }
            if (Math.abs(f11) <= Math.abs(f12)) {
                boolean unused = e.this.f62058d;
            } else if (!e.this.f62060f && !e.this.f62059e) {
                e.this.f62058d = true;
            }
            if (e.this.f62058d) {
                a aVar = e.this.f62062h;
                if (aVar != null) {
                    aVar.b(motionEvent.getX(), e22.getX());
                }
            } else if (e.this.f62063i) {
                e eVar = e.this;
                View view = eVar.f62064j;
                Intrinsics.e(view);
                if (eVar.p(view, (int) this.f62067a)) {
                    e.this.f62060f = true;
                    a aVar2 = e.this.f62062h;
                    if (aVar2 != null) {
                        aVar2.c(motionEvent.getY(), e22.getY());
                    }
                } else {
                    e eVar2 = e.this;
                    View view2 = eVar2.f62064j;
                    Intrinsics.e(view2);
                    if (eVar2.r(view2, (int) this.f62067a)) {
                        e.this.f62059e = true;
                        a aVar3 = e.this.f62062h;
                        if (aVar3 != null) {
                            aVar3.d(motionEvent.getY(), e22.getY());
                        }
                    }
                }
            } else if (e.this.o((int) this.f62067a)) {
                e.this.f62060f = true;
                a aVar4 = e.this.f62062h;
                if (aVar4 != null) {
                    aVar4.c(motionEvent.getY(), e22.getY());
                }
            } else if (e.this.q((int) this.f62067a)) {
                e.this.f62059e = true;
                a aVar5 = e.this.f62062h;
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
        this.f62055a = context;
        this.f62056b = view;
        m();
    }

    private final void m() {
        this.f62061g = new GestureDetector(this.f62055a, this.f62065k);
        View view = this.f62056b;
        Intrinsics.e(view);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: eo.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean n11;
                n11 = e.n(e.this, view2, motionEvent);
                return n11;
            }
        });
        GestureDetector gestureDetector = this.f62061g;
        Intrinsics.e(gestureDetector);
        gestureDetector.setOnDoubleTapListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(e eVar, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            a aVar = eVar.f62062h;
            if (aVar != null) {
                aVar.e();
            }
            eVar.f62060f = false;
            eVar.f62059e = false;
            eVar.f62058d = false;
        }
        GestureDetector gestureDetector = eVar.f62061g;
        Intrinsics.e(gestureDetector);
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public final void l(boolean z10) {
        this.f62057c = z10;
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
        this.f62062h = aVar;
    }
}
