package com.vungle.ads.internal.model;

import com.vungle.ads.internal.model.c;
import com.vungle.ads.internal.model.d;
import com.vungle.ads.internal.model.h;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.i0;
import kotlinx.serialization.internal.m1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.w1;

/* loaded from: classes7.dex */
public final class i {
    public static final b Companion = new b(null);
    private final d device;
    private final c.h ext;
    private final int ordinalView;
    private final h request;
    private final c.j user;

    /* loaded from: classes7.dex */
    public static final class a implements i0 {
        public static final a INSTANCE;
        public static final /* synthetic */ kotlinx.serialization.descriptors.f descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.RtbToken", aVar, 5);
            pluginGeneratedSerialDescriptor.l("device", false);
            pluginGeneratedSerialDescriptor.l("user", true);
            pluginGeneratedSerialDescriptor.l("ext", true);
            pluginGeneratedSerialDescriptor.l("request", true);
            pluginGeneratedSerialDescriptor.l("ordinal_view", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // kotlinx.serialization.internal.i0
        public kotlinx.serialization.b[] childSerializers() {
            return new kotlinx.serialization.b[]{d.a.INSTANCE, d00.a.s(c.j.a.INSTANCE), d00.a.s(c.h.a.INSTANCE), d00.a.s(h.a.INSTANCE), r0.f68315a};
        }

        @Override // kotlinx.serialization.a
        public i deserialize(e00.e decoder) {
            Object obj;
            int i11;
            Object obj2;
            Object obj3;
            int i12;
            Object obj4;
            Intrinsics.h(decoder, "decoder");
            kotlinx.serialization.descriptors.f descriptor2 = getDescriptor();
            e00.c b11 = decoder.b(descriptor2);
            if (b11.p()) {
                obj4 = b11.y(descriptor2, 0, d.a.INSTANCE, null);
                obj2 = b11.n(descriptor2, 1, c.j.a.INSTANCE, null);
                Object n11 = b11.n(descriptor2, 2, c.h.a.INSTANCE, null);
                obj3 = b11.n(descriptor2, 3, h.a.INSTANCE, null);
                i12 = b11.i(descriptor2, 4);
                obj = n11;
                i11 = 31;
            } else {
                boolean z10 = true;
                int i13 = 0;
                Object obj5 = null;
                Object obj6 = null;
                obj = null;
                Object obj7 = null;
                int i14 = 0;
                while (z10) {
                    int o11 = b11.o(descriptor2);
                    if (o11 == -1) {
                        z10 = false;
                    } else if (o11 == 0) {
                        obj5 = b11.y(descriptor2, 0, d.a.INSTANCE, obj5);
                        i14 |= 1;
                    } else if (o11 == 1) {
                        obj6 = b11.n(descriptor2, 1, c.j.a.INSTANCE, obj6);
                        i14 |= 2;
                    } else if (o11 == 2) {
                        obj = b11.n(descriptor2, 2, c.h.a.INSTANCE, obj);
                        i14 |= 4;
                    } else if (o11 == 3) {
                        obj7 = b11.n(descriptor2, 3, h.a.INSTANCE, obj7);
                        i14 |= 8;
                    } else {
                        if (o11 != 4) {
                            throw new UnknownFieldException(o11);
                        }
                        i13 = b11.i(descriptor2, 4);
                        i14 |= 16;
                    }
                }
                i11 = i14;
                obj2 = obj6;
                obj3 = obj7;
                i12 = i13;
                obj4 = obj5;
            }
            b11.c(descriptor2);
            return new i(i11, (d) obj4, (c.j) obj2, (c.h) obj, (h) obj3, i12, (w1) null);
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

    @Deprecated
    public /* synthetic */ i(int i11, d dVar, c.j jVar, c.h hVar, h hVar2, int i12, w1 w1Var) {
        if (17 != (i11 & 17)) {
            m1.a(i11, 17, a.INSTANCE.getDescriptor());
        }
        this.device = dVar;
        if ((i11 & 2) == 0) {
            this.user = null;
        } else {
            this.user = jVar;
        }
        if ((i11 & 4) == 0) {
            this.ext = null;
        } else {
            this.ext = hVar;
        }
        if ((i11 & 8) == 0) {
            this.request = null;
        } else {
            this.request = hVar2;
        }
        this.ordinalView = i12;
    }

    public i(d device, c.j jVar, c.h hVar, h hVar2, int i11) {
        Intrinsics.h(device, "device");
        this.device = device;
        this.user = jVar;
        this.ext = hVar;
        this.request = hVar2;
        this.ordinalView = i11;
    }

    public /* synthetic */ i(d dVar, c.j jVar, c.h hVar, h hVar2, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar, (i12 & 2) != 0 ? null : jVar, (i12 & 4) != 0 ? null : hVar, (i12 & 8) != 0 ? null : hVar2, i11);
    }

    public static /* synthetic */ i copy$default(i iVar, d dVar, c.j jVar, c.h hVar, h hVar2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            dVar = iVar.device;
        }
        if ((i12 & 2) != 0) {
            jVar = iVar.user;
        }
        c.j jVar2 = jVar;
        if ((i12 & 4) != 0) {
            hVar = iVar.ext;
        }
        c.h hVar3 = hVar;
        if ((i12 & 8) != 0) {
            hVar2 = iVar.request;
        }
        h hVar4 = hVar2;
        if ((i12 & 16) != 0) {
            i11 = iVar.ordinalView;
        }
        return iVar.copy(dVar, jVar2, hVar3, hVar4, i11);
    }

