package com.vungle.ads.internal.signals;

import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.transsion.mpush.api.LocalPushMessage;
import com.vungle.ads.internal.model.j;
import com.vungle.ads.internal.signals.b;
import e00.c;
import e00.d;
import e00.e;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.b1;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.i0;
import kotlinx.serialization.internal.m1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.w1;

/* loaded from: classes7.dex */
public final class a {
    public static final b Companion = new b(null);
    private final int sessionCount;
    private long sessionCreationTime;
    private int sessionDepthCounter;
    private long sessionDuration;
    private final String sessionId;
    private List<com.vungle.ads.internal.signals.b> signaledAd;
    private List<j> unclosedAd;

    /* renamed from: com.vungle.ads.internal.signals.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0740a implements i0 {
        public static final C0740a INSTANCE;
        public static final /* synthetic */ f descriptor;

        static {
            C0740a c0740a = new C0740a();
            INSTANCE = c0740a;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.signals.SessionData", c0740a, 7);
            pluginGeneratedSerialDescriptor.l("103", false);
            pluginGeneratedSerialDescriptor.l("101", true);
            pluginGeneratedSerialDescriptor.l(StatisticData.ERROR_CODE_NOT_FOUND, true);
            pluginGeneratedSerialDescriptor.l("106", true);
            pluginGeneratedSerialDescriptor.l(LocalPushMessage.STYLE_VERTICAL_TYPE, true);
            pluginGeneratedSerialDescriptor.l("104", true);
            pluginGeneratedSerialDescriptor.l("105", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private C0740a() {
        }

        @Override // kotlinx.serialization.internal.i0
        public kotlinx.serialization.b[] childSerializers() {
            kotlinx.serialization.internal.f fVar = new kotlinx.serialization.internal.f(b.a.INSTANCE);
            kotlinx.serialization.internal.f fVar2 = new kotlinx.serialization.internal.f(j.a.INSTANCE);
            r0 r0Var = r0.f68315a;
            b1 b1Var = b1.f68233a;
            return new kotlinx.serialization.b[]{r0Var, b2.f68235a, b1Var, fVar, b1Var, r0Var, fVar2};
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0069. Please report as an issue. */
        @Override // kotlinx.serialization.a
        public a deserialize(e decoder) {
            int i11;
            Object obj;
            int i12;
            long j11;
            int i13;
            String str;
            Object obj2;
            long j12;
            Intrinsics.h(decoder, "decoder");
            f descriptor2 = getDescriptor();
            c b11 = decoder.b(descriptor2);
            int i14 = 2;
            if (b11.p()) {
                int i15 = b11.i(descriptor2, 0);
                String m11 = b11.m(descriptor2, 1);
                long f11 = b11.f(descriptor2, 2);
                obj2 = b11.y(descriptor2, 3, new kotlinx.serialization.internal.f(b.a.INSTANCE), null);
                long f12 = b11.f(descriptor2, 4);
                int i16 = b11.i(descriptor2, 5);
                obj = b11.y(descriptor2, 6, new kotlinx.serialization.internal.f(j.a.INSTANCE), null);
                i11 = i15;
                i12 = i16;
                j11 = f12;
                str = m11;
                i13 = 127;
                j12 = f11;
            } else {
                long j13 = 0;
                boolean z10 = true;
                int i17 = 0;
                int i18 = 0;
                String str2 = null;
                Object obj3 = null;
                long j14 = 0;
                Object obj4 = null;
                int i19 = 0;
                while (z10) {
                    int o11 = b11.o(descriptor2);
                    switch (o11) {
                        case -1:
                            z10 = false;
                        case 0:
                            i18 |= 1;
                            i17 = b11.i(descriptor2, 0);
                        case 1:
                            str2 = b11.m(descriptor2, 1);
                            i18 |= 2;
                        case 2:
                            j14 = b11.f(descriptor2, i14);
                            i18 |= 4;
                        case 3:
                            obj3 = b11.y(descriptor2, 3, new kotlinx.serialization.internal.f(b.a.INSTANCE), obj3);
                            i18 |= 8;
                            i14 = 2;
                        case 4:
                            j13 = b11.f(descriptor2, 4);
                            i18 |= 16;
                            i14 = 2;
                        case 5:
                            i19 = b11.i(descriptor2, 5);
                            i18 |= 32;
                            i14 = 2;
                        case 6:
                            obj4 = b11.y(descriptor2, 6, new kotlinx.serialization.internal.f(j.a.INSTANCE), obj4);
                            i18 |= 64;
                            i14 = 2;
                        default:
                            throw new UnknownFieldException(o11);
                    }
                }
                i11 = i17;
                obj = obj4;
                i12 = i19;
                j11 = j13;
                i13 = i18;
                str = str2;
                obj2 = obj3;
                j12 = j14;
            }
            b11.c(descriptor2);
            return new a(i13, i11, str, j12, (List) obj2, j11, i12, (List) obj, null);
        }

        @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
        public f getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.g
        public void serialize(e00.f encoder, a value) {
            Intrinsics.h(encoder, "encoder");
            Intrinsics.h(value, "value");
            f descriptor2 = getDescriptor();
            d b11 = encoder.b(descriptor2);
            a.write$Self(value, b11, descriptor2);
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
            return C0740a.INSTANCE;
        }
    }

    public a(int i11) {
        this.sessionCount = i11;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "randomUUID().toString()");
        this.sessionId = uuid;
        this.sessionCreationTime = System.currentTimeMillis() / 1000;
        this.signaledAd = new ArrayList();
        this.unclosedAd = new ArrayList();
    }

    @Deprecated
    public /* synthetic */ a(int i11, int i12, String str, long j11, List list, long j12, int i13, List list2, w1 w1Var) {
        if (1 != (i11 & 1)) {
            m1.a(i11, 1, C0740a.INSTANCE.getDescriptor());
        }
        this.sessionCount = i12;
        if ((i11 & 2) == 0) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.g(uuid, "randomUUID().toString()");
            this.sessionId = uuid;
        } else {
            this.sessionId = str;
        }
        if ((i11 & 4) == 0) {
            this.sessionCreationTime = System.currentTimeMillis() / 1000;
        } else {
            this.sessionCreationTime = j11;
        }
        if ((i11 & 8) == 0) {
            this.signaledAd = new ArrayList();
        } else {
            this.signaledAd = list;
        }
        if ((i11 & 16) == 0) {
            this.sessionDuration = 0L;
        } else {
            this.sessionDuration = j12;
        }
        if ((i11 & 32) == 0) {
            this.sessionDepthCounter = 0;
        } else {
            this.sessionDepthCounter = i13;
        }
        if ((i11 & 64) == 0) {
            this.unclosedAd = new ArrayList();
        } else {
            this.unclosedAd = list2;
        }
    }

