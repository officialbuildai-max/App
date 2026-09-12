package com.transsion.player.longvideo.member;

import android.app.Application;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.ps.activate.PSActivateManager;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.member.MemberResolutionDao;
import com.transsion.memberapi.MemberSource;
import com.transsion.wrapperad.activate.ui.LongVodActivateDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class ResolutionMemberManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ResolutionMemberManager f48259a = new ResolutionMemberManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f48260b = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.member.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MemberResolutionDao g11;
            g11 = ResolutionMemberManager.g();
            return g11;
        }
    });

    private ResolutionMemberManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d() {
        String simpleName = ResolutionMemberManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MemberResolutionDao e() {
        return (MemberResolutionDao) f48260b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemberResolutionDao g() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).s1();
    }

    public final Object f(go.a aVar, Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.b(), new ResolutionMemberManager$isVipResolutionTip$2(aVar, null), continuation);
    }

    public final void h(FragmentManager fragmentManager, MemberSource from, final go.a aVar, String str, final zx.e eVar) {
        Intrinsics.h(fragmentManager, "fragmentManager");
        Intrinsics.h(from, "from");
        if (yx.a.f79208a.k(from)) {
            a.C0856a.g(lg.a.f68962a, d() + " --> showRewardDialog() --> 解锁高清视频播放权限开关关闭 --> from = " + from, false, 2, null);
            return;
        }
        if (PSActivateManager.f42225a.d()) {
            LongVodActivateDialog longVodActivateDialog = new LongVodActivateDialog();
            longVodActivateDialog.v0(new zx.e() { // from class: com.transsion.player.longvideo.member.ResolutionMemberManager$showRewardDialog$1$1
                @Override // zx.e
                public void a(boolean z10) {
                    kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new ResolutionMemberManager$showRewardDialog$1$1$onActivate$1(z10, go.a.this, eVar, null), 3, null);
                }
            });
            longVodActivateDialog.r0(from, str);
            longVodActivateDialog.show(fragmentManager, "解锁高清视频播放权限");
            return;
        }
        a.C0856a.g(lg.a.f68962a, d() + " --> showRewardDialog() --> 没有激励广告，无法解锁高清视频播放权限 --> from = " + from, false, 2, null);
        if (eVar != null) {
            eVar.a(false);
        }
    }

    public final Object i(go.a aVar, Continuation continuation) {
        Object g11;
        return (aVar != null && (g11 = kotlinx.coroutines.i.g(y0.b(), new ResolutionMemberManager$unlock$2(aVar, null), continuation)) == IntrinsicsKt.f()) ? g11 : Unit.f67184a;
    }

    public final Object j(go.a aVar, Continuation continuation) {
        Object g11;
        return (aVar != null && (g11 = kotlinx.coroutines.i.g(y0.b(), new ResolutionMemberManager$updateVipResolutionTip$2(aVar, null), continuation)) == IntrinsicsKt.f()) ? g11 : Unit.f67184a;
    }
}
