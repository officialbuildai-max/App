package com.transsion.shorttv_pugc.viewmodel;

import com.transsion.shorttv_pugc.ShorttvModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$requestFirstVideo$1", f = "ShortTvViewModel.kt", l = {146, 156, 160, 161, 164}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShortTvViewModel$requestFirstVideo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $collectionId;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ String $ugcVideoId;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/n0;", "Lkotlin/Result;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)Lkotlin/Result;"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$requestFirstVideo$1$2", f = "ShortTvViewModel.kt", l = {179, 180, 184}, m = "invokeSuspend")
    /* renamed from: com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$requestFirstVideo$1$2, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<n0, Continuation<? super Result<? extends Unit>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ ShorttvModel.UGCVideo $downloadVideo;
        final /* synthetic */ String $subjectId;
        final /* synthetic */ Ref.ObjectRef<ShorttvModel.UGCVideo> $ugcVideo;
        final /* synthetic */ Ref.ObjectRef<String> $ugcVideoIdMutable;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ ShortTvViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<ShorttvModel.UGCVideo> objectRef, ShortTvViewModel shortTvViewModel, Ref.ObjectRef<String> objectRef2, String str, String str2, ShorttvModel.UGCVideo uGCVideo, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$ugcVideo = objectRef;
            this.this$0 = shortTvViewModel;
            this.$ugcVideoIdMutable = objectRef2;
            this.$collectionId = str;
            this.$subjectId = str2;
            this.$downloadVideo = uGCVideo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$ugcVideo, this.this$0, this.$ugcVideoIdMutable, this.$collectionId, this.$subjectId, this.$downloadVideo, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Result<Unit>> continuation) {
            return ((AnonymousClass2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0137 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:8:0x0028, B:10:0x0133, B:12:0x0137, B:14:0x0147, B:15:0x014a, B:17:0x0153, B:18:0x0159, B:20:0x0169, B:21:0x0177, B:23:0x0184, B:25:0x018a, B:28:0x0196, B:29:0x019c, B:31:0x019f, B:34:0x01a7, B:38:0x01bc, B:39:0x01b0, B:41:0x01b6, B:43:0x01bf, B:46:0x01ce, B:48:0x01db, B:50:0x0232, B:52:0x0234, B:53:0x025d, B:70:0x0050, B:72:0x00f1, B:74:0x00f7, B:76:0x00ff, B:78:0x0105, B:80:0x010b, B:82:0x0111, B:84:0x0117, B:85:0x011d, B:92:0x006a, B:94:0x00db, B:99:0x0088), top: B:2:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0153 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:8:0x0028, B:10:0x0133, B:12:0x0137, B:14:0x0147, B:15:0x014a, B:17:0x0153, B:18:0x0159, B:20:0x0169, B:21:0x0177, B:23:0x0184, B:25:0x018a, B:28:0x0196, B:29:0x019c, B:31:0x019f, B:34:0x01a7, B:38:0x01bc, B:39:0x01b0, B:41:0x01b6, B:43:0x01bf, B:46:0x01ce, B:48:0x01db, B:50:0x0232, B:52:0x0234, B:53:0x025d, B:70:0x0050, B:72:0x00f1, B:74:0x00f7, B:76:0x00ff, B:78:0x0105, B:80:0x010b, B:82:0x0111, B:84:0x0117, B:85:0x011d, B:92:0x006a, B:94:0x00db, B:99:0x0088), top: B:2:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0169 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:8:0x0028, B:10:0x0133, B:12:0x0137, B:14:0x0147, B:15:0x014a, B:17:0x0153, B:18:0x0159, B:20:0x0169, B:21:0x0177, B:23:0x0184, B:25:0x018a, B:28:0x0196, B:29:0x019c, B:31:0x019f, B:34:0x01a7, B:38:0x01bc, B:39:0x01b0, B:41:0x01b6, B:43:0x01bf, B:46:0x01ce, B:48:0x01db, B:50:0x0232, B:52:0x0234, B:53:0x025d, B:70:0x0050, B:72:0x00f1, B:74:0x00f7, B:76:0x00ff, B:78:0x0105, B:80:0x010b, B:82:0x0111, B:84:0x0117, B:85:0x011d, B:92:0x006a, B:94:0x00db, B:99:0x0088), top: B:2:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0184 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:8:0x0028, B:10:0x0133, B:12:0x0137, B:14:0x0147, B:15:0x014a, B:17:0x0153, B:18:0x0159, B:20:0x0169, B:21:0x0177, B:23:0x0184, B:25:0x018a, B:28:0x0196, B:29:0x019c, B:31:0x019f, B:34:0x01a7, B:38:0x01bc, B:39:0x01b0, B:41:0x01b6, B:43:0x01bf, B:46:0x01ce, B:48:0x01db, B:50:0x0232, B:52:0x0234, B:53:0x025d, B:70:0x0050, B:72:0x00f1, B:74:0x00f7, B:76:0x00ff, B:78:0x0105, B:80:0x010b, B:82:0x0111, B:84:0x0117, B:85:0x011d, B:92:0x006a, B:94:0x00db, B:99:0x0088), top: B:2:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0194  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x01a5  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01cd  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0278  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x028a  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0158  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0140  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x00f7 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:8:0x0028, B:10:0x0133, B:12:0x0137, B:14:0x0147, B:15:0x014a, B:17:0x0153, B:18:0x0159, B:20:0x0169, B:21:0x0177, B:23:0x0184, B:25:0x018a, B:28:0x0196, B:29:0x019c, B:31:0x019f, B:34:0x01a7, B:38:0x01bc, B:39:0x01b0, B:41:0x01b6, B:43:0x01bf, B:46:0x01ce, B:48:0x01db, B:50:0x0232, B:52:0x0234, B:53:0x025d, B:70:0x0050, B:72:0x00f1, B:74:0x00f7, B:76:0x00ff, B:78:0x0105, B:80:0x010b, B:82:0x0111, B:84:0x0117, B:85:0x011d, B:92:0x006a, B:94:0x00db, B:99:0x0088), top: B:2:0x000c }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r43) {
            /*
                Method dump skipped, instructions count: 658
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$requestFirstVideo$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$requestFirstVideo$1(String str, ShortTvViewModel shortTvViewModel, String str2, String str3, Continuation<? super ShortTvViewModel$requestFirstVideo$1> continuation) {
        super(2, continuation);
        this.$ugcVideoId = str;
        this.this$0 = shortTvViewModel;
        this.$collectionId = str2;
        this.$subjectId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvViewModel$requestFirstVideo$1(this.$ugcVideoId, this.this$0, this.$collectionId, this.$subjectId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvViewModel$requestFirstVideo$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00cc  */
    /* JADX WARN: Type inference failed for: r9v0, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v9, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$requestFirstVideo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
