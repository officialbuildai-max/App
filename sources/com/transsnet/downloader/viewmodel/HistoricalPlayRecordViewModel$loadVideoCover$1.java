package com.transsnet.downloader.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$loadVideoCover$1", f = "HistoricalPlayRecordViewModel.kt", l = {265, 269, 276}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
final class HistoricalPlayRecordViewModel$loadVideoCover$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ HistoricalPlayRecordViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoricalPlayRecordViewModel$loadVideoCover$1(HistoricalPlayRecordViewModel historicalPlayRecordViewModel, Continuation<? super HistoricalPlayRecordViewModel$loadVideoCover$1> continuation) {
        super(2, continuation);
        this.this$0 = historicalPlayRecordViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoricalPlayRecordViewModel$loadVideoCover$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((HistoricalPlayRecordViewModel$loadVideoCover$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0126, code lost:
    
        r6 = r6.getHistorical();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x012a, code lost:
    
        if (r6 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x012c, code lost:
    
        r6.setVideo(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x012f, code lost:
    
        r6 = r1.P();
        r5 = kotlin.coroutines.jvm.internal.Boxing.d(r5);
        r18.L$0 = r1;
        r18.L$1 = r4;
        r18.L$2 = r3;
        r18.L$3 = r2;
        r18.I$0 = r12;
        r18.label = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0147, code lost:
    
        if (r6.emit(r5, r18) != r8) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0149, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x014a, code lost:
    
        r5 = r1;
        r1 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00fd A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:8:0x0026, B:11:0x00f7, B:13:0x00fd, B:15:0x0105, B:16:0x0108, B:18:0x0110, B:20:0x0116, B:21:0x011c, B:25:0x0126, B:27:0x012c, B:28:0x012f, B:38:0x006c, B:40:0x0072, B:43:0x0083, B:47:0x008c, B:50:0x00a2, B:54:0x00be, B:56:0x00c2, B:59:0x00da, B:61:0x00e6, B:65:0x015a, B:75:0x0042, B:77:0x0053, B:80:0x0060), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072 A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:8:0x0026, B:11:0x00f7, B:13:0x00fd, B:15:0x0105, B:16:0x0108, B:18:0x0110, B:20:0x0116, B:21:0x011c, B:25:0x0126, B:27:0x012c, B:28:0x012f, B:38:0x006c, B:40:0x0072, B:43:0x0083, B:47:0x008c, B:50:0x00a2, B:54:0x00be, B:56:0x00c2, B:59:0x00da, B:61:0x00e6, B:65:0x015a, B:75:0x0042, B:77:0x0053, B:80:0x0060), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c2 A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:8:0x0026, B:11:0x00f7, B:13:0x00fd, B:15:0x0105, B:16:0x0108, B:18:0x0110, B:20:0x0116, B:21:0x011c, B:25:0x0126, B:27:0x012c, B:28:0x012f, B:38:0x006c, B:40:0x0072, B:43:0x0083, B:47:0x008c, B:50:0x00a2, B:54:0x00be, B:56:0x00c2, B:59:0x00da, B:61:0x00e6, B:65:0x015a, B:75:0x0042, B:77:0x0053, B:80:0x0060), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e6 A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:8:0x0026, B:11:0x00f7, B:13:0x00fd, B:15:0x0105, B:16:0x0108, B:18:0x0110, B:20:0x0116, B:21:0x011c, B:25:0x0126, B:27:0x012c, B:28:0x012f, B:38:0x006c, B:40:0x0072, B:43:0x0083, B:47:0x008c, B:50:0x00a2, B:54:0x00be, B:56:0x00c2, B:59:0x00da, B:61:0x00e6, B:65:0x015a, B:75:0x0042, B:77:0x0053, B:80:0x0060), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0172  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x014a -> B:9:0x014c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00c0 -> B:33:0x0156). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00e4 -> B:33:0x0156). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00e6 -> B:10:0x00f7). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$loadVideoCover$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
