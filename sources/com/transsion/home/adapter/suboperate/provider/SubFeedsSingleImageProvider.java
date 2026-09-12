package com.transsion.home.adapter.suboperate.provider;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.adapter.trending.provider.SubjectSingleImgItemProvider;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.ExplainBean;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.music.data.MusicLikedFragmentViewModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public class SubFeedsSingleImageProvider extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f44572e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f44573f;

    /* renamed from: g, reason: collision with root package name */
    private final SubjectSingleImgItemProvider f44574g;

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f44575h = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.suboperate.provider.r
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MusicLikedFragmentViewModel G;
            G = SubFeedsSingleImageProvider.G();
            return G;
        }
    });

    public SubFeedsSingleImageProvider(int i11, boolean z10) {
        this.f44572e = i11;
        this.f44573f = z10;
        this.f44574g = new SubjectSingleImgItemProvider(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(OperateItem operateItem, SubFeedsSingleImageProvider subFeedsSingleImageProvider, View view) {
        List<Object> data;
        Subject feedsSubject = operateItem.getFeedsSubject();
        if (feedsSubject != null) {
            if (nh.m.f70597a.e()) {
                rl.h.f(feedsSubject, "opt_sub_feeds");
                BaseProviderMultiAdapter g11 = subFeedsSingleImageProvider.g();
                subFeedsSingleImageProvider.H((g11 == null || (data = g11.getData()) == null) ? -1 : data.indexOf(operateItem), feedsSubject, false);
            } else {
                Context k11 = subFeedsSingleImageProvider.k();
                AppCompatActivity appCompatActivity = k11 instanceof AppCompatActivity ? (AppCompatActivity) k11 : null;
                if (appCompatActivity != null) {
                    kotlinx.coroutines.k.d(androidx.view.v.a(appCompatActivity), null, null, new SubFeedsSingleImageProvider$convert$2$1$1$1(subFeedsSingleImageProvider, operateItem, feedsSubject, null), 3, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(OperateItem operateItem, SubFeedsSingleImageProvider subFeedsSingleImageProvider, View view) {
        Subject feedsSubject;
        List<Object> data;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 2000L) || (feedsSubject = operateItem.getFeedsSubject()) == null) {
            return;
        }
        rl.h.g(feedsSubject, SubTabFragment.INSTANCE.a(subFeedsSingleImageProvider.f44572e), subFeedsSingleImageProvider.k(), "opt_sub_feeds");
        BaseProviderMultiAdapter g11 = subFeedsSingleImageProvider.g();
        subFeedsSingleImageProvider.H((g11 == null || (data = g11.getData()) == null) ? -1 : data.indexOf(operateItem), feedsSubject, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MusicLikedFragmentViewModel G() {
        return new MusicLikedFragmentViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(int i11, Subject subject, boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", z10 ? "browse_feeds_single_item" : "click_feeds_single_item");
        hashMap.put("sequence", String.valueOf(i11));
        hashMap.put("item_type", "rec");
        String ops = subject.getOps();
        if (ops == null) {
            ops = "";
        }
        hashMap.put("ops", ops);
        String subjectId = subject.getSubjectId();
        hashMap.put("subject_id", subjectId != null ? subjectId : "");
        hashMap.put("builtin", subject.getBuiltIn() ? "1" : "0");
        hashMap.put("tabId", String.valueOf(this.f44572e));
        StringBuilder sb2 = new StringBuilder();
        List<ExplainBean> explains = subject.getExplains();
        if (explains != null) {
            Iterator<T> it = explains.iterator();
            while (it.hasNext()) {
                sb2.append(((ExplainBean) it.next()).getType());
                sb2.append(",");
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        hashMap.put("rec_explain_type", StringsKt.r1(sb3, ','));
        il.b.e(subject, hashMap);
        if (z10) {
            com.transsion.baselib.helper.a.f43316a.e(SubTabFragment.INSTANCE.a(this.f44572e), hashMap);
        } else {
            com.transsion.baselib.helper.a.f43316a.f(SubTabFragment.INSTANCE.a(this.f44572e), hashMap);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final OperateItem item) {
        List<Object> data;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Subject feedsSubject = item.getFeedsSubject();
        if (feedsSubject != null) {
            this.f44574g.b(helper, item);
            BaseProviderMultiAdapter g11 = g();
            H((g11 == null || (data = g11.getData()) == null) ? -1 : data.indexOf(item), feedsSubject, true);
        }
        helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubFeedsSingleImageProvider.D(OperateItem.this, this, view);
            }
        });
        View H = this.f44574g.H();
        if (H != null) {
            H.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubFeedsSingleImageProvider.E(OperateItem.this, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MusicLikedFragmentViewModel F() {
        return (MusicLikedFragmentViewModel) this.f44575h.getValue();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.SINGLE_SUBJECT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f44574g.m();
    }
}
