package com.transsnet.downloader.viewmodel;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadViewModel$getDownloadedList$1", f = "DownloadViewModel.kt", l = {Sdk$SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadViewModel$getDownloadedList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromDb;
    int label;
    final /* synthetic */ DownloadViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadViewModel$getDownloadedList$1(boolean z10, DownloadViewModel downloadViewModel, Continuation<? super DownloadViewModel$getDownloadedList$1> continuation) {
        super(2, continuation);
        this.$fromDb = z10;
        this.this$0 = downloadViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewModel$getDownloadedList$1(this.$fromDb, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadViewModel$getDownloadedList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object A;
        String str;
        androidx.view.b0 b0Var;
        androidx.view.b0 b0Var2;
        String str2;
        androidx.view.b0 b0Var3;
        androidx.view.b0 b0Var4;
        Map D;
        DownloadBean o02;
        Object obj2;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
            boolean z10 = this.$fromDb;
            this.label = 1;
            A = a11.A(z10, this);
            if (A == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            A = obj;
        }
        List<DownloadBean> list = (List) A;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            a.C0856a c0856a = lg.a.f68962a;
            str = this.this$0.f60164a;
            Intrinsics.g(str, "access$getTAG$p(...)");
            a.C0856a.r(c0856a, str, new String[]{"getDownloadedList, is empty"}, false, 4, null);
            b0Var = this.this$0.f60179p;
            b0Var.n(new ArrayList());
            b0Var2 = this.this$0.f60180q;
            b0Var2.n(MapsKt.h());
            return Unit.f67184a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (true) {
            String str3 = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            DownloadBean downloadBean = (DownloadBean) next;
            String subjectId = downloadBean.getSubjectId();
            if (subjectId == null || StringsKt.q0(subjectId)) {
                subjectId = null;
            }
            String ugcVideoCollectionId = downloadBean.getUgcVideoCollectionId();
            if (ugcVideoCollectionId != null && !StringsKt.q0(ugcVideoCollectionId)) {
                str3 = ugcVideoCollectionId;
            }
            if (subjectId != null) {
                obj2 = "subject:" + subjectId;
            } else if (str3 != null) {
                obj2 = "collection:" + str3;
            } else {
                obj2 = new Object();
            }
            Object obj3 = linkedHashMap.get(obj2);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(obj2, obj3);
            }
            ((List) obj3).add(next);
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (DownloadBean downloadBean2 : list) {
            String subjectId2 = downloadBean2.getSubjectId();
            if (subjectId2 == null || StringsKt.q0(subjectId2)) {
                subjectId2 = null;
            }
            String ugcVideoCollectionId2 = downloadBean2.getUgcVideoCollectionId();
            if (ugcVideoCollectionId2 == null || StringsKt.q0(ugcVideoCollectionId2)) {
                ugcVideoCollectionId2 = null;
            }
            if (subjectId2 == null && ugcVideoCollectionId2 == null) {
                arrayList.add(downloadBean2);
            } else {
                String str4 = subjectId2 != null ? "subject:" + subjectId2 : "collection:" + ugcVideoCollectionId2;
                if (!linkedHashSet.contains(str4)) {
                    List list3 = (List) linkedHashMap.get(str4);
                    List list4 = list3;
                    if (list4 != null && !list4.isEmpty()) {
                        if (list3.size() == 1) {
                            arrayList.addAll(list3);
                        } else {
                            o02 = this.this$0.o0(list3);
                            arrayList.add(o02);
                        }
                    }
                    linkedHashSet.add(str4);
                }
            }
        }
        a.C0856a c0856a2 = lg.a.f68962a;
        str2 = this.this$0.f60164a;
        Intrinsics.g(str2, "access$getTAG$p(...)");
        a.C0856a.r(c0856a2, str2, new String[]{"getDownloadedList, size = " + arrayList.size()}, false, 4, null);
        b0Var3 = this.this$0.f60179p;
        b0Var3.n(arrayList);
        b0Var4 = this.this$0.f60180q;
        D = this.this$0.D(arrayList);
        b0Var4.n(D);
        return Unit.f67184a;
    }
}
