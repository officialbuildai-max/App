package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes.dex */
public class Placeholder extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f7800a;

    /* renamed from: b, reason: collision with root package name */
    private View f7801b;

    /* renamed from: c, reason: collision with root package name */
    private int f7802c;

    public Placeholder(Context context) {
        super(context);
        this.f7800a = -1;
        this.f7801b = null;
        this.f7802c = 4;
        a(null);
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7800a = -1;
        this.f7801b = null;
        this.f7802c = 4;
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7800a = -1;
        this.f7801b = null;
        this.f7802c = 4;
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        this.f7800a = -1;
        this.f7801b = null;
        this.f7802c = 4;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        super.setVisibility(this.f7802c);
        this.f7800a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_placeholder_content) {
                    this.f7800a = obtainStyledAttributes.getResourceId(index, this.f7800a);
                } else if (index == R$styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.f7802c = obtainStyledAttributes.getInt(index, this.f7802c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public View getContent() {
        return this.f7801b;
    }

    public int getEmptyVisibility() {
        return this.f7802c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE);
            Paint paint = new Paint();
            paint.setARGB(255, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds(UrlUtils.QUESTION_MARK, 0, 1, rect);
            canvas.drawText(UrlUtils.QUESTION_MARK, ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i11) {
        View findViewById;
        if (this.f7800a == i11) {
            return;
        }
        View view = this.f7801b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.b) this.f7801b.getLayoutParams()).f7756j0 = false;
            this.f7801b = null;
        }
        this.f7800a = i11;
        if (i11 == -1 || (findViewById = ((View) getParent()).findViewById(i11)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i11) {
        this.f7802c = i11;
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
        if (this.f7801b == null) {
            return;
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f7801b.getLayoutParams();
        bVar2.f7780v0.n1(0);
        ConstraintWidget.DimensionBehaviour C = bVar.f7780v0.C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        if (C != dimensionBehaviour) {
            bVar.f7780v0.o1(bVar2.f7780v0.Y());
        }
        if (bVar.f7780v0.V() != dimensionBehaviour) {
            bVar.f7780v0.P0(bVar2.f7780v0.z());
        }
        bVar2.f7780v0.n1(8);
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        if (this.f7800a == -1 && !isInEditMode()) {
            setVisibility(this.f7802c);
        }
        View findViewById = constraintLayout.findViewById(this.f7800a);
        this.f7801b = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.b) findViewById.getLayoutParams()).f7756j0 = true;
            this.f7801b.setVisibility(0);
            setVisibility(0);
        }
    }
}
