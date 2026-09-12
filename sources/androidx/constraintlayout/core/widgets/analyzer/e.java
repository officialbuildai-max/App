package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends DependencyNode {

    /* renamed from: m, reason: collision with root package name */
    public int f7036m;

    public e(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof j) {
            this.f6990e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.f6990e = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
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
}
