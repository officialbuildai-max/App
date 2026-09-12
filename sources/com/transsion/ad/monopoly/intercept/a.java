package com.transsion.ad.monopoly.intercept;

import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private a f42198a;

    /* renamed from: com.transsion.ad.monopoly.intercept.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0597a {

        /* renamed from: a, reason: collision with root package name */
        private a f42199a;

        /* renamed from: b, reason: collision with root package name */
        private a f42200b;

        public final C0597a a(a aVar) {
            if (this.f42199a == null) {
                this.f42200b = aVar;
                this.f42199a = aVar;
                return this;
            }
            a aVar2 = this.f42200b;
            if (aVar2 != null) {
                aVar2.f(aVar);
            }
            this.f42200b = aVar;
            return this;
        }

        public final a b() {
            return this.f42199a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(a aVar) {
        this.f42198a = aVar;
    }

    public abstract Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation);

    public final a c() {
        return this.f42198a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String d() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AdPlansHitResponse e() {
        return new AdPlansHitResponse(true, "default");
    }
}
