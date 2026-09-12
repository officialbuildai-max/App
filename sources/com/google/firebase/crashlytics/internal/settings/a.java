package com.google.firebase.crashlytics.internal.settings;

import com.cloud.tmc.miniutils.constant.TimeConstants;
import com.google.firebase.crashlytics.internal.common.c0;
import com.google.firebase.crashlytics.internal.settings.c;
import org.json.JSONObject;

/* loaded from: classes4.dex */
class a implements g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static c b(c0 c0Var) {
        return new c(c0Var.a() + TimeConstants.HOUR, new c.b(8, 4), new c.a(true, false, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.g
    public c a(c0 c0Var, JSONObject jSONObject) {
        return b(c0Var);
    }
}
