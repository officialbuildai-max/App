package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DependencyNode implements u0.a {

    /* renamed from: d, reason: collision with root package name */
    WidgetRun f6989d;

    /* renamed from: f, reason: collision with root package name */
    int f6991f;

    /* renamed from: g, reason: collision with root package name */
    public int f6992g;

    /* renamed from: a, reason: collision with root package name */
    public u0.a f6986a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6987b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6988c = false;

    /* renamed from: e, reason: collision with root package name */
    Type f6990e = Type.UNKNOWN;

    /* renamed from: h, reason: collision with root package name */
    int f6993h = 1;

    /* renamed from: i, reason: collision with root package name */
    e f6994i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6995j = false;

    /* renamed from: k, reason: collision with root package name */
    List f6996k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    List f6997l = new ArrayList();

    /* loaded from: classes.dex */
    enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f6989d = widgetRun;
    }

    @Override // u0.a
    public void a(u0.a aVar) {
        Iterator it = this.f6997l.iterator();
        while (it.hasNext()) {
            if (!((DependencyNode) it.next()).f6995j) {
                return;
            }
        }
        this.f6988c = true;
        u0.a aVar2 = this.f6986a;
        if (aVar2 != null) {
            aVar2.a(this);
        }
        if (this.f6987b) {
            this.f6989d.a(this);
            return;
        }
        DependencyNode dependencyNode = null;
        int i11 = 0;
        for (DependencyNode dependencyNode2 : this.f6997l) {
            if (!(dependencyNode2 instanceof e)) {
                i11++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i11 == 1 && dependencyNode.f6995j) {
            e eVar = this.f6994i;
            if (eVar != null) {
                if (!eVar.f6995j) {
                    return;
                } else {
                    this.f6991f = this.f6993h * eVar.f6992g;
                }
            }
            d(dependencyNode.f6992g + this.f6991f);
        }
        u0.a aVar3 = this.f6986a;
        if (aVar3 != null) {
            aVar3.a(this);
        }
    }

    public void b(u0.a aVar) {
        this.f6996k.add(aVar);
        if (this.f6995j) {
            aVar.a(aVar);
        }
    }

    public void c() {
        this.f6997l.clear();
        this.f6996k.clear();
        this.f6995j = false;
        this.f6992g = 0;
        this.f6988c = false;
        this.f6987b = false;
    }

    public void d(int i11) {
        if (this.f6995j) {
            return;
        }
        this.f6995j = true;
        this.f6992g = i11;
        for (u0.a aVar : this.f6996k) {
            aVar.a(aVar);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f6989d.f6999b.v());
        sb2.append(":");
        sb2.append(this.f6990e);
        sb2.append("(");
        sb2.append(this.f6995j ? Integer.valueOf(this.f6992g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f6997l.size());
        sb2.append(":d=");
        sb2.append(this.f6996k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
