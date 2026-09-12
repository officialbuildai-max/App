package com.transsion.ad.test.ad_config;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v;
import com.blankj.utilcode.util.o;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.test.TestBaseActivity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import ji.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ti.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/transsion/ad/test/ad_config/TestAdPlansActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", "", "getLogTag", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lji/x;", "a", "Lji/x;", "binding", "AdPlansAdapter", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class TestAdPlansActivity extends TestBaseActivity {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private x binding;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/ad/test/ad_config/TestAdPlansActivity$AdPlansAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/ad/db/plan/MbAdDbPlans;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "holder", "mbAdDbPlans", "", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/ad/db/plan/MbAdDbPlans;)V", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class AdPlansAdapter extends BaseQuickAdapter {
        public AdPlansAdapter() {
            super(R$layout.test_item_ad_plan_layout, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: B1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, MbAdDbPlans mbAdDbPlans) {
            Intrinsics.h(holder, "holder");
            Intrinsics.h(mbAdDbPlans, "mbAdDbPlans");
            StringBuilder sb2 = new StringBuilder();
            List list = (List) o.e(mbAdDbPlans.getAdMaterialList(), new TypeToken<List<? extends AdMaterialList>>() { // from class: com.transsion.ad.test.ad_config.TestAdPlansActivity$AdPlansAdapter$convert$adMaterialList$1
            }.getType());
            Intrinsics.e(list);
            if (!list.isEmpty()) {
                sb2.append("type = " + ((AdMaterialList) list.get(0)).getType() + "\n");
            }
            sb2.append("id = " + mbAdDbPlans.getId() + "\n");
            sb2.append("name = " + mbAdDbPlans.getName() + "\n");
            p pVar = p.f76389a;
            String startTime = mbAdDbPlans.getStartTime();
            sb2.append("startTime = " + p.b(pVar, startTime != null ? Long.valueOf(Long.parseLong(startTime)) : null, null, 2, null) + "\n");
            String endTime = mbAdDbPlans.getEndTime();
            sb2.append("endTime = " + p.b(pVar, endTime != null ? Long.valueOf(Long.parseLong(endTime)) : null, null, 2, null) + "\n");
            sb2.append("dispatchTimeStart = " + mbAdDbPlans.getDispatchTimeStart() + "\n");
            sb2.append("dispatchTimeEnd = " + mbAdDbPlans.getDispatchTimeEnd() + "\n");
            sb2.append("displayTimes = " + mbAdDbPlans.getDisplayTimes() + "\n");
            sb2.append("showedTimes = " + mbAdDbPlans.getShowedTimes() + "\n");
            sb2.append("showDate = " + mbAdDbPlans.getShowDate() + "\n");
            sb2.append("brand = " + mbAdDbPlans.getBrand() + "\n");
            sb2.append("denyBrand = " + mbAdDbPlans.getDenyBrand() + "\n");
            sb2.append("model = " + mbAdDbPlans.getModel() + "\n");
            sb2.append("denyModel = " + mbAdDbPlans.getDenyModel() + "\n");
            sb2.append("country = " + mbAdDbPlans.getCountry() + "\n");
            sb2.append("adSource = " + mbAdDbPlans.getAdSource() + "\n");
            sb2.append("extAdSlot = " + mbAdDbPlans.getExtAdSlot() + "\n");
            sb2.append("sort = " + mbAdDbPlans.getSort() + "\n");
            sb2.append("bidEcpmCent = " + mbAdDbPlans.getBidEcpmCent() + "\n");
            sb2.append("ecpmCent = " + mbAdDbPlans.getEcpmCent() + "\n");
            sb2.append("h5LinkPreload = " + mbAdDbPlans.getH5LinkPreload() + "\n");
            sb2.append("h5LinkOpenByCct = " + mbAdDbPlans.getH5LinkOpenByCct() + "\n");
            holder.setText(R$id.tvConfig, sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(TestAdPlansActivity testAdPlansActivity, View view) {
        kotlinx.coroutines.k.d(v.a(testAdPlansActivity), null, null, new TestAdPlansActivity$onCreate$1$1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(TestAdPlansActivity testAdPlansActivity, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        Object obj = adapter.getData().get(i11);
        MbAdDbPlans mbAdDbPlans = obj instanceof MbAdDbPlans ? (MbAdDbPlans) obj : null;
        if (mbAdDbPlans != null) {
            Intent intent = new Intent(testAdPlansActivity, (Class<?>) TestAdPlanDetailActivity.class);
            intent.putExtra("MbAdDbPlans", mbAdDbPlans);
            testAdPlansActivity.startActivity(intent);
        }
    }

    @Override // oi.b
    public String getLogTag() {
        return "ad_";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x c11 = x.c(getLayoutInflater());
        this.binding = c11;
        if (c11 == null) {
            Intrinsics.z("binding");
            c11 = null;
        }
        setContentView(c11.getRoot());
        x xVar = this.binding;
        if (xVar == null) {
            Intrinsics.z("binding");
            xVar = null;
        }
        xVar.f66312b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_config.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdPlansActivity.V(TestAdPlansActivity.this, view);
            }
        });
        AdPlansAdapter adPlansAdapter = new AdPlansAdapter();
        x xVar2 = this.binding;
        if (xVar2 == null) {
            Intrinsics.z("binding");
            xVar2 = null;
        }
        RecyclerView recyclerView = xVar2.f66313c;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adPlansAdapter);
        adPlansAdapter.w1(new p6.d() { // from class: com.transsion.ad.test.ad_config.f
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                TestAdPlansActivity.W(TestAdPlansActivity.this, baseQuickAdapter, view, i11);
            }
        });
        kotlinx.coroutines.k.d(v.a(this), null, null, new TestAdPlansActivity$onCreate$4(adPlansAdapter, this, null), 3, null);
    }
}
