package k0;

import android.graphics.text.LineBreakConfig;
import android.text.StaticLayout;
import kotlin.jvm.JvmStatic;

/* loaded from: classes2.dex */
final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public static final y0 f66674a = new y0();

    private y0() {
    }

    @JvmStatic
    public static final boolean a(StaticLayout staticLayout) {
        boolean isFallbackLineSpacingEnabled;
        isFallbackLineSpacingEnabled = staticLayout.isFallbackLineSpacingEnabled();
        return isFallbackLineSpacingEnabled;
    }

    @JvmStatic
    public static final void b(StaticLayout.Builder builder, int i11, int i12) {
        LineBreakConfig.Builder lineBreakStyle;
        LineBreakConfig.Builder lineBreakWordStyle;
        LineBreakConfig build;
        lineBreakStyle = s0.a().setLineBreakStyle(i11);
        lineBreakWordStyle = lineBreakStyle.setLineBreakWordStyle(i12);
        build = lineBreakWordStyle.build();
        builder.setLineBreakConfig(build);
    }
}
