package cl;

import android.widget.FrameLayout;
import androidx.constraintlayout.widget.Group;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.UGCFilterVideoItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a extends BaseItemProvider {

    /* renamed from: h, reason: collision with root package name */
    public static final C0174a f17347h = new C0174a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final int f17348i = 8;

    /* renamed from: e, reason: collision with root package name */
    private final hl.b f17349e;

    /* renamed from: f, reason: collision with root package name */
    private final int f17350f = 4;

    /* renamed from: g, reason: collision with root package name */
    private final int f17351g = R$layout.ugc_item_filter_source;

    /* renamed from: cl.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0174a {
        private C0174a() {
        }

        public /* synthetic */ C0174a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(hl.b bVar) {
        this.f17349e = bVar;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f17350f;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f17351g;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void v(BaseViewHolder viewHolder, int i11) {
        Intrinsics.h(viewHolder, "viewHolder");
        super.v(viewHolder, i11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder holder, UGCFilterVideoItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        BiddingNativeManager nonAdDelegate = item.getNonAdDelegate();
        if (nonAdDelegate == null) {
            FrameLayout frameLayout = (FrameLayout) holder.getViewOrNull(R$id.nativeView);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            Group group = (Group) holder.getViewOrNull(R$id.group);
            if (group != null) {
                group.setVisibility(0);
                return;
            }
            return;
        }
        r a11 = cy.b.f61063a.a(k(), nonAdDelegate.getMSceneId());
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) holder.getViewOrNull(R$id.nativeView);
        if (nativeWrapperAdView != null) {
            BiddingNativeManager nonAdDelegate2 = item.getNonAdDelegate();
            nativeWrapperAdView.bindNativeView(nonAdDelegate, a11, nonAdDelegate2 != null ? nonAdDelegate2.n0() : null);
        }
        FrameLayout frameLayout2 = (FrameLayout) holder.getViewOrNull(R$id.nativeView);
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        Group group2 = (Group) holder.getViewOrNull(R$id.group);
        if (group2 != null) {
            group2.setVisibility(8);
        }
    }
}
