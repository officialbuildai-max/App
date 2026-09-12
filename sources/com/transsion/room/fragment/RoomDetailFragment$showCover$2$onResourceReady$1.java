package com.transsion.room.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import com.google.android.material.imageview.ShapeableImageView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1", f = "RoomDetailFragment.kt", l = {599}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class RoomDetailFragment$showCover$2$onResourceReady$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $resource;
    int label;
    final /* synthetic */ RoomDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Landroid/graphics/Bitmap;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$1", f = "RoomDetailFragment.kt", l = {594}, m = "invokeSuspend")
    /* renamed from: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $resource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Bitmap bitmap, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$resource = bitmap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$resource, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.c cVar = (kotlinx.coroutines.flow.c) this.L$0;
                Bitmap bitmap = this.$resource;
                this.label = 1;
                if (cVar.emit(bitmap, this) == f11) {
                    return f11;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$3", f = "RoomDetailFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$3, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.c, Throwable, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Throwable th2, Continuation<? super Unit> continuation) {
            return new AnonymousClass3(continuation).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoomDetailFragment f51479a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f51480b;

        a(RoomDetailFragment roomDetailFragment, Bitmap bitmap) {
            this.f51479a = roomDetailFragment;
            this.f51480b = bitmap;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Bitmap bitmap, Continuation continuation) {
            ShapeableImageView shapeableImageView;
            ShapeableImageView shapeableImageView2;
            ShapeableImageView shapeableImageView3;
            if (!this.f51479a.isAdded() || this.f51479a.isRemoving() || this.f51479a.isDetached()) {
                return Unit.f67184a;
            }
            bq.n mViewBinding = this.f51479a.getMViewBinding();
            if (mViewBinding != null) {
                mViewBinding.f16880d.setBackground(new BitmapDrawable(this.f51479a.getResources(), bitmap));
                ViewGroup.LayoutParams layoutParams = mViewBinding.f16879c.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = mViewBinding.f16880d.getMeasuredHeight();
                }
                mViewBinding.f16879c.setLayoutParams(layoutParams);
            }
            if (this.f51480b.getHeight() < com.blankj.utilcode.util.a0.a(56.0f)) {
                bq.n mViewBinding2 = this.f51479a.getMViewBinding();
                if (mViewBinding2 != null && (shapeableImageView3 = mViewBinding2.f16885i) != null) {
                    shapeableImageView3.setImageBitmap(bitmap);
                }
                bq.n mViewBinding3 = this.f51479a.getMViewBinding();
                if (mViewBinding3 != null && (shapeableImageView2 = mViewBinding3.f16885i) != null) {
                    jg.c.k(shapeableImageView2);
                }
            } else {
                bq.n mViewBinding4 = this.f51479a.getMViewBinding();
                if (mViewBinding4 != null && (shapeableImageView = mViewBinding4.f16885i) != null) {
                    jg.c.g(shapeableImageView);
                }
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDetailFragment$showCover$2$onResourceReady$1(Bitmap bitmap, RoomDetailFragment roomDetailFragment, Continuation<? super RoomDetailFragment$showCover$2$onResourceReady$1> continuation) {
        super(2, continuation);
        this.$resource = bitmap;
        this.this$0 = roomDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomDetailFragment$showCover$2$onResourceReady$1(this.$resource, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((RoomDetailFragment$showCover$2$onResourceReady$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            final kotlinx.coroutines.flow.b s11 = kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.$resource, null));
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(new kotlinx.coroutines.flow.b() { // from class: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1

                /* renamed from: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: classes6.dex */
                public static final class AnonymousClass2 implements kotlinx.coroutines.flow.c {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ kotlinx.coroutines.flow.c f51473a;

                    @Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
                    @DebugMetadata(c = "com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1$2", f = "RoomDetailFragment.kt", l = {50}, m = "emit")
                    /* renamed from: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    /* loaded from: classes6.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(kotlinx.coroutines.flow.c cVar) {
                        this.f51473a = cVar;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.c
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r7
                            com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.b(r7)
                            goto L48
                        L29:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L31:
                            kotlin.ResultKt.b(r7)
                            kotlinx.coroutines.flow.c r7 = r5.f51473a
                            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
                            r2 = 50
                            r4 = 0
                            android.graphics.Bitmap r6 = hg.b.a(r6, r2, r4)
                            r0.label = r3
                            java.lang.Object r6 = r7.emit(r6, r0)
                            if (r6 != r1) goto L48
                            return r1
                        L48:
                            kotlin.Unit r6 = kotlin.Unit.f67184a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.b
                public Object a(kotlinx.coroutines.flow.c cVar, Continuation continuation) {
                    Object a11 = kotlinx.coroutines.flow.b.this.a(new AnonymousClass2(cVar), continuation);
                    return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
                }
            }, kotlinx.coroutines.y0.a()), new AnonymousClass3(null));
            a aVar = new a(this.this$0, this.$resource);
            this.label = 1;
            if (f12.a(aVar, this) == f11) {
                return f11;
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
