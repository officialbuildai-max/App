package com.transsion.room.viewmodel;

import android.app.Application;
import android.os.Bundle;
import androidx.view.u0;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.PostRankType;
import com.transsion.moviedetailapi.p006enum.PostListSource;
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
public final class RoomHotViewModel extends AbsSubjectListViewModel {

    /* renamed from: k, reason: collision with root package name */
    private int f51882k;

    /* renamed from: l, reason: collision with root package name */
    private final Lazy f51883l;

    /* renamed from: m, reason: collision with root package name */
    private String f51884m;

    /* renamed from: n, reason: collision with root package name */
    private String f51885n;

    /* renamed from: o, reason: collision with root package name */
    private final Lazy f51886o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomHotViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f51882k = 10;
        this.f51883l = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.room.viewmodel.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                eq.a d02;
                d02 = RoomHotViewModel.d0();
                return d02;
            }
        });
        this.f51885n = "0";
        this.f51886o = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.transsion.usercenter.profile.b b02;
                b02 = RoomHotViewModel.b0();
                return b02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.usercenter.profile.b X() {
        return (com.transsion.usercenter.profile.b) this.f51886o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final eq.a Z() {
        return (eq.a) this.f51883l.getValue();
    }

    private final void a0(String str) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomHotViewModel$loadNewSubject$1(this, str, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.usercenter.profile.b b0() {
        return (com.transsion.usercenter.profile.b) zg.c.f79537e.a().h(com.transsion.usercenter.profile.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(RoomHotViewModel roomHotViewModel, PublishEvent it) {
        Intrinsics.h(it, "it");
        roomHotViewModel.a0(it.getPostId());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final eq.a d0() {
        return (eq.a) zg.c.f79537e.a().h(eq.a.class);
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public PostListSource A() {
        return PostListSource.ROOM;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void E(boolean z10) {
        Y(this.f51884m, this.f51885n, W(), t().getValue(), z10);
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void F(Bundle bundle) {
        if (bundle != null) {
            this.f51884m = bundle.getString("subject_id");
            Serializable serializable = bundle.getSerializable("rank_type");
            Intrinsics.f(serializable, "null cannot be cast to non-null type com.transsion.moviedetailapi.PostRankType");
            M((PostRankType) serializable);
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomHotViewModel$onCreate$$inlined$observeEvent$1(false, new Function1() { // from class: com.transsion.room.viewmodel.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit c02;
                c02 = RoomHotViewModel.c0(RoomHotViewModel.this, (PublishEvent) obj);
                return c02;
            }
        }, null), 3, null);
    }

    public int W() {
        return this.f51882k;
    }

    public final void Y(String str, String page, int i11, String sortType, boolean z10) {
        Intrinsics.h(page, "page");
        Intrinsics.h(sortType, "sortType");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomHotViewModel$getPostSubject$1(this, str, page, i11, sortType, z10, null), 3, null);
    }

    public void e0(int i11) {
        this.f51882k = i11;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public String w(int i11) {
        return i11 == PostRankType.POST_RANK_TYPE_NEW.ordinal() ? "roomdetail_new" : "roomdetail_hot";
    }
}
