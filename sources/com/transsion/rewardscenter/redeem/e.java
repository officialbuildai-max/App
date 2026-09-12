package com.transsion.rewardscenter.redeem;

import com.transsion.rewardscenterapi.LotteryPrize;
import com.transsion.rewardscenterapi.SkuPoint;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class e {

    /* loaded from: classes6.dex */
    public static final class a extends e {

        /* renamed from: a, reason: collision with root package name */
        private final LotteryPrize f51073a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f51074b;

        /* renamed from: c, reason: collision with root package name */
        private final SkuPoint f51075c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LotteryPrize lotteryPrize, boolean z10, SkuPoint skuPoint) {
            super(null);
            Intrinsics.h(lotteryPrize, "lotteryPrize");
            this.f51073a = lotteryPrize;
            this.f51074b = z10;
            this.f51075c = skuPoint;
        }

        public final boolean a() {
            return this.f51074b;
        }

        public final LotteryPrize b() {
            return this.f51073a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f51073a, aVar.f51073a) && this.f51074b == aVar.f51074b && Intrinsics.c(this.f51075c, aVar.f51075c);
        }

        public int hashCode() {
            int hashCode = ((this.f51073a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f51074b)) * 31;
            SkuPoint skuPoint = this.f51075c;
            return hashCode + (skuPoint == null ? 0 : skuPoint.hashCode());
        }

        public String toString() {
            return "LotteryItem(lotteryPrize=" + this.f51073a + ", hasPaid=" + this.f51074b + ", skuPoint=" + this.f51075c + ")";
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends e {

        /* renamed from: a, reason: collision with root package name */
        private final SkuPoint f51076a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f51077b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SkuPoint skuPoint, boolean z10) {
            super(null);
            Intrinsics.h(skuPoint, "skuPoint");
            this.f51076a = skuPoint;
            this.f51077b = z10;
        }

        public final boolean a() {
            return this.f51077b;
        }

        public final SkuPoint b() {
            return this.f51076a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.c(this.f51076a, bVar.f51076a) && this.f51077b == bVar.f51077b;
        }

        public int hashCode() {
            return (this.f51076a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f51077b);
        }

        public String toString() {
            return "SkuItem(skuPoint=" + this.f51076a + ", hasPaid=" + this.f51077b + ")";
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends e {

        /* renamed from: a, reason: collision with root package name */
        private final String f51078a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String title) {
            super(null);
            Intrinsics.h(title, "title");
            this.f51078a = title;
        }

        public final String a() {
            return this.f51078a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.c(this.f51078a, ((c) obj).f51078a);
        }

        public int hashCode() {
            return this.f51078a.hashCode();
        }

        public String toString() {
            return "TitleItem(title=" + this.f51078a + ")";
        }
    }

    private e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
