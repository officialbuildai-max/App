package fw;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;

/* loaded from: classes7.dex */
public final class r implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f63004a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f63005b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f63006c;

    /* renamed from: d, reason: collision with root package name */
    public final EditTextWithClear f63007d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f63008e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f63009f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f63010g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f63011h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f63012i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f63013j;

    private r(LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, EditTextWithClear editTextWithClear, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8) {
        this.f63004a = linearLayout;
        this.f63005b = appCompatTextView;
        this.f63006c = appCompatTextView2;
        this.f63007d = editTextWithClear;
        this.f63008e = appCompatTextView3;
        this.f63009f = appCompatTextView4;
        this.f63010g = appCompatTextView5;
        this.f63011h = appCompatTextView6;
        this.f63012i = appCompatTextView7;
        this.f63013j = appCompatTextView8;
    }

    public static r a(View view) {
        int i11 = R$id.btn_close;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_custom_brand;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.et_custom_brand;
                EditTextWithClear editTextWithClear = (EditTextWithClear) g4.b.a(view, i11);
                if (editTextWithClear != null) {
                    i11 = R$id.tv_lane_cur;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.tv_lane_infinix;
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView4 != null) {
                            i11 = R$id.tv_lane_itel;
                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView5 != null) {
                                i11 = R$id.tv_lane_samsung;
                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView6 != null) {
                                    i11 = R$id.tv_lane_tecno;
                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView7 != null) {
                                        i11 = R$id.tv_reset;
                                        AppCompatTextView appCompatTextView8 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView8 != null) {
                                            return new r((LinearLayout) view, appCompatTextView, appCompatTextView2, editTextWithClear, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8);
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
        return this.f63004a;
    }
}
