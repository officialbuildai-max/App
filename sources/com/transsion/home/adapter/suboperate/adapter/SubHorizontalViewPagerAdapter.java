package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.R$string;
import com.transsion.edcation.CourseManager;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import ej.f;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class SubHorizontalViewPagerAdapter extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final List f44512a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44513b;

    /* renamed from: c, reason: collision with root package name */
    private final OperateItem f44514c;

    /* renamed from: d, reason: collision with root package name */
    private final int f44515d;

    /* renamed from: e, reason: collision with root package name */
    private final int f44516e;

    /* loaded from: classes5.dex */
    public static final class a extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final ImageView f44517a;

        /* renamed from: b, reason: collision with root package name */
        private final DownloadView f44518b;

        /* renamed from: c, reason: collision with root package name */
        private final TextView f44519c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.h(itemView, "itemView");
            View findViewById = itemView.findViewById(R$id.home_sub_pager_item_image);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.f44517a = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R$id.sub_operation_banner_download);
            Intrinsics.g(findViewById2, "findViewById(...)");
            this.f44518b = (DownloadView) findViewById2;
            View findViewById3 = itemView.findViewById(R$id.sub_operation_banner_title);
            Intrinsics.g(findViewById3, "findViewById(...)");
            this.f44519c = (TextView) findViewById3;
        }

        public final DownloadView f() {
            return this.f44518b;
        }

        public final TextView g() {
            return this.f44519c;
        }

        public final ImageView getImageView() {
            return this.f44517a;
        }
    }

    public SubHorizontalViewPagerAdapter(List banners, int i11, OperateItem operateItem, int i12, int i13) {
        Intrinsics.h(banners, "banners");
        Intrinsics.h(operateItem, "operateItem");
        this.f44512a = banners;
        this.f44513b = i11;
        this.f44514c = operateItem;
        this.f44515d = i12;
        this.f44516e = i13;
    }

    private final Subject i(BannerData bannerData) {
        if (bannerData == null) {
            return null;
        }
        return new Subject(bannerData.getSubjectId(), Integer.valueOf(bannerData.getSubjectType()), null, null, null, null, null, null, null, null, null, null, null, null, null, bannerData.getSeenStatus(), null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, -32772, 134217727, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(BannerData bannerData, SubHorizontalViewPagerAdapter subHorizontalViewPagerAdapter, int i11, View view) {
        String deepLink;
        if (bannerData == null || (deepLink = bannerData.getDeepLink()) == null) {
            return;
        }
        Uri g11 = com.transsion.baselib.helper.b.f43318a.g(Uri.parse(deepLink + "&module_name=opt_banner_free&autoPlay=true&ops=" + bannerData.getOps()));
        if (g11 != null) {
            ds.c.j(g11);
        }
        subHorizontalViewPagerAdapter.p(bannerData, i11, DownloadManagerApi.x0(DownloadManagerApi.f58521j.a(), bannerData.getSubjectId(), null, false, false, 12, null) ? "play_subject" : "download_subject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(a aVar, BannerData bannerData, SubHorizontalViewPagerAdapter subHorizontalViewPagerAdapter, Context context, int i11, View view) {
        if (aVar.f().getType() == 2 || aVar.f().getType() == 3) {
            if (bannerData != null) {
                CourseManager.f44139a.w(bannerData.getSubjectId(), bannerData.getSeenStatus());
                wk.a.b(subHorizontalViewPagerAdapter.i(bannerData), SubTabFragment.INSTANCE.a(subHorizontalViewPagerAdapter.f44513b), "opt_rank_list");
                return;
            }
            return;
        }
        String a11 = SubTabFragment.INSTANCE.a(subHorizontalViewPagerAdapter.f44513b);
        Subject subject = new Subject(bannerData != null ? bannerData.getSubjectId() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, -2, 134217727, null);
        Intrinsics.e(context);
        subHorizontalViewPagerAdapter.o(bannerData, i11, rl.h.g(subject, a11, context, "opt_rank_list"));
    }

    private final void o(BannerData bannerData, int i11, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_banner");
        hashMap.put("sequence", String.valueOf(i11));
        hashMap.put("module_name", str);
        hashMap.put("tabId", String.valueOf(this.f44513b));
        if (bannerData != null) {
            il.b.c(bannerData, hashMap);
        }
        il.b.a(this.f44514c, hashMap);
        com.transsion.baselib.helper.a.f43316a.f(SubTabFragment.INSTANCE.a(this.f44513b), hashMap);
    }

    private final void p(BannerData bannerData, int i11, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_banner_poster");
        hashMap.put("sequence", String.valueOf(i11));
        hashMap.put("module_name", str);
        hashMap.put("tabId", String.valueOf(this.f44513b));
        if (bannerData != null) {
            il.b.c(bannerData, hashMap);
        }
        il.b.a(this.f44514c, hashMap);
        com.transsion.baselib.helper.a.f43316a.f(SubTabFragment.INSTANCE.a(this.f44513b), hashMap);
    }

    private final void q(BannerData bannerData, DownloadView downloadView) {
        Integer seenStatus;
        boolean z10 = false;
        if ((bannerData != null ? Intrinsics.c(bannerData.getHasResource(), Boolean.TRUE) : false) && HomeTabId.INSTANCE.h(Integer.valueOf(this.f44513b), true)) {
            jg.c.k(downloadView);
        } else {
            if (bannerData != null ? Intrinsics.c(bannerData.getHasResource(), Boolean.TRUE) : false) {
                jg.c.k(downloadView);
            } else {
                jg.c.g(downloadView);
            }
        }
        if (HomeTabId.INSTANCE.h(Integer.valueOf(this.f44513b), true)) {
            if (bannerData != null && (seenStatus = bannerData.getSeenStatus()) != null && seenStatus.intValue() == 1) {
                z10 = true;
            }
            if (z10) {
                downloadView.setCourseAdded();
                return;
            } else {
                downloadView.setAddCourse();
                return;
            }
        }
        if (ak.t.f727a.b()) {
            if (bannerData != null && bannerData.getSubjectType() == SubjectType.SHORT_TV.getValue()) {
                z10 = true;
            }
            if (!z10) {
                downloadView.setShowPlayType();
                return;
            }
        }
        DownloadView.setShowType$default(downloadView, bannerData != null ? bannerData.getSubjectId() : null, null, null, false, R$string.download_now, 14, null);
    }

    private final void r(a aVar, int i11) {
        if (HomeTabId.INSTANCE.h(Integer.valueOf(this.f44513b), true)) {
            if (i11 == 1) {
                aVar.f().setCourseAdded();
            } else {
                aVar.f().setAddCourse();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final a holder, final int i11) {
        String str;
        String str2;
        Image image;
        Image image2;
        String content;
        Intrinsics.h(holder, "holder");
        final Context context = holder.getImageView().getContext();
        final BannerData bannerData = (BannerData) this.f44512a.get(i11 % this.f44512a.size());
        holder.getImageView().getLayoutParams().height = this.f44516e;
        String str3 = "";
        if (bannerData == null || !bannerData.getBuiltIn()) {
            f.a aVar = ej.f.f62005a;
            Intrinsics.e(context);
            f.b m11 = aVar.m(context);
            if (bannerData == null || (image2 = bannerData.getImage()) == null || (str = image2.getUrl()) == null) {
                str = "";
            }
            f.b m12 = m11.g(str).m(this.f44515d);
            if (bannerData == null || (image = bannerData.getImage()) == null || (str2 = image.getThumbnail()) == null) {
                str2 = "";
            }
            m12.l(str2).d(holder.getImageView());
        } else {
            kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new SubHorizontalViewPagerAdapter$onBindViewHolder$1(bannerData, holder, null), 3, null);
        }
        TextView g11 = holder.g();
        if (bannerData != null && (content = bannerData.getContent()) != null) {
            str3 = content;
        }
        g11.setText(str3);
        q(bannerData, holder.f());
        holder.getImageView().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubHorizontalViewPagerAdapter.l(BannerData.this, this, i11, view);
            }
        });
        holder.f().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubHorizontalViewPagerAdapter.m(SubHorizontalViewPagerAdapter.a.this, bannerData, this, context, i11, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i11, List payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, i11);
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof Integer) {
            r(holder, ((Number) obj).intValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_sub_horizontal_view_pager, parent, false);
        Intrinsics.e(inflate);
        return new a(inflate);
    }
}
