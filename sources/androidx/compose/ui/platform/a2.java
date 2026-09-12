package androidx.compose.ui.platform;

import android.view.RenderNode;

/* loaded from: classes.dex */
final class a2 {

    /* renamed from: a, reason: collision with root package name */
    public static final a2 f5805a = new a2();

    private a2() {
    }

    public final int a(RenderNode renderNode) {
        return renderNode.getAmbientShadowColor();
    }

    public final int b(RenderNode renderNode) {
        return renderNode.getSpotShadowColor();
    }

    public final void c(RenderNode renderNode, int i11) {
        renderNode.setAmbientShadowColor(i11);
    }

    public final void d(RenderNode renderNode, int i11) {
        renderNode.setSpotShadowColor(i11);
    }
}
