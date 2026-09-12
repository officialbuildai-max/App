package com.transsnet.downloader.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.MediaBaseViewModel$loadLocalVideoCover$1", f = "MediaBaseViewModel.kt", l = {91, 95}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class MediaBaseViewModel$loadLocalVideoCover$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MediaBaseViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBaseViewModel$loadLocalVideoCover$1(MediaBaseViewModel mediaBaseViewModel, Continuation<? super MediaBaseViewModel$loadLocalVideoCover$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaBaseViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaBaseViewModel$loadLocalVideoCover$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MediaBaseViewModel$loadLocalVideoCover$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054 A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:7:0x001a, B:8:0x00b9, B:11:0x004e, B:13:0x0054, B:16:0x0065, B:20:0x006e, B:23:0x0084, B:28:0x009d, B:30:0x00a1, B:36:0x00c3, B:46:0x0036, B:49:0x0042), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1 A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:7:0x001a, B:8:0x00b9, B:11:0x004e, B:13:0x0054, B:16:0x0065, B:20:0x006e, B:23:0x0084, B:28:0x009d, B:30:0x00a1, B:36:0x00c3, B:46:0x0036, B:49:0x0042), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x009f -> B:9:0x00c0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b6 -> B:8:0x00b9). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.MediaBaseViewModel$loadLocalVideoCover$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
