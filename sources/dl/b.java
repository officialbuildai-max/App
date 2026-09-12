package dl;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.baseui.util.j;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.hashtag.a;
import com.transsion.home.hashtag.model.HashTagItem;
import com.transsion.home.hashtag.model.HashTagItemType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import ej.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class b extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final a.InterfaceC0621a f61486e;

    /* renamed from: f, reason: collision with root package name */
    private int f61487f;

    public b(a.InterfaceC0621a callbacks) {
        Intrinsics.h(callbacks, "callbacks");
        this.f61486e = callbacks;
        this.f61487f = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(b bVar, UGCVideo uGCVideo, BaseViewHolder baseViewHolder, View view) {
        bVar.f61486e.a(uGCVideo, baseViewHolder.getBindingAdapterPosition());
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return HashTagItemType.HASHTAG_CARD.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.ugc_item_hashtag_subject;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder holder, HashTagItem item) {
        String str;
        String str2;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        final UGCVideo ugcVideo = item.getUgcVideo();
        if (ugcVideo == null) {
            return;
        }
        a0.a(107.0f);
        a0.a(149.0f);
        boolean z10 = true;
        int a11 = a0.a(((this.f61487f - 1) * 8.0f) + 24.0f);
        int e11 = y.e();
        int i11 = (e11 - a11) / this.f61487f;
        int a12 = a0.a(((r5 - 1) * 8.0f) + 24.0f);
        a0.a(109.0f);
        a0.a(109.0f);
        int i12 = e11 - a12;
        int i13 = i12 / this.f61487f;
        int a13 = a0.a(164.0f);
        int a14 = a0.a(92.0f);
        int i14 = i12 / this.f61487f;
        int i15 = (int) (i14 * ((a14 * 1.0f) / a13));
        ((FrameLayout) holder.getView(R$id.nativeView)).setVisibility(8);
        ((Group) holder.getView(R$id.group)).setVisibility(0);
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getView(R$id.iv_cover);
        View view = holder.getView(R$id.cover_container);
        ugcVideo.getCategory();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = i15;
        ((ViewGroup.MarginLayoutParams) bVar).width = i14;
        view.setLayoutParams(bVar);
        f.b m11 = f.f62005a.m(k());
        Cover cover = ugcVideo.getCover();
        if (cover == null || (str = cover.getUrl()) == null) {
            str = "";
        }
        f.b g11 = m11.g(str);
        Cover cover2 = ugcVideo.getCover();
        if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
            str2 = "";
        }
        g11.l(str2).i(R$color.cl37).m(i14).c(i15).d(shapeableImageView);
        int i16 = R$id.tv_title;
        String title = ugcVideo.getTitle();
        if (title == null) {
            title = "";
        }
        holder.setText(i16, title);
        holder.setText(R$id.tv_views, j.c(ugcVideo.getWatchNum(), k()));
        Long publishTime = ugcVideo.getPublishTime();
        long longValue = publishTime != null ? publishTime.longValue() : 0L;
        String i17 = longValue > 0 ? TimeUtilKt.i(longValue) : "";
        if (i17.length() == 0) {
            holder.setText(R$id.tv_type, "");
            holder.setVisible(R$id.separator, false);
        } else {
            holder.setText(R$id.tv_type, i17);
            holder.setVisible(R$id.separator, true);
        }
        UGCVideoTypeKt.i((ImageView) holder.getView(R$id.iv_res_post_type), ugcVideo, null, 4, null);
        Long duration = ugcVideo.getDuration();
        holder.setText(R$id.tv_duration, TimeUtilKt.q(duration != null ? duration.longValue() : 0L));
        String corner = ugcVideo.getCorner();
        View view2 = holder.getView(R$id.tag_audio);
        TextView textView = (TextView) holder.getView(R$id.tv_audio_tag);
        if (corner != null && !StringsKt.q0(corner)) {
            z10 = false;
        }
        view2.setVisibility(z10 ? 8 : 0);
        String corner2 = ugcVideo.getCorner();
        textView.setText(corner2 != null ? corner2 : "");
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: dl.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                b.A(b.this, ugcVideo, holder, view3);
            }
        });
    }
}
