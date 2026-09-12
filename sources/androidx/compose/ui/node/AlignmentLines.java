package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLineKt;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class AlignmentLines {

    /* renamed from: a, reason: collision with root package name */
    private final a f5282a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5283b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5284c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5285d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5286e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5287f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5288g;

    /* renamed from: h, reason: collision with root package name */
    private a f5289h;

    /* renamed from: i, reason: collision with root package name */
    private final Map f5290i;

    private AlignmentLines(a aVar) {
        this.f5282a = aVar;
        this.f5283b = true;
        this.f5290i = new HashMap();
    }

    public /* synthetic */ AlignmentLines(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(androidx.compose.ui.layout.a aVar, int i11, NodeCoordinator nodeCoordinator) {
        float f11 = i11;
        long a11 = y.h.a(f11, f11);
        while (true) {
            a11 = d(nodeCoordinator, a11);
            nodeCoordinator = nodeCoordinator.a2();
            Intrinsics.e(nodeCoordinator);
            if (Intrinsics.c(nodeCoordinator, this.f5282a.M())) {
                break;
            } else if (e(nodeCoordinator).containsKey(aVar)) {
                float i12 = i(nodeCoordinator, aVar);
                a11 = y.h.a(i12, i12);
            }
        }
        int round = Math.round(aVar instanceof androidx.compose.ui.layout.h ? y.g.n(a11) : y.g.m(a11));
        Map map = this.f5290i;
        if (map.containsKey(aVar)) {
            round = AlignmentLineKt.c(aVar, ((Number) MapsKt.i(this.f5290i, aVar)).intValue(), round);
        }
        map.put(aVar, Integer.valueOf(round));
    }

    protected abstract long d(NodeCoordinator nodeCoordinator, long j11);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Map e(NodeCoordinator nodeCoordinator);

    public final a f() {
        return this.f5282a;
    }

    public final boolean g() {
        return this.f5283b;
    }

    public final Map h() {
        return this.f5290i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int i(NodeCoordinator nodeCoordinator, androidx.compose.ui.layout.a aVar);

    public final boolean j() {
        return this.f5284c || this.f5286e || this.f5287f || this.f5288g;
    }

    public final boolean k() {
        o();
        return this.f5289h != null;
    }

    public final boolean l() {
        return this.f5285d;
    }

    public final void m() {
        this.f5283b = true;
        a D = this.f5282a.D();
        if (D == null) {
            return;
        }
        if (this.f5284c) {
            D.Z();
        } else if (this.f5286e || this.f5285d) {
            D.requestLayout();
        }
        if (this.f5287f) {
            this.f5282a.Z();
        }
        if (this.f5288g) {
            this.f5282a.requestLayout();
        }
        D.v().m();
    }

    public final void n() {
        this.f5290i.clear();
        this.f5282a.U(new Function1<a, Unit>() { // from class: androidx.compose.ui.node.AlignmentLines$recalculate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((a) obj);
                return Unit.f67184a;
            }

            public final void invoke(a aVar) {
                Map map;
                if (aVar.n()) {
                    if (aVar.v().g()) {
                        aVar.I();
                    }
                    map = aVar.v().f5290i;
                    AlignmentLines alignmentLines = AlignmentLines.this;
                    for (Map.Entry entry : map.entrySet()) {
                        alignmentLines.c((androidx.compose.ui.layout.a) entry.getKey(), ((Number) entry.getValue()).intValue(), aVar.M());
                    }
                    NodeCoordinator a22 = aVar.M().a2();
                    Intrinsics.e(a22);
                    while (!Intrinsics.c(a22, AlignmentLines.this.f().M())) {
                        Set<androidx.compose.ui.layout.a> keySet = AlignmentLines.this.e(a22).keySet();
                        AlignmentLines alignmentLines2 = AlignmentLines.this;
                        for (androidx.compose.ui.layout.a aVar2 : keySet) {
                            alignmentLines2.c(aVar2, alignmentLines2.i(a22, aVar2), a22);
                        }
                        a22 = a22.a2();
                        Intrinsics.e(a22);
                    }
                }
            }
        });
        this.f5290i.putAll(e(this.f5282a.M()));
        this.f5283b = false;
    }

    public final void o() {
        a aVar;
        AlignmentLines v11;
        AlignmentLines v12;
        if (j()) {
            aVar = this.f5282a;
        } else {
            a D = this.f5282a.D();
            if (D == null) {
                return;
            }
            aVar = D.v().f5289h;
            if (aVar == null || !aVar.v().j()) {
                a aVar2 = this.f5289h;
                if (aVar2 == null || aVar2.v().j()) {
                    return;
                }
                a D2 = aVar2.D();
                if (D2 != null && (v12 = D2.v()) != null) {
                    v12.o();
                }
                a D3 = aVar2.D();
                aVar = (D3 == null || (v11 = D3.v()) == null) ? null : v11.f5289h;
            }
        }
        this.f5289h = aVar;
    }

    public final void p() {
        this.f5283b = true;
        this.f5284c = false;
        this.f5286e = false;
        this.f5285d = false;
        this.f5287f = false;
        this.f5288g = false;
        this.f5289h = null;
    }

    public final void q(boolean z10) {
        this.f5286e = z10;
    }

    public final void r(boolean z10) {
        this.f5288g = z10;
    }

    public final void s(boolean z10) {
        this.f5287f = z10;
    }

    public final void t(boolean z10) {
        this.f5285d = z10;
    }

    public final void u(boolean z10) {
        this.f5284c = z10;
    }
}
