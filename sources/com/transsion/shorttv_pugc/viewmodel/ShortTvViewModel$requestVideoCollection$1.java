package com.transsion.shorttv_pugc.viewmodel;

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
@DebugMetadata(c = "com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$requestVideoCollection$1", f = "ShortTvViewModel.kt", l = {255, 256, 259}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShortTvViewModel$requestVideoCollection$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $collectionId;
    final /* synthetic */ int $endPosition;
    final /* synthetic */ int $startPosition;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$requestVideoCollection$1(String str, int i11, int i12, ShortTvViewModel shortTvViewModel, Continuation<? super ShortTvViewModel$requestVideoCollection$1> continuation) {
        super(2, continuation);
        this.$collectionId = str;
        this.$startPosition = i11;
        this.$endPosition = i12;
        this.this$0 = shortTvViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShortTvViewModel$requestVideoCollection$1 shortTvViewModel$requestVideoCollection$1 = new ShortTvViewModel$requestVideoCollection$1(this.$collectionId, this.$startPosition, this.$endPosition, this.this$0, continuation);
        shortTvViewModel$requestVideoCollection$1.L$0 = obj;
        return shortTvViewModel$requestVideoCollection$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvViewModel$requestVideoCollection$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(1:2)|(1:(1:(1:(10:7|8|9|(4:13|(8:16|(1:18)|19|(4:21|(2:22|(2:24|(2:26|27)(1:53))(2:54|55))|28|(8:30|(1:32)(1:52)|33|(4:35|(2:36|(2:38|(2:40|41)(1:48))(2:49|50))|42|(4:44|45|46|47))|51|45|46|47))|56|57|47|14)|58|59)|60|61|(2:63|(2:65|66)(1:68))|69|70|71)(2:73|74))(16:75|76|77|78|(4:80|(4:83|(3:85|86|87)(1:89)|88|81)|90|91)|100|93|(2:97|(1:99))|9|(5:11|13|(1:14)|58|59)|60|61|(0)|69|70|71))(3:101|102|103))(2:134|(2:170|171)(3:138|(5:146|(2:149|147)|150|151|(2:153|154)(2:155|(7:157|158|159|160|161|162|(1:164)(1:165))(3:169|70|71)))|145))|104|105|(6:107|(5:121|122|(2:125|123)|126|127)(1:109)|110|111|112|(1:114)(14:115|78|(0)|100|93|(3:95|97|(0))|9|(0)|60|61|(0)|69|70|71))(7:131|60|61|(0)|69|70|71)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0337, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0338, code lost:
    
        r18 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0235, code lost:
    
        if (r0 == null) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x026a A[Catch: all -> 0x0039, TryCatch #4 {all -> 0x0039, blocks: (B:8:0x0034, B:9:0x0262, B:11:0x026a, B:13:0x0270, B:14:0x0276, B:16:0x027c, B:18:0x0285, B:19:0x0288, B:21:0x0290, B:22:0x0296, B:24:0x029c, B:28:0x02b4, B:30:0x02b8, B:32:0x02c6, B:33:0x02eb, B:35:0x02f1, B:36:0x02f7, B:38:0x02fd, B:42:0x0315, B:44:0x0319, B:45:0x0328, B:51:0x0321, B:59:0x0330, B:60:0x033f, B:76:0x005c, B:78:0x0207, B:80:0x0210, B:81:0x021b, B:83:0x0221, B:86:0x022d, B:91:0x0231, B:93:0x023c, B:95:0x0245, B:97:0x024b, B:100:0x0237, B:102:0x007a), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x027c A[Catch: all -> 0x0039, TryCatch #4 {all -> 0x0039, blocks: (B:8:0x0034, B:9:0x0262, B:11:0x026a, B:13:0x0270, B:14:0x0276, B:16:0x027c, B:18:0x0285, B:19:0x0288, B:21:0x0290, B:22:0x0296, B:24:0x029c, B:28:0x02b4, B:30:0x02b8, B:32:0x02c6, B:33:0x02eb, B:35:0x02f1, B:36:0x02f7, B:38:0x02fd, B:42:0x0315, B:44:0x0319, B:45:0x0328, B:51:0x0321, B:59:0x0330, B:60:0x033f, B:76:0x005c, B:78:0x0207, B:80:0x0210, B:81:0x021b, B:83:0x0221, B:86:0x022d, B:91:0x0231, B:93:0x023c, B:95:0x0245, B:97:0x024b, B:100:0x0237, B:102:0x007a), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0210 A[Catch: all -> 0x0039, TryCatch #4 {all -> 0x0039, blocks: (B:8:0x0034, B:9:0x0262, B:11:0x026a, B:13:0x0270, B:14:0x0276, B:16:0x027c, B:18:0x0285, B:19:0x0288, B:21:0x0290, B:22:0x0296, B:24:0x029c, B:28:0x02b4, B:30:0x02b8, B:32:0x02c6, B:33:0x02eb, B:35:0x02f1, B:36:0x02f7, B:38:0x02fd, B:42:0x0315, B:44:0x0319, B:45:0x0328, B:51:0x0321, B:59:0x0330, B:60:0x033f, B:76:0x005c, B:78:0x0207, B:80:0x0210, B:81:0x021b, B:83:0x0221, B:86:0x022d, B:91:0x0231, B:93:0x023c, B:95:0x0245, B:97:0x024b, B:100:0x0237, B:102:0x007a), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0261 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 955
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$requestVideoCollection$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
