package com.transsion.postdetail.shorttv_pugc.factory;

import android.os.Build;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.postdetail.util.UGCShortTVFloatManager;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsion.videofloat.manager.a0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ox.b;
import ox.e;
import sx.a;

/* loaded from: classes6.dex */
public final class f implements st.e {

    /* loaded from: classes6.dex */
    public static final class a implements sx.a {
        a() {
        }

        @Override // sx.a
        public boolean a(px.a aVar) {
            return UGCShortTVFloatManager.f50207b.m(aVar);
        }

        @Override // sx.a
        public void b(px.a aVar) {
            a.C0946a.a(this, aVar);
            UGCShortTVFloatManager.f50207b.k(aVar);
        }

        @Override // sx.a
        public void c(px.a aVar) {
            UGCShortTVFloatManager uGCShortTVFloatManager = UGCShortTVFloatManager.f50207b;
            uGCShortTVFloatManager.j();
            uGCShortTVFloatManager.n(aVar);
        }
    }

    private final px.a j(ot.d dVar) {
        ShorttvModel.UGCVideoCollection belongToCollection;
        ShorttvModel.UGCVideoCollection belongToCollection2;
        ShorttvModel.UGCVideoCollection belongToCollection3;
        ShorttvModel.UGCVideoCollection belongToCollection4;
        px.a aVar = new px.a(dVar.g(), dVar.c(), null, FloatPlayType.SHORT_TV, "", -1, dVar.a(), "", dVar.e());
        aVar.J(Integer.valueOf(SubjectType.SHORT_TV.getValue()));
        aVar.A(dVar.b());
        aVar.B(dVar.d());
        ShorttvModel.UGCVideo h11 = dVar.h();
        String collectionId = (h11 == null || (belongToCollection4 = h11.getBelongToCollection()) == null) ? null : belongToCollection4.getCollectionId();
        ShorttvModel.UGCVideo h12 = dVar.h();
        String collectionName = (h12 == null || (belongToCollection3 = h12.getBelongToCollection()) == null) ? null : belongToCollection3.getCollectionName();
        ShorttvModel.UGCVideo h13 = dVar.h();
        Integer videoNum = (h13 == null || (belongToCollection2 = h13.getBelongToCollection()) == null) ? null : belongToCollection2.getVideoNum();
        ShorttvModel.UGCVideo h14 = dVar.h();
        UGCVideoBelongToCollection uGCVideoBelongToCollection = new UGCVideoBelongToCollection(collectionId, collectionName, videoNum, (h14 == null || (belongToCollection = h14.getBelongToCollection()) == null) ? null : belongToCollection.getPosition(), null, 16, null);
        ShorttvModel.UGCVideo h15 = dVar.h();
        String ugcVideoId = h15 != null ? h15.getUgcVideoId() : null;
        ShorttvModel.UGCVideo h16 = dVar.h();
        String title = h16 != null ? h16.getTitle() : null;
        ShorttvModel.UGCVideo h17 = dVar.h();
        String description = h17 != null ? h17.getDescription() : null;
        ShorttvModel.UGCVideo h18 = dVar.h();
        String corner = h18 != null ? h18.getCorner() : null;
        ShorttvModel.UGCVideo h19 = dVar.h();
        Long duration = h19 != null ? h19.getDuration() : null;
        ShorttvModel.UGCVideo h20 = dVar.h();
        String watchNum = h20 != null ? h20.getWatchNum() : null;
        ShorttvModel.UGCVideo h21 = dVar.h();
        String releaseDate = h21 != null ? h21.getReleaseDate() : null;
        ShorttvModel.UGCVideo h22 = dVar.h();
        Long publishTime = h22 != null ? h22.getPublishTime() : null;
        ShorttvModel.UGCVideo h23 = dVar.h();
        String category = h23 != null ? h23.getCategory() : null;
        ShorttvModel.UGCVideo h24 = dVar.h();
        String ops = h24 != null ? h24.getOps() : null;
        ShorttvModel.UGCVideo h25 = dVar.h();
        String subjectId = h25 != null ? h25.getSubjectId() : null;
        ShorttvModel.UGCVideo h26 = dVar.h();
        List<String> country = h26 != null ? h26.getCountry() : null;
        ShorttvModel.UGCVideo h27 = dVar.h();
        aVar.L(new UGCVideo(ugcVideoId, title, description, null, null, null, corner, duration, watchNum, releaseDate, publishTime, category, null, null, uGCVideoBelongToCollection, ops, subjectId, country, null, null, null, null, null, h27 != null ? h27.getRestrictKid() : 0, false, null, null, null, null, 528232504, null));
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(FragmentActivity fragmentActivity, boolean z10) {
        if (z10) {
            fragmentActivity.finish();
        }
        return Unit.f67184a;
    }

    @Override // st.e
    public void a(FragmentActivity activity, boolean z10, boolean z11, ViewGroup viewGroup) {
        Intrinsics.h(activity, "activity");
        e.a aVar = ox.e.f72320a;
        if (aVar.b().c() && com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("k_pip_enable", true)) {
            aVar.b().a(activity, true, z11, viewGroup);
        }
    }

    @Override // st.e
    public void b(FragmentActivity activity, String ugcVideoId, String pageName, String str) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        Intrinsics.h(pageName, "pageName");
        ox.b.f72314a.c().e(activity, null, ugcVideoId, pageName, str);
    }

    @Override // st.e
    public void c() {
        b.C0906b.a(ox.b.f72314a.c(), false, 1, null);
    }

    @Override // st.e
    public com.transsion.player.orplayer.g d(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return a0.f58056a.b(UGCShortTVFloatManager.f50207b.h(str));
    }

    @Override // st.e
    public boolean e(com.transsion.player.orplayer.g gVar) {
        return a0.f58056a.c(gVar);
    }

    @Override // st.e
    public boolean f(com.transsion.player.orplayer.g gVar) {
        return ox.c.f72319a.c(gVar);
    }

    @Override // st.e
    public void g(boolean z10, FragmentActivity fragmentActivity, ot.d bean) {
        Intrinsics.h(bean, "bean");
        if (z10) {
            if (fragmentActivity == null || fragmentActivity.isDestroyed() || fragmentActivity.isFinishing()) {
                return;
            }
            px.a j11 = j(bean);
            if (Build.VERSION.SDK_INT >= 31) {
                ox.e.f72320a.b().h(fragmentActivity, j11);
            }
        }
        ox.e.f72320a.b().onPipModeChanged(z10);
    }

    @Override // st.e
    public void h(final FragmentActivity activity, ot.d bean) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(bean, "bean");
        px.a j11 = j(bean);
        if (!com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("k_pip_enable", true)) {
            lg.a.f68962a.c("VideoFloat", "shottv 设置页pip开关被关闭了", true);
            return;
        }
        e.a aVar = ox.e.f72320a;
        if (aVar.b().c()) {
            lg.a.f68962a.c("VideoFloat-pip", "shottv 当前可用画中画，使用画中画播放", true);
            aVar.b().k(activity, j11, FloatActionType.HOME, false);
        } else {
            UGCShortTVFloatManager.f50207b.q(bean.f());
            ox.b.f72314a.c().g(activity, j11, false, false, new Function1() { // from class: com.transsion.postdetail.shorttv_pugc.factory.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit k11;
                    k11 = f.k(FragmentActivity.this, ((Boolean) obj).booleanValue());
                    return k11;
                }
            }, new a());
        }
    }
}
