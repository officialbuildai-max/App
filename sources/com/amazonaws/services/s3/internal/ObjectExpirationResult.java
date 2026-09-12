package com.amazonaws.services.s3.internal;

import java.util.Date;

/* loaded from: classes2.dex */
public interface ObjectExpirationResult {
    void setExpirationTime(Date date);

    void setExpirationTimeRuleId(String str);
}
