package ie;

import android.app.UiModeManager;
import android.content.Context;
import com.iab.omid.library.hisavana.adsession.DeviceCategory;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static UiModeManager f65328a;

    public static DeviceCategory a() {
        UiModeManager uiModeManager = f65328a;
        if (uiModeManager == null) {
            return DeviceCategory.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        return currentModeType != 1 ? currentModeType != 4 ? DeviceCategory.OTHER : DeviceCategory.CTV : DeviceCategory.MOBILE;
    }

    public static void b(Context context) {
        if (context != null) {
            f65328a = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