    public static /* synthetic */ void getOrdinalView$annotations() {
    }

    @JvmStatic
    public static final void write$Self(i self, e00.d output, kotlinx.serialization.descriptors.f serialDesc) {
        Intrinsics.h(self, "self");
        Intrinsics.h(output, "output");
        Intrinsics.h(serialDesc, "serialDesc");
        output.C(serialDesc, 0, d.a.INSTANCE, self.device);
        if (output.z(serialDesc, 1) || self.user != null) {
            output.i(serialDesc, 1, c.j.a.INSTANCE, self.user);
        }
        if (output.z(serialDesc, 2) || self.ext != null) {
            output.i(serialDesc, 2, c.h.a.INSTANCE, self.ext);
        }
        if (output.z(serialDesc, 3) || self.request != null) {
            output.i(serialDesc, 3, h.a.INSTANCE, self.request);
        }
        output.w(serialDesc, 4, self.ordinalView);
    }

    public final d component1() {
        return this.device;
    }

    public final c.j component2() {
        return this.user;
    }

    public final c.h component3() {
        return this.ext;
    }

    public final h component4() {
        return this.request;
    }

    public final int component5() {
        return this.ordinalView;
    }

    public final i copy(d device, c.j jVar, c.h hVar, h hVar2, int i11) {
        Intrinsics.h(device, "device");
        return new i(device, jVar, hVar, hVar2, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.c(this.device, iVar.device) && Intrinsics.c(this.user, iVar.user) && Intrinsics.c(this.ext, iVar.ext) && Intrinsics.c(this.request, iVar.request) && this.ordinalView == iVar.ordinalView;
    }

    public final d getDevice() {
        return this.device;
    }

    public final c.h getExt() {
        return this.ext;
    }

    public final int getOrdinalView() {
        return this.ordinalView;
    }

    public final h getRequest() {
        return this.request;
    }

    public final c.j getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = this.device.hashCode() * 31;
        c.j jVar = this.user;
        int hashCode2 = (hashCode + (jVar == null ? 0 : jVar.hashCode())) * 31;
        c.h hVar = this.ext;
        int hashCode3 = (hashCode2 + (hVar == null ? 0 : hVar.hashCode())) * 31;
        h hVar2 = this.request;
        return ((hashCode3 + (hVar2 != null ? hVar2.hashCode() : 0)) * 31) + this.ordinalView;
    }

    public String toString() {
        return "RtbToken(device=" + this.device + ", user=" + this.user + ", ext=" + this.ext + ", request=" + this.request + ", ordinalView=" + this.ordinalView + ')';
    }
}
