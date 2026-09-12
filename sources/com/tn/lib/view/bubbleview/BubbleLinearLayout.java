package com.tn.lib.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tn.lib.view.bubbleview.BubbleDrawable;
import com.tn.lib.widget.R$styleable;

/* loaded from: classes4.dex */
public class BubbleLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private BubbleDrawable f41297a;

    /* renamed from: b, reason: collision with root package name */
    private float f41298b;

    /* renamed from: c, reason: collision with root package name */
    private int f41299c;

    /* renamed from: d, reason: collision with root package name */
    private float f41300d;

    /* renamed from: e, reason: collision with root package name */
    private float f41301e;

    /* renamed from: f, reason: collision with root package name */
    private float f41302f;

    /* renamed from: g, reason: collision with root package name */
    private float f41303g;

    /* renamed from: h, reason: collision with root package name */
    private float f41304h;

    /* renamed from: i, reason: collision with root package name */
    private float f41305i;

    /* renamed from: j, reason: collision with root package name */
    private BubbleDrawable.ArrowLocation f41306j;

    /* renamed from: k, reason: collision with root package name */
    private int f41307k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f41308l;

    public BubbleLinearLayout(Context context) {
        super(context);
        b(null);
    }

    public BubbleLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        setLayerType(1, null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleView);
            this.f41298b = obtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowRadius, BubbleDrawable.b.A);
            this.f41299c = obtainStyledAttributes.getColor(R$styleable.BubbleView_shadowColor, BubbleDrawable.b.B);
            this.f41300d = obtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetX, BubbleDrawable.b.C);
            this.f41301e = obtainStyledAttributes.getDimension(R$styleable.BubbleView_shadowOffsetY, BubbleDrawable.b.C);
            this.f41302f = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowWidth, BubbleDrawable.b.f41195u);
            this.f41304h = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowHeight, BubbleDrawable.b.f41196v);
            this.f41303g = obtainStyledAttributes.getDimension(R$styleable.BubbleView_angle, BubbleDrawable.b.f41197w);
            this.f41305i = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowPosition, BubbleDrawable.b.f41198x);
            this.f41307k = obtainStyledAttributes.getColor(R$styleable.BubbleView_bubbleColor, BubbleDrawable.b.f41199y);
            this.f41306j = BubbleDrawable.ArrowLocation.mapIntToValue(obtainStyledAttributes.getInt(R$styleable.BubbleView_arrowLocation, 0));
            this.f41308l = obtainStyledAttributes.getBoolean(R$styleable.BubbleView_arrowCenter, false);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i11, int i12) {
        d((int) ((getPaddingLeft() + this.f41298b) - this.f41300d), (int) (((i11 - getPaddingRight()) - this.f41298b) - this.f41300d), (int) ((getPaddingTop() + this.f41298b) - this.f41301e), (int) (((i12 - getPaddingBottom()) - this.f41298b) - this.f41301e));
        setBackgroundDrawable(this.f41297a);
    }

    private void d(int i11, int i12, int i13, int i14) {
        if (i12 < i11 || i14 < i13) {
            return;
        }
        this.f41297a = new BubbleDrawable.b().B(new RectF(i11, i13, i12, i14)).t(this.f41306j).z(BubbleDrawable.BubbleType.COLOR).q(this.f41303g).s(this.f41304h).v(this.f41302f).u(this.f41305i).x(this.f41307k).r(this.f41308l).F(this.f41298b).C(this.f41299c).D(this.f41300d).E(this.f41301e).A();
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
        post(new Runnable() { // from class: com.tn.lib.view.bubbleview.BubbleLinearLayout.1
            @Override // java.lang.Runnable
            public void run() {
                BubbleLinearLayout bubbleLinearLayout = BubbleLinearLayout.this;
                bubbleLinearLayout.c(bubbleLinearLayout.getWidth(), BubbleLinearLayout.this.getHeight());
            }
        });
    }
}
