package com.transsnet.downloader.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1", f = "DownloadMultiListFragment.kt", l = {342, 345, 348, 351, 355}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DownloadBean> $data;
    final /* synthetic */ boolean $isSelected;
    final /* synthetic */ int $size;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    final /* synthetic */ DownloadMultiListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1$2", f = "DownloadMultiListFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsnet.downloader.fragment.DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.LongRef $totalSize;
        int label;
        final /* synthetic */ DownloadMultiListFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DownloadMultiListFragment downloadMultiListFragment, Ref.LongRef longRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = downloadMultiListFragment;
            this.$totalSize = longRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$totalSize, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ny.c cVar;
            ny.c cVar2;
            com.transsnet.downloader.adapter.g gVar;
            CopyOnWriteArrayList<DownloadBean> F1;
            com.transsnet.downloader.adapter.g gVar2;
            int i11;
            com.transsnet.downloader.adapter.g gVar3;
            ny.c cVar3;
            int i12;
            int i13;
            com.transsnet.downloader.adapter.g gVar4;
            List<Object> data;
            CopyOnWriteArrayList<DownloadBean> F12;
            int i14;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (!this.this$0.isAdded() || this.this$0.isDetached() || this.this$0.isRemoving()) {
                return Unit.f67184a;
            }
            cVar = this.this$0.tabControl;
            if (cVar != null) {
                i14 = this.this$0.resolutionTabPosition;
                cVar.x(i14, Boxing.e(this.$totalSize.element));
            }
            cVar2 = this.this$0.tabControl;
            if (cVar2 != null) {
                cVar2.U(false);
            }
            gVar = this.this$0.mAdapter;
            if (gVar != null && (F1 = gVar.F1()) != null) {
                DownloadMultiListFragment downloadMultiListFragment = this.this$0;
                a.C0856a c0856a = lg.a.f68962a;
                String tag = downloadMultiListFragment.getTAG();
                Intrinsics.g(tag, "<get-TAG>(...)");
                gVar2 = downloadMultiListFragment.mAdapter;
                Integer num = null;
                Integer d11 = (gVar2 == null || (F12 = gVar2.F1()) == null) ? null : Boxing.d(F12.size());
                i11 = downloadMultiListFragment.unableSize;
                gVar3 = downloadMultiListFragment.mAdapter;
                if (gVar3 != null && (data = gVar3.getData()) != null) {
                    num = Boxing.d(data.size());
                }
                a.C0856a.v(c0856a, tag, "selectAllWithSizeGreaterThan30,checkedSize = " + d11 + ",unableSize = " + i11 + ", dataSize = " + num, false, 4, null);
                downloadMultiListFragment.o1();
                cVar3 = downloadMultiListFragment.tabControl;
                if (cVar3 != null) {
                    i12 = downloadMultiListFragment.resolutionTabPosition;
                    int size = F1.size();
                    i13 = downloadMultiListFragment.unableSize;
                    int i15 = size + i13;
                    gVar4 = downloadMultiListFragment.mAdapter;
                    Intrinsics.e(gVar4);
                    cVar3.k(i12, F1, i15 == gVar4.getData().size());
                }
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1(List<DownloadBean> list, DownloadMultiListFragment downloadMultiListFragment, boolean z10, int i11, Continuation<? super DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1> continuation) {
        super(2, continuation);
        this.$data = list;
        this.this$0 = downloadMultiListFragment;
        this.$isSelected = z10;
        this.$size = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1(this.$data, this.this$0, this.$isSelected, this.$size, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0154 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01a8 -> B:15:0x01ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01b6 -> B:16:0x01ba). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.fragment.DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
