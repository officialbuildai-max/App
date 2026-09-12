package androidx.compose.ui.platform.accessibility;

import android.support.v4.media.session.c;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.b;
import androidx.compose.ui.semantics.i;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import y.g;
import y.h;

/* loaded from: classes.dex */
public abstract class CollectionInfo_androidKt {
    private static final boolean a(List list) {
        List l11;
        long v11;
        if (list.size() < 2) {
            return true;
        }
        if (list.size() == 0 || list.size() == 1) {
            l11 = CollectionsKt.l();
        } else {
            l11 = new ArrayList();
            Object obj = list.get(0);
            int n11 = CollectionsKt.n(list);
            int i11 = 0;
            while (i11 < n11) {
                i11++;
                Object obj2 = list.get(i11);
                SemanticsNode semanticsNode = (SemanticsNode) obj2;
                SemanticsNode semanticsNode2 = (SemanticsNode) obj;
                l11.add(g.d(h.a(Math.abs(g.m(semanticsNode2.i().d()) - g.m(semanticsNode.i().d())), Math.abs(g.n(semanticsNode2.i().d()) - g.n(semanticsNode.i().d())))));
                obj = obj2;
            }
        }
        if (l11.size() == 1) {
            v11 = ((g) CollectionsKt.i0(l11)).v();
        } else {
            if (l11.isEmpty()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object i02 = CollectionsKt.i0(l11);
            int n12 = CollectionsKt.n(l11);
            if (1 <= n12) {
                int i12 = 1;
                while (true) {
                    i02 = g.d(g.r(((g) i02).v(), ((g) l11.get(i12)).v()));
                    if (i12 == n12) {
                        break;
                    }
                    i12++;
                }
            }
            v11 = ((g) i02).v();
        }
        return g.n(v11) < g.m(v11);
    }

    public static final boolean b(SemanticsNode semanticsNode) {
        i n11 = semanticsNode.n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        return (SemanticsConfigurationKt.a(n11, semanticsProperties.a()) == null && SemanticsConfigurationKt.a(semanticsNode.n(), semanticsProperties.y()) == null) ? false : true;
    }

    private static final boolean c(b bVar) {
        return bVar.b() < 0 || bVar.a() < 0;
    }

    public static final void d(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        i n11 = semanticsNode.n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        b bVar = (b) SemanticsConfigurationKt.a(n11, semanticsProperties.a());
        if (bVar != null) {
            accessibilityNodeInfoCompat.setCollectionInfo(f(bVar));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (SemanticsConfigurationKt.a(semanticsNode.n(), semanticsProperties.y()) != null) {
            List t11 = semanticsNode.t();
            int size = t11.size();
            for (int i11 = 0; i11 < size; i11++) {
                SemanticsNode semanticsNode2 = (SemanticsNode) t11.get(i11);
                if (semanticsNode2.n().e(SemanticsProperties.f5994a.z())) {
                    arrayList.add(semanticsNode2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        boolean a11 = a(arrayList);
        accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(a11 ? 1 : arrayList.size(), a11 ? arrayList.size() : 1, false, 0));
    }

    public static final void e(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        i n11 = semanticsNode.n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        c.a(SemanticsConfigurationKt.a(n11, semanticsProperties.b()));
        SemanticsNode r11 = semanticsNode.r();
        if (r11 == null || SemanticsConfigurationKt.a(r11.n(), semanticsProperties.y()) == null) {
            return;
        }
        b bVar = (b) SemanticsConfigurationKt.a(r11.n(), semanticsProperties.a());
        if ((bVar == null || !c(bVar)) && semanticsNode.n().e(semanticsProperties.z())) {
            ArrayList arrayList = new ArrayList();
            List t11 = r11.t();
            int size = t11.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                SemanticsNode semanticsNode2 = (SemanticsNode) t11.get(i12);
                if (semanticsNode2.n().e(SemanticsProperties.f5994a.z())) {
                    arrayList.add(semanticsNode2);
                    if (semanticsNode2.q().i0() < semanticsNode.q().i0()) {
                        i11++;
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            boolean a11 = a(arrayList);
            AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain = AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(a11 ? 0 : i11, 1, a11 ? i11 : 0, 1, false, ((Boolean) semanticsNode.n().l(SemanticsProperties.f5994a.z(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt$setCollectionItemInfo$itemInfo$1
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            })).booleanValue());
            if (obtain != null) {
                accessibilityNodeInfoCompat.setCollectionItemInfo(obtain);
            }
        }
    }

    private static final AccessibilityNodeInfoCompat.CollectionInfoCompat f(b bVar) {
        return AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(bVar.b(), bVar.a(), false, 0);
    }
}
