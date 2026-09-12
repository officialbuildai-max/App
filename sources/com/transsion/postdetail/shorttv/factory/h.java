package com.transsion.postdetail.shorttv.factory;

import android.content.Context;
import android.content.Intent;
import com.therouter.TheRouter;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class h implements qs.i {
    private final ILoginApi c() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    @Override // qs.i
    public boolean a() {
        ILoginApi c11 = c();
        return c11 != null && c11.a();
    }

    @Override // qs.i
    public Intent b(Context context) {
        Intrinsics.h(context, "context");
        ILoginApi c11 = c();
        if (c11 != null) {
            return c11.o(context);
        }
        return null;
    }

    @Override // qs.i
    public String getUserId() {
        UserInfo i11;
        ILoginApi c11 = c();
        if (c11 == null || (i11 = c11.i()) == null) {
            return null;
        }
        return i11.getUserId();
    }
}
