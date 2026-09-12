package bq;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.room.R$id;

/* loaded from: classes5.dex */
public final class k implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16863a;

    /* renamed from: b, reason: collision with root package name */
    public final View f16864b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f16865c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f16866d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f16867e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f16868f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f16869g;

    private k(ConstraintLayout constraintLayout, View view, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f16863a = constraintLayout;
        this.f16864b = view;
        this.f16865c = appCompatImageView;
        this.f16866d = appCompatImageView2;
        this.f16867e = appCompatTextView;
        this.f16868f = appCompatTextView2;
        this.f16869g = appCompatTextView3;
    }

    public static k a(View view) {
        int i11 = R$id.btn_top;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            i11 = R$id.iv_back;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_icon;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.tvAdWatchAVideo;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_tips;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.tv_title;
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView3 != null) {
                                return new k((ConstraintLayout) view, a11, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2, appCompatTextView3);
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
        return this.f16863a;
    }
}
