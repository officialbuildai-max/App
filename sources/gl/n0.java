package gl;

import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.tabs.TabLayout;
import com.transsion.home.R$id;
import com.transsion.home.view.filter.expand.UGCFilterExpandView;

/* loaded from: classes6.dex */
public final class n0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63916a;

    /* renamed from: b, reason: collision with root package name */
    public final UGCFilterExpandView f63917b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f63918c;

    /* renamed from: d, reason: collision with root package name */
    public final ViewStub f63919d;

    /* renamed from: e, reason: collision with root package name */
    public final ViewStub f63920e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewStub f63921f;

    /* renamed from: g, reason: collision with root package name */
    public final TabLayout f63922g;

    private n0(ConstraintLayout constraintLayout, UGCFilterExpandView uGCFilterExpandView, ConstraintLayout constraintLayout2, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, TabLayout tabLayout) {
        this.f63916a = constraintLayout;
        this.f63917b = uGCFilterExpandView;
        this.f63918c = constraintLayout2;
        this.f63919d = viewStub;
        this.f63920e = viewStub2;
        this.f63921f = viewStub3;
        this.f63922g = tabLayout;
    }

    public static n0 a(View view) {
        int i11 = R$id.filterExpand;
        UGCFilterExpandView uGCFilterExpandView = (UGCFilterExpandView) g4.b.a(view, i11);
        if (uGCFilterExpandView != null) {
            i11 = R$id.ll_tab_movie;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.loading_stub;
                ViewStub viewStub = (ViewStub) g4.b.a(view, i11);
                if (viewStub != null) {
                    i11 = R$id.no_network_stub;
                    ViewStub viewStub2 = (ViewStub) g4.b.a(view, i11);
                    if (viewStub2 != null) {
                        i11 = R$id.no_result_stub;
                        ViewStub viewStub3 = (ViewStub) g4.b.a(view, i11);
                        if (viewStub3 != null) {
                            i11 = R$id.tab_movie;
                            TabLayout tabLayout = (TabLayout) g4.b.a(view, i11);
                            if (tabLayout != null) {
                                return new n0((ConstraintLayout) view, uGCFilterExpandView, constraintLayout, viewStub, viewStub2, viewStub3, tabLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63916a;
    }
}
