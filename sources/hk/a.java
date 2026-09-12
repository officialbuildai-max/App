package hk;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private Spannable f64634a;

    public a(Spannable spannable) {
        this.f64634a = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View textView, MotionEvent event) {
        Intrinsics.h(textView, "textView");
        Intrinsics.h(event, "event");
        int action = event.getAction();
        if (!(textView instanceof TextView)) {
            return false;
        }
        if (action == 0 || action == 1) {
            float x10 = event.getX();
            float totalPaddingLeft = (x10 - r4.getTotalPaddingLeft()) + textView.getScrollX();
            float y10 = (event.getY() - r4.getTotalPaddingTop()) + textView.getScrollY();
            Layout layout = ((TextView) textView).getLayout();
            Intrinsics.g(layout, "getLayout(...)");
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) y10), totalPaddingLeft);
            Spannable spannable = this.f64634a;
            ClickableSpan[] clickableSpanArr = spannable != null ? (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class) : null;
            if (!(clickableSpanArr.length == 0)) {
                if (action == 0) {
                    Spannable spannable2 = this.f64634a;
                    if (spannable2 != null) {
                        int spanStart = spannable2.getSpanStart(clickableSpanArr[0]);
                        Spannable spannable3 = this.f64634a;
                        if (spannable3 != null) {
                            try {
                                Selection.setSelection(this.f64634a, spanStart, spannable3.getSpanEnd(clickableSpanArr[0]));
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } else if (action == 1) {
                    clickableSpanArr[0].onClick(textView);
                }
                return true;
            }
            Selection.removeSelection(this.f64634a);
        }
        return false;
    }
}
