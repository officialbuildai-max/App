package com.mbridge.msdk.videocommon.download;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f39974a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f39975b;

    /* loaded from: classes5.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final j f39976a = new j();
    }

    private j() {
    }

    public static j a() {
        return b.f39976a;
    }

    public boolean a(int i11) {
        if (MBridgeConstans.DEBUG) {
            o0.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i11 + ", key: REWARD_VIDEO_REFACTOR_FOR_CAMPAIGN_REQUEST");
        }
        if (i11 != 94 && i11 != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.f39975b;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.f39975b = new AtomicBoolean(q0.a().a("r_v_r_f_c_r", false));
        } catch (Exception e11) {
            this.f39975b = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e11.getMessage());
            }
        }
        return this.f39975b.get();
    }

    public boolean b(int i11) {
        if (MBridgeConstans.DEBUG) {
            o0.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i11 + ", key: REWARD_VIDEO_REFACTOR_FOR_LOAD");
        }
        if (i11 != 94 && i11 != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.f39974a;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.f39974a = new AtomicBoolean(q0.a().a("r_v_r_f_l", false));
        } catch (Exception e11) {
            this.f39974a = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e11.getMessage());
            }
        }
        return this.f39974a.get();
    }
}
