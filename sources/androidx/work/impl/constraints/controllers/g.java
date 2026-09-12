package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.model.j0;
import androidx.work.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class g extends BaseConstraintController {

    /* renamed from: c, reason: collision with root package name */
    private static final a f15690c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final String f15691d;

    /* renamed from: b, reason: collision with root package name */
    private final int f15692b;

    /* loaded from: classes2.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String i11 = t.i("NetworkNotRoamingCtrlr");
        Intrinsics.g(i11, "tagWithPrefix(...)");
        f15691d = i11;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(i4.g tracker) {
        super(tracker);
        Intrinsics.h(tracker, "tracker");
        this.f15692b = 7;
    }

    @Override // androidx.work.impl.constraints.controllers.d
    public boolean c(j0 workSpec) {
        Intrinsics.h(workSpec, "workSpec");
        return workSpec.f15855j.f() == NetworkType.NOT_ROAMING;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    public int e() {
        return this.f15692b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean f(androidx.work.impl.constraints.g value) {
        Intrinsics.h(value, "value");
        if (Build.VERSION.SDK_INT < 24) {
            t.e().a(f15691d, "Not-roaming network constraint is not supported before API 24, only checking for connected state.");
            if (!value.d() || value.c()) {
                return true;
            }
        } else if (!value.d() || !value.f() || value.c()) {
            return true;
        }
        return false;
    }
}
