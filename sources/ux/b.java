package ux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.web.R$id;
import com.transsion.web.R$layout;

/* loaded from: classes7.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f77068a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f77069b;

    /* renamed from: c, reason: collision with root package name */
    public final ShapeableImageView f77070c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f77071d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f77072e;

    private b(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, RecyclerView recyclerView, TextView textView) {
        this.f77068a = constraintLayout;
        this.f77069b = appCompatImageView;
        this.f77070c = shapeableImageView;
        this.f77071d = recyclerView;
        this.f77072e = textView;
    }

    public static b a(View view) {
        int i11 = R$id.iv_close;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_share;
            ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
            if (shapeableImageView != null) {
                i11 = R$id.share_list;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tv_share_title;
                    TextView textView = (TextView) g4.b.a(view, i11);
                    if (textView != null) {
                        return new b((ConstraintLayout) view, appCompatImageView, shapeableImageView, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static b c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.dialog_imge_share, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77068a;
    }
}
