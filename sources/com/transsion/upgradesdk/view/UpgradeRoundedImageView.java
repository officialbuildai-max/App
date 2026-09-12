package com.transsion.upgradesdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.upgradesdk.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/upgradesdk/view/UpgradeRoundedImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "upgradesdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class UpgradeRoundedImageView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    public final float f56750a;

    /* renamed from: b, reason: collision with root package name */
    public final float f56751b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f56752c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UpgradeRoundedImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UpgradeRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UpgradeRoundedImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.f56751b = 1.5f;
        Paint paint = new Paint(1);
        this.f56752c = paint;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.UpgradeSdkRoundedImageView);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f56750a = obtainStyledAttributes.getDimension(R$styleable.UpgradeSdkRoundedImageView_cornerRadius, 10.0f);
        obtainStyledAttributes.recycle();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(335544320);
        paint.setStrokeWidth(1.5f);
    }

    public /* synthetic */ UpgradeRoundedImageView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        Path path = new Path();
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f11 = this.f56750a;
        path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
        float f12 = this.f56751b;
        if (f12 > 0.0f) {
            float f13 = f12 / 2.0f;
            RectF rectF2 = new RectF(f13, f13, getWidth() - f13, getHeight() - f13);
            float f14 = this.f56750a;
            canvas.drawRoundRect(rectF2, f14, f14, this.f56752c);
        }
    }
}
