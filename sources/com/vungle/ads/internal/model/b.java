package com.vungle.ads.internal.model;

import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.i0;
import kotlinx.serialization.internal.m1;
import kotlinx.serialization.internal.w1;

/* loaded from: classes7.dex */
public final class b {
    public static final C0734b Companion = new C0734b(null);
    private final String appId;
    private final String bundle;
    private final String ver;

    /* loaded from: classes7.dex */
    public static final class a implements i0 {
        public static final a INSTANCE;
        public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AppNode", aVar, 3);
            pluginGeneratedSerialDescriptor.l("bundle", false);
            pluginGeneratedSerialDescriptor.l("ver", false);
            pluginGeneratedSerialDescriptor.l("id", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // kotlinx.serialization.internal.i0
        public kotlinx.serialization.b[] childSerializers() {
            b2 b2Var = b2.f68235a;
            return new kotlinx.serialization.b[]{b2Var, b2Var, b2Var};
        }

        @Override // kotlinx.serialization.a
        public b deserialize(e00.e decoder) {
            String str;
            String str2;
            String str3;
            int i11;
            Intrinsics.h(decoder, "decoder");
            kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
            e00.c b11 = decoder.b(descriptor2);
            if (b11.p()) {
                String m11 = b11.m(descriptor2, 0);
                String m12 = b11.m(descriptor2, 1);
                str = m11;
                str2 = b11.m(descriptor2, 2);
                str3 = m12;
                i11 = 7;
            } else {
                String str4 = null;
                String str5 = null;
                String str6 = null;
                boolean z10 = true;
                int i12 = 0;
                while (z10) {
                    int o11 = b11.o(descriptor2);
                    if (o11 == -1) {
                        z10 = false;
                    } else if (o11 == 0) {
                        str4 = b11.m(descriptor2, 0);
                        i12 |= 1;
                    } else if (o11 == 1) {
                        str6 = b11.m(descriptor2, 1);
                        i12 |= 2;
                    } else {
                        if (o11 != 2) {
                            throw new UnknownFieldException(o11);
                        }
                        str5 = b11.m(descriptor2, 2);
                        i12 |= 4;
                    }
                }
                str = str4;
                str2 = str5;
                str3 = str6;
                i11 = i12;
            }
            b11.c(descriptor2);
            return new b(i11, str, str3, str2, null);
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

    /* renamed from: com.vungle.ads.internal.model.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0734b {
        private C0734b() {
        }

        public /* synthetic */ C0734b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final kotlinx.serialization.b serializer() {
            return a.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ b(int i11, String str, String str2, String str3, w1 w1Var) {
        if (7 != (i11 & 7)) {
            m1.a(i11, 7, a.INSTANCE.getDescriptor());
        }
        this.bundle = str;
        this.ver = str2;
        this.appId = str3;
    }

    public b(String bundle, String ver, String appId) {
        Intrinsics.h(bundle, "bundle");
        Intrinsics.h(ver, "ver");
        Intrinsics.h(appId, "appId");
        this.bundle = bundle;
        this.ver = ver;
        this.appId = appId;
    }

    public static /* synthetic */ b copy$default(b bVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bVar.bundle;
        }
        if ((i11 & 2) != 0) {
            str2 = bVar.ver;
        }
        if ((i11 & 4) != 0) {
            str3 = bVar.appId;
        }
        return bVar.copy(str, str2, str3);
    }

    public static /* synthetic */ void getAppId$annotations() {
    }

    @JvmStatic
    public static final void write$Self(b self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
        Intrinsics.h(self, "self");
        Intrinsics.h(output, "output");
        Intrinsics.h(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.bundle);
        output.y(serialDesc, 1, self.ver);
        output.y(serialDesc, 2, self.appId);
    }

    public final String component1() {
        return this.bundle;
    }

    public final String component2() {
        return this.ver;
    }

    public final String component3() {
        return this.appId;
    }

    public final b copy(String bundle, String ver, String appId) {
        Intrinsics.h(bundle, "bundle");
        Intrinsics.h(ver, "ver");
        Intrinsics.h(appId, "appId");
        return new b(bundle, ver, appId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.bundle, bVar.bundle) && Intrinsics.c(this.ver, bVar.ver) && Intrinsics.c(this.appId, bVar.appId);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final String getVer() {
        return this.ver;
    }

    public int hashCode() {
        return (((this.bundle.hashCode() * 31) + this.ver.hashCode()) * 31) + this.appId.hashCode();
    }

    public String toString() {
        return "AppNode(bundle=" + this.bundle + ", ver=" + this.ver + ", appId=" + this.appId + ')';
    }
}
