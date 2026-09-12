package com.transsion.rewardscenter.prize;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.cloud.config.utils.XLogUtil;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.rewardscenter.R$color;
import com.transsion.rewardscenter.prize.e;
import com.transsion.rewardscenterapi.DrawChance;
import com.transsion.rewardscenterapi.DrawResult;
import com.transsion.rewardscenterapi.UserPrize;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002/0B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0012J%\u0010\u0018\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R*\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/transsion/rewardscenter/prize/g;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/rewardscenter/prize/e;", "Lwp/a;", XLogUtil.TAG, "<init>", "(Lwp/a;)V", "", "Y1", "()V", "V1", "Lcom/transsion/rewardscenterapi/UserPrize;", "userPrize", "W1", "(Lcom/transsion/rewardscenterapi/UserPrize;)V", "", "drawResultId", "U1", "(Ljava/lang/String;)V", "T1", "", "data", "", RequestParameters.POSITION, "N1", "(Ljava/util/List;I)I", "Lcom/transsion/rewardscenterapi/DrawResult;", "G", "Ljava/util/List;", "allRows", "Lcom/transsion/rewardscenterapi/DrawChance;", "H", "Lcom/transsion/rewardscenterapi/DrawChance;", "drawChance", "", "I", "Z", "isExpanded", "Lkotlin/Function0;", "J", "Lkotlin/jvm/functions/Function0;", "S1", "()Lkotlin/jvm/functions/Function0;", "X1", "(Lkotlin/jvm/functions/Function0;)V", "onCollapse", "K", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class g extends BaseProviderMultiAdapter<e> {
    public static final int L = 8;
    public static final int M = 2;

    /* renamed from: G, reason: from kotlin metadata */
    private List<DrawResult> allRows;

    /* renamed from: H, reason: from kotlin metadata */
    private DrawChance drawChance;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isExpanded;

    /* renamed from: J, reason: from kotlin metadata */
    private Function0<Unit> onCollapse;

    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.l {

        /* renamed from: a, reason: collision with root package name */
        private final int f51049a;

        /* renamed from: b, reason: collision with root package name */
        private final int f51050b;

        /* renamed from: c, reason: collision with root package name */
        private final Paint f51051c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public b() {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.rewardscenter.prize.g.b.<init>():void");
        }

        public b(int i11, int i12) {
            this.f51049a = i11;
            this.f51050b = i12;
            this.f51051c = new Paint();
        }

        public /* synthetic */ b(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
            this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 1 : i12);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            Intrinsics.h(outRect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            outRect.set(0, 0, 0, parent.getChildAdapterPosition(view) < state.b() + (-1) ? this.f51049a + this.f51050b : this.f51049a);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void onDraw(Canvas c11, RecyclerView parent, RecyclerView.y state) {
            Intrinsics.h(c11, "c");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            this.f51051c.setColor(androidx.core.content.b.getColor(parent.getContext(), R$color.prize_list_divider));
            int childCount = parent.getChildCount() - 1;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = parent.getChildAt(i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                int paddingLeft = parent.getPaddingLeft();
                int width = parent.getWidth() - parent.getPaddingRight();
                c11.drawRect(paddingLeft, childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) layoutParams)).bottomMargin, width, this.f51050b + r1, this.f51051c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(wp.a config) {
        super(null, 1, null);
        Intrinsics.h(config, "config");
        this.allRows = CollectionsKt.l();
        F1(new com.transsion.rewardscenter.prize.b(config));
        F1(new k(config));
        F1(new d(new Function0() { // from class: com.transsion.rewardscenter.prize.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit R1;
                R1 = g.R1(g.this);
                return R1;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R1(g gVar) {
        gVar.Y1();
        return Unit.f67184a;
    }

    private final void V1() {
        ArrayList arrayList = new ArrayList();
        DrawChance drawChance = this.drawChance;
        if (drawChance != null) {
            arrayList.add(new e.a(drawChance));
        }
        if (this.isExpanded || this.allRows.size() <= 2) {
            List<DrawResult> list = this.allRows;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.v(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(new e.c((DrawResult) it.next()));
            }
            arrayList.addAll(arrayList2);
        } else {
            List K0 = CollectionsKt.K0(this.allRows, 2);
            ArrayList arrayList3 = new ArrayList(CollectionsKt.v(K0, 10));
            Iterator it2 = K0.iterator();
            while (it2.hasNext()) {
                arrayList3.add(new e.c((DrawResult) it2.next()));
            }
            arrayList.addAll(arrayList3);
        }
        if (this.allRows.size() > 2) {
            arrayList.add(new e.b(this.isExpanded));
        }
        n1(arrayList);
    }

    private final void Y1() {
        Function0<Unit> function0;
        this.isExpanded = !this.isExpanded;
        V1();
        if (this.isExpanded || (function0 = this.onCollapse) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    protected int N1(List<? extends e> data, int position) {
        Intrinsics.h(data, "data");
        e eVar = data.get(position);
        if (eVar instanceof e.a) {
            return PrizeItemType.DRAW_CHANCE.getValue();
        }
        if (eVar instanceof e.c) {
            return PrizeItemType.ROW.getValue();
        }
        if (eVar instanceof e.b) {
            return PrizeItemType.FOOTER.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Function0<Unit> S1() {
        return this.onCollapse;
    }

    public final void T1(String drawResultId) {
        Intrinsics.h(drawResultId, "drawResultId");
        List<DrawResult> list = this.allRows;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list, 10));
        for (DrawResult drawResult : list) {
            if (Intrinsics.c(drawResult.getDrawResultId(), drawResultId)) {
                drawResult = drawResult.copy((r20 & 1) != 0 ? drawResult.drawResultId : null, (r20 & 2) != 0 ? drawResult.source : null, (r20 & 4) != 0 ? drawResult.claimStatus : "CLAIM_STATUS_CLAIMED", (r20 & 8) != 0 ? drawResult.needFill : null, (r20 & 16) != 0 ? drawResult.fillStatus : null, (r20 & 32) != 0 ? drawResult.fulfillStatus : null, (r20 & 64) != 0 ? drawResult.imgUrl : null, (r20 & 128) != 0 ? drawResult.title : null, (r20 & 256) != 0 ? drawResult.prizeType : null);
            }
            arrayList.add(drawResult);
        }
        this.allRows = arrayList;
        V1();
    }

    public final void U1(String drawResultId) {
        Intrinsics.h(drawResultId, "drawResultId");
        List<DrawResult> list = this.allRows;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list, 10));
        for (DrawResult drawResult : list) {
            if (Intrinsics.c(drawResult.getDrawResultId(), drawResultId)) {
                drawResult = drawResult.copy((r20 & 1) != 0 ? drawResult.drawResultId : null, (r20 & 2) != 0 ? drawResult.source : null, (r20 & 4) != 0 ? drawResult.claimStatus : "CLAIM_STATUS_TOP_UP", (r20 & 8) != 0 ? drawResult.needFill : null, (r20 & 16) != 0 ? drawResult.fillStatus : null, (r20 & 32) != 0 ? drawResult.fulfillStatus : null, (r20 & 64) != 0 ? drawResult.imgUrl : null, (r20 & 128) != 0 ? drawResult.title : null, (r20 & 256) != 0 ? drawResult.prizeType : null);
            }
            arrayList.add(drawResult);
        }
        this.allRows = arrayList;
        V1();
    }

    public final void W1(UserPrize userPrize) {
        List<DrawResult> l11;
        this.drawChance = userPrize != null ? userPrize.getDrawChance() : null;
        if (userPrize == null || (l11 = userPrize.getPrizeItems()) == null) {
            l11 = CollectionsKt.l();
        }
        this.allRows = l11;
        this.isExpanded = false;
        V1();
    }

    public final void X1(Function0<Unit> function0) {
        this.onCollapse = function0;
    }
}
