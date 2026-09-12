package androidx.compose.ui.platform;

import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.f;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public abstract class e2 {

    /* renamed from: a, reason: collision with root package name */
    private static final y.i f5854a = new y.i(0.0f, 0.0f, 10.0f, 10.0f);

    public static final b2 a(List list, int i11) {
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (((b2) list.get(i12)).d() == i11) {
                return (b2) list.get(i12);
            }
        }
        return null;
    }

    public static final androidx.collection.o b(androidx.compose.ui.semantics.m mVar) {
        SemanticsNode a11 = mVar.a();
        androidx.collection.e0 b11 = androidx.collection.p.b();
        if (a11.q().n() && a11.q().D0()) {
            y.i i11 = a11.i();
            c(new Region(Math.round(i11.f()), Math.round(i11.i()), Math.round(i11.g()), Math.round(i11.c())), a11, b11, a11, new Region());
        }
        return b11;
    }

    private static final void c(Region region, SemanticsNode semanticsNode, androidx.collection.e0 e0Var, SemanticsNode semanticsNode2, Region region2) {
        androidx.compose.ui.layout.n p11;
        boolean z10 = (semanticsNode2.q().n() && semanticsNode2.q().D0()) ? false : true;
        if (!region.isEmpty() || semanticsNode2.o() == semanticsNode.o()) {
            if (!z10 || semanticsNode2.x()) {
                y.i v11 = semanticsNode2.v();
                int round = Math.round(v11.f());
                int round2 = Math.round(v11.i());
                int round3 = Math.round(v11.g());
                int round4 = Math.round(v11.c());
                region2.set(round, round2, round3, round4);
                int o11 = semanticsNode2.o() == semanticsNode.o() ? -1 : semanticsNode2.o();
                if (!region2.op(region, Region.Op.INTERSECT)) {
                    if (semanticsNode2.x()) {
                        SemanticsNode r11 = semanticsNode2.r();
                        y.i i11 = (r11 == null || (p11 = r11.p()) == null || !p11.n()) ? f5854a : r11.i();
                        e0Var.t(o11, new d2(semanticsNode2, new Rect(Math.round(i11.f()), Math.round(i11.i()), Math.round(i11.g()), Math.round(i11.c()))));
                        return;
                    } else {
                        if (o11 == -1) {
                            e0Var.t(o11, new d2(semanticsNode2, region2.getBounds()));
                            return;
                        }
                        return;
                    }
                }
                e0Var.t(o11, new d2(semanticsNode2, region2.getBounds()));
                List t11 = semanticsNode2.t();
                for (int size = t11.size() - 1; -1 < size; size--) {
                    c(region, semanticsNode, e0Var, (SemanticsNode) t11.get(size), region2);
                }
                if (f(semanticsNode2)) {
                    region.op(round, round2, round3, round4, Region.Op.DIFFERENCE);
                }
            }
        }
    }

    public static final Float d(androidx.compose.ui.semantics.i iVar) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        androidx.compose.ui.semantics.a aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(iVar, androidx.compose.ui.semantics.h.f6051a.h());
        if (aVar == null || (function1 = (Function1) aVar.a()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (Float) arrayList.get(0);
    }

    public static final androidx.compose.ui.text.z e(androidx.compose.ui.semantics.i iVar) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        androidx.compose.ui.semantics.a aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(iVar, androidx.compose.ui.semantics.h.f6051a.i());
        if (aVar == null || (function1 = (Function1) aVar.a()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (androidx.compose.ui.text.z) arrayList.get(0);
    }

    public static final boolean f(SemanticsNode semanticsNode) {
        return semanticsNode.w().o() || semanticsNode.w().f();
    }

    public static final View g(AndroidViewsHandler androidViewsHandler, int i11) {
        Object obj;
        Iterator<T> it = androidViewsHandler.getLayoutNodeToHolder().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((LayoutNode) ((Map.Entry) obj).getKey()).j0() == i11) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return (AndroidViewHolder) entry.getValue();
        }
        return null;
    }

    public static final String h(int i11) {
        f.a aVar = androidx.compose.ui.semantics.f.f6039b;
        if (androidx.compose.ui.semantics.f.k(i11, aVar.a())) {
            return "android.widget.Button";
        }
        if (androidx.compose.ui.semantics.f.k(i11, aVar.b())) {
            return "android.widget.CheckBox";
        }
        if (androidx.compose.ui.semantics.f.k(i11, aVar.e())) {
            return "android.widget.RadioButton";
        }
        if (androidx.compose.ui.semantics.f.k(i11, aVar.d())) {
            return "android.widget.ImageView";
        }
        if (androidx.compose.ui.semantics.f.k(i11, aVar.c())) {
            return "android.widget.Spinner";
        }
        return null;
    }
}
