package ez;

import com.vungle.ads.internal.util.q;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.h0;
import kotlinx.serialization.internal.i;
import kotlinx.serialization.internal.i0;
import kotlinx.serialization.internal.w1;

/* loaded from: classes7.dex */
public final class d {
    public static final b Companion = new b(null);
    private Float earningsByPlacementUSD;
    private Boolean isUserAPurchaser;
    private Boolean isUserASubscriber;
    private Float last30DaysMeanSpendUSD;
    private Float last30DaysMedianSpendUSD;
    private Float last30DaysPlacementFillRate;
    private Float last30DaysTotalSpendUSD;
    private Float last30DaysUserLtvUSD;
    private Float last30DaysUserPltvUSD;
    private Float last7DaysMeanSpendUSD;
    private Float last7DaysMedianSpendUSD;
    private Float last7DaysPlacementFillRate;
    private Float last7DaysTotalSpendUSD;
    private Float last7DaysUserLtvUSD;
    private Float last7DaysUserPltvUSD;
    private List<String> topNAdomain;
    private Float totalEarningsUSD;

    /* loaded from: classes7.dex */
    public static final class a implements i0 {
        public static final a INSTANCE;
        public static final /* synthetic */ f descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.Revenue", aVar, 17);
            pluginGeneratedSerialDescriptor.l("total_earnings_usd", true);
            pluginGeneratedSerialDescriptor.l("earnings_by_placement_usd", true);
            pluginGeneratedSerialDescriptor.l("top_n_adomain", true);
            pluginGeneratedSerialDescriptor.l("is_user_a_purchaser", true);
            pluginGeneratedSerialDescriptor.l("is_user_a_subscriber", true);
            pluginGeneratedSerialDescriptor.l("last_7_days_total_spend_usd", true);
            pluginGeneratedSerialDescriptor.l("last_7_days_median_spend_usd", true);
            pluginGeneratedSerialDescriptor.l("last_7_days_mean_spend_usd", true);
            pluginGeneratedSerialDescriptor.l("last_30_days_total_spend_usd", true);
            pluginGeneratedSerialDescriptor.l("last_30_days_median_spend_usd", true);
            pluginGeneratedSerialDescriptor.l("last_30_days_mean_spend_usd", true);
            pluginGeneratedSerialDescriptor.l("last_7_days_user_pltv_usd", true);
            pluginGeneratedSerialDescriptor.l("last_7_days_user_ltv_usd", true);
            pluginGeneratedSerialDescriptor.l("last_30_days_user_pltv_usd", true);
            pluginGeneratedSerialDescriptor.l("last_30_days_user_ltv_usd", true);
            pluginGeneratedSerialDescriptor.l("last_7_days_placement_fill_rate", true);
            pluginGeneratedSerialDescriptor.l("last_30_days_placement_fill_rate", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // kotlinx.serialization.internal.i0
        public kotlinx.serialization.b[] childSerializers() {
            h0 h0Var = h0.f68269a;
            kotlinx.serialization.b s11 = d00.a.s(h0Var);
            kotlinx.serialization.b s12 = d00.a.s(h0Var);
            kotlinx.serialization.b s13 = d00.a.s(new kotlinx.serialization.internal.f(b2.f68235a));
            i iVar = i.f68275a;
            return new kotlinx.serialization.b[]{s11, s12, s13, d00.a.s(iVar), d00.a.s(iVar), d00.a.s(h0Var), d00.a.s(h0Var), d00.a.s(h0Var), d00.a.s(h0Var), d00.a.s(h0Var), d00.a.s(h0Var), d00.a.s(h0Var), d00.a.s(h0Var), d00.a.s(h0Var), d00.a.s(h0Var), d00.a.s(h0Var), d00.a.s(h0Var)};
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00ba. Please report as an issue. */
        @Override // kotlinx.serialization.a
        public d deserialize(e00.e decoder) {
            Object obj;
            Object obj2;
            Object obj3;
            int i11;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            Object obj10;
            Object obj11;
            Object obj12;
            Object obj13;
            Object obj14;
            Object obj15;
            Object obj16;
            Object obj17;
            Object obj18;
            Object obj19;
            Object obj20;
            Object obj21;
            Object obj22;
            Object obj23;
            Intrinsics.h(decoder, "decoder");
            f descriptor2 = getDescriptor();
            e00.c b11 = decoder.b(descriptor2);
            if (b11.p()) {
                h0 h0Var = h0.f68269a;
                Object n11 = b11.n(descriptor2, 0, h0Var, null);
                Object n12 = b11.n(descriptor2, 1, h0Var, null);
                Object n13 = b11.n(descriptor2, 2, new kotlinx.serialization.internal.f(b2.f68235a), null);
                i iVar = i.f68275a;
                obj3 = b11.n(descriptor2, 3, iVar, null);
                obj9 = b11.n(descriptor2, 4, iVar, null);
                obj14 = b11.n(descriptor2, 5, h0Var, null);
                obj16 = b11.n(descriptor2, 6, h0Var, null);
                obj13 = b11.n(descriptor2, 7, h0Var, null);
                obj15 = b11.n(descriptor2, 8, h0Var, null);
                obj12 = b11.n(descriptor2, 9, h0Var, null);
                obj17 = b11.n(descriptor2, 10, h0Var, null);
                obj11 = b11.n(descriptor2, 11, h0Var, null);
                obj8 = b11.n(descriptor2, 12, h0Var, null);
                obj7 = b11.n(descriptor2, 13, h0Var, null);
                obj6 = b11.n(descriptor2, 14, h0Var, null);
                Object n14 = b11.n(descriptor2, 15, h0Var, null);
                obj4 = b11.n(descriptor2, 16, h0Var, null);
                obj = n12;
                i11 = 131071;
                obj2 = n11;
                obj5 = n14;
                obj10 = n13;
            } else {
                boolean z10 = true;
                Object obj24 = null;
                Object obj25 = null;
                Object obj26 = null;
                Object obj27 = null;
                Object obj28 = null;
                Object obj29 = null;
                Object obj30 = null;
                Object obj31 = null;
                Object obj32 = null;
                Object obj33 = null;
                Object obj34 = null;
                Object obj35 = null;
                Object obj36 = null;
                Object obj37 = null;
                Object obj38 = null;
                Object obj39 = null;
                int i12 = 0;
                Object obj40 = null;
                while (z10) {
                    int o11 = b11.o(descriptor2);
                    switch (o11) {
                        case -1:
                            obj18 = obj40;
                            obj19 = obj26;
                            obj20 = obj39;
                            obj21 = obj27;
                            z10 = false;
                            obj26 = obj19;
                            obj27 = obj21;
                            obj39 = obj20;
                            obj40 = obj18;
                        case 0:
                            obj18 = obj40;
                            obj19 = obj26;
                            Object obj41 = obj39;
                            obj21 = obj27;
                            obj20 = b11.n(descriptor2, 0, h0.f68269a, obj41);
                            i12 |= 1;
                            obj26 = obj19;
                            obj27 = obj21;
                            obj39 = obj20;
                            obj40 = obj18;
                        case 1:
                            i12 |= 2;
                            obj27 = b11.n(descriptor2, 1, h0.f68269a, obj27);
                            obj26 = obj26;
                            obj40 = obj40;
                        case 2:
                            obj22 = obj26;
                            obj23 = obj27;
                            obj40 = b11.n(descriptor2, 2, new kotlinx.serialization.internal.f(b2.f68235a), obj40);
                            i12 |= 4;
                            obj26 = obj22;
                            obj27 = obj23;
                        case 3:
                            obj22 = obj26;
                            obj23 = obj27;
                            obj25 = b11.n(descriptor2, 3, i.f68275a, obj25);
                            i12 |= 8;
                            obj26 = obj22;
                            obj27 = obj23;
                        case 4:
                            obj22 = obj26;
                            obj23 = obj27;
                            obj24 = b11.n(descriptor2, 4, i.f68275a, obj24);
                            i12 |= 16;
                            obj26 = obj22;
                            obj27 = obj23;
                        case 5:
                            obj22 = obj26;
                            obj23 = obj27;
                            obj32 = b11.n(descriptor2, 5, h0.f68269a, obj32);
                            i12 |= 32;
                            obj26 = obj22;
                            obj27 = obj23;
                        case 6:
                            obj22 = obj26;
                            obj23 = obj27;
                            obj33 = b11.n(descriptor2, 6, h0.f68269a, obj33);
                            i12 |= 64;
                            obj26 = obj22;
                            obj27 = obj23;
                        case 7:
                            obj22 = obj26;
                            obj23 = obj27;
                            obj31 = b11.n(descriptor2, 7, h0.f68269a, obj31);
                            i12 |= 128;
                            obj26 = obj22;
                            obj27 = obj23;
                        case 8:
                            obj22 = obj26;
                            obj23 = obj27;
                            obj30 = b11.n(descriptor2, 8, h0.f68269a, obj30);
                            i12 |= 256;
                            obj26 = obj22;
                            obj27 = obj23;
                        case 9:
                            obj22 = obj26;
                            obj23 = obj27;
                            obj29 = b11.n(descriptor2, 9, h0.f68269a, obj29);
                            i12 |= 512;
                            obj26 = obj22;
                            obj27 = obj23;
                        case 10:
                            obj22 = obj26;
                            obj23 = obj27;
                            obj34 = b11.n(descriptor2, 10, h0.f68269a, obj34);
                            i12 |= 1024;
                            obj26 = obj22;
                            obj27 = obj23;
                        case 11:
                            obj22 = obj26;
                            obj23 = obj27;
                            obj28 = b11.n(descriptor2, 11, h0.f68269a, obj28);
                            i12 |= 2048;
                            obj26 = obj22;
                            obj27 = obj23;
                        case 12:
                            obj23 = obj27;
                            obj35 = b11.n(descriptor2, 12, h0.f68269a, obj35);
                            i12 |= 4096;
                            obj26 = obj26;
                            obj36 = obj36;
                            obj27 = obj23;
                        case 13:
                            obj23 = obj27;
                            obj36 = b11.n(descriptor2, 13, h0.f68269a, obj36);
                            i12 |= 8192;
                            obj26 = obj26;
                            obj37 = obj37;
                            obj27 = obj23;
                        case 14:
                            obj23 = obj27;
                            obj37 = b11.n(descriptor2, 14, h0.f68269a, obj37);
                            i12 |= 16384;
                            obj26 = obj26;
                            obj38 = obj38;
                            obj27 = obj23;
                        case 15:
                            obj23 = obj27;
                            obj22 = obj26;
                            obj38 = b11.n(descriptor2, 15, h0.f68269a, obj38);
                            i12 |= 32768;
                            obj26 = obj22;
                            obj27 = obj23;
                        case 16:
                            obj26 = b11.n(descriptor2, 16, h0.f68269a, obj26);
                            i12 |= 65536;
                            obj27 = obj27;
                        default:
                            throw new UnknownFieldException(o11);
                    }
                }
                Object obj42 = obj40;
                Object obj43 = obj39;
                obj = obj27;
                obj2 = obj43;
                obj3 = obj25;
                i11 = i12;
                obj4 = obj26;
                obj5 = obj38;
                obj6 = obj37;
                obj7 = obj36;
                obj8 = obj35;
                obj9 = obj24;
                obj10 = obj42;
                Object obj44 = obj34;
                obj11 = obj28;
                obj12 = obj29;
                obj13 = obj31;
                obj14 = obj32;
                obj15 = obj30;
                obj16 = obj33;
                obj17 = obj44;
            }
            b11.c(descriptor2);
            return new d(i11, (Float) obj2, (Float) obj, (List) obj10, (Boolean) obj3, (Boolean) obj9, (Float) obj14, (Float) obj16, (Float) obj13, (Float) obj15, (Float) obj12, (Float) obj17, (Float) obj11, (Float) obj8, (Float) obj7, (Float) obj6, (Float) obj5, (Float) obj4, null);
        }

        @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
        public f getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.g
        public void serialize(e00.f encoder, d value) {
            Intrinsics.h(encoder, "encoder");
            Intrinsics.h(value, "value");
            f descriptor2 = getDescriptor();
            e00.d b11 = encoder.b(descriptor2);
            d.write$Self(value, b11, descriptor2);
            b11.c(descriptor2);
        }

        @Override // kotlinx.serialization.internal.i0
        public kotlinx.serialization.b[] typeParametersSerializers() {
            return i0.a.a(this);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final kotlinx.serialization.b serializer() {
            return a.INSTANCE;
        }
    }

    public d() {
    }

    @Deprecated
    public /* synthetic */ d(int i11, Float f11, Float f12, List list, Boolean bool, Boolean bool2, Float f13, Float f14, Float f15, Float f16, Float f17, Float f18, Float f19, Float f20, Float f21, Float f22, Float f23, Float f24, w1 w1Var) {
        if ((i11 & 1) == 0) {
            this.totalEarningsUSD = null;
        } else {
            this.totalEarningsUSD = f11;
        }
        if ((i11 & 2) == 0) {
            this.earningsByPlacementUSD = null;
        } else {
            this.earningsByPlacementUSD = f12;
        }
        if ((i11 & 4) == 0) {
            this.topNAdomain = null;
        } else {
            this.topNAdomain = list;
        }
        if ((i11 & 8) == 0) {
            this.isUserAPurchaser = null;
        } else {
            this.isUserAPurchaser = bool;
        }
        if ((i11 & 16) == 0) {
            this.isUserASubscriber = null;
        } else {
            this.isUserASubscriber = bool2;
        }
        if ((i11 & 32) == 0) {
            this.last7DaysTotalSpendUSD = null;
        } else {
            this.last7DaysTotalSpendUSD = f13;
        }
        if ((i11 & 64) == 0) {
            this.last7DaysMedianSpendUSD = null;
        } else {
            this.last7DaysMedianSpendUSD = f14;
        }
        if ((i11 & 128) == 0) {
            this.last7DaysMeanSpendUSD = null;
        } else {
            this.last7DaysMeanSpendUSD = f15;
        }
        if ((i11 & 256) == 0) {
            this.last30DaysTotalSpendUSD = null;
        } else {
            this.last30DaysTotalSpendUSD = f16;
        }
        if ((i11 & 512) == 0) {
            this.last30DaysMedianSpendUSD = null;
        } else {
            this.last30DaysMedianSpendUSD = f17;
        }
        if ((i11 & 1024) == 0) {
            this.last30DaysMeanSpendUSD = null;
        } else {
            this.last30DaysMeanSpendUSD = f18;
        }
        if ((i11 & 2048) == 0) {
            this.last7DaysUserPltvUSD = null;
        } else {
            this.last7DaysUserPltvUSD = f19;
        }
        if ((i11 & 4096) == 0) {
            this.last7DaysUserLtvUSD = null;
        } else {
            this.last7DaysUserLtvUSD = f20;
        }
        if ((i11 & 8192) == 0) {
            this.last30DaysUserPltvUSD = null;
        } else {
            this.last30DaysUserPltvUSD = f21;
        }
        if ((i11 & 16384) == 0) {
            this.last30DaysUserLtvUSD = null;
        } else {
            this.last30DaysUserLtvUSD = f22;
        }
        if ((32768 & i11) == 0) {
            this.last7DaysPlacementFillRate = null;
        } else {
            this.last7DaysPlacementFillRate = f23;
        }
        if ((i11 & 65536) == 0) {
            this.last30DaysPlacementFillRate = null;
        } else {
            this.last30DaysPlacementFillRate = f24;
        }
    }

    private static /* synthetic */ void getEarningsByPlacementUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysMeanSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysMedianSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysPlacementFillRate$annotations() {
    }

    private static /* synthetic */ void getLast30DaysTotalSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysUserLtvUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysUserPltvUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysMeanSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysMedianSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysPlacementFillRate$annotations() {
    }

    private static /* synthetic */ void getLast7DaysTotalSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysUserLtvUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysUserPltvUSD$annotations() {
    }

    private static /* synthetic */ void getTopNAdomain$annotations() {
    }

    private static /* synthetic */ void getTotalEarningsUSD$annotations() {
    }

    private static /* synthetic */ void isUserAPurchaser$annotations() {
    }

    private static /* synthetic */ void isUserASubscriber$annotations() {
    }

    @JvmStatic
    public static final void write$Self(d self, e00.d output, f serialDesc) {
        Intrinsics.h(self, "self");
        Intrinsics.h(output, "output");
        Intrinsics.h(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self.totalEarningsUSD != null) {
            output.i(serialDesc, 0, h0.f68269a, self.totalEarningsUSD);
        }
        if (output.z(serialDesc, 1) || self.earningsByPlacementUSD != null) {
            output.i(serialDesc, 1, h0.f68269a, self.earningsByPlacementUSD);
        }
        if (output.z(serialDesc, 2) || self.topNAdomain != null) {
            output.i(serialDesc, 2, new kotlinx.serialization.internal.f(b2.f68235a), self.topNAdomain);
        }
        if (output.z(serialDesc, 3) || self.isUserAPurchaser != null) {
            output.i(serialDesc, 3, i.f68275a, self.isUserAPurchaser);
        }
        if (output.z(serialDesc, 4) || self.isUserASubscriber != null) {
            output.i(serialDesc, 4, i.f68275a, self.isUserASubscriber);
        }
        if (output.z(serialDesc, 5) || self.last7DaysTotalSpendUSD != null) {
            output.i(serialDesc, 5, h0.f68269a, self.last7DaysTotalSpendUSD);
        }
        if (output.z(serialDesc, 6) || self.last7DaysMedianSpendUSD != null) {
            output.i(serialDesc, 6, h0.f68269a, self.last7DaysMedianSpendUSD);
        }
        if (output.z(serialDesc, 7) || self.last7DaysMeanSpendUSD != null) {
            output.i(serialDesc, 7, h0.f68269a, self.last7DaysMeanSpendUSD);
        }
        if (output.z(serialDesc, 8) || self.last30DaysTotalSpendUSD != null) {
            output.i(serialDesc, 8, h0.f68269a, self.last30DaysTotalSpendUSD);
        }
        if (output.z(serialDesc, 9) || self.last30DaysMedianSpendUSD != null) {
            output.i(serialDesc, 9, h0.f68269a, self.last30DaysMedianSpendUSD);
        }
        if (output.z(serialDesc, 10) || self.last30DaysMeanSpendUSD != null) {
            output.i(serialDesc, 10, h0.f68269a, self.last30DaysMeanSpendUSD);
        }
        if (output.z(serialDesc, 11) || self.last7DaysUserPltvUSD != null) {
            output.i(serialDesc, 11, h0.f68269a, self.last7DaysUserPltvUSD);
        }
        if (output.z(serialDesc, 12) || self.last7DaysUserLtvUSD != null) {
            output.i(serialDesc, 12, h0.f68269a, self.last7DaysUserLtvUSD);
        }
        if (output.z(serialDesc, 13) || self.last30DaysUserPltvUSD != null) {
            output.i(serialDesc, 13, h0.f68269a, self.last30DaysUserPltvUSD);
        }
        if (output.z(serialDesc, 14) || self.last30DaysUserLtvUSD != null) {
            output.i(serialDesc, 14, h0.f68269a, self.last30DaysUserLtvUSD);
        }
        if (output.z(serialDesc, 15) || self.last7DaysPlacementFillRate != null) {
            output.i(serialDesc, 15, h0.f68269a, self.last7DaysPlacementFillRate);
        }
        if (!output.z(serialDesc, 16) && self.last30DaysPlacementFillRate == null) {
            return;
        }
        output.i(serialDesc, 16, h0.f68269a, self.last30DaysPlacementFillRate);
    }

    public final d setEarningsByPlacement(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.earningsByPlacementUSD = Float.valueOf(f11);
        }
        return this;
    }

    public final d setIsUserAPurchaser(boolean z10) {
        this.isUserAPurchaser = Boolean.valueOf(z10);
        return this;
    }

    public final d setIsUserASubscriber(boolean z10) {
        this.isUserASubscriber = Boolean.valueOf(z10);
        return this;
    }

    public final d setLast30DaysMeanSpendUsd(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysMeanSpendUSD = Float.valueOf(f11);
        }
        return this;
    }

