package gl;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.tabs.TabLayout;
import com.transsion.home.R$id;

/* loaded from: classes6.dex */
public final class g0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63826a;

    /* renamed from: b, reason: collision with root package name */
    public final View f63827b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f63828c;

    /* renamed from: d, reason: collision with root package name */
    public final TabLayout f63829d;

    private g0(ConstraintLayout constraintLayout, View view, ConstraintLayout constraintLayout2, TabLayout tabLayout) {
        this.f63826a = constraintLayout;
        this.f63827b = view;
        this.f63828c = constraintLayout2;
        this.f63829d = tabLayout;
    }

    public static g0 a(View view) {
        int i11 = R$id.divider;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i12 = R$id.tab_movie;
            TabLayout tabLayout = (TabLayout) g4.b.a(view, i12);
            if (tabLayout != null) {
                return new g0(constraintLayout, a11, constraintLayout, tabLayout);
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63826a;
    }
}
