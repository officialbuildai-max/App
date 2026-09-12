package ht;

import android.net.Uri;
import com.therouter.TheRouter;
import com.transsion.web.api.WebPageIdentity;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes7.dex */
public abstract class b {
    public static final int a(List list, Object obj) {
        Intrinsics.h(list, "<this>");
        Iterator it = list.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            int i12 = i11 + 1;
            if (it.next() == obj) {
                return i11;
            }
            i11 = i12;
        }
        return -1;
    }

    public static final boolean b(Uri uri) {
        Intrinsics.h(uri, "<this>");
        return Intrinsics.c(uri.getScheme(), "https") || Intrinsics.c(uri.getScheme(), "http");
    }

    public static final void c(String str, String extraParam) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(extraParam, "extraParam");
        Uri parse = Uri.parse(str + extraParam);
        Intrinsics.e(parse);
        if (b(parse)) {
            ds.c.k(TheRouter.c(WebPageIdentity.WEB_VIEW).K("url", str));
            return;
        }
        try {
            Uri a11 = dt.a.f61555a.a(parse);
            if (a11 != null) {
                ds.c.j(a11);
            }
        } catch (Throwable th2) {
            a.C0856a.l(lg.a.f68962a, "Deeplink", "openDeeplink:" + th2, false, 4, null);
            th2.printStackTrace();
        }
    }

    public static /* synthetic */ void d(String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = "";
        }
        c(str, str2);
    }
}
