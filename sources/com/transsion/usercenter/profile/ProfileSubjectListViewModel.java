package com.transsion.usercenter.profile;

import android.app.Application;
import android.os.Bundle;
import androidx.view.u0;
import com.cloud.tmc.integration.event.EventConstants;
import com.therouter.TheRouter;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.p006enum.PostListSource;
import com.transsion.moviedetailapi.p006enum.ProfileSubSource;
import com.transsion.usercenter.profile.b;
import com.transsnet.flow.event.sync.event.PublishEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class ProfileSubjectListViewModel extends AbsSubjectListViewModel {

    /* renamed from: k, reason: collision with root package name */
    private int f57209k;

    /* renamed from: l, reason: collision with root package name */
    private String f57210l;

    /* renamed from: m, reason: collision with root package name */
    private final Lazy f57211m;

    /* renamed from: n, reason: collision with root package name */
    private final Lazy f57212n;

    /* renamed from: o, reason: collision with root package name */
    private int f57213o;

    /* renamed from: p, reason: collision with root package name */
    private String f57214p;

    /* loaded from: classes6.dex */
    static final class a implements lz.h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f57216b;

        a(String str) {
            this.f57216b = str;
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(Integer it) {
            Intrinsics.h(it, "it");
            return ProfileSubjectListViewModel.this.f57209k == 0 ? ProfileSubjectListViewModel.this.b0() ? b.a.d(ProfileSubjectListViewModel.this.a0(), this.f57216b, ProfileSubjectListViewModel.this.f57214p, ProfileSubjectListViewModel.this.Z(), null, null, 24, null) : b.a.f(ProfileSubjectListViewModel.this.a0(), this.f57216b, ProfileSubjectListViewModel.this.f57214p, ProfileSubjectListViewModel.this.Z(), null, null, 24, null) : b.a.b(ProfileSubjectListViewModel.this.a0(), this.f57216b, ProfileSubjectListViewModel.this.f57214p, ProfileSubjectListViewModel.this.Z(), null, 8, null);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends sg.a {
        b() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            ProfileSubjectListViewModel.this.y().q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(PostSubjectBean postSubjectBean) {
            String str;
            Integer perPage;
            super.c(postSubjectBean);
            if (postSubjectBean != null) {
                ProfileSubjectListViewModel profileSubjectListViewModel = ProfileSubjectListViewModel.this;
                try {
                    Pager pager = postSubjectBean.getPager();
                    profileSubjectListViewModel.h0((pager == null || (perPage = pager.getPerPage()) == null) ? 10 : perPage.intValue());
                    Pager pager2 = postSubjectBean.getPager();
                    if (pager2 == null || (str = pager2.getNextPage()) == null) {
                        str = "";
                    }
                    profileSubjectListViewModel.f57214p = str;
                } catch (Exception unused) {
                }
            }
            ProfileSubjectListViewModel.this.y().q(postSubjectBean);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSubjectListViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f57211m = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi e02;
                e02 = ProfileSubjectListViewModel.e0();
                return e02;
            }
        });
        this.f57212n = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b f02;
                f02 = ProfileSubjectListViewModel.f0();
                return f02;
            }
        });
        this.f57213o = 10;
        this.f57214p = "";
    }

    private final ILoginApi Y() {
        return (ILoginApi) this.f57211m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.usercenter.profile.b a0() {
        return (com.transsion.usercenter.profile.b) this.f57212n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b0() {
        UserInfo i11;
        String str = this.f57210l;
        if (str != null && str.length() != 0) {
            String str2 = this.f57210l;
            ILoginApi Y = Y();
            if (!Intrinsics.c(str2, (Y == null || (i11 = Y.i()) == null) ? null : i11.getUserId())) {
                return false;
            }
        }
        return true;
    }

    private final boolean c0() {
        ILoginApi Y;
        UserInfo i11;
        UserInfo i12;
        String str = this.f57210l;
        String str2 = null;
        if (str == null) {
            ILoginApi Y2 = Y();
            str = (Y2 == null || (i12 = Y2.i()) == null) ? null : i12.getUserId();
            if (str == null) {
                str = "";
            }
        }
        if (str.length() == 0) {
            return true;
        }
        ILoginApi Y3 = Y();
        if (Y3 != null && (i11 = Y3.i()) != null) {
            str2 = i11.getUserId();
        }
        return Intrinsics.c(str, str2) && ((Y = Y()) == null || !Y.a());
    }

    private final void d0(String str) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ProfileSubjectListViewModel$loadNewSubject$1(this, str, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi e0() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.usercenter.profile.b f0() {
        return (com.transsion.usercenter.profile.b) zg.c.f79537e.a().h(com.transsion.usercenter.profile.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(ProfileSubjectListViewModel profileSubjectListViewModel, PublishEvent it) {
        Intrinsics.h(it, "it");
        profileSubjectListViewModel.d0(it.getPostId());
        return Unit.f67184a;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public PostListSource A() {
        return PostListSource.PROFILE;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public ProfileSubSource B() {
        return this.f57209k == 0 ? ProfileSubSource.POSTS : ProfileSubSource.LIKES;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void E(boolean z10) {
        UserInfo i11;
        String str = this.f57210l;
        if (str == null) {
            ILoginApi Y = Y();
            str = (Y == null || (i11 = Y.i()) == null) ? null : i11.getUserId();
            if (str == null) {
                str = "";
            }
        }
        if (c0() && this.f57209k == 0) {
            y().q(null);
        } else {
            io.reactivex.rxjava3.core.j.t(Integer.valueOf(this.f57209k)).n(new a(str)).f(sg.d.f75472a.c()).subscribe(new b());
        }
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void F(Bundle bundle) {
        this.f57209k = bundle != null ? bundle.getInt(EventConstants.KEY_SOURCE) : 0;
        this.f57210l = bundle != null ? bundle.getString("userId") : null;
        if (this.f57209k == 0 && b0() && !c0()) {
            kotlinx.coroutines.k.d(u0.a(this), null, null, new ProfileSubjectListViewModel$onCreate$$inlined$observeEvent$1(false, new Function1() { // from class: com.transsion.usercenter.profile.l0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit g02;
                    g02 = ProfileSubjectListViewModel.g0(ProfileSubjectListViewModel.this, (PublishEvent) obj);
                    return g02;
                }
            }, null), 3, null);
        }
        this.f57214p = "0";
    }

    public int Z() {
        return this.f57213o;
    }

    public void h0(int i11) {
        this.f57213o = i11;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public String w(int i11) {
        return this.f57209k == 0 ? "profiledetail_posts" : "profiledetail_likes";
    }
}
