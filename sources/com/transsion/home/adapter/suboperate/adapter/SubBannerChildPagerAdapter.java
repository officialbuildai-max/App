package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.hisavana.common.bean.TAdNativeInfo;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.home.R$drawable;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.suboperate.adapter.SubBannerChildPagerAdapter;
import com.transsion.home.adapter.trending.BannerADDataHelper;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import ej.f;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class SubBannerChildPagerAdapter extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private List f44490a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44491b;

    /* renamed from: c, reason: collision with root package name */
    private final OperateItem f44492c;

    /* renamed from: d, reason: collision with root package name */
    private final int f44493d;

    /* renamed from: e, reason: collision with root package name */
    private final int f44494e;

    /* loaded from: classes5.dex */
    public static final class SubViewPagerViewHolder extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final int f44495a;

        /* renamed from: b, reason: collision with root package name */
        private final OperateItem f44496b;

        /* renamed from: c, reason: collision with root package name */
        private final ImageView f44497c;

        /* renamed from: d, reason: collision with root package name */
        private final ImageView f44498d;

        /* renamed from: e, reason: collision with root package name */
        private final TextView f44499e;

        /* renamed from: f, reason: collision with root package name */
        private final TextView f44500f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubViewPagerViewHolder(View itemView, int i11, OperateItem operateItem) {
            super(itemView);
            Intrinsics.h(itemView, "itemView");
            Intrinsics.h(operateItem, "operateItem");
            this.f44495a = i11;
            this.f44496b = operateItem;
            View findViewById = itemView.findViewById(R$id.contentIV);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.f44497c = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R$id.playIV);
            Intrinsics.g(findViewById2, "findViewById(...)");
            this.f44498d = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R$id.titleTV);
            Intrinsics.g(findViewById3, "findViewById(...)");
            this.f44499e = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R$id.desTV);
            Intrinsics.g(findViewById4, "findViewById(...)");
            this.f44500f = (TextView) findViewById4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(BannerData bannerData, SubViewPagerViewHolder subViewPagerViewHolder, int i11, View it) {
            Intrinsics.h(it, "it");
            String deepLink = bannerData.getDeepLink();
            if (deepLink != null) {
                if (!nh.m.f70597a.e()) {
                    uh.b.f76876a.d(R$string.no_network_toast);
                    return Unit.f67184a;
                }
                Uri g11 = com.transsion.baselib.helper.b.f43318a.g(Uri.parse(deepLink + "&module_name=opt_banner_free&autoPlay=true&ops=" + bannerData.getOps()));
                if (g11 != null) {
                    ak.k.o(g11);
                }
                subViewPagerViewHolder.j(bannerData, i11, DownloadManagerApi.x0(DownloadManagerApi.f58521j.a(), bannerData.getSubjectId(), null, false, false, 12, null) ? "play_subject" : "download_subject");
            }
            return Unit.f67184a;
        }

        private final SpannableString i(Subject subject) {
            int indexOf;
            List R0;
            StringBuilder sb2 = new StringBuilder();
            String releaseDate = subject.getReleaseDate();
            String genre = subject.getGenre();
            String str = (genre == null || (R0 = StringsKt.R0(genre, new char[]{','}, false, 0, 6, null)) == null) ? null : (String) CollectionsKt.k0(R0);
            if (releaseDate != null && releaseDate.length() != 0) {
                sb2.append(" | ");
                sb2.append(releaseDate);
            }
            if (str != null) {
                sb2.append(" | ");
                sb2.append(str);
            }
            SpannableString spannableString = new SpannableString(sb2);
            if (releaseDate != null && releaseDate.length() != 0) {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_20));
                ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_60));
                spannableString.setSpan(foregroundColorSpan, 0, 3, 17);
                spannableString.setSpan(foregroundColorSpan2, 3, releaseDate.length() + 3, 17);
            }
            if (str != null && (indexOf = sb2.indexOf(str)) >= 3) {
                ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_20));
                ForegroundColorSpan foregroundColorSpan4 = new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_60));
                spannableString.setSpan(foregroundColorSpan3, indexOf - 3, indexOf, 17);
                spannableString.setSpan(foregroundColorSpan4, indexOf, sb2.length(), 17);
            }
            return spannableString;
        }

        private final void j(BannerData bannerData, int i11, String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "click_banner_poster");
            hashMap.put("sequence", String.valueOf(i11));
            hashMap.put("module_name", str);
            hashMap.put("tabId", String.valueOf(this.f44495a));
            if (bannerData != null) {
                il.b.c(bannerData, hashMap);
            }
            il.b.a(this.f44496b, hashMap);
            com.transsion.baselib.helper.a.f43316a.f(SubTabFragment.INSTANCE.a(this.f44495a), hashMap);
        }

        private final void k(BannerData bannerData, ImageView imageView) {
            if (!(bannerData != null ? Intrinsics.c(bannerData.getHasResource(), Boolean.TRUE) : false)) {
                imageView.setImageResource(R$drawable.ic_trending_arrow);
            } else if (!ak.t.f727a.b() || bannerData.getSubjectType() == SubjectType.SHORT_TV.getValue()) {
                imageView.setImageResource(R$drawable.ic_trending_download);
            } else {
                imageView.setImageResource(R$drawable.ic_trending_play);
            }
        }

        public final void g(final BannerData bannerData, final int i11) {
            String url;
            String thumbnail;
            Cover cover;
            Cover cover2;
            Intrinsics.h(bannerData, "bannerData");
            Subject subject = bannerData.getSubject();
            if (subject == null || (cover2 = subject.getCover()) == null || (url = cover2.getUrl()) == null) {
                Image image = bannerData.getImage();
                url = image != null ? image.getUrl() : null;
            }
            Subject subject2 = bannerData.getSubject();
            if (subject2 == null || (cover = subject2.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) {
                Image image2 = bannerData.getImage();
                thumbnail = image2 != null ? image2.getThumbnail() : null;
            }
            if (bannerData.getBuiltIn()) {
                kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1(url, this, null), 3, null);
            } else {
                f.a aVar = ej.f.f62005a;
                Context context = this.f44497c.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m11 = aVar.m(context);
                if (url == null) {
                    url = "";
                }
                f.b g11 = m11.g(url);
                if (thumbnail == null) {
                    thumbnail = "";
                }
                g11.l(thumbnail).i(R$mipmap.ic_img_placeholder).m(dk.a.b(40)).c(dk.a.b(56)).d(this.f44497c);
            }
            this.itemView.setClickable(false);
            Subject subject3 = bannerData.getSubject();
            if (subject3 != null) {
                TextView textView = this.f44499e;
                String title = subject3.getTitle();
                textView.setText(title != null ? title : "");
                SpannableString i12 = i(subject3);
                if (i12.length() > 0) {
                    this.f44500f.setText(i12);
                    this.f44500f.setCompoundDrawablesWithIntrinsicBounds(com.transsion.moviedetailapi.g.a(subject3.getSubjectType()), 0, 0, 0);
                }
            }
            if (bannerData.getSubject() == null) {
                this.f44499e.setText(bannerData.getContent());
                this.f44500f.setText((CharSequence) null);
            }
            CharSequence text = this.f44500f.getText();
            if (text == null || text.length() == 0) {
                this.f44500f.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            TextView textView2 = this.f44500f;
            CharSequence text2 = textView2.getText();
            textView2.setVisibility(text2 == null || text2.length() == 0 ? 8 : 0);
            View itemView = this.itemView;
            Intrinsics.g(itemView, "itemView");
            jg.c.c(itemView, 0L, new Function1() { // from class: com.transsion.home.adapter.suboperate.adapter.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit h11;
                    h11 = SubBannerChildPagerAdapter.SubViewPagerViewHolder.h(BannerData.this, this, i11, (View) obj);
                    return h11;
                }
            }, 1, null);
            k(bannerData, this.f44498d);
        }

        public final ImageView getImageView() {
            return this.f44497c;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final ImageView f44501a;

        /* renamed from: b, reason: collision with root package name */
        private final ImageView f44502b;

        /* renamed from: c, reason: collision with root package name */
        private final ImageView f44503c;

        /* renamed from: d, reason: collision with root package name */
        private final TextView f44504d;

        /* renamed from: e, reason: collision with root package name */
        private final TextView f44505e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.h(itemView, "itemView");
            View findViewById = itemView.findViewById(R$id.iconBg);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.f44501a = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R$id.contentIV);
            Intrinsics.g(findViewById2, "findViewById(...)");
            this.f44502b = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R$id.playIV);
            Intrinsics.g(findViewById3, "findViewById(...)");
            this.f44503c = (ImageView) findViewById3;
            View findViewById4 = itemView.findViewById(R$id.titleTV);
            Intrinsics.g(findViewById4, "findViewById(...)");
            this.f44504d = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R$id.desTV);
            Intrinsics.g(findViewById5, "findViewById(...)");
            this.f44505e = (TextView) findViewById5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit i(View it) {
            Intrinsics.h(it, "it");
            BannerADDataHelper.f44708a.l();
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit j(AdMaterialList adMaterialList, AdPlans adPlans, View it) {
            Intrinsics.h(it, "it");
            com.transsion.ad.strategy.b.f42281a.a(adMaterialList != null ? adMaterialList.getDeeplink() : null, adMaterialList != null ? adMaterialList.getH5Link() : null, adPlans);
            return Unit.f67184a;
        }

        public final void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            final AdPlans plans;
            String str;
            String thumbnail;
            if (biddingIntermediateMaterialBean == null || (plans = biddingIntermediateMaterialBean.getPlans()) == null) {
                return;
            }
            TAdNativeInfo nativeInfo = biddingIntermediateMaterialBean.getNativeInfo();
            if (nativeInfo != null) {
                this.f44504d.setText(nativeInfo.getTitle());
                this.f44505e.setText(nativeInfo.getDescription());
                RequestManager with = Glide.with(this.f44501a.getContext());
                TAdNativeInfo.Image icon = nativeInfo.getIcon();
                with.load2(icon != null ? icon.getUrl() : null).transform(new hg.a(50, 8, true)).into(this.f44501a);
                this.f44502b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                RequestManager with2 = Glide.with(this.f44502b.getContext());
                TAdNativeInfo.Image icon2 = nativeInfo.getIcon();
                with2.load2(icon2 != null ? icon2.getUrl() : null).placeholder(R$mipmap.ic_img_placeholder).into(this.f44502b);
                this.f44503c.setImageResource(R$drawable.ic_trending_arrow);
                View itemView = this.itemView;
                Intrinsics.g(itemView, "itemView");
                jg.c.c(itemView, 0L, new Function1() { // from class: com.transsion.home.adapter.suboperate.adapter.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit i11;
                        i11 = SubBannerChildPagerAdapter.a.i((View) obj);
                        return i11;
                    }
                }, 1, null);
                return;
            }
            com.transsion.ad.monopoly.plan.b bVar = com.transsion.ad.monopoly.plan.b.f42223a;
            AdMaterialList c11 = bVar.c(plans);
            MbAdImage a11 = bVar.a(plans);
            this.f44502b.setImageResource(R$mipmap.ic_img_placeholder);
            f.a aVar = ej.f.f62005a;
            Context context = this.f44502b.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m11 = aVar.m(context);
            String str2 = "";
            if (a11 == null || (str = a11.getUrl()) == null) {
                str = "";
            }
            f.b g11 = m11.g(str);
            if (a11 != null && (thumbnail = a11.getThumbnail()) != null) {
                str2 = thumbnail;
            }
            g11.l(str2).i(R$mipmap.ic_img_placeholder).m(dk.a.b(40)).c(dk.a.b(56)).d(this.f44502b);
            this.f44502b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f44504d.setText(c11 != null ? c11.getTitle() : null);
            this.f44505e.setText(c11 != null ? c11.getDesc() : null);
            this.f44505e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.f44503c.setImageResource(R$drawable.ic_trending_arrow);
            final AdMaterialList c12 = bVar.c(plans);
            View itemView2 = this.itemView;
            Intrinsics.g(itemView2, "itemView");
            jg.c.c(itemView2, 0L, new Function1() { // from class: com.transsion.home.adapter.suboperate.adapter.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit j11;
                    j11 = SubBannerChildPagerAdapter.a.j(AdMaterialList.this, plans, (View) obj);
                    return j11;
                }
            }, 1, null);
        }
    }

    public SubBannerChildPagerAdapter(List banners, int i11, OperateItem operateItem) {
        Intrinsics.h(banners, "banners");
        Intrinsics.h(operateItem, "operateItem");
        this.f44490a = banners;
        this.f44491b = i11;
        this.f44492c = operateItem;
        this.f44494e = 1;
    }

    private final BannerData g(int i11) {
        int size;
        if (!this.f44490a.isEmpty() && (size = i11 % this.f44490a.size()) >= 0 && size < this.f44490a.size()) {
            return (BannerData) this.f44490a.get(size);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        BannerData g11 = g(i11);
        return (g11 != null ? g11.getBiddingAdData() : null) != null ? this.f44494e : this.f44493d;
    }

    public final void h(List list) {
        Intrinsics.h(list, "<set-?>");
        this.f44490a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.b0 holder, int i11) {
        Intrinsics.h(holder, "holder");
        if (this.f44490a.isEmpty()) {
            return;
        }
        int size = i11 % this.f44490a.size();
        BannerData bannerData = (BannerData) this.f44490a.get(size);
        if (bannerData == null) {
            return;
        }
        if (holder instanceof a) {
            ((a) holder).h(bannerData.getBiddingAdData());
        } else if (holder instanceof SubViewPagerViewHolder) {
            ((SubViewPagerViewHolder) holder).g(bannerData, size);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.b0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_sub_top_banner_card, parent, false);
        if (i11 == this.f44494e) {
            Intrinsics.e(inflate);
            return new a(inflate);
        }
        Intrinsics.e(inflate);
        return new SubViewPagerViewHolder(inflate, this.f44491b, this.f44492c);
    }
}
