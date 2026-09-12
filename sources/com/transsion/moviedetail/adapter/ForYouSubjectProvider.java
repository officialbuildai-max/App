package com.transsion.moviedetail.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.SubjectLayoutStyle;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.LayoutStyle;
import com.transsion.moviedetailapi.bean.Subject;
import ej.f;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class ForYouSubjectProvider extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final Subject f46991e;

    /* renamed from: f, reason: collision with root package name */
    private final int f46992f;

    /* renamed from: g, reason: collision with root package name */
    private final int f46993g = y.e();

    /* renamed from: h, reason: collision with root package name */
    private final float f46994h;

    /* renamed from: i, reason: collision with root package name */
    private final float f46995i;

    public ForYouSubjectProvider(Subject subject, int i11) {
        this.f46991e = subject;
        this.f46992f = i11;
        float a11 = (r2 - a0.a(((i11 - 1) * 8) + 24)) / i11;
        this.f46994h = a11;
        this.f46995i = (a11 * 149.0f) / 107.0f;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 1002;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        LayoutStyle style;
        Subject subject = this.f46991e;
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.MUSIC.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                return R$layout.movie_detail_item_for_you_hor;
            }
        }
        Subject subject2 = this.f46991e;
        String shape = (subject2 == null || (style = subject2.getStyle()) == null) ? null : style.getShape();
        return Intrinsics.c(shape, SubjectLayoutStyle.Horizontal.getValue()) ? R$layout.movie_detail_item_for_you_hor : Intrinsics.c(shape, SubjectLayoutStyle.Square.getValue()) ? R$layout.movie_detail_item_for_you_square : R$layout.movie_detail_item_for_you;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder holder, Subject item) {
        String str;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.b) {
            ((StaggeredGridLayoutManager.b) layoutParams).c(false);
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            if (item.getBuiltIn()) {
                kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new ForYouSubjectProvider$convert$1$1(item, shapeableImageView, null), 3, null);
            } else {
                f.a aVar = ej.f.f62005a;
                Context context = shapeableImageView.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m11 = aVar.m(context);
                Cover cover = item.getCover();
                f.b c11 = m11.g(cover != null ? cover.getUrl() : null).m((int) this.f46994h).c((int) this.f46995i);
                Cover cover2 = item.getCover();
                if (cover2 == null || (str = cover2.getThumbnail()) == null) {
                    str = "";
                }
                c11.l(str).d(shapeableImageView);
            }
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) holder.getViewOrNull(R$id.tv_title);
        if (appCompatTextView != null) {
            appCompatTextView.setText(item.getTitle());
        }
        TextView textView = (TextView) holder.getView(R$id.tv_for_you_corner);
        textView.setText(item.getCorner());
        String corner = item.getCorner();
        textView.setVisibility(corner == null || corner.length() == 0 ? 8 : 0);
    }
}
