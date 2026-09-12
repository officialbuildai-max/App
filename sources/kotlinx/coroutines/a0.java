package kotlinx.coroutines;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f67748a;

    /* renamed from: b, reason: collision with root package name */
    public final m f67749b;

    /* renamed from: c, reason: collision with root package name */
    public final Function3 f67750c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f67751d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f67752e;

    public a0(Object obj, m mVar, Function3 function3, Object obj2, Throwable th2) {
        this.f67748a = obj;
        this.f67749b = mVar;
        this.f67750c = function3;
        this.f67751d = obj2;
        this.f67752e = th2;
    }

    public /* synthetic */ a0(Object obj, m mVar, Function3 function3, Object obj2, Throwable th2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i11 & 2) != 0 ? null : mVar, (i11 & 4) != 0 ? null : function3, (i11 & 8) != 0 ? null : obj2, (i11 & 16) != 0 ? null : th2);
    }

    public static /* synthetic */ a0 b(a0 a0Var, Object obj, m mVar, Function3 function3, Object obj2, Throwable th2, int i11, Object obj3) {
        if ((i11 & 1) != 0) {
            obj = a0Var.f67748a;
        }
        if ((i11 & 2) != 0) {
            mVar = a0Var.f67749b;
        }
        m mVar2 = mVar;
        if ((i11 & 4) != 0) {
            function3 = a0Var.f67750c;
        }
        Function3 function32 = function3;
        if ((i11 & 8) != 0) {
            obj2 = a0Var.f67751d;
        }
        Object obj4 = obj2;
        if ((i11 & 16) != 0) {
            th2 = a0Var.f67752e;
        }
        return a0Var.a(obj, mVar2, function32, obj4, th2);
    }

    public final a0 a(Object obj, m mVar, Function3 function3, Object obj2, Throwable th2) {
        return new a0(obj, mVar, function3, obj2, th2);
    }

    public final boolean c() {
        return this.f67752e != null;
    }

    public final void d(CancellableContinuationImpl cancellableContinuationImpl, Throwable th2) {
        m mVar = this.f67749b;
        if (mVar != null) {
            cancellableContinuationImpl.callCancelHandler(mVar, th2);
        }
        Function3 function3 = this.f67750c;
        if (function3 != null) {
            cancellableContinuationImpl.callOnCancellation(function3, th2, this.f67748a);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Intrinsics.c(this.f67748a, a0Var.f67748a) && Intrinsics.c(this.f67749b, a0Var.f67749b) && Intrinsics.c(this.f67750c, a0Var.f67750c) && Intrinsics.c(this.f67751d, a0Var.f67751d) && Intrinsics.c(this.f67752e, a0Var.f67752e);
    }

    public int hashCode() {
        Object obj = this.f67748a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        m mVar = this.f67749b;
        int hashCode2 = (hashCode + (mVar == null ? 0 : mVar.hashCode())) * 31;
        Function3 function3 = this.f67750c;
        int hashCode3 = (hashCode2 + (function3 == null ? 0 : function3.hashCode())) * 31;
        Object obj2 = this.f67751d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th2 = this.f67752e;
        return hashCode4 + (th2 != null ? th2.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f67748a + ", cancelHandler=" + this.f67749b + ", onCancellation=" + this.f67750c + ", idempotentResume=" + this.f67751d + ", cancelCause=" + this.f67752e + ')';
    }
}
