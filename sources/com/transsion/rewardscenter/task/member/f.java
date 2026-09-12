package com.transsion.rewardscenter.task.member;

import android.widget.TextView;
import com.tn.lib.widget.R$string;
import com.transsion.member.c0;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f extends BaseTaskCommonProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(wp.a config) {
        super(config);
        Intrinsics.h(config, "config");
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public boolean F(MemberTaskItem memberTaskItem) {
        Integer status;
        return (memberTaskItem == null || (status = memberTaskItem.getStatus()) == null || status.intValue() != 3) && xm.k.f78504a.C() > 0;
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void G() {
        xm.k.f78504a.v();
        c0.f46483a.b().putLong("kv_game_download_app_claim_item", System.currentTimeMillis());
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void K(TextView button, MemberTaskItem item) {
        String str;
        Intrinsics.h(button, "button");
        Intrinsics.h(item, "item");
        if (System.currentTimeMillis() - c0.f46483a.b().getLong("kv_game_download_app_claim_item", 0L) <= (item.getTimeInterval() != null ? r7.intValue() : 0) * 1000) {
            uh.b.f76876a.e(k().getString(R$string.try_again));
            return;
        }
        String jumpUrl = item.getJumpUrl();
        if (jumpUrl == null || jumpUrl.length() == 0) {
            str = "oneroom://com.community.oneroom?type=/main/tab&bottomTab=home&topTab=Game";
        } else {
            str = item.getJumpUrl();
            if (str == null) {
                str = "";
            }
        }
        zj.b.d(zj.b.f79550a, k(), str, null, 4, null);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return TaskType.GAME_RES_APP_DOWNLOAD.getValue();
    }
}
