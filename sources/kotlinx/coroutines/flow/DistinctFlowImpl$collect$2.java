package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class DistinctFlowImpl$collect$2 implements c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DistinctFlowImpl f67840a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f67841b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f67842c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DistinctFlowImpl$collect$2(DistinctFlowImpl distinctFlowImpl, Ref.ObjectRef objectRef, c cVar) {
        this.f67840a = distinctFlowImpl;
        this.f67841b = objectRef;
        this.f67842c = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r7v4, types: [T, java.lang.Object] */
    @Override // kotlinx.coroutines.flow.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L67
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.flow.DistinctFlowImpl r7 = r5.f67840a
            kotlin.jvm.functions.Function1 r7 = r7.f67838b
            java.lang.Object r7 = r7.invoke(r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = r5.f67841b
            T r2 = r2.element
            kotlinx.coroutines.internal.z r4 = kotlinx.coroutines.flow.internal.m.f67936a
            if (r2 == r4) goto L58
            kotlinx.coroutines.flow.DistinctFlowImpl r4 = r5.f67840a
            kotlin.jvm.functions.Function2 r4 = r4.f67839c
            java.lang.Object r2 = r4.invoke(r2, r7)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L55
            goto L58
        L55:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        L58:
            kotlin.jvm.internal.Ref$ObjectRef r2 = r5.f67841b
            r2.element = r7
            kotlinx.coroutines.flow.c r7 = r5.f67842c
            r0.label = r3
            java.lang.Object r6 = r7.emit(r6, r0)
            if (r6 != r1) goto L67
            return r1
        L67:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
