package com.transsion.rewardscenter.task.member;

import android.widget.TextView;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes6.dex */
public final class k extends BaseTaskCommonProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(wp.a config) {
        super(config);
        Intrinsics.h(config, "config");
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public String D(MemberTaskItem item) {
        Intrinsics.h(item, "item");
        Integer durationCondition = item.getDurationCondition();
        int intValue = (durationCondition != null ? durationCondition.intValue() : 0) / 60;
        int i11 = RangesKt.i(xm.k.f78504a.I(), intValue);
        return item.getTitle() + " (" + i11 + "/" + intValue + "mins)";
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public boolean F(MemberTaskItem memberTaskItem) {
        Integer status;
        Integer durationCondition;
        return (memberTaskItem == null || (status = memberTaskItem.getStatus()) == null || status.intValue() != 3) && xm.k.f78504a.I() >= ((memberTaskItem == null || (durationCondition = memberTaskItem.getDurationCondition()) == null) ? 0 : durationCondition.intValue()) / 60;
    }

    @Override // com.transsion.rewardscenter.task.member.BaseTaskCommonProvider
    public void K(TextView button, MemberTaskItem item) {
        String str;
        Intrinsics.h(button, "button");
        Intrinsics.h(item, "item");
        String jumpUrl = item.getJumpUrl();
        if (jumpUrl == null || jumpUrl.length() == 0) {
            str = "oneroom://com.community.oneroom?type=/main/tab&tabIndex=0";
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
        return TaskType.WATCH.getValue();
    }
}
