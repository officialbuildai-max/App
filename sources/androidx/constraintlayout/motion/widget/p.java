package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final MotionLayout f7498a;

    /* renamed from: n, reason: collision with root package name */
    private MotionEvent f7511n;

    /* renamed from: q, reason: collision with root package name */
    private MotionLayout.e f7514q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f7515r;

    /* renamed from: s, reason: collision with root package name */
    final t f7516s;

    /* renamed from: t, reason: collision with root package name */
    float f7517t;

    /* renamed from: u, reason: collision with root package name */
    float f7518u;

    /* renamed from: b, reason: collision with root package name */
    androidx.constraintlayout.widget.e f7499b = null;

    /* renamed from: c, reason: collision with root package name */
    b f7500c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7501d = false;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList f7502e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private b f7503f = null;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f7504g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private SparseArray f7505h = new SparseArray();

    /* renamed from: i, reason: collision with root package name */
    private HashMap f7506i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private SparseIntArray f7507j = new SparseIntArray();

    /* renamed from: k, reason: collision with root package name */
    private boolean f7508k = false;

    /* renamed from: l, reason: collision with root package name */
    private int f7509l = 400;

    /* renamed from: m, reason: collision with root package name */
    private int f7510m = 0;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7512o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f7513p = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.constraintlayout.core.motion.utils.c f7519a;

        a(p pVar, androidx.constraintlayout.core.motion.utils.c cVar) {
            this.f7519a = cVar;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            return (float) this.f7519a.a(f11);
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f7520a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f7521b;

        /* renamed from: c, reason: collision with root package name */
        private int f7522c;

        /* renamed from: d, reason: collision with root package name */
        private int f7523d;

        /* renamed from: e, reason: collision with root package name */
        private int f7524e;

        /* renamed from: f, reason: collision with root package name */
        private String f7525f;

        /* renamed from: g, reason: collision with root package name */
        private int f7526g;

        /* renamed from: h, reason: collision with root package name */
        private int f7527h;

        /* renamed from: i, reason: collision with root package name */
        private float f7528i;

        /* renamed from: j, reason: collision with root package name */
        private final p f7529j;

        /* renamed from: k, reason: collision with root package name */
        private ArrayList f7530k;

        /* renamed from: l, reason: collision with root package name */
        private q f7531l;

        /* renamed from: m, reason: collision with root package name */
        private ArrayList f7532m;

        /* renamed from: n, reason: collision with root package name */
        private int f7533n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f7534o;

        /* renamed from: p, reason: collision with root package name */
        private int f7535p;

        /* renamed from: q, reason: collision with root package name */
        private int f7536q;

        /* renamed from: r, reason: collision with root package name */
        private int f7537r;

        /* loaded from: classes.dex */
        public static class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private final b f7538a;

            /* renamed from: b, reason: collision with root package name */
            int f7539b;

            /* renamed from: c, reason: collision with root package name */
            int f7540c;

            public a(Context context, b bVar, XmlPullParser xmlPullParser) {
                this.f7539b = -1;
                this.f7540c = 17;
                this.f7538a = bVar;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i11 = 0; i11 < indexCount; i11++) {
                    int index = obtainStyledAttributes.getIndex(i11);
                    if (index == R$styleable.OnClick_targetId) {
                        this.f7539b = obtainStyledAttributes.getResourceId(index, this.f7539b);
                    } else if (index == R$styleable.OnClick_clickAction) {
                        this.f7540c = obtainStyledAttributes.getInt(index, this.f7540c);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v4, types: [android.view.View] */
            public void a(MotionLayout motionLayout, int i11, b bVar) {
                int i12 = this.f7539b;
                MotionLayout motionLayout2 = motionLayout;
                if (i12 != -1) {
                    motionLayout2 = motionLayout.findViewById(i12);
                }
                if (motionLayout2 == null) {
                    Log.e("MotionScene", "OnClick could not find id " + this.f7539b);
                    return;
                }
                int i13 = bVar.f7523d;
                int i14 = bVar.f7522c;
                if (i13 == -1) {
                    motionLayout2.setOnClickListener(this);
                    return;
                }
                int i15 = this.f7540c;
                boolean z10 = false;
                boolean z11 = ((i15 & 1) != 0 && i11 == i13) | ((i15 & 1) != 0 && i11 == i13) | ((i15 & 256) != 0 && i11 == i13) | ((i15 & 16) != 0 && i11 == i14);
                if ((i15 & 4096) != 0 && i11 == i14) {
                    z10 = true;
                }
                if (z11 || z10) {
                    motionLayout2.setOnClickListener(this);
                }
            }

            boolean b(b bVar, MotionLayout motionLayout) {
                b bVar2 = this.f7538a;
                if (bVar2 == bVar) {
                    return true;
                }
                int i11 = bVar2.f7522c;
                int i12 = this.f7538a.f7523d;
                if (i12 == -1) {
                    return motionLayout.f7231f != i11;
                }
                int i13 = motionLayout.f7231f;
                return i13 == i12 || i13 == i11;
            }

            public void c(MotionLayout motionLayout) {
                int i11 = this.f7539b;
                if (i11 == -1) {
                    return;
                }
                View findViewById = motionLayout.findViewById(i11);
                if (findViewById != null) {
                    findViewById.setOnClickListener(null);
                    return;
                }
                Log.e("MotionScene", " (*)  could not find id " + this.f7539b);
            }

            /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
            /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onClick(android.view.View r8) {
                /*
                    Method dump skipped, instructions count: 228
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.p.b.a.onClick(android.view.View):void");
            }
        }

        public b(int i11, p pVar, int i12, int i13) {
            this.f7520a = -1;
            this.f7521b = false;
            this.f7522c = -1;
            this.f7523d = -1;
            this.f7524e = 0;
            this.f7525f = null;
            this.f7526g = -1;
            this.f7527h = 400;
            this.f7528i = 0.0f;
            this.f7530k = new ArrayList();
            this.f7531l = null;
            this.f7532m = new ArrayList();
            this.f7533n = 0;
            this.f7534o = false;
            this.f7535p = -1;
            this.f7536q = 0;
            this.f7537r = 0;
            this.f7520a = i11;
            this.f7529j = pVar;
            this.f7523d = i12;
            this.f7522c = i13;
            this.f7527h = pVar.f7509l;
            this.f7536q = pVar.f7510m;
        }

        b(p pVar, Context context, XmlPullParser xmlPullParser) {
            this.f7520a = -1;
            this.f7521b = false;
            this.f7522c = -1;
            this.f7523d = -1;
            this.f7524e = 0;
            this.f7525f = null;
            this.f7526g = -1;
            this.f7527h = 400;
            this.f7528i = 0.0f;
            this.f7530k = new ArrayList();
            this.f7531l = null;
            this.f7532m = new ArrayList();
            this.f7533n = 0;
            this.f7534o = false;
            this.f7535p = -1;
            this.f7536q = 0;
            this.f7537r = 0;
            this.f7527h = pVar.f7509l;
            this.f7536q = pVar.f7510m;
            this.f7529j = pVar;
            w(pVar, context, Xml.asAttributeSet(xmlPullParser));
        }

        b(p pVar, b bVar) {
            this.f7520a = -1;
            this.f7521b = false;
            this.f7522c = -1;
            this.f7523d = -1;
            this.f7524e = 0;
            this.f7525f = null;
            this.f7526g = -1;
            this.f7527h = 400;
            this.f7528i = 0.0f;
            this.f7530k = new ArrayList();
            this.f7531l = null;
            this.f7532m = new ArrayList();
            this.f7533n = 0;
            this.f7534o = false;
            this.f7535p = -1;
            this.f7536q = 0;
            this.f7537r = 0;
            this.f7529j = pVar;
            this.f7527h = pVar.f7509l;
            if (bVar != null) {
                this.f7535p = bVar.f7535p;
                this.f7524e = bVar.f7524e;
                this.f7525f = bVar.f7525f;
                this.f7526g = bVar.f7526g;
                this.f7527h = bVar.f7527h;
                this.f7530k = bVar.f7530k;
                this.f7528i = bVar.f7528i;
                this.f7536q = bVar.f7536q;
            }
        }

        private void v(p pVar, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                if (index == R$styleable.Transition_constraintSetEnd) {
                    this.f7522c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f7522c);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        bVar.H(context, this.f7522c);
                        pVar.f7505h.append(this.f7522c, bVar);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.f7522c = pVar.O(context, this.f7522c);
                    }
                } else if (index == R$styleable.Transition_constraintSetStart) {
                    this.f7523d = typedArray.getResourceId(index, this.f7523d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.f7523d);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName2)) {
                        androidx.constraintlayout.widget.b bVar2 = new androidx.constraintlayout.widget.b();
                        bVar2.H(context, this.f7523d);
                        pVar.f7505h.append(this.f7523d, bVar2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.f7523d = pVar.O(context, this.f7523d);
                    }
                } else if (index == R$styleable.Transition_motionInterpolator) {
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.f7526g = resourceId;
                        if (resourceId != -1) {
                            this.f7524e = -2;
                        }
                    } else if (i12 == 3) {
                        String string = typedArray.getString(index);
                        this.f7525f = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.f7526g = typedArray.getResourceId(index, -1);
                                this.f7524e = -2;
                            } else {
                                this.f7524e = -1;
                            }
                        }
                    } else {
                        this.f7524e = typedArray.getInteger(index, this.f7524e);
                    }
                } else if (index == R$styleable.Transition_duration) {
                    int i13 = typedArray.getInt(index, this.f7527h);
                    this.f7527h = i13;
                    if (i13 < 8) {
                        this.f7527h = 8;
                    }
                } else if (index == R$styleable.Transition_staggered) {
                    this.f7528i = typedArray.getFloat(index, this.f7528i);
                } else if (index == R$styleable.Transition_autoTransition) {
                    this.f7533n = typedArray.getInteger(index, this.f7533n);
                } else if (index == R$styleable.Transition_android_id) {
                    this.f7520a = typedArray.getResourceId(index, this.f7520a);
                } else if (index == R$styleable.Transition_transitionDisable) {
                    this.f7534o = typedArray.getBoolean(index, this.f7534o);
                } else if (index == R$styleable.Transition_pathMotionArc) {
                    this.f7535p = typedArray.getInteger(index, -1);
                } else if (index == R$styleable.Transition_layoutDuringTransition) {
                    this.f7536q = typedArray.getInteger(index, 0);
                } else if (index == R$styleable.Transition_transitionFlags) {
                    this.f7537r = typedArray.getInteger(index, 0);
                }
            }
            if (this.f7523d == -1) {
                this.f7521b = true;
            }
        }

        private void w(p pVar, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transition);
            v(pVar, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public int A() {
            return this.f7523d;
        }

        public q B() {
            return this.f7531l;
        }

        public boolean C() {
            return !this.f7534o;
        }

        public boolean D(int i11) {
            return (i11 & this.f7537r) != 0;
        }

        public void E(int i11) {
            this.f7527h = Math.max(i11, 8);
        }

        public void F(boolean z10) {
            this.f7534o = !z10;
        }

        public void G(int i11, String str, int i12) {
            this.f7524e = i11;
            this.f7525f = str;
            this.f7526g = i12;
        }

        public void H(int i11) {
            q B = B();
            if (B != null) {
                B.y(i11);
            }
        }

        public void I(int i11) {
            this.f7535p = i11;
        }

        public void t(g gVar) {
            this.f7530k.add(gVar);
        }

        public void u(Context context, XmlPullParser xmlPullParser) {
            this.f7532m.add(new a(context, this, xmlPullParser));
        }

        public int x() {
            return this.f7533n;
        }

        public int y() {
            return this.f7522c;
        }

        public int z() {
            return this.f7536q;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context, MotionLayout motionLayout, int i11) {
        this.f7498a = motionLayout;
        this.f7516s = new t(motionLayout);
        M(context, i11);
        this.f7505h.put(R$id.motion_base, new androidx.constraintlayout.widget.b());
        this.f7506i.put("motion_base", Integer.valueOf(R$id.motion_base));
    }

    private boolean J(int i11) {
        int i12 = this.f7507j.get(i11);
        int size = this.f7507j.size();
        while (i12 > 0) {
            if (i12 == i11) {
                return true;
            }
            int i13 = size - 1;
            if (size < 0) {
                return true;
            }
            i12 = this.f7507j.get(i12);
            size = i13;
        }
        return false;
    }

    private boolean K() {
        return this.f7514q != null;
    }

    private void M(Context context, int i11) {
        XmlResourceParser xml = context.getResources().getXml(i11);
        try {
            int eventType = xml.getEventType();
            b bVar = null;
            while (true) {
                char c11 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    if (this.f7508k) {
                        System.out.println("parsing = " + name);
                    }
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c11 = 5;
                                break;
                            }
                            break;
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                c11 = '\b';
                                break;
                            }
                            break;
                        case -687739768:
                            if (name.equals("Include")) {
                                c11 = 7;
                                break;
                            }
                            break;
                        case 61998586:
                            if (name.equals("ViewTransition")) {
                                c11 = '\t';
                                break;
                            }
                            break;
                        case 269306229:
                            if (name.equals("Transition")) {
                                break;
                            }
                            break;
                        case 312750793:
                            if (name.equals("OnClick")) {
                                c11 = 3;
                                break;
                            }
                            break;
                        case 327855227:
                            if (name.equals("OnSwipe")) {
                                c11 = 2;
                                break;
                            }
                            break;
                        case 793277014:
                            if (name.equals("MotionScene")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c11 = 4;
                                break;
                            }
                            break;
                        case 1942574248:
                            if (name.equals("include")) {
                                c11 = 6;
                                break;
                            }
                            break;
                    }
                    c11 = 65535;
                    switch (c11) {
                        case 0:
                            Q(context, xml);
                            break;
                        case 1:
                            ArrayList arrayList = this.f7502e;
                            bVar = new b(this, context, xml);
                            arrayList.add(bVar);
                            if (this.f7500c == null && !bVar.f7521b) {
                                this.f7500c = bVar;
                                if (bVar.f7531l != null) {
                                    this.f7500c.f7531l.x(this.f7515r);
                                }
                            }
                            if (!bVar.f7521b) {
                                break;
                            } else {
                                if (bVar.f7522c == -1) {
                                    this.f7503f = bVar;
                                } else {
                                    this.f7504g.add(bVar);
                                }
                                this.f7502e.remove(bVar);
                                break;
                            }
                        case 2:
                            if (bVar == null) {
                                Log.v("MotionScene", " OnSwipe (" + context.getResources().getResourceEntryName(i11) + ".xml:" + xml.getLineNumber() + ")");
                            }
                            if (bVar == null) {
                                break;
                            } else {
                                bVar.f7531l = new q(context, this.f7498a, xml);
                                break;
                            }
                        case 3:
                            if (bVar == null) {
                                break;
                            } else {
                                bVar.u(context, xml);
                                break;
                            }
                        case 4:
                            this.f7499b = new androidx.constraintlayout.widget.e(context, xml);
                            break;
                        case 5:
                            N(context, xml);
                            break;
                        case 6:
                        case 7:
                            P(context, xml);
                            break;
                        case '\b':
                            g gVar = new g(context, xml);
                            if (bVar == null) {
                                break;
                            } else {
                                bVar.f7530k.add(gVar);
                                break;
                            }
                        case '\t':
                            this.f7516s.a(new s(context, xml));
                            break;
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x00d0. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0068. Please report as an issue. */
    private int N(Context context, XmlPullParser xmlPullParser) {
        char c11;
        char c12;
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        bVar.V(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < attributeCount; i13++) {
            String attributeName = xmlPullParser.getAttributeName(i13);
            String attributeValue = xmlPullParser.getAttributeValue(i13);
            if (this.f7508k) {
                System.out.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -1496482599:
                    if (attributeName.equals("deriveConstraintsFrom")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1153153640:
                    if (attributeName.equals("constraintRotate")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            c11 = 65535;
            switch (c11) {
                case 0:
                    i12 = s(context, attributeValue);
                    break;
                case 1:
                    try {
                        bVar.f7834d = Integer.parseInt(attributeValue);
                    } catch (NumberFormatException unused) {
                        attributeValue.hashCode();
                        switch (attributeValue.hashCode()) {
                            case -768416914:
                                if (attributeValue.equals("x_left")) {
                                    c12 = 0;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (attributeValue.equals(TtmlNode.LEFT)) {
                                    c12 = 1;
                                    break;
                                }
                                break;
                            case 3387192:
                                if (attributeValue.equals("none")) {
                                    c12 = 2;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (attributeValue.equals(TtmlNode.RIGHT)) {
                                    c12 = 3;
                                    break;
                                }
                                break;
                            case 1954540437:
                                if (attributeValue.equals("x_right")) {
                                    c12 = 4;
                                    break;
                                }
                                break;
                        }
                        c12 = 65535;
                        switch (c12) {
                            case 0:
                                bVar.f7834d = 4;
                                break;
                            case 1:
                                bVar.f7834d = 2;
                                break;
                            case 2:
                                bVar.f7834d = 0;
                                break;
                            case 3:
                                bVar.f7834d = 1;
                                break;
                            case 4:
                                bVar.f7834d = 3;
                                break;
                        }
                    }
                    break;
                case 2:
                    i11 = s(context, attributeValue);
                    this.f7506i.put(c0(attributeValue), Integer.valueOf(i11));
                    bVar.f7832b = androidx.constraintlayout.motion.widget.a.c(context, i11);
                    break;
            }
        }
        if (i11 != -1) {
            if (this.f7498a.f7267x != 0) {
                bVar.Y(true);
            }
            bVar.I(context, xmlPullParser);
            if (i12 != -1) {
                this.f7507j.put(i11, i12);
            }
            this.f7505h.put(i11, bVar);
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O(Context context, int i11) {
        XmlResourceParser xml = context.getResources().getXml(i11);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return N(context, xml);
                }
            }
            return -1;
        } catch (IOException e11) {
            e11.printStackTrace();
            return -1;
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
            return -1;
        }
    }

    private void P(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.include_constraintSet) {
                O(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void Q(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.MotionScene_defaultDuration) {
                int i12 = obtainStyledAttributes.getInt(index, this.f7509l);
                this.f7509l = i12;
                if (i12 < 8) {
                    this.f7509l = 8;
                }
            } else if (index == R$styleable.MotionScene_layoutDuringTransition) {
                this.f7510m = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void U(int i11, MotionLayout motionLayout) {
        androidx.constraintlayout.widget.b bVar = (androidx.constraintlayout.widget.b) this.f7505h.get(i11);
        bVar.f7833c = bVar.f7832b;
        int i12 = this.f7507j.get(i11);
        if (i12 > 0) {
            U(i12, motionLayout);
            androidx.constraintlayout.widget.b bVar2 = (androidx.constraintlayout.widget.b) this.f7505h.get(i12);
            if (bVar2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + androidx.constraintlayout.motion.widget.a.c(this.f7498a.getContext(), i12));
                return;
            }
            bVar.f7833c += "/" + bVar2.f7833c;
            bVar.Q(bVar2);
        } else {
            bVar.f7833c += "  layout";
            bVar.P(motionLayout);
        }
        bVar.h(bVar);
    }

    public static String c0(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : str.substring(indexOf + 1);
    }

    private int s(Context context, String str) {
        int i11;
        if (str.contains("/")) {
            i11 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.f7508k) {
                System.out.println("id getMap res = " + i11);
            }
        } else {
            i11 = -1;
        }
        if (i11 != -1) {
            return i11;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e("MotionScene", "error in parsing id");
        return i11;
    }

    private int z(int i11) {
        int c11;
        androidx.constraintlayout.widget.e eVar = this.f7499b;
        return (eVar == null || (c11 = eVar.c(i11, -1, -1)) == -1) ? i11 : c11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int A() {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return 0;
        }
        return this.f7500c.f7531l.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float B() {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return 0.0f;
        }
        return this.f7500c.f7531l.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float C() {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return 0.0f;
        }
        return this.f7500c.f7531l.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float D() {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return 0.0f;
        }
        return this.f7500c.f7531l.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float E() {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return 0.0f;
        }
        return this.f7500c.f7531l.o();
    }

    public float F() {
        b bVar = this.f7500c;
        if (bVar != null) {
            return bVar.f7528i;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int G() {
        b bVar = this.f7500c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f7523d;
    }

    public b H(int i11) {
        Iterator it = this.f7502e.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f7520a == i11) {
                return bVar;
            }
        }
        return null;
    }

    public List I(int i11) {
        int z10 = z(i11);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f7502e.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f7523d == z10 || bVar.f7522c == z10) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public boolean L(int i11) {
        return this.f7516s.g(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(float f11, float f12) {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return;
        }
        this.f7500c.f7531l.u(f11, f12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(float f11, float f12) {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return;
        }
        this.f7500c.f7531l.v(f11, f12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(MotionEvent motionEvent, int i11, MotionLayout motionLayout) {
        MotionLayout.e eVar;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.f7514q == null) {
            this.f7514q = this.f7498a.U();
        }
        this.f7514q.a(motionEvent);
        if (i11 != -1) {
            int action = motionEvent.getAction();
            boolean z10 = false;
            if (action == 0) {
                this.f7517t = motionEvent.getRawX();
                this.f7518u = motionEvent.getRawY();
                this.f7511n = motionEvent;
                this.f7512o = false;
                if (this.f7500c.f7531l != null) {
                    RectF f11 = this.f7500c.f7531l.f(this.f7498a, rectF);
                    if (f11 != null && !f11.contains(this.f7511n.getX(), this.f7511n.getY())) {
                        this.f7511n = null;
                        this.f7512o = true;
                        return;
                    }
                    RectF p11 = this.f7500c.f7531l.p(this.f7498a, rectF);
                    if (p11 == null || p11.contains(this.f7511n.getX(), this.f7511n.getY())) {
                        this.f7513p = false;
                    } else {
                        this.f7513p = true;
                    }
                    this.f7500c.f7531l.w(this.f7517t, this.f7518u);
                    return;
                }
                return;
            }
            if (action == 2 && !this.f7512o) {
                float rawY = motionEvent.getRawY() - this.f7518u;
                float rawX = motionEvent.getRawX() - this.f7517t;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.f7511n) == null) {
                    return;
                }
                b i12 = i(i11, rawX, rawY, motionEvent2);
                if (i12 != null) {
                    motionLayout.setTransition(i12);
                    RectF p12 = this.f7500c.f7531l.p(this.f7498a, rectF);
                    if (p12 != null && !p12.contains(this.f7511n.getX(), this.f7511n.getY())) {
                        z10 = true;
                    }
                    this.f7513p = z10;
                    this.f7500c.f7531l.z(this.f7517t, this.f7518u);
                }
            }
        }
        if (this.f7512o) {
            return;
        }
        b bVar = this.f7500c;
        if (bVar != null && bVar.f7531l != null && !this.f7513p) {
            this.f7500c.f7531l.s(motionEvent, this.f7514q, i11, this);
        }
        this.f7517t = motionEvent.getRawX();
        this.f7518u = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (eVar = this.f7514q) == null) {
            return;
        }
        eVar.recycle();
        this.f7514q = null;
        int i13 = motionLayout.f7231f;
        if (i13 != -1) {
            h(motionLayout, i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(MotionLayout motionLayout) {
        for (int i11 = 0; i11 < this.f7505h.size(); i11++) {
            int keyAt = this.f7505h.keyAt(i11);
            if (J(keyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            U(keyAt, motionLayout);
        }
    }

    public void W(int i11, androidx.constraintlayout.widget.b bVar) {
        this.f7505h.put(i11, bVar);
    }

    public void X(int i11) {
        b bVar = this.f7500c;
        if (bVar != null) {
            bVar.E(i11);
        } else {
            this.f7509l = i11;
        }
    }

    public void Y(boolean z10) {
        this.f7515r = z10;
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return;
        }
        this.f7500c.f7531l.x(this.f7515r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r2 != (-1)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Z(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.e r0 = r6.f7499b
            r1 = -1
            if (r0 == 0) goto L18
            int r0 = r0.c(r7, r1, r1)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r7
        Ld:
            androidx.constraintlayout.widget.e r2 = r6.f7499b
            int r2 = r2.c(r8, r1, r1)
            if (r2 == r1) goto L16
            goto L1a
        L16:
            r2 = r8
            goto L1a
        L18:
            r0 = r7
            goto L16
        L1a:
            androidx.constraintlayout.motion.widget.p$b r3 = r6.f7500c
            if (r3 == 0) goto L2d
            int r3 = androidx.constraintlayout.motion.widget.p.b.a(r3)
            if (r3 != r8) goto L2d
            androidx.constraintlayout.motion.widget.p$b r3 = r6.f7500c
            int r3 = androidx.constraintlayout.motion.widget.p.b.c(r3)
            if (r3 != r7) goto L2d
            return
        L2d:
            java.util.ArrayList r3 = r6.f7502e
            java.util.Iterator r3 = r3.iterator()
        L33:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L6d
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.p$b r4 = (androidx.constraintlayout.motion.widget.p.b) r4
            int r5 = androidx.constraintlayout.motion.widget.p.b.a(r4)
            if (r5 != r2) goto L4b
            int r5 = androidx.constraintlayout.motion.widget.p.b.c(r4)
            if (r5 == r0) goto L57
        L4b:
            int r5 = androidx.constraintlayout.motion.widget.p.b.a(r4)
            if (r5 != r8) goto L33
            int r5 = androidx.constraintlayout.motion.widget.p.b.c(r4)
            if (r5 != r7) goto L33
        L57:
            r6.f7500c = r4
            if (r4 == 0) goto L6c
            androidx.constraintlayout.motion.widget.q r7 = androidx.constraintlayout.motion.widget.p.b.l(r4)
            if (r7 == 0) goto L6c
            androidx.constraintlayout.motion.widget.p$b r7 = r6.f7500c
            androidx.constraintlayout.motion.widget.q r7 = androidx.constraintlayout.motion.widget.p.b.l(r7)
            boolean r8 = r6.f7515r
            r7.x(r8)
        L6c:
            return
        L6d:
            androidx.constraintlayout.motion.widget.p$b r7 = r6.f7503f
            java.util.ArrayList r3 = r6.f7504g
            java.util.Iterator r3 = r3.iterator()
        L75:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L89
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.p$b r4 = (androidx.constraintlayout.motion.widget.p.b) r4
            int r5 = androidx.constraintlayout.motion.widget.p.b.a(r4)
            if (r5 != r8) goto L75
            r7 = r4
            goto L75
        L89:
            androidx.constraintlayout.motion.widget.p$b r8 = new androidx.constraintlayout.motion.widget.p$b
            r8.<init>(r6, r7)
            androidx.constraintlayout.motion.widget.p.b.d(r8, r0)
            androidx.constraintlayout.motion.widget.p.b.b(r8, r2)
            if (r0 == r1) goto L9b
            java.util.ArrayList r7 = r6.f7502e
            r7.add(r8)
        L9b:
            r6.f7500c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.p.Z(int, int):void");
    }

    public void a0(b bVar) {
        this.f7500c = bVar;
        if (bVar == null || bVar.f7531l == null) {
            return;
        }
        this.f7500c.f7531l.x(this.f7515r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0() {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return;
        }
        this.f7500c.f7531l.A();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d0() {
        Iterator it = this.f7502e.iterator();
        while (it.hasNext()) {
            if (((b) it.next()).f7531l != null) {
                return true;
            }
        }
        b bVar = this.f7500c;
        return (bVar == null || bVar.f7531l == null) ? false : true;
    }

    public void e0(int i11, View... viewArr) {
        this.f7516s.k(i11, viewArr);
    }

    public void f(MotionLayout motionLayout, int i11) {
        Iterator it = this.f7502e.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f7532m.size() > 0) {
                Iterator it2 = bVar.f7532m.iterator();
                while (it2.hasNext()) {
                    ((b.a) it2.next()).c(motionLayout);
                }
            }
        }
        Iterator it3 = this.f7504g.iterator();
        while (it3.hasNext()) {
            b bVar2 = (b) it3.next();
            if (bVar2.f7532m.size() > 0) {
                Iterator it4 = bVar2.f7532m.iterator();
                while (it4.hasNext()) {
                    ((b.a) it4.next()).c(motionLayout);
                }
            }
        }
        Iterator it5 = this.f7502e.iterator();
        while (it5.hasNext()) {
            b bVar3 = (b) it5.next();
            if (bVar3.f7532m.size() > 0) {
                Iterator it6 = bVar3.f7532m.iterator();
                while (it6.hasNext()) {
                    ((b.a) it6.next()).a(motionLayout, i11, bVar3);
                }
            }
        }
        Iterator it7 = this.f7504g.iterator();
        while (it7.hasNext()) {
            b bVar4 = (b) it7.next();
            if (bVar4.f7532m.size() > 0) {
                Iterator it8 = bVar4.f7532m.iterator();
                while (it8.hasNext()) {
                    ((b.a) it8.next()).a(motionLayout, i11, bVar4);
                }
            }
        }
    }

    public boolean g(int i11, m mVar) {
        return this.f7516s.d(i11, mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(MotionLayout motionLayout, int i11) {
        b bVar;
        if (K() || this.f7501d) {
            return false;
        }
        Iterator it = this.f7502e.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2.f7533n != 0 && ((bVar = this.f7500c) != bVar2 || !bVar.D(2))) {
                if (i11 == bVar2.f7523d && (bVar2.f7533n == 4 || bVar2.f7533n == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.f7533n == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.M(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.V();
                    }
                    return true;
                }
                if (i11 == bVar2.f7522c && (bVar2.f7533n == 3 || bVar2.f7533n == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.f7533n == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.M(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.V();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public b i(int i11, float f11, float f12, MotionEvent motionEvent) {
        if (i11 == -1) {
            return this.f7500c;
        }
        List<b> I = I(i11);
        RectF rectF = new RectF();
        float f13 = 0.0f;
        b bVar = null;
        for (b bVar2 : I) {
            if (!bVar2.f7534o && bVar2.f7531l != null) {
                bVar2.f7531l.x(this.f7515r);
                RectF p11 = bVar2.f7531l.p(this.f7498a, rectF);
                if (p11 == null || motionEvent == null || p11.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF f14 = bVar2.f7531l.f(this.f7498a, rectF);
                    if (f14 == null || motionEvent == null || f14.contains(motionEvent.getX(), motionEvent.getY())) {
                        float a11 = bVar2.f7531l.a(f11, f12);
                        if (bVar2.f7531l.f7552l && motionEvent != null) {
                            a11 = ((float) (Math.atan2(f12 + r10, f11 + r9) - Math.atan2(motionEvent.getX() - bVar2.f7531l.f7549i, motionEvent.getY() - bVar2.f7531l.f7550j))) * 10.0f;
                        }
                        float f15 = a11 * (bVar2.f7522c == i11 ? -1.0f : 1.1f);
                        if (f15 > f13) {
                            bVar = bVar2;
                            f13 = f15;
                        }
                    }
                }
            }
        }
        return bVar;
    }

    public void j(int i11, boolean z10) {
        this.f7516s.e(i11, z10);
    }

    public int k() {
        b bVar = this.f7500c;
        if (bVar != null) {
            return bVar.f7535p;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return 0;
        }
        return this.f7500c.f7531l.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.constraintlayout.widget.b m(int i11) {
        return n(i11, -1, -1);
    }

    androidx.constraintlayout.widget.b n(int i11, int i12, int i13) {
        int c11;
        if (this.f7508k) {
            PrintStream printStream = System.out;
            printStream.println("id " + i11);
            printStream.println("size " + this.f7505h.size());
        }
        androidx.constraintlayout.widget.e eVar = this.f7499b;
        if (eVar != null && (c11 = eVar.c(i11, i12, i13)) != -1) {
            i11 = c11;
        }
        if (this.f7505h.get(i11) != null) {
            return (androidx.constraintlayout.widget.b) this.f7505h.get(i11);
        }
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + androidx.constraintlayout.motion.widget.a.c(this.f7498a.getContext(), i11) + " In MotionScene");
        SparseArray sparseArray = this.f7505h;
        return (androidx.constraintlayout.widget.b) sparseArray.get(sparseArray.keyAt(0));
    }

    public int[] o() {
        int size = this.f7505h.size();
        int[] iArr = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = this.f7505h.keyAt(i11);
        }
        return iArr;
    }

    public ArrayList p() {
        return this.f7502e;
    }

    public int q() {
        b bVar = this.f7500c;
        return bVar != null ? bVar.f7527h : this.f7509l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        b bVar = this.f7500c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f7522c;
    }

    public Interpolator t() {
        int i11 = this.f7500c.f7524e;
        if (i11 == -2) {
            return AnimationUtils.loadInterpolator(this.f7498a.getContext(), this.f7500c.f7526g);
        }
        if (i11 == -1) {
            return new a(this, androidx.constraintlayout.core.motion.utils.c.c(this.f7500c.f7525f));
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

    public void u(m mVar) {
        b bVar = this.f7500c;
        if (bVar != null) {
            Iterator it = bVar.f7530k.iterator();
            while (it.hasNext()) {
                ((g) it.next()).b(mVar);
            }
        } else {
            b bVar2 = this.f7503f;
            if (bVar2 != null) {
                Iterator it2 = bVar2.f7530k.iterator();
                while (it2.hasNext()) {
                    ((g) it2.next()).b(mVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float v() {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return 0.0f;
        }
        return this.f7500c.f7531l.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float w() {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return 0.0f;
        }
        return this.f7500c.f7531l.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return false;
        }
        return this.f7500c.f7531l.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float y(float f11, float f12) {
        b bVar = this.f7500c;
        if (bVar == null || bVar.f7531l == null) {
            return 0.0f;
        }
        return this.f7500c.f7531l.j(f11, f12);
    }
}
