package com.transsion.rewardscenter;

import com.transsion.rewardscenterapi.IRewardsCenterApi;

/* loaded from: classes6.dex */
public abstract class c {
    public static final IRewardsCenterApi a() {
        return new RewardsCenterProvider();
    }
}
