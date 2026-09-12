package ms;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv_pugc.base.widget.HorizontalRecyclerview2;
import com.transsion.shorttv_pugc.base.widget.TnTextView;

/* loaded from: classes7.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f69898a;

    /* renamed from: b, reason: collision with root package name */
    public final HorizontalRecyclerview2 f69899b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f69900c;

    /* renamed from: d, reason: collision with root package name */
    public final TnTextView f69901d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f69902e;

    private g(View view, HorizontalRecyclerview2 horizontalRecyclerview2, AppCompatTextView appCompatTextView, TnTextView tnTextView, AppCompatTextView appCompatTextView2) {
        this.f69898a = view;
        this.f69899b = horizontalRecyclerview2;
        this.f69900c = appCompatTextView;
        this.f69901d = tnTextView;
        this.f69902e = appCompatTextView2;
    }

    public static g a(View view) {
        int i11 = R$id.recycler_view;
        HorizontalRecyclerview2 horizontalRecyclerview2 = (HorizontalRecyclerview2) g4.b.a(view, i11);
        if (horizontalRecyclerview2 != null) {
            i11 = R$id.tv_title;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tv_title_trending;
                TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                if (tnTextView != null) {
                    i11 = R$id.tv_view_all;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        return new g(view, horizontalRecyclerview2, appCompatTextView, tnTextView, appCompatTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f69898a;
    }
}
