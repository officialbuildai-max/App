package androidx.compose.ui.platform;

import android.view.RenderNode;

/* loaded from: classes.dex */
final class y1 {

    /* renamed from: a, reason: collision with root package name */
    public static final y1 f5958a = new y1();

    private y1() {
    }

    public final void a(RenderNode renderNode) {
        renderNode.destroyDisplayListData();
    }
}
