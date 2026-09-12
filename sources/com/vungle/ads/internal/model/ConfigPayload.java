package com.vungle.ads.internal.model;

import com.cloud.config.utils.XLogUtil;
import com.vungle.ads.internal.model.g;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.b1;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.i0;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.w1;

/* loaded from: classes7.dex */
public final class ConfigPayload {
    public static final d Companion = new d(null);
    private b autoRedirect;
    private final c cleverCache;
    private final String configExtension;
    private Long configLastValidatedTimestamp;
    private final e configSettings;
    private final Boolean disableAdId;
    private Boolean enableOT;
    private final f endpoints;
    private final Boolean fpdEnabled;
    private final Boolean isReportIncentivizedEnabled;
    private final h logMetricsSettings;
    private final List<com.vungle.ads.internal.model.g> placements;
    private Boolean retryPriorityTPATs;
    private final Boolean rtaDebugging;
    private final Integer sessionTimeout;
    private final Integer signalSessionTimeout;
    private final Boolean signalsDisabled;
    private final i userPrivacy;
    private final Boolean waitForConnectivityForTPAT;

    /* loaded from: classes7.dex */
    public static final class IABSettings {
        public static final b Companion = new b(null);
        private final Integer tcfStatus;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/vungle/ads/internal/model/ConfigPayload$IABSettings$TcfStatus;", "", "", "rawValue", "<init>", "(Ljava/lang/String;II)V", "I", "getRawValue", "()I", "Companion", "a", "ALLOW_ID", "DISABLE_ID", "LEGACY", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
        /* loaded from: classes7.dex */
        public enum TcfStatus {
            ALLOW_ID(0),
            DISABLE_ID(1),
            LEGACY(2);


            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Map<Integer, TcfStatus> rawValueMap;
            private final int rawValue;

            /* renamed from: com.vungle.ads.internal.model.ConfigPayload$IABSettings$TcfStatus$a, reason: from kotlin metadata */
            /* loaded from: classes7.dex */
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final TcfStatus fromRawValue(Integer num) {
                    return (TcfStatus) TcfStatus.rawValueMap.get(num);
                }
            }

