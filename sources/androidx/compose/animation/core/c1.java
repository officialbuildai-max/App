package androidx.compose.animation.core;

import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class c1 implements b1 {

    /* renamed from: a, reason: collision with root package name */
    private final q f2486a;

    /* renamed from: b, reason: collision with root package name */
    private o f2487b;

    /* renamed from: c, reason: collision with root package name */
    private o f2488c;

    /* renamed from: d, reason: collision with root package name */
    private o f2489d;

    /* loaded from: classes.dex */
    public static final class a implements q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d0 f2490a;

        a(d0 d0Var) {
            this.f2490a = d0Var;
        }

        @Override // androidx.compose.animation.core.q
        public d0 get(int i11) {
            return this.f2490a;
        }
    }

    public c1(d0 d0Var) {
        this(new a(d0Var));
    }

    public c1(q qVar) {
        this.f2486a = qVar;
    }

    @Override // androidx.compose.animation.core.v0
    public /* synthetic */ boolean a() {
        return a1.a(this);
    }

    @Override // androidx.compose.animation.core.v0
    public o c(o oVar, o oVar2, o oVar3) {
        if (this.f2489d == null) {
            this.f2489d = p.g(oVar3);
        }
        o oVar4 = this.f2489d;
        if (oVar4 == null) {
            Intrinsics.z("endVelocityVector");
            oVar4 = null;
        }
        int b11 = oVar4.b();
        for (int i11 = 0; i11 < b11; i11++) {
            o oVar5 = this.f2489d;
            if (oVar5 == null) {
                Intrinsics.z("endVelocityVector");
                oVar5 = null;
            }
            oVar5.e(i11, this.f2486a.get(i11).b(oVar.a(i11), oVar2.a(i11), oVar3.a(i11)));
        }
        o oVar6 = this.f2489d;
        if (oVar6 != null) {
            return oVar6;
        }
        Intrinsics.z("endVelocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.v0
    public o e(long j11, o oVar, o oVar2, o oVar3) {
        if (this.f2488c == null) {
            this.f2488c = p.g(oVar3);
        }
        o oVar4 = this.f2488c;
        if (oVar4 == null) {
            Intrinsics.z("velocityVector");
            oVar4 = null;
        }
        int b11 = oVar4.b();
        for (int i11 = 0; i11 < b11; i11++) {
            o oVar5 = this.f2488c;
            if (oVar5 == null) {
                Intrinsics.z("velocityVector");
                oVar5 = null;
            }
            oVar5.e(i11, this.f2486a.get(i11).d(j11, oVar.a(i11), oVar2.a(i11), oVar3.a(i11)));
        }
        o oVar6 = this.f2488c;
        if (oVar6 != null) {
            return oVar6;
        }
        Intrinsics.z("velocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.v0
    public long f(o oVar, o oVar2, o oVar3) {
        Iterator<Integer> it = RangesKt.t(0, oVar.b()).iterator();
        long j11 = 0;
        while (it.hasNext()) {
            int a11 = ((IntIterator) it).a();
            j11 = Math.max(j11, this.f2486a.get(a11).e(oVar.a(a11), oVar2.a(a11), oVar3.a(a11)));
        }
        return j11;
    }

    @Override // androidx.compose.animation.core.v0
    public o g(long j11, o oVar, o oVar2, o oVar3) {
        if (this.f2487b == null) {
            this.f2487b = p.g(oVar);
        }
        o oVar4 = this.f2487b;
        if (oVar4 == null) {
            Intrinsics.z("valueVector");
            oVar4 = null;
        }
        int b11 = oVar4.b();
        for (int i11 = 0; i11 < b11; i11++) {
            o oVar5 = this.f2487b;
            if (oVar5 == null) {
                Intrinsics.z("valueVector");
                oVar5 = null;
            }
            oVar5.e(i11, this.f2486a.get(i11).c(j11, oVar.a(i11), oVar2.a(i11), oVar3.a(i11)));
        }
        o oVar6 = this.f2487b;
        if (oVar6 != null) {
            return oVar6;
        }
        Intrinsics.z("valueVector");
        return null;
    }
}
