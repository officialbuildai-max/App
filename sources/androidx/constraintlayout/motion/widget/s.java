package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class s {

    /* renamed from: w, reason: collision with root package name */
    private static String f7569w = "ViewTransition";

    /* renamed from: a, reason: collision with root package name */
    private int f7570a;

    /* renamed from: e, reason: collision with root package name */
    int f7574e;

    /* renamed from: f, reason: collision with root package name */
    g f7575f;

    /* renamed from: g, reason: collision with root package name */
    b.a f7576g;

    /* renamed from: j, reason: collision with root package name */
    private int f7579j;

    /* renamed from: k, reason: collision with root package name */
    private String f7580k;

    /* renamed from: o, reason: collision with root package name */
    Context f7584o;

    /* renamed from: b, reason: collision with root package name */
    private int f7571b = -1;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7572c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f7573d = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f7577h = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f7578i = -1;

    /* renamed from: l, reason: collision with root package name */
    private int f7581l = 0;

    /* renamed from: m, reason: collision with root package name */
    private String f7582m = null;

    /* renamed from: n, reason: collision with root package name */
    private int f7583n = -1;

    /* renamed from: p, reason: collision with root package name */
    private int f7585p = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f7586q = -1;

    /* renamed from: r, reason: collision with root package name */
    private int f7587r = -1;

    /* renamed from: s, reason: collision with root package name */
    private int f7588s = -1;

    /* renamed from: t, reason: collision with root package name */
    private int f7589t = -1;

    /* renamed from: u, reason: collision with root package name */
    private int f7590u = -1;

    /* renamed from: v, reason: collision with root package name */
    private int f7591v = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.constraintlayout.core.motion.utils.c f7592a;

        a(s sVar, androidx.constraintlayout.core.motion.utils.c cVar) {
            this.f7592a = cVar;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            return (float) this.f7592a.a(f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f7593a;

        /* renamed from: b, reason: collision with root package name */
        private final int f7594b;

        /* renamed from: c, reason: collision with root package name */
        long f7595c;

        /* renamed from: d, reason: collision with root package name */
        m f7596d;

        /* renamed from: e, reason: collision with root package name */
        int f7597e;

        /* renamed from: f, reason: collision with root package name */
        int f7598f;

        /* renamed from: h, reason: collision with root package name */
        t f7600h;

        /* renamed from: i, reason: collision with root package name */
        Interpolator f7601i;

        /* renamed from: k, reason: collision with root package name */
        float f7603k;

        /* renamed from: l, reason: collision with root package name */
        float f7604l;

        /* renamed from: m, reason: collision with root package name */
        long f7605m;

        /* renamed from: o, reason: collision with root package name */
        boolean f7607o;

        /* renamed from: g, reason: collision with root package name */
        androidx.constraintlayout.core.motion.utils.d f7599g = new androidx.constraintlayout.core.motion.utils.d();

        /* renamed from: j, reason: collision with root package name */
        boolean f7602j = false;

        /* renamed from: n, reason: collision with root package name */
        Rect f7606n = new Rect();

        b(t tVar, m mVar, int i11, int i12, int i13, Interpolator interpolator, int i14, int i15) {
            this.f7607o = false;
            this.f7600h = tVar;
            this.f7596d = mVar;
            this.f7597e = i11;
            this.f7598f = i12;
            long nanoTime = System.nanoTime();
            this.f7595c = nanoTime;
            this.f7605m = nanoTime;
            this.f7600h.b(this);
            this.f7601i = interpolator;
            this.f7593a = i14;
            this.f7594b = i15;
            if (i13 == 3) {
                this.f7607o = true;
            }
            this.f7604l = i11 == 0 ? Float.MAX_VALUE : 1.0f / i11;
            a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            if (this.f7602j) {
                c();
            } else {
                b();
            }
        }

        void b() {
            long nanoTime = System.nanoTime();
            long j11 = nanoTime - this.f7605m;
            this.f7605m = nanoTime;
            float f11 = this.f7603k + (((float) (j11 * 1.0E-6d)) * this.f7604l);
            this.f7603k = f11;
            if (f11 >= 1.0f) {
                this.f7603k = 1.0f;
            }
            Interpolator interpolator = this.f7601i;
            float interpolation = interpolator == null ? this.f7603k : interpolator.getInterpolation(this.f7603k);
            m mVar = this.f7596d;
            boolean x10 = mVar.x(mVar.f7452b, interpolation, nanoTime, this.f7599g);
            if (this.f7603k >= 1.0f) {
                if (this.f7593a != -1) {
                    this.f7596d.v().setTag(this.f7593a, Long.valueOf(System.nanoTime()));
                }
                if (this.f7594b != -1) {
                    this.f7596d.v().setTag(this.f7594b, null);
                }
                if (!this.f7607o) {
                    this.f7600h.i(this);
                }
            }
            if (this.f7603k < 1.0f || x10) {
                this.f7600h.f();
            }
        }

        void c() {
            long nanoTime = System.nanoTime();
            long j11 = nanoTime - this.f7605m;
            this.f7605m = nanoTime;
            float f11 = this.f7603k - (((float) (j11 * 1.0E-6d)) * this.f7604l);
            this.f7603k = f11;
            if (f11 < 0.0f) {
                this.f7603k = 0.0f;
            }
            Interpolator interpolator = this.f7601i;
            float interpolation = interpolator == null ? this.f7603k : interpolator.getInterpolation(this.f7603k);
            m mVar = this.f7596d;
            boolean x10 = mVar.x(mVar.f7452b, interpolation, nanoTime, this.f7599g);
            if (this.f7603k <= 0.0f) {
                if (this.f7593a != -1) {
                    this.f7596d.v().setTag(this.f7593a, Long.valueOf(System.nanoTime()));
                }
                if (this.f7594b != -1) {
                    this.f7596d.v().setTag(this.f7594b, null);
                }
                this.f7600h.i(this);
            }
            if (this.f7603k > 0.0f || x10) {
                this.f7600h.f();
            }
        }

        public void d(int i11, float f11, float f12) {
            if (i11 == 1) {
                if (this.f7602j) {
                    return;
                }
                e(true);
            } else {
                if (i11 != 2) {
                    return;
                }
                this.f7596d.v().getHitRect(this.f7606n);
                if (this.f7606n.contains((int) f11, (int) f12) || this.f7602j) {
                    return;
                }
                e(true);
            }
        }

        void e(boolean z10) {
            int i11;
            this.f7602j = z10;
            if (z10 && (i11 = this.f7598f) != -1) {
                this.f7604l = i11 == 0 ? Float.MAX_VALUE : 1.0f / i11;
            }
            this.f7600h.f();
            this.f7605m = System.nanoTime();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0051. Please report as an issue. */
    public s(Context context, XmlPullParser xmlPullParser) {
        char c11;
        this.f7584o = context;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case -1962203927:
                            if (name.equals("ConstraintOverride")) {
                                c11 = 2;
                                break;
                            }
                            c11 = 65535;
                            break;
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                c11 = 1;
                                break;
                            }
                            c11 = 65535;
                            break;
                        case 61998586:
                            if (name.equals("ViewTransition")) {
                                c11 = 0;
                                break;
                            }
                            c11 = 65535;
                            break;
                        case 366511058:
                            if (name.equals("CustomMethod")) {
                                c11 = 4;
                                break;
                            }
                            c11 = 65535;
                            break;
                        case 1791837707:
                            if (name.equals("CustomAttribute")) {
                                c11 = 3;
                                break;
                            }
                            c11 = 65535;
                            break;
                        default:
                            c11 = 65535;
                            break;
                    }
                    if (c11 == 0) {
                        m(context, xmlPullParser);
                    } else if (c11 == 1) {
                        this.f7575f = new g(context, xmlPullParser);
                    } else if (c11 == 2) {
                        this.f7576g = androidx.constraintlayout.widget.b.m(context, xmlPullParser);
                    } else if (c11 == 3 || c11 == 4) {
                        ConstraintAttribute.i(context, xmlPullParser, this.f7576g.f7844g);
                    } else {
                        Log.e(f7569w, androidx.constraintlayout.motion.widget.a.a() + " unknown tag " + name);
                        Log.e(f7569w, ".xml:" + xmlPullParser.getLineNumber());
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("ViewTransition".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View[] viewArr) {
        if (this.f7585p != -1) {
            for (View view : viewArr) {
                view.setTag(this.f7585p, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.f7586q != -1) {
            for (View view2 : viewArr) {
                view2.setTag(this.f7586q, null);
            }
        }
    }

    private void m(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.ViewTransition_android_id) {
                this.f7570a = obtainStyledAttributes.getResourceId(index, this.f7570a);
            } else if (index == R$styleable.ViewTransition_motionTarget) {
                if (MotionLayout.IS_IN_EDIT_MODE) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.f7579j);
                    this.f7579j = resourceId;
                    if (resourceId == -1) {
                        this.f7580k = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.f7580k = obtainStyledAttributes.getString(index);
                } else {
                    this.f7579j = obtainStyledAttributes.getResourceId(index, this.f7579j);
                }
            } else if (index == R$styleable.ViewTransition_onStateTransition) {
                this.f7571b = obtainStyledAttributes.getInt(index, this.f7571b);
            } else if (index == R$styleable.ViewTransition_transitionDisable) {
                this.f7572c = obtainStyledAttributes.getBoolean(index, this.f7572c);
            } else if (index == R$styleable.ViewTransition_pathMotionArc) {
                this.f7573d = obtainStyledAttributes.getInt(index, this.f7573d);
            } else if (index == R$styleable.ViewTransition_duration) {
                this.f7577h = obtainStyledAttributes.getInt(index, this.f7577h);
            } else if (index == R$styleable.ViewTransition_upDuration) {
                this.f7578i = obtainStyledAttributes.getInt(index, this.f7578i);
            } else if (index == R$styleable.ViewTransition_viewTransitionMode) {
                this.f7574e = obtainStyledAttributes.getInt(index, this.f7574e);
            } else if (index == R$styleable.ViewTransition_motionInterpolator) {
                int i12 = obtainStyledAttributes.peekValue(index).type;
                if (i12 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.f7583n = resourceId2;
                    if (resourceId2 != -1) {
                        this.f7581l = -2;
                    }
                } else if (i12 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f7582m = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.f7581l = -1;
                    } else {
                        this.f7583n = obtainStyledAttributes.getResourceId(index, -1);
                        this.f7581l = -2;
                    }
                } else {
                    this.f7581l = obtainStyledAttributes.getInteger(index, this.f7581l);
                }
            } else if (index == R$styleable.ViewTransition_setsTag) {
                this.f7585p = obtainStyledAttributes.getResourceId(index, this.f7585p);
            } else if (index == R$styleable.ViewTransition_clearsTag) {
                this.f7586q = obtainStyledAttributes.getResourceId(index, this.f7586q);
            } else if (index == R$styleable.ViewTransition_ifTagSet) {
                this.f7587r = obtainStyledAttributes.getResourceId(index, this.f7587r);
            } else if (index == R$styleable.ViewTransition_ifTagNotSet) {
                this.f7588s = obtainStyledAttributes.getResourceId(index, this.f7588s);
            } else if (index == R$styleable.ViewTransition_SharedValueId) {
                this.f7590u = obtainStyledAttributes.getResourceId(index, this.f7590u);
            } else if (index == R$styleable.ViewTransition_SharedValue) {
                this.f7589t = obtainStyledAttributes.getInteger(index, this.f7589t);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void p(p.b bVar, View view) {
        int i11 = this.f7577h;
        if (i11 != -1) {
            bVar.E(i11);
        }
        bVar.I(this.f7573d);
        bVar.G(this.f7581l, this.f7582m, this.f7583n);
        int id2 = view.getId();
        g gVar = this.f7575f;
        if (gVar != null) {
            ArrayList d11 = gVar.d(-1);
            g gVar2 = new g();
            Iterator it = d11.iterator();
            while (it.hasNext()) {
                gVar2.c(((d) it.next()).clone().i(id2));
            }
            bVar.t(gVar2);
        }
    }

    void b(t tVar, MotionLayout motionLayout, View view) {
        m mVar = new m(view);
        mVar.B(view);
        this.f7575f.a(mVar);
        mVar.I(motionLayout.getWidth(), motionLayout.getHeight(), this.f7577h, System.nanoTime());
        new b(tVar, mVar, this.f7577h, this.f7578i, this.f7571b, f(motionLayout.getContext()), this.f7585p, this.f7586q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(t tVar, MotionLayout motionLayout, int i11, androidx.constraintlayout.widget.b bVar, final View... viewArr) {
        if (this.f7572c) {
            return;
        }
        int i12 = this.f7574e;
        if (i12 == 2) {
            b(tVar, motionLayout, viewArr[0]);
            return;
        }
        if (i12 == 1) {
            for (int i13 : motionLayout.getConstraintSetIds()) {
                if (i13 != i11) {
                    androidx.constraintlayout.widget.b constraintSet = motionLayout.getConstraintSet(i13);
                    for (View view : viewArr) {
                        b.a A = constraintSet.A(view.getId());
                        b.a aVar = this.f7576g;
                        if (aVar != null) {
                            aVar.d(A);
                            A.f7844g.putAll(this.f7576g.f7844g);
                        }
                    }
                }
            }
        }
        androidx.constraintlayout.widget.b bVar2 = new androidx.constraintlayout.widget.b();
        bVar2.r(bVar);
        for (View view2 : viewArr) {
            b.a A2 = bVar2.A(view2.getId());
            b.a aVar2 = this.f7576g;
            if (aVar2 != null) {
                aVar2.d(A2);
                A2.f7844g.putAll(this.f7576g.f7844g);
            }
        }
        motionLayout.updateState(i11, bVar2);
        motionLayout.updateState(R$id.view_transition, bVar);
        motionLayout.setState(R$id.view_transition, -1, -1);
        p.b bVar3 = new p.b(-1, motionLayout.f7221a, R$id.view_transition, i11);
        for (View view3 : viewArr) {
            p(bVar3, view3);
        }
        motionLayout.setTransition(bVar3);
        motionLayout.transitionToEnd(new Runnable() { // from class: androidx.constraintlayout.motion.widget.r
            @Override // java.lang.Runnable
            public final void run() {
                s.this.k(viewArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(View view) {
        int i11 = this.f7587r;
        boolean z10 = i11 == -1 || view.getTag(i11) != null;
        int i12 = this.f7588s;
        return z10 && (i12 == -1 || view.getTag(i12) == null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f7570a;
    }

    Interpolator f(Context context) {
        int i11 = this.f7581l;
        if (i11 == -2) {
            return AnimationUtils.loadInterpolator(context, this.f7583n);
        }
        if (i11 == -1) {
            return new a(this, androidx.constraintlayout.core.motion.utils.c.c(this.f7582m));
        }
        if (i11 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i11 == 1) {
            return new AccelerateInterpolator();
        }
        if (i11 == 2) {
            return new DecelerateInterpolator();
        }
        if (i11 == 4) {
            return new BounceInterpolator();
        }
        if (i11 == 5) {
            return new OvershootInterpolator();
        }
        if (i11 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public int g() {
        return this.f7589t;
    }

    public int h() {
        return this.f7590u;
    }

    public int i() {
        return this.f7571b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return !this.f7572c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.f7579j == -1 && this.f7580k == null) || !d(view)) {
            return false;
        }
        if (view.getId() == this.f7579j) {
            return true;
        }
        return this.f7580k != null && (view.getLayoutParams() instanceof ConstraintLayout.b) && (str = ((ConstraintLayout.b) view.getLayoutParams()).f7742c0) != null && str.matches(this.f7580k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(boolean z10) {
        this.f7572c = !z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(int i11) {
        int i12 = this.f7571b;
        return i12 == 1 ? i11 == 0 : i12 == 2 ? i11 == 1 : i12 == 3 && i11 == 0;
    }

    public String toString() {
        return "ViewTransition(" + androidx.constraintlayout.motion.widget.a.c(this.f7584o, this.f7570a) + ")";
    }
}
