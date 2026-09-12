package androidx.compose.ui.focus;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.focus.b;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;

/* loaded from: classes.dex */
public abstract class f {
    public static final y.i a(View view) {
        int[] a11 = e.f4323a.a();
        view.getLocationInWindow(a11);
        int i11 = a11[0];
        return new y.i(i11, a11[1], i11 + view.getWidth(), a11[1] + view.getHeight());
    }

    public static final boolean b(View view, Integer num, Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (!(view instanceof ViewGroup)) {
            return view.requestFocus(num.intValue(), rect);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isFocused()) {
            return true;
        }
        if ((!viewGroup.isFocusable() || view.hasFocus()) && !(view instanceof AndroidComposeView)) {
            if (rect != null) {
                View findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
                return findNextFocusFromRect != null ? findNextFocusFromRect.requestFocus(num.intValue(), rect) : view.requestFocus(num.intValue(), rect);
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, view.hasFocus() ? view.findFocus() : null, num.intValue());
            return findNextFocus != null ? findNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
        }
        return view.requestFocus(num.intValue(), rect);
    }

    public static final Integer c(int i11) {
        b.a aVar = b.f4312b;
        if (b.l(i11, aVar.h())) {
            return 33;
        }
        if (b.l(i11, aVar.a())) {
            return 130;
        }
        if (b.l(i11, aVar.d())) {
            return 17;
        }
        if (b.l(i11, aVar.g())) {
            return 66;
        }
        if (b.l(i11, aVar.e())) {
            return 2;
        }
        return b.l(i11, aVar.f()) ? 1 : null;
    }

    public static final b d(int i11) {
        if (i11 == 1) {
            return b.i(b.f4312b.f());
        }
        if (i11 == 2) {
            return b.i(b.f4312b.e());
        }
        if (i11 == 17) {
            return b.i(b.f4312b.d());
        }
        if (i11 == 33) {
            return b.i(b.f4312b.h());
        }
        if (i11 == 66) {
            return b.i(b.f4312b.g());
        }
        if (i11 != 130) {
            return null;
        }
        return b.i(b.f4312b.a());
    }

    public static final LayoutDirection e(int i11) {
        if (i11 == 0) {
            return LayoutDirection.Ltr;
        }
        if (i11 != 1) {
            return null;
        }
        return LayoutDirection.Rtl;
    }
}