    public final d setLast30DaysMedianSpendUsd(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysMedianSpendUSD = Float.valueOf(f11);
        }
        return this;
    }

    public final d setLast30DaysPlacementFillRate(float f11) {
        if (q.INSTANCE.isInRange(f11, 0.0f, 100.0f)) {
            this.last30DaysPlacementFillRate = Float.valueOf(f11);
        }
        return this;
    }

    public final d setLast30DaysTotalSpendUsd(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysTotalSpendUSD = Float.valueOf(f11);
        }
        return this;
    }

    public final d setLast30DaysUserLtvUsd(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysUserLtvUSD = Float.valueOf(f11);
        }
        return this;
    }

    public final d setLast30DaysUserPltvUsd(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysUserPltvUSD = Float.valueOf(f11);
        }
        return this;
    }

    public final d setLast7DaysMeanSpendUsd(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysMeanSpendUSD = Float.valueOf(f11);
        }
        return this;
    }

    public final d setLast7DaysMedianSpendUsd(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysMedianSpendUSD = Float.valueOf(f11);
        }
        return this;
    }

    public final d setLast7DaysPlacementFillRate(float f11) {
        if (q.INSTANCE.isInRange(f11, 0.0f, 100.0f)) {
            this.last7DaysPlacementFillRate = Float.valueOf(f11);
        }
        return this;
    }

    public final d setLast7DaysTotalSpendUsd(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysTotalSpendUSD = Float.valueOf(f11);
        }
        return this;
    }

    public final d setLast7DaysUserLtvUsd(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysUserLtvUSD = Float.valueOf(f11);
        }
        return this;
    }

    public final d setLast7DaysUserPltvUsd(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysUserPltvUSD = Float.valueOf(f11);
        }
        return this;
    }

    public final d setTopNAdomain(List<String> list) {
        this.topNAdomain = list != null ? CollectionsKt.U0(list) : null;
        return this;
    }

    public final d setTotalEarningsUsd(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.totalEarningsUSD = Float.valueOf(f11);
        }
        return this;
    }
}
