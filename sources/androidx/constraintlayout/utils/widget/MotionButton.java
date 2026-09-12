package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class MotionButton extends AppCompatButton {

    /* renamed from: a, reason: collision with root package name */
    private float f7673a;

    /* renamed from: b, reason: collision with root package name */
    private float f7674b;

    /* renamed from: c, reason: collision with root package name */
    private Path f7675c;

    /* renamed from: d, reason: collision with root package name */
    ViewOutlineProvider f7676d;

    /* renamed from: e, reason: collision with root package name */
    RectF f7677e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), (Math.min(r3, r4) * MotionButton.this.f7673a) / 2.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.f7674b);
        }
    }

    public MotionButton(Context context) {
        super(context);
        this.f7673a = 0.0f;
        this.f7674b = Float.NaN;
        init(context, null);
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7673a = 0.0f;
        this.f7674b = Float.NaN;
        init(context, attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7673a = 0.0f;
        this.f7674b = Float.NaN;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.f7674b;
    }

    public float getRoundPercent() {
        return this.f7673a;
    }

    public void setRound(float f11) {
        if (Float.isNaN(f11)) {
            this.f7674b = f11;
            float f12 = this.f7673a;
            this.f7673a = -1.0f;
            setRoundPercent(f12);
            return;
        }
        boolean z10 = this.f7674b != f11;
        this.f7674b = f11;
        if (f11 != 0.0f) {
            if (this.f7675c == null) {
                this.f7675c = new Path();
            }
            if (this.f7677e == null) {
                this.f7677e = new RectF();
            }
            if (this.f7676d == null) {
                b bVar = new b();
                this.f7676d = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f7677e.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f7675c.reset();
            Path path = this.f7675c;
            RectF rectF = this.f7677e;
            float f13 = this.f7674b;
            path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f11) {
        boolean z10 = this.f7673a != f11;
        this.f7673a = f11;
        if (f11 != 0.0f) {
            if (this.f7675c == null) {
                this.f7675c = new Path();
            }
            if (this.f7677e == null) {
                this.f7677e = new RectF();
            }
            if (this.f7676d == null) {
                a aVar = new a();
                this.f7676d = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f7673a) / 2.0f;
            this.f7677e.set(0.0f, 0.0f, width, height);
            this.f7675c.reset();
            this.f7675c.addRoundRect(this.f7677e, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }
}
