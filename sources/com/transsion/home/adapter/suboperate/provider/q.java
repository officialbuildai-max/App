package com.transsion.home.adapter.suboperate.provider;

import android.view.View;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.adapter.trending.provider.SubjectItemProvider;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.ExplainBean;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class q extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f44690e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f44691f;

    /* renamed from: g, reason: collision with root package name */
    private final SubjectItemProvider f44692g;

    public q(int i11, boolean z10) {
        this.f44690e = i11;
        this.f44691f = z10;
        this.f44692g = new SubjectItemProvider(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(OperateItem operateItem, q qVar, View view) {
        List<Object> data;
        Subject feedsSubject = operateItem.getFeedsSubject();
        if (feedsSubject != null) {
            rl.h.f(feedsSubject, "opt_sub_feeds");
            BaseProviderMultiAdapter g11 = qVar.g();
            qVar.D((g11 == null || (data = g11.getData()) == null) ? -1 : data.indexOf(operateItem), feedsSubject, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(OperateItem operateItem, q qVar, View view) {
        Subject feedsSubject;
        List<Object> data;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 2000L) || (feedsSubject = operateItem.getFeedsSubject()) == null) {
            return;
        }
        rl.h.g(feedsSubject, SubTabFragment.INSTANCE.a(qVar.f44690e), qVar.k(), "opt_sub_feeds");
        BaseProviderMultiAdapter g11 = qVar.g();
        qVar.D((g11 == null || (data = g11.getData()) == null) ? -1 : data.indexOf(operateItem), feedsSubject, false);
    }

    private final void D(int i11, Subject subject, boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", z10 ? "browse_feeds_item" : "click_feeds_item");
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
        hashMap.put("tabId", String.valueOf(this.f44690e));
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
            com.transsion.baselib.helper.a.f43316a.e(SubTabFragment.INSTANCE.a(this.f44690e), hashMap);
        } else {
            com.transsion.baselib.helper.a.f43316a.f(SubTabFragment.INSTANCE.a(this.f44690e), hashMap);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final OperateItem item) {
        List<Object> data;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Subject feedsSubject = item.getFeedsSubject();
        if (feedsSubject != null) {
            this.f44692g.b(helper, item);
            BaseProviderMultiAdapter g11 = g();
            D((g11 == null || (data = g11.getData()) == null) ? -1 : data.indexOf(item), feedsSubject, true);
        }
        helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.B(OperateItem.this, this, view);
            }
        });
        View G = this.f44692g.G();
        if (G != null) {
            G.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.C(OperateItem.this, this, view);
                }
            });
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.SUBJECT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f44692g.m();
    }
}
