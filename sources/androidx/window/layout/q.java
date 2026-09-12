package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.layout.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f15432a = new q();

    private q() {
    }

    private final boolean c(Activity activity, androidx.window.core.b bVar) {
        Rect a11 = f0.f15420a.a(activity).a();
        if (bVar.e()) {
            return false;
        }
        if (bVar.d() != a11.width() && bVar.a() != a11.height()) {
            return false;
        }
        if (bVar.d() >= a11.width() || bVar.a() >= a11.height()) {
            return (bVar.d() == a11.width() && bVar.a() == a11.height()) ? false : true;
        }
        return false;
    }

    public final r a(Activity activity, FoldingFeature oemFeature) {
        HardwareFoldingFeature.Type a11;
        r.c cVar;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(oemFeature, "oemFeature");
        int type = oemFeature.getType();
        if (type == 1) {
            a11 = HardwareFoldingFeature.Type.INSTANCE.a();
        } else {
            if (type != 2) {
                return null;
            }
            a11 = HardwareFoldingFeature.Type.INSTANCE.b();
        }
        int state = oemFeature.getState();
        if (state == 1) {
            cVar = r.c.f15442c;
        } else {
            if (state != 2) {
                return null;
            }
            cVar = r.c.f15443d;
        }
        Rect bounds = oemFeature.getBounds();
        Intrinsics.g(bounds, "oemFeature.bounds");
        if (!c(activity, new androidx.window.core.b(bounds))) {
            return null;
        }
        Rect bounds2 = oemFeature.getBounds();
        Intrinsics.g(bounds2, "oemFeature.bounds");
        return new HardwareFoldingFeature(new androidx.window.core.b(bounds2), a11, cVar);
    }

    public final a0 b(Activity activity, WindowLayoutInfo info) {
        r rVar;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(info, "info");
        List<FoldingFeature> displayFeatures = info.getDisplayFeatures();
        Intrinsics.g(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature feature : displayFeatures) {
            if (feature instanceof FoldingFeature) {
                q qVar = f15432a;
                Intrinsics.g(feature, "feature");
                rVar = qVar.a(activity, feature);
            } else {
                rVar = null;
            }
            if (rVar != null) {
                arrayList.add(rVar);
            }
        }
        return new a0(arrayList);
    }
}
