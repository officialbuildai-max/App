package androidx.work.impl.constraints.controllers;

import androidx.work.impl.model.j0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class BaseConstraintController implements d {

    /* renamed from: a, reason: collision with root package name */
    private final i4.g f15679a;

    public BaseConstraintController(i4.g tracker) {
        Intrinsics.h(tracker, "tracker");
        this.f15679a = tracker;
    }

    @Override // androidx.work.impl.constraints.controllers.d
    public boolean a(j0 workSpec) {
        Intrinsics.h(workSpec, "workSpec");
        return c(workSpec) && f(this.f15679a.f());
    }

    @Override // androidx.work.impl.constraints.controllers.d
    public kotlinx.coroutines.flow.b b(androidx.work.d constraints) {
        Intrinsics.h(constraints, "constraints");
        return kotlinx.coroutines.flow.d.e(new BaseConstraintController$track$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int e();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean f(Object obj);
}
