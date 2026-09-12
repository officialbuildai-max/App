package com.transsion.videodetail.music.data;

import com.transsion.videodetail.music.bean.LikeListActionEnum;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$likedMusic$1", f = "MusicLikedFragmentViewModel.kt", l = {66}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class MusicLikedFragmentViewModel$likedMusic$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ LikeListActionEnum $action;
    final /* synthetic */ String $subjectId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MusicLikedFragmentViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicLikedFragmentViewModel$likedMusic$1(String str, LikeListActionEnum likeListActionEnum, MusicLikedFragmentViewModel musicLikedFragmentViewModel, Continuation<? super MusicLikedFragmentViewModel$likedMusic$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$action = likeListActionEnum;
        this.this$0 = musicLikedFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MusicLikedFragmentViewModel$likedMusic$1 musicLikedFragmentViewModel$likedMusic$1 = new MusicLikedFragmentViewModel$likedMusic$1(this.$subjectId, this.$action, this.this$0, continuation);
        musicLikedFragmentViewModel$likedMusic$1.L$0 = obj;
        return musicLikedFragmentViewModel$likedMusic$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MusicLikedFragmentViewModel$likedMusic$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00c8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.label
            r2 = 1
            if (r1 == 0) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r11.L$0
            com.transsion.videodetail.music.data.MusicLikedFragmentViewModel r0 = (com.transsion.videodetail.music.data.MusicLikedFragmentViewModel) r0
            kotlin.ResultKt.b(r12)     // Catch: java.lang.Throwable -> L13
            goto L63
        L13:
            r12 = move-exception
            goto Lb5
        L16:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1e:
            kotlin.ResultKt.b(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.n0 r12 = (kotlinx.coroutines.n0) r12
            java.lang.String r12 = r11.$subjectId
            com.transsion.videodetail.music.bean.LikeListActionEnum r1 = r11.$action
            com.transsion.videodetail.music.data.MusicLikedFragmentViewModel r3 = r11.this$0
            kotlin.Result$Companion r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L13
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L13
            r4.<init>()     // Catch: java.lang.Throwable -> L13
            java.lang.String r5 = "subjectId"
            r4.put(r5, r12)     // Catch: java.lang.Throwable -> L13
            java.lang.String r12 = "action"
            int r1 = r1.getValue()     // Catch: java.lang.Throwable -> L13
            r4.put(r12, r1)     // Catch: java.lang.Throwable -> L13
            com.transsion.videodetail.music.data.a r5 = com.transsion.videodetail.music.data.MusicLikedFragmentViewModel.j(r3)     // Catch: java.lang.Throwable -> L13
            bh.b$a r12 = bh.b.f16553a     // Catch: java.lang.Throwable -> L13
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L13
            java.lang.String r4 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.g(r1, r4)     // Catch: java.lang.Throwable -> L13
            okhttp3.RequestBody r6 = r12.a(r1)     // Catch: java.lang.Throwable -> L13
            r11.L$0 = r3     // Catch: java.lang.Throwable -> L13
            r11.label = r2     // Catch: java.lang.Throwable -> L13
            r7 = 0
            r9 = 2
            r10 = 0
            r8 = r11
            java.lang.Object r12 = com.transsion.videodetail.music.data.a.C0713a.b(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L13
            if (r12 != r0) goto L62
            return r0
        L62:
            r0 = r3
        L63:
            com.tn.lib.net.bean.BaseDto r12 = (com.tn.lib.net.bean.BaseDto) r12     // Catch: java.lang.Throwable -> L13
            java.lang.Object r1 = r12.getData()     // Catch: java.lang.Throwable -> L13
            com.transsion.videodetail.music.bean.MusicLikedRemoteActionBean r1 = (com.transsion.videodetail.music.bean.MusicLikedRemoteActionBean) r1     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L83
            java.lang.Integer r1 = r1.getAction()     // Catch: java.lang.Throwable -> L13
            com.transsion.videodetail.music.bean.LikeListActionEnum r2 = com.transsion.videodetail.music.bean.LikeListActionEnum.ADD     // Catch: java.lang.Throwable -> L13
            int r2 = r2.getValue()     // Catch: java.lang.Throwable -> L13
            if (r1 != 0) goto L7a
            goto L83
        L7a:
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L13
            if (r1 != r2) goto L83
            java.lang.String r1 = "收藏"
            goto L85
        L83:
            java.lang.String r1 = "取消"
        L85:
            kx.a r2 = kx.a.f68524a     // Catch: java.lang.Throwable -> L13
            java.lang.String r0 = com.transsion.videodetail.music.data.MusicLikedFragmentViewModel.f(r0)     // Catch: java.lang.Throwable -> L13
            java.lang.Object r12 = r12.getData()     // Catch: java.lang.Throwable -> L13
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L13
            r3.<init>()     // Catch: java.lang.Throwable -> L13
            r3.append(r0)     // Catch: java.lang.Throwable -> L13
            java.lang.String r0 = " --> likedMusic() --> "
            r3.append(r0)     // Catch: java.lang.Throwable -> L13
            r3.append(r1)     // Catch: java.lang.Throwable -> L13
            java.lang.String r0 = "成功,同步本地数据库 --> likeMusic = "
            r3.append(r0)     // Catch: java.lang.Throwable -> L13
            r3.append(r12)     // Catch: java.lang.Throwable -> L13
            java.lang.String r12 = r3.toString()     // Catch: java.lang.Throwable -> L13
            r2.a(r12)     // Catch: java.lang.Throwable -> L13
            kotlin.Unit r12 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L13
            java.lang.Object r12 = kotlin.Result.m1185constructorimpl(r12)     // Catch: java.lang.Throwable -> L13
            goto Lbf
        Lb5:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r12 = kotlin.ResultKt.a(r12)
            java.lang.Object r12 = kotlin.Result.m1185constructorimpl(r12)
        Lbf:
            com.transsion.videodetail.music.data.MusicLikedFragmentViewModel r0 = r11.this$0
            java.lang.Throwable r12 = kotlin.Result.m1188exceptionOrNullimpl(r12)
            if (r12 != 0) goto Lc8
            goto Le5
        Lc8:
            kx.a r1 = kx.a.f68524a
            java.lang.String r0 = com.transsion.videodetail.music.data.MusicLikedFragmentViewModel.f(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = " --> likedMusic() --> it = "
            r2.append(r0)
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            r1.b(r12)
        Le5:
            kotlin.Unit r12 = kotlin.Unit.f67184a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$likedMusic$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
