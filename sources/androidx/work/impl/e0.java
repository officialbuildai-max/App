package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes2.dex */
public class e0 extends androidx.work.h0 {

    /* renamed from: j, reason: collision with root package name */
    private static final String f15720j = androidx.work.t.i("WorkContinuationImpl");

    /* renamed from: a, reason: collision with root package name */
    private final f1 f15721a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15722b;

    /* renamed from: c, reason: collision with root package name */
    private final ExistingWorkPolicy f15723c;

    /* renamed from: d, reason: collision with root package name */
    private final List f15724d;

    /* renamed from: e, reason: collision with root package name */
    private final List f15725e;

    /* renamed from: f, reason: collision with root package name */
    private final List f15726f;

    /* renamed from: g, reason: collision with root package name */
    private final List f15727g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f15728h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.work.w f15729i;

    public e0(f1 f1Var, String str, ExistingWorkPolicy existingWorkPolicy, List list) {
        this(f1Var, str, existingWorkPolicy, list, null);
    }

    public e0(f1 f1Var, String str, ExistingWorkPolicy existingWorkPolicy, List list, List list2) {
        this.f15721a = f1Var;
        this.f15722b = str;
        this.f15723c = existingWorkPolicy;
        this.f15724d = list;
        this.f15727g = list2;
        this.f15725e = new ArrayList(list.size());
        this.f15726f = new ArrayList();
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                this.f15726f.addAll(((e0) it.next()).f15726f);
            }
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (existingWorkPolicy == ExistingWorkPolicy.REPLACE && ((androidx.work.i0) list.get(i11)).d().h() != Long.MAX_VALUE) {
                throw new IllegalArgumentException("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
            }
            String b11 = ((androidx.work.i0) list.get(i11)).b();
            this.f15725e.add(b11);
            this.f15726f.add(b11);
        }
    }

    public e0(f1 f1Var, List list) {
        this(f1Var, null, ExistingWorkPolicy.KEEP, list, null);
    }

    private static boolean j(e0 e0Var, Set set) {
        set.addAll(e0Var.d());
        Set n11 = n(e0Var);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (n11.contains((String) it.next())) {
                return true;
            }
        }
        List f11 = e0Var.f();
        if (f11 != null && !f11.isEmpty()) {
            Iterator it2 = f11.iterator();
            while (it2.hasNext()) {
                if (j((e0) it2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(e0Var.d());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit l() {
        androidx.work.impl.utils.f.b(this);
        return Unit.f67184a;
    }

    public static Set n(e0 e0Var) {
        HashSet hashSet = new HashSet();
        List f11 = e0Var.f();
        if (f11 != null && !f11.isEmpty()) {
            Iterator it = f11.iterator();
            while (it.hasNext()) {
                hashSet.addAll(((e0) it.next()).d());
            }
        }
        return hashSet;
    }

    @Override // androidx.work.h0
    public androidx.work.w a() {
        if (this.f15728h) {
            androidx.work.t.e().k(f15720j, "Already enqueued work ids (" + TextUtils.join(", ", this.f15725e) + ")");
        } else {
            this.f15729i = androidx.work.a0.c(this.f15721a.m().n(), "EnqueueRunnable_" + c().name(), this.f15721a.u().c(), new Function0() { // from class: androidx.work.impl.d0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit l11;
                    l11 = e0.this.l();
                    return l11;
                }
            });
        }
        return this.f15729i;
    }

    public ExistingWorkPolicy c() {
        return this.f15723c;
    }

    public List d() {
        return this.f15725e;
    }

    public String e() {
        return this.f15722b;
    }

    public List f() {
        return this.f15727g;
    }

    public List g() {
        return this.f15724d;
    }

    public f1 h() {
        return this.f15721a;
    }

    public boolean i() {
        return j(this, new HashSet());
    }

    public boolean k() {
        return this.f15728h;
    }

    public void m() {
        this.f15728h = true;
    }
}
