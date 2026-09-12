package com.transsion.videodetail.music.data;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$getMusicLiked$1", f = "MusicLikedFragmentViewModel.kt", l = {PsExtractor.PRIVATE_STREAM_1, 193, 195}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class MusicLikedFragmentViewModel$getMusicLiked$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $from;
    int label;
    final /* synthetic */ MusicLikedFragmentViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicLikedFragmentViewModel$getMusicLiked$1(MusicLikedFragmentViewModel musicLikedFragmentViewModel, String str, Continuation<? super MusicLikedFragmentViewModel$getMusicLiked$1> continuation) {
        super(2, continuation);
        this.this$0 = musicLikedFragmentViewModel;
        this.$from = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MusicLikedFragmentViewModel$getMusicLiked$1(this.this$0, this.$from, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MusicLikedFragmentViewModel$getMusicLiked$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        oj.a A;
        List list;
        String t11;
        Object I;
        Object H;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            A = this.this$0.A();
            this.label = 1;
            obj = A.a(this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                if (i11 != 2 && i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f67184a;
            }
            ResultKt.b(obj);
        }
        int intValue = ((Number) obj).intValue();
        list = this.this$0.f57849b;
        list.clear();
        kx.a aVar = kx.a.f68524a;
        t11 = this.this$0.t();
        aVar.a(t11 + " --> getMusicLiked() --> 加载音乐收藏数据 --> count = " + intValue + " --> from = " + this.$from);
        if (intValue > 0) {
            MusicLikedFragmentViewModel musicLikedFragmentViewModel = this.this$0;
            this.label = 2;
            H = musicLikedFragmentViewModel.H(this);
            if (H == f11) {
                return f11;
            }
        } else {
            MusicLikedFragmentViewModel musicLikedFragmentViewModel2 = this.this$0;
            this.label = 3;
            I = musicLikedFragmentViewModel2.I(this);
            if (I == f11) {
                return f11;
            }
        }
        return Unit.f67184a;
    }
}
