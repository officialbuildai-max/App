package com.transsion.shorttv.viewmodel;

import android.content.Context;
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
@DebugMetadata(c = "com.transsion.shorttv.viewmodel.ShortTvViewModel$loadCache$1", f = "ShortTvViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class ShortTvViewModel$loadCache$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.shorttv.viewmodel.ShortTvViewModel$loadCache$1$1", f = "ShortTvViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.shorttv.viewmodel.ShortTvViewModel$loadCache$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ ShortTvViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ShortTvViewModel shortTvViewModel, Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = shortTvViewModel;
            this.$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d() {
            a.C0856a.z(lg.a.f68962a, "ShortTvViewModel", "Cache---没有运营位缓存", false, 4, null);
            return Unit.f67184a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:5:0x000e, B:7:0x0020, B:10:0x0031, B:12:0x003b, B:14:0x004a, B:15:0x0054, B:16:0x008a, B:22:0x0085, B:23:0x0029), top: B:4:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0085 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:5:0x000e, B:7:0x0020, B:10:0x0031, B:12:0x003b, B:14:0x004a, B:15:0x0054, B:16:0x008a, B:22:0x0085, B:23:0x0029), top: B:4:0x000e }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r0 = r8.label
                if (r0 != 0) goto L9a
                kotlin.ResultKt.b(r9)
                com.transsion.shorttv.viewmodel.ShortTvViewModel r9 = r8.this$0
                android.content.Context r0 = r8.$context
                kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L27
                com.transsion.shorttv.utils.h r1 = com.transsion.shorttv.utils.h.f53707a     // Catch: java.lang.Throwable -> L27
                com.tencent.mmkv.MMKV r1 = r1.d()     // Catch: java.lang.Throwable -> L27
                java.lang.String r2 = "short_tv_operating_data"
                java.lang.String r3 = ""
                java.lang.String r1 = r1.getString(r2, r3)     // Catch: java.lang.Throwable -> L27
                if (r1 == 0) goto L29
                int r2 = r1.length()     // Catch: java.lang.Throwable -> L27
                if (r2 != 0) goto L31
                goto L29
            L27:
                r9 = move-exception
                goto L8e
            L29:
                ps.a r1 = com.transsion.shorttv.viewmodel.ShortTvViewModel.s(r9)     // Catch: java.lang.Throwable -> L27
                java.lang.String r1 = r1.a(r0)     // Catch: java.lang.Throwable -> L27
            L31:
                java.lang.Class<com.transsion.shorttv.bean.OperatingResp> r0 = com.transsion.shorttv.bean.OperatingResp.class
                java.lang.Object r0 = com.blankj.utilcode.util.o.d(r1, r0)     // Catch: java.lang.Throwable -> L27
                com.transsion.shorttv.bean.OperatingResp r0 = (com.transsion.shorttv.bean.OperatingResp) r0     // Catch: java.lang.Throwable -> L27
                if (r0 == 0) goto L85
                java.lang.String r1 = "from_cache"
                r0.setSourceFrom(r1)     // Catch: java.lang.Throwable -> L27
                lg.a$a r2 = lg.a.f68962a     // Catch: java.lang.Throwable -> L27
                java.lang.String r3 = "ShortTvViewModel"
                java.util.List r1 = r0.getBanners()     // Catch: java.lang.Throwable -> L27
                if (r1 == 0) goto L53
                int r1 = r1.size()     // Catch: java.lang.Throwable -> L27
                java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.d(r1)     // Catch: java.lang.Throwable -> L27
                goto L54
            L53:
                r1 = 0
            L54:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L27
                r4.<init>()     // Catch: java.lang.Throwable -> L27
                java.lang.String r5 = "Cache---有运营位缓存 banner:"
                r4.append(r5)     // Catch: java.lang.Throwable -> L27
                r4.append(r1)     // Catch: java.lang.Throwable -> L27
                java.lang.String r1 = " "
                r4.append(r1)     // Catch: java.lang.Throwable -> L27
                java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L27
                java.lang.String[] r4 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> L27
                r6 = 4
                r7 = 0
                r5 = 0
                lg.a.C0856a.r(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L27
                r1 = 1
                r0.setCache(r1)     // Catch: java.lang.Throwable -> L27
                com.transsion.shorttv.viewmodel.ShortTvViewModel.F(r9, r0)     // Catch: java.lang.Throwable -> L27
                androidx.lifecycle.b0 r9 = r9.i0()     // Catch: java.lang.Throwable -> L27
                r9.n(r0)     // Catch: java.lang.Throwable -> L27
                kotlin.Unit r9 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L27
                goto L8a
            L85:
                com.transsion.shorttv.viewmodel.o r9 = new com.transsion.shorttv.viewmodel.o     // Catch: java.lang.Throwable -> L27
                r9.<init>()     // Catch: java.lang.Throwable -> L27
            L8a:
                kotlin.Result.m1185constructorimpl(r9)     // Catch: java.lang.Throwable -> L27
                goto L97
            L8e:
                kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
                java.lang.Object r9 = kotlin.ResultKt.a(r9)
                kotlin.Result.m1185constructorimpl(r9)
            L97:
                kotlin.Unit r9 = kotlin.Unit.f67184a
                return r9
            L9a:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.viewmodel.ShortTvViewModel$loadCache$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$loadCache$1(ShortTvViewModel shortTvViewModel, Context context, Continuation<? super ShortTvViewModel$loadCache$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTvViewModel;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShortTvViewModel$loadCache$1 shortTvViewModel$loadCache$1 = new ShortTvViewModel$loadCache$1(this.this$0, this.$context, continuation);
        shortTvViewModel$loadCache$1.L$0 = obj;
        return shortTvViewModel$loadCache$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvViewModel$loadCache$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        kotlinx.coroutines.k.d((n0) this.L$0, null, null, new AnonymousClass1(this.this$0, this.$context, null), 3, null);
        return Unit.f67184a;
    }
}
