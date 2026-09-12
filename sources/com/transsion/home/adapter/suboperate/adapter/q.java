package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.edcation.CourseManager;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.R$mipmap;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingListItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\n\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010 J\u001f\u0010$\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0002H\u0014¢\u0006\u0004\b$\u0010%J-\u0010)\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00022\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0014¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010.¨\u00061"}, d2 = {"Lcom/transsion/home/adapter/suboperate/adapter/q;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/RankingListItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "layoutResId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "tabId", "<init>", "(ILcom/transsion/home/bean/OperateItem;I)V", "Landroid/content/Context;", "context", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "Landroid/view/ViewGroup;", "parent", RequestParameters.POSITION, "Landroid/view/View;", "H1", "(Landroid/content/Context;Lcom/transsion/moviedetailapi/bean/Subject;Landroid/view/ViewGroup;I)Landroid/view/View;", "Landroid/widget/ImageView;", "imageView", "seenStatus", "", "L1", "(Landroid/widget/ImageView;I)V", "pos", "G1", "(I)I", "rankListItem", "J1", "(Lcom/transsion/home/bean/RankingListItem;I)V", "K1", "holder", WebConstants.FIELD_ITEM, "D1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/RankingListItem;)V", "", "", "payloads", "E1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/RankingListItem;Ljava/util/List;)V", "F", "Lcom/transsion/home/bean/OperateItem;", "G", "I", "H", "perWidth", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class q extends BaseQuickAdapter {
    public static final int I = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final OperateItem operateItem;

    /* renamed from: G, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: H, reason: from kotlin metadata */
    private final int perWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i11, OperateItem operateItem, int i12) {
        super(i11, null, 2, null);
        Intrinsics.h(operateItem, "operateItem");
        this.operateItem = operateItem;
        this.tabId = i12;
        this.perWidth = Math.min(y.e(), y.c()) - a0.a(54.0f);
    }

    public /* synthetic */ q(int i11, OperateItem operateItem, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? R$layout.item_provider_ranklist : i11, operateItem, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(Subject subject, q qVar, RankingListItem rankingListItem, int i11, View view) {
        rl.h.f(subject, "opt_ranking_list");
        qVar.K1(rankingListItem, i11);
    }

    private final int G1(int pos) {
        return pos != 0 ? pos != 1 ? pos != 2 ? R$mipmap.ic_rank_defalut : R$mipmap.ic_rank_03 : R$mipmap.ic_rank_02 : R$mipmap.ic_rank_01;
    }

    private final View H1(Context context, final Subject subject, ViewGroup parent, int position) {
        String str;
        String valueOf;
        View inflate = LayoutInflater.from(context).inflate(R$layout.item_provider_ranklist_items, parent, false);
        View findViewById = inflate.findViewById(R$id.sub_operation_rankinglist_cover);
        Intrinsics.g(findViewById, "findViewById(...)");
        ShapeableImageView shapeableImageView = (ShapeableImageView) findViewById;
        f.b m11 = ej.f.f62005a.m(context);
        Cover cover = subject.getCover();
        if (cover == null || (str = cover.getUrl()) == null) {
            str = "";
        }
        m11.g(str).d(shapeableImageView);
        ((TextView) inflate.findViewById(R$id.sub_operation_rankinglist_title)).setText(subject.getTitle());
        ((TextView) inflate.findViewById(R$id.sub_operation_rankinglist_tag)).setText(defpackage.a.b(context, subject));
        ImageView imageView = (ImageView) inflate.findViewById(R$id.sub_operation_rankinglist_add_icon);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.I1(Subject.this, this, view);
                }
            });
        }
        Intrinsics.e(imageView);
        Integer seenStatus = subject.getSeenStatus();
        L1(imageView, seenStatus != null ? seenStatus.intValue() : 0);
        AppCompatImageView appCompatImageView = (AppCompatImageView) inflate.findViewById(R$id.sub_operation_rankinglist_rank);
        if (appCompatImageView != null) {
            appCompatImageView.setImageResource(G1(position));
        }
        TextView textView = (TextView) inflate.findViewById(R$id.sub_operation_rankinglist_text);
        if (position > 2) {
            if (position < 9) {
                valueOf = "0" + (position + 1);
            } else {
                valueOf = String.valueOf(position + 1);
            }
            textView.setText(valueOf);
        } else {
            textView.setText("");
        }
        Intrinsics.e(inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(Subject subject, q qVar, View view) {
        CourseManager.v(CourseManager.f44139a, subject, null, 2, null);
        wk.a.b(subject, SubTabFragment.INSTANCE.a(qVar.tabId), "opt_banner");
    }

    private final void J1(RankingListItem rankListItem, int position) {
        List<Subject> subjects = rankListItem.getSubjects();
        Subject subject = subjects != null ? subjects.get(position) : null;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_rank_list_item");
        hashMap.put("sequence", String.valueOf(position));
        hashMap.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
        hashMap.put("tabId", String.valueOf(this.tabId));
        String title = rankListItem.getTitle();
        if (title == null) {
            title = "";
        }
        hashMap.put("groupTitle", title);
        il.b.a(this.operateItem, hashMap);
        if (subject != null) {
            il.b.e(subject, hashMap);
        }
        com.transsion.baselib.helper.a.f43316a.e(SubTabFragment.INSTANCE.a(this.tabId), hashMap);
    }

    private final void K1(RankingListItem rankListItem, int position) {
        List<Subject> subjects = rankListItem.getSubjects();
        Subject subject = subjects != null ? subjects.get(position) : null;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_rank_list_item");
        hashMap.put("sequence", String.valueOf(position));
        hashMap.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
        hashMap.put("tabId", String.valueOf(this.tabId));
        String title = rankListItem.getTitle();
        if (title == null) {
            title = "";
        }
        hashMap.put("groupTitle", title);
        il.b.a(this.operateItem, hashMap);
        if (subject != null) {
            il.b.e(subject, hashMap);
        }
        com.transsion.baselib.helper.a.f43316a.b(SubTabFragment.INSTANCE.a(this.tabId), hashMap);
    }

    private final void L1(ImageView imageView, int seenStatus) {
        imageView.setImageResource(seenStatus == 1 ? com.transsion.baseui.R$mipmap.ic_added : com.transsion.baseui.R$mipmap.ic_add);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, final RankingListItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        LinearLayout linearLayout = (LinearLayout) holder.getView(R$id.sub_operation_rankinglist_root);
        linearLayout.removeAllViews();
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = this.perWidth;
        linearLayout.setLayoutParams(layoutParams);
        List<Subject> subjects = item.getSubjects();
        if (subjects != null) {
            final int i11 = 0;
            for (Object obj : subjects) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.u();
                }
                final Subject subject = (Subject) obj;
                View H1 = H1(getContext(), subject, linearLayout, i11);
                linearLayout.addView(H1);
                H1.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        q.F1(Subject.this, this, item, i11, view);
                    }
                });
                J1(item, i11);
                i11 = i12;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void G(BaseViewHolder holder, RankingListItem item, List<? extends Object> payloads) {
        Integer seenStatus;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.G(holder, item, payloads);
        int i11 = 0;
        Subject subject = (Subject) payloads.get(0);
        List<Subject> subjects = item.getSubjects();
        int n02 = subjects != null ? CollectionsKt.n0(subjects, subject) : -1;
        LinearLayout linearLayout = (LinearLayout) holder.getView(R$id.sub_operation_rankinglist_root);
        if (n02 < 0 || n02 >= linearLayout.getChildCount()) {
            return;
        }
        ImageView imageView = (ImageView) linearLayout.getChildAt(n02).findViewById(R$id.sub_operation_rankinglist_add_icon);
        Intrinsics.e(imageView);
        if (subject != null && (seenStatus = subject.getSeenStatus()) != null) {
            i11 = seenStatus.intValue();
        }
        L1(imageView, i11);
    }
}
