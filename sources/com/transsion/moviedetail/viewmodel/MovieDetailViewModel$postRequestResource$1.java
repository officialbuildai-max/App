package com.transsion.moviedetail.viewmodel;

import com.transsion.publish.model.PostEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$postRequestResource$1", f = "MovieDetailViewModel.kt", l = {259}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class MovieDetailViewModel$postRequestResource$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $before;
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ MovieDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/publish/model/PostEntity;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$postRequestResource$1$1", f = "MovieDetailViewModel.kt", l = {251, 253, 255}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$postRequestResource$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $before;
        final /* synthetic */ String $subjectId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MovieDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, boolean z10, MovieDetailViewModel movieDetailViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$subjectId = str;
            this.$before = z10;
            this.this$0 = movieDetailViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$subjectId, this.$before, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r8.label
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L28
                if (r1 == r4) goto L20
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                goto L1b
            L13:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1b:
                kotlin.ResultKt.b(r9)
                goto L9d
            L20:
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                kotlin.ResultKt.b(r9)
                goto L6f
            L28:
                kotlin.ResultKt.b(r9)
                java.lang.Object r9 = r8.L$0
                r1 = r9
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                com.google.gson.JsonObject r9 = new com.google.gson.JsonObject
                r9.<init>()
                java.lang.String r6 = "subjectId"
                java.lang.String r7 = r8.$subjectId
                r9.addProperty(r6, r7)
                boolean r6 = r8.$before
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r6)
                java.lang.String r7 = "before"
                r9.addProperty(r7, r6)
                bh.b$a r6 = bh.b.f16553a
                java.lang.String r9 = r9.toString()
                java.lang.String r7 = "toString(...)"
                kotlin.jvm.internal.Intrinsics.g(r9, r7)
                okhttp3.RequestBody r9 = r6.a(r9)
                if (r9 == 0) goto L72
                com.transsion.moviedetail.viewmodel.MovieDetailViewModel r6 = r8.this$0
                fn.a r6 = com.transsion.moviedetail.viewmodel.MovieDetailViewModel.n(r6)
                vg.a$a r7 = vg.a.f77447a
                java.lang.String r7 = r7.a()
                r8.L$0 = r1
                r8.label = r4
                java.lang.Object r9 = r6.f(r7, r9, r8)
                if (r9 != r0) goto L6f
                return r0
            L6f:
                com.tn.lib.net.bean.BaseDto r9 = (com.tn.lib.net.bean.BaseDto) r9
                goto L73
            L72:
                r9 = r5
            L73:
                if (r9 == 0) goto L7a
                java.lang.String r4 = r9.getCode()
                goto L7b
            L7a:
                r4 = r5
            L7b:
                java.lang.String r6 = "0"
                boolean r4 = kotlin.jvm.internal.Intrinsics.c(r4, r6)
                if (r4 != 0) goto L8e
                r8.L$0 = r5
                r8.label = r3
                java.lang.Object r9 = r1.emit(r5, r8)
                if (r9 != r0) goto L9d
                return r0
            L8e:
                java.lang.Object r9 = r9.getData()
                r8.L$0 = r5
                r8.label = r2
                java.lang.Object r9 = r1.emit(r9, r8)
                if (r9 != r0) goto L9d
                return r0
            L9d:
                kotlin.Unit r9 = kotlin.Unit.f67184a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$postRequestResource$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/publish/model/PostEntity;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$postRequestResource$1$2", f = "MovieDetailViewModel.kt", l = {258}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$postRequestResource$1$2, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.c, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = cVar;
            return anonymousClass2.invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.c cVar = (kotlinx.coroutines.flow.c) this.L$0;
                this.label = 1;
                if (cVar.emit(null, this) == f11) {
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
    /* loaded from: classes6.dex */
    public static final class a implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MovieDetailViewModel f47503a;

        a(MovieDetailViewModel movieDetailViewModel) {
            this.f47503a = movieDetailViewModel;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(PostEntity postEntity, Continuation continuation) {
            this.f47503a.H().n(postEntity);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieDetailViewModel$postRequestResource$1(String str, boolean z10, MovieDetailViewModel movieDetailViewModel, Continuation<? super MovieDetailViewModel$postRequestResource$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$before = z10;
        this.this$0 = movieDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieDetailViewModel$postRequestResource$1(this.$subjectId, this.$before, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MovieDetailViewModel$postRequestResource$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.$subjectId, this.$before, this.this$0, null)), new AnonymousClass2(null));
            a aVar = new a(this.this$0);
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
