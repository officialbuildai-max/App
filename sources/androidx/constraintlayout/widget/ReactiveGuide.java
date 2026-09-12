package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;

/* loaded from: classes.dex */
public class ReactiveGuide extends View implements d.a {

    /* renamed from: a, reason: collision with root package name */
    private int f7805a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7806b;

    /* renamed from: c, reason: collision with root package name */
    private int f7807c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7808d;

    public ReactiveGuide(Context context) {
        super(context);
        this.f7805a = -1;
        this.f7806b = false;
        this.f7807c = 0;
        this.f7808d = true;
        super.setVisibility(8);
        b(null);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7805a = -1;
        this.f7806b = false;
        this.f7807c = 0;
        this.f7808d = true;
        super.setVisibility(8);
        b(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7805a = -1;
        this.f7806b = false;
        this.f7807c = 0;
        this.f7808d = true;
        super.setVisibility(8);
        b(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        this.f7805a = -1;
        this.f7806b = false;
        this.f7807c = 0;
        this.f7808d = true;
        super.setVisibility(8);
        b(attributeSet);
    }

    private void a(int i11, int i12, MotionLayout motionLayout, int i13) {
        b constraintSet = motionLayout.getConstraintSet(i13);
        constraintSet.W(i12, i11);
        motionLayout.updateState(i13, constraintSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.f7805a = obtainStyledAttributes.getResourceId(index, this.f7805a);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.f7806b = obtainStyledAttributes.getBoolean(index, this.f7806b);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.f7807c = obtainStyledAttributes.getResourceId(index, this.f7807c);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.f7808d = obtainStyledAttributes.getBoolean(index, this.f7808d);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f7805a != -1) {
            ConstraintLayout.getSharedValues().a(this.f7805a, this);
        }
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.f7807c;
    }

    public int getAttributeId() {
        return this.f7805a;
    }

    public boolean isAnimatingChange() {
        return this.f7806b;
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        setMeasuredDimension(0, 0);
    }

    public void onNewValue(int i11, int i12, int i13) {
        setGuidelineBegin(i12);
        int id2 = getId();
        if (id2 > 0 && (getParent() instanceof MotionLayout)) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            int currentState = motionLayout.getCurrentState();
            int i14 = this.f7807c;
            if (i14 != 0) {
                currentState = i14;
            }
            int i15 = 0;
            if (!this.f7806b) {
                if (!this.f7808d) {
                    a(i12, id2, motionLayout, currentState);
                    return;
                }
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                while (i15 < constraintSetIds.length) {
                    a(i12, id2, motionLayout, constraintSetIds[i15]);
                    i15++;
                }
                return;
            }
            if (this.f7808d) {
                int[] constraintSetIds2 = motionLayout.getConstraintSetIds();
                while (i15 < constraintSetIds2.length) {
                    int i16 = constraintSetIds2[i15];
                    if (i16 != currentState) {
                        a(i12, id2, motionLayout, i16);
                    }
                    i15++;
                }
            }
            b cloneConstraintSet = motionLayout.cloneConstraintSet(currentState);
            cloneConstraintSet.W(id2, i12);
            motionLayout.updateStateAnimate(currentState, cloneConstraintSet, 1000);
        }
    }

    public void setAnimateChange(boolean z10) {
        this.f7806b = z10;
    }

    public void setApplyToConstraintSetId(int i11) {
        this.f7807c = i11;
    }

    public void setAttributeId(int i11) {
        d sharedValues = ConstraintLayout.getSharedValues();
        int i12 = this.f7805a;
        if (i12 != -1) {
            sharedValues.b(i12, this);
        }
        this.f7805a = i11;
        if (i11 != -1) {
            sharedValues.a(i11, this);
        }
    }

    public void setGuidelineBegin(int i11) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f7737a = i11;
        setLayoutParams(bVar);
    }

    public void setGuidelineEnd(int i11) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f7739b = i11;
        setLayoutParams(bVar);
    }

    public void setGuidelinePercent(float f11) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f7741c = f11;
        setLayoutParams(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
    }
}
