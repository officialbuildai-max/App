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
import kotlinx.serialization.internal.i0;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.w1;

/* loaded from: classes7.dex */
public final class e {
    public static final b Companion = new b(null);
    private List<String> friends;
    private Float healthPercentile;
    private Float inGamePurchasesUSD;
    private Float levelPercentile;
    private String page;
    private Integer sessionDuration;
    private Integer sessionStartTime;
    private Integer signupDate;
    private Integer timeSpent;
    private String userID;
    private Float userLevelPercentile;
    private Float userScorePercentile;

    /* loaded from: classes7.dex */
    public static final class a implements i0 {
        public static final a INSTANCE;
        public static final /* synthetic */ f descriptor;

        static {
            a aVar = new a();
            INSTANCE = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.SessionContext", aVar, 12);
            pluginGeneratedSerialDescriptor.l("level_percentile", true);
            pluginGeneratedSerialDescriptor.l("page", true);
            pluginGeneratedSerialDescriptor.l("time_spent", true);
            pluginGeneratedSerialDescriptor.l("signup_date", true);
            pluginGeneratedSerialDescriptor.l("user_score_percentile", true);
            pluginGeneratedSerialDescriptor.l("user_id", true);
            pluginGeneratedSerialDescriptor.l("friends", true);
            pluginGeneratedSerialDescriptor.l("user_level_percentile", true);
            pluginGeneratedSerialDescriptor.l("health_percentile", true);
            pluginGeneratedSerialDescriptor.l("session_start_time", true);
            pluginGeneratedSerialDescriptor.l("session_duration", true);
            pluginGeneratedSerialDescriptor.l("in_game_purchases_usd", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // kotlinx.serialization.internal.i0
        public kotlinx.serialization.b[] childSerializers() {
            h0 h0Var = h0.f68269a;
            kotlinx.serialization.b s11 = d00.a.s(h0Var);
            b2 b2Var = b2.f68235a;
            kotlinx.serialization.b s12 = d00.a.s(b2Var);
            r0 r0Var = r0.f68315a;
            return new kotlinx.serialization.b[]{s11, s12, d00.a.s(r0Var), d00.a.s(r0Var), d00.a.s(h0Var), d00.a.s(b2Var), d00.a.s(new kotlinx.serialization.internal.f(b2Var)), d00.a.s(h0Var), d00.a.s(h0Var), d00.a.s(r0Var), d00.a.s(r0Var), d00.a.s(h0Var)};
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:10:0x007f. Please report as an issue. */
        @Override // kotlinx.serialization.a
        public e deserialize(e00.e decoder) {
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            int i11;
            Object obj5;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            Object obj10;
            Object obj11;
            Object obj12;
            Object obj13;
            Intrinsics.h(decoder, "decoder");
            f descriptor2 = getDescriptor();
            e00.c b11 = decoder.b(descriptor2);
            Object obj14 = null;
            if (b11.p()) {
                h0 h0Var = h0.f68269a;
                obj7 = b11.n(descriptor2, 0, h0Var, null);
                b2 b2Var = b2.f68235a;
                Object n11 = b11.n(descriptor2, 1, b2Var, null);
                r0 r0Var = r0.f68315a;
                obj11 = b11.n(descriptor2, 2, r0Var, null);
                obj6 = b11.n(descriptor2, 3, r0Var, null);
                Object n12 = b11.n(descriptor2, 4, h0Var, null);
                obj10 = b11.n(descriptor2, 5, b2Var, null);
                obj5 = b11.n(descriptor2, 6, new kotlinx.serialization.internal.f(b2Var), null);
                obj12 = b11.n(descriptor2, 7, h0Var, null);
                obj9 = b11.n(descriptor2, 8, h0Var, null);
                obj = b11.n(descriptor2, 9, r0Var, null);
                obj8 = b11.n(descriptor2, 10, r0Var, null);
                obj4 = b11.n(descriptor2, 11, h0Var, null);
                obj3 = n11;
                obj2 = n12;
                i11 = 4095;
            } else {
                boolean z10 = true;
                int i12 = 0;
                Object obj15 = null;
                Object obj16 = null;
                Object obj17 = null;
                obj = null;
                Object obj18 = null;
                Object obj19 = null;
                Object obj20 = null;
                Object obj21 = null;
                Object obj22 = null;
                obj2 = null;
                Object obj23 = null;
                while (z10) {
                    int o11 = b11.o(descriptor2);
                    switch (o11) {
                        case -1:
                            z10 = false;
                            obj14 = obj14;
                            obj15 = obj15;
                        case 0:
                            i12 |= 1;
                            obj14 = b11.n(descriptor2, 0, h0.f68269a, obj14);
                            obj15 = obj15;
                        case 1:
                            obj13 = obj14;
                            obj15 = b11.n(descriptor2, 1, b2.f68235a, obj15);
                            i12 |= 2;
                            obj14 = obj13;
                        case 2:
                            obj13 = obj14;
                            obj16 = b11.n(descriptor2, 2, r0.f68315a, obj16);
                            i12 |= 4;
                            obj14 = obj13;
                        case 3:
                            obj13 = obj14;
                            obj23 = b11.n(descriptor2, 3, r0.f68315a, obj23);
                            i12 |= 8;
                            obj14 = obj13;
                        case 4:
                            obj13 = obj14;
                            obj2 = b11.n(descriptor2, 4, h0.f68269a, obj2);
                            i12 |= 16;
                            obj14 = obj13;
                        case 5:
                            obj13 = obj14;
                            obj22 = b11.n(descriptor2, 5, b2.f68235a, obj22);
                            i12 |= 32;
                            obj14 = obj13;
                        case 6:
                            obj13 = obj14;
                            obj19 = b11.n(descriptor2, 6, new kotlinx.serialization.internal.f(b2.f68235a), obj19);
                            i12 |= 64;
                            obj14 = obj13;
                        case 7:
                            obj13 = obj14;
                            obj21 = b11.n(descriptor2, 7, h0.f68269a, obj21);
                            i12 |= 128;
                            obj14 = obj13;
                        case 8:
                            obj13 = obj14;
                            obj18 = b11.n(descriptor2, 8, h0.f68269a, obj18);
                            i12 |= 256;
                            obj14 = obj13;
                        case 9:
                            obj13 = obj14;
                            obj = b11.n(descriptor2, 9, r0.f68315a, obj);
                            i12 |= 512;
                            obj14 = obj13;
                        case 10:
                            obj13 = obj14;
                            obj17 = b11.n(descriptor2, 10, r0.f68315a, obj17);
                            i12 |= 1024;
                            obj14 = obj13;
                        case 11:
                            obj20 = b11.n(descriptor2, 11, h0.f68269a, obj20);
                            i12 |= 2048;
                            obj14 = obj14;
                        default:
                            throw new UnknownFieldException(o11);
                    }
                }
                obj3 = obj15;
                obj4 = obj20;
                Object obj24 = obj21;
                i11 = i12;
                obj5 = obj19;
                obj6 = obj23;
                obj7 = obj14;
                obj8 = obj17;
                obj9 = obj18;
                obj10 = obj22;
                obj11 = obj16;
                obj12 = obj24;
            }
            b11.c(descriptor2);
            return new e(i11, (Float) obj7, (String) obj3, (Integer) obj11, (Integer) obj6, (Float) obj2, (String) obj10, (List) obj5, (Float) obj12, (Float) obj9, (Integer) obj, (Integer) obj8, (Float) obj4, null);
        }

        @Override // kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
        public f getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.g
        public void serialize(e00.f encoder, e value) {
            Intrinsics.h(encoder, "encoder");
            Intrinsics.h(value, "value");
            f descriptor2 = getDescriptor();
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

    public e() {
    }

    @Deprecated
    public /* synthetic */ e(int i11, Float f11, String str, Integer num, Integer num2, Float f12, String str2, List list, Float f13, Float f14, Integer num3, Integer num4, Float f15, w1 w1Var) {
        if ((i11 & 1) == 0) {
            this.levelPercentile = null;
        } else {
            this.levelPercentile = f11;
        }
        if ((i11 & 2) == 0) {
            this.page = null;
        } else {
            this.page = str;
        }
        if ((i11 & 4) == 0) {
            this.timeSpent = null;
        } else {
            this.timeSpent = num;
        }
        if ((i11 & 8) == 0) {
            this.signupDate = null;
        } else {
            this.signupDate = num2;
        }
        if ((i11 & 16) == 0) {
            this.userScorePercentile = null;
        } else {
            this.userScorePercentile = f12;
        }
        if ((i11 & 32) == 0) {
            this.userID = null;
        } else {
            this.userID = str2;
        }
        if ((i11 & 64) == 0) {
            this.friends = null;
        } else {
            this.friends = list;
        }
        if ((i11 & 128) == 0) {
            this.userLevelPercentile = null;
        } else {
            this.userLevelPercentile = f13;
        }
        if ((i11 & 256) == 0) {
            this.healthPercentile = null;
        } else {
            this.healthPercentile = f14;
        }
        if ((i11 & 512) == 0) {
            this.sessionStartTime = null;
        } else {
            this.sessionStartTime = num3;
        }
        if ((i11 & 1024) == 0) {
            this.sessionDuration = null;
        } else {
            this.sessionDuration = num4;
        }
        if ((i11 & 2048) == 0) {
            this.inGamePurchasesUSD = null;
        } else {
            this.inGamePurchasesUSD = f15;
        }
    }

    private static /* synthetic */ void getFriends$annotations() {
    }

    private static /* synthetic */ void getHealthPercentile$annotations() {
    }

    private static /* synthetic */ void getInGamePurchasesUSD$annotations() {
    }

    private static /* synthetic */ void getLevelPercentile$annotations() {
    }

    private static /* synthetic */ void getPage$annotations() {
    }

    private static /* synthetic */ void getSessionDuration$annotations() {
    }

    private static /* synthetic */ void getSessionStartTime$annotations() {
    }

    private static /* synthetic */ void getSignupDate$annotations() {
    }

    private static /* synthetic */ void getTimeSpent$annotations() {
    }

    private static /* synthetic */ void getUserID$annotations() {
    }

    private static /* synthetic */ void getUserLevelPercentile$annotations() {
    }

    private static /* synthetic */ void getUserScorePercentile$annotations() {
    }

    @JvmStatic
    public static final void write$Self(e self, e00.d output, f serialDesc) {
        Intrinsics.h(self, "self");
        Intrinsics.h(output, "output");
        Intrinsics.h(serialDesc, "serialDesc");
        if (output.z(serialDesc, 0) || self.levelPercentile != null) {
            output.i(serialDesc, 0, h0.f68269a, self.levelPercentile);
        }
        if (output.z(serialDesc, 1) || self.page != null) {
            output.i(serialDesc, 1, b2.f68235a, self.page);
        }
        if (output.z(serialDesc, 2) || self.timeSpent != null) {
            output.i(serialDesc, 2, r0.f68315a, self.timeSpent);
        }
        if (output.z(serialDesc, 3) || self.signupDate != null) {
            output.i(serialDesc, 3, r0.f68315a, self.signupDate);
        }
        if (output.z(serialDesc, 4) || self.userScorePercentile != null) {
            output.i(serialDesc, 4, h0.f68269a, self.userScorePercentile);
        }
        if (output.z(serialDesc, 5) || self.userID != null) {
            output.i(serialDesc, 5, b2.f68235a, self.userID);
        }
        if (output.z(serialDesc, 6) || self.friends != null) {
            output.i(serialDesc, 6, new kotlinx.serialization.internal.f(b2.f68235a), self.friends);
        }
        if (output.z(serialDesc, 7) || self.userLevelPercentile != null) {
            output.i(serialDesc, 7, h0.f68269a, self.userLevelPercentile);
        }
        if (output.z(serialDesc, 8) || self.healthPercentile != null) {
            output.i(serialDesc, 8, h0.f68269a, self.healthPercentile);
        }
        if (output.z(serialDesc, 9) || self.sessionStartTime != null) {
            output.i(serialDesc, 9, r0.f68315a, self.sessionStartTime);
        }
        if (output.z(serialDesc, 10) || self.sessionDuration != null) {
            output.i(serialDesc, 10, r0.f68315a, self.sessionDuration);
        }
        if (!output.z(serialDesc, 11) && self.inGamePurchasesUSD == null) {
            return;
        }
        output.i(serialDesc, 11, h0.f68269a, self.inGamePurchasesUSD);
    }

    public final e setFriends(List<String> list) {
        this.friends = list != null ? CollectionsKt.U0(list) : null;
        return this;
    }

    public final e setHealthPercentile(float f11) {
        if (q.INSTANCE.isInRange(f11, 0.0f, 100.0f)) {
            this.healthPercentile = Float.valueOf(f11);
        }
        return this;
    }

    public final e setInGamePurchasesUSD(float f11) {
        if (q.isInRange$default(q.INSTANCE, f11, 0.0f, 0.0f, 4, (Object) null)) {
            this.inGamePurchasesUSD = Float.valueOf(f11);
        }
        return this;
    }

    public final e setLevelPercentile(float f11) {
        if (q.INSTANCE.isInRange(f11, 0.0f, 100.0f)) {
            this.levelPercentile = Float.valueOf(f11);
        }
        return this;
    }

    public final e setPage(String page) {
        Intrinsics.h(page, "page");
        this.page = page;
        return this;
    }

    public final e setSessionDuration(int i11) {
        this.sessionDuration = Integer.valueOf(i11);
        return this;
    }

    public final e setSessionStartTime(int i11) {
        this.sessionStartTime = Integer.valueOf(i11);
        return this;
    }

    public final e setSignupDate(int i11) {
        this.signupDate = Integer.valueOf(i11);
        return this;
    }

    public final e setTimeSpent(int i11) {
        this.timeSpent = Integer.valueOf(i11);
        return this;
    }

    public final e setUserID(String userID) {
        Intrinsics.h(userID, "userID");
        this.userID = userID;
        return this;
    }

    public final e setUserLevelPercentile(float f11) {
        if (q.INSTANCE.isInRange(f11, 0.0f, 100.0f)) {
            this.userLevelPercentile = Float.valueOf(f11);
        }
        return this;
    }

    public final e setUserScorePercentile(float f11) {
        if (q.INSTANCE.isInRange(f11, 0.0f, 100.0f)) {
            this.userScorePercentile = Float.valueOf(f11);
        }
        return this;
    }
}
