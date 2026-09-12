package androidx.compose.ui.scrollcapture;

import androidx.compose.ui.layout.l;
import androidx.compose.ui.semantics.SemanticsNode;
import o0.r;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final SemanticsNode f5979a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5980b;

    /* renamed from: c, reason: collision with root package name */
    private final r f5981c;

    /* renamed from: d, reason: collision with root package name */
    private final l f5982d;

    public i(SemanticsNode semanticsNode, int i11, r rVar, l lVar) {
        this.f5979a = semanticsNode;
        this.f5980b = i11;
        this.f5981c = rVar;
        this.f5982d = lVar;
    }

    public final l a() {
        return this.f5982d;
    }

    public final int b() {
        return this.f5980b;
    }

    public final SemanticsNode c() {
        return this.f5979a;
    }

    public final r d() {
        return this.f5981c;
    }

    public String toString() {
        return "ScrollCaptureCandidate(node=" + this.f5979a + ", depth=" + this.f5980b + ", viewportBoundsInWindow=" + this.f5981c + ", coordinates=" + this.f5982d + ')';
    }
}
