package com.transsnet.downloader.fragment;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.memberapi.PremiumV2CheckAccessDto;
import com.transsion.memberapi.PremiumV2CheckAccessRequestBean;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initView$4$2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import ok.b;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initView$4$2", f = "DownloadReDetectorGroupMainFragment.kt", l = {TTAdConstant.AD_ID_IS_NULL_CODE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadReDetectorGroupMainFragment$initView$4$2 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadReDetectorGroupMainFragment this$0;

    /* loaded from: classes7.dex */
    public static final class a implements ok.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadReDetectorGroupMainFragment f59048a;

        a(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment) {
            this.f59048a = downloadReDetectorGroupMainFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment) {
            downloadReDetectorGroupMainFragment.T1();
            return Unit.f67184a;
        }

        @Override // ok.b
        public void a(boolean z10) {
            b.a.a(this, z10);
        }

        @Override // ok.b
        public void onFail() {
        }

        @Override // ok.b
        public void onSuccess() {
            Subject subject;
            FragmentActivity activity = this.f59048a.getActivity();
            if (activity != null) {
                final DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment = this.f59048a;
                subject = downloadReDetectorGroupMainFragment.subject;
                if (subject != null) {
                    com.transsnet.downloader.manager.f.f59601a.a().j(activity, subject, new Function0() { // from class: com.transsnet.downloader.fragment.y2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c11;
                            c11 = DownloadReDetectorGroupMainFragment$initView$4$2.a.c(DownloadReDetectorGroupMainFragment.this);
                            return c11;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadReDetectorGroupMainFragment$initView$4$2(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, Continuation<? super DownloadReDetectorGroupMainFragment$initView$4$2> continuation) {
        super(2, continuation);
        this.this$0 = downloadReDetectorGroupMainFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        r5 = r21.subject;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit g(final com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment r21, com.transsion.memberapi.PremiumV2CheckAccessDto r22) {
        /*
            r0 = r21
            r1 = 0
            if (r22 == 0) goto L10
            java.lang.Boolean r2 = r22.getHasAccess()
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r2 = kotlin.jvm.internal.Intrinsics.c(r2, r3)
            goto L11
        L10:
            r2 = r1
        L11:
            java.lang.Class<com.transsion.memberapi.IPremiumApi> r3 = com.transsion.memberapi.IPremiumApi.class
            r4 = 0
            if (r2 == 0) goto L48
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            if (r2 == 0) goto L30
            com.transsion.moviedetailapi.bean.Subject r5 = com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.h1(r21)
            if (r5 == 0) goto L30
            com.transsnet.downloader.manager.f$a r6 = com.transsnet.downloader.manager.f.f59601a
            com.transsnet.downloader.manager.f r6 = r6.a()
            com.transsnet.downloader.fragment.x2 r7 = new com.transsnet.downloader.fragment.x2
            r7.<init>()
            r6.j(r2, r5, r7)
        L30:
            com.transsion.memberapi.PremiumConsumeRequestBean r0 = new com.transsion.memberapi.PremiumConsumeRequestBean
            java.lang.String r2 = "subject_download"
            java.lang.String r5 = "free_download_count"
            r0.<init>(r2, r5, r4, r4)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object r1 = com.therouter.TheRouter.d(r3, r1)
            com.transsion.memberapi.IPremiumApi r1 = (com.transsion.memberapi.IPremiumApi) r1
            if (r1 == 0) goto Ld5
            r1.s(r0)
            goto Ld5
        L48:
            if (r22 == 0) goto L4e
            java.lang.String r4 = r22.getAction()
        L4e:
            java.lang.String r2 = "ACCESS_ACTION_VIP"
            boolean r2 = kotlin.jvm.internal.Intrinsics.c(r4, r2)
            if (r2 == 0) goto L8a
            com.transsion.baselib.helper.f r5 = com.transsion.baselib.helper.f.f43323a
            java.lang.String r6 = com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.g1(r21)
            java.lang.String r7 = com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.f1(r21)
            java.lang.String r8 = com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.i1(r21)
            java.lang.String r9 = com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.d1(r21)
            r10 = 0
            r5.f(r6, r7, r8, r9, r10)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object r1 = com.therouter.TheRouter.d(r3, r1)
            com.transsion.memberapi.IPremiumApi r1 = (com.transsion.memberapi.IPremiumApi) r1
            if (r1 == 0) goto Ld5
            java.lang.String r2 = com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.g1(r21)
            java.lang.String r3 = com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.i1(r21)
            java.lang.String r4 = com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.d1(r21)
            java.lang.String r0 = com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.f1(r21)
            r1.j(r2, r3, r0, r4)
            goto Ld5
        L8a:
            java.lang.String r2 = "ACCESS_ACTION_LOTTERY"
            boolean r2 = kotlin.jvm.internal.Intrinsics.c(r4, r2)
            if (r2 == 0) goto Ld5
            java.lang.Class<com.transsion.commercializationapi.ITaskCenterApi> r2 = com.transsion.commercializationapi.ITaskCenterApi.class
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object r1 = com.therouter.TheRouter.d(r2, r1)
            com.transsion.commercializationapi.ITaskCenterApi r1 = (com.transsion.commercializationapi.ITaskCenterApi) r1
            if (r1 == 0) goto Ld5
            com.transsion.moviedetailapi.bean.Subject r2 = com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.h1(r21)
            if (r2 == 0) goto Laa
            java.lang.String r2 = r2.getGenre()
            if (r2 != 0) goto Lac
        Laa:
            java.lang.String r2 = ""
        Lac:
            com.transsion.memberapi.MemberCheckResult r15 = new com.transsion.memberapi.MemberCheckResult
            com.transsion.memberapi.ThreeInOnePopup r16 = r22.getPopup()
            r17 = 4095(0xfff, float:5.738E-42)
            r18 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r19 = 0
            r3 = r15
            r20 = r15
            r15 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initView$4$2$a r3 = new com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initView$4$2$a
            r3.<init>(r0)
            r0 = r20
            r1.d(r2, r0, r3)
        Ld5:
            kotlin.Unit r0 = kotlin.Unit.f67184a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initView$4$2.g(com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment, com.transsion.memberapi.PremiumV2CheckAccessDto):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment) {
        downloadReDetectorGroupMainFragment.T1();
        return Unit.f67184a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadReDetectorGroupMainFragment$initView$4$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadReDetectorGroupMainFragment$initView$4$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Subject subject;
        Integer num;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            ArrayList arrayList = new ArrayList();
            copyOnWriteArrayList = this.this$0.checkedList;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(Boxing.d(((DownloadBean) it.next()).getEp()));
            }
            IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
            if (iPremiumApi != null) {
                subject = this.this$0.subject;
                String subjectId = subject != null ? subject.getSubjectId() : null;
                num = this.this$0.currentResolution;
                PremiumV2CheckAccessRequestBean premiumV2CheckAccessRequestBean = new PremiumV2CheckAccessRequestBean(subjectId, "subject_download", "free_download_count", null, null, null, arrayList, num, 56, null);
                final DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment = this.this$0;
                Function1 function1 = new Function1() { // from class: com.transsnet.downloader.fragment.w2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit g11;
                        g11 = DownloadReDetectorGroupMainFragment$initView$4$2.g(DownloadReDetectorGroupMainFragment.this, (PremiumV2CheckAccessDto) obj2);
                        return g11;
                    }
                };
                this.label = 1;
                if (iPremiumApi.q(premiumV2CheckAccessRequestBean, function1, this) == f11) {
                    return f11;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
