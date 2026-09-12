package com.transsion.postdetail.shorttv_pugc.factory;

import com.transsion.mb.config.manager.ConfigBean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import lg.a;

/* loaded from: classes6.dex */
public final class b implements st.b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f49355a = new a(null);

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // st.b
    public String a() {
        ConfigBean c11 = sm.f.f75530c.a().c("shorts_unlock_config", true);
        String value = c11 != null ? c11.getValue() : null;
        a.C0856a.f(lg.a.f68962a, "ShortTv", "getUnlockConfig config：" + value, false, 4, null);
        return value;
    }
}
