package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.i;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.b;

/* loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL = 1;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;

    /* renamed from: l, reason: collision with root package name */
    private e f7190l;

    public Flow(Context context) {
        super(context);
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        this.f7190l = new e();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f7190l.H2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_padding) {
                    this.f7190l.M1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingStart) {
                    this.f7190l.R1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.f7190l.O1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f7190l.P1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f7190l.S1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f7190l.Q1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f7190l.N1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f7190l.M2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f7190l.B2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f7190l.L2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f7190l.v2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f7190l.D2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f7190l.x2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f7190l.F2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f7190l.z2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f7190l.u2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f7190l.C2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f7190l.w2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f7190l.E2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f7190l.J2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f7190l.y2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f7190l.I2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f7190l.A2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f7190l.K2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f7190l.G2(obtainStyledAttributes.getInt(index, -1));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f7730d = this.f7190l;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(b.a aVar, t0.b bVar, ConstraintLayout.b bVar2, SparseArray<ConstraintWidget> sparseArray) {
        super.loadParameters(aVar, bVar, bVar2, sparseArray);
        if (bVar instanceof e) {
            e eVar = (e) bVar;
            int i11 = bVar2.Z;
            if (i11 != -1) {
                eVar.H2(i11);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onMeasure(int i11, int i12) {
        onMeasure(this.f7190l, i11, i12);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(i iVar, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (iVar == null) {
            setMeasuredDimension(0, 0);
        } else {
            iVar.G1(mode, size, mode2, size2);
            setMeasuredDimension(iVar.B1(), iVar.A1());
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget constraintWidget, boolean z10) {
        this.f7190l.x1(z10);
    }

    public void setFirstHorizontalBias(float f11) {
        this.f7190l.u2(f11);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i11) {
        this.f7190l.v2(i11);
        requestLayout();
    }

    public void setFirstVerticalBias(float f11) {
        this.f7190l.w2(f11);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i11) {
        this.f7190l.x2(i11);
        requestLayout();
    }

    public void setHorizontalAlign(int i11) {
        this.f7190l.y2(i11);
        requestLayout();
    }

    public void setHorizontalBias(float f11) {
        this.f7190l.z2(f11);
        requestLayout();
    }

    public void setHorizontalGap(int i11) {
        this.f7190l.A2(i11);
        requestLayout();
    }

    public void setHorizontalStyle(int i11) {
        this.f7190l.B2(i11);
        requestLayout();
    }

    public void setLastHorizontalBias(float f11) {
        this.f7190l.C2(f11);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i11) {
        this.f7190l.D2(i11);
        requestLayout();
    }

    public void setLastVerticalBias(float f11) {
        this.f7190l.E2(f11);
        requestLayout();
    }

    public void setLastVerticalStyle(int i11) {
        this.f7190l.F2(i11);
        requestLayout();
    }

    public void setMaxElementsWrap(int i11) {
        this.f7190l.G2(i11);
        requestLayout();
    }

    public void setOrientation(int i11) {
        this.f7190l.H2(i11);
        requestLayout();
    }

    public void setPadding(int i11) {
        this.f7190l.M1(i11);
        requestLayout();
    }

    public void setPaddingBottom(int i11) {
        this.f7190l.N1(i11);
        requestLayout();
    }

    public void setPaddingLeft(int i11) {
        this.f7190l.P1(i11);
        requestLayout();
    }

    public void setPaddingRight(int i11) {
        this.f7190l.Q1(i11);
        requestLayout();
    }

    public void setPaddingTop(int i11) {
        this.f7190l.S1(i11);
        requestLayout();
    }

    public void setVerticalAlign(int i11) {
        this.f7190l.I2(i11);
        requestLayout();
    }

    public void setVerticalBias(float f11) {
        this.f7190l.J2(f11);
        requestLayout();
    }

    public void setVerticalGap(int i11) {
        this.f7190l.K2(i11);
        requestLayout();
    }

    public void setVerticalStyle(int i11) {
        this.f7190l.L2(i11);
        requestLayout();
    }

    public void setWrapMode(int i11) {
        this.f7190l.M2(i11);
        requestLayout();
    }
}
