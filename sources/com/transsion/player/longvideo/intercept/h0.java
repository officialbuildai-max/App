package com.transsion.player.longvideo.intercept;

import com.therouter.TheRouter;
import com.transsion.baselib.db.download.VipInfo;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final h0 f48193a = new h0();

    private h0() {
    }

    public final int a(Subject subject) {
        VipInfo vipInfo;
        Integer freeEpisodeCount;
        if (subject == null || (vipInfo = subject.getVipInfo()) == null || (freeEpisodeCount = vipInfo.getFreeEpisodeCount()) == null) {
            return 0;
        }
        return freeEpisodeCount.intValue();
    }

    public final int b(Subject subject) {
        VipInfo vipInfo;
        Integer requireMemberType;
        Integer previewSeconds;
        if (subject == null || (vipInfo = subject.getVipInfo()) == null || (requireMemberType = vipInfo.getRequireMemberType()) == null || requireMemberType.intValue() != 1) {
            IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
            if (iPremiumApi != null) {
                return iPremiumApi.w();
            }
            return 300000;
        }
        VipInfo vipInfo2 = subject.getVipInfo();
        if (vipInfo2 == null || (previewSeconds = vipInfo2.getPreviewSeconds()) == null) {
            return 300000;
        }
        return previewSeconds.intValue();
    }

    public final boolean c(Subject subject, int i11) {
        VipInfo vipInfo;
        Integer freeEpisodeCount;
        return ((subject == null || (vipInfo = subject.getVipInfo()) == null || (freeEpisodeCount = vipInfo.getFreeEpisodeCount()) == null) ? 0 : freeEpisodeCount.intValue()) > i11;
    }

    public final boolean d(Subject subject) {
        if (!(subject != null ? subject.isMovieType() : false)) {
            if (!(subject != null ? subject.isTvType() : false)) {
                return false;
            }
        }
        return true;
    }

    public final boolean e(Subject subject, String str) {
        int i11;
        VipInfo vipInfo;
        Integer requireMemberType;
        List S0;
        Integer num;
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        int t11 = iPremiumApi != null ? iPremiumApi.t() : 720;
        if (str != null && (S0 = StringsKt.S0(str, new String[]{","}, false, 0, 6, null)) != null) {
            Iterator it = S0.iterator();
            if (it.hasNext()) {
                Integer valueOf = Integer.valueOf(com.transsion.player.longvideo.member.q.f48287a.e(StringsKt.n1((String) it.next()).toString()));
                while (it.hasNext()) {
                    Integer valueOf2 = Integer.valueOf(com.transsion.player.longvideo.member.q.f48287a.e(StringsKt.n1((String) it.next()).toString()));
                    if (valueOf.compareTo(valueOf2) < 0) {
                        valueOf = valueOf2;
                    }
                }
                num = valueOf;
            } else {
                num = null;
            }
            if (num != null) {
                i11 = num.intValue();
                return (subject == null && (vipInfo = subject.getVipInfo()) != null && (requireMemberType = vipInfo.getRequireMemberType()) != null && requireMemberType.intValue() == 1) || i11 >= t11;
            }
        }
        i11 = 0;
        if (subject == null) {
        }
    }

    public final boolean f(Subject subject) {
        VipInfo vipInfo;
        Integer requireMemberType;
        return (subject == null || (vipInfo = subject.getVipInfo()) == null || (requireMemberType = vipInfo.getRequireMemberType()) == null || requireMemberType.intValue() != 1) ? false : true;
    }
}
