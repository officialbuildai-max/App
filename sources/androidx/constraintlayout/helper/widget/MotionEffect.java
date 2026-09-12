package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    public static final int WEST = 3;

    /* renamed from: n, reason: collision with root package name */
    private float f7208n;

    /* renamed from: o, reason: collision with root package name */
    private int f7209o;

    /* renamed from: p, reason: collision with root package name */
    private int f7210p;

    /* renamed from: q, reason: collision with root package name */
    private int f7211q;

    /* renamed from: r, reason: collision with root package name */
    private int f7212r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f7213s;

    /* renamed from: t, reason: collision with root package name */
    private int f7214t;

    /* renamed from: u, reason: collision with root package name */
    private int f7215u;

    public MotionEffect(Context context) {
        super(context);
        this.f7208n = 0.1f;
        this.f7209o = 49;
        this.f7210p = 50;
        this.f7211q = 0;
        this.f7212r = 0;
        this.f7213s = true;
        this.f7214t = -1;
        this.f7215u = -1;
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7208n = 0.1f;
        this.f7209o = 49;
        this.f7210p = 50;
        this.f7211q = 0;
        this.f7212r = 0;
        this.f7213s = true;
        this.f7214t = -1;
        this.f7215u = -1;
        l(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7208n = 0.1f;
        this.f7209o = 49;
        this.f7210p = 50;
        this.f7211q = 0;
        this.f7212r = 0;
        this.f7213s = true;
        this.f7214t = -1;
        this.f7215u = -1;
        l(context, attributeSet);
    }

    private void l(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionEffect_motionEffect_start) {
                    int i12 = obtainStyledAttributes.getInt(index, this.f7209o);
                    this.f7209o = i12;
                    this.f7209o = Math.max(Math.min(i12, 99), 0);
                } else if (index == R$styleable.MotionEffect_motionEffect_end) {
                    int i13 = obtainStyledAttributes.getInt(index, this.f7210p);
                    this.f7210p = i13;
                    this.f7210p = Math.max(Math.min(i13, 99), 0);
                } else if (index == R$styleable.MotionEffect_motionEffect_translationX) {
                    this.f7211q = obtainStyledAttributes.getDimensionPixelOffset(index, this.f7211q);
                } else if (index == R$styleable.MotionEffect_motionEffect_translationY) {
                    this.f7212r = obtainStyledAttributes.getDimensionPixelOffset(index, this.f7212r);
                } else if (index == R$styleable.MotionEffect_motionEffect_alpha) {
                    this.f7208n = obtainStyledAttributes.getFloat(index, this.f7208n);
                } else if (index == R$styleable.MotionEffect_motionEffect_move) {
                    this.f7215u = obtainStyledAttributes.getInt(index, this.f7215u);
                } else if (index == R$styleable.MotionEffect_motionEffect_strict) {
                    this.f7213s = obtainStyledAttributes.getBoolean(index, this.f7213s);
                } else if (index == R$styleable.MotionEffect_motionEffect_viewTransition) {
                    this.f7214t = obtainStyledAttributes.getResourceId(index, this.f7214t);
                }
            }
            int i14 = this.f7209o;
            int i15 = this.f7210p;
            if (i14 == i15) {
                if (i14 > 0) {
                    this.f7209o = i14 - 1;
                } else {
                    this.f7210p = i15 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    public boolean isDecorator() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0185, code lost:
    
        if (r14 == 0.0f) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0199, code lost:
    
        if (r14 == 0.0f) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a9, code lost:
    
        if (r15 == 0.0f) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01b9, code lost:
    
        if (r15 == 0.0f) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e4  */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout r23, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r24) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }
}
