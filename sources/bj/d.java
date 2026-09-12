package bj;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.audio.R$id;

/* loaded from: classes5.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16646a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f16647b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f16648c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f16649d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f16650e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f16651f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f16652g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f16653h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f16654i;

    /* renamed from: j, reason: collision with root package name */
    public final ProgressBar f16655j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f16656k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f16657l;

    private d(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, ProgressBar progressBar, TextView textView, TextView textView2) {
        this.f16646a = constraintLayout;
        this.f16647b = constraintLayout2;
        this.f16648c = constraintLayout3;
        this.f16649d = constraintLayout4;
        this.f16650e = appCompatImageView;
        this.f16651f = appCompatImageView2;
        this.f16652g = appCompatImageView3;
        this.f16653h = appCompatImageView4;
        this.f16654i = appCompatImageView5;
        this.f16655j = progressBar;
        this.f16656k = textView;
        this.f16657l = textView2;
    }

    public static d a(View view) {
        int i11 = R$id.clExpansion;
        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.clPackUp;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout2 != null) {
                ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                i11 = R$id.iv_history;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.iv_next;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.ivPackUp;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView3 != null) {
                            i11 = R$id.iv_play;
                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView4 != null) {
                                i11 = R$id.iv_remove;
                                AppCompatImageView appCompatImageView5 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView5 != null) {
                                    i11 = R$id.pbSubject;
                                    ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                                    if (progressBar != null) {
                                        i11 = R$id.tvAudioName;
                                        TextView textView = (TextView) g4.b.a(view, i11);
                                        if (textView != null) {
                                            i11 = R$id.tvAudioTime;
                                            TextView textView2 = (TextView) g4.b.a(view, i11);
                                            if (textView2 != null) {
                                                return new d(constraintLayout3, constraintLayout, constraintLayout2, constraintLayout3, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, progressBar, textView, textView2);
                                            }
                                        }
                                    }
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
        return this.f16646a;
    }
}
