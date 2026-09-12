package com.transsnet.downloader.fragment;

import android.widget.FrameLayout;
import androidx.core.view.PointerIconCompat;
import com.transsnet.downloader.adapter.DownloadShortTvEpListAdapter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1", f = "DownloadReDetectorShortTVFragment.kt", l = {PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_GRABBING, 1024, 1027, 1032}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSelected;
    final /* synthetic */ Ref.ObjectRef<Map<Integer, my.c>> $selectMap;
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ DownloadReDetectorShortTVFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1$1", f = "DownloadReDetectorShortTVFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.IntRef $positionStart;
        int label;
        final /* synthetic */ DownloadReDetectorShortTVFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, Ref.IntRef intRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = downloadReDetectorShortTVFragment;
            this.$positionStart = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$positionStart, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            downloadShortTvEpListAdapter = this.this$0.shortTVEpAdapter;
            if (downloadShortTvEpListAdapter == null) {
                return null;
            }
            downloadShortTvEpListAdapter.notifyItemRangeChanged(this.$positionStart.element, 30);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1$2", f = "DownloadReDetectorShortTVFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.IntRef $positionStart;
        int label;
        final /* synthetic */ DownloadReDetectorShortTVFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, Ref.IntRef intRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = downloadReDetectorShortTVFragment;
            this.$positionStart = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$positionStart, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter;
            int i11;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            downloadShortTvEpListAdapter = this.this$0.shortTVEpAdapter;
            if (downloadShortTvEpListAdapter == null) {
                return null;
            }
            int i12 = this.$positionStart.element;
            i11 = this.this$0.curUnlockAllCount;
            downloadShortTvEpListAdapter.notifyItemRangeChanged(i12, i11 - this.$positionStart.element);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1$3", f = "DownloadReDetectorShortTVFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1$3, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DownloadReDetectorShortTVFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = downloadReDetectorShortTVFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FrameLayout frameLayout;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (!this.this$0.isAdded() || this.this$0.isDetached() || this.this$0.isRemoving()) {
                return Unit.f67184a;
            }
            py.f0 f0Var = (py.f0) this.this$0.getMViewBinding();
            if (f0Var != null && (frameLayout = f0Var.f72815g) != null) {
                jg.c.g(frameLayout);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, boolean z10, Ref.ObjectRef<Map<Integer, my.c>> objectRef, Continuation<? super DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadReDetectorShortTVFragment;
        this.$isSelected = z10;
        this.$selectMap = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1(this.this$0, this.$isSelected, this.$selectMap, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0143 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0199  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x018a -> B:15:0x018d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0193 -> B:16:0x0194). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
