package bf;

import android.content.Context;
import com.transsion.baseui.dialog.BaseDialog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f16548a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final List f16549b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static final Map f16550c = new LinkedHashMap();

    private c() {
    }

    public final void a() {
        f16549b.clear();
        f16550c.clear();
    }

    public final boolean b(BaseDialog dialog, String tag) {
        Intrinsics.h(dialog, "dialog");
        Intrinsics.h(tag, "tag");
        List list = f16549b;
        if (list.isEmpty()) {
            list.add(dialog);
            return true;
        }
        f16550c.put(tag, dialog);
        return false;
    }

    public final void c(Context context) {
        Intrinsics.h(context, "context");
        f16549b.clear();
        Map map = f16550c;
        if (map.isEmpty()) {
            return;
        }
        String str = (String) CollectionsKt.h0(map.keySet());
        BaseDialog baseDialog = (BaseDialog) map.remove(str);
        if (baseDialog == null || !f16548a.b(baseDialog, str)) {
            return;
        }
        baseDialog.k0(context, str);
    }
}
