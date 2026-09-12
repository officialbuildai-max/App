package com.vungle.ads.internal.model;

import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.i0;
import kotlinx.serialization.internal.w1;

/* loaded from: classes7.dex */
public final class f {
    public static final b Companion = new b(null);
    private final String params;
    private final String vendorKey;
    private final String vendorURL;

    /* loaded from: classes7.dex */
    public static final class a implements i0 {
        public static final a INSTANCE;
        public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.OmSdkData", aVar, 3);
            pluginGeneratedSerialDescriptor.l("params", true);
            pluginGeneratedSerialDescriptor.l("vendorKey", true);
            pluginGeneratedSerialDescriptor.l("vendorURL", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // kotlinx.serialization.internal.i0
        public kotlinx.serialization.b[] childSerializers() {
            b2 b2Var = b2.f68235a;
            return new kotlinx.serialization.b[]{d00.a.s(b2Var), d00.a.s(b2Var), d00.a.s(b2Var)};
        }

        @Override // kotlinx.serialization.a
        public f deserialize(e00.e decoder) {
            Object obj;
            int i11;
            Object obj2;
            Object obj3;
            Intrinsics.h(decoder, "decoder");
            kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
            e00.c b11 = decoder.b(descriptor2);
            Object obj4 = null;
            if (b11.p()) {
                b2 b2Var = b2.f68235a;
                obj2 = b11.n(descriptor2, 0, b2Var, null);
                Object n11 = b11.n(descriptor2, 1, b2Var, null);
                obj3 = b11.n(descriptor2, 2, b2Var, null);
                obj = n11;
                i11 = 7;
            } else {
                boolean z10 = true;
                int i12 = 0;
                obj = null;
                Object obj5 = null;
                while (z10) {
                    int o11 = b11.o(descriptor2);
                    if (o11 == -1) {
                        z10 = false;
                    } else if (o11 == 0) {
                        obj4 = b11.n(descriptor2, 0, b2.f68235a, obj4);
                        i12 |= 1;
                    } else if (o11 == 1) {
                        obj = b11.n(descriptor2, 1, b2.f68235a, obj);
                        i12 |= 2;
                    } else {
                        if (o11 != 2) {
                            throw new UnknownFieldException(o11);
                        }
                        obj5 = b11.n(descriptor2, 2, b2.f68235a, obj5);
                        i12 |= 4;
                    }
                }
                i11 = i12;
                obj2 = obj4;
                obj3 = obj5;
            }
            b11.c(descriptor2);
            return new f(i11, (String) obj2, (String) obj, (String) obj3, (w1) null);
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
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    @Deprecated
    public /* synthetic */ f(int i11, String str, String str2, String str3, w1 w1Var) {
        if ((i11 & 1) == 0) {
            this.params = null;
        } else {
            this.params = str;
        }
        if ((i11 & 2) == 0) {
            this.vendorKey = null;
        } else {
            this.vendorKey = str2;
        }
        if ((i11 & 4) == 0) {
            this.vendorURL = null;
        } else {
            this.vendorURL = str3;
        }
    }

    public f(String str, String str2, String str3) {
        this.params = str;
        this.vendorKey = str2;
        this.vendorURL = str3;
    }

    public /* synthetic */ f(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }

    public static /* synthetic */ f copy$default(f fVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = fVar.params;
        }
        if ((i11 & 2) != 0) {
            str2 = fVar.vendorKey;
        }
        if ((i11 & 4) != 0) {
            str3 = fVar.vendorURL;
        }
        return fVar.copy(str, str2, str3);
    }

    @JvmStatic
    public static final void write$Self(f self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
        Intrinsics.h(self, "self");
        Intrinsics.h(output, "output");
        Intrinsics.h(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self.params != null) {
            output.i(serialDesc, 0, b2.f68235a, self.params);
        }
        if (output.z(serialDesc, 1) || self.vendorKey != null) {
            output.i(serialDesc, 1, b2.f68235a, self.vendorKey);
        }
        if (!output.z(serialDesc, 2) && self.vendorURL == null) {
            return;
        }
        output.i(serialDesc, 2, b2.f68235a, self.vendorURL);
    }

    public final String component1() {
        return this.params;
    }

    public final String component2() {
        return this.vendorKey;
    }

    public final String component3() {
        return this.vendorURL;
    }

    public final f copy(String str, String str2, String str3) {
        return new f(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.c(this.params, fVar.params) && Intrinsics.c(this.vendorKey, fVar.vendorKey) && Intrinsics.c(this.vendorURL, fVar.vendorURL);
    }

    public final String getParams() {
        return this.params;
    }

    public final String getVendorKey() {
        return this.vendorKey;
    }

    public final String getVendorURL() {
        return this.vendorURL;
    }

    public int hashCode() {
        String str = this.params;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.vendorKey;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.vendorURL;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "OmSdkData(params=" + this.params + ", vendorKey=" + this.vendorKey + ", vendorURL=" + this.vendorURL + ')';
    }
}
