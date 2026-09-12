package ym;

import android.text.TextPaint;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f79164a = new a();

    /* renamed from: ym.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class ViewOnLayoutChangeListenerC0998a implements View.OnLayoutChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f79165a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f79166b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f79167c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f79168d;

        public ViewOnLayoutChangeListenerC0998a(TextView textView, int i11, int i12, int i13) {
            this.f79165a = textView;
            this.f79166b = i11;
            this.f79167c = i12;
            this.f79168d = i13;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            CharSequence text;
            view.removeOnLayoutChangeListener(this);
            int width = (this.f79165a.getWidth() - this.f79165a.getPaddingLeft()) - this.f79165a.getPaddingRight();
            if (width <= 0 || (text = this.f79165a.getText()) == null || text.length() == 0) {
                return;
            }
            TextPaint textPaint = new TextPaint(this.f79165a.getPaint());
            int i19 = this.f79166b;
            while (i19 > this.f79167c) {
                textPaint.setTextSize(TypedValue.applyDimension(2, i19, this.f79165a.getResources().getDisplayMetrics()));
                if (textPaint.measureText(this.f79165a.getText(), 0, this.f79165a.getText().length()) <= width) {
                    break;
                } else {
                    i19 -= this.f79168d;
                }
            }
            this.f79165a.setTextSize(2, i19);
        }
    }

    private a() {
    }

    public static /* synthetic */ void b(a aVar, TextView textView, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i11 = 40;
        }
        if ((i14 & 4) != 0) {
            i12 = 10;
        }
        if ((i14 & 8) != 0) {
            i13 = 1;
        }
        aVar.a(textView, i11, i12, i13);
    }

    public final void a(TextView textView, int i11, int i12, int i13) {
        CharSequence text;
        Intrinsics.h(textView, "textView");
        if (i11 < i12) {
            throw new IllegalArgumentException("maxTextSizeSp must be greater than or equal to minTextSizeSp");
        }
        if (i12 <= 0 || i13 <= 0) {
            throw new IllegalArgumentException("minTextSizeSp and stepGranularitySp must be greater than 0");
        }
        if (!textView.isLaidOut() || textView.isLayoutRequested()) {
            textView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0998a(textView, i11, i12, i13));
            return;
        }
        int width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
        if (width <= 0 || (text = textView.getText()) == null || text.length() == 0) {
            return;
        }
        TextPaint textPaint = new TextPaint(textView.getPaint());
        while (i11 > i12) {
            textPaint.setTextSize(TypedValue.applyDimension(2, i11, textView.getResources().getDisplayMetrics()));
            if (textPaint.measureText(textView.getText(), 0, textView.getText().length()) <= width) {
                break;
            } else {
                i11 -= i13;
            }
        }
        textView.setTextSize(2, i11);
    }
}
