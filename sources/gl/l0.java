package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.FlowLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class l0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f63896a;

    /* renamed from: b, reason: collision with root package name */
    public final FlowLayout f63897b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f63898c;

    private l0(LinearLayout linearLayout, FlowLayout flowLayout, AppCompatTextView appCompatTextView) {
        this.f63896a = linearLayout;
        this.f63897b = flowLayout;
        this.f63898c = appCompatTextView;
    }

    public static l0 a(View view) {
        int i11 = R$id.flow_layout;
        FlowLayout flowLayout = (FlowLayout) g4.b.a(view, i11);
        if (flowLayout != null) {
            i11 = R$id.tvExpand;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                return new l0((LinearLayout) view, flowLayout, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static l0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.layout_filter_expand_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f63896a;
    }
}
