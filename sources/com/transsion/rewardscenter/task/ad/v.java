package com.transsion.rewardscenter.task.ad;

import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class v {

    /* loaded from: classes6.dex */
    public static final class a extends v {

        /* renamed from: a, reason: collision with root package name */
        private final BiddingIntermediateMaterialBean f51187a;

        /* renamed from: b, reason: collision with root package name */
        private NativeWrapperAdView f51188b;

        /* renamed from: c, reason: collision with root package name */
        private com.transsion.ad.bidding.base.r f51189c;

        /* renamed from: d, reason: collision with root package name */
        private com.transsion.ad.bidding.base.u f51190d;

        /* renamed from: e, reason: collision with root package name */
        private AdTaskState f51191e;

        /* renamed from: f, reason: collision with root package name */
        private String f51192f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f51193g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f51194h;

        /* renamed from: i, reason: collision with root package name */
        private long f51195i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BiddingIntermediateMaterialBean adBean, NativeWrapperAdView nativeWrapperAdView, com.transsion.ad.bidding.base.r rVar, com.transsion.ad.bidding.base.u uVar, AdTaskState adTaskState, String packageName, boolean z10, boolean z11, long j11) {
            super(null);
            Intrinsics.h(adBean, "adBean");
            Intrinsics.h(adTaskState, "adTaskState");
            Intrinsics.h(packageName, "packageName");
            this.f51187a = adBean;
            this.f51188b = nativeWrapperAdView;
            this.f51189c = rVar;
            this.f51190d = uVar;
            this.f51191e = adTaskState;
            this.f51192f = packageName;
            this.f51193g = z10;
            this.f51194h = z11;
            this.f51195i = j11;
        }

        public /* synthetic */ a(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, NativeWrapperAdView nativeWrapperAdView, com.transsion.ad.bidding.base.r rVar, com.transsion.ad.bidding.base.u uVar, AdTaskState adTaskState, String str, boolean z10, boolean z11, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(biddingIntermediateMaterialBean, (i11 & 2) != 0 ? null : nativeWrapperAdView, (i11 & 4) != 0 ? null : rVar, (i11 & 8) == 0 ? uVar : null, (i11 & 16) != 0 ? AdTaskState.NORMAL : adTaskState, (i11 & 32) != 0 ? "" : str, (i11 & 64) != 0 ? false : z10, (i11 & 128) == 0 ? z11 : false, (i11 & 256) != 0 ? 0L : j11);
        }

        public final a a(BiddingIntermediateMaterialBean adBean, NativeWrapperAdView nativeWrapperAdView, com.transsion.ad.bidding.base.r rVar, com.transsion.ad.bidding.base.u uVar, AdTaskState adTaskState, String packageName, boolean z10, boolean z11, long j11) {
            Intrinsics.h(adBean, "adBean");
            Intrinsics.h(adTaskState, "adTaskState");
            Intrinsics.h(packageName, "packageName");
            return new a(adBean, nativeWrapperAdView, rVar, uVar, adTaskState, packageName, z10, z11, j11);
        }

        public final BiddingIntermediateMaterialBean c() {
            return this.f51187a;
        }

        public final com.transsion.ad.bidding.base.r d() {
            return this.f51189c;
        }

        public final AdTaskState e() {
            return this.f51191e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f51187a, aVar.f51187a) && Intrinsics.c(this.f51188b, aVar.f51188b) && Intrinsics.c(this.f51189c, aVar.f51189c) && Intrinsics.c(this.f51190d, aVar.f51190d) && this.f51191e == aVar.f51191e && Intrinsics.c(this.f51192f, aVar.f51192f) && this.f51193g == aVar.f51193g && this.f51194h == aVar.f51194h && this.f51195i == aVar.f51195i;
        }

        public final boolean f() {
            return this.f51194h;
        }

        public final long g() {
            return this.f51195i;
        }

        public final NativeWrapperAdView h() {
            return this.f51188b;
        }

        public int hashCode() {
            int hashCode = this.f51187a.hashCode() * 31;
            NativeWrapperAdView nativeWrapperAdView = this.f51188b;
            int hashCode2 = (hashCode + (nativeWrapperAdView == null ? 0 : nativeWrapperAdView.hashCode())) * 31;
            com.transsion.ad.bidding.base.r rVar = this.f51189c;
            int hashCode3 = (hashCode2 + (rVar == null ? 0 : rVar.hashCode())) * 31;
            com.transsion.ad.bidding.base.u uVar = this.f51190d;
            return ((((((((((hashCode3 + (uVar != null ? uVar.hashCode() : 0)) * 31) + this.f51191e.hashCode()) * 31) + this.f51192f.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f51193g)) * 31) + androidx.compose.foundation.e.a(this.f51194h)) * 31) + androidx.collection.s.a(this.f51195i);
        }

        public final String i() {
            return this.f51192f;
        }

        public final com.transsion.ad.bidding.base.u j() {
            return this.f51190d;
        }

        public final boolean k() {
            return this.f51193g;
        }

        public final void l(com.transsion.ad.bidding.base.r rVar) {
            this.f51189c = rVar;
        }

        public final void m(AdTaskState adTaskState) {
            Intrinsics.h(adTaskState, "<set-?>");
            this.f51191e = adTaskState;
        }

        public final void n(boolean z10) {
            this.f51194h = z10;
        }

        public final void o(long j11) {
            this.f51195i = j11;
        }

        public final void p(NativeWrapperAdView nativeWrapperAdView) {
            this.f51188b = nativeWrapperAdView;
        }

        public final void q(com.transsion.ad.bidding.base.u uVar) {
            this.f51190d = uVar;
        }

        public String toString() {
            return "RegularItem(adBean=" + this.f51187a + ", nativeAdView=" + this.f51188b + ", adLayoutProvider=" + this.f51189c + ", sspLayoutProvider=" + this.f51190d + ", adTaskState=" + this.f51191e + ", packageName=" + this.f51192f + ", isPullNewAd=" + this.f51193g + ", bind=" + this.f51194h + ", downloadStartTime=" + this.f51195i + ")";
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends v {

        /* renamed from: a, reason: collision with root package name */
        private final AdTaskState f51196a;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AdTaskState adTaskState) {
            super(null);
            Intrinsics.h(adTaskState, "adTaskState");
            this.f51196a = adTaskState;
        }

        public /* synthetic */ b(AdTaskState adTaskState, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? AdTaskState.NORMAL : adTaskState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.f51196a == ((b) obj).f51196a;
        }

        public int hashCode() {
            return this.f51196a.hashCode();
        }

        public String toString() {
            return "RewardItem(adTaskState=" + this.f51196a + ")";
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends v {

        /* renamed from: a, reason: collision with root package name */
        private final BiddingIntermediateMaterialBean f51197a;

        /* renamed from: b, reason: collision with root package name */
        private NativeWrapperAdView f51198b;

        /* renamed from: c, reason: collision with root package name */
        private com.transsion.ad.bidding.base.r f51199c;

        /* renamed from: d, reason: collision with root package name */
        private com.transsion.ad.bidding.base.u f51200d;

        /* renamed from: e, reason: collision with root package name */
        private AdTaskState f51201e;

        /* renamed from: f, reason: collision with root package name */
        private String f51202f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f51203g;

        /* renamed from: h, reason: collision with root package name */
        private long f51204h;

        /* renamed from: i, reason: collision with root package name */
        private long f51205i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BiddingIntermediateMaterialBean adBean, NativeWrapperAdView nativeWrapperAdView, com.transsion.ad.bidding.base.r rVar, com.transsion.ad.bidding.base.u uVar, AdTaskState adTaskState, String packageName, boolean z10, long j11, long j12) {
            super(null);
            Intrinsics.h(adBean, "adBean");
            Intrinsics.h(adTaskState, "adTaskState");
            Intrinsics.h(packageName, "packageName");
            this.f51197a = adBean;
            this.f51198b = nativeWrapperAdView;
            this.f51199c = rVar;
            this.f51200d = uVar;
            this.f51201e = adTaskState;
            this.f51202f = packageName;
            this.f51203g = z10;
            this.f51204h = j11;
            this.f51205i = j12;
        }

        public /* synthetic */ c(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, NativeWrapperAdView nativeWrapperAdView, com.transsion.ad.bidding.base.r rVar, com.transsion.ad.bidding.base.u uVar, AdTaskState adTaskState, String str, boolean z10, long j11, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(biddingIntermediateMaterialBean, (i11 & 2) != 0 ? null : nativeWrapperAdView, (i11 & 4) != 0 ? null : rVar, (i11 & 8) == 0 ? uVar : null, (i11 & 16) != 0 ? AdTaskState.NORMAL : adTaskState, (i11 & 32) != 0 ? "" : str, (i11 & 64) != 0 ? false : z10, (i11 & 128) != 0 ? 0L : j11, (i11 & 256) == 0 ? j12 : 0L);
        }

        public final c a(BiddingIntermediateMaterialBean adBean, NativeWrapperAdView nativeWrapperAdView, com.transsion.ad.bidding.base.r rVar, com.transsion.ad.bidding.base.u uVar, AdTaskState adTaskState, String packageName, boolean z10, long j11, long j12) {
            Intrinsics.h(adBean, "adBean");
            Intrinsics.h(adTaskState, "adTaskState");
            Intrinsics.h(packageName, "packageName");
            return new c(adBean, nativeWrapperAdView, rVar, uVar, adTaskState, packageName, z10, j11, j12);
        }

        public final BiddingIntermediateMaterialBean c() {
            return this.f51197a;
        }

        public final com.transsion.ad.bidding.base.r d() {
            return this.f51199c;
        }

        public final AdTaskState e() {
            return this.f51201e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.c(this.f51197a, cVar.f51197a) && Intrinsics.c(this.f51198b, cVar.f51198b) && Intrinsics.c(this.f51199c, cVar.f51199c) && Intrinsics.c(this.f51200d, cVar.f51200d) && this.f51201e == cVar.f51201e && Intrinsics.c(this.f51202f, cVar.f51202f) && this.f51203g == cVar.f51203g && this.f51204h == cVar.f51204h && this.f51205i == cVar.f51205i;
        }

        public final boolean f() {
            return this.f51203g;
        }

        public final long g() {
            return this.f51205i;
        }

        public final NativeWrapperAdView h() {
            return this.f51198b;
        }

        public int hashCode() {
            int hashCode = this.f51197a.hashCode() * 31;
            NativeWrapperAdView nativeWrapperAdView = this.f51198b;
            int hashCode2 = (hashCode + (nativeWrapperAdView == null ? 0 : nativeWrapperAdView.hashCode())) * 31;
            com.transsion.ad.bidding.base.r rVar = this.f51199c;
            int hashCode3 = (hashCode2 + (rVar == null ? 0 : rVar.hashCode())) * 31;
            com.transsion.ad.bidding.base.u uVar = this.f51200d;
            return ((((((((((hashCode3 + (uVar != null ? uVar.hashCode() : 0)) * 31) + this.f51201e.hashCode()) * 31) + this.f51202f.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f51203g)) * 31) + androidx.collection.s.a(this.f51204h)) * 31) + androidx.collection.s.a(this.f51205i);
        }

        public final String i() {
            return this.f51202f;
        }

        public final long j() {
            return this.f51204h;
        }

        public final com.transsion.ad.bidding.base.u k() {
            return this.f51200d;
        }

        public final void l(com.transsion.ad.bidding.base.r rVar) {
            this.f51199c = rVar;
        }

        public final void m(AdTaskState adTaskState) {
            Intrinsics.h(adTaskState, "<set-?>");
            this.f51201e = adTaskState;
        }

        public final void n(boolean z10) {
            this.f51203g = z10;
        }

        public final void o(long j11) {
            this.f51205i = j11;
        }

        public final void p(NativeWrapperAdView nativeWrapperAdView) {
            this.f51198b = nativeWrapperAdView;
        }

        public final void q(long j11) {
            this.f51204h = j11;
        }

        public final void r(com.transsion.ad.bidding.base.u uVar) {
            this.f51200d = uVar;
        }

        public String toString() {
            return "StageItem(adBean=" + this.f51197a + ", nativeAdView=" + this.f51198b + ", adLayoutProvider=" + this.f51199c + ", sspLayoutProvider=" + this.f51200d + ", adTaskState=" + this.f51201e + ", packageName=" + this.f51202f + ", bind=" + this.f51203g + ", playedTime=" + this.f51204h + ", downloadStartTime=" + this.f51205i + ")";
        }
    }

    private v() {
    }

    public /* synthetic */ v(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
