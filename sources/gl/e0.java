package gl;

import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.tabs.TabLayout;
import com.transsion.home.R$id;
import com.transsion.home.view.filter.expand.FilterExpandView;
import com.transsion.home.view.filter.expand.TabExpandView;

/* loaded from: classes6.dex */
public final class e0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63807a;

    /* renamed from: b, reason: collision with root package name */
    public final TabExpandView f63808b;

    /* renamed from: c, reason: collision with root package name */
    public final FilterExpandView f63809c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f63810d;

    /* renamed from: e, reason: collision with root package name */
    public final ViewStub f63811e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewStub f63812f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewStub f63813g;

    /* renamed from: h, reason: collision with root package name */
    public final TabLayout f63814h;

    private e0(ConstraintLayout constraintLayout, TabExpandView tabExpandView, FilterExpandView filterExpandView, ConstraintLayout constraintLayout2, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, TabLayout tabLayout) {
        this.f63807a = constraintLayout;
        this.f63808b = tabExpandView;
        this.f63809c = filterExpandView;
        this.f63810d = constraintLayout2;
        this.f63811e = viewStub;
        this.f63812f = viewStub2;
        this.f63813g = viewStub3;
        this.f63814h = tabLayout;
    }

    public static e0 a(View view) {
        int i11 = R$id.channelExpand;
        TabExpandView tabExpandView = (TabExpandView) g4.b.a(view, i11);
        if (tabExpandView != null) {
            i11 = R$id.filterExpand;
            FilterExpandView filterExpandView = (FilterExpandView) g4.b.a(view, i11);
            if (filterExpandView != null) {
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
                                    return new e0((ConstraintLayout) view, tabExpandView, filterExpandView, constraintLayout, viewStub, viewStub2, viewStub3, tabLayout);
                                }
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
        return this.f63807a;
    }
}
