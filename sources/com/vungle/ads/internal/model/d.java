package com.vungle.ads.internal.model;

import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.b1;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.h0;
import kotlinx.serialization.internal.i0;
import kotlinx.serialization.internal.m1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.w1;

/* loaded from: classes7.dex */
public final class d {
    public static final b Companion = new b(null);
    private final String carrier;
    private c ext;

    /* renamed from: h, reason: collision with root package name */
    private int f60759h;
    private String ifa;
    private Integer lmt;
    private final String make;
    private final String model;

    /* renamed from: os, reason: collision with root package name */
    private final String f60760os;
    private final String osv;

    /* renamed from: ua, reason: collision with root package name */
    private String f60761ua;

    /* renamed from: w, reason: collision with root package name */
    private int f60762w;

    /* loaded from: classes7.dex */
    public static final class a implements i0 {
        public static final a INSTANCE;
        public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.DeviceNode", aVar, 11);
            pluginGeneratedSerialDescriptor.l("make", false);
            pluginGeneratedSerialDescriptor.l("model", false);
            pluginGeneratedSerialDescriptor.l("osv", false);
            pluginGeneratedSerialDescriptor.l("carrier", true);
            pluginGeneratedSerialDescriptor.l("os", false);
            pluginGeneratedSerialDescriptor.l("w", false);
            pluginGeneratedSerialDescriptor.l("h", false);
            pluginGeneratedSerialDescriptor.l("ua", true);
            pluginGeneratedSerialDescriptor.l("ifa", true);
            pluginGeneratedSerialDescriptor.l("lmt", true);
            pluginGeneratedSerialDescriptor.l("ext", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // kotlinx.serialization.internal.i0
        public kotlinx.serialization.b[] childSerializers() {
            b2 b2Var = b2.f68235a;
            kotlinx.serialization.b s11 = d00.a.s(b2Var);
            r0 r0Var = r0.f68315a;
            return new kotlinx.serialization.b[]{b2Var, b2Var, b2Var, s11, b2Var, r0Var, r0Var, d00.a.s(b2Var), d00.a.s(b2Var), d00.a.s(r0Var), d00.a.s(c.a.INSTANCE)};
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0081. Please report as an issue. */
        @Override // kotlinx.serialization.a
        public d deserialize(e00.e decoder) {
            int i11;
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            int i12;
            int i13;
            String str;
            String str2;
            String str3;
            String str4;
            Intrinsics.h(decoder, "decoder");
            kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
            e00.c b11 = decoder.b(descriptor2);
            int i14 = 10;
            int i15 = 9;
            if (b11.p()) {
                String m11 = b11.m(descriptor2, 0);
                String m12 = b11.m(descriptor2, 1);
                String m13 = b11.m(descriptor2, 2);
                b2 b2Var = b2.f68235a;
                obj5 = b11.n(descriptor2, 3, b2Var, null);
                String m14 = b11.m(descriptor2, 4);
                int i16 = b11.i(descriptor2, 5);
                int i17 = b11.i(descriptor2, 6);
                obj4 = b11.n(descriptor2, 7, b2Var, null);
                obj3 = b11.n(descriptor2, 8, b2Var, null);
                obj = b11.n(descriptor2, 9, r0.f68315a, null);
                obj2 = b11.n(descriptor2, 10, c.a.INSTANCE, null);
                str = m11;
                i11 = i17;
                i12 = i16;
                str4 = m14;
                str3 = m13;
                str2 = m12;
                i13 = 2047;
            } else {
                boolean z10 = true;
                int i18 = 0;
                int i19 = 0;
                Object obj6 = null;
                Object obj7 = null;
                Object obj8 = null;
                Object obj9 = null;
                String str5 = null;
                String str6 = null;
                String str7 = null;
                String str8 = null;
                Object obj10 = null;
                int i20 = 0;
                while (z10) {
                    int o11 = b11.o(descriptor2);
                    switch (o11) {
                        case -1:
                            z10 = false;
                            i14 = 10;
                        case 0:
                            str5 = b11.m(descriptor2, 0);
                            i19 |= 1;
                            i14 = 10;
                            i15 = 9;
                        case 1:
                            str6 = b11.m(descriptor2, 1);
                            i19 |= 2;
                            i14 = 10;
                            i15 = 9;
                        case 2:
                            str7 = b11.m(descriptor2, 2);
                            i19 |= 4;
                            i14 = 10;
                            i15 = 9;
                        case 3:
                            obj10 = b11.n(descriptor2, 3, b2.f68235a, obj10);
                            i19 |= 8;
                            i14 = 10;
                            i15 = 9;
                        case 4:
                            str8 = b11.m(descriptor2, 4);
                            i19 |= 16;
                            i14 = 10;
                        case 5:
                            i20 = b11.i(descriptor2, 5);
                            i19 |= 32;
                        case 6:
                            i18 = b11.i(descriptor2, 6);
                            i19 |= 64;
                        case 7:
                            obj9 = b11.n(descriptor2, 7, b2.f68235a, obj9);
                            i19 |= 128;
                        case 8:
                            obj8 = b11.n(descriptor2, 8, b2.f68235a, obj8);
                            i19 |= 256;
                        case 9:
                            obj6 = b11.n(descriptor2, i15, r0.f68315a, obj6);
                            i19 |= 512;
                        case 10:
                            obj7 = b11.n(descriptor2, i14, c.a.INSTANCE, obj7);
                            i19 |= 1024;
                        default:
                            throw new UnknownFieldException(o11);
                    }
                }
                i11 = i18;
                obj = obj6;
                obj2 = obj7;
                obj3 = obj8;
                obj4 = obj9;
                obj5 = obj10;
                i12 = i20;
                i13 = i19;
                str = str5;
                str2 = str6;
                str3 = str7;
                str4 = str8;
            }
            b11.c(descriptor2);
            return new d(i13, str, str2, str3, (String) obj5, str4, i12, i11, (String) obj4, (String) obj3, (Integer) obj, (c) obj2, (w1) null);
        }

        @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
        public kotlinx.serialization.descriptors.f getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.g
        public void serialize(e00.f encoder, d value) {
            Intrinsics.h(encoder, "encoder");
            Intrinsics.h(value, "value");
            kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
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

    /* loaded from: classes7.dex */
    public static final class c {
        public static final b Companion = new b(null);
        private String amazonAdvertisingId;
        private String appSetId;
        private Integer appSetIdScope;
        private float batteryLevel;
        private int batterySaverEnabled;
        private String batteryState;
        private String connectionType;
        private String connectionTypeDetail;
        private String gaid;
        private boolean isGooglePlayServicesAvailable;
        private boolean isSideloadEnabled;
        private boolean isTv;
        private String language;
        private String locale;
        private Long obt;
        private Long oit;
        private Long ort;
        private int sdCardAvailable;
        private int soundEnabled;
        private String timeZone;
        private float volumeLevel;

        /* loaded from: classes7.dex */
        public static final class a implements i0 {
            public static final a INSTANCE;
            public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

            static {
                a aVar = new a();
                INSTANCE = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.DeviceNode.VungleExt", aVar, 21);
                pluginGeneratedSerialDescriptor.l("is_google_play_services_available", true);
                pluginGeneratedSerialDescriptor.l("app_set_id", true);
                pluginGeneratedSerialDescriptor.l("app_set_id_scope", true);
                pluginGeneratedSerialDescriptor.l("battery_level", true);
                pluginGeneratedSerialDescriptor.l("battery_state", true);
                pluginGeneratedSerialDescriptor.l("battery_saver_enabled", true);
                pluginGeneratedSerialDescriptor.l("connection_type", true);
                pluginGeneratedSerialDescriptor.l("connection_type_detail", true);
                pluginGeneratedSerialDescriptor.l("locale", true);
                pluginGeneratedSerialDescriptor.l(TmcConstants.KEY_LANGUAGE, true);
                pluginGeneratedSerialDescriptor.l("time_zone", true);
                pluginGeneratedSerialDescriptor.l("volume_level", true);
                pluginGeneratedSerialDescriptor.l("sound_enabled", true);
                pluginGeneratedSerialDescriptor.l("is_tv", true);
                pluginGeneratedSerialDescriptor.l("sd_card_available", true);
                pluginGeneratedSerialDescriptor.l("is_sideload_enabled", true);
                pluginGeneratedSerialDescriptor.l(UrlKt.KEY_MINI_GAID, true);
                pluginGeneratedSerialDescriptor.l("amazon_advertising_id", true);
                pluginGeneratedSerialDescriptor.l("oit", true);
                pluginGeneratedSerialDescriptor.l("ort", true);
                pluginGeneratedSerialDescriptor.l("obt", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // kotlinx.serialization.internal.i0
            public kotlinx.serialization.b[] childSerializers() {
                b2 b2Var = b2.f68235a;
                kotlinx.serialization.b s11 = d00.a.s(b2Var);
                r0 r0Var = r0.f68315a;
                kotlinx.serialization.b s12 = d00.a.s(r0Var);
                kotlinx.serialization.b s13 = d00.a.s(b2Var);
                kotlinx.serialization.b s14 = d00.a.s(b2Var);
                kotlinx.serialization.b s15 = d00.a.s(b2Var);
                kotlinx.serialization.b s16 = d00.a.s(b2Var);
                kotlinx.serialization.b s17 = d00.a.s(b2Var);
                kotlinx.serialization.b s18 = d00.a.s(b2Var);
                kotlinx.serialization.b s19 = d00.a.s(b2Var);
                kotlinx.serialization.b s20 = d00.a.s(b2Var);
                b1 b1Var = b1.f68233a;
                kotlinx.serialization.b s21 = d00.a.s(b1Var);
                kotlinx.serialization.b s22 = d00.a.s(b1Var);
                kotlinx.serialization.b s23 = d00.a.s(b1Var);
                kotlinx.serialization.internal.i iVar = kotlinx.serialization.internal.i.f68275a;
                h0 h0Var = h0.f68269a;
                return new kotlinx.serialization.b[]{iVar, s11, s12, h0Var, s13, r0Var, s14, s15, s16, s17, s18, h0Var, r0Var, iVar, r0Var, iVar, s19, s20, s21, s22, s23};
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00eb. Please report as an issue. */
            @Override // kotlinx.serialization.a
            public c deserialize(e00.e decoder) {
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
                boolean z10;
                float f11;
                Object obj10;
                int i12;
                boolean z11;
                boolean z12;
                int i13;
                float f12;
                int i14;
                Object obj11;
                Object obj12;
                Object obj13;
                Object obj14;
                int i15;
                Object obj15;
                Intrinsics.h(decoder, "decoder");
                kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
                e00.c b11 = decoder.b(descriptor2);
                int i16 = 0;
                if (b11.p()) {
                    boolean C = b11.C(descriptor2, 0);
                    b2 b2Var = b2.f68235a;
                    Object n11 = b11.n(descriptor2, 1, b2Var, null);
                    obj13 = b11.n(descriptor2, 2, r0.f68315a, null);
                    float u11 = b11.u(descriptor2, 3);
                    obj12 = b11.n(descriptor2, 4, b2Var, null);
                    int i17 = b11.i(descriptor2, 5);
                    obj10 = b11.n(descriptor2, 6, b2Var, null);
                    obj11 = b11.n(descriptor2, 7, b2Var, null);
                    obj9 = b11.n(descriptor2, 8, b2Var, null);
                    obj8 = b11.n(descriptor2, 9, b2Var, null);
                    obj7 = b11.n(descriptor2, 10, b2Var, null);
                    float u12 = b11.u(descriptor2, 11);
                    int i18 = b11.i(descriptor2, 12);
                    boolean C2 = b11.C(descriptor2, 13);
                    int i19 = b11.i(descriptor2, 14);
                    boolean C3 = b11.C(descriptor2, 15);
                    obj4 = n11;
                    Object n12 = b11.n(descriptor2, 16, b2Var, null);
                    Object n13 = b11.n(descriptor2, 17, b2Var, null);
                    b1 b1Var = b1.f68233a;
                    obj6 = n13;
                    obj5 = b11.n(descriptor2, 18, b1Var, null);
                    f11 = u11;
                    i11 = 2097151;
                    i12 = i18;
                    i13 = i17;
                    f12 = u12;
                    z10 = C3;
                    i14 = i19;
                    z12 = C2;
                    z11 = C;
                    obj = b11.n(descriptor2, 19, b1Var, null);
                    obj2 = b11.n(descriptor2, 20, b1Var, null);
                    obj3 = n12;
                } else {
                    obj = null;
                    boolean z13 = true;
                    Object obj16 = null;
                    Object obj17 = null;
                    Object obj18 = null;
                    Object obj19 = null;
                    Object obj20 = null;
                    Object obj21 = null;
                    Object obj22 = null;
                    Object obj23 = null;
                    Object obj24 = null;
                    Object obj25 = null;
                    Object obj26 = null;
                    int i20 = 0;
                    boolean z14 = false;
                    int i21 = 0;
                    boolean z15 = false;
                    boolean z16 = false;
                    int i22 = 0;
                    float f13 = 0.0f;
                    float f14 = 0.0f;
                    obj2 = null;
                    while (z13) {
                        int i23 = i20;
                        int o11 = b11.o(descriptor2);
                        switch (o11) {
                            case -1:
                                obj15 = obj26;
                                z13 = false;
                                obj16 = obj16;
                                obj26 = obj15;
                                i20 = i23;
                            case 0:
                                obj15 = obj26;
                                z15 = b11.C(descriptor2, 0);
                                i16 |= 1;
                                obj16 = obj16;
                                obj17 = obj17;
                                obj26 = obj15;
                                i20 = i23;
                            case 1:
                                Object obj27 = obj17;
                                i16 |= 2;
                                obj17 = obj27;
                                i20 = i23;
                                obj26 = b11.n(descriptor2, 1, b2.f68235a, obj26);
                                obj16 = obj16;
                            case 2:
                                obj16 = b11.n(descriptor2, 2, r0.f68315a, obj16);
                                i16 |= 4;
                                obj17 = obj17;
                                i20 = i23;
                            case 3:
                                obj14 = obj16;
                                f13 = b11.u(descriptor2, 3);
                                i16 |= 8;
                                i20 = i23;
                                obj16 = obj14;
                            case 4:
                                obj14 = obj16;
                                obj20 = b11.n(descriptor2, 4, b2.f68235a, obj20);
                                i16 |= 16;
                                i20 = i23;
                                obj16 = obj14;
                            case 5:
                                obj14 = obj16;
                                i22 = b11.i(descriptor2, 5);
                                i16 |= 32;
                                i20 = i23;
                                obj16 = obj14;
                            case 6:
                                obj14 = obj16;
                                obj17 = b11.n(descriptor2, 6, b2.f68235a, obj17);
                                i16 |= 64;
                                i20 = i23;
                                obj16 = obj14;
                            case 7:
                                obj14 = obj16;
                                obj18 = b11.n(descriptor2, 7, b2.f68235a, obj18);
                                i16 |= 128;
                                i20 = i23;
                                obj16 = obj14;
                            case 8:
                                obj14 = obj16;
                                obj25 = b11.n(descriptor2, 8, b2.f68235a, obj25);
                                i16 |= 256;
                                i20 = i23;
                                obj16 = obj14;
                            case 9:
                                obj14 = obj16;
                                obj24 = b11.n(descriptor2, 9, b2.f68235a, obj24);
                                i16 |= 512;
                                i20 = i23;
                                obj16 = obj14;
                            case 10:
                                obj14 = obj16;
                                obj23 = b11.n(descriptor2, 10, b2.f68235a, obj23);
                                i16 |= 1024;
                                i20 = i23;
                                obj16 = obj14;
                            case 11:
                                obj14 = obj16;
                                f14 = b11.u(descriptor2, 11);
                                i16 |= 2048;
                                i20 = i23;
                                obj16 = obj14;
                            case 12:
                                obj14 = obj16;
                                i21 = b11.i(descriptor2, 12);
                                i16 |= 4096;
                                i20 = i23;
                                obj16 = obj14;
                            case 13:
                                obj14 = obj16;
                                z16 = b11.C(descriptor2, 13);
                                i16 |= 8192;
                                i20 = i23;
                                obj16 = obj14;
                            case 14:
                                obj14 = obj16;
                                i16 |= 16384;
                                i20 = b11.i(descriptor2, 14);
                                obj16 = obj14;
                            case 15:
                                obj14 = obj16;
                                z14 = b11.C(descriptor2, 15);
                                i16 |= 32768;
                                i20 = i23;
                                obj16 = obj14;
                            case 16:
                                obj14 = obj16;
                                obj19 = b11.n(descriptor2, 16, b2.f68235a, obj19);
                                i15 = 65536;
                                i16 |= i15;
                                i20 = i23;
                                obj16 = obj14;
                            case 17:
                                obj14 = obj16;
                                obj22 = b11.n(descriptor2, 17, b2.f68235a, obj22);
                                i15 = 131072;
                                i16 |= i15;
                                i20 = i23;
                                obj16 = obj14;
                            case 18:
                                obj14 = obj16;
                                obj21 = b11.n(descriptor2, 18, b1.f68233a, obj21);
                                i15 = 262144;
                                i16 |= i15;
                                i20 = i23;
                                obj16 = obj14;
                            case 19:
                                obj14 = obj16;
                                obj = b11.n(descriptor2, 19, b1.f68233a, obj);
                                i15 = 524288;
                                i16 |= i15;
                                i20 = i23;
                                obj16 = obj14;
                            case 20:
                                obj14 = obj16;
                                obj2 = b11.n(descriptor2, 20, b1.f68233a, obj2);
                                i15 = 1048576;
                                i16 |= i15;
                                i20 = i23;
                                obj16 = obj14;
                            default:
                                throw new UnknownFieldException(o11);
                        }
                    }
                    int i24 = i20;
                    Object obj28 = obj26;
                    Object obj29 = obj16;
                    obj3 = obj19;
                    i11 = i16;
                    obj4 = obj28;
                    obj5 = obj21;
                    obj6 = obj22;
                    obj7 = obj23;
                    obj8 = obj24;
                    obj9 = obj25;
                    z10 = z14;
                    f11 = f13;
                    obj10 = obj17;
                    i12 = i21;
                    z11 = z15;
                    z12 = z16;
                    i13 = i22;
                    f12 = f14;
                    i14 = i24;
                    obj11 = obj18;
                    obj12 = obj20;
                    obj13 = obj29;
                }
                b11.c(descriptor2);
                return new c(i11, z11, (String) obj4, (Integer) obj13, f11, (String) obj12, i13, (String) obj10, (String) obj11, (String) obj9, (String) obj8, (String) obj7, f12, i12, z12, i14, z10, (String) obj3, (String) obj6, (Long) obj5, (Long) obj, (Long) obj2, (w1) null);
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
            this(false, (String) null, (Integer) null, 0.0f, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0f, 0, false, 0, false, (String) null, (String) null, (Long) null, (Long) null, (Long) null, 2097151, (DefaultConstructorMarker) null);
        }

        @Deprecated
        public /* synthetic */ c(int i11, boolean z10, String str, Integer num, float f11, String str2, int i12, String str3, String str4, String str5, String str6, String str7, float f12, int i13, boolean z11, int i14, boolean z12, String str8, String str9, Long l11, Long l12, Long l13, w1 w1Var) {
            if ((i11 & 1) == 0) {
                this.isGooglePlayServicesAvailable = false;
            } else {
                this.isGooglePlayServicesAvailable = z10;
            }
            if ((i11 & 2) == 0) {
                this.appSetId = null;
            } else {
                this.appSetId = str;
            }
            if ((i11 & 4) == 0) {
                this.appSetIdScope = null;
            } else {
                this.appSetIdScope = num;
            }
            if ((i11 & 8) == 0) {
                this.batteryLevel = 0.0f;
            } else {
                this.batteryLevel = f11;
            }
            if ((i11 & 16) == 0) {
                this.batteryState = null;
            } else {
                this.batteryState = str2;
            }
            if ((i11 & 32) == 0) {
                this.batterySaverEnabled = 0;
            } else {
                this.batterySaverEnabled = i12;
            }
            if ((i11 & 64) == 0) {
                this.connectionType = null;
            } else {
                this.connectionType = str3;
            }
            if ((i11 & 128) == 0) {
                this.connectionTypeDetail = null;
            } else {
                this.connectionTypeDetail = str4;
            }
            if ((i11 & 256) == 0) {
                this.locale = null;
            } else {
                this.locale = str5;
            }
            if ((i11 & 512) == 0) {
                this.language = null;
            } else {
                this.language = str6;
            }
            if ((i11 & 1024) == 0) {
                this.timeZone = null;
            } else {
                this.timeZone = str7;
            }
            if ((i11 & 2048) == 0) {
                this.volumeLevel = 0.0f;
            } else {
                this.volumeLevel = f12;
            }
            if ((i11 & 4096) == 0) {
                this.soundEnabled = 1;
            } else {
                this.soundEnabled = i13;
            }
            if ((i11 & 8192) == 0) {
                this.isTv = false;
            } else {
                this.isTv = z11;
            }
            if ((i11 & 16384) == 0) {
                this.sdCardAvailable = 1;
            } else {
                this.sdCardAvailable = i14;
            }
            if ((32768 & i11) == 0) {
                this.isSideloadEnabled = false;
            } else {
                this.isSideloadEnabled = z12;
            }
            if ((65536 & i11) == 0) {
                this.gaid = null;
            } else {
                this.gaid = str8;
            }
            if ((131072 & i11) == 0) {
                this.amazonAdvertisingId = null;
            } else {
                this.amazonAdvertisingId = str9;
            }
            if ((262144 & i11) == 0) {
                this.oit = null;
            } else {
                this.oit = l11;
            }
            if ((524288 & i11) == 0) {
                this.ort = null;
            } else {
                this.ort = l12;
            }
            if ((i11 & 1048576) == 0) {
                this.obt = null;
            } else {
                this.obt = l13;
            }
        }

        public c(boolean z10, String str, Integer num, float f11, String str2, int i11, String str3, String str4, String str5, String str6, String str7, float f12, int i12, boolean z11, int i13, boolean z12, String str8, String str9, Long l11, Long l12, Long l13) {
            this.isGooglePlayServicesAvailable = z10;
            this.appSetId = str;
            this.appSetIdScope = num;
            this.batteryLevel = f11;
            this.batteryState = str2;
            this.batterySaverEnabled = i11;
            this.connectionType = str3;
            this.connectionTypeDetail = str4;
            this.locale = str5;
            this.language = str6;
            this.timeZone = str7;
            this.volumeLevel = f12;
            this.soundEnabled = i12;
            this.isTv = z11;
            this.sdCardAvailable = i13;
            this.isSideloadEnabled = z12;
            this.gaid = str8;
            this.amazonAdvertisingId = str9;
            this.oit = l11;
            this.ort = l12;
            this.obt = l13;
        }

        public /* synthetic */ c(boolean z10, String str, Integer num, float f11, String str2, int i11, String str3, String str4, String str5, String str6, String str7, float f12, int i12, boolean z11, int i13, boolean z12, String str8, String str9, Long l11, Long l12, Long l13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
            this((i14 & 1) != 0 ? false : z10, (i14 & 2) != 0 ? null : str, (i14 & 4) != 0 ? null : num, (i14 & 8) != 0 ? 0.0f : f11, (i14 & 16) != 0 ? null : str2, (i14 & 32) != 0 ? 0 : i11, (i14 & 64) != 0 ? null : str3, (i14 & 128) != 0 ? null : str4, (i14 & 256) != 0 ? null : str5, (i14 & 512) != 0 ? null : str6, (i14 & 1024) != 0 ? null : str7, (i14 & 2048) == 0 ? f12 : 0.0f, (i14 & 4096) != 0 ? 1 : i12, (i14 & 8192) != 0 ? false : z11, (i14 & 16384) == 0 ? i13 : 1, (32768 & i14) != 0 ? false : z12, (i14 & 65536) != 0 ? null : str8, (i14 & 131072) != 0 ? null : str9, (i14 & 262144) != 0 ? null : l11, (i14 & 524288) != 0 ? null : l12, (i14 & 1048576) != 0 ? null : l13);
        }

        public static /* synthetic */ void getAmazonAdvertisingId$annotations() {
        }

        public static /* synthetic */ void getAppSetId$annotations() {
        }

        public static /* synthetic */ void getAppSetIdScope$annotations() {
        }

        public static /* synthetic */ void getBatteryLevel$annotations() {
        }

        public static /* synthetic */ void getBatterySaverEnabled$annotations() {
        }

        public static /* synthetic */ void getBatteryState$annotations() {
        }

        public static /* synthetic */ void getConnectionType$annotations() {
        }

        public static /* synthetic */ void getConnectionTypeDetail$annotations() {
        }

        public static /* synthetic */ void getGaid$annotations() {
        }

        public static /* synthetic */ void getLanguage$annotations() {
        }

        public static /* synthetic */ void getLocale$annotations() {
        }

        public static /* synthetic */ void getObt$annotations() {
        }

        public static /* synthetic */ void getOit$annotations() {
        }

        public static /* synthetic */ void getOrt$annotations() {
        }

        public static /* synthetic */ void getSdCardAvailable$annotations() {
        }

        public static /* synthetic */ void getSoundEnabled$annotations() {
        }

        public static /* synthetic */ void getTimeZone$annotations() {
        }

        public static /* synthetic */ void getVolumeLevel$annotations() {
        }

        public static /* synthetic */ void isGooglePlayServicesAvailable$annotations() {
        }

        public static /* synthetic */ void isSideloadEnabled$annotations() {
        }

        public static /* synthetic */ void isTv$annotations() {
        }

        @JvmStatic
        public static final void write$Self(c self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
            Intrinsics.h(self, "self");
            Intrinsics.h(output, "output");
            Intrinsics.h(serialDesc, "serialDesc");
            if (output.z(serialDesc, 0) || self.isGooglePlayServicesAvailable) {
                output.x(serialDesc, 0, self.isGooglePlayServicesAvailable);
            }
            if (output.z(serialDesc, 1) || self.appSetId != null) {
                output.i(serialDesc, 1, b2.f68235a, self.appSetId);
            }
            if (output.z(serialDesc, 2) || self.appSetIdScope != null) {
                output.i(serialDesc, 2, r0.f68315a, self.appSetIdScope);
            }
            if (output.z(serialDesc, 3) || !Intrinsics.c(Float.valueOf(self.batteryLevel), Float.valueOf(0.0f))) {
                output.s(serialDesc, 3, self.batteryLevel);
            }
            if (output.z(serialDesc, 4) || self.batteryState != null) {
                output.i(serialDesc, 4, b2.f68235a, self.batteryState);
            }
            if (output.z(serialDesc, 5) || self.batterySaverEnabled != 0) {
                output.w(serialDesc, 5, self.batterySaverEnabled);
            }
            if (output.z(serialDesc, 6) || self.connectionType != null) {
                output.i(serialDesc, 6, b2.f68235a, self.connectionType);
            }
            if (output.z(serialDesc, 7) || self.connectionTypeDetail != null) {
                output.i(serialDesc, 7, b2.f68235a, self.connectionTypeDetail);
            }
            if (output.z(serialDesc, 8) || self.locale != null) {
                output.i(serialDesc, 8, b2.f68235a, self.locale);
            }
            if (output.z(serialDesc, 9) || self.language != null) {
                output.i(serialDesc, 9, b2.f68235a, self.language);
            }
            if (output.z(serialDesc, 10) || self.timeZone != null) {
                output.i(serialDesc, 10, b2.f68235a, self.timeZone);
            }
            if (output.z(serialDesc, 11) || !Intrinsics.c(Float.valueOf(self.volumeLevel), Float.valueOf(0.0f))) {
                output.s(serialDesc, 11, self.volumeLevel);
            }
            if (output.z(serialDesc, 12) || self.soundEnabled != 1) {
                output.w(serialDesc, 12, self.soundEnabled);
            }
            if (output.z(serialDesc, 13) || self.isTv) {
                output.x(serialDesc, 13, self.isTv);
            }
            if (output.z(serialDesc, 14) || self.sdCardAvailable != 1) {
                output.w(serialDesc, 14, self.sdCardAvailable);
            }
            if (output.z(serialDesc, 15) || self.isSideloadEnabled) {
                output.x(serialDesc, 15, self.isSideloadEnabled);
            }
            if (output.z(serialDesc, 16) || self.gaid != null) {
                output.i(serialDesc, 16, b2.f68235a, self.gaid);
            }
            if (output.z(serialDesc, 17) || self.amazonAdvertisingId != null) {
                output.i(serialDesc, 17, b2.f68235a, self.amazonAdvertisingId);
            }
            if (output.z(serialDesc, 18) || self.oit != null) {
                output.i(serialDesc, 18, b1.f68233a, self.oit);
            }
            if (output.z(serialDesc, 19) || self.ort != null) {
                output.i(serialDesc, 19, b1.f68233a, self.ort);
            }
            if (!output.z(serialDesc, 20) && self.obt == null) {
                return;
            }
            output.i(serialDesc, 20, b1.f68233a, self.obt);
        }

        public final boolean component1() {
            return this.isGooglePlayServicesAvailable;
        }

        public final String component10() {
            return this.language;
        }

        public final String component11() {
            return this.timeZone;
        }

        public final float component12() {
            return this.volumeLevel;
        }

        public final int component13() {
            return this.soundEnabled;
        }

        public final boolean component14() {
            return this.isTv;
        }

        public final int component15() {
            return this.sdCardAvailable;
        }

        public final boolean component16() {
            return this.isSideloadEnabled;
        }

        public final String component17() {
            return this.gaid;
        }

        public final String component18() {
            return this.amazonAdvertisingId;
        }

        public final Long component19() {
            return this.oit;
        }

        public final String component2() {
            return this.appSetId;
        }

        public final Long component20() {
            return this.ort;
        }

        public final Long component21() {
            return this.obt;
        }

        public final Integer component3() {
            return this.appSetIdScope;
        }

        public final float component4() {
            return this.batteryLevel;
        }

        public final String component5() {
            return this.batteryState;
        }

        public final int component6() {
            return this.batterySaverEnabled;
        }

        public final String component7() {
            return this.connectionType;
        }

        public final String component8() {
            return this.connectionTypeDetail;
        }

        public final String component9() {
            return this.locale;
        }

        public final c copy(boolean z10, String str, Integer num, float f11, String str2, int i11, String str3, String str4, String str5, String str6, String str7, float f12, int i12, boolean z11, int i13, boolean z12, String str8, String str9, Long l11, Long l12, Long l13) {
            return new c(z10, str, num, f11, str2, i11, str3, str4, str5, str6, str7, f12, i12, z11, i13, z12, str8, str9, l11, l12, l13);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.isGooglePlayServicesAvailable == cVar.isGooglePlayServicesAvailable && Intrinsics.c(this.appSetId, cVar.appSetId) && Intrinsics.c(this.appSetIdScope, cVar.appSetIdScope) && Intrinsics.c(Float.valueOf(this.batteryLevel), Float.valueOf(cVar.batteryLevel)) && Intrinsics.c(this.batteryState, cVar.batteryState) && this.batterySaverEnabled == cVar.batterySaverEnabled && Intrinsics.c(this.connectionType, cVar.connectionType) && Intrinsics.c(this.connectionTypeDetail, cVar.connectionTypeDetail) && Intrinsics.c(this.locale, cVar.locale) && Intrinsics.c(this.language, cVar.language) && Intrinsics.c(this.timeZone, cVar.timeZone) && Intrinsics.c(Float.valueOf(this.volumeLevel), Float.valueOf(cVar.volumeLevel)) && this.soundEnabled == cVar.soundEnabled && this.isTv == cVar.isTv && this.sdCardAvailable == cVar.sdCardAvailable && this.isSideloadEnabled == cVar.isSideloadEnabled && Intrinsics.c(this.gaid, cVar.gaid) && Intrinsics.c(this.amazonAdvertisingId, cVar.amazonAdvertisingId) && Intrinsics.c(this.oit, cVar.oit) && Intrinsics.c(this.ort, cVar.ort) && Intrinsics.c(this.obt, cVar.obt);
        }

        public final String getAmazonAdvertisingId() {
            return this.amazonAdvertisingId;
        }

        public final String getAppSetId() {
            return this.appSetId;
        }

        public final Integer getAppSetIdScope() {
            return this.appSetIdScope;
        }

        public final float getBatteryLevel() {
            return this.batteryLevel;
        }

        public final int getBatterySaverEnabled() {
            return this.batterySaverEnabled;
        }

        public final String getBatteryState() {
            return this.batteryState;
        }

        public final String getConnectionType() {
            return this.connectionType;
        }

        public final String getConnectionTypeDetail() {
            return this.connectionTypeDetail;
        }

        public final String getGaid() {
            return this.gaid;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final Long getObt() {
            return this.obt;
        }

        public final Long getOit() {
            return this.oit;
        }

        public final Long getOrt() {
            return this.ort;
        }

        public final int getSdCardAvailable() {
            return this.sdCardAvailable;
        }

        public final int getSoundEnabled() {
            return this.soundEnabled;
        }

        public final String getTimeZone() {
            return this.timeZone;
        }

        public final float getVolumeLevel() {
            return this.volumeLevel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v42 */
        /* JADX WARN: Type inference failed for: r0v43 */
        /* JADX WARN: Type inference failed for: r2v30, types: [boolean] */
        public int hashCode() {
            boolean z10 = this.isGooglePlayServicesAvailable;
            ?? r02 = z10;
            if (z10) {
                r02 = 1;
            }
            int i11 = r02 * 31;
            String str = this.appSetId;
            int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.appSetIdScope;
            int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Float.floatToIntBits(this.batteryLevel)) * 31;
            String str2 = this.batteryState;
            int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.batterySaverEnabled) * 31;
            String str3 = this.connectionType;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.connectionTypeDetail;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.locale;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.language;
            int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.timeZone;
            int hashCode8 = (((((hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Float.floatToIntBits(this.volumeLevel)) * 31) + this.soundEnabled) * 31;
            ?? r22 = this.isTv;
            int i12 = r22;
            if (r22 != 0) {
                i12 = 1;
            }
            int i13 = (((hashCode8 + i12) * 31) + this.sdCardAvailable) * 31;
            boolean z11 = this.isSideloadEnabled;
            int i14 = (i13 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
            String str8 = this.gaid;
            int hashCode9 = (i14 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.amazonAdvertisingId;
            int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
            Long l11 = this.oit;
            int hashCode11 = (hashCode10 + (l11 == null ? 0 : l11.hashCode())) * 31;
            Long l12 = this.ort;
            int hashCode12 = (hashCode11 + (l12 == null ? 0 : l12.hashCode())) * 31;
            Long l13 = this.obt;
            return hashCode12 + (l13 != null ? l13.hashCode() : 0);
        }

        public final boolean isGooglePlayServicesAvailable() {
            return this.isGooglePlayServicesAvailable;
        }

        public final boolean isSideloadEnabled() {
            return this.isSideloadEnabled;
        }

        public final boolean isTv() {
            return this.isTv;
        }

        public final void setAmazonAdvertisingId(String str) {
            this.amazonAdvertisingId = str;
        }

        public final void setAppSetId(String str) {
            this.appSetId = str;
        }

        public final void setAppSetIdScope(Integer num) {
            this.appSetIdScope = num;
        }

        public final void setBatteryLevel(float f11) {
            this.batteryLevel = f11;
        }

        public final void setBatterySaverEnabled(int i11) {
            this.batterySaverEnabled = i11;
        }

        public final void setBatteryState(String str) {
            this.batteryState = str;
        }

        public final void setConnectionType(String str) {
            this.connectionType = str;
        }

        public final void setConnectionTypeDetail(String str) {
            this.connectionTypeDetail = str;
        }

        public final void setGaid(String str) {
            this.gaid = str;
        }

        public final void setGooglePlayServicesAvailable(boolean z10) {
            this.isGooglePlayServicesAvailable = z10;
        }

        public final void setLanguage(String str) {
            this.language = str;
        }

        public final void setLocale(String str) {
            this.locale = str;
        }

        public final void setObt(Long l11) {
            this.obt = l11;
        }

        public final void setOit(Long l11) {
            this.oit = l11;
        }

        public final void setOrt(Long l11) {
            this.ort = l11;
        }

        public final void setSdCardAvailable(int i11) {
            this.sdCardAvailable = i11;
        }

        public final void setSideloadEnabled(boolean z10) {
            this.isSideloadEnabled = z10;
        }

        public final void setSoundEnabled(int i11) {
            this.soundEnabled = i11;
        }

        public final void setTimeZone(String str) {
            this.timeZone = str;
        }

        public final void setTv(boolean z10) {
            this.isTv = z10;
        }

        public final void setVolumeLevel(float f11) {
            this.volumeLevel = f11;
        }

        public String toString() {
            return "VungleExt(isGooglePlayServicesAvailable=" + this.isGooglePlayServicesAvailable + ", appSetId=" + this.appSetId + ", appSetIdScope=" + this.appSetIdScope + ", batteryLevel=" + this.batteryLevel + ", batteryState=" + this.batteryState + ", batterySaverEnabled=" + this.batterySaverEnabled + ", connectionType=" + this.connectionType + ", connectionTypeDetail=" + this.connectionTypeDetail + ", locale=" + this.locale + ", language=" + this.language + ", timeZone=" + this.timeZone + ", volumeLevel=" + this.volumeLevel + ", soundEnabled=" + this.soundEnabled + ", isTv=" + this.isTv + ", sdCardAvailable=" + this.sdCardAvailable + ", isSideloadEnabled=" + this.isSideloadEnabled + ", gaid=" + this.gaid + ", amazonAdvertisingId=" + this.amazonAdvertisingId + ", oit=" + this.oit + ", ort=" + this.ort + ", obt=" + this.obt + ')';
        }
    }

    @Deprecated
    public /* synthetic */ d(int i11, String str, String str2, String str3, String str4, String str5, int i12, int i13, String str6, String str7, Integer num, c cVar, w1 w1Var) {
        if (119 != (i11 & Sdk$SDKError.Reason.JSON_ENCODE_ERROR_VALUE)) {
            m1.a(i11, Sdk$SDKError.Reason.JSON_ENCODE_ERROR_VALUE, a.INSTANCE.getDescriptor());
        }
        this.make = str;
        this.model = str2;
        this.osv = str3;
        if ((i11 & 8) == 0) {
            this.carrier = null;
        } else {
            this.carrier = str4;
        }
        this.f60760os = str5;
        this.f60762w = i12;
        this.f60759h = i13;
        if ((i11 & 128) == 0) {
            this.f60761ua = null;
        } else {
            this.f60761ua = str6;
        }
        if ((i11 & 256) == 0) {
            this.ifa = null;
        } else {
            this.ifa = str7;
        }
        if ((i11 & 512) == 0) {
            this.lmt = null;
        } else {
            this.lmt = num;
        }
        if ((i11 & 1024) == 0) {
            this.ext = null;
        } else {
            this.ext = cVar;
        }
    }

    public d(String make, String model, String osv, String str, String os2, int i11, int i12, String str2, String str3, Integer num, c cVar) {
        Intrinsics.h(make, "make");
        Intrinsics.h(model, "model");
        Intrinsics.h(osv, "osv");
        Intrinsics.h(os2, "os");
        this.make = make;
        this.model = model;
        this.osv = osv;
        this.carrier = str;
        this.f60760os = os2;
        this.f60762w = i11;
        this.f60759h = i12;
        this.f60761ua = str2;
        this.ifa = str3;
        this.lmt = num;
        this.ext = cVar;
    }

    public /* synthetic */ d(String str, String str2, String str3, String str4, String str5, int i11, int i12, String str6, String str7, Integer num, c cVar, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i13 & 8) != 0 ? null : str4, str5, i11, i12, (i13 & 128) != 0 ? null : str6, (i13 & 256) != 0 ? null : str7, (i13 & 512) != 0 ? null : num, (i13 & 1024) != 0 ? null : cVar);
    }

    @JvmStatic
    public static final void write$Self(d self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
        Intrinsics.h(self, "self");
        Intrinsics.h(output, "output");
        Intrinsics.h(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.make);
        output.y(serialDesc, 1, self.model);
        output.y(serialDesc, 2, self.osv);
        if (output.z(serialDesc, 3) || self.carrier != null) {
            output.i(serialDesc, 3, b2.f68235a, self.carrier);
        }
        output.y(serialDesc, 4, self.f60760os);
        output.w(serialDesc, 5, self.f60762w);
        output.w(serialDesc, 6, self.f60759h);
        if (output.z(serialDesc, 7) || self.f60761ua != null) {
            output.i(serialDesc, 7, b2.f68235a, self.f60761ua);
        }
        if (output.z(serialDesc, 8) || self.ifa != null) {
            output.i(serialDesc, 8, b2.f68235a, self.ifa);
        }
        if (output.z(serialDesc, 9) || self.lmt != null) {
            output.i(serialDesc, 9, r0.f68315a, self.lmt);
        }
        if (!output.z(serialDesc, 10) && self.ext == null) {
            return;
        }
        output.i(serialDesc, 10, c.a.INSTANCE, self.ext);
    }

    public final String component1() {
        return this.make;
    }

    public final Integer component10() {
        return this.lmt;
    }

    public final c component11() {
        return this.ext;
    }

    public final String component2() {
        return this.model;
    }

    public final String component3() {
        return this.osv;
    }

    public final String component4() {
        return this.carrier;
    }

    public final String component5() {
        return this.f60760os;
    }

    public final int component6() {
        return this.f60762w;
    }

    public final int component7() {
        return this.f60759h;
    }

    public final String component8() {
        return this.f60761ua;
    }

    public final String component9() {
        return this.ifa;
    }

    public final d copy(String make, String model, String osv, String str, String os2, int i11, int i12, String str2, String str3, Integer num, c cVar) {
        Intrinsics.h(make, "make");
        Intrinsics.h(model, "model");
        Intrinsics.h(osv, "osv");
        Intrinsics.h(os2, "os");
        return new d(make, model, osv, str, os2, i11, i12, str2, str3, num, cVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.c(this.make, dVar.make) && Intrinsics.c(this.model, dVar.model) && Intrinsics.c(this.osv, dVar.osv) && Intrinsics.c(this.carrier, dVar.carrier) && Intrinsics.c(this.f60760os, dVar.f60760os) && this.f60762w == dVar.f60762w && this.f60759h == dVar.f60759h && Intrinsics.c(this.f60761ua, dVar.f60761ua) && Intrinsics.c(this.ifa, dVar.ifa) && Intrinsics.c(this.lmt, dVar.lmt) && Intrinsics.c(this.ext, dVar.ext);
    }

    public final String getCarrier() {
        return this.carrier;
    }

    public final c getExt() {
        return this.ext;
    }

    public final int getH() {
        return this.f60759h;
    }

    public final String getIfa() {
        return this.ifa;
    }

    public final Integer getLmt() {
        return this.lmt;
    }

    public final String getMake() {
        return this.make;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getOs() {
        return this.f60760os;
    }

    public final String getOsv() {
        return this.osv;
    }

    public final String getUa() {
        return this.f60761ua;
    }

    public final int getW() {
        return this.f60762w;
    }

    public int hashCode() {
        int hashCode = ((((this.make.hashCode() * 31) + this.model.hashCode()) * 31) + this.osv.hashCode()) * 31;
        String str = this.carrier;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f60760os.hashCode()) * 31) + this.f60762w) * 31) + this.f60759h) * 31;
        String str2 = this.f60761ua;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ifa;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.lmt;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        c cVar = this.ext;
        return hashCode5 + (cVar != null ? cVar.hashCode() : 0);
    }

    public final void setExt(c cVar) {
        this.ext = cVar;
    }

    public final void setH(int i11) {
        this.f60759h = i11;
    }

    public final void setIfa(String str) {
        this.ifa = str;
    }

    public final void setLmt(Integer num) {
        this.lmt = num;
    }

    public final void setUa(String str) {
        this.f60761ua = str;
    }

    public final void setW(int i11) {
        this.f60762w = i11;
    }

    public String toString() {
        return "DeviceNode(make=" + this.make + ", model=" + this.model + ", osv=" + this.osv + ", carrier=" + this.carrier + ", os=" + this.f60760os + ", w=" + this.f60762w + ", h=" + this.f60759h + ", ua=" + this.f60761ua + ", ifa=" + this.ifa + ", lmt=" + this.lmt + ", ext=" + this.ext + ')';
    }
}
