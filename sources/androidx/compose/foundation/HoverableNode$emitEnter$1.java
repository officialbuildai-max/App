package androidx.compose.foundation;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "androidx.compose.foundation.HoverableNode", f = "Hoverable.kt", l = {111}, m = "emitEnter")
/* loaded from: classes.dex */
public final class HoverableNode$emitEnter$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HoverableNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HoverableNode$emitEnter$1(HoverableNode hoverableNode, Continuation<? super HoverableNode$emitEnter$1> continuation) {
        super(continuation);
        this.this$0 = hoverableNode;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.foundation.HoverableNode.D1(androidx.compose.foundation.HoverableNode, kotlin.coroutines.Continuation):java.lang.Object
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 14
        	at java.base/java.util.ArrayList.add(ArrayList.java:455)
        	at java.base/java.util.ArrayList.add(ArrayList.java:467)
        	at jadx.core.utils.ListUtils.safeReplace(ListUtils.java:98)
        	at jadx.core.dex.visitors.InlineMethods.replaceClsUsage(InlineMethods.java:167)
        	at jadx.core.dex.visitors.InlineMethods.lambda$updateUsageInfo$0(InlineMethods.java:147)
        	at jadx.core.dex.nodes.InsnNode.visitInsns(InsnNode.java:284)
        	at jadx.core.dex.visitors.InlineMethods.updateUsageInfo(InlineMethods.java:138)
        	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:120)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:72)
        	... 1 more
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r2) {
        /*
            r1 = this;
            r1.result = r2
            int r2 = r1.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 | r0
            r1.label = r2
            androidx.compose.foundation.HoverableNode r2 = r1.this$0
            java.lang.Object r2 = androidx.compose.foundation.HoverableNode.D1(r2, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableNode$emitEnter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
