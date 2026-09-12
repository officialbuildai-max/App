package so;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* loaded from: classes6.dex */
public final class v implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f75854a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f75855b;

    private v(FrameLayout frameLayout, AppCompatTextView appCompatTextView) {
        this.f75854a = frameLayout;
        this.f75855b = appCompatTextView;
    }

    public static v a(View view) {
        int i11 = R$id.tvHeader;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            return new v((FrameLayout) view, appCompatTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static v c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.item_feedback_input_header, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f75854a;
    }
}
