package zm;

import com.transsion.memberapi.MemberTaskRewardInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final int f79555a;

    /* renamed from: b, reason: collision with root package name */
    private final String f79556b;

    /* renamed from: c, reason: collision with root package name */
    private final int f79557c;

    /* renamed from: d, reason: collision with root package name */
    private final int f79558d;

    /* renamed from: e, reason: collision with root package name */
    private final MemberTaskRewardInfo f79559e;

    public d(int i11, String rewardId, int i12, int i13, MemberTaskRewardInfo memberTaskRewardInfo) {
        Intrinsics.h(rewardId, "rewardId");
        this.f79555a = i11;
        this.f79556b = rewardId;
        this.f79557c = i12;
        this.f79558d = i13;
        this.f79559e = memberTaskRewardInfo;
    }

    public final int a() {
        return this.f79555a;
    }

    public final MemberTaskRewardInfo b() {
        return this.f79559e;
    }

    public final int c() {
        return this.f79557c;
    }

    public final String d() {
        return this.f79556b;
    }

    public final int e() {
        return this.f79558d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f79555a == dVar.f79555a && Intrinsics.c(this.f79556b, dVar.f79556b) && this.f79557c == dVar.f79557c && this.f79558d == dVar.f79558d && Intrinsics.c(this.f79559e, dVar.f79559e);
    }

    public int hashCode() {
        int hashCode = ((((((this.f79555a * 31) + this.f79556b.hashCode()) * 31) + this.f79557c) * 31) + this.f79558d) * 31;
        MemberTaskRewardInfo memberTaskRewardInfo = this.f79559e;
        return hashCode + (memberTaskRewardInfo == null ? 0 : memberTaskRewardInfo.hashCode());
    }

    public String toString() {
        return "MemberTaskRewardData(index=" + this.f79555a + ", rewardId=" + this.f79556b + ", rewardAmount=" + this.f79557c + ", rewardType=" + this.f79558d + ", info=" + this.f79559e + ")";
    }
}
