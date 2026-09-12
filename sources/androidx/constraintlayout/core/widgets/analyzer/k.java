package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: h, reason: collision with root package name */
    public static int f7042h;

    /* renamed from: c, reason: collision with root package name */
    WidgetRun f7045c;

    /* renamed from: d, reason: collision with root package name */
    WidgetRun f7046d;

    /* renamed from: f, reason: collision with root package name */
    int f7048f;

    /* renamed from: g, reason: collision with root package name */
    int f7049g;

    /* renamed from: a, reason: collision with root package name */
    public int f7043a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7044b = false;

    /* renamed from: e, reason: collision with root package name */
    ArrayList f7047e = new ArrayList();

    public k(WidgetRun widgetRun, int i11) {
        this.f7045c = null;
        this.f7046d = null;
        int i12 = f7042h;
        this.f7048f = i12;
        f7042h = i12 + 1;
        this.f7045c = widgetRun;
        this.f7046d = widgetRun;
        this.f7049g = i11;
    }

    private long c(DependencyNode dependencyNode, long j11) {
        WidgetRun widgetRun = dependencyNode.f6989d;
        if (widgetRun instanceof i) {
            return j11;
        }
        int size = dependencyNode.f6996k.size();
        long j12 = j11;
        for (int i11 = 0; i11 < size; i11++) {
            u0.a aVar = (u0.a) dependencyNode.f6996k.get(i11);
            if (aVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) aVar;
                if (dependencyNode2.f6989d != widgetRun) {
                    j12 = Math.min(j12, c(dependencyNode2, dependencyNode2.f6991f + j11));
                }
            }
        }
        if (dependencyNode != widgetRun.f7006i) {
            return j12;
        }
        long j13 = j11 - widgetRun.j();
        return Math.min(Math.min(j12, c(widgetRun.f7005h, j13)), j13 - widgetRun.f7005h.f6991f);
    }

    private long d(DependencyNode dependencyNode, long j11) {
        WidgetRun widgetRun = dependencyNode.f6989d;
        if (widgetRun instanceof i) {
            return j11;
        }
        int size = dependencyNode.f6996k.size();
        long j12 = j11;
        for (int i11 = 0; i11 < size; i11++) {
            u0.a aVar = (u0.a) dependencyNode.f6996k.get(i11);
            if (aVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) aVar;
                if (dependencyNode2.f6989d != widgetRun) {
                    j12 = Math.max(j12, d(dependencyNode2, dependencyNode2.f6991f + j11));
                }
            }
        }
        if (dependencyNode != widgetRun.f7005h) {
            return j12;
        }
        long j13 = j11 + widgetRun.j();
        return Math.max(Math.max(j12, d(widgetRun.f7006i, j13)), j13 - widgetRun.f7006i.f6991f);
    }

    public void a(WidgetRun widgetRun) {
        this.f7047e.add(widgetRun);
        this.f7046d = widgetRun;
    }

    public long b(androidx.constraintlayout.core.widgets.d dVar, int i11) {
        long j11;
        int i12;
        WidgetRun widgetRun = this.f7045c;
        if (widgetRun instanceof c) {
            if (((c) widgetRun).f7003f != i11) {
                return 0L;
            }
        } else if (i11 == 0) {
            if (!(widgetRun instanceof j)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof l)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i11 == 0 ? dVar.f6939e : dVar.f6941f).f7005h;
        DependencyNode dependencyNode2 = (i11 == 0 ? dVar.f6939e : dVar.f6941f).f7006i;
        boolean contains = widgetRun.f7005h.f6997l.contains(dependencyNode);
        boolean contains2 = this.f7045c.f7006i.f6997l.contains(dependencyNode2);
        long j12 = this.f7045c.j();
        if (contains && contains2) {
            long d11 = d(this.f7045c.f7005h, 0L);
            long c11 = c(this.f7045c.f7006i, 0L);
            long j13 = d11 - j12;
            WidgetRun widgetRun2 = this.f7045c;
            int i13 = widgetRun2.f7006i.f6991f;
            if (j13 >= (-i13)) {
                j13 += i13;
            }
            int i14 = widgetRun2.f7005h.f6991f;
            long j14 = ((-c11) - j12) - i14;
            if (j14 >= i14) {
                j14 -= i14;
            }
            float f11 = (float) (widgetRun2.f6999b.s(i11) > 0.0f ? (((float) j14) / r12) + (((float) j13) / (1.0f - r12)) : 0L);
            long j15 = (f11 * r12) + 0.5f + j12 + (f11 * (1.0f - r12)) + 0.5f;
            j11 = r12.f7005h.f6991f + j15;
            i12 = this.f7045c.f7006i.f6991f;
        } else {
            if (contains) {
                return Math.max(d(this.f7045c.f7005h, r12.f6991f), this.f7045c.f7005h.f6991f + j12);
            }
            if (contains2) {
                return Math.max(-c(this.f7045c.f7006i, r12.f6991f), (-this.f7045c.f7006i.f6991f) + j12);
            }
            j11 = r12.f7005h.f6991f + this.f7045c.j();
            i12 = this.f7045c.f7006i.f6991f;
        }
        return j11 - i12;
    }
}
