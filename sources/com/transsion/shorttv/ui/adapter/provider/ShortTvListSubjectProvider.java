package com.transsion.shorttv.ui.adapter.provider;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import as.b;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.c0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.shorttv.R$color;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.R$mipmap;
import com.transsion.shorttv.R$string;
import com.transsion.shorttv.bean.Cover;
import com.transsion.shorttv.bean.Subject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class ShortTvListSubjectProvider extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final String f53221e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f53222f;

    public ShortTvListSubjectProvider(String pageName, boolean z10) {
        Intrinsics.h(pageName, "pageName");
        this.f53221e = pageName;
        this.f53222f = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(BaseViewHolder baseViewHolder, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        baseViewHolder.itemView.performClick();
    }

    private final void B(AppCompatImageView appCompatImageView, Subject subject) {
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new ShortTvListSubjectProvider$loadBuiltInCover$1(subject, appCompatImageView, null), 3, null);
    }

    private final void C(AppCompatImageView appCompatImageView, Subject subject) {
        String thumbnail;
        String url;
        b.a aVar = as.b.f16186a;
        Context context = appCompatImageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        Cover cover = subject.getCover();
        String str = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
        int i11 = R$color.short_tv_module_04;
        Cover cover2 = subject.getCover();
        aVar.j(context, appCompatImageView, str, (r30 & 8) != 0 ? aVar.c() : i11, (r30 & 16) != 0 ? aVar.b() : 0, (r30 & 32) != 0, (r30 & 64) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (r30 & 128) != 0, (r30 & 256) != 0, (r30 & 512) != 0 ? false : false, (r30 & 1024) != 0 ? false : false, (r30 & 2048) != 0 ? false : false, (r30 & 4096) != 0 ? 25 : 0);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.short_tv_item_trending;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder holder, xs.a data) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(data, "data");
        Subject b11 = data.b();
        if (b11 == null) {
            return;
        }
        holder.getView(R$id.tv_title_trending).setVisibility(b11.getShowTitle() ? 0 : 8);
        if (b11.getNonAdDelegate() != null) {
            ((FrameLayout) holder.getView(R$id.flAdContainer)).setVisibility(0);
            ((Group) holder.getView(R$id.group)).setVisibility(8);
            ur.b bVar = ur.b.f77013a;
            Context k11 = k();
            BiddingNativeManager nonAdDelegate = b11.getNonAdDelegate();
            com.transsion.ad.bidding.base.r a11 = bVar.a(k11, nonAdDelegate != null ? nonAdDelegate.getMSceneId() : null);
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) holder.getViewOrNull(R$id.flAdContainer);
            if (nativeWrapperAdView != null) {
                BiddingNativeManager nonAdDelegate2 = b11.getNonAdDelegate();
                BiddingNativeManager nonAdDelegate3 = b11.getNonAdDelegate();
                nativeWrapperAdView.bindNativeView(nonAdDelegate2, a11, nonAdDelegate3 != null ? nonAdDelegate3.n0() : null);
                return;
            }
            return;
        }
        ((FrameLayout) holder.getView(R$id.flAdContainer)).setVisibility(8);
        ((Group) holder.getView(R$id.group)).setVisibility(0);
        AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getView(R$id.iv_cover);
        if (b11.getBuiltIn()) {
            B(appCompatImageView, b11);
        } else {
            C(appCompatImageView, b11);
        }
        TextView textView = (TextView) holder.getView(R$id.tv_title);
        textView.setText(b11.getTitle());
        boolean z10 = new StaticLayout(b11.getTitle(), textView.getPaint(), y.e() - a0.a(139.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() > 1;
        TextView textView2 = (TextView) holder.getView(R$id.tv_type);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String releaseDate = b11.getReleaseDate();
        if (releaseDate != null && releaseDate.length() != 0) {
            Date l11 = c0.l(b11.getReleaseDate(), "yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(l11);
            spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
        }
        String[] a12 = com.blankj.utilcode.util.u.a(b11.getGenre(), ",");
        if (a12 != null) {
            for (String str : a12) {
                spannableStringBuilder.append((CharSequence) " · ").append((CharSequence) str);
            }
        }
        String countryName = b11.getCountryName();
        if (countryName != null && countryName.length() != 0) {
            spannableStringBuilder.append((CharSequence) " · ").append((CharSequence) b11.getCountryName());
        }
        textView2.setText(spannableStringBuilder);
        List tags = b11.getTags();
        if (tags == null) {
            tags = new ArrayList();
        }
        RecyclerView recyclerView = (RecyclerView) holder.getView(R$id.rv_list);
        if (tags.isEmpty()) {
            yr.b.b(recyclerView);
        } else {
            com.transsion.shorttv.ui.adapter.s sVar = new com.transsion.shorttv.ui.adapter.s(CollectionsKt.U0(tags));
            sVar.w1(new p6.d() { // from class: com.transsion.shorttv.ui.adapter.provider.g
                @Override // p6.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    ShortTvListSubjectProvider.A(BaseViewHolder.this, baseQuickAdapter, view, i11);
                }
            });
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext());
            flexboxLayoutManager.c0(0);
            flexboxLayoutManager.d0(1);
            flexboxLayoutManager.e0(0);
            recyclerView.setLayoutManager(flexboxLayoutManager);
            if (recyclerView.getItemDecorationCount() <= 0) {
                recyclerView.addItemDecoration(new com.transsion.shorttv.base.widget.f(a0.a(4.0f)));
            }
            recyclerView.setAdapter(sVar);
            yr.b.e(recyclerView);
        }
        TextView textView3 = (TextView) holder.getView(R$id.tv_desc);
        textView3.setMaxLines(z10 ? 1 : 2);
        String str2 = this.f53221e;
        if (Intrinsics.c(str2, "minitv_explore")) {
            textView3.setText(b11.getDescription());
        } else if (Intrinsics.c(str2, "minitv_favorite")) {
            textView3.setText(b11.getTotalEpisode() + " EPs");
        }
        TextView textView4 = (TextView) holder.getView(R$id.btn_download);
        textView4.setText(this.f53222f ? Utils.a().getString(R$string.short_tv_download) : Utils.a().getString(R$string.short_tv_play));
        textView4.setCompoundDrawablesWithIntrinsicBounds(this.f53222f ? R$mipmap.short_tv_ic_download_white : R$mipmap.short_tv_ic_play_white_trending, 0, 0, 0);
    }
}
