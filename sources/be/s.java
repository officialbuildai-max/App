package be;

import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.TInnerAdRequestBody;
import com.hisavana.common.interfacz.ICacheAd;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;

/* loaded from: classes4.dex */
public class s extends c {
    public static AdCache B = new AdCache();

    public s(CloudControlConfig.CodeSeat codeSeat, i iVar, t tVar) {
        super(codeSeat, iVar, tVar);
    }

    @Override // be.c
    public AdCache G() {
        return AdCacheManager.getCache(4);
    }

    @Override // be.c
    public boolean d0() {
        return true;
    }

    @Override // be.c
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void p(BaseSplash baseSplash) {
        if (baseSplash == null || G().hasAd(this.f16444j, baseSplash)) {
            return;
        }
        baseSplash.destroyAd();
    }

    @Override // be.c
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public BaseSplash e(boolean z10) {
        ICacheAd cache = G().getCache(this.f16444j, false, V(), z10);
        this.f16443i = cache;
        if (cache == null) {
            AdLogUtil.Log().w("SplashCacheHandler", "no ad");
            return null;
        }
        G().removeCache(this.f16444j, (BaseSplash) this.f16443i);
        if (((BaseSplash) this.f16443i).isExpired()) {
            AdLogUtil.Log().w("SplashCacheHandler", "ad is expired");
            return null;
        }
        TInnerAdRequestBody d11 = d(null, 2);
        ((BaseSplash) this.f16443i).addRequestBody(d11);
        ((BaseSplash) this.f16443i).setShowId(DeviceUtil.o());
        m(d11, this.f16436b);
        return (BaseSplash) this.f16443i;
    }

    @Override // be.c
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void z(BaseSplash baseSplash) {
        if (baseSplash != null) {
            baseSplash.pauseAd();
        }
    }

    @Override // be.c
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void F(BaseSplash baseSplash) {
        if (baseSplash != null) {
            baseSplash.resumeAd();
        }
    }
}
