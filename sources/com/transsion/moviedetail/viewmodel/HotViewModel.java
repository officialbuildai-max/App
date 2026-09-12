package com.transsion.moviedetail.viewmodel;

import android.app.Application;
import android.os.Bundle;
import androidx.view.b0;
import androidx.view.u0;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.PostRankType;
import com.transsion.moviedetailapi.p006enum.PostListSource;
import com.transsion.moviedetailapi.p006enum.ProfileSubSource;
import com.transsnet.flow.event.sync.event.PublishEvent;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class HotViewModel extends AbsSubjectListViewModel {

    /* renamed from: k */
    private final Lazy f47475k;

    /* renamed from: l */
    private String f47476l;

    /* renamed from: m */
    private String f47477m;

    /* renamed from: n */
    private String f47478n;

    /* renamed from: o */
    private int f47479o;

    /* renamed from: p */
    private final b0 f47480p;

    /* renamed from: q */
    private final Lazy f47481q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f47475k = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.moviedetail.viewmodel.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                fn.a j02;
                j02 = HotViewModel.j0();
                return j02;
            }
        });
        this.f47478n = "0";
        this.f47480p = new b0();
        this.f47481q = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.transsion.usercenter.profile.b h02;
                h02 = HotViewModel.h0();
                return h02;
            }
        });
    }

    public final com.transsion.usercenter.profile.b Y() {
        return (com.transsion.usercenter.profile.b) this.f47481q.getValue();
    }

    private final void a0(String str, String str2, int i11, String str3, boolean z10) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new HotViewModel$getPostSubject$1(this, str, str2, i11, str3, z10, null), 3, null);
    }

    public static /* synthetic */ void c0(HotViewModel hotViewModel, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = "1";
        }
        if ((i12 & 2) != 0) {
            i11 = 3;
        }
        hotViewModel.b0(str, i11);
    }

    public final fn.a e0() {
        return (fn.a) this.f47475k.getValue();
    }

    private final void g0(String str) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new HotViewModel$loadNewSubject$1(this, str, null), 3, null);
    }

    public static final com.transsion.usercenter.profile.b h0() {
        return (com.transsion.usercenter.profile.b) zg.c.f79537e.a().h(com.transsion.usercenter.profile.b.class);
    }

    public static final Unit i0(HotViewModel hotViewModel, PublishEvent it) {
        Intrinsics.h(it, "it");
        hotViewModel.g0(it.getPostId());
        return Unit.f67184a;
    }

    public static final fn.a j0() {
        return (fn.a) zg.c.f79537e.a().h(fn.a.class);
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public PostListSource A() {
        return PostListSource.SUBJECT;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public ProfileSubSource B() {
        return ProfileSubSource.COMMENTS;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void E(boolean z10) {
        a0(this.f47476l, this.f47478n, X(), t().getValue(), z10);
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void F(Bundle bundle) {
        if (bundle != null) {
            this.f47476l = bundle.getString("subject_id");
            this.f47477m = bundle.getString("ops");
            Serializable serializable = bundle.getSerializable("rank_type");
            Intrinsics.f(serializable, "null cannot be cast to non-null type com.transsion.moviedetailapi.PostRankType");
            M((PostRankType) serializable);
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new HotViewModel$onCreate$$inlined$observeEvent$1(false, new Function1() { // from class: com.transsion.moviedetail.viewmodel.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i02;
                i02 = HotViewModel.i0(HotViewModel.this, (PublishEvent) obj);
                return i02;
            }
        }, null), 3, null);
    }

    public int X() {
        return this.f47479o;
    }

    public final String Z() {
        return this.f47477m;
    }

    public final void b0(String page, int i11) {
        Intrinsics.h(page, "page");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new HotViewModel$getRecommendRooms$1(this, page, i11, null), 3, null);
    }

    public final b0 d0() {
        return this.f47480p;
    }

    public final String f0() {
        return this.f47476l;
    }

    public void k0(int i11) {
        this.f47479o = i11;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public String w(int i11) {
        return i11 == PostRankType.POST_RANK_TYPE_NEW.ordinal() ? "subjectdetail_new" : "subjectdetail_hot";
    }
}
