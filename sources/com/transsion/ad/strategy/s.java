package com.transsion.ad.strategy;

import com.transsion.ad.monopoly.model.MbAdPlansBean;

/* loaded from: classes5.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f42298a = new s();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f42299b = true;

    /* renamed from: c, reason: collision with root package name */
    private static long f42300c;

    /* renamed from: d, reason: collision with root package name */
    private static int f42301d;

    private s() {
    }

    public final int a() {
        if (f42299b) {
            f42301d = f.f42286a.b().getInt("newUserAdShieldHour", 0);
        }
        return f42301d;
    }

    public final long b() {
        if (f42299b) {
            f42300c = f.f42286a.b().getLong("userCreateTime", 0L);
        }
        return f42300c;
    }

    public final boolean c() {
        if (f42299b) {
            f fVar = f.f42286a;
            f42300c = fVar.b().getLong("userCreateTime", 0L);
            f42301d = fVar.b().getInt("newUserAdShieldHour", 0);
        }
        f42299b = false;
        return f42301d != 0 && System.currentTimeMillis() - f42300c < (((long) f42301d) * ((long) 3600)) * ((long) 1000);
    }

    public final void d(MbAdPlansBean mbAdPlansBean) {
        Integer newUserAdShieldHour;
        Long userCreateTime;
        f fVar = f.f42286a;
        fVar.b().putLong("userCreateTime", (mbAdPlansBean == null || (userCreateTime = mbAdPlansBean.getUserCreateTime()) == null) ? 0L : userCreateTime.longValue());
        fVar.b().putInt("newUserAdShieldHour", (mbAdPlansBean == null || (newUserAdShieldHour = mbAdPlansBean.getNewUserAdShieldHour()) == null) ? 0 : newUserAdShieldHour.intValue());
        f42299b = true;
        oi.a.c(oi.a.f71145a, "NewUserShieldStrategy --> saveNewUserShieldData() --> 保存新用户屏蔽数据 --> userCreateTime = " + (mbAdPlansBean != null ? mbAdPlansBean.getUserCreateTime() : null) + ", newUserAdShieldHour = " + (mbAdPlansBean != null ? mbAdPlansBean.getNewUserAdShieldHour() : null), 0, false, 2, null);
    }
}
