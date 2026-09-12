package com.transsion.ad.test.ad_config;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v;
import com.blankj.utilcode.util.o;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import com.transsion.ad.ps.model.ItemDetail;
import com.transsion.ad.ps.model.PSAdTypeEnum;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ji.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/transsion/ad/test/ad_config/TestAdPsOfferActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", "", "Z", "", "getLogTag", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lji/y;", "a", "Lji/y;", "binding", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class TestAdPsOfferActivity extends TestBaseActivity {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private y binding;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/ad/test/ad_config/TestAdPsOfferActivity$a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/ad/db/pslink/PsLinkAdPlan;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "holder", WebConstants.FIELD_ITEM, "", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/ad/db/pslink/PsLinkAdPlan;)V", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class a extends BaseQuickAdapter {
        public a() {
            super(R$layout.test_item_ad_plan_layout, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: B1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, PsLinkAdPlan item) {
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            StringBuilder sb2 = new StringBuilder();
            RecommendInfo recommendInfo = (RecommendInfo) o.d(item.getPsInfoJson(), RecommendInfo.class);
            sb2.append("id = " + item.getId() + "\n");
            sb2.append("nonId = " + item.getNonId() + "\n");
            sb2.append("adSource = " + item.getAdSource() + "\n");
            sb2.append("extAdSlot = " + item.getExtAdSlot() + "\n");
            sb2.append("showMax = " + item.getShowMax() + "\n");
            sb2.append("clickMax = " + item.getClickMax() + "\n");
            sb2.append("showHours = " + item.getShowHours() + "\n");
            sb2.append("showedTimes = " + item.getShowedTimes() + "\n");
            sb2.append("clickedTimes = " + item.getClickedTimes() + "\n");
            sb2.append("showDate = " + item.getShowDate() + "\n");
            sb2.append("rank = " + item.getRank() + "\n");
            sb2.append("psPlanId = " + item.getPsPlanId() + "\n");
            sb2.append("updateTimestamp = " + item.getUpdateTimestamp() + "\n");
            sb2.append("packageName = " + recommendInfo.getPackageName() + "\n");
            ItemDetail detail = recommendInfo.getDetail();
            sb2.append("name = " + (detail != null ? detail.getName() : null) + "\n");
            sb2.append("showAttributionLink = " + recommendInfo.getShowAttributionLink() + "\n");
            sb2.append("attributionLink = " + recommendInfo.getAttributionLink() + "\n");
            sb2.append("deepLink = " + recommendInfo.getDeepLink() + "\n");
            sb2.append("gpLink = " + recommendInfo.getGpLink() + "\n");
            sb2.append("isOffer = " + recommendInfo.isOffer() + "\n");
            Integer adType = recommendInfo.getAdType();
            int value = PSAdTypeEnum.PS_AD_TYPE_USER_RETENTION_1.getValue();
            if (adType != null && adType.intValue() == value) {
                sb2.append("adType = 拉活\n");
            } else {
                sb2.append("adType = 拉新\n");
            }
            holder.setText(R$id.tvConfig, sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(TestAdPsOfferActivity testAdPsOfferActivity, View view) {
        hi.f.f64595a.j(!r2.e());
        testAdPsOfferActivity.Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(TestAdPsOfferActivity testAdPsOfferActivity, View view) {
        kotlinx.coroutines.k.d(v.a(testAdPsOfferActivity), null, null, new TestAdPsOfferActivity$onCreate$4$1(testAdPsOfferActivity, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(TestAdPsOfferActivity testAdPsOfferActivity, View view) {
        hi.f.f64595a.g(!r2.b());
        testAdPsOfferActivity.Z();
    }

    private final void Z() {
        y yVar = this.binding;
        y yVar2 = null;
        if (yVar == null) {
            Intrinsics.z("binding");
            yVar = null;
        }
        Button button = yVar.f66316b;
        hi.f fVar = hi.f.f64595a;
        button.setText(fVar.e() ? "releasePsApi = true" : "releasePsApi = false");
        y yVar3 = this.binding;
        if (yVar3 == null) {
            Intrinsics.z("binding");
        } else {
            yVar2 = yVar3;
        }
        yVar2.f66318d.setText(fVar.b() ? "detailRequestLog = true" : "detailRequestLog = false");
    }

    @Override // oi.b
    public String getLogTag() {
        return "ad_ps_d";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        y c11 = y.c(getLayoutInflater());
        this.binding = c11;
        y yVar = null;
        if (c11 == null) {
            Intrinsics.z("binding");
            c11 = null;
        }
        setContentView(c11.getRoot());
        a aVar = new a();
        y yVar2 = this.binding;
        if (yVar2 == null) {
            Intrinsics.z("binding");
            yVar2 = null;
        }
        RecyclerView recyclerView = yVar2.f66319e;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(aVar);
        kotlinx.coroutines.k.d(v.a(this), null, null, new TestAdPsOfferActivity$onCreate$2(this, aVar, null), 3, null);
        Z();
        y yVar3 = this.binding;
        if (yVar3 == null) {
            Intrinsics.z("binding");
            yVar3 = null;
        }
        yVar3.f66316b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_config.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdPsOfferActivity.W(TestAdPsOfferActivity.this, view);
            }
        });
        y yVar4 = this.binding;
        if (yVar4 == null) {
            Intrinsics.z("binding");
            yVar4 = null;
        }
        yVar4.f66317c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_config.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdPsOfferActivity.X(TestAdPsOfferActivity.this, view);
            }
        });
        y yVar5 = this.binding;
        if (yVar5 == null) {
            Intrinsics.z("binding");
        } else {
            yVar = yVar5;
        }
        yVar.f66318d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_config.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdPsOfferActivity.Y(TestAdPsOfferActivity.this, view);
            }
        });
    }
}
