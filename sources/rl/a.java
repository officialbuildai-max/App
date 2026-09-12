package rl;

import com.transsion.mb.config.manager.ConfigBean;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f74668a = new a();

    private a() {
    }

    public final boolean a() {
        String value;
        ConfigBean c11 = sm.f.f75530c.a().c("app_center_switch", true);
        if (c11 != null && (value = c11.getValue()) != null) {
            try {
                return new JSONObject(value).optBoolean("app_center_off");
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
