package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {

    /* renamed from: a, reason: collision with root package name */
    private final l f1766a;

    public AppCompatRatingBar(@NonNull Context context) {
        this(context, null);
    }

    public AppCompatRatingBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.ratingBarStyle);
    }

    public AppCompatRatingBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        f0.a(this, getContext());
        l lVar = new l(this);
        this.f1766a = lVar;
        lVar.c(attributeSet, i11);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        Bitmap b11 = this.f1766a.b();
        if (b11 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b11.getWidth() * getNumStars(), i11, 0), getMeasuredHeight());
        }
    }
}