            static {
                TcfStatus[] values = values();
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.e(values.length), 16));
                for (TcfStatus tcfStatus : values) {
                    linkedHashMap.put(Integer.valueOf(tcfStatus.rawValue), tcfStatus);
                }
                rawValueMap = linkedHashMap;
            }

            TcfStatus(int i11) {
                this.rawValue = i11;
            }

            public final int getRawValue() {
                return this.rawValue;
            }
        }

        /* loaded from: classes7.dex */
        public static final class a implements i0 {
            public static final a INSTANCE;
            public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.IABSettings", aVar, 1);
                pluginGeneratedSerialDescriptor.l("tcf_status", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // kotlinx.serialization.internal.i0
            public kotlinx.serialization.b[] childSerializers() {
                return new kotlinx.serialization.b[]{d00.a.s(r0.f68315a)};
            }

            @Override // kotlinx.serialization.a
            public IABSettings deserialize(e00.e decoder) {
                Object obj;
                Intrinsics.h(decoder, "decoder");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.c b11 = decoder.b(descriptor2);
                int i11 = 1;
                w1 w1Var = null;
                if (b11.p()) {
                    obj = b11.n(descriptor2, 0, r0.f68315a, null);
                } else {
                    boolean z10 = true;
                    int i12 = 0;
                    obj = null;
                    while (z10) {
                        int o11 = b11.o(descriptor2);
                        if (o11 == -1) {
                            z10 = false;
                        } else {
                            if (o11 != 0) {
                                throw new UnknownFieldException(o11);
                            }
                            obj = b11.n(descriptor2, 0, r0.f68315a, obj);
                            i12 = 1;
                        }
                    }
                    i11 = i12;
                }
                b11.c(descriptor2);
                return new IABSettings(i11, (Integer) obj, w1Var);
            }

            @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
            public kotlinx.serialization.descriptors.f getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.g
            public void serialize(e00.f encoder, IABSettings value) {
                Intrinsics.h(encoder, "encoder");
                Intrinsics.h(value, "value");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.d b11 = encoder.b(descriptor2);
                IABSettings.write$Self(value, b11, descriptor2);
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

        /* JADX WARN: Multi-variable type inference failed */
        public IABSettings() {
            this((Integer) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        @Deprecated
        public /* synthetic */ IABSettings(int i11, Integer num, w1 w1Var) {
            if ((i11 & 1) == 0) {
                this.tcfStatus = null;
            } else {
                this.tcfStatus = num;
            }
        }

        public IABSettings(Integer num) {
            this.tcfStatus = num;
        }

        public /* synthetic */ IABSettings(Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : num);
        }

        public static /* synthetic */ IABSettings copy$default(IABSettings iABSettings, Integer num, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                num = iABSettings.tcfStatus;
            }
            return iABSettings.copy(num);
        }

        public static /* synthetic */ void getTcfStatus$annotations() {
        }

        @JvmStatic
        public static final void write$Self(IABSettings self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
            Intrinsics.h(self, "self");
            Intrinsics.h(output, "output");
            Intrinsics.h(serialDesc, "serialDesc");
            if (!output.z(serialDesc, 0) && self.tcfStatus == null) {
                return;
            }
            output.i(serialDesc, 0, r0.f68315a, self.tcfStatus);
        }

        public final Integer component1() {
            return this.tcfStatus;
        }

        public final IABSettings copy(Integer num) {
            return new IABSettings(num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IABSettings) && Intrinsics.c(this.tcfStatus, ((IABSettings) obj).tcfStatus);
        }

        public final Integer getTcfStatus() {
            return this.tcfStatus;
        }

        public int hashCode() {
            Integer num = this.tcfStatus;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        public String toString() {
            return "IABSettings(tcfStatus=" + this.tcfStatus + ')';
        }
    }

    /* loaded from: classes7.dex */
    public static final class a implements i0 {
        public static final a INSTANCE;
        public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload", aVar, 19);
            pluginGeneratedSerialDescriptor.l("reuse_assets", true);
            pluginGeneratedSerialDescriptor.l(XLogUtil.TAG, true);
            pluginGeneratedSerialDescriptor.l("endpoints", true);
            pluginGeneratedSerialDescriptor.l("log_metrics", true);
            pluginGeneratedSerialDescriptor.l("placements", true);
            pluginGeneratedSerialDescriptor.l("user", true);
            pluginGeneratedSerialDescriptor.l("config_extension", true);
            pluginGeneratedSerialDescriptor.l("disable_ad_id", true);
            pluginGeneratedSerialDescriptor.l("ri_enabled", true);
            pluginGeneratedSerialDescriptor.l("session_timeout", true);
            pluginGeneratedSerialDescriptor.l("wait_for_connectivity_for_tpat", true);
            pluginGeneratedSerialDescriptor.l("sdk_session_timeout", true);
            pluginGeneratedSerialDescriptor.l("signals_disabled", true);
            pluginGeneratedSerialDescriptor.l("fpd_enabled", true);
            pluginGeneratedSerialDescriptor.l("rta_debugging", true);
            pluginGeneratedSerialDescriptor.l("config_last_validated_ts", true);
            pluginGeneratedSerialDescriptor.l("auto_redirect", true);
            pluginGeneratedSerialDescriptor.l("retry_prioritized_tpat", true);
            pluginGeneratedSerialDescriptor.l("enable_ot", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // kotlinx.serialization.internal.i0
        public kotlinx.serialization.b[] childSerializers() {
            kotlinx.serialization.b s11 = d00.a.s(c.a.INSTANCE);
            kotlinx.serialization.b s12 = d00.a.s(e.a.INSTANCE);
            kotlinx.serialization.b s13 = d00.a.s(f.a.INSTANCE);
            kotlinx.serialization.b s14 = d00.a.s(h.a.INSTANCE);
            kotlinx.serialization.b s15 = d00.a.s(new kotlinx.serialization.internal.f(g.a.INSTANCE));
            kotlinx.serialization.b s16 = d00.a.s(i.a.INSTANCE);
            kotlinx.serialization.b s17 = d00.a.s(b2.f68235a);
            kotlinx.serialization.internal.i iVar = kotlinx.serialization.internal.i.f68275a;
            kotlinx.serialization.b s18 = d00.a.s(iVar);
            kotlinx.serialization.b s19 = d00.a.s(iVar);
            r0 r0Var = r0.f68315a;
            return new kotlinx.serialization.b[]{s11, s12, s13, s14, s15, s16, s17, s18, s19, d00.a.s(r0Var), d00.a.s(iVar), d00.a.s(r0Var), d00.a.s(iVar), d00.a.s(iVar), d00.a.s(iVar), d00.a.s(b1.f68233a), d00.a.s(b.a.INSTANCE), d00.a.s(iVar), d00.a.s(iVar)};
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00e5. Please report as an issue. */
        @Override // kotlinx.serialization.a
        public ConfigPayload deserialize(e00.e decoder) {
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            Object obj10;
            Object obj11;
            int i11;
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
            Object obj24;
            Intrinsics.h(decoder, "decoder");
            kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
            e00.c b11 = decoder.b(descriptor2);
            if (b11.p()) {
                Object n11 = b11.n(descriptor2, 0, c.a.INSTANCE, null);
                obj11 = b11.n(descriptor2, 1, e.a.INSTANCE, null);
                obj6 = b11.n(descriptor2, 2, f.a.INSTANCE, null);
                Object n12 = b11.n(descriptor2, 3, h.a.INSTANCE, null);
                Object n13 = b11.n(descriptor2, 4, new kotlinx.serialization.internal.f(g.a.INSTANCE), null);
                obj15 = b11.n(descriptor2, 5, i.a.INSTANCE, null);
                obj19 = b11.n(descriptor2, 6, b2.f68235a, null);
                kotlinx.serialization.internal.i iVar = kotlinx.serialization.internal.i.f68275a;
                obj18 = b11.n(descriptor2, 7, iVar, null);
                obj17 = b11.n(descriptor2, 8, iVar, null);
                r0 r0Var = r0.f68315a;
                obj16 = b11.n(descriptor2, 9, r0Var, null);
                obj14 = b11.n(descriptor2, 10, iVar, null);
                Object n14 = b11.n(descriptor2, 11, r0Var, null);
                Object n15 = b11.n(descriptor2, 12, iVar, null);
                obj13 = n14;
                obj10 = b11.n(descriptor2, 13, iVar, null);
                obj9 = b11.n(descriptor2, 14, iVar, null);
                obj8 = b11.n(descriptor2, 15, b1.f68233a, null);
                Object n16 = b11.n(descriptor2, 16, b.a.INSTANCE, null);
                obj3 = b11.n(descriptor2, 17, iVar, null);
                obj7 = n16;
                obj4 = n11;
                i11 = 524287;
                obj12 = n15;
                obj = n13;
                obj2 = b11.n(descriptor2, 18, iVar, null);
                obj5 = n12;
            } else {
                boolean z10 = true;
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
                obj = null;
                Object obj35 = null;
                Object obj36 = null;
                Object obj37 = null;
                Object obj38 = null;
                Object obj39 = null;
                Object obj40 = null;
                Object obj41 = null;
                int i12 = 0;
                Object obj42 = null;
                while (z10) {
                    int o11 = b11.o(descriptor2);
                    switch (o11) {
                        case -1:
                            obj20 = obj42;
                            obj21 = obj25;
                            obj22 = obj29;
                            z10 = false;
                            obj29 = obj22;
                            obj42 = obj20;
                            obj25 = obj21;
                        case 0:
                            obj21 = obj25;
                            obj22 = obj29;
                            obj20 = obj42;
                            obj41 = b11.n(descriptor2, 0, c.a.INSTANCE, obj41);
                            i12 |= 1;
                            obj29 = obj22;
                            obj42 = obj20;
                            obj25 = obj21;
                        case 1:
                            obj21 = obj25;
                            i12 |= 2;
                            obj42 = b11.n(descriptor2, 1, e.a.INSTANCE, obj42);
                            obj29 = obj29;
                            obj25 = obj21;
                        case 2:
                            obj23 = obj42;
                            obj24 = obj29;
                            obj28 = b11.n(descriptor2, 2, f.a.INSTANCE, obj28);
                            i12 |= 4;
                            obj29 = obj24;
                            obj42 = obj23;
                        case 3:
                            obj23 = obj42;
                            obj24 = obj29;
                            obj27 = b11.n(descriptor2, 3, h.a.INSTANCE, obj27);
                            i12 |= 8;
                            obj29 = obj24;
                            obj42 = obj23;
                        case 4:
                            obj23 = obj42;
                            obj24 = obj29;
                            obj = b11.n(descriptor2, 4, new kotlinx.serialization.internal.f(g.a.INSTANCE), obj);
                            i12 |= 16;
                            obj29 = obj24;
                            obj42 = obj23;
                        case 5:
                            obj23 = obj42;
                            obj24 = obj29;
                            obj25 = b11.n(descriptor2, 5, i.a.INSTANCE, obj25);
                            i12 |= 32;
                            obj29 = obj24;
                            obj42 = obj23;
                        case 6:
                            obj23 = obj42;
                            obj24 = obj29;
                            obj34 = b11.n(descriptor2, 6, b2.f68235a, obj34);
                            i12 |= 64;
                            obj29 = obj24;
                            obj42 = obj23;
                        case 7:
                            obj23 = obj42;
                            obj24 = obj29;
                            obj33 = b11.n(descriptor2, 7, kotlinx.serialization.internal.i.f68275a, obj33);
                            i12 |= 128;
                            obj29 = obj24;
                            obj42 = obj23;
                        case 8:
                            obj23 = obj42;
                            obj24 = obj29;
                            obj32 = b11.n(descriptor2, 8, kotlinx.serialization.internal.i.f68275a, obj32);
                            i12 |= 256;
                            obj29 = obj24;
                            obj42 = obj23;
                        case 9:
                            obj23 = obj42;
                            obj24 = obj29;
                            obj26 = b11.n(descriptor2, 9, r0.f68315a, obj26);
                            i12 |= 512;
                            obj29 = obj24;
                            obj42 = obj23;
                        case 10:
                            obj23 = obj42;
                            obj24 = obj29;
                            obj31 = b11.n(descriptor2, 10, kotlinx.serialization.internal.i.f68275a, obj31);
                            i12 |= 1024;
                            obj29 = obj24;
                            obj42 = obj23;
                        case 11:
                            obj23 = obj42;
                            obj24 = obj29;
                            obj30 = b11.n(descriptor2, 11, r0.f68315a, obj30);
                            i12 |= 2048;
                            obj29 = obj24;
                            obj42 = obj23;
                        case 12:
                            obj23 = obj42;
                            obj35 = b11.n(descriptor2, 12, kotlinx.serialization.internal.i.f68275a, obj35);
                            i12 |= 4096;
                            obj29 = obj29;
                            obj36 = obj36;
                            obj42 = obj23;
                        case 13:
                            obj23 = obj42;
                            obj36 = b11.n(descriptor2, 13, kotlinx.serialization.internal.i.f68275a, obj36);
                            i12 |= 8192;
                            obj29 = obj29;
                            obj37 = obj37;
                            obj42 = obj23;
                        case 14:
                            obj23 = obj42;
                            obj37 = b11.n(descriptor2, 14, kotlinx.serialization.internal.i.f68275a, obj37);
                            i12 |= 16384;
                            obj29 = obj29;
                            obj38 = obj38;
                            obj42 = obj23;
                        case 15:
                            obj23 = obj42;
                            obj38 = b11.n(descriptor2, 15, b1.f68233a, obj38);
                            i12 |= 32768;
                            obj29 = obj29;
                            obj39 = obj39;
                            obj42 = obj23;
                        case 16:
                            obj23 = obj42;
                            obj39 = b11.n(descriptor2, 16, b.a.INSTANCE, obj39);
                            i12 |= 65536;
                            obj29 = obj29;
                            obj40 = obj40;
                            obj42 = obj23;
                        case 17:
                            obj23 = obj42;
                            obj24 = obj29;
                            obj40 = b11.n(descriptor2, 17, kotlinx.serialization.internal.i.f68275a, obj40);
                            i12 |= 131072;
                            obj29 = obj24;
                            obj42 = obj23;
                        case 18:
                            obj29 = b11.n(descriptor2, 18, kotlinx.serialization.internal.i.f68275a, obj29);
                            i12 |= 262144;
                            obj42 = obj42;
                        default:
                            throw new UnknownFieldException(o11);
                    }
                }
                Object obj43 = obj42;
                Object obj44 = obj25;
                obj2 = obj29;
                obj3 = obj40;
                obj4 = obj41;
                obj5 = obj27;
                obj6 = obj28;
                obj7 = obj39;
                obj8 = obj38;
                obj9 = obj37;
                obj10 = obj36;
                obj11 = obj43;
                i11 = i12;
                obj12 = obj35;
                obj13 = obj30;
                obj14 = obj31;
                obj15 = obj44;
                obj16 = obj26;
                obj17 = obj32;
                obj18 = obj33;
                obj19 = obj34;
            }
            b11.c(descriptor2);
            return new ConfigPayload(i11, (c) obj4, (e) obj11, (f) obj6, (h) obj5, (List) obj, (i) obj15, (String) obj19, (Boolean) obj18, (Boolean) obj17, (Integer) obj16, (Boolean) obj14, (Integer) obj13, (Boolean) obj12, (Boolean) obj10, (Boolean) obj9, (Long) obj8, (b) obj7, (Boolean) obj3, (Boolean) obj2, (w1) null);
        }

        @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
        public kotlinx.serialization.descriptors.f getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.g
        public void serialize(e00.f encoder, ConfigPayload value) {
            Intrinsics.h(encoder, "encoder");
            Intrinsics.h(value, "value");
            kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
            e00.d b11 = encoder.b(descriptor2);
            ConfigPayload.write$Self(value, b11, descriptor2);
            b11.c(descriptor2);
        }

        @Override // kotlinx.serialization.internal.i0
        public kotlinx.serialization.b[] typeParametersSerializers() {
            return i0.a.a(this);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static final C0733b Companion = new C0733b(null);
        private final Long afterClickDuration;
        private final Boolean allowAutoRedirect;

        /* loaded from: classes7.dex */
        public static final class a implements i0 {
            public static final a INSTANCE;
            public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.AutoRedirect", aVar, 2);
                pluginGeneratedSerialDescriptor.l("allow_auto_redirect", true);
                pluginGeneratedSerialDescriptor.l("after_click_ms", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // kotlinx.serialization.internal.i0
            public kotlinx.serialization.b[] childSerializers() {
                return new kotlinx.serialization.b[]{d00.a.s(kotlinx.serialization.internal.i.f68275a), d00.a.s(b1.f68233a)};
            }

            @Override // kotlinx.serialization.a
            public b deserialize(e00.e decoder) {
                Object obj;
                Object obj2;
                int i11;
                Intrinsics.h(decoder, "decoder");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.c b11 = decoder.b(descriptor2);
                w1 w1Var = null;
                if (b11.p()) {
                    obj = b11.n(descriptor2, 0, kotlinx.serialization.internal.i.f68275a, null);
                    obj2 = b11.n(descriptor2, 1, b1.f68233a, null);
                    i11 = 3;
                } else {
                    boolean z10 = true;
                    int i12 = 0;
                    obj = null;
                    Object obj3 = null;
                    while (z10) {
                        int o11 = b11.o(descriptor2);
                        if (o11 == -1) {
                            z10 = false;
                        } else if (o11 == 0) {
                            obj = b11.n(descriptor2, 0, kotlinx.serialization.internal.i.f68275a, obj);
                            i12 |= 1;
                        } else {
                            if (o11 != 1) {
                                throw new UnknownFieldException(o11);
                            }
                            obj3 = b11.n(descriptor2, 1, b1.f68233a, obj3);
                            i12 |= 2;
                        }
                    }
                    obj2 = obj3;
                    i11 = i12;
                }
                b11.c(descriptor2);
                return new b(i11, (Boolean) obj, (Long) obj2, w1Var);
            }

            @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
            public kotlinx.serialization.descriptors.f getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.g
            public void serialize(e00.f encoder, b value) {
                Intrinsics.h(encoder, "encoder");
                Intrinsics.h(value, "value");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.d b11 = encoder.b(descriptor2);
                b.write$Self(value, b11, descriptor2);
                b11.c(descriptor2);
            }

            @Override // kotlinx.serialization.internal.i0
            public kotlinx.serialization.b[] typeParametersSerializers() {
                return i0.a.a(this);
            }
        }

        /* renamed from: com.vungle.ads.internal.model.ConfigPayload$b$b, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0733b {
            private C0733b() {
            }

            public /* synthetic */ C0733b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final kotlinx.serialization.b serializer() {
                return a.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            this((Boolean) null, (Long) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        @Deprecated
        public /* synthetic */ b(int i11, Boolean bool, Long l11, w1 w1Var) {
            this.allowAutoRedirect = (i11 & 1) == 0 ? Boolean.FALSE : bool;
            if ((i11 & 2) == 0) {
                this.afterClickDuration = Long.MAX_VALUE;
            } else {
                this.afterClickDuration = l11;
            }
        }

        public b(Boolean bool, Long l11) {
            this.allowAutoRedirect = bool;
            this.afterClickDuration = l11;
        }

        public /* synthetic */ b(Boolean bool, Long l11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? Boolean.FALSE : bool, (i11 & 2) != 0 ? Long.MAX_VALUE : l11);
        }

        public static /* synthetic */ b copy$default(b bVar, Boolean bool, Long l11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bool = bVar.allowAutoRedirect;
            }
            if ((i11 & 2) != 0) {
                l11 = bVar.afterClickDuration;
            }
            return bVar.copy(bool, l11);
        }

        public static /* synthetic */ void getAfterClickDuration$annotations() {
        }

        public static /* synthetic */ void getAllowAutoRedirect$annotations() {
        }

        @JvmStatic
        public static final void write$Self(b self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
            Long l11;
            Intrinsics.h(self, "self");
            Intrinsics.h(output, "output");
            Intrinsics.h(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || !Intrinsics.c(self.allowAutoRedirect, Boolean.FALSE)) {
                output.i(serialDesc, 0, kotlinx.serialization.internal.i.f68275a, self.allowAutoRedirect);
            }
            if (output.z(serialDesc, 1) || (l11 = self.afterClickDuration) == null || l11.longValue() != Long.MAX_VALUE) {
                output.i(serialDesc, 1, b1.f68233a, self.afterClickDuration);
            }
        }

        public final Boolean component1() {
            return this.allowAutoRedirect;
        }

        public final Long component2() {
            return this.afterClickDuration;
        }

        public final b copy(Boolean bool, Long l11) {
            return new b(bool, l11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.c(this.allowAutoRedirect, bVar.allowAutoRedirect) && Intrinsics.c(this.afterClickDuration, bVar.afterClickDuration);
        }

        public final Long getAfterClickDuration() {
            return this.afterClickDuration;
        }

        public final Boolean getAllowAutoRedirect() {
            return this.allowAutoRedirect;
        }

        public int hashCode() {
            Boolean bool = this.allowAutoRedirect;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Long l11 = this.afterClickDuration;
            return hashCode + (l11 != null ? l11.hashCode() : 0);
        }

        public String toString() {
            return "AutoRedirect(allowAutoRedirect=" + this.allowAutoRedirect + ", afterClickDuration=" + this.afterClickDuration + ')';
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {
        public static final b Companion = new b(null);
        private final Integer diskPercentage;
        private final Long diskSize;
        private final Boolean enabled;

        /* loaded from: classes7.dex */
        public static final class a implements i0 {
            public static final a INSTANCE;
            public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.CleverCache", aVar, 3);
                pluginGeneratedSerialDescriptor.l("enabled", true);
                pluginGeneratedSerialDescriptor.l("disk_size", true);
                pluginGeneratedSerialDescriptor.l("disk_percentage", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // kotlinx.serialization.internal.i0
            public kotlinx.serialization.b[] childSerializers() {
                return new kotlinx.serialization.b[]{d00.a.s(kotlinx.serialization.internal.i.f68275a), d00.a.s(b1.f68233a), d00.a.s(r0.f68315a)};
            }

            @Override // kotlinx.serialization.a
            public c deserialize(e00.e decoder) {
                Object obj;
                Object obj2;
                int i11;
                Object obj3;
                Intrinsics.h(decoder, "decoder");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.c b11 = decoder.b(descriptor2);
                Object obj4 = null;
                if (b11.p()) {
                    obj3 = b11.n(descriptor2, 0, kotlinx.serialization.internal.i.f68275a, null);
                    obj = b11.n(descriptor2, 1, b1.f68233a, null);
                    obj2 = b11.n(descriptor2, 2, r0.f68315a, null);
                    i11 = 7;
                } else {
                    boolean z10 = true;
                    int i12 = 0;
                    Object obj5 = null;
                    Object obj6 = null;
                    while (z10) {
                        int o11 = b11.o(descriptor2);
                        if (o11 == -1) {
                            z10 = false;
                        } else if (o11 == 0) {
                            obj4 = b11.n(descriptor2, 0, kotlinx.serialization.internal.i.f68275a, obj4);
                            i12 |= 1;
                        } else if (o11 == 1) {
                            obj5 = b11.n(descriptor2, 1, b1.f68233a, obj5);
                            i12 |= 2;
                        } else {
                            if (o11 != 2) {
                                throw new UnknownFieldException(o11);
                            }
                            obj6 = b11.n(descriptor2, 2, r0.f68315a, obj6);
                            i12 |= 4;
                        }
                    }
                    obj = obj5;
                    obj2 = obj6;
                    Object obj7 = obj4;
                    i11 = i12;
                    obj3 = obj7;
                }
                b11.c(descriptor2);
                return new c(i11, (Boolean) obj3, (Long) obj, (Integer) obj2, (w1) null);
            }

            @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
            public kotlinx.serialization.descriptors.f getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.g
            public void serialize(e00.f encoder, c value) {
                Intrinsics.h(encoder, "encoder");
                Intrinsics.h(value, "value");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.d b11 = encoder.b(descriptor2);
                c.write$Self(value, b11, descriptor2);
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

        public c() {
            this((Boolean) null, (Long) null, (Integer) null, 7, (DefaultConstructorMarker) null);
        }

        @Deprecated
        public /* synthetic */ c(int i11, Boolean bool, Long l11, Integer num, w1 w1Var) {
            this.enabled = (i11 & 1) == 0 ? Boolean.FALSE : bool;
            if ((i11 & 2) == 0) {
                this.diskSize = 1000L;
            } else {
                this.diskSize = l11;
            }
            if ((i11 & 4) == 0) {
                this.diskPercentage = 3;
            } else {
                this.diskPercentage = num;
            }
        }

        public c(Boolean bool, Long l11, Integer num) {
            this.enabled = bool;
            this.diskSize = l11;
            this.diskPercentage = num;
        }

        public /* synthetic */ c(Boolean bool, Long l11, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? Boolean.FALSE : bool, (i11 & 2) != 0 ? 1000L : l11, (i11 & 4) != 0 ? 3 : num);
        }

        public static /* synthetic */ c copy$default(c cVar, Boolean bool, Long l11, Integer num, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bool = cVar.enabled;
            }
            if ((i11 & 2) != 0) {
                l11 = cVar.diskSize;
            }
            if ((i11 & 4) != 0) {
                num = cVar.diskPercentage;
            }
            return cVar.copy(bool, l11, num);
        }

        public static /* synthetic */ void getDiskPercentage$annotations() {
        }

        public static /* synthetic */ void getDiskSize$annotations() {
        }

        public static /* synthetic */ void getEnabled$annotations() {
        }

        @JvmStatic
        public static final void write$Self(c self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
            Integer num;
            Long l11;
            Intrinsics.h(self, "self");
            Intrinsics.h(output, "output");
            Intrinsics.h(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || !Intrinsics.c(self.enabled, Boolean.FALSE)) {
                output.i(serialDesc, 0, kotlinx.serialization.internal.i.f68275a, self.enabled);
            }
            if (output.z(serialDesc, 1) || (l11 = self.diskSize) == null || l11.longValue() != 1000) {
                output.i(serialDesc, 1, b1.f68233a, self.diskSize);
            }
            if (output.z(serialDesc, 2) || (num = self.diskPercentage) == null || num.intValue() != 3) {
                output.i(serialDesc, 2, r0.f68315a, self.diskPercentage);
            }
        }

        public final Boolean component1() {
            return this.enabled;
        }

        public final Long component2() {
            return this.diskSize;
        }

        public final Integer component3() {
            return this.diskPercentage;
        }

        public final c copy(Boolean bool, Long l11, Integer num) {
            return new c(bool, l11, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.c(this.enabled, cVar.enabled) && Intrinsics.c(this.diskSize, cVar.diskSize) && Intrinsics.c(this.diskPercentage, cVar.diskPercentage);
        }

        public final Integer getDiskPercentage() {
            return this.diskPercentage;
        }

        public final Long getDiskSize() {
            return this.diskSize;
        }

        public final Boolean getEnabled() {
            return this.enabled;
        }

        public int hashCode() {
            Boolean bool = this.enabled;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Long l11 = this.diskSize;
            int hashCode2 = (hashCode + (l11 == null ? 0 : l11.hashCode())) * 31;
            Integer num = this.diskPercentage;
            return hashCode2 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "CleverCache(enabled=" + this.enabled + ", diskSize=" + this.diskSize + ", diskPercentage=" + this.diskPercentage + ')';
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final kotlinx.serialization.b serializer() {
            return a.INSTANCE;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e {
        public static final b Companion = new b(null);
        private final Long refreshTime;

        /* loaded from: classes7.dex */
        public static final class a implements i0 {
            public static final a INSTANCE;
            public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.ConfigSettings", aVar, 1);
                pluginGeneratedSerialDescriptor.l("refresh_interval", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // kotlinx.serialization.internal.i0
            public kotlinx.serialization.b[] childSerializers() {
                return new kotlinx.serialization.b[]{d00.a.s(b1.f68233a)};
            }

            @Override // kotlinx.serialization.a
            public e deserialize(e00.e decoder) {
                Object obj;
                Intrinsics.h(decoder, "decoder");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.c b11 = decoder.b(descriptor2);
                int i11 = 1;
                w1 w1Var = null;
                if (b11.p()) {
                    obj = b11.n(descriptor2, 0, b1.f68233a, null);
                } else {
                    boolean z10 = true;
                    int i12 = 0;
                    obj = null;
                    while (z10) {
                        int o11 = b11.o(descriptor2);
                        if (o11 == -1) {
                            z10 = false;
                        } else {
                            if (o11 != 0) {
                                throw new UnknownFieldException(o11);
                            }
                            obj = b11.n(descriptor2, 0, b1.f68233a, obj);
                            i12 = 1;
                        }
                    }
                    i11 = i12;
                }
                b11.c(descriptor2);
                return new e(i11, (Long) obj, w1Var);
            }

            @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
            public kotlinx.serialization.descriptors.f getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.g
            public void serialize(e00.f encoder, e value) {
                Intrinsics.h(encoder, "encoder");
                Intrinsics.h(value, "value");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.d b11 = encoder.b(descriptor2);
                e.write$Self(value, b11, descriptor2);
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

        /* JADX WARN: Multi-variable type inference failed */
        public e() {
            this((Long) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        @Deprecated
        public /* synthetic */ e(int i11, Long l11, w1 w1Var) {
            if ((i11 & 1) == 0) {
                this.refreshTime = null;
            } else {
                this.refreshTime = l11;
            }
        }

        public e(Long l11) {
            this.refreshTime = l11;
        }

        public /* synthetic */ e(Long l11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : l11);
        }

        public static /* synthetic */ e copy$default(e eVar, Long l11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                l11 = eVar.refreshTime;
            }
            return eVar.copy(l11);
        }

        public static /* synthetic */ void getRefreshTime$annotations() {
        }

        @JvmStatic
        public static final void write$Self(e self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
            Intrinsics.h(self, "self");
            Intrinsics.h(output, "output");
            Intrinsics.h(serialDesc, "serialDesc");
            if (!output.z(serialDesc, 0) && self.refreshTime == null) {
                return;
            }
            output.i(serialDesc, 0, b1.f68233a, self.refreshTime);
        }

        public final Long component1() {
            return this.refreshTime;
        }

        public final e copy(Long l11) {
            return new e(l11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && Intrinsics.c(this.refreshTime, ((e) obj).refreshTime);
        }

        public final Long getRefreshTime() {
            return this.refreshTime;
        }

        public int hashCode() {
            Long l11 = this.refreshTime;
            if (l11 == null) {
                return 0;
            }
            return l11.hashCode();
        }

        public String toString() {
            return "ConfigSettings(refreshTime=" + this.refreshTime + ')';
        }
    }

    /* loaded from: classes7.dex */
    public static final class f {
        public static final b Companion = new b(null);
        private final String adsEndpoint;
        private final String errorLogsEndpoint;
        private final String metricsEndpoint;
        private final String mraidEndpoint;
        private final String riEndpoint;

        /* loaded from: classes7.dex */
        public static final class a implements i0 {
            public static final a INSTANCE;
            public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.Endpoints", aVar, 5);
                pluginGeneratedSerialDescriptor.l(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, true);
                pluginGeneratedSerialDescriptor.l("ri", true);
                pluginGeneratedSerialDescriptor.l("error_logs", true);
                pluginGeneratedSerialDescriptor.l("metrics", true);
                pluginGeneratedSerialDescriptor.l("mraid_js", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // kotlinx.serialization.internal.i0
            public kotlinx.serialization.b[] childSerializers() {
                b2 b2Var = b2.f68235a;
                return new kotlinx.serialization.b[]{d00.a.s(b2Var), d00.a.s(b2Var), d00.a.s(b2Var), d00.a.s(b2Var), d00.a.s(b2Var)};
            }

            @Override // kotlinx.serialization.a
            public f deserialize(e00.e decoder) {
                Object obj;
                int i11;
                Object obj2;
                Object obj3;
                Object obj4;
                Object obj5;
                Intrinsics.h(decoder, "decoder");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.c b11 = decoder.b(descriptor2);
                Object obj6 = null;
                if (b11.p()) {
                    b2 b2Var = b2.f68235a;
                    obj2 = b11.n(descriptor2, 0, b2Var, null);
                    obj3 = b11.n(descriptor2, 1, b2Var, null);
                    Object n11 = b11.n(descriptor2, 2, b2Var, null);
                    obj4 = b11.n(descriptor2, 3, b2Var, null);
                    obj5 = b11.n(descriptor2, 4, b2Var, null);
                    obj = n11;
                    i11 = 31;
                } else {
                    boolean z10 = true;
                    int i12 = 0;
                    Object obj7 = null;
                    obj = null;
                    Object obj8 = null;
                    Object obj9 = null;
                    while (z10) {
                        int o11 = b11.o(descriptor2);
                        if (o11 == -1) {
                            z10 = false;
                        } else if (o11 == 0) {
                            obj6 = b11.n(descriptor2, 0, b2.f68235a, obj6);
                            i12 |= 1;
                        } else if (o11 == 1) {
                            obj7 = b11.n(descriptor2, 1, b2.f68235a, obj7);
                            i12 |= 2;
                        } else if (o11 == 2) {
                            obj = b11.n(descriptor2, 2, b2.f68235a, obj);
                            i12 |= 4;
                        } else if (o11 == 3) {
                            obj8 = b11.n(descriptor2, 3, b2.f68235a, obj8);
                            i12 |= 8;
                        } else {
                            if (o11 != 4) {
                                throw new UnknownFieldException(o11);
                            }
                            obj9 = b11.n(descriptor2, 4, b2.f68235a, obj9);
                            i12 |= 16;
                        }
                    }
                    i11 = i12;
                    obj2 = obj6;
                    obj3 = obj7;
                    obj4 = obj8;
                    obj5 = obj9;
                }
                b11.c(descriptor2);
                return new f(i11, (String) obj2, (String) obj3, (String) obj, (String) obj4, (String) obj5, (w1) null);
            }

            @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
            public kotlinx.serialization.descriptors.f getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.g
            public void serialize(e00.f encoder, f value) {
                Intrinsics.h(encoder, "encoder");
                Intrinsics.h(value, "value");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.d b11 = encoder.b(descriptor2);
                f.write$Self(value, b11, descriptor2);
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

        public f() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
        }

        @Deprecated
        public /* synthetic */ f(int i11, String str, String str2, String str3, String str4, String str5, w1 w1Var) {
            if ((i11 & 1) == 0) {
                this.adsEndpoint = null;
            } else {
                this.adsEndpoint = str;
            }
            if ((i11 & 2) == 0) {
                this.riEndpoint = null;
            } else {
                this.riEndpoint = str2;
            }
            if ((i11 & 4) == 0) {
                this.errorLogsEndpoint = null;
            } else {
                this.errorLogsEndpoint = str3;
            }
            if ((i11 & 8) == 0) {
                this.metricsEndpoint = null;
            } else {
                this.metricsEndpoint = str4;
            }
            if ((i11 & 16) == 0) {
                this.mraidEndpoint = null;
            } else {
                this.mraidEndpoint = str5;
            }
        }

        public f(String str, String str2, String str3, String str4, String str5) {
            this.adsEndpoint = str;
            this.riEndpoint = str2;
            this.errorLogsEndpoint = str3;
            this.metricsEndpoint = str4;
            this.mraidEndpoint = str5;
        }

        public /* synthetic */ f(String str, String str2, String str3, String str4, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5);
        }

        public static /* synthetic */ f copy$default(f fVar, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = fVar.adsEndpoint;
            }
            if ((i11 & 2) != 0) {
                str2 = fVar.riEndpoint;
            }
            String str6 = str2;
            if ((i11 & 4) != 0) {
                str3 = fVar.errorLogsEndpoint;
            }
            String str7 = str3;
            if ((i11 & 8) != 0) {
                str4 = fVar.metricsEndpoint;
            }
            String str8 = str4;
            if ((i11 & 16) != 0) {
                str5 = fVar.mraidEndpoint;
            }
            return fVar.copy(str, str6, str7, str8, str5);
        }

        public static /* synthetic */ void getAdsEndpoint$annotations() {
        }

        public static /* synthetic */ void getErrorLogsEndpoint$annotations() {
        }

        public static /* synthetic */ void getMetricsEndpoint$annotations() {
        }

        public static /* synthetic */ void getMraidEndpoint$annotations() {
        }

        public static /* synthetic */ void getRiEndpoint$annotations() {
        }

        @JvmStatic
        public static final void write$Self(f self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
            Intrinsics.h(self, "self");
            Intrinsics.h(output, "output");
            Intrinsics.h(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.adsEndpoint != null) {
                output.i(serialDesc, 0, b2.f68235a, self.adsEndpoint);
            }
            if (output.z(serialDesc, 1) || self.riEndpoint != null) {
                output.i(serialDesc, 1, b2.f68235a, self.riEndpoint);
            }
            if (output.z(serialDesc, 2) || self.errorLogsEndpoint != null) {
                output.i(serialDesc, 2, b2.f68235a, self.errorLogsEndpoint);
            }
            if (output.z(serialDesc, 3) || self.metricsEndpoint != null) {
                output.i(serialDesc, 3, b2.f68235a, self.metricsEndpoint);
            }
            if (!output.z(serialDesc, 4) && self.mraidEndpoint == null) {
                return;
            }
            output.i(serialDesc, 4, b2.f68235a, self.mraidEndpoint);
        }

        public final String component1() {
            return this.adsEndpoint;
        }

        public final String component2() {
            return this.riEndpoint;
        }

        public final String component3() {
            return this.errorLogsEndpoint;
        }

        public final String component4() {
            return this.metricsEndpoint;
        }

        public final String component5() {
            return this.mraidEndpoint;
        }

        public final f copy(String str, String str2, String str3, String str4, String str5) {
            return new f(str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return Intrinsics.c(this.adsEndpoint, fVar.adsEndpoint) && Intrinsics.c(this.riEndpoint, fVar.riEndpoint) && Intrinsics.c(this.errorLogsEndpoint, fVar.errorLogsEndpoint) && Intrinsics.c(this.metricsEndpoint, fVar.metricsEndpoint) && Intrinsics.c(this.mraidEndpoint, fVar.mraidEndpoint);
        }

        public final String getAdsEndpoint() {
            return this.adsEndpoint;
        }

        public final String getErrorLogsEndpoint() {
            return this.errorLogsEndpoint;
        }

        public final String getMetricsEndpoint() {
            return this.metricsEndpoint;
        }

        public final String getMraidEndpoint() {
            return this.mraidEndpoint;
        }

        public final String getRiEndpoint() {
            return this.riEndpoint;
        }

        public int hashCode() {
            String str = this.adsEndpoint;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.riEndpoint;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.errorLogsEndpoint;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.metricsEndpoint;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.mraidEndpoint;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "Endpoints(adsEndpoint=" + this.adsEndpoint + ", riEndpoint=" + this.riEndpoint + ", errorLogsEndpoint=" + this.errorLogsEndpoint + ", metricsEndpoint=" + this.metricsEndpoint + ", mraidEndpoint=" + this.mraidEndpoint + ')';
        }
    }

    /* loaded from: classes7.dex */
    public static final class g {
        public static final b Companion = new b(null);
        private final String buttonAccept;
        private final String buttonDeny;
        private final String consentMessage;
        private final String consentMessageVersion;
        private final String consentTitle;
        private final Boolean isCountryDataProtected;

        /* loaded from: classes7.dex */
        public static final class a implements i0 {
            public static final a INSTANCE;
            public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.GDPRSettings", aVar, 6);
                pluginGeneratedSerialDescriptor.l("is_country_data_protected", true);
                pluginGeneratedSerialDescriptor.l("consent_title", true);
                pluginGeneratedSerialDescriptor.l("consent_message", true);
                pluginGeneratedSerialDescriptor.l("consent_message_version", true);
                pluginGeneratedSerialDescriptor.l("button_accept", true);
                pluginGeneratedSerialDescriptor.l("button_deny", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // kotlinx.serialization.internal.i0
            public kotlinx.serialization.b[] childSerializers() {
                kotlinx.serialization.b s11 = d00.a.s(kotlinx.serialization.internal.i.f68275a);
                b2 b2Var = b2.f68235a;
                return new kotlinx.serialization.b[]{s11, d00.a.s(b2Var), d00.a.s(b2Var), d00.a.s(b2Var), d00.a.s(b2Var), d00.a.s(b2Var)};
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:10:0x004a. Please report as an issue. */
            @Override // kotlinx.serialization.a
            public g deserialize(e00.e decoder) {
                Object obj;
                Object obj2;
                Object obj3;
                Object obj4;
                Object obj5;
                int i11;
                Object obj6;
                Intrinsics.h(decoder, "decoder");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.c b11 = decoder.b(descriptor2);
                int i12 = 5;
                Object obj7 = null;
                if (b11.p()) {
                    obj6 = b11.n(descriptor2, 0, kotlinx.serialization.internal.i.f68275a, null);
                    b2 b2Var = b2.f68235a;
                    obj = b11.n(descriptor2, 1, b2Var, null);
                    obj2 = b11.n(descriptor2, 2, b2Var, null);
                    obj3 = b11.n(descriptor2, 3, b2Var, null);
                    obj4 = b11.n(descriptor2, 4, b2Var, null);
                    obj5 = b11.n(descriptor2, 5, b2Var, null);
                    i11 = 63;
                } else {
                    boolean z10 = true;
                    int i13 = 0;
                    Object obj8 = null;
                    Object obj9 = null;
                    Object obj10 = null;
                    Object obj11 = null;
                    Object obj12 = null;
                    while (z10) {
                        int o11 = b11.o(descriptor2);
                        switch (o11) {
                            case -1:
                                z10 = false;
                                i12 = 5;
                            case 0:
                                obj7 = b11.n(descriptor2, 0, kotlinx.serialization.internal.i.f68275a, obj7);
                                i13 |= 1;
                                i12 = 5;
                            case 1:
                                obj8 = b11.n(descriptor2, 1, b2.f68235a, obj8);
                                i13 |= 2;
                            case 2:
                                obj9 = b11.n(descriptor2, 2, b2.f68235a, obj9);
                                i13 |= 4;
                            case 3:
                                obj10 = b11.n(descriptor2, 3, b2.f68235a, obj10);
                                i13 |= 8;
                            case 4:
                                obj11 = b11.n(descriptor2, 4, b2.f68235a, obj11);
                                i13 |= 16;
                            case 5:
                                obj12 = b11.n(descriptor2, i12, b2.f68235a, obj12);
                                i13 |= 32;
                            default:
                                throw new UnknownFieldException(o11);
                        }
                    }
                    obj = obj8;
                    obj2 = obj9;
                    obj3 = obj10;
                    obj4 = obj11;
                    obj5 = obj12;
                    Object obj13 = obj7;
                    i11 = i13;
                    obj6 = obj13;
                }
                b11.c(descriptor2);
                return new g(i11, (Boolean) obj6, (String) obj, (String) obj2, (String) obj3, (String) obj4, (String) obj5, (w1) null);
            }

            @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
            public kotlinx.serialization.descriptors.f getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.g
            public void serialize(e00.f encoder, g value) {
                Intrinsics.h(encoder, "encoder");
                Intrinsics.h(value, "value");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.d b11 = encoder.b(descriptor2);
                g.write$Self(value, b11, descriptor2);
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

        public g() {
            this((Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        @Deprecated
        public /* synthetic */ g(int i11, Boolean bool, String str, String str2, String str3, String str4, String str5, w1 w1Var) {
            if ((i11 & 1) == 0) {
                this.isCountryDataProtected = null;
            } else {
                this.isCountryDataProtected = bool;
            }
            if ((i11 & 2) == 0) {
                this.consentTitle = null;
            } else {
                this.consentTitle = str;
            }
            if ((i11 & 4) == 0) {
                this.consentMessage = null;
            } else {
                this.consentMessage = str2;
            }
            if ((i11 & 8) == 0) {
                this.consentMessageVersion = null;
            } else {
                this.consentMessageVersion = str3;
            }
            if ((i11 & 16) == 0) {
                this.buttonAccept = null;
            } else {
                this.buttonAccept = str4;
            }
            if ((i11 & 32) == 0) {
                this.buttonDeny = null;
            } else {
                this.buttonDeny = str5;
            }
        }

        public g(Boolean bool, String str, String str2, String str3, String str4, String str5) {
            this.isCountryDataProtected = bool;
            this.consentTitle = str;
            this.consentMessage = str2;
            this.consentMessageVersion = str3;
            this.buttonAccept = str4;
            this.buttonDeny = str5;
        }

        public /* synthetic */ g(Boolean bool, String str, String str2, String str3, String str4, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5);
        }

        public static /* synthetic */ g copy$default(g gVar, Boolean bool, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bool = gVar.isCountryDataProtected;
            }
            if ((i11 & 2) != 0) {
                str = gVar.consentTitle;
            }
            String str6 = str;
            if ((i11 & 4) != 0) {
                str2 = gVar.consentMessage;
            }
            String str7 = str2;
            if ((i11 & 8) != 0) {
                str3 = gVar.consentMessageVersion;
            }
            String str8 = str3;
            if ((i11 & 16) != 0) {
                str4 = gVar.buttonAccept;
            }
            String str9 = str4;
            if ((i11 & 32) != 0) {
                str5 = gVar.buttonDeny;
            }
            return gVar.copy(bool, str6, str7, str8, str9, str5);
        }

        public static /* synthetic */ void getButtonAccept$annotations() {
        }

        public static /* synthetic */ void getButtonDeny$annotations() {
        }

        public static /* synthetic */ void getConsentMessage$annotations() {
        }

        public static /* synthetic */ void getConsentMessageVersion$annotations() {
        }

        public static /* synthetic */ void getConsentTitle$annotations() {
        }

        public static /* synthetic */ void isCountryDataProtected$annotations() {
        }

        @JvmStatic
        public static final void write$Self(g self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
            Intrinsics.h(self, "self");
            Intrinsics.h(output, "output");
            Intrinsics.h(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.isCountryDataProtected != null) {
                output.i(serialDesc, 0, kotlinx.serialization.internal.i.f68275a, self.isCountryDataProtected);
            }
            if (output.z(serialDesc, 1) || self.consentTitle != null) {
                output.i(serialDesc, 1, b2.f68235a, self.consentTitle);
            }
            if (output.z(serialDesc, 2) || self.consentMessage != null) {
                output.i(serialDesc, 2, b2.f68235a, self.consentMessage);
            }
            if (output.z(serialDesc, 3) || self.consentMessageVersion != null) {
                output.i(serialDesc, 3, b2.f68235a, self.consentMessageVersion);
            }
            if (output.z(serialDesc, 4) || self.buttonAccept != null) {
                output.i(serialDesc, 4, b2.f68235a, self.buttonAccept);
            }
            if (!output.z(serialDesc, 5) && self.buttonDeny == null) {
                return;
            }
            output.i(serialDesc, 5, b2.f68235a, self.buttonDeny);
        }

        public final Boolean component1() {
            return this.isCountryDataProtected;
        }

        public final String component2() {
            return this.consentTitle;
        }

        public final String component3() {
            return this.consentMessage;
        }

        public final String component4() {
            return this.consentMessageVersion;
        }

        public final String component5() {
            return this.buttonAccept;
        }

        public final String component6() {
            return this.buttonDeny;
        }

        public final g copy(Boolean bool, String str, String str2, String str3, String str4, String str5) {
            return new g(bool, str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return Intrinsics.c(this.isCountryDataProtected, gVar.isCountryDataProtected) && Intrinsics.c(this.consentTitle, gVar.consentTitle) && Intrinsics.c(this.consentMessage, gVar.consentMessage) && Intrinsics.c(this.consentMessageVersion, gVar.consentMessageVersion) && Intrinsics.c(this.buttonAccept, gVar.buttonAccept) && Intrinsics.c(this.buttonDeny, gVar.buttonDeny);
        }

        public final String getButtonAccept() {
            return this.buttonAccept;
        }

        public final String getButtonDeny() {
            return this.buttonDeny;
        }

        public final String getConsentMessage() {
            return this.consentMessage;
        }

        public final String getConsentMessageVersion() {
            return this.consentMessageVersion;
        }

        public final String getConsentTitle() {
            return this.consentTitle;
        }

        public int hashCode() {
            Boolean bool = this.isCountryDataProtected;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.consentTitle;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.consentMessage;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.consentMessageVersion;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.buttonAccept;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.buttonDeny;
            return hashCode5 + (str5 != null ? str5.hashCode() : 0);
        }

        public final Boolean isCountryDataProtected() {
            return this.isCountryDataProtected;
        }

        public String toString() {
            return "GDPRSettings(isCountryDataProtected=" + this.isCountryDataProtected + ", consentTitle=" + this.consentTitle + ", consentMessage=" + this.consentMessage + ", consentMessageVersion=" + this.consentMessageVersion + ", buttonAccept=" + this.buttonAccept + ", buttonDeny=" + this.buttonDeny + ')';
        }
    }

    /* loaded from: classes7.dex */
    public static final class h {
        public static final b Companion = new b(null);
        private final Integer errorLogLevel;
        private final Boolean metricsEnabled;

        /* loaded from: classes7.dex */
        public static final class a implements i0 {
            public static final a INSTANCE;
            public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.LogMetricsSettings", aVar, 2);
                pluginGeneratedSerialDescriptor.l("error_log_level", true);
                pluginGeneratedSerialDescriptor.l("metrics_is_enabled", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // kotlinx.serialization.internal.i0
            public kotlinx.serialization.b[] childSerializers() {
                return new kotlinx.serialization.b[]{d00.a.s(r0.f68315a), d00.a.s(kotlinx.serialization.internal.i.f68275a)};
            }

            @Override // kotlinx.serialization.a
            public h deserialize(e00.e decoder) {
                Object obj;
                Object obj2;
                int i11;
                Intrinsics.h(decoder, "decoder");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.c b11 = decoder.b(descriptor2);
                w1 w1Var = null;
                if (b11.p()) {
                    obj = b11.n(descriptor2, 0, r0.f68315a, null);
                    obj2 = b11.n(descriptor2, 1, kotlinx.serialization.internal.i.f68275a, null);
                    i11 = 3;
                } else {
                    boolean z10 = true;
                    int i12 = 0;
                    obj = null;
                    Object obj3 = null;
                    while (z10) {
                        int o11 = b11.o(descriptor2);
                        if (o11 == -1) {
                            z10 = false;
                        } else if (o11 == 0) {
                            obj = b11.n(descriptor2, 0, r0.f68315a, obj);
                            i12 |= 1;
                        } else {
                            if (o11 != 1) {
                                throw new UnknownFieldException(o11);
                            }
                            obj3 = b11.n(descriptor2, 1, kotlinx.serialization.internal.i.f68275a, obj3);
                            i12 |= 2;
                        }
                    }
                    obj2 = obj3;
                    i11 = i12;
                }
                b11.c(descriptor2);
                return new h(i11, (Integer) obj, (Boolean) obj2, w1Var);
            }

            @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
            public kotlinx.serialization.descriptors.f getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.g
            public void serialize(e00.f encoder, h value) {
                Intrinsics.h(encoder, "encoder");
                Intrinsics.h(value, "value");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.d b11 = encoder.b(descriptor2);
                h.write$Self(value, b11, descriptor2);
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

        /* JADX WARN: Multi-variable type inference failed */
        public h() {
            this((Integer) null, (Boolean) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        @Deprecated
        public /* synthetic */ h(int i11, Integer num, Boolean bool, w1 w1Var) {
            if ((i11 & 1) == 0) {
                this.errorLogLevel = null;
            } else {
                this.errorLogLevel = num;
            }
            if ((i11 & 2) == 0) {
                this.metricsEnabled = null;
            } else {
                this.metricsEnabled = bool;
            }
        }

        public h(Integer num, Boolean bool) {
            this.errorLogLevel = num;
            this.metricsEnabled = bool;
        }

        public /* synthetic */ h(Integer num, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : bool);
        }

        public static /* synthetic */ h copy$default(h hVar, Integer num, Boolean bool, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                num = hVar.errorLogLevel;
            }
            if ((i11 & 2) != 0) {
                bool = hVar.metricsEnabled;
            }
            return hVar.copy(num, bool);
        }

        public static /* synthetic */ void getErrorLogLevel$annotations() {
        }

        public static /* synthetic */ void getMetricsEnabled$annotations() {
        }

        @JvmStatic
        public static final void write$Self(h self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
            Intrinsics.h(self, "self");
            Intrinsics.h(output, "output");
            Intrinsics.h(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.errorLogLevel != null) {
                output.i(serialDesc, 0, r0.f68315a, self.errorLogLevel);
            }
            if (!output.z(serialDesc, 1) && self.metricsEnabled == null) {
                return;
            }
            output.i(serialDesc, 1, kotlinx.serialization.internal.i.f68275a, self.metricsEnabled);
        }

        public final Integer component1() {
            return this.errorLogLevel;
        }

        public final Boolean component2() {
            return this.metricsEnabled;
        }

        public final h copy(Integer num, Boolean bool) {
            return new h(num, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Intrinsics.c(this.errorLogLevel, hVar.errorLogLevel) && Intrinsics.c(this.metricsEnabled, hVar.metricsEnabled);
        }

        public final Integer getErrorLogLevel() {
            return this.errorLogLevel;
        }

        public final Boolean getMetricsEnabled() {
            return this.metricsEnabled;
        }

        public int hashCode() {
            Integer num = this.errorLogLevel;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Boolean bool = this.metricsEnabled;
            return hashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "LogMetricsSettings(errorLogLevel=" + this.errorLogLevel + ", metricsEnabled=" + this.metricsEnabled + ')';
        }
    }

    /* loaded from: classes7.dex */
    public static final class i {
        public static final b Companion = new b(null);
        private final g gdpr;
        private final IABSettings iab;

        /* loaded from: classes7.dex */
        public static final class a implements i0 {
            public static final a INSTANCE;
            public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.ConfigPayload.UserPrivacy", aVar, 2);
                pluginGeneratedSerialDescriptor.l("gdpr", true);
                pluginGeneratedSerialDescriptor.l("iab", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // kotlinx.serialization.internal.i0
            public kotlinx.serialization.b[] childSerializers() {
                return new kotlinx.serialization.b[]{d00.a.s(g.a.INSTANCE), d00.a.s(IABSettings.a.INSTANCE)};
            }

            @Override // kotlinx.serialization.a
            public i deserialize(e00.e decoder) {
                Object obj;
                Object obj2;
                int i11;
                Intrinsics.h(decoder, "decoder");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.c b11 = decoder.b(descriptor2);
                w1 w1Var = null;
                if (b11.p()) {
                    obj = b11.n(descriptor2, 0, g.a.INSTANCE, null);
                    obj2 = b11.n(descriptor2, 1, IABSettings.a.INSTANCE, null);
                    i11 = 3;
                } else {
                    boolean z10 = true;
                    int i12 = 0;
                    obj = null;
                    Object obj3 = null;
                    while (z10) {
                        int o11 = b11.o(descriptor2);
                        if (o11 == -1) {
                            z10 = false;
                        } else if (o11 == 0) {
                            obj = b11.n(descriptor2, 0, g.a.INSTANCE, obj);
                            i12 |= 1;
                        } else {
                            if (o11 != 1) {
                                throw new UnknownFieldException(o11);
                            }
                            obj3 = b11.n(descriptor2, 1, IABSettings.a.INSTANCE, obj3);
                            i12 |= 2;
                        }
                    }
                    obj2 = obj3;
                    i11 = i12;
                }
                b11.c(descriptor2);
                return new i(i11, (g) obj, (IABSettings) obj2, w1Var);
            }

            @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
            public kotlinx.serialization.descriptors.f getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.g
            public void serialize(e00.f encoder, i value) {
                Intrinsics.h(encoder, "encoder");
                Intrinsics.h(value, "value");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.d b11 = encoder.b(descriptor2);
                i.write$Self(value, b11, descriptor2);
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

        /* JADX WARN: Multi-variable type inference failed */
        public i() {
            this((g) null, (IABSettings) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        @Deprecated
        public /* synthetic */ i(int i11, g gVar, IABSettings iABSettings, w1 w1Var) {
            if ((i11 & 1) == 0) {
                this.gdpr = null;
            } else {
                this.gdpr = gVar;
            }
            if ((i11 & 2) == 0) {
                this.iab = null;
            } else {
                this.iab = iABSettings;
            }
        }

        public i(g gVar, IABSettings iABSettings) {
            this.gdpr = gVar;
            this.iab = iABSettings;
        }

        public /* synthetic */ i(g gVar, IABSettings iABSettings, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : gVar, (i11 & 2) != 0 ? null : iABSettings);
        }

        public static /* synthetic */ i copy$default(i iVar, g gVar, IABSettings iABSettings, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                gVar = iVar.gdpr;
            }
            if ((i11 & 2) != 0) {
                iABSettings = iVar.iab;
            }
            return iVar.copy(gVar, iABSettings);
        }

        public static /* synthetic */ void getGdpr$annotations() {
        }

        public static /* synthetic */ void getIab$annotations() {
        }

        @JvmStatic
        public static final void write$Self(i self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
            Intrinsics.h(self, "self");
            Intrinsics.h(output, "output");
            Intrinsics.h(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.gdpr != null) {
                output.i(serialDesc, 0, g.a.INSTANCE, self.gdpr);
            }
            if (!output.z(serialDesc, 1) && self.iab == null) {
                return;
            }
            output.i(serialDesc, 1, IABSettings.a.INSTANCE, self.iab);
        }

        public final g component1() {
            return this.gdpr;
        }

        public final IABSettings component2() {
            return this.iab;
        }

        public final i copy(g gVar, IABSettings iABSettings) {
            return new i(gVar, iABSettings);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Intrinsics.c(this.gdpr, iVar.gdpr) && Intrinsics.c(this.iab, iVar.iab);
        }

        public final g getGdpr() {
            return this.gdpr;
        }

        public final IABSettings getIab() {
            return this.iab;
        }

        public int hashCode() {
            g gVar = this.gdpr;
            int hashCode = (gVar == null ? 0 : gVar.hashCode()) * 31;
            IABSettings iABSettings = this.iab;
            return hashCode + (iABSettings != null ? iABSettings.hashCode() : 0);
        }

        public String toString() {
            return "UserPrivacy(gdpr=" + this.gdpr + ", iab=" + this.iab + ')';
        }
    }

    public ConfigPayload() {
        this((c) null, (e) null, (f) null, (h) null, (List) null, (i) null, (String) null, (Boolean) null, (Boolean) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, (Long) null, (b) null, (Boolean) null, (Boolean) null, 524287, (DefaultConstructorMarker) null);
    }

    @Deprecated
    public /* synthetic */ ConfigPayload(int i11, c cVar, e eVar, f fVar, h hVar, List list, i iVar, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Long l11, b bVar, Boolean bool7, Boolean bool8, w1 w1Var) {
        if ((i11 & 1) == 0) {
            this.cleverCache = null;
        } else {
            this.cleverCache = cVar;
        }
        if ((i11 & 2) == 0) {
            this.configSettings = null;
        } else {
            this.configSettings = eVar;
        }
        if ((i11 & 4) == 0) {
            this.endpoints = null;
        } else {
            this.endpoints = fVar;
        }
        if ((i11 & 8) == 0) {
            this.logMetricsSettings = null;
        } else {
            this.logMetricsSettings = hVar;
        }
        if ((i11 & 16) == 0) {
            this.placements = null;
        } else {
            this.placements = list;
        }
        if ((i11 & 32) == 0) {
            this.userPrivacy = null;
        } else {
            this.userPrivacy = iVar;
        }
        if ((i11 & 64) == 0) {
            this.configExtension = null;
        } else {
            this.configExtension = str;
        }
        this.disableAdId = (i11 & 128) == 0 ? Boolean.TRUE : bool;
        if ((i11 & 256) == 0) {
            this.isReportIncentivizedEnabled = null;
        } else {
            this.isReportIncentivizedEnabled = bool2;
        }
        if ((i11 & 512) == 0) {
            this.sessionTimeout = null;
        } else {
            this.sessionTimeout = num;
        }
        if ((i11 & 1024) == 0) {
            this.waitForConnectivityForTPAT = null;
        } else {
            this.waitForConnectivityForTPAT = bool3;
        }
        if ((i11 & 2048) == 0) {
            this.signalSessionTimeout = null;
        } else {
            this.signalSessionTimeout = num2;
        }
        if ((i11 & 4096) == 0) {
            this.signalsDisabled = null;
        } else {
            this.signalsDisabled = bool4;
        }
        if ((i11 & 8192) == 0) {
            this.fpdEnabled = null;
        } else {
            this.fpdEnabled = bool5;
        }
        if ((i11 & 16384) == 0) {
            this.rtaDebugging = null;
        } else {
            this.rtaDebugging = bool6;
        }
        if ((32768 & i11) == 0) {
            this.configLastValidatedTimestamp = null;
        } else {
            this.configLastValidatedTimestamp = l11;
        }
        if ((65536 & i11) == 0) {
            this.autoRedirect = null;
        } else {
            this.autoRedirect = bVar;
        }
        if ((131072 & i11) == 0) {
            this.retryPriorityTPATs = null;
        } else {
            this.retryPriorityTPATs = bool7;
        }
        if ((i11 & 262144) == 0) {
            this.enableOT = null;
        } else {
            this.enableOT = bool8;
        }
    }

    public ConfigPayload(c cVar, e eVar, f fVar, h hVar, List<com.vungle.ads.internal.model.g> list, i iVar, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Long l11, b bVar, Boolean bool7, Boolean bool8) {
        this.cleverCache = cVar;
        this.configSettings = eVar;
        this.endpoints = fVar;
        this.logMetricsSettings = hVar;
        this.placements = list;
        this.userPrivacy = iVar;
        this.configExtension = str;
        this.disableAdId = bool;
        this.isReportIncentivizedEnabled = bool2;
        this.sessionTimeout = num;
        this.waitForConnectivityForTPAT = bool3;
        this.signalSessionTimeout = num2;
        this.signalsDisabled = bool4;
        this.fpdEnabled = bool5;
        this.rtaDebugging = bool6;
        this.configLastValidatedTimestamp = l11;
        this.autoRedirect = bVar;
        this.retryPriorityTPATs = bool7;
        this.enableOT = bool8;
    }

    public /* synthetic */ ConfigPayload(c cVar, e eVar, f fVar, h hVar, List list, i iVar, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Long l11, b bVar, Boolean bool7, Boolean bool8, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : cVar, (i11 & 2) != 0 ? null : eVar, (i11 & 4) != 0 ? null : fVar, (i11 & 8) != 0 ? null : hVar, (i11 & 16) != 0 ? null : list, (i11 & 32) != 0 ? null : iVar, (i11 & 64) != 0 ? null : str, (i11 & 128) != 0 ? Boolean.TRUE : bool, (i11 & 256) != 0 ? null : bool2, (i11 & 512) != 0 ? null : num, (i11 & 1024) != 0 ? null : bool3, (i11 & 2048) != 0 ? null : num2, (i11 & 4096) != 0 ? null : bool4, (i11 & 8192) != 0 ? null : bool5, (i11 & 16384) != 0 ? null : bool6, (i11 & 32768) != 0 ? null : l11, (i11 & 65536) != 0 ? null : bVar, (i11 & 131072) != 0 ? null : bool7, (i11 & 262144) != 0 ? null : bool8);
    }

    public static /* synthetic */ void getAutoRedirect$annotations() {
    }

    public static /* synthetic */ void getCleverCache$annotations() {
    }

    public static /* synthetic */ void getConfigExtension$annotations() {
    }

    public static /* synthetic */ void getConfigLastValidatedTimestamp$annotations() {
    }

    public static /* synthetic */ void getConfigSettings$annotations() {
    }

    public static /* synthetic */ void getDisableAdId$annotations() {
    }

    public static /* synthetic */ void getEnableOT$annotations() {
    }

    public static /* synthetic */ void getEndpoints$annotations() {
    }

    public static /* synthetic */ void getFpdEnabled$annotations() {
    }

    public static /* synthetic */ void getLogMetricsSettings$annotations() {
    }

    public static /* synthetic */ void getPlacements$annotations() {
    }

    public static /* synthetic */ void getRetryPriorityTPATs$annotations() {
    }

    public static /* synthetic */ void getRtaDebugging$annotations() {
    }

    public static /* synthetic */ void getSessionTimeout$annotations() {
    }

    public static /* synthetic */ void getSignalSessionTimeout$annotations() {
    }

    public static /* synthetic */ void getSignalsDisabled$annotations() {
    }

    public static /* synthetic */ void getUserPrivacy$annotations() {
    }

    public static /* synthetic */ void getWaitForConnectivityForTPAT$annotations() {
    }

    public static /* synthetic */ void isReportIncentivizedEnabled$annotations() {
    }

    @JvmStatic
    public static final void write$Self(ConfigPayload self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
        Intrinsics.h(self, "self");
        Intrinsics.h(output, "output");
        Intrinsics.h(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self.cleverCache != null) {
            output.i(serialDesc, 0, c.a.INSTANCE, self.cleverCache);
        }
        if (output.z(serialDesc, 1) || self.configSettings != null) {
            output.i(serialDesc, 1, e.a.INSTANCE, self.configSettings);
        }
        if (output.z(serialDesc, 2) || self.endpoints != null) {
            output.i(serialDesc, 2, f.a.INSTANCE, self.endpoints);
        }
        if (output.z(serialDesc, 3) || self.logMetricsSettings != null) {
            output.i(serialDesc, 3, h.a.INSTANCE, self.logMetricsSettings);
        }
        if (output.z(serialDesc, 4) || self.placements != null) {
            output.i(serialDesc, 4, new kotlinx.serialization.internal.f(g.a.INSTANCE), self.placements);
        }
        if (output.z(serialDesc, 5) || self.userPrivacy != null) {
            output.i(serialDesc, 5, i.a.INSTANCE, self.userPrivacy);
        }
        if (output.z(serialDesc, 6) || self.configExtension != null) {
            output.i(serialDesc, 6, b2.f68235a, self.configExtension);
        }
        if (output.z(serialDesc, 7) || !Intrinsics.c(self.disableAdId, Boolean.TRUE)) {
            output.i(serialDesc, 7, kotlinx.serialization.internal.i.f68275a, self.disableAdId);
        }
        if (output.z(serialDesc, 8) || self.isReportIncentivizedEnabled != null) {
            output.i(serialDesc, 8, kotlinx.serialization.internal.i.f68275a, self.isReportIncentivizedEnabled);
        }
        if (output.z(serialDesc, 9) || self.sessionTimeout != null) {
            output.i(serialDesc, 9, r0.f68315a, self.sessionTimeout);
        }
        if (output.z(serialDesc, 10) || self.waitForConnectivityForTPAT != null) {
            output.i(serialDesc, 10, kotlinx.serialization.internal.i.f68275a, self.waitForConnectivityForTPAT);
        }
        if (output.z(serialDesc, 11) || self.signalSessionTimeout != null) {
            output.i(serialDesc, 11, r0.f68315a, self.signalSessionTimeout);
        }
        if (output.z(serialDesc, 12) || self.signalsDisabled != null) {
            output.i(serialDesc, 12, kotlinx.serialization.internal.i.f68275a, self.signalsDisabled);
        }
        if (output.z(serialDesc, 13) || self.fpdEnabled != null) {
            output.i(serialDesc, 13, kotlinx.serialization.internal.i.f68275a, self.fpdEnabled);
        }
        if (output.z(serialDesc, 14) || self.rtaDebugging != null) {
            output.i(serialDesc, 14, kotlinx.serialization.internal.i.f68275a, self.rtaDebugging);
        }
        if (output.z(serialDesc, 15) || self.configLastValidatedTimestamp != null) {
            output.i(serialDesc, 15, b1.f68233a, self.configLastValidatedTimestamp);
        }
        if (output.z(serialDesc, 16) || self.autoRedirect != null) {
            output.i(serialDesc, 16, b.a.INSTANCE, self.autoRedirect);
        }
        if (output.z(serialDesc, 17) || self.retryPriorityTPATs != null) {
            output.i(serialDesc, 17, kotlinx.serialization.internal.i.f68275a, self.retryPriorityTPATs);
        }
        if (!output.z(serialDesc, 18) && self.enableOT == null) {
            return;
        }
        output.i(serialDesc, 18, kotlinx.serialization.internal.i.f68275a, self.enableOT);
    }

    public final c component1() {
        return this.cleverCache;
    }

    public final Integer component10() {
        return this.sessionTimeout;
    }

    public final Boolean component11() {
        return this.waitForConnectivityForTPAT;
    }

    public final Integer component12() {
        return this.signalSessionTimeout;
    }

    public final Boolean component13() {
        return this.signalsDisabled;
    }

    public final Boolean component14() {
        return this.fpdEnabled;
    }

    public final Boolean component15() {
        return this.rtaDebugging;
    }

    public final Long component16() {
        return this.configLastValidatedTimestamp;
    }

    public final b component17() {
        return this.autoRedirect;
    }

    public final Boolean component18() {
        return this.retryPriorityTPATs;
    }

    public final Boolean component19() {
        return this.enableOT;
    }

    public final e component2() {
        return this.configSettings;
    }

    public final f component3() {
        return this.endpoints;
    }

    public final h component4() {
        return this.logMetricsSettings;
    }

    public final List<com.vungle.ads.internal.model.g> component5() {
        return this.placements;
    }

    public final i component6() {
        return this.userPrivacy;
    }

    public final String component7() {
        return this.configExtension;
    }

    public final Boolean component8() {
        return this.disableAdId;
    }

    public final Boolean component9() {
        return this.isReportIncentivizedEnabled;
    }

    public final ConfigPayload copy(c cVar, e eVar, f fVar, h hVar, List<com.vungle.ads.internal.model.g> list, i iVar, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Long l11, b bVar, Boolean bool7, Boolean bool8) {
        return new ConfigPayload(cVar, eVar, fVar, hVar, list, iVar, str, bool, bool2, num, bool3, num2, bool4, bool5, bool6, l11, bVar, bool7, bool8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigPayload)) {
            return false;
        }
        ConfigPayload configPayload = (ConfigPayload) obj;
        return Intrinsics.c(this.cleverCache, configPayload.cleverCache) && Intrinsics.c(this.configSettings, configPayload.configSettings) && Intrinsics.c(this.endpoints, configPayload.endpoints) && Intrinsics.c(this.logMetricsSettings, configPayload.logMetricsSettings) && Intrinsics.c(this.placements, configPayload.placements) && Intrinsics.c(this.userPrivacy, configPayload.userPrivacy) && Intrinsics.c(this.configExtension, configPayload.configExtension) && Intrinsics.c(this.disableAdId, configPayload.disableAdId) && Intrinsics.c(this.isReportIncentivizedEnabled, configPayload.isReportIncentivizedEnabled) && Intrinsics.c(this.sessionTimeout, configPayload.sessionTimeout) && Intrinsics.c(this.waitForConnectivityForTPAT, configPayload.waitForConnectivityForTPAT) && Intrinsics.c(this.signalSessionTimeout, configPayload.signalSessionTimeout) && Intrinsics.c(this.signalsDisabled, configPayload.signalsDisabled) && Intrinsics.c(this.fpdEnabled, configPayload.fpdEnabled) && Intrinsics.c(this.rtaDebugging, configPayload.rtaDebugging) && Intrinsics.c(this.configLastValidatedTimestamp, configPayload.configLastValidatedTimestamp) && Intrinsics.c(this.autoRedirect, configPayload.autoRedirect) && Intrinsics.c(this.retryPriorityTPATs, configPayload.retryPriorityTPATs) && Intrinsics.c(this.enableOT, configPayload.enableOT);
    }

    public final b getAutoRedirect() {
        return this.autoRedirect;
    }

    public final c getCleverCache() {
        return this.cleverCache;
    }

    public final String getConfigExtension() {
        return this.configExtension;
    }

    public final Long getConfigLastValidatedTimestamp() {
        return this.configLastValidatedTimestamp;
    }

    public final e getConfigSettings() {
        return this.configSettings;
    }

    public final Boolean getDisableAdId() {
        return this.disableAdId;
    }

    public final Boolean getEnableOT() {
        return this.enableOT;
    }

    public final f getEndpoints() {
        return this.endpoints;
    }

    public final Boolean getFpdEnabled() {
        return this.fpdEnabled;
    }

    public final h getLogMetricsSettings() {
        return this.logMetricsSettings;
    }

    public final List<com.vungle.ads.internal.model.g> getPlacements() {
        return this.placements;
    }

    public final Boolean getRetryPriorityTPATs() {
        return this.retryPriorityTPATs;
    }

    public final Boolean getRtaDebugging() {
        return this.rtaDebugging;
    }

    public final Integer getSessionTimeout() {
        return this.sessionTimeout;
    }

    public final Integer getSignalSessionTimeout() {
        return this.signalSessionTimeout;
    }

    public final Boolean getSignalsDisabled() {
        return this.signalsDisabled;
    }

    public final i getUserPrivacy() {
        return this.userPrivacy;
    }

    public final Boolean getWaitForConnectivityForTPAT() {
        return this.waitForConnectivityForTPAT;
    }

    public int hashCode() {
        c cVar = this.cleverCache;
        int hashCode = (cVar == null ? 0 : cVar.hashCode()) * 31;
        e eVar = this.configSettings;
        int hashCode2 = (hashCode + (eVar == null ? 0 : eVar.hashCode())) * 31;
        f fVar = this.endpoints;
        int hashCode3 = (hashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 31;
        h hVar = this.logMetricsSettings;
        int hashCode4 = (hashCode3 + (hVar == null ? 0 : hVar.hashCode())) * 31;
        List<com.vungle.ads.internal.model.g> list = this.placements;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        i iVar = this.userPrivacy;
        int hashCode6 = (hashCode5 + (iVar == null ? 0 : iVar.hashCode())) * 31;
        String str = this.configExtension;
        int hashCode7 = (hashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.disableAdId;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isReportIncentivizedEnabled;
        int hashCode9 = (hashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.sessionTimeout;
        int hashCode10 = (hashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool3 = this.waitForConnectivityForTPAT;
        int hashCode11 = (hashCode10 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num2 = this.signalSessionTimeout;
        int hashCode12 = (hashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool4 = this.signalsDisabled;
        int hashCode13 = (hashCode12 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.fpdEnabled;
        int hashCode14 = (hashCode13 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.rtaDebugging;
        int hashCode15 = (hashCode14 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Long l11 = this.configLastValidatedTimestamp;
        int hashCode16 = (hashCode15 + (l11 == null ? 0 : l11.hashCode())) * 31;
        b bVar = this.autoRedirect;
        int hashCode17 = (hashCode16 + (bVar == null ? 0 : bVar.hashCode())) * 31;
        Boolean bool7 = this.retryPriorityTPATs;
        int hashCode18 = (hashCode17 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.enableOT;
        return hashCode18 + (bool8 != null ? bool8.hashCode() : 0);
    }

    public final Boolean isReportIncentivizedEnabled() {
        return this.isReportIncentivizedEnabled;
    }

    public final void setAutoRedirect(b bVar) {
        this.autoRedirect = bVar;
    }

    public final void setConfigLastValidatedTimestamp(Long l11) {
        this.configLastValidatedTimestamp = l11;
    }

    public final void setEnableOT(Boolean bool) {
        this.enableOT = bool;
    }

    public final void setRetryPriorityTPATs(Boolean bool) {
        this.retryPriorityTPATs = bool;
    }

    public String toString() {
        return "ConfigPayload(cleverCache=" + this.cleverCache + ", configSettings=" + this.configSettings + ", endpoints=" + this.endpoints + ", logMetricsSettings=" + this.logMetricsSettings + ", placements=" + this.placements + ", userPrivacy=" + this.userPrivacy + ", configExtension=" + this.configExtension + ", disableAdId=" + this.disableAdId + ", isReportIncentivizedEnabled=" + this.isReportIncentivizedEnabled + ", sessionTimeout=" + this.sessionTimeout + ", waitForConnectivityForTPAT=" + this.waitForConnectivityForTPAT + ", signalSessionTimeout=" + this.signalSessionTimeout + ", signalsDisabled=" + this.signalsDisabled + ", fpdEnabled=" + this.fpdEnabled + ", rtaDebugging=" + this.rtaDebugging + ", configLastValidatedTimestamp=" + this.configLastValidatedTimestamp + ", autoRedirect=" + this.autoRedirect + ", retryPriorityTPATs=" + this.retryPriorityTPATs + ", enableOT=" + this.enableOT + ')';
    }
}
