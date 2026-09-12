package com.hisavana.common.interfacz;

/* loaded from: classes.dex */
public interface IBidWithNotify {
    String getPayload();

    boolean isExpired();

    void notifyLoss();

    void notifyWin();
}