    public static /* synthetic */ a copy$default(a aVar, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = aVar.sessionCount;
        }
        return aVar.copy(i11);
    }

    public static /* synthetic */ void getSessionCount$annotations() {
    }

    public static /* synthetic */ void getSessionCreationTime$annotations() {
    }

    public static /* synthetic */ void getSessionDepthCounter$annotations() {
    }

    public static /* synthetic */ void getSessionDuration$annotations() {
    }

    public static /* synthetic */ void getSessionId$annotations() {
    }

    public static /* synthetic */ void getSignaledAd$annotations() {
    }

    public static /* synthetic */ void getUnclosedAd$annotations() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0030, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r1, r2) == false) goto L7;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void write$Self(com.vungle.ads.internal.signals.a r7, e00.d r8, kotlinx.serialization.descriptors.f r9) {
        /*
            java.lang.String r0 = "self"
            kotlin.jvm.internal.Intrinsics.h(r7, r0)
            java.lang.String r0 = "output"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            java.lang.String r0 = "serialDesc"
            kotlin.jvm.internal.Intrinsics.h(r9, r0)
            int r0 = r7.sessionCount
            r1 = 0
            r8.w(r9, r1, r0)
            r0 = 1
            boolean r1 = r8.z(r9, r0)
            if (r1 == 0) goto L1d
            goto L32
        L1d:
            java.lang.String r1 = r7.sessionId
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.g(r2, r3)
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r2)
            if (r1 != 0) goto L37
        L32:
            java.lang.String r1 = r7.sessionId
            r8.y(r9, r0, r1)
        L37:
            r0 = 2
            boolean r1 = r8.z(r9, r0)
            if (r1 == 0) goto L3f
            goto L4c
        L3f:
            long r1 = r7.sessionCreationTime
            long r3 = java.lang.System.currentTimeMillis()
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L51
        L4c:
            long r1 = r7.sessionCreationTime
            r8.F(r9, r0, r1)
        L51:
            r0 = 3
            boolean r1 = r8.z(r9, r0)
            if (r1 == 0) goto L59
            goto L66
        L59:
            java.util.List<com.vungle.ads.internal.signals.b> r1 = r7.signaledAd
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r2)
            if (r1 != 0) goto L72
        L66:
            kotlinx.serialization.internal.f r1 = new kotlinx.serialization.internal.f
            com.vungle.ads.internal.signals.b$a r2 = com.vungle.ads.internal.signals.b.a.INSTANCE
            r1.<init>(r2)
            java.util.List<com.vungle.ads.internal.signals.b> r2 = r7.signaledAd
            r8.C(r9, r0, r1, r2)
        L72:
            r0 = 4
            boolean r1 = r8.z(r9, r0)
            if (r1 == 0) goto L7a
            goto L82
        L7a:
            long r1 = r7.sessionDuration
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L87
        L82:
            long r1 = r7.sessionDuration
            r8.F(r9, r0, r1)
        L87:
            r0 = 5
            boolean r1 = r8.z(r9, r0)
            if (r1 == 0) goto L8f
            goto L93
        L8f:
            int r1 = r7.sessionDepthCounter
            if (r1 == 0) goto L98
        L93:
            int r1 = r7.sessionDepthCounter
            r8.w(r9, r0, r1)
        L98:
            r0 = 6
            boolean r1 = r8.z(r9, r0)
            if (r1 == 0) goto La0
            goto Lad
        La0:
            java.util.List<com.vungle.ads.internal.model.j> r1 = r7.unclosedAd
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r2)
            if (r1 != 0) goto Lb9
        Lad:
            kotlinx.serialization.internal.f r1 = new kotlinx.serialization.internal.f
            com.vungle.ads.internal.model.j$a r2 = com.vungle.ads.internal.model.j.a.INSTANCE
            r1.<init>(r2)
            java.util.List<com.vungle.ads.internal.model.j> r7 = r7.unclosedAd
            r8.C(r9, r0, r1, r7)
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.signals.a.write$Self(com.vungle.ads.internal.signals.a, e00.d, kotlinx.serialization.descriptors.f):void");
    }

    public final int component1() {
        return this.sessionCount;
    }

    public final a copy(int i11) {
        return new a(i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.sessionCount == ((a) obj).sessionCount;
    }

    public final int getSessionCount() {
        return this.sessionCount;
    }

    public final long getSessionCreationTime() {
        return this.sessionCreationTime;
    }

    public final int getSessionDepthCounter() {
        return this.sessionDepthCounter;
    }

    public final long getSessionDuration() {
        return this.sessionDuration;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final List<com.vungle.ads.internal.signals.b> getSignaledAd() {
        return this.signaledAd;
    }

    public final List<j> getUnclosedAd() {
        return this.unclosedAd;
    }

    public int hashCode() {
        return this.sessionCount;
    }

    public final void setSessionCreationTime(long j11) {
        this.sessionCreationTime = j11;
    }

    public final void setSessionDepthCounter(int i11) {
        this.sessionDepthCounter = i11;
    }

    public final void setSessionDuration(long j11) {
        this.sessionDuration = j11;
    }

    public final void setSignaledAd(List<com.vungle.ads.internal.signals.b> list) {
        Intrinsics.h(list, "<set-?>");
        this.signaledAd = list;
    }

    public final void setUnclosedAd(List<j> list) {
        Intrinsics.h(list, "<set-?>");
        this.unclosedAd = list;
    }

    public String toString() {
        return "SessionData(sessionCount=" + this.sessionCount + ')';
    }
}
