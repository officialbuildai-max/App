package com.tn.lib.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tn.lib.view.bubbleview.BubbleDrawable;
import com.tn.lib.widget.R$styleable;

/* loaded from: classes4.dex */
public class BubbleFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private BubbleDrawable f41221a;

    /* renamed from: b, reason: collision with root package name */
    private float f41222b;

    /* renamed from: c, reason: collision with root package name */
    private int f41223c;

    /* renamed from: d, reason: collision with root package name */
    private float f41224d;

    /* renamed from: e, reason: collision with root package name */
    private float f41225e;

    /* renamed from: f, reason: collision with root package name */
    private float f41226f;

    /* renamed from: g, reason: collision with root package name */
    private float f41227g;

    /* renamed from: h, reason: collision with root package name */
    private float f41228h;

    /* renamed from: i, reason: collision with root package name */
    private float f41229i;

    /* renamed from: j, reason: collision with root package name */
    private BubbleDrawable.ArrowLocation f41230j;

    /* renamed from: k, reason: collision with root package name */
    private int f41231k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f41232l;

    public BubbleFrameLayout(Context context) {
        super(context);
        b(null);
    }

    public BubbleFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        setLayerType(1, null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleView);
            this.f41222b = obtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowRadius, BubbleDrawable.b.A);
            this.f41223c = obtainStyledAttributes.getColor(R$styleable.BubbleView_shadowColor, BubbleDrawable.b.B);
            this.f41224d = obtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetX, BubbleDrawable.b.C);
            this.f41225e = obtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetY, BubbleDrawable.b.C);
            this.f41226f = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowWidth, BubbleDrawable.b.f41195u);
            this.f41228h = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowHeight, BubbleDrawable.b.f41196v);
            this.f41227g = obtainStyledAttributes.getDimension(R$styleable.BubbleView_angle, BubbleDrawable.b.f41197w);
            this.f41229i = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowPosition, BubbleDrawable.b.f41198x);
            this.f41231k = obtainStyledAttributes.getColor(R$styleable.BubbleView_bubbleColor, BubbleDrawable.b.f41199y);
            this.f41230j = BubbleDrawable.ArrowLocation.mapIntToValue(obtainStyledAttributes.getInt(R$styleable.BubbleView_arrowLocation, 0));
            this.f41232l = obtainStyledAttributes.getBoolean(R$styleable.BubbleView_arrowCenter, false);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i11, int i12) {
        d((int) ((getPaddingLeft() + this.f41222b) - this.f41224d), (int) (((i11 - getPaddingRight()) - this.f41222b) - this.f41224d), (int) ((getPaddingTop() + this.f41222b) - this.f41225e), (int) (((i12 - getPaddingBottom()) - this.f41222b) - this.f41225e));
        setBackgroundDrawable(this.f41221a);
    }

    private void d(int i11, int i12, int i13, int i14) {
        if (i12 < i11 || i14 < i13) {
            return;
        }
        this.f41221a = new BubbleDrawable.b().B(new RectF(i11, i13, i12, i14)).t(this.f41230j).z(BubbleDrawable.BubbleType.COLOR).q(this.f41227g).s(this.f41228h).v(this.f41226f).u(this.f41229i).x(this.f41231k).r(this.f41232l).F(this.f41222b).C(this.f41223c).D(this.f41224d).E(this.f41225e).A();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        c(i11, i12);
    }

    public void setUpBubbleDrawable() {
        setBackgroundDrawable(null);
        post(new Runnable() { // from class: com.tn.lib.view.bubbleview.BubbleFrameLayout.1
            @Override // java.lang.Runnable
            public void run() {
                BubbleFrameLayout bubbleFrameLayout = BubbleFrameLayout.this;
                bubbleFrameLayout.c(bubbleFrameLayout.getWidth(), BubbleFrameLayout.this.getHeight());
            }
        });
    }
}
