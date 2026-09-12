package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements MotionLayout.h {

    /* renamed from: j, reason: collision with root package name */
    private boolean f7217j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7218k;

    /* renamed from: l, reason: collision with root package name */
    private float f7219l;

    /* renamed from: m, reason: collision with root package name */
    protected View[] f7220m;

    public MotionHelper(Context context) {
        super(context);
        this.f7217j = false;
        this.f7218k = false;
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7217j = false;
        this.f7218k = false;
        k(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7217j = false;
        this.f7218k = false;
        k(attributeSet);
    }

    public float getProgress() {
        return this.f7219l;
    }

    public boolean isDecorator() {
        return false;
    }

    public boolean isUseOnHide() {
        return this.f7218k;
    }

    public boolean isUsedOnShow() {
        return this.f7217j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionHelper_onShow) {
                    this.f7217j = obtainStyledAttributes.getBoolean(index, this.f7217j);
                } else if (index == R$styleable.MotionHelper_onHide) {
                    this.f7218k = obtainStyledAttributes.getBoolean(index, this.f7218k);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onFinishedMotionScene(MotionLayout motionLayout) {
    }

    public void onPostDraw(Canvas canvas) {
    }

    public void onPreDraw(Canvas canvas) {
    }

    public void onPreSetup(MotionLayout motionLayout, HashMap<View, m> hashMap) {
    }

    public void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i11) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.h
    public void onTransitionStarted(MotionLayout motionLayout, int i11, int i12) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.h
    public void onTransitionTrigger(MotionLayout motionLayout, int i11, boolean z10, float f11) {
    }

    public void setProgress(float f11) {
        this.f7219l = f11;
        int i11 = 0;
        if (this.f7728b > 0) {
            this.f7220m = j((ConstraintLayout) getParent());
            while (i11 < this.f7728b) {
                setProgress(this.f7220m[i11], f11);
                i11++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i11 < childCount) {
            View childAt = viewGroup.getChildAt(i11);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, f11);
            }
            i11++;
        }
    }

    public void setProgress(View view, float f11) {
    }
}
