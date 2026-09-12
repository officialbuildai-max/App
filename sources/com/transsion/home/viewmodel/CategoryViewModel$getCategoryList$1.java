package com.transsion.home.viewmodel;

import bh.b;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.CategoryBean;
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
import kotlinx.coroutines.n0;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.CategoryViewModel$getCategoryList$1", f = "CategoryViewModel.kt", l = {32}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class CategoryViewModel$getCategoryList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $type;
    Object L$0;
    int label;
    final /* synthetic */ CategoryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryViewModel$getCategoryList$1(String str, CategoryViewModel categoryViewModel, Continuation<? super CategoryViewModel$getCategoryList$1> continuation) {
        super(2, continuation);
        this.$type = str;
        this.this$0 = categoryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CategoryViewModel$getCategoryList$1(this.$type, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((CategoryViewModel$getCategoryList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i11;
        ol.b l11;
        CategoryViewModel categoryViewModel;
        Object f11 = IntrinsicsKt.f();
        int i12 = this.label;
        try {
        } catch (Exception e11) {
            this.this$0.j().n(new BaseDto());
            e11.printStackTrace();
        }
        if (i12 == 0) {
            ResultKt.b(obj);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(NativeComponentConstants.KEY_COMPONENT_TYPE, this.$type);
            jsonObject.addProperty("page", Boxing.d(this.this$0.k()));
            i11 = this.this$0.f45843c;
            jsonObject.addProperty("perPage", Boxing.d(i11));
            b.a aVar = bh.b.f16553a;
            String jsonElement = jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            RequestBody a11 = aVar.a(jsonElement);
            if (a11 != null) {
                CategoryViewModel categoryViewModel2 = this.this$0;
                l11 = categoryViewModel2.l();
                String a12 = vg.a.f77447a.a();
                this.L$0 = categoryViewModel2;
                this.label = 1;
                obj = l11.c(a12, a11, this);
                if (obj == f11) {
                    return f11;
                }
                categoryViewModel = categoryViewModel2;
            }
            return Unit.f67184a;
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        categoryViewModel = (CategoryViewModel) this.L$0;
        ResultKt.b(obj);
        BaseDto baseDto = (BaseDto) obj;
        categoryViewModel.m((CategoryBean) baseDto.getData());
        categoryViewModel.j().n(baseDto);
        int k11 = categoryViewModel.k();
        categoryViewModel.o(k11 + 1);
        Boxing.d(k11);
        return Unit.f67184a;
    }
}
