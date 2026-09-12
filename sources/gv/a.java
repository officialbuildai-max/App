package gv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.TitleLayout;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;

/* loaded from: classes7.dex */
public final class a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64077a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f64078b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f64079c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleLayout f64080d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f64081e;

    private a(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView, TitleLayout titleLayout, AppCompatTextView appCompatTextView) {
        this.f64077a = constraintLayout;
        this.f64078b = appCompatImageView;
        this.f64079c = recyclerView;
        this.f64080d = titleLayout;
        this.f64081e = appCompatTextView;
    }

    public static a a(View view) {
        int i11 = R$id.ivHeader;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.rv_permissions;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.toolBar;
                TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                if (titleLayout != null) {
                    i11 = R$id.tvNext;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        return new a((ConstraintLayout) view, appCompatImageView, recyclerView, titleLayout, appCompatTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_permissions, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64077a;
    }
}
