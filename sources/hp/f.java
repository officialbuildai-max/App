package hp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.CustomHeader;

/* loaded from: classes6.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64877a;

    /* renamed from: b, reason: collision with root package name */
    public final ProgressBar f64878b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f64879c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f64880d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f64881e;

    /* renamed from: f, reason: collision with root package name */
    public final CustomHeader f64882f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f64883g;

    private f(ConstraintLayout constraintLayout, ProgressBar progressBar, RecyclerView recyclerView, LinearLayout linearLayout, LinearLayout linearLayout2, CustomHeader customHeader, TextView textView) {
        this.f64877a = constraintLayout;
        this.f64878b = progressBar;
        this.f64879c = recyclerView;
        this.f64880d = linearLayout;
        this.f64881e = linearLayout2;
        this.f64882f = customHeader;
        this.f64883g = textView;
    }

    public static f a(View view) {
        int i11 = R$id.select_video_loading;
        ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
        if (progressBar != null) {
            i11 = R$id.select_video_recycler;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.sv_lock_view;
                LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                if (linearLayout != null) {
                    i11 = R$id.sv_no_content_view;
                    LinearLayout linearLayout2 = (LinearLayout) g4.b.a(view, i11);
                    if (linearLayout2 != null) {
                        i11 = R$id.sv_title_bar;
                        CustomHeader customHeader = (CustomHeader) g4.b.a(view, i11);
                        if (customHeader != null) {
                            i11 = R$id.sv_tv_grant;
                            TextView textView = (TextView) g4.b.a(view, i11);
                            if (textView != null) {
                                return new f((ConstraintLayout) view, progressBar, recyclerView, linearLayout, linearLayout2, customHeader, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_select_music, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64877a;
    }
}
