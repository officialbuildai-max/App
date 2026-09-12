package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.TitleLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final NestedScrollView f16789a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatEditText f16790b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatEditText f16791c;

    /* renamed from: d, reason: collision with root package name */
    public final ShapeableImageView f16792d;

    /* renamed from: e, reason: collision with root package name */
    public final TitleLayout f16793e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f16794f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f16795g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f16796h;

    private a(NestedScrollView nestedScrollView, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, ShapeableImageView shapeableImageView, TitleLayout titleLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f16789a = nestedScrollView;
        this.f16790b = appCompatEditText;
        this.f16791c = appCompatEditText2;
        this.f16792d = shapeableImageView;
        this.f16793e = titleLayout;
        this.f16794f = appCompatTextView;
        this.f16795g = appCompatTextView2;
        this.f16796h = appCompatTextView3;
    }

    public static a a(View view) {
        int i11 = R$id.et_community_desc;
        AppCompatEditText appCompatEditText = (AppCompatEditText) g4.b.a(view, i11);
        if (appCompatEditText != null) {
            i11 = R$id.et_community_name;
            AppCompatEditText appCompatEditText2 = (AppCompatEditText) g4.b.a(view, i11);
            if (appCompatEditText2 != null) {
                i11 = R$id.iv_avatar;
                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                if (shapeableImageView != null) {
                    i11 = R$id.tool_bar;
                    TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                    if (titleLayout != null) {
                        i11 = R$id.tv_comfirm;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tv_desc;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView2 != null) {
                                i11 = R$id.tv_name;
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView3 != null) {
                                    return new a((NestedScrollView) view, appCompatEditText, appCompatEditText2, shapeableImageView, titleLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
                                }
                            }
                        }
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
        View inflate = layoutInflater.inflate(R$layout.activity_create_room, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f16789a;
    }
}
