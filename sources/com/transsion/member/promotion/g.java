package com.transsion.member.promotion;

import com.transsion.member.c0;
import java.util.Calendar;
import lg.a;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f46739a = new g();

    private g() {
    }

    private final long b(long j11) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j11);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static /* synthetic */ void e(g gVar, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = System.currentTimeMillis();
        }
        gVar.d(j11);
    }

    public final boolean a(long j11, int i11) {
        if (i11 <= 0) {
            a.C0856a.f(lg.a.f68962a, "premium_discount", "MemberPromotionDialogHelper --> canShow() --> 每日展示上限无效，maxShowCountPerDay = " + i11, false, 4, null);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long c11 = c();
        if (c11 > 0 && currentTimeMillis >= c11 && currentTimeMillis - c11 < j11) {
            a.C0856a.f(lg.a.f68962a, "premium_discount", "MemberPromotionDialogHelper --> canShow() --> 展示间隔未达到，lastShowTime = " + c11 + ", now = " + currentTimeMillis + ", showIntervalMillis = " + j11, false, 4, null);
            return false;
        }
        long b11 = b(currentTimeMillis);
        c0 c0Var = c0.f46483a;
        long j12 = c0Var.b().getLong("kv_promotion_dialog_show_window_start_time", 0L);
        if (j12 != b11) {
            a.C0856a.f(lg.a.f68962a, "premium_discount", "MemberPromotionDialogHelper --> canShow() --> 当前自然日尚无展示记录，recordedDayStartTime = " + j12 + ", currentDayStartTime = " + b11, false, 4, null);
            return true;
        }
        int i12 = c0Var.b().getInt("kv_promotion_dialog_show_count_in_window", 0);
        boolean z10 = i12 < i11;
        if (!z10) {
            a.C0856a.f(lg.a.f68962a, "premium_discount", "MemberPromotionDialogHelper --> canShow() --> 已达到每日展示上限，showCount = " + i12 + ", maxShowCountPerDay = " + i11, false, 4, null);
        }
        return z10;
    }

    public final long c() {
        return c0.f46483a.b().getLong("kv_promotion_dialog_last_show_time", 0L);
    }

    public final void d(long j11) {
        long b11 = b(j11);
        c0 c0Var = c0.f46483a;
        int i11 = 1;
        if (c0Var.b().getLong("kv_promotion_dialog_show_window_start_time", 0L) == b11) {
            i11 = 1 + c0Var.b().getInt("kv_promotion_dialog_show_count_in_window", 0);
        } else {
            c0Var.b().putLong("kv_promotion_dialog_show_window_start_time", b11);
        }
        c0Var.b().putInt("kv_promotion_dialog_show_count_in_window", i11);
        c0Var.b().putLong("kv_promotion_dialog_last_show_time", j11);
    }
}
