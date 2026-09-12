package com.transsion.wrapperad.view.cardpage;

import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final NativeWrapperAdView f58468a;

    /* renamed from: b, reason: collision with root package name */
    private final BiddingIntermediateMaterialBean f58469b;

    /* renamed from: c, reason: collision with root package name */
    private NativeCardPageAdHelper f58470c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f58471d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f58472e;

    public f(NativeWrapperAdView nativeView, BiddingIntermediateMaterialBean adBean, NativeCardPageAdHelper nativeCardPageAdHelper, boolean z10, boolean z11) {
        Intrinsics.h(nativeView, "nativeView");
        Intrinsics.h(adBean, "adBean");
        this.f58468a = nativeView;
        this.f58469b = adBean;
        this.f58470c = nativeCardPageAdHelper;
        this.f58471d = z10;
        this.f58472e = z11;
    }

    public /* synthetic */ f(NativeWrapperAdView nativeWrapperAdView, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, NativeCardPageAdHelper nativeCardPageAdHelper, boolean z10, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(nativeWrapperAdView, biddingIntermediateMaterialBean, (i11 & 4) != 0 ? null : nativeCardPageAdHelper, (i11 & 8) != 0 ? false : z10, (i11 & 16) != 0 ? true : z11);
    }

    public final BiddingIntermediateMaterialBean a() {
        return this.f58469b;
    }

    public final boolean b() {
        return this.f58471d;
    }

    public final NativeCardPageAdHelper c() {
        return this.f58470c;
    }

    public final NativeWrapperAdView d() {
        return this.f58468a;
    }

    public final boolean e() {
        return this.f58472e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.c(this.f58468a, fVar.f58468a) && Intrinsics.c(this.f58469b, fVar.f58469b) && Intrinsics.c(this.f58470c, fVar.f58470c) && this.f58471d == fVar.f58471d && this.f58472e == fVar.f58472e;
    }

    public final void f(boolean z10) {
        this.f58471d = z10;
    }

    public final void g(NativeCardPageAdHelper nativeCardPageAdHelper) {
        this.f58470c = nativeCardPageAdHelper;
    }

    public final void h(boolean z10) {
        this.f58472e = z10;
    }

    public int hashCode() {
        int hashCode = ((this.f58468a.hashCode() * 31) + this.f58469b.hashCode()) * 31;
        NativeCardPageAdHelper nativeCardPageAdHelper = this.f58470c;
        return ((((hashCode + (nativeCardPageAdHelper == null ? 0 : nativeCardPageAdHelper.hashCode())) * 31) + androidx.compose.foundation.e.a(this.f58471d)) * 31) + androidx.compose.foundation.e.a(this.f58472e);
    }

    public String toString() {
        return "NativeCardPageData(nativeView=" + this.f58468a + ", adBean=" + this.f58469b + ", helper=" + this.f58470c + ", bind=" + this.f58471d + ", showGuide=" + this.f58472e + ")";
    }
}
