package com.transsion.publish.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.publish.R$layout;
import com.transsion.room.api.bean.LocationPlace;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/transsion/publish/adapter/SelectLocationAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/room/api/bean/LocationPlace;", "Lcom/transsion/publish/adapter/SelectLocationAdapter$SelectLocationItemVH;", "<init>", "()V", "", "lat", "lon", "", "D1", "(Ljava/lang/Double;Ljava/lang/Double;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "C1", "(Landroid/view/ViewGroup;I)Lcom/transsion/publish/adapter/SelectLocationAdapter$SelectLocationItemVH;", "holder", WebConstants.FIELD_ITEM, "B1", "(Lcom/transsion/publish/adapter/SelectLocationAdapter$SelectLocationItemVH;Lcom/transsion/room/api/bean/LocationPlace;)V", "F", "Ljava/lang/Double;", "curLat", "G", "curLon", "SelectLocationItemVH", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class SelectLocationAdapter extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private Double curLat;

    /* renamed from: G, reason: from kotlin metadata */
    private Double curLon;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/publish/adapter/SelectLocationAdapter$SelectLocationItemVH;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lhp/j;", "viewBinding", "<init>", "(Lhp/j;)V", "a", "Lhp/j;", "f", "()Lhp/j;", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes6.dex */
    public static final class SelectLocationItemVH extends BaseViewHolder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final hp.j viewBinding;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public SelectLocationItemVH(hp.j r3) {
            /*
                r2 = this;
                java.lang.String r0 = "viewBinding"
                kotlin.jvm.internal.Intrinsics.h(r3, r0)
                androidx.constraintlayout.widget.ConstraintLayout r0 = r3.getRoot()
                java.lang.String r1 = "getRoot(...)"
                kotlin.jvm.internal.Intrinsics.g(r0, r1)
                r2.<init>(r0)
                r2.viewBinding = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.publish.adapter.SelectLocationAdapter.SelectLocationItemVH.<init>(hp.j):void");
        }

        /* renamed from: f, reason: from getter */
        public final hp.j getViewBinding() {
            return this.viewBinding;
        }
    }

    public SelectLocationAdapter() {
        super(R$layout.item_select_location, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(SelectLocationItemVH holder, LocationPlace item) {
        String str;
        StringBuilder sb2;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        holder.getViewBinding().f64931c.setText(item.getName());
        String distance = item.getDistance();
        if (distance == null || distance.length() == 0) {
            Double d11 = this.curLat;
            if ((d11 != null ? d11.doubleValue() : 0.0d) > 0.0d) {
                Double d12 = this.curLon;
                if ((d12 != null ? d12.doubleValue() : 0.0d) > 0.0d) {
                    if (this.curLat == null || this.curLon == null || item.getLat() == null || item.getLon() == null) {
                        str = null;
                    } else {
                        ak.s sVar = ak.s.f726a;
                        Double d13 = this.curLat;
                        Intrinsics.e(d13);
                        double doubleValue = d13.doubleValue();
                        Double d14 = this.curLon;
                        Intrinsics.e(d14);
                        double doubleValue2 = d14.doubleValue();
                        Double lat = item.getLat();
                        Intrinsics.e(lat);
                        double doubleValue3 = lat.doubleValue();
                        Double lon = item.getLon();
                        Intrinsics.e(lon);
                        str = sVar.a(doubleValue, doubleValue2, doubleValue3, lon.doubleValue());
                    }
                    sb2 = new StringBuilder();
                    if (str != null && str.length() != 0) {
                        sb2.append(item.getDistance());
                        sb2.append("·");
                    }
                    sb2.append(item.getAddress());
                    holder.getViewBinding().f64930b.setText(sb2);
                }
            }
        }
        str = item.getDistance();
        sb2 = new StringBuilder();
        if (str != null) {
            sb2.append(item.getDistance());
            sb2.append("·");
        }
        sb2.append(item.getAddress());
        holder.getViewBinding().f64930b.setText(sb2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public SelectLocationItemVH y0(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        hp.j c11 = hp.j.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.g(c11, "inflate(...)");
        return new SelectLocationItemVH(c11);
    }

    public final void D1(Double lat, Double lon) {
        this.curLat = lat;
        this.curLon = lon;
    }
}
