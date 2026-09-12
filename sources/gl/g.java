package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f63820a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f63821b;

    /* renamed from: c, reason: collision with root package name */
    public final View f63822c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f63823d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f63824e;

    /* renamed from: f, reason: collision with root package name */
    public final TnTextView f63825f;

    private g(FrameLayout frameLayout, ConstraintLayout constraintLayout, View view, AppCompatImageView appCompatImageView, RecyclerView recyclerView, TnTextView tnTextView) {
        this.f63820a = frameLayout;
        this.f63821b = constraintLayout;
        this.f63822c = view;
        this.f63823d = appCompatImageView;
        this.f63824e = recyclerView;
        this.f63825f = tnTextView;
    }

    public static g a(View view) {
        View a11;
        int i11 = R$id.clHeader;
        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
        if (constraintLayout != null && (a11 = g4.b.a(view, (i11 = R$id.divider))) != null) {
            i11 = R$id.ivClose;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.rvGrades;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tvTitle;
                    TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                    if (tnTextView != null) {
                        return new g((FrameLayout) view, constraintLayout, a11, appCompatImageView, recyclerView, tnTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static g c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.dialog_grade_select, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f63820a;
    }
}
