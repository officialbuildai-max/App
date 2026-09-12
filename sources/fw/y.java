package fw;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;

/* loaded from: classes7.dex */
public final class y implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f63113a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f63114b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f63115c;

    /* renamed from: d, reason: collision with root package name */
    public final EditTextWithClear f63116d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f63117e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f63118f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f63119g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f63120h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f63121i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f63122j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f63123k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f63124l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f63125m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f63126n;

    /* renamed from: o, reason: collision with root package name */
    public final AppCompatTextView f63127o;

    private y(LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, EditTextWithClear editTextWithClear, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, AppCompatTextView appCompatTextView10, AppCompatTextView appCompatTextView11, AppCompatTextView appCompatTextView12, AppCompatTextView appCompatTextView13) {
        this.f63113a = linearLayout;
        this.f63114b = appCompatTextView;
        this.f63115c = appCompatTextView2;
        this.f63116d = editTextWithClear;
        this.f63117e = appCompatTextView3;
        this.f63118f = appCompatTextView4;
        this.f63119g = appCompatTextView5;
        this.f63120h = appCompatTextView6;
        this.f63121i = appCompatTextView7;
        this.f63122j = appCompatTextView8;
        this.f63123k = appCompatTextView9;
        this.f63124l = appCompatTextView10;
        this.f63125m = appCompatTextView11;
        this.f63126n = appCompatTextView12;
        this.f63127o = appCompatTextView13;
    }

    public static y a(View view) {
        int i11 = R$id.btn_close;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_custom_lane;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.et_custom_lane;
                EditTextWithClear editTextWithClear = (EditTextWithClear) g4.b.a(view, i11);
                if (editTextWithClear != null) {
                    i11 = R$id.tv_lane_1;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.tv_lane_2;
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView4 != null) {
                            i11 = R$id.tv_lane_3;
                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView5 != null) {
                                i11 = R$id.tv_lane_4;
                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView6 != null) {
                                    i11 = R$id.tv_lane_5;
                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView7 != null) {
                                        i11 = R$id.tv_lane_6;
                                        AppCompatTextView appCompatTextView8 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView8 != null) {
                                            i11 = R$id.tv_lane_7;
                                            AppCompatTextView appCompatTextView9 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView9 != null) {
                                                i11 = R$id.tv_lane_8;
                                                AppCompatTextView appCompatTextView10 = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView10 != null) {
                                                    i11 = R$id.tv_lane_9;
                                                    AppCompatTextView appCompatTextView11 = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView11 != null) {
                                                        i11 = R$id.tv_lane_cur;
                                                        AppCompatTextView appCompatTextView12 = (AppCompatTextView) g4.b.a(view, i11);
                                                        if (appCompatTextView12 != null) {
                                                            i11 = R$id.tv_reset;
                                                            AppCompatTextView appCompatTextView13 = (AppCompatTextView) g4.b.a(view, i11);
                                                            if (appCompatTextView13 != null) {
                                                                return new y((LinearLayout) view, appCompatTextView, appCompatTextView2, editTextWithClear, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9, appCompatTextView10, appCompatTextView11, appCompatTextView12, appCompatTextView13);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f63113a;
    }
}
