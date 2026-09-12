package fw;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;

/* loaded from: classes7.dex */
public final class w implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f63079a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f63080b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f63081c;

    /* renamed from: d, reason: collision with root package name */
    public final EditTextWithClear f63082d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f63083e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f63084f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f63085g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f63086h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f63087i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f63088j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f63089k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f63090l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f63091m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f63092n;

    private w(LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, EditTextWithClear editTextWithClear, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, AppCompatTextView appCompatTextView10, AppCompatTextView appCompatTextView11, AppCompatTextView appCompatTextView12) {
        this.f63079a = linearLayout;
        this.f63080b = appCompatTextView;
        this.f63081c = appCompatTextView2;
        this.f63082d = editTextWithClear;
        this.f63083e = appCompatTextView3;
        this.f63084f = appCompatTextView4;
        this.f63085g = appCompatTextView5;
        this.f63086h = appCompatTextView6;
        this.f63087i = appCompatTextView7;
        this.f63088j = appCompatTextView8;
        this.f63089k = appCompatTextView9;
        this.f63090l = appCompatTextView10;
        this.f63091m = appCompatTextView11;
        this.f63092n = appCompatTextView12;
    }

    public static w a(View view) {
        int i11 = R$id.btn_close;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_custom_host;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.et_custom_host;
                EditTextWithClear editTextWithClear = (EditTextWithClear) g4.b.a(view, i11);
                if (editTextWithClear != null) {
                    i11 = R$id.tv_host_1;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.tv_host_2;
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView4 != null) {
                            i11 = R$id.tv_host_3;
                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView5 != null) {
                                i11 = R$id.tv_host_4;
                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView6 != null) {
                                    i11 = R$id.tv_host_5;
                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView7 != null) {
                                        i11 = R$id.tv_host_6;
                                        AppCompatTextView appCompatTextView8 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView8 != null) {
                                            i11 = R$id.tv_host_7;
                                            AppCompatTextView appCompatTextView9 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView9 != null) {
                                                i11 = R$id.tv_host_8;
                                                AppCompatTextView appCompatTextView10 = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView10 != null) {
                                                    i11 = R$id.tv_host_cur;
                                                    AppCompatTextView appCompatTextView11 = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView11 != null) {
                                                        i11 = R$id.tv_reset;
                                                        AppCompatTextView appCompatTextView12 = (AppCompatTextView) g4.b.a(view, i11);
                                                        if (appCompatTextView12 != null) {
                                                            return new w((LinearLayout) view, appCompatTextView, appCompatTextView2, editTextWithClear, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9, appCompatTextView10, appCompatTextView11, appCompatTextView12);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f63079a;
    }
}
