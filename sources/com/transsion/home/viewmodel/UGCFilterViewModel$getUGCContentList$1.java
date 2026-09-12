package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.RefreshBaseDto;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCContentList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.UGCFilterViewModel$getUGCContentList$1", f = "UGCFilterViewModel.kt", l = {102}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class UGCFilterViewModel$getUGCContentList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $categoryLve2;
    final /* synthetic */ Integer $categoryLve3;
    final /* synthetic */ Integer $categoryLve4;
    final /* synthetic */ String $finallyCateGory;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ int $page;
    final /* synthetic */ int $perPage;
    final /* synthetic */ String $selectGrade;
    final /* synthetic */ String $sort;
    int label;
    final /* synthetic */ UGCFilterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCFilterViewModel$getUGCContentList$1(String str, int i11, String str2, Integer num, Integer num2, Integer num3, boolean z10, UGCFilterViewModel uGCFilterViewModel, int i12, String str3, Continuation<? super UGCFilterViewModel$getUGCContentList$1> continuation) {
        super(2, continuation);
        this.$finallyCateGory = str;
        this.$page = i11;
        this.$sort = str2;
        this.$categoryLve2 = num;
        this.$categoryLve3 = num2;
        this.$categoryLve4 = num3;
        this.$isRefresh = z10;
        this.this$0 = uGCFilterViewModel;
        this.$perPage = i12;
        this.$selectGrade = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCFilterViewModel$getUGCContentList$1(this.$finallyCateGory, this.$page, this.$sort, this.$categoryLve2, this.$categoryLve3, this.$categoryLve4, this.$isRefresh, this.this$0, this.$perPage, this.$selectGrade, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCFilterViewModel$getUGCContentList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        ol.c cVar;
        Object d11;
        List<UGCContent> items;
        List<UGCContent> list;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        ?? r11 = ", sort=";
        String str3 = "UGCFilterViewModel";
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                lg.a.f68962a.c("UGCFilterViewModel", "getUGCContentList: category=" + this.$finallyCateGory + ", page=" + this.$page + ", sort=" + this.$sort + ", lv2=" + this.$categoryLve2 + ", lv3=" + this.$categoryLve3 + ", lv4=" + this.$categoryLve4 + ", isRefresh=" + this.$isRefresh, false);
                cVar = this.this$0.f45924e;
                String a11 = vg.a.f77447a.a();
                String str4 = this.$finallyCateGory;
                int i12 = this.$page;
                int i13 = this.$perPage;
                String str5 = this.$sort;
                Integer num = this.$categoryLve2;
                Integer num2 = this.$categoryLve3;
                Integer num3 = this.$categoryLve4;
                String str6 = this.$selectGrade;
                this.label = 1;
                str = "UGCFilterViewModel";
                str3 = str6;
                str2 = ", sort=";
                UGCFilterViewModel$getUGCContentList$1 uGCFilterViewModel$getUGCContentList$1 = this;
                try {
                    d11 = cVar.d(a11, str4, i12, i13, str5, num, num2, num3, str3, uGCFilterViewModel$getUGCContentList$1);
                    r11 = uGCFilterViewModel$getUGCContentList$1;
                    if (d11 == f11) {
                        return f11;
                    }
                } catch (Exception e11) {
                    e = e11;
                    e.printStackTrace();
                    this.this$0.o().n(null);
                    lg.a.f68962a.i(str, "getUGCContentList error: " + e.getMessage() + ", page=" + this.$page + str2 + this.$sort, true);
                    return Unit.f67184a;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                d11 = obj;
                str = "UGCFilterViewModel";
                str2 = ", sort=";
                r11 = r11;
            }
            BaseDto baseDto = (BaseDto) d11;
            UGCContentList uGCContentList = (UGCContentList) baseDto.getData();
            if (uGCContentList != null) {
                List<UGCContent> items2 = uGCContentList.getItems();
                if (items2 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : items2) {
                        UGCContent uGCContent = (UGCContent) obj2;
                        if (Intrinsics.c(uGCContent.getTopicType(), "UGC_VIDEO") && uGCContent.getVideo() != null) {
                            arrayList.add(obj2);
                        }
                    }
                    list = CollectionsKt.U0(arrayList);
                } else {
                    list = null;
                }
                uGCContentList.setItems(list);
            }
            String msg = baseDto.getMsg();
            String str7 = msg == null ? "" : msg;
            String code = baseDto.getCode();
            String str8 = code == null ? "" : code;
            String reason = baseDto.getReason();
            this.this$0.o().n(new RefreshBaseDto(str7, str8, uGCContentList, reason == null ? "" : reason, this.$isRefresh));
            a.C0856a c0856a = lg.a.f68962a;
            int i14 = this.$page;
            String str9 = this.$sort;
            UGCContentList uGCContentList2 = (UGCContentList) baseDto.getData();
            c0856a.c(str, "getUGCContentList success: page=" + i14 + str2 + str9 + ", size=" + ((uGCContentList2 == null || (items = uGCContentList2.getItems()) == null) ? 0 : items.size()), false);
        } catch (Exception e12) {
            e = e12;
            str = str3;
            str2 = r11;
        }
        return Unit.f67184a;
    }
}
