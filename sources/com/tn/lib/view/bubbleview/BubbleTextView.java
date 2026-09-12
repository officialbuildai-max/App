package com.tn.lib.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.bubbleview.BubbleDrawable;
import com.tn.lib.widget.R$styleable;

/* loaded from: classes4.dex */
public class BubbleTextView extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    private BubbleDrawable f41309a;

    /* renamed from: b, reason: collision with root package name */
    private float f41310b;

    /* renamed from: c, reason: collision with root package name */
    private float f41311c;

    /* renamed from: d, reason: collision with root package name */
    private float f41312d;

    /* renamed from: e, reason: collision with root package name */
    private float f41313e;

    /* renamed from: f, reason: collision with root package name */
    private int f41314f;

    /* renamed from: g, reason: collision with root package name */
    private int f41315g;

    /* renamed from: h, reason: collision with root package name */
    private BubbleDrawable.ArrowLocation f41316h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f41317i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f41318a;

        static {
            int[] iArr = new int[BubbleDrawable.ArrowLocation.values().length];
            f41318a = iArr;
            try {
                iArr[BubbleDrawable.ArrowLocation.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41318a[BubbleDrawable.ArrowLocation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41318a[BubbleDrawable.ArrowLocation.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41318a[BubbleDrawable.ArrowLocation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BubbleTextView(Context context) {
        super(context);
        b(null);
    }

    public BubbleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    public BubbleTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleView);
            this.f41310b = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowWidth, BubbleDrawable.b.f41195u);
            this.f41312d = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowHeight, BubbleDrawable.b.f41196v);
            this.f41311c = obtainStyledAttributes.getDimension(R$styleable.BubbleView_angle, BubbleDrawable.b.f41197w);
            this.f41313e = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowPosition, BubbleDrawable.b.f41198x);
            this.f41314f = obtainStyledAttributes.getColor(R$styleable.BubbleView_bubbleColor, BubbleDrawable.b.f41199y);
            this.f41316h = BubbleDrawable.ArrowLocation.mapIntToValue(obtainStyledAttributes.getInt(R$styleable.BubbleView_arrowLocation, 0));
            this.f41317i = obtainStyledAttributes.getBoolean(R$styleable.BubbleView_arrowCenter, false);
            this.f41315g = obtainStyledAttributes.getInt(R$styleable.BubbleView_bubbleAlpha, 255);
            obtainStyledAttributes.recycle();
        }
        f();
    }

    private void c() {
        d(getWidth(), getHeight());
    }

    private void d(int i11, int i12) {
        e(0, i11, 0, i12);
    }

    private void e(int i11, int i12, int i13, int i14) {
        this.f41309a = new BubbleDrawable.b().B(new RectF(i11, i13, i12, i14)).t(this.f41316h).z(BubbleDrawable.BubbleType.COLOR).q(this.f41311c).p(this.f41315g).s(this.f41312d).v(this.f41310b).x(this.f41314f).u(this.f41313e).r(this.f41317i).A();
    }

    private void f() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i11 = a.f41318a[this.f41316h.ordinal()];
        if (i11 == 1) {
            paddingLeft = (int) (paddingLeft + this.f41310b);
        } else if (i11 == 2) {
            paddingRight = (int) (paddingRight + this.f41310b);
        } else if (i11 == 3) {
            paddingTop = (int) (paddingTop + this.f41312d);
        } else if (i11 == 4) {
            paddingBottom = (int) (paddingBottom + this.f41312d);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override // android.view.View
    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        c();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        BubbleDrawable bubbleDrawable = this.f41309a;
        if (bubbleDrawable != null) {
            bubbleDrawable.draw(canvas);
        }
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        d(i11, i12);
    }

    public void setArrowPosition(float f11) {
        this.f41313e = f11;
        c();
    }
}
