package ob;

import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rb.o;

/* loaded from: classes5.dex */
public final class e implements bd.f {

    /* renamed from: a, reason: collision with root package name */
    private final o f71072a;

    public e(o userMetadata) {
        Intrinsics.h(userMetadata, "userMetadata");
        this.f71072a = userMetadata;
    }

    @Override // bd.f
    public void a(bd.e rolloutsState) {
        Intrinsics.h(rolloutsState, "rolloutsState");
        o oVar = this.f71072a;
        Set b11 = rolloutsState.b();
        Intrinsics.g(b11, "rolloutsState.rolloutAssignments");
        Set<bd.d> set = b11;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(set, 10));
        for (bd.d dVar : set) {
            arrayList.add(rb.i.b(dVar.d(), dVar.b(), dVar.c(), dVar.f(), dVar.e()));
        }
        oVar.t(arrayList);
        g.f().b("Updated Crashlytics Rollout State");
    }
}
