package com.transsion.api.gateway.config;

import android.text.TextUtils;
import com.transsion.api.gateway.bean.RemoteConfig;
import com.transsion.api.gateway.config.a;
import com.transsion.api.gateway.utils.ContextUtils;
import com.transsion.api.gateway.utils.GatewayUtils;
import com.transsion.api.gateway.utils.SafeStringUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class b {
    private static volatile b INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    public a f42568a;

    public b() {
        new AtomicBoolean(false);
        try {
            b();
        } catch (Exception unused) {
        }
    }

    public static b a() {
        if (INSTANCE == null) {
            synchronized (b.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new b();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public void b() {
        if (this.f42568a != null) {
            return;
        }
        SafeStringUtils.getInstance(ContextUtils.getContext()).getLong(SafeStringUtils.SP_LAST_CONFIG_SYNC_TIME);
        String string = SafeStringUtils.getInstance(ContextUtils.getContext()).getString(SafeStringUtils.SP_CONFIG);
        if (!TextUtils.isEmpty(string)) {
            GatewayUtils.L.d(" load from cache");
            try {
                a aVar = new a(new a.C0602a(new a(new a.C0602a())).a((RemoteConfig) com.transsion.json.b.a(string, RemoteConfig.class)));
                if (aVar.f42549d > 0) {
                    this.f42568a = aVar;
                }
                GatewayUtils.L.d(" load from cache success" + this.f42568a.toString());
                return;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        GatewayUtils.L.d(" set config");
        this.f42568a = new a(new a.C0602a(new a(new a.C0602a())));
    }
}
