package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;

/* loaded from: classes.dex */
public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;

    /* renamed from: j, reason: collision with root package name */
    private int f7715j;

    /* renamed from: k, reason: collision with root package name */
    private int f7716k;

    /* renamed from: l, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.a f7717l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        super.setVisibility(8);
    }

    private void l(ConstraintWidget constraintWidget, int i11, boolean z10) {
        this.f7716k = i11;
        if (z10) {
            int i12 = this.f7715j;
            if (i12 == 5) {
                this.f7716k = 1;
            } else if (i12 == 6) {
                this.f7716k = 0;
            }
        } else {
            int i13 = this.f7715j;
            if (i13 == 5) {
                this.f7716k = 0;
            } else if (i13 == 6) {
                this.f7716k = 1;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            ((androidx.constraintlayout.core.widgets.a) constraintWidget).E1(this.f7716k);
        }
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.f7717l.y1();
    }

    public boolean getAllowsGoneWidget() {
        return this.f7717l.y1();
    }

    public int getMargin() {
        return this.f7717l.A1();
    }

    public int getType() {
        return this.f7715j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        this.f7717l = new androidx.constraintlayout.core.widgets.a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f7717l.D1(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f7717l.F1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f7730d = this.f7717l;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(b.a aVar, t0.b bVar, ConstraintLayout.b bVar2, SparseArray<ConstraintWidget> sparseArray) {
        super.loadParameters(aVar, bVar, bVar2, sparseArray);
        if (bVar instanceof androidx.constraintlayout.core.widgets.a) {
            androidx.constraintlayout.core.widgets.a aVar2 = (androidx.constraintlayout.core.widgets.a) bVar;
            l(aVar2, aVar.f7842e.f7874h0, ((androidx.constraintlayout.core.widgets.d) bVar.M()).U1());
            aVar2.D1(aVar.f7842e.f7890p0);
            aVar2.F1(aVar.f7842e.f7876i0);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget constraintWidget, boolean z10) {
        l(constraintWidget, this.f7715j, z10);
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f7717l.D1(z10);
    }

    public void setDpMargin(int i11) {
        this.f7717l.F1((int) ((i11 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i11) {
        this.f7717l.F1(i11);
    }

    public void setType(int i11) {
        this.f7715j = i11;
    }
}
