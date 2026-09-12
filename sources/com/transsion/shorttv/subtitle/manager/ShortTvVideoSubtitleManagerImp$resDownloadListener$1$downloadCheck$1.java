package com.transsion.shorttv.subtitle.manager;

import com.cloud.tmc.kernel.constants.TmcConstants;
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
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.subtitle.manager.ShortTvVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1", f = "ShortTvVideoSubtitleManagerImp.kt", l = {TmcConstants.NOTIFY_ADDHOME_GUIDE_BOTTOM_SHOW}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class ShortTvVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ts.a $bean;
    final /* synthetic */ boolean $isSuccess;
    int label;
    final /* synthetic */ ShortTvVideoSubtitleManagerImp this$0;
    final /* synthetic */ ShortTvVideoSubtitleManagerImp$resDownloadListener$1 this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1(ShortTvVideoSubtitleManagerImp shortTvVideoSubtitleManagerImp, ts.a aVar, boolean z10, ShortTvVideoSubtitleManagerImp$resDownloadListener$1 shortTvVideoSubtitleManagerImp$resDownloadListener$1, Continuation<? super ShortTvVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTvVideoSubtitleManagerImp;
        this.$bean = aVar;
        this.$isSuccess = z10;
        this.this$1 = shortTvVideoSubtitleManagerImp$resDownloadListener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1(this.this$0, this.$bean, this.$isSuccess, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean f11;
        String str;
        String str2;
        String str3;
        Object f12 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            ShortTvVideoSubtitleManagerImp shortTvVideoSubtitleManagerImp = this.this$0;
            String g11 = this.$bean.g();
            this.label = 1;
            obj = shortTvVideoSubtitleManagerImp.a(g11, this);
            if (obj == f12) {
                return f12;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List list = (List) obj;
        String str4 = this.$isSuccess ? "下载完成" : "资源继续下载";
        if (list.isEmpty()) {
            a.C0856a c0856a = lg.a.f68962a;
            str3 = this.this$0.f53139c;
            c0856a.u("short_tv_subtitle", str3 + " " + str4 + "，数据库为空，执行检测 titleName:" + this.$bean.h() + ", ep:" + this.$bean.a() + " se:" + this.$bean.c(), true);
            ShortTvVideoSubtitleManagerImp.n(this.this$0, this.$bean, null, 2, null);
        } else {
            f11 = this.this$1.f(list);
            if (f11) {
                a.C0856a c0856a2 = lg.a.f68962a;
                str2 = this.this$0.f53139c;
                c0856a2.u("short_tv_subtitle", str2 + " " + str4 + "，有失败，执行检测 titleName:" + this.$bean.h() + ", ep:" + this.$bean.a() + " se:" + this.$bean.c(), true);
                ShortTvVideoSubtitleManagerImp.n(this.this$0, this.$bean, null, 2, null);
            } else {
                a.C0856a c0856a3 = lg.a.f68962a;
                str = this.this$0.f53139c;
                c0856a3.u("short_tv_subtitle", str + " " + str4 + "，有字幕无需检测 titleName:" + this.$bean.h() + ", ep:" + this.$bean.a() + " se:" + this.$bean.c(), true);
            }
        }
        return Unit.f67184a;
    }
}
