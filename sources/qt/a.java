package qt;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.shorttv_pugc.bean.Subject;
import com.transsion.shorttv_pugc.ui.dialog.ShortTvDownloadResDialog;
import hj.i;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f73823a = new a();

    private a() {
    }

    public final void a(FragmentActivity activity, String str, String str2, String str3, boolean z10, Subject subject, String str4, Boolean bool) {
        String str5 = str2;
        Intrinsics.h(activity, "activity");
        if (!z10 && Intrinsics.c(bool, Boolean.FALSE)) {
            Navigator.x(TheRouter.c(ls.a.f69157a.b()).z("download", true).K("id", str4 == null ? subject != null ? subject.getSubjectId() : null : str4).K("ops", str2), activity, null, 2, null);
            return;
        }
        if (str5 == null || str2.length() == 0) {
            Bundle extras = activity.getIntent().getExtras();
            str5 = extras != null ? extras.getString("ops") : null;
        }
        String str6 = str5;
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        ShortTvDownloadResDialog.INSTANCE.a(str, i.f64628a.i(), subject, str6, str3, z10).show(supportFragmentManager, "download");
    }
}
