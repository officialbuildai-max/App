package com.transsion.usercenter.setting.viewmodel;

import com.transsion.baselib.locale.d;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.setting.viewmodel.LocaleLanguageViewModel$getList$1", f = "LocaleLanguageViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class LocaleLanguageViewModel$getList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LocaleLanguageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocaleLanguageViewModel$getList$1(LocaleLanguageViewModel localeLanguageViewModel, Continuation<? super LocaleLanguageViewModel$getList$1> continuation) {
        super(2, continuation);
        this.this$0 = localeLanguageViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocaleLanguageViewModel$getList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LocaleLanguageViewModel$getList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        d.b bVar = d.f43351f;
        Locale j11 = bVar.e().j();
        if (j11 != null) {
            LocaleLanguageViewModel localeLanguageViewModel = this.this$0;
            boolean q11 = bVar.e().q(j11);
            String language = j11.getLanguage();
            String[] g11 = bVar.g();
            String[] f11 = bVar.f();
            ArrayList arrayList = new ArrayList();
            int length = g11.length;
            int i11 = 0;
            while (i11 < length) {
                vw.a aVar = new vw.a();
                aVar.c(g11[i11]);
                aVar.e(f11[i11]);
                aVar.d(q11 ? i11 == 0 : Intrinsics.c(language, f11[i11]));
                arrayList.add(aVar);
                i11++;
            }
            localeLanguageViewModel.e().n(arrayList);
        }
        return Unit.f67184a;
    }
}
