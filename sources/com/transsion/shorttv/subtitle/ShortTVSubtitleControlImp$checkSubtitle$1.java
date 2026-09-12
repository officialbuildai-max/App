package com.transsion.shorttv.subtitle;

import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.ShortTvInnerPlayBean;
import com.transsion.shorttv.subtitle.manager.b;
import java.util.ArrayList;
import java.util.List;
import js.e;
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
import nh.m;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$checkSubtitle$1", f = "ShortTVSubtitleControlImp.kt", l = {177, 179, 184}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class ShortTVSubtitleControlImp$checkSubtitle$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ShortTVSubtitleControlImp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$checkSubtitle$1$1", f = "ShortTVSubtitleControlImp.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$checkSubtitle$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ ShortTvInnerPlayBean $history;
        final /* synthetic */ List<ts.b> $list;
        int label;
        final /* synthetic */ ShortTVSubtitleControlImp this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<ts.b> list, ShortTVSubtitleControlImp shortTVSubtitleControlImp, ShortTvInnerPlayBean shortTvInnerPlayBean, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$list = list;
            this.this$0 = shortTVSubtitleControlImp;
            this.$history = shortTvInnerPlayBean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$list, this.this$0, this.$history, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            e eVar;
            e eVar2;
            e eVar3;
            e eVar4;
            e eVar5;
            e eVar6;
            String str;
            ws.a aVar;
            ws.a aVar2;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            List<ts.b> list = this.$list;
            if (list != null && !list.isEmpty()) {
                aVar = this.this$0.f53119h;
                List list2 = (List) aVar.d().f();
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.clear();
                list2.addAll(this.$list);
                a.C0856a.g(lg.a.f68962a, "checkSubtitle setList, size:" + list2.size(), false, 2, null);
                aVar2 = this.this$0.f53119h;
                aVar2.d().q(list2);
                ShortTVSubtitleControlImp shortTVSubtitleControlImp = this.this$0;
                ShortTvInnerPlayBean shortTvInnerPlayBean = this.$history;
                shortTVSubtitleControlImp.y(list2, shortTvInnerPlayBean != null ? shortTvInnerPlayBean.getSubtitleSelectId() : null);
            }
            if (m.f70597a.e()) {
                eVar = this.this$0.f53116e;
                String e11 = eVar.e();
                eVar2 = this.this$0.f53116e;
                String e12 = eVar2.e();
                eVar3 = this.this$0.f53116e;
                String str2 = e12 + "_" + eVar3.c() + "short";
                eVar4 = this.this$0.f53116e;
                ShortTVItem d11 = eVar4.d();
                String id2 = d11 != null ? d11.getId() : null;
                eVar5 = this.this$0.f53116e;
                int c11 = eVar5.c();
                eVar6 = this.this$0.f53116e;
                ShortTVItem d12 = eVar6.d();
                int se2 = d12 != null ? d12.getSe() : 0;
                str = this.this$0.f53117f;
                b.C0658b.a(com.transsion.shorttv.subtitle.manager.b.f53144a.b(), new ts.a(e11, str2, "", "", id2, c11, se2, str), null, 2, null);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVSubtitleControlImp$checkSubtitle$1(ShortTVSubtitleControlImp shortTVSubtitleControlImp, Continuation<? super ShortTVSubtitleControlImp$checkSubtitle$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTVSubtitleControlImp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVSubtitleControlImp$checkSubtitle$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTVSubtitleControlImp$checkSubtitle$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e A[RETURN] */
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
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L2b
            if (r1 == r4) goto L27
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            kotlin.ResultKt.b(r12)
            goto Le9
        L17:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1f:
            java.lang.Object r1 = r11.L$0
            com.transsion.shorttv.bean.ShortTvInnerPlayBean r1 = (com.transsion.shorttv.bean.ShortTvInnerPlayBean) r1
            kotlin.ResultKt.b(r12)
            goto L6f
        L27:
            kotlin.ResultKt.b(r12)
            goto L4f
        L2b:
            kotlin.ResultKt.b(r12)
            com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp r12 = r11.this$0
            com.transsion.shorttv.viewmodel.ShortTvViewModel r12 = com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp.t(r12)
            if (r12 == 0) goto L53
            qs.h r12 = r12.A0()
            if (r12 == 0) goto L53
            com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp r1 = r11.this$0
            js.e r1 = com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp.q(r1)
            java.lang.String r1 = r1.e()
            r11.label = r4
            java.lang.Object r12 = r12.c(r1, r11)
            if (r12 != r0) goto L4f
            return r0
        L4f:
            com.transsion.shorttv.bean.ShortTvInnerPlayBean r12 = (com.transsion.shorttv.bean.ShortTvInnerPlayBean) r12
            r1 = r12
            goto L54
        L53:
            r1 = r5
        L54:
            com.transsion.shorttv.subtitle.manager.b$a r12 = com.transsion.shorttv.subtitle.manager.b.f53144a
            com.transsion.shorttv.subtitle.manager.b r12 = r12.b()
            com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp r6 = r11.this$0
            js.e r6 = com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp.q(r6)
            java.lang.String r6 = r6.f()
            r11.L$0 = r1
            r11.label = r3
            java.lang.Object r12 = r12.a(r6, r11)
            if (r12 != r0) goto L6f
            return r0
        L6f:
            java.util.List r12 = (java.util.List) r12
            r6 = r12
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L8c
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L7d
            goto L8c
        L7d:
            com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp r6 = r11.this$0
            kotlin.jvm.functions.Function1 r6 = com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp.m(r6)
            if (r6 == 0) goto L8c
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            r6.invoke(r4)
        L8c:
            lg.a$a r4 = lg.a.f68962a
            com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp r6 = r11.this$0
            js.e r6 = com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp.q(r6)
            java.lang.String r6 = r6.f()
            com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp r7 = r11.this$0
            js.e r7 = com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp.q(r7)
            java.lang.String r7 = r7.e()
            if (r12 == 0) goto Lad
            int r8 = r12.size()
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.d(r8)
            goto Lae
        Lad:
            r8 = r5
        Lae:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "checkSubtitle subtitleResId:"
            r9.append(r10)
            r9.append(r6)
            java.lang.String r6 = ", subjectId:"
            r9.append(r6)
            r9.append(r7)
            java.lang.String r6 = ", size:"
            r9.append(r6)
            r9.append(r8)
            java.lang.String r6 = r9.toString()
            r7 = 0
            lg.a.C0856a.g(r4, r6, r7, r3, r5)
            kotlinx.coroutines.a2 r3 = kotlinx.coroutines.y0.c()
            com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$checkSubtitle$1$1 r4 = new com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$checkSubtitle$1$1
            com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp r6 = r11.this$0
            r4.<init>(r12, r6, r1, r5)
            r11.L$0 = r5
            r11.label = r2
            java.lang.Object r12 = kotlinx.coroutines.i.g(r3, r4, r11)
            if (r12 != r0) goto Le9
            return r0
        Le9:
            kotlin.Unit r12 = kotlin.Unit.f67184a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$checkSubtitle$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
