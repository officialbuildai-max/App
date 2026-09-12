package bi;

import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.transsion.core.log.ObjectLogUtils;
import java.util.Locale;

/* loaded from: classes5.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static ObjectLogUtils f16629a = new ObjectLogUtils.a().p("NetworkMonitor").q(true).n(false).m();

    public static String a() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "persist.sys.oobe_country", TmcConstants.ROUTE_UNKNOWN);
        } catch (Exception e11) {
            f16629a.g(Log.getStackTraceString(e11));
            str = "";
        }
        return (TextUtils.isEmpty(str) || TmcConstants.ROUTE_UNKNOWN.equals(str)) ? b().getCountry() : str;
    }

    private static Locale b() {
        Locale locale;
        LocaleList localeList;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                localeList = LocaleList.getDefault();
                locale = localeList.get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale;
        } catch (Exception e11) {
            Locale locale2 = Locale.getDefault();
            f16629a.g(Log.getStackTraceString(e11));
            return locale2;
        }
    }
}
